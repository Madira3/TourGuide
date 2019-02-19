package com.example.android.tourguide;

import android.app.Fragment;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction().replace(R.id.fragment_container, new AboutFragment()).commit();
            navigationView.setCheckedItem(R.id.about_menu_text);
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull final MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.about_menu_text) {
            getFragmentManager().beginTransaction().replace(R.id.fragment_container, new AboutFragment()).addToBackStack(null).commit();
            setTitle(menuItem.getTitle());

        } else if (menuItem.getItemId() == R.id.visit_menu_text) {
            getFragmentManager().beginTransaction().replace(R.id.fragment_container, new VisitListFrag()).addToBackStack(null).commit();
            setTitle(menuItem.getTitle());


        } else if (menuItem.getItemId() == R.id.stay_menu_text) {
            getFragmentManager().beginTransaction().replace(R.id.fragment_container, new StayListFrag()).addToBackStack(null).commit();
            setTitle(menuItem.getTitle());

        } else if (menuItem.getItemId() == R.id.dine_menu_text) {
            getFragmentManager().beginTransaction().replace(R.id.fragment_container, new DineListFrag()).addToBackStack(null).commit();
            setTitle(menuItem.getTitle());

        } else {
            getFragmentManager().beginTransaction().replace(R.id.fragment_container, new ShopListFragment()).addToBackStack(null).commit();
            setTitle(menuItem.getTitle());
        }


        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }

    }

    public void setActionBarTitle(String title) {
        getSupportActionBar().setTitle(title);
    }
}
