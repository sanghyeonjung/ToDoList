package com.example.to_do_list_application;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
    private String TAG = "메인";
    Fragment fragment_home;
    Fragment fragment_todolist;
    Fragment fragment_storage;
    Fragment fragment_more;
    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragment_home = new Home_Fragment();
        fragment_todolist = new ToDoList_Fragment();
        fragment_storage = new Storage_Fragment();
        fragment_more = new More_Fragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.main_layout, fragment_home).commitAllowingStateLoss();
        bottomNavigationView = findViewById(R.id.menu_bottom_navigation);
        bottomNavigationView.setOnItemSelectedListener(item -> {
            // do stuff
            switch (item.getItemId()){
                case R.id.menu_home:
                    getSupportFragmentManager().beginTransaction().replace(R.id.main_layout, fragment_home).commitAllowingStateLoss();
                    return true;
                case R.id.menu_todolist:
                    getSupportFragmentManager().beginTransaction().replace(R.id.main_layout, fragment_todolist).commitAllowingStateLoss();
                    return true;
                case R.id.menu_memory:
                    getSupportFragmentManager().beginTransaction().replace(R.id.main_layout, fragment_storage).commitAllowingStateLoss();
                    return true;
                case R.id.menu_more:
                    getSupportFragmentManager().beginTransaction().replace(R.id.main_layout, fragment_more).commitAllowingStateLoss();
                    return true;
            }
            return true;
        });
    }
}