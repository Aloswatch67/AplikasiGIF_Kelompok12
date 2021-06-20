package com.example.gifapplication;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.MenuItem;
import android.widget.TextView;


import com.example.gifapplication.view.fragment.SearchFragment;
import com.example.gifapplication.view.fragment.TrendingFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeScreen extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener
{
    private Fragment selectedFragment = new SearchFragment();
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_screen);

        bottomNavigationView = findViewById(R.id.homescreen_bottomnav);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.bottomnav_search:
                selectedFragment = new SearchFragment();
                loadFragment(selectedFragment);
                break;

            case R.id.bottomnav_trending:
                selectedFragment = new TrendingFragment();
                loadFragment(selectedFragment);
                break;
        }

        return loadFragment(selectedFragment);
    }

    private boolean loadFragment(Fragment selectedFragment)
    {
        if (selectedFragment != null)
        {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.homescreen_fragment, selectedFragment)
                    .commit();
            return true;
        }

        return false;
    }
}