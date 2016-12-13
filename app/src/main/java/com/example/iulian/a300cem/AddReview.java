package com.example.iulian.a300cem;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Looper;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.PermissionChecker;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.security.Permission;
import java.util.List;


public class AddReview extends AppCompatActivity {


    private double longitude;
    private double latitude;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_review);

        final EditText reviewTitle = (EditText) findViewById(R.id.reviewTitle);
        final EditText reviewComment = (EditText) findViewById(R.id.reviewComment);
        final Button addReviewButton = (Button) findViewById(R.id.addReviewButton);


        addReviewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String title = reviewTitle.getText().toString();
                final String comment = reviewComment.getText().toString();


                Response.Listener<String> responseListener = new Response.Listener<String>() {

                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");
                            if (success) {
                                Intent reviewIntent = new Intent(AddReview.this, UserAreaActivity.class);
                                AddReview.this.startActivity(reviewIntent);
                            } else {
                                AlertDialog.Builder builder = new AlertDialog.Builder(AddReview.this);
                                builder.setMessage("Action Failed")
                                        .setNegativeButton("Retry", null)
                                        .create()
                                        .show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };

                final double[] coordinates = getLoc();

                ReviewRequest reviewRequest = new ReviewRequest(title, comment, coordinates[0], coordinates[1], responseListener);
                                                   RequestQueue queue = Volley.newRequestQueue(AddReview.this);
                                                   queue.add(reviewRequest);
                                               }
                                           }

        );


    }

    private double[] getLoc() {
        LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        List<String> providers = locationManager.getProviders(true);
        Location loc = null;

        for (int i = providers.size() - 1; i >= 0; i--) {
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

                return null;
            }
            loc = locationManager.getLastKnownLocation(providers.get(i));
            if (loc != null) break;
        }

        double[] coordinates = new double[2];
        if (loc != null) {
            coordinates[0] = loc.getLongitude();
            coordinates[1] = loc.getLatitude();
        }
        return coordinates;
    }

}
