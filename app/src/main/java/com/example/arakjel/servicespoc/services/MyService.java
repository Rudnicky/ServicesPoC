package com.example.arakjel.servicespoc.services;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.Toast;

import com.example.arakjel.servicespoc.R;


public class MyService extends Service {

    private MediaPlayer mMediaPlayer;

    @Override
    public void onCreate() {
        Toast.makeText(this, "Service has been Created", Toast.LENGTH_LONG).show();
        mMediaPlayer = new MediaPlayer().create(this, R.raw.eastwest);
        mMediaPlayer.setLooping(false);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this, "Service has Started", Toast.LENGTH_LONG).show();
        mMediaPlayer.start();
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "Service has been Destroyed", Toast.LENGTH_LONG).show();
        mMediaPlayer.stop();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
