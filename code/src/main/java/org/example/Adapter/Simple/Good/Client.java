package org.example.Adapter.Simple.Good;

/**
 * Say we have a video editing application that allows users to upload a video and change the color of the video.
 * The application provides preset color options for the user to select, such as black and white, or midnight purple.
 */
public class Client {
    public static void main (String [] args){
        VideoEditingApplication videoEditor = new VideoEditingApplication(new Video());
        videoEditor.applyColor(new Blackwhite());
        videoEditor.applyColor(new ColorAdapter(new RainbowColor()));
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
 *  3rd party library is wrapped in the adapter with same interface as client
 */
interface ThirdPartyLibrary{
    public void applyColor(Video video);
}

class RainbowColor implements ThirdPartyLibrary{
    @Override
    public void applyColor(Video video) {
        System.out.println("apply third party library color");
    }
}

class ColorAdapter implements Color{
    ThirdPartyLibrary thirdPartyColor;

    ColorAdapter(ThirdPartyLibrary c){
        this.thirdPartyColor = c;
    }
    @Override
    public void applyColor(Video video) {
        thirdPartyColor.applyColor(video);
    }
}
