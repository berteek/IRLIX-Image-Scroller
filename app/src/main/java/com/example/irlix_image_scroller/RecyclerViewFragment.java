package com.example.irlix_image_scroller;

import android.media.Image;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
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
    private ImageBlockViewModel imageBlockViewModel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentRecyclerViewBinding.inflate(getLayoutInflater(), container, false);

        initAdapter();

        imageBlockViewModel = new ViewModelProvider(this).get(ImageBlockViewModel.class);
        imageBlockViewModel.setApplication(getActivity().getApplication());

        Log.e("Database ", "getAll()");
        imageBlockViewModel.getAll(imageBlocks -> imageBlockAdapter.addImageBlock(imageBlocks.get(0)));

        return binding.getRoot();
    }

    /*private void init() {
        initAdapter();
        ImageBlock imageBlock1 = new ImageBlock(
                "https://static.wikia.nocookie.net/nopixel/images/e/e6/Bogg_bimx.jpg/revision/latest?cb=20210313094623",
                "Bogg Dann",
                "https://yt3.ggpht.com/ytc/AKedOLSRzLPOSGKGzsQfPofbvOmT2Ox3Ea0EStcU9HUb=s900-c-k-c0x00ffffff-no-rj",
                tags,
                1337
        );
        imageBlockAdapter.addImageBlock(imageBlock1);
    }*/

    private void initAdapter() {
        imageBlockAdapter = new ImageBlockAdapter();
        binding.rcView.setLayoutManager(new LinearLayoutManager(getActivity()));
        binding.rcView.setAdapter(imageBlockAdapter);
    }
}