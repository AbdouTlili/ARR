package com.arr.abdou.arr;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;

public class SignUp extends AppCompatActivity {
    private FirebaseAuth fireSignUp;
    EditText userMail;
    EditText userPasswd;
    EditText userPasswd1;
    EditText pseudo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        fireSignUp=FirebaseAuth.getInstance();
        Button signUp=findViewById(R.id.signupBut);

    }
}
