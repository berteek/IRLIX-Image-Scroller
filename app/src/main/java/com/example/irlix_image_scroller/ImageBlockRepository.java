package com.example.irlix_image_scroller;

import android.app.Application;
import android.os.AsyncTask;

import androidx.room.Update;

import java.util.List;

public class ImageBlockRepository {

    public interface ICallBack<T> {
        void execute(T t);
    }

    private ImageBlockDao imageBlockDao;

    public ImageBlockRepository(Application application) {
        ImageBlockDatabase database = ImageBlockDatabase.getInstance(application);
        imageBlockDao = database.imageBlockDao();
    }

    public void insert(ImageBlock imageBlock) {
        new InsertImageBlockAsyncTask(imageBlockDao).execute(imageBlock);
    }

    public void update(ImageBlock imageBlock) {
        new UpdateImageBlockAsyncTask(imageBlockDao).execute(imageBlock);
    }

    public void delete(ImageBlock imageBlock) {
        new DeleteImageBlockAsyncTask(imageBlockDao).execute(imageBlock);
    }

    public void getAll(ICallBack<List<ImageBlock>> iCallBack) {
        new GetAllImageBlockAsyncTask(imageBlockDao, iCallBack).execute();
    }

    private static class GetAllImageBlockAsyncTask extends AsyncTask<Void, Void, List<ImageBlock>> {

        private ImageBlockDao imageBlockDao;
        private ICallBack<List<ImageBlock>> iCallBack;

        private GetAllImageBlockAsyncTask(ImageBlockDao imageBlockDao, ICallBack<List<ImageBlock>> iCallBack) {
            this.imageBlockDao = imageBlockDao;
            this.iCallBack = iCallBack;
        }

        @Override
        protected List<ImageBlock> doInBackground(Void... voids) {
            return imageBlockDao.getAll();
        }

        @Override
        protected void onPostExecute(List<ImageBlock> imageBlocks) {
            super.onPostExecute(imageBlocks);

            iCallBack.execute(imageBlocks);
        }
    }

    private static class InsertImageBlockAsyncTask extends AsyncTask<ImageBlock, Void, Void> {

        private ImageBlockDao imageBlockDao;

        private InsertImageBlockAsyncTask(ImageBlockDao imageBlockDao) {
            this.imageBlockDao = imageBlockDao;
        }

        @Override
        protected Void doInBackground(ImageBlock... imageBlocks) {
            imageBlockDao.insert(imageBlocks[0]);
            return null;
        }
    }

    private static class UpdateImageBlockAsyncTask extends AsyncTask<ImageBlock, Void, Void> {

        private ImageBlockDao imageBlockDao;

        private UpdateImageBlockAsyncTask(ImageBlockDao imageBlockDao) {
            this.imageBlockDao = imageBlockDao;
        }

        @Override
        protected Void doInBackground(ImageBlock... imageBlocks) {
            imageBlockDao.update(imageBlocks[0]);
            return null;
        }
    }

    private static class DeleteImageBlockAsyncTask extends AsyncTask<ImageBlock, Void, Void> {

        private ImageBlockDao imageBlockDao;

        private DeleteImageBlockAsyncTask(ImageBlockDao imageBlockDao) {
            this.imageBlockDao = imageBlockDao;
        }

        @Override
        protected Void doInBackground(ImageBlock... imageBlocks) {
            imageBlockDao.delete(imageBlocks[0]);
            return null;
        }
    }
}
