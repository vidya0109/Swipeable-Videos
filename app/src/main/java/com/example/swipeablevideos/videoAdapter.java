package com.example.swipeablevideos;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.VideoView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class videoAdapter extends RecyclerView.Adapter<videoAdapter.videoViewHolder>
{
    List<VideoItem>  videoItems;
    Context context;

    public videoAdapter(List<VideoItem> videoItems,Context context) {
        this.videoItems = videoItems;
        this.context = context;
    }

    @NonNull
    @Override
    public videoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new videoViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.container_video,parent,false) );
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public void onBindViewHolder(@NonNull videoViewHolder holder, int position) {

        holder.textView.setText(videoItems.get(position).getVideoTitle());
        holder.textView2.setText(videoItems.get(position).getVideoDescription());
        holder.videoView.setVideoPath(videoItems.get(position).getVideoUrl());

        holder.videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                holder.progressBar.setVisibility(View.GONE);
                mediaPlayer.start();

                float videoRatio = mediaPlayer.getVideoWidth()/(float)mediaPlayer.getVideoHeight();

                float Screenratio = holder.videoView.getWidth() / (float) holder.videoView.getHeight();

                float scale = videoRatio / Screenratio;

                if (scale>=1f){

                    holder.videoView.setScaleX(scale);
                }
                else{

                    holder.videoView.setScaleY(1f/scale);
                }

            }
        });

        holder.videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {

                mediaPlayer.start();
            }
        });
        holder.videoView.setOnTouchListener(new OnSwipeTouchListener(context){
            @Override
            public void onSwipeLeft() {
                super.onSwipeLeft();
                Intent i = new Intent(context,Profile.class);
                context.startActivity(i);
            }
            @Override
            public void onSwipeRight() {
                super.onSwipeRight();


                Intent i = new Intent(context,Subscibed.class);
                context.startActivity(i);

            }
        });;
    }

    @Override
    public int getItemCount() {
        return videoItems.size();
    }




    static class videoViewHolder extends RecyclerView.ViewHolder{

        VideoView videoView;
        TextView textView ,textView2;
        ProgressBar progressBar;
        Context context;
        public videoViewHolder(@NonNull View itemView) {
            super(itemView);
            videoView = itemView.findViewById(R.id.videoView);
            textView = itemView.findViewById(R.id.videoTitle);
            textView2 = itemView.findViewById(R.id.videoDescription);
            progressBar = itemView.findViewById(R.id.progressBar);

        }


    }
}

