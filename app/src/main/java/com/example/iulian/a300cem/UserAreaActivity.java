package com.example.iulian.a300cem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class UserAreaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_area);


        final Button addReview = (Button) findViewById(R.id.addReviewButton);

        addReview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addReviewIntent = new Intent(UserAreaActivity.this, AddReview.class);
                UserAreaActivity.this.startActivity(addReviewIntent);
            }
        });

        final Button viewMap = (Button) findViewById(R.id.viewMapButton);

        viewMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent viewMapIntent = new Intent(UserAreaActivity.this, viewMap.class);
                UserAreaActivity.this.startActivity(viewMapIntent);
            }
        });

    }
}
