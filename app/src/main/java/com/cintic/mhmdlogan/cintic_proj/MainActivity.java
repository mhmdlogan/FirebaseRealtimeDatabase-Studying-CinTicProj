package com.cintic.mhmdlogan.cintic_proj;

import android.graphics.Color;
import android.app.Dialog;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.firebase.client.collection.LLRBNode;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button A1;
    private Button A2;
    private Button A3;
    private Button A4;
    private Button A5;
    private Button B1;
    private Button B2;
    private Button B3;
    private Button B4;
    private Button B5;
    String val , val2, val3,val4,val5,val11,val22,val33,val44,val55 ;
    private Firebase mRef,mRef1,mRef2,mRef3,mRef4,mRef5,mRef11,mRef22,mRef33,mRef44,mRef55;

    private EditText name;
    private EditText comment;
    private Button com;
    private ListView listView;

    private Firebase mRootRef;
    private ArrayList<String> usernames = new ArrayList<>();
    private ArrayList<String> comments= new ArrayList<>();

    DatabaseReference db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Firebase.setAndroidContext(this);

        A1 =(Button)(findViewById(R.id.A1));
        A2 =(Button)(findViewById(R.id.A2));
        A3 =(Button)(findViewById(R.id.A3));
        A4 =(Button)(findViewById(R.id.A4));
        A5 =(Button)(findViewById(R.id.A5));
        B1 =(Button)(findViewById(R.id.B1));
        B2 =(Button)(findViewById(R.id.B2));
        B3 =(Button)(findViewById(R.id.B3));
        B4 =(Button)(findViewById(R.id.B4));
        B5 =(Button)(findViewById(R.id.B5));

        mRootRef = new Firebase("https://cintic-proj.firebaseio.com/Comments");

        name = (EditText)findViewById(R.id.txtName);
        comment =(EditText)findViewById(R.id.txtComment);
        com = (Button)findViewById(R.id.btnComment);
        listView = (ListView)findViewById(R.id.lv);

        com.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String user = name.getText().toString();
                String value = comment.getText().toString();
                Firebase childRef = mRootRef.child(user);
                childRef.setValue(value);
                comment.setText("");
                name.setText("");
            }
        });

         final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,usernames);

        listView.setAdapter(arrayAdapter);
        mRootRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                String valu = dataSnapshot.getValue(String.class);
                String valu2 = dataSnapshot.getKey();
                usernames.add(valu2 + ": "+ valu);
                //comments.add(valu2);
                arrayAdapter.notifyDataSetChanged();
                Toast.makeText(MainActivity.this, "Comment done", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                String valu = dataSnapshot.getValue(String.class);
                String valu2 = dataSnapshot.getKey();
                usernames.add(valu2 + ": "+ valu);
                //comments.add(valu2);
                arrayAdapter.notifyDataSetChanged();
                Toast.makeText(MainActivity.this, "Comment done", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

        mRef = new Firebase("https://cintic-proj.firebaseio.com/");

        mRef1 = new Firebase("https://cintic-proj.firebaseio.com/A1");
        mRef2 = new Firebase("https://cintic-proj.firebaseio.com/A2");
        mRef3 = new Firebase("https://cintic-proj.firebaseio.com/A3");
        mRef4 = new Firebase("https://cintic-proj.firebaseio.com/A4");
        mRef5 = new Firebase("https://cintic-proj.firebaseio.com/A5");
        mRef11 = new Firebase("https://cintic-proj.firebaseio.com/B1");
        mRef22 = new Firebase("https://cintic-proj.firebaseio.com/B2");
        mRef33 = new Firebase("https://cintic-proj.firebaseio.com/B3");
        mRef44 = new Firebase("https://cintic-proj.firebaseio.com/B4");
        mRef55 = new Firebase("https://cintic-proj.firebaseio.com/B5");

        db = FirebaseDatabase.getInstance().getReference();

        mRef1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                val = dataSnapshot.getValue(String.class);
                //A1.setText(val);

                if (val.equals("B"))
                {
                    A1.setBackgroundColor(Color.GRAY);
                }
                else {
                    A1.setBackgroundColor(Color.BLUE);
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

        mRef2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                val2 = dataSnapshot.getValue(String.class);
                //A1.setText(val);

                if (val2.equals("B"))
                {
                    A2.setBackgroundColor(Color.GRAY);
                }
                else {
                    A2.setBackgroundColor(Color.BLUE);
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

        mRef3.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                val3 = dataSnapshot.getValue(String.class);
                //A1.setText(val);

                if (val3.equals("B"))
                {
                    A3.setBackgroundColor(Color.GRAY);
                }
                else {
                    A3.setBackgroundColor(Color.BLUE);
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

        mRef4.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                val4 = dataSnapshot.getValue(String.class);
                //A1.setText(val);

                if (val4.equals("B"))
                {
                    A4.setBackgroundColor(Color.GRAY);
                }
                else {
                    A4.setBackgroundColor(Color.BLUE);
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

        mRef5.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                val5 = dataSnapshot.getValue(String.class);
                //A1.setText(val);

                if (val5.equals("B"))
                {
                    A5.setBackgroundColor(Color.GRAY);
                }
                else {
                    A5.setBackgroundColor(Color.BLUE);
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

        mRef11.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                val11 = dataSnapshot.getValue(String.class);
                //A1.setText(val);

                if (val11.equals("B"))
                {
                    B1.setBackgroundColor(Color.GRAY);
                }
                else {
                    B1.setBackgroundColor(Color.BLUE);
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

        mRef22.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                val22 = dataSnapshot.getValue(String.class);
                //A1.setText(val);

                if (val22.equals("B"))
                {
                    B2.setBackgroundColor(Color.GRAY);
                }
                else {
                    B2.setBackgroundColor(Color.BLUE);
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

        mRef33.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                val33 = dataSnapshot.getValue(String.class);
                //A1.setText(val);

                if (val33.equals("B"))
                {
                    B3.setBackgroundColor(Color.GRAY);
                }
                else {
                    B3.setBackgroundColor(Color.BLUE);
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

        mRef44.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                val44 = dataSnapshot.getValue(String.class);
                //A1.setText(val);

                if (val44.equals("B"))
                {
                    B4.setBackgroundColor(Color.GRAY);
                }
                else {
                    B4.setBackgroundColor(Color.BLUE);
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

        mRef55.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                val55 = dataSnapshot.getValue(String.class);
                //A1.setText(val);

                if (val55.equals("B"))
                {
                    B5.setBackgroundColor(Color.GRAY);
                }
                else {
                    B5.setBackgroundColor(Color.BLUE);
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });


        A1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Firebase child = mRef.child("A1");

                if (val.equals("B"))
                {
                    child.setValue("N");
                }
                else
                {
                    child.setValue("B");
                }

            }
        });

        A2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Firebase child = mRef.child("A2");

                if (val2.equals("B"))
                {
                    child.setValue("N");
                }
                else
                {
                    child.setValue("B");
                }

            }
        });

        A3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Firebase child = mRef.child("A3");

                if (val3.equals("B"))
                {
                    child.setValue("N");
                }
                else
                {
                    child.setValue("B");
                }

            }
        });

        A4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Firebase child = mRef.child("A4");

                if (val4.equals("B"))
                {
                    child.setValue("N");
                }
                else
                {
                    child.setValue("B");
                }

            }
        });

        A5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Firebase child = mRef.child("A5");

                if (val5.equals("B"))
                {
                    child.setValue("N");
                }
                else
                {
                    child.setValue("B");
                }

            }
        });

        B1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Firebase child = mRef.child("B1");

                if (val11.equals("B"))
                {
                    child.setValue("N");
                }
                else
                {
                    child.setValue("B");
                }

            }
        });
        B2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Firebase child = mRef.child("B2");

                if (val22.equals("B"))
                {
                    child.setValue("N");
                }
                else
                {
                    child.setValue("B");
                }

            }
        });
        B3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Firebase child = mRef.child("B3");

                if (val33.equals("B"))
                {
                    child.setValue("N");
                }
                else
                {
                    child.setValue("B");
                }

            }
        });
        B4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Firebase child = mRef.child("B4");

                if (val44.equals("B"))
                {
                    child.setValue("N");
                }
                else
                {
                    child.setValue("B");
                }

            }
        });
        B5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Firebase child = mRef.child("B5");

                if (val55.equals("B"))
                {
                    child.setValue("N");
                }
                else
                {
                    child.setValue("B");
                }

            }
        });
    }

}
