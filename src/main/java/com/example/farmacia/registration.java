package com.example.farmacia;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class registration extends AppCompatActivity
{
    EditText usernameInput, passwordInput, confirmInput, addressInput, birthInput;
    String usernameText, passwordText, confirmText, addressText, birthText;
    Button signupButton;
    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        usernameInput = findViewById(R.id.edittext4);
        passwordInput = findViewById(R.id.edittext5);
        confirmInput = findViewById(R.id.edittext7);
        addressInput = findViewById(R.id.edittext10);
        birthInput = findViewById(R.id.edittext11);
        signupButton = findViewById(R.id.signup);
        sp = getSharedPreferences("MyUserPrefs", Context.MODE_PRIVATE);

        signupButton.setOnClickListener(v ->
        {
            if(!TextUtils.isEmpty(usernameInput.getText().toString()) || !TextUtils.isEmpty(passwordInput.getText().toString()) || !TextUtils.isEmpty(confirmInput.getText().toString()) || !TextUtils.isEmpty(addressInput.getText().toString()) || !TextUtils.isEmpty(birthInput.getText().toString()))
            {
                if(passwordInput.getText().toString().equals(confirmInput.getText().toString()))
                {
                    SharedPreferences.Editor editor = sp.edit();

                    editor.putString("username", usernameInput.getText().toString());
                    editor.putString("password", passwordInput.getText().toString());
                    editor.putString("confirmPassword", confirmInput.getText().toString());
                    editor.putString("address", addressInput.getText().toString());
                    editor.putString("birth", birthInput.getText().toString());
                    editor.commit();

                    Intent i = new Intent(this, MainActivity.class);
                    startActivity(i);
                    finish();
                }

                else
                {
                    Toast.makeText(this, "Please check passwords", Toast.LENGTH_SHORT).show();
                }
            }

            else
            {
                Toast.makeText(this, "Please fill your data", Toast.LENGTH_SHORT).show();

            }
        });
    }

    public void returnToLogin(View view)
    {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
        finish();
    }
}