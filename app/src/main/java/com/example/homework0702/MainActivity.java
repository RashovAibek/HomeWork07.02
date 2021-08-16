package com.example.homework0702;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private EditText editText1;
    private EditText editText2;

    private Button changeActivityButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        changeActivityButton = findViewById(R.id.bot);
        editText = findViewById(R.id.email);
        editText1 = findViewById(R.id.edt1);
        editText2 = findViewById(R.id.edt2);

        changeActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!(editText.getText().toString().isEmpty()) && !(editText1.getText().toString().isEmpty()) && !(editText2.getText().toString().isEmpty())){
                    Intent intent = new Intent(Intent.ACTION_SEND);
                    intent.setType("plain/text");
                    intent.putExtra(Intent.EXTRA_EMAIL,new String[] {
                            editText.getText().toString()
                    });
                    intent.putExtra(Intent.EXTRA_SUBJECT,editText1.getText().toString());
                    intent.putExtra(Intent.EXTRA_TEXT,editText2.getText().toString());
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this, "Заполните все поля", Toast.LENGTH_SHORT).show();
                }


            }
        });
    }

}