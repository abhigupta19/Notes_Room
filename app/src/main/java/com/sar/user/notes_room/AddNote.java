package com.sar.user.notes_room;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedInputStream;

public class AddNote extends AppCompatActivity {

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);
        final Intent intent=new Intent();
        Button button=findViewById(R.id.button);
        final EditText editText =findViewById(R.id.editText);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editText.getText()==null)
                {
                    setResult(RESULT_CANCELED,intent);

                }
                else {
                    setResult(RESULT_OK,intent);
                    intent.putExtra("data",editText.getText().toString());
                    Log.i("hiiiii",editText.getText().toString());
                }
                finish();
            }
        });

    }
}
