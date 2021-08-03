package com.example.irlix_image_scroller;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.irlix_image_scroller.databinding.ActivityMainBinding;
import com.example.irlix_image_scroller.databinding.FragmentRecyclerViewBinding;

import org.xmlpull.v1.XmlPullParser;

public class RecyclerViewFragment extends Fragment {

    FragmentRecyclerViewBinding binding;
    private ImageBlockAdapter imageBlockAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        imageBlockAdapter = new ImageBlockAdapter();
        binding = FragmentRecyclerViewBinding.inflate(getLayoutInflater(), container, false);
        init();
        return binding.getRoot();
    }

    private void init() {
        binding.rcView.setLayoutManager(new LinearLayoutManager(getActivity()));
        binding.rcView.setAdapter(imageBlockAdapter);
    }
}