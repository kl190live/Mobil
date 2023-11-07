package com.example.logreg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText userEditText;
    private EditText passwordEditText;
    private Button loginButton;
    private Button registerButton;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (userEditText.getText().toString().isEmpty())
                {
                    Toast.makeText(MainActivity.this, "Add meg az email címet", Toast.LENGTH_SHORT).show();
                }
                else if(passwordEditText.getText().toString().isEmpty())
                {
                    Toast.makeText(MainActivity.this, "Adj meg a jelszót", Toast.LENGTH_SHORT).show();
                }
                else if(!userEditText.getText().toString().contains("@")&&!userEditText.getText().toString().contains("."))
                {
                    Toast.makeText(MainActivity.this, "Rosszul adtad meg az email címet", Toast.LENGTH_SHORT).show();
                }
                else {
                    Intent intent1=new Intent(MainActivity.this,LoggedInActivity.class);
                    startActivity(intent1);
                    finish();
                }
            }
        });

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,RegisterActivity.class);
                startActivity(intent);
                finish();
            }
        });





    }



    public void init(){
        userEditText=findViewById(R.id.userEditText);
        passwordEditText=findViewById(R.id.passwordEditText);
        loginButton=findViewById(R.id.loginButton);
        registerButton=findViewById(R.id.registerButton);
    }


}