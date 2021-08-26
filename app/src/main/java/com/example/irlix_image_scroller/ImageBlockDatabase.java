package com.example.irlix_image_scroller;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import org.jetbrains.annotations.NotNull;

@Database(entities = ImageBlock.class, version = 1)
public abstract class ImageBlockDatabase extends RoomDatabase {

    private static ImageBlockDatabase instance;

    public abstract ImageBlockDao imageBlockDao();

    public static synchronized ImageBlockDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext()
                    , ImageBlockDatabase.class
                    , "image_block_database")
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallback)
                    .build();
        }

        return instance;
    }

    private static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull @NotNull SupportSQLiteDatabase db) {
            super.onCreate(db);

//            new PopulateDbAsyncTask(instance).execute();
            AsyncTask.execute(() -> {
                ImageBlock imageBlock = new ImageBlock(
                        "https://static.wikia.nocookie.net/nopixel/images/e/e6/Bogg_bimx.jpg/revision/latest?cb=20210313094623",
                        "Bogg Dann",
                        "https://yt3.ggpht.com/ytc/AKedOLSRzLPOSGKGzsQfPofbvOmT2Ox3Ea0EStcU9HUb=s900-c-k-c0x00ffffff-no-rj",
                        "bogg, bimx, bike",
                        1337
                );
                instance.imageBlockDao().insert(imageBlock);
                Log.e("Database", "insert()");
            });
        }
    };

    private static class PopulateDbAsyncTask extends AsyncTask<Void, Void, Void> {
        private ImageBlockDao imageBlockDao;

        private PopulateDbAsyncTask(ImageBlockDatabase db) {
            imageBlockDao = db.imageBlockDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {

            return null;
        }
    }
}
