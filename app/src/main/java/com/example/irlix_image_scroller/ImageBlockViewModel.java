package com.example.irlix_image_scroller;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.ViewModel;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class ImageBlockViewModel extends ViewModel {

    private ImageBlockRepository repository;

    public ImageBlockViewModel() {}

    public ImageBlockViewModel(@NonNull @NotNull Application application) {
        repository = new ImageBlockRepository(application);
    }

    public void setApplication(Application application) {
        repository = new ImageBlockRepository(application);
    }

    public void insert(ImageBlock imageBlock) {
        repository.insert(imageBlock);
    }

    public void update(ImageBlock imageBlock) {
        repository.update(imageBlock);
    }

    public void delete(ImageBlock imageBlock) {
        repository.delete(imageBlock);
    }

    public void getAll(ImageBlockRepository.ICallBack<List<ImageBlock>> iCallBack) {
        repository.getAll(iCallBack);
    }
}
