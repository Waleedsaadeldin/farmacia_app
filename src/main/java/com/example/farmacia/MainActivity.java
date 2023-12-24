package com.example.farmacia;
import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    Button loginButton;
    TextView toRegister;
    EditText usernameInput, passwordInput;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BroadcastReceiver br = new MyReceiver();
        IntentFilter f1 = new IntentFilter(Intent.ACTION_POWER_DISCONNECTED);
        IntentFilter f2 = new IntentFilter(Intent.ACTION_POWER_CONNECTED);
        IntentFilter f3 = new IntentFilter(Intent.ACTION_BATTERY_LOW);

        registerReceiver(br, f1);
        registerReceiver(br, f2);
        registerReceiver(br, f3);


//        startService(new Intent(this, MedicationReminderService.class));
        usernameInput = findViewById(R.id.edittext);
        passwordInput = findViewById(R.id.edittext2);

        loginButton = findViewById(R.id.login_button);
        toRegister = findViewById(R.id.textView3);


        loginButton.setOnClickListener(v ->
        {
            if(!TextUtils.isEmpty(usernameInput.getText().toString()) || !TextUtils.isEmpty(passwordInput.getText().toString()))
            {
                SharedPreferences sp = getApplicationContext().getSharedPreferences("MyUserPrefs", Context.MODE_PRIVATE);
                String username = sp.getString("username", "");
                String password = sp.getString("password", "");

                if(username.equals(usernameInput.getText().toString()) && password.equals(passwordInput.getText().toString()))
                {
                    Intent i = new Intent(this, shop.class);
                    startActivity(i);
                    finish();

                    Toast.makeText(this, "Welcome " + username, Toast.LENGTH_SHORT).show();
                }

                else
                {
                    Toast.makeText(this, "username or password is wrong!", Toast.LENGTH_SHORT).show();
                }
            }

            else
            {
                Toast.makeText(this, "please fill your data", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void returnToReg(View view)
    {
        Intent i = new Intent(this, registration.class);
        startActivity(i);
        finish();
    }
}