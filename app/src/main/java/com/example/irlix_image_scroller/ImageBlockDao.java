package com.example.irlix_image_scroller;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ImageBlockDao {

    @Insert
    void insert(ImageBlock imageBlock);

    @Update
    void update(ImageBlock imageBlock);

    @Delete
    void delete(ImageBlock imageBlock);

    @Query("SELECT * FROM image_block_table")
    List<ImageBlock> getAll();
}
