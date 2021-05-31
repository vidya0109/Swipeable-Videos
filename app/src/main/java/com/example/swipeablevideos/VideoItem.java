package com.example.swipeablevideos;

import android.content.Context;

public class VideoItem {

    String videoUrl , videoTitle , videoDescription;


    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public String getVideoTitle() {
        return videoTitle;
    }

    public void setVideoTitle(String videoTitle) {
        this.videoTitle = videoTitle;
    }

    public String getVideoDescription() {
        return videoDescription;
    }

    public void setVideoDescription(String videoDescription) {
        this.videoDescription = videoDescription;
    }



    public VideoItem(String videoUrl, String videoTitle, String videoDescription) {
        this.videoUrl = videoUrl;
        this.videoTitle = videoTitle;
        this.videoDescription = videoDescription;

    }
}
