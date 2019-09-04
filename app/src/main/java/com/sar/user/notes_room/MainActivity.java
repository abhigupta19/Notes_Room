package com.sar.user.notes_room;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.List;
import java.util.UUID;

public class MainActivity extends AppCompatActivity {
    ViewModel viewModel;
    List<Table> tables;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FloatingActionButton floatingActionButton=findViewById(R.id.floatingActionButton);
        RecyclerView recyclerView=findViewById(R.id.rec);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        RecyclerAdapter recyclerAdapter=new RecyclerAdapter(this,tables);
        recyclerView.setAdapter(recyclerAdapter);

        viewModel=ViewModelProviders.of(this).get(ViewModel.class);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,AddNote.class);
                startActivityForResult(intent,1);

            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1&&resultCode==RESULT_OK)
        {
            String id=UUID.randomUUID().toString();
            Table table=new Table();
            table.setId(id);
            table.setNotes(data.getStringExtra("data"));

            Log.i("hiii",id);
            Log.i("hiiii",data.getStringExtra("data"));
            viewModel.insert(table);
            Toast.makeText(MainActivity.this,"data save",Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(MainActivity.this,"data not save",Toast.LENGTH_SHORT).show();
        }
    }
}
