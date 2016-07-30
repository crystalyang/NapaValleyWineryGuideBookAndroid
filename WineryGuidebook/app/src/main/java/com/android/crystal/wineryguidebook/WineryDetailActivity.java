package com.android.crystal.wineryguidebook;

import android.*;
import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class WineryDetailActivity extends Activity {
    private static final int MY_PERMISSIONS_REQUEST_CALL_PHONE = 1234;

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
        address = i.getStringExtra("address");
        phone = i.getStringExtra("phone");
        rate = i.getStringExtra("rate");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_winery_detail);
        txtName = (TextView) findViewById(R.id.txtName);
        txtName.setText(name);
        txtAddress = (TextView) findViewById(R.id.txtAddress);
        txtAddress.setText(address);
        txtRate = (TextView) findViewById(R.id.txtRate);
        txtRate.setText(rate);

        final Button button = (Button) findViewById(R.id.btnCall);
        if (button != null) {
            button.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Intent callIntent = new Intent(Intent.ACTION_CALL);
                    callIntent.setData(Uri.parse("tel" + phone));

                    if (ActivityCompat.checkSelfPermission(getApplicationContext(), android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                        requestPermissions(new String[] {Manifest.permission.CALL_PHONE},MY_PERMISSIONS_REQUEST_CALL_PHONE);
                        return;
                    }else {
                        // TODO: causing crash; fix this later
                        startActivity(callIntent);

                    }
                }
            });
        }

        final Button review = (Button) findViewById(R.id.btnReview);
        if(review != null){
            review.setOnClickListener(new View.OnClickListener(){
                public void onClick(View v){
                    Intent i = new Intent(v.getContext(),ReviewListActivity.class);
                    i.putExtra("id",id);
                    startActivity(i);
                }
            });
        }
    }
}
