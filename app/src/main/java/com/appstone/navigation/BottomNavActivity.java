package com.appstone.navigation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class BottomNavActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    BottomNavigationView bottomNavView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_nav);

        bottomNavView = findViewById(R.id.bottom_nav);

        bottomNavView.setOnNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        bottomNavView.getMenu().findItem(item.getItemId()).setChecked(true);

        if (item.getItemId() == R.id.action_delete) {
            onBackPressed();
        } else if (item.getItemId() == R.id.action_move) {
//            Toast.makeText(BottomNavActivity.this, "Move", Toast.LENGTH_LONG).show();
        }
        return false;
    }
}
