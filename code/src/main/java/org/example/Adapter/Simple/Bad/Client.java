package org.example.Adapter.Simple.Bad;

/**
 * Say we have a video editing application that allows users to upload a video and change the color of the video.
 * The application provides preset color options for the user to select, such as black and white, or midnight purple.
 */
public class Client {
    public static void main (String [] args){
        VideoEditingApplication videoEditor = new VideoEditingApplication(new Video());
        videoEditor.applyColor(new Blackwhite());
    }
}
class Video{
}
interface Color{
    public void applyColor(Video video);
}

class Blackwhite implements Color{

    @Override
    public void applyColor(Video video) {
        System.out.println("applied black and white on video");
    }
}
class VideoEditingApplication{
    Video video;
    VideoEditingApplication(Video video){
        this.video = video;
    }
    public void applyColor(Color color){
        color.applyColor(video);
    }
}

/**
 * if you have a new color with different interface, we cannot use it because it is expecting a Color interface
 */
