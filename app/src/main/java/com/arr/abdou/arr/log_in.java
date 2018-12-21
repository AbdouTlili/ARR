package com.arr.abdou.arr;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class log_in extends AppCompatActivity {

    EditText userMail = (EditText) findViewById(R.id.userMail);
    EditText userPasswd = (EditText) findViewById(R.id.userPasswd);
    Button loginBut = (Button) findViewById(R.id.loginBut);
    //TextView

    private FirebaseAuth fireLog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);


        loginBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginUserFireBase();
            }
        });
    }

    void loginUserFireBase(String mail,String passwd,FirebaseAuth fireLog){
        fireLog.signInWithEmailAndPassword(mail,passwd)
                .addOnCompleteListener((Activity) getApplicationContext(), new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Intent intent = new Intent(getApplicationContext(),splash_screen.class);
                            startActivity(intent);
                        }else {

                        }
                    }
                })
    }


}
