package com.example.irlix_image_scroller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.media.Image;
import android.os.Bundle;

import com.example.irlix_image_scroller.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    Fragment recyclerViewFragment;
    Fragment imageBlockInfoFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewFragment = new RecyclerViewFragment();
        imageBlockInfoFragment = new ImageBlockInfoFragment();

        getSupportFragmentManager().beginTransaction().replace(R.id.flRcViewFragment, recyclerViewFragment).commit();
    }
}