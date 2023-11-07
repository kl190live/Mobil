package com.example.logreg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    private EditText userEmailEditText;
    private EditText usernameEditText;
    private EditText UserpasEditText;
    private EditText realnameEditText;
    private Button finishButton;
    private Button backButton;
    private felhasznalo felhasznalo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        init();

        finishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (userEmailEditText.getText().toString().isEmpty())
                {
                    Toast.makeText(RegisterActivity.this, "Add meg az email címet", Toast.LENGTH_SHORT).show();
                }
                else if (!userEmailEditText.getText().toString().contains("@")&&!userEmailEditText.getText().toString().contains("."))
                {
                    Toast.makeText(RegisterActivity.this, "Rosszul adtad meg a email cimet", Toast.LENGTH_SHORT).show();
                }
                else if(usernameEditText.getText().toString().isEmpty())
                {
                    Toast.makeText(RegisterActivity.this, "Adj meg egy felhasználónevet", Toast.LENGTH_SHORT).show();
                }
                else if(UserpasEditText.getText().toString().isEmpty())
                {
                    Toast.makeText(RegisterActivity.this, "Adj meg egy jelszót", Toast.LENGTH_SHORT).show();
                }
                else if (realnameEditText.getText().toString().isEmpty())
                {
                    Toast.makeText(RegisterActivity.this, "Add meg a nevedet", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Intent intent3=new Intent(RegisterActivity.this,MainActivity.class);
                    startActivity(intent3);
                    finish();
                }
            }
        });



        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent4=new Intent(RegisterActivity.this,MainActivity.class);
                startActivity(intent4);
                finish();
            }
        });




    }


    public void init()
    {
        userEmailEditText=findViewById(R.id.userEmailEditText);
        usernameEditText=findViewById(R.id.usernameEditText);
        UserpasEditText=findViewById(R.id.UserpasEditText);
        realnameEditText=findViewById(R.id.realnameEditText);
        finishButton=findViewById(R.id.finishButton);
        backButton=findViewById(R.id.backButton);
    }


}