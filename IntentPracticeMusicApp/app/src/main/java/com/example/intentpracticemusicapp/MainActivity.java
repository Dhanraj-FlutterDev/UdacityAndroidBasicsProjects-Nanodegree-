package com.example.intentpracticemusicapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        TextView playlist = (TextView) findViewById(R.id.playlist);
        TextView album = (TextView) findViewById(R.id.album);
        TextView folder = (TextView) findViewById(R.id.folder);
        TextView favourites = (TextView) findViewById(R.id.fav);
        TextView nowPlaying = (TextView) findViewById(R.id.now_playing);

        playlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,Playlist.class);
                startActivity(i);
            }
        });
        album.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,Albums.class);
                startActivity(i);
            }
        });
        folder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,Folders.class);
                startActivity(i);
            }
        });
        favourites.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,Favourites.class);
                startActivity(i);
            }
        });
        nowPlaying.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,NowPlaying.class);
                startActivity(i);
            }
        });
    }


}
