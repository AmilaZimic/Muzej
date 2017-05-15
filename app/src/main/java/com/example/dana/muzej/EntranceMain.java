package com.example.dana.muzej;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.dana.muzej.Helpers.Image;
import com.example.dana.muzej.Helpers.News;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Locale;
import java.util.Map;


public class EntranceMain extends AppCompatActivity {

    private Button buttonLeft;
    private Button buttonRight;
    private Button buttonUp;
    private Button buttonBottom;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entrance_main);
         buttonLeft=(Button)findViewById(R.id.buttonLeftSpace);
        /*get to database*/
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference databaseReference = database.getReference();
        //databaseReference.child("Galerije_nazivi/galerija1").setValue("Galelllll");
        //String m=databaseReference.child("Galerije_nazivi/galerija1").

        databaseReference.child("Galerije_nazivi").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                Map<String, String> map = (Map<String, String>) dataSnapshot.getValue();
                String galerija1_bih=map.get("gl1_bih");
                String galerija1_eng=map.get("gl1_eng");
                String galerija2_bih=map.get("gl2_bih");
                String galerija2_eng=map.get("gl2_eng");
                String galerija3_bih=map.get("gl3_bih");
                String galerija3_eng=map.get("gl3_eng");
                String galerija4_bih=map.get("gl4_bih");
                String galerija4_eng=map.get("gl4_eng");
                if(Locale.getDefault().getLanguage().equals("hr"))
                {
                    buttonLeft.setText(galerija1_bih);
                    buttonRight.setText(galerija2_bih);
                    buttonUp.setText(galerija3_bih);
                    buttonBottom.setText(galerija4_bih);
                }
                else {
                    buttonLeft.setText(galerija1_eng);
                    buttonRight.setText(galerija2_eng);
                    buttonUp.setText(galerija3_eng);
                    buttonBottom.setText(galerija4_eng);

                }
                /*String r = dataSnapshot.getValue().toString();

                buttonLeft.setText(r);*/

            }
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });



        buttonLeft.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intLeft=new Intent(EntranceMain.this,LeftSpace.class);
                startActivity(intLeft);
            }


        });

        buttonRight=(Button)findViewById(R.id.buttonRightSpace);

        buttonRight.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intLeft=new Intent(EntranceMain.this,RightSpace.class);
                startActivity(intLeft);
            }


        });


        buttonUp=(Button)findViewById(R.id.buttonUpSpace);

        buttonUp.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intLeft=new Intent(EntranceMain.this,UpSpace.class);
                startActivity(intLeft);
            }


        });

        buttonBottom=(Button)findViewById(R.id.buttonBottomSpace);

        buttonBottom.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intLeft=new Intent(EntranceMain.this,BottomSpace.class);
                startActivity(intLeft);
            }


        });


    }
}
