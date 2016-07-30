package com.android.crystal.wineryguidebook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class WineryDetailActivity extends AppCompatActivity {

    String id;
    String name;
    String address;
    String phone;
    String rate;
    TextView txtName;
    TextView txtAddress;
    TextView txtRate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent i = getIntent();
        id = i.getStringExtra("id");
        name = i.getStringExtra("name");
        address =i.getStringExtra("address");
        phone = i.getStringExtra("phone");
        rate = i.getStringExtra("rate");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_winery_detail);
        txtName = (TextView)findViewById(R.id.txtName);
        txtName.setText(name);
        txtAddress = (TextView)findViewById(R.id.txtAddress);
        txtAddress.setText(address);
        txtRate = (TextView)findViewById(R.id.txtRate);
        txtRate.setText(rate);
    }
}
