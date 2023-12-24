package com.example.farmacia;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class shopdetail extends AppCompatActivity
{
    int quant = 1;
    TextView drugName, drugPrice, drugActive, drugQuantity;
    ImageView drugImage;

//    FloatingActionButton f_action;
    int[] imagesShop = {R.drawable.panadol, R.drawable.congestal, R.drawable.antinal, R.drawable.cataflam};
    String[] drugsNames = {"Panadol", "Congestal", "Antinal", "Cataflam"};
    String[] drugsPrices = {"20.75 EGP", "55.25 EGP", "23.35 EGP", "66.26 EGP"};
    String[] drugsQuantities = {"120", "90", "55", "102"};
    String[] drugsActives = {"Active Ingredients:\n500mg paracetamol\n65 mg caffeine", "Active Ingredients:\n650mg paracetamol\nPseudoephedrine HCL 60mg", "Active Ingredients:\nNifuroxazide", "Active Ingredients:\nDiclofenac Free Acid"};

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_detail);

        drugName = findViewById(R.id.tv_name_product_shop_detail);
        drugPrice = findViewById(R.id.drug_price_detail);
        drugActive = findViewById(R.id.active_brief);
        drugQuantity = findViewById(R.id.quantity_text);
        drugImage = findViewById(R.id.image_shop_detail);
//        f_action = findViewById(R.id.fab_add_to_cart);
        String name = getIntent().getStringExtra("name");
        int image = getIntent().getIntExtra("image", 0);
        String price = getIntent().getStringExtra("price");
        String active = getIntent().getStringExtra("active");

        drugName.setText(name);
        drugPrice.setText(price);
        drugActive.setText(active);
        drugImage.setImageResource(image);
        drugQuantity.setText(Integer.toString(quant));


    }

    public void returnToDecrement(View view)
    {
        if(quant > 1)
        {
            quant--;
            drugQuantity.setText(Integer.toString(quant));
        }
    }

    public void returnToIncrement(View view)
    {
        quant++;
        drugQuantity.setText(Integer.toString(quant));
    }

//    public void addToCart(View view)
//    {
//        Toast.makeText(this, "Added to cart", Toast.LENGTH_SHORT).show();
//    }

    public void goBack(View view)
    {
        Intent i = new Intent(this, shop.class);
        startActivity(i);
        finish();
    }

    public void callUs(View view)
    {
        Intent i = new Intent(Intent.ACTION_DIAL);
        i.setData(Uri.parse("tel: +201272033603"));
        startActivity(i);
    }

    public void clickme(View view) {
        Intent i = new Intent(this, MedicationReminderService.class);
        startService(i);
    }
}