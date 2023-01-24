package com.example.w23_layouts;

import androidx.appcompat.app.AppCompatActivity;
// context = the app's runtime memory, where we have access to all resources

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
// Layout file, Controle the layout, model
// MVC
public class ThirdActivity extends AppCompatActivity {
    // R.java
    // I need Button Object
    Button logInButton;
    EditText userNameText;
    EditText passwordText;
    TextView megText;
    UserDB userDB = new UserDB();//

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        logInButton = findViewById(R.id.LogIn);
        userNameText = findViewById(R.id.userNameText);
        passwordText = findViewById(R.id.passwordText);
        megText = findViewById(R.id.welcomeText);

        logInButton.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                // any code here will run when the button clicked
                if (!userNameText.getText().toString().isEmpty() &&
                    !passwordText.getText().toString().isEmpty())
                {
                    megText.setText("Welcome " + userNameText.getText().toString());
                    logInButton.setVisibility(View.INVISIBLE);
                    userNameText.setVisibility(View.INVISIBLE);
                    passwordText.setVisibility(View.INVISIBLE);
                    User newUser = new User(userNameText.getText().toString(), passwordText.getText().toString());
                    userDB.addNewUser(newUser);

                }else {
                    Toast.makeText(ThirdActivity.this, R.string.erromsg, Toast.LENGTH_SHORT).show();
                }

            }
        });


    }
}