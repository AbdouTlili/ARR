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
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;

public class log_in extends AppCompatActivity {



    private FirebaseAuth fireLog;
     EditText userMail;
     EditText userPasswd;
     TextView signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

         signup=(TextView) findViewById(R.id.signup);
         userMail = (EditText) findViewById(R.id.userMail);
         userPasswd = (EditText) findViewById(R.id.userPasswd);
        Button loginBut = (Button) findViewById(R.id.loginBut);
        fireLog=FirebaseAuth.getInstance();
        loginBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fireLog.signInWithEmailAndPassword(userMail.getText().toString(),userPasswd.getText().toString())
                        .addOnCompleteListener(log_in.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()){
                                    Intent intent = new Intent(log_in.this,splash_screen.class);
                                    startActivity(intent);
                                }else {
                                    try {
                                        throw task.getException();
                                    } catch(FirebaseAuthWeakPasswordException e) {
                                        userPasswd.setError("Password must be at least 6 char's");
                                        userPasswd.requestFocus();
                                    } catch(FirebaseAuthInvalidCredentialsException e) {
                                        userMail.setError("Invalid email format");
                                        userMail.requestFocus();
                                    } catch(FirebaseAuthUserCollisionException e) {
                                        userMail.setError("Password doesn't match to this email");
                                        userMail.requestFocus();
                                    } catch(Exception e) {

                                    }

                                }
                            }
                        });
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(log_in.this,SignUp.class));

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
