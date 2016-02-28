package com.karanandfriends.cameraapp.adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.karanandfriends.cameraapp.R;
import com.karanandfriends.cameraapp.models.Photo;

import java.io.InputStream;
import java.util.Collections;
import java.util.List;

public class PhotoAdapter extends BaseAdapter {

    private List<Photo> photos = Collections.emptyList();

    private final Context context;

    public PhotoAdapter(Context context) {
        this.context = context;
    }

    // TODO: Ensure thread safety
    public void updatePhotos(List<Photo> photos) {
        this.photos = photos;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return photos.size();
    }

    @Override
    public Photo getItem(int position) {
        return photos.get(position);
    }

    @Override
    public long getItemId(int position) {
        // for now this will return position in list
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rootView = LayoutInflater.from(context)
                .inflate(R.layout.photo, parent, false);


        ImageView photoView = (ImageView) rootView.findViewById(R.id.photo);

        Photo photo = getItem(position);

        // Set photo by downloading from url
        new DownloadImageTask(photoView).execute(photo.getUrl());

        return rootView;
    }


    // NOT MINE. Grabbed from somewhere online:
    // http://web.archive.org/web/20120802025411/http://developer.aiwgame.com
    // /imageview-show-image-from-url-on-android-4-0.html
    private class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
        ImageView bmImage;

        public DownloadImageTask(ImageView bmImage) {
            this.bmImage = bmImage;
        }

        protected Bitmap doInBackground(String... urls) {
            String urldisplay = urls[0];
            Bitmap mIcon11 = null;
            try {
                InputStream in = new java.net.URL(urldisplay).openStream();
                mIcon11 = BitmapFactory.decodeStream(in);
            } catch (Exception e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            return mIcon11;
        }

        protected void onPostExecute(Bitmap result) {
            bmImage.setImageBitmap(result);
        }
    }
}
