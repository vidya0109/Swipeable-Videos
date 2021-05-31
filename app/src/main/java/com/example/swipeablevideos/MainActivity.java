package com.example.swipeablevideos;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager2 viewPager2 = findViewById(R.id.videosviewpager);

        List<VideoItem> videoItems = new ArrayList<>();

        String path = "android.resource://" + getPackageName() + "/" + R.raw.video2;
        VideoItem videoItem = new VideoItem(path, "Nature's Beauty", "Nature is so beautiful");
        videoItems.add(videoItem);
        String path2 = "android.resource://" + getPackageName() + "/" + R.raw.video5;
        VideoItem videoItem2 = new VideoItem(path2, "Flowers", "Flowers are so beautiful");
        videoItems.add(videoItem2);
        String path3 = "android.resource://" + getPackageName() + "/" + R.raw.video7;
        VideoItem videoItem3 = new VideoItem(path3, "Motivational Video", "Dream big");
        videoItems.add(videoItem3);
        String path4 = "android.resource://" + getPackageName() + "/" + R.raw.video6;
        VideoItem videoItem4 = new VideoItem(path4, "Nature", "Beauty is on another level");
        videoItems.add(videoItem4);
        viewPager2.setAdapter(new videoAdapter(videoItems,this));


    }
}