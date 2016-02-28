package com.karanandfriends.cameraapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import com.etsy.android.grid.StaggeredGridView;
import com.karanandfriends.cameraapp.adapters.PhotoAdapter;
import com.karanandfriends.cameraapp.models.Photo;

import java.util.Collections;
import java.util.List;

public class GalleryActivity extends AppCompatActivity {

    private PhotoAdapter photoAdapter;
    private List<Photo> photos = Collections.emptyList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // TODO: Hit endpoint and obtain list of first n photos
        // TODO: Store in list of Photo objects ("photos")

        photoAdapter = new PhotoAdapter(this);
        photoAdapter.updatePhotos(photos);
        StaggeredGridView gridView = (StaggeredGridView) findViewById(R.id.grid_view);
        gridView.setAdapter(photoAdapter);

        Button addPhotoButton = (Button) findViewById(R.id.addPhotoButton);
        addPhotoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent photoCaptureActivity = new Intent(getApplicationContext(),
                        PhotoCaptureActivity.class);
                startActivity(photoCaptureActivity);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_gallery, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
