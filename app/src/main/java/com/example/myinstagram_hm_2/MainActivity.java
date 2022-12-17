package com.example.myinstagram_hm_2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    FragmentContainerView fragmentContainerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.main_bottom_nav);
        fragmentContainerView = findViewById(R.id.main_container);


        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.menu_home:
                        openFragment(new HomeFragment());
                        break;
                    case R.id.menu_search:
                        openFragment(new SearchFragment());
                        break;
                    case R.id.menu_gallery:
                        openFragment(new GalleryFragment());
                        break;
                    case R.id.menu_like:
                        openFragment(new LikeFragment());
                        break;
                    case R.id.menu_profile:
                        openFragment(new ProfileFragment());
                        break;
                }
                return false;
            }
        });
    }

    private  void openFragment(Fragment fragment){
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.main_container, fragment)
                .commit();
    }
}