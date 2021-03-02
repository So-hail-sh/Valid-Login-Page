package com.example.validloginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText user,pass;
    Button btn;
    TextView ate;
    int attempt = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user = findViewById(R.id.user);
        pass = findViewById(R.id.pass);
        btn = findViewById(R.id.btn);
        ate = findViewById(R.id.ate);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String username = user.getText().toString();
                String password = pass.getText().toString();

                if (username.isEmpty()){
                    user.setError("Username can't be empty");
                    user.requestFocus();
                    return;
                }
                if (password.isEmpty()){

                    pass.setError("password can't be empty");
                    pass.requestFocus();
                    return;
                }
                if (username.equals("Admin")&& password.equals("123456")){
                    Intent i = new Intent(MainActivity.this,Activity2.class);
                    startActivity(i);
                }else {
                    Toast.makeText(MainActivity.this, "user and pass don't match", Toast.LENGTH_SHORT).show();
                    attempt--;
                    ate.setText(Integer.toString(attempt));
                    if (attempt == 0){
                        btn.setVisibility(View.INVISIBLE);
                    }
                }
            }
        });
    }
}