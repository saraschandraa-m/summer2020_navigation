package com.appstone.navigation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar mToolbar = findViewById(R.id.tl_home);
        setSupportActionBar(mToolbar);

        drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navView = findViewById(R.id.navigation_view);

        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, mToolbar,
                R.string.open, R.string.close);

        drawerToggle.syncState();


        navView.setNavigationItemSelectedListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        drawerLayout.closeDrawer(GravityCompat.START);

        switch (item.getItemId()) {
            case R.id.action_delete:
                startActivity(new Intent(MainActivity.this, TabActivity.class));
                break;

            case R.id.action_move:
//                FragmentTransaction fm = getSupportFragmentManager().beginTransaction();
//                fm.replace(R.id.fragment_holder, new MoveToInboxFragment());
//                fm.commit();


                Bundle args = new Bundle();
                args.putString("LABEL", "MOVE TO INBOX");

                MoveToInboxFragment moveToInboxFragment = new MoveToInboxFragment();
                moveToInboxFragment.setArguments(args);


                getSupportFragmentManager().beginTransaction().
                        replace(R.id.fragment_holder, moveToInboxFragment).commit();
                break;


            case R.id.action_archive:
                Bundle args1 = new Bundle();
                args1.putString("LABEL", "ARCHIVE");
                ArchiveFragment archiveFragment = new ArchiveFragment();
                archiveFragment.setArguments(args1);

                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_holder, archiveFragment).commit();
                break;

            case R.id.action_mark_as_important:
                Bundle args2 = new Bundle();
                args2.putString("LABEL", "MARK AS IMPORTANT");
                MarkAsFragment markAsFragment = new MarkAsFragment();
                markAsFragment.setArguments(args2);

                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_holder, markAsFragment).commit();
                break;
        }
        return false;
    }


    public void printToast() {
        Toast.makeText(this, "Called from fragment", Toast.LENGTH_LONG).show();
    }
}
