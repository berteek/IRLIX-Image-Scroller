package com.example.irlix_image_scroller;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.irlix_image_scroller.databinding.FragmentRecyclerViewBinding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        ArrayList<String> tags = new ArrayList<String>();
        tags.add("bimx");
        tags.add("bike");
        tags.add("bawg");
        ImageBlock imageBlock = new ImageBlock(
                "https://static.wikia.nocookie.net/nopixel/images/e/e6/Bogg_bimx.jpg/revision/latest?cb=20210313094623",
                "Bogg Dann",
                "https://yt3.ggpht.com/ytc/AKedOLSRzLPOSGKGzsQfPofbvOmT2Ox3Ea0EStcU9HUb=s900-c-k-c0x00ffffff-no-rj",
                tags,
                1337
        );
        imageBlockAdapter.addImageBlock(imageBlock);
    }
}