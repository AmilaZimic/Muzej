package com.example.dana.muzej;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import com.example.dana.muzej.Helpers.Image;
import com.example.dana.muzej.Helpers.ImageAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import static com.example.dana.muzej.R.id.snap;

public class LeftSpace extends AppCompatActivity {

    private static LeftSpace instance = null;
    final ArrayList<Image> ads = new ArrayList<Image>();
    StaggeredGridLayoutManager mStaggeredLayoutManager;
    RecyclerView mRecyclerView;
    ImageAdapter mAdAdapter;

    public static LeftSpace getInstance() {
        if (instance == null) {
            instance = new LeftSpace();
        }
        return instance;
    }


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_left_space);

     FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference databaseReference = database.getReference();
        databaseReference.child("ImagesLeftSpace").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                Iterable<DataSnapshot> children = dataSnapshot.getChildren();
                for (DataSnapshot child : children) {
                    Image r = child.getValue(Image.class);
                    ads.add(r);

                    mAdAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        mAdAdapter = new ImageAdapter(ads);
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mStaggeredLayoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(mStaggeredLayoutManager);

        mRecyclerView.setAdapter(mAdAdapter);

    }


    }


