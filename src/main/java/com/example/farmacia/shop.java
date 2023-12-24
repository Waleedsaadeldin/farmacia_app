package com.example.farmacia;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;


import android.annotation.SuppressLint;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.google.android.material.card.MaterialCardView;

public class shop extends AppCompatActivity
{
    int[] imagesShop = {R.drawable.panadol, R.drawable.congestal, R.drawable.antinal, R.drawable.cataflam};
    String[] drugsNames = {"Panadol", "Congestal", "Antinal", "Cataflam"};
    String[] drugsPrices = {"20.75 EGP", "55.25 EGP", "23.35 EGP", "66.26 EGP"};
    String[] drugsQuantities = {"120", "90", "55", "102"};
    String[] drugsActives = {"Active Ingredients:\n500mg paracetamol\n65 mg caffeine", "Active Ingredients:\n650mg paracetamol\nPseudoephedrine HCL 60mg", "Active Ingredients:\nNifuroxazide", "Active Ingredients:\nDiclofenac Free Acid"};

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);


    }

    public void returnToDetails(View view)
    {
        Intent i = new Intent(this, shopdetail.class);
        i.putExtra("name", drugsNames[0]);
        i.putExtra("price", drugsPrices[0]);
        i.putExtra("active", drugsActives[0]);
        i.putExtra("image", imagesShop[0]);

        startActivity(i);
    }

    public void toCart(View view)
    {
        Intent i = new Intent(this, pharmacy.class);
        startActivity(i);
    }

    public void returnToDetails2(View view)
    {
        Intent i = new Intent(this, shopdetail.class);
        i.putExtra("name", drugsNames[1]);
        i.putExtra("price", drugsPrices[1]);
        i.putExtra("quantity", drugsQuantities[1]);
        i.putExtra("active", drugsActives[1]);
        i.putExtra("image", imagesShop[1]);

        startActivity(i);
    }

    public void returnToDetails3(View view)
    {
        Intent i = new Intent(this, shopdetail.class);
        i.putExtra("name", drugsNames[2]);
        i.putExtra("price", drugsPrices[2]);
        i.putExtra("quantity", drugsQuantities[2]);
        i.putExtra("active", drugsActives[2]);
        i.putExtra("image", imagesShop[2]);

        startActivity(i);
    }

    public void returnToDetails4(View view)
    {
        Intent i = new Intent(this, shopdetail.class);
        i.putExtra("name", drugsNames[3]);
        i.putExtra("price", drugsPrices[3]);
        i.putExtra("quantity", drugsQuantities[3]);
        i.putExtra("active", drugsActives[3]);
        i.putExtra("image", imagesShop[3]);

        startActivity(i);
    }

    public void backToLogin(View view)
    {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
        finish();
    }

    public void orderNow(View view)
    {
        startService(new Intent(this, MedicationReminderService.class));
    }
}