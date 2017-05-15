package com.example.dana.muzej.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dana.muzej.Helpers.Image;
import com.example.dana.muzej.Helpers.ImageAdapter;
import com.example.dana.muzej.Helpers.News;
import com.example.dana.muzej.Helpers.NewsAdapter;
import com.example.dana.muzej.LeftSpace;
import com.example.dana.muzej.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class Whatsnew extends Fragment {
    private static Whatsnew instance = null;
    final ArrayList<News> ads = new ArrayList<News>();
    NewsAdapter mAdAdapter;
    StaggeredGridLayoutManager mStaggeredLayoutManager;
    RecyclerView mRecyclerView;



    public Whatsnew() {
        // Required empty public constructor
    }

    public static Whatsnew getInstance() {
        if (instance == null) {
            instance = new Whatsnew();
        }
        return instance;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView=inflater.inflate(R.layout.fragment_whatsnew, container, false);
       //initializePlaces();


        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference databaseReference = database.getReference();
        databaseReference.child("WhatsNew").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                Iterable<DataSnapshot> children = dataSnapshot.getChildren();
                for (DataSnapshot child : children) {
                    News r = child.getValue(News.class);
                    ads.add(r);

                    mAdAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });



        mAdAdapter = new NewsAdapter(ads);
        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_view);
        mStaggeredLayoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(mStaggeredLayoutManager);

        mRecyclerView.setAdapter(mAdAdapter);

        return rootView;
    }




    public void initializePlaces() {

        ArrayList<News> places = new ArrayList<>();
        // Creating ads in database should be considered
        places.add(new News(
                "https://firebasestorage.googleapis.com/v0/b/historijskimuzejbih-985c5.appspot.com/o/historijski_muzej_sarajevo_08.jpg?alt=media&token=0af1f481-6676-47c7-8b03-f8273fe3fdf0",
                "Historijski muzej BIH",
                "Historical Museum of BIH",
                "Neki opis",
                "Some description"));


        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference databaseReference = database.getReference();
        for (int i = 0; i < places.size(); i++) {
            databaseReference.child("WhatsNew").push().setValue(places.get(i));
        }


    }
}




