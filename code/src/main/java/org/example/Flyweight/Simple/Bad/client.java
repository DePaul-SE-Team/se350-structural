package org.example.Flyweight.Simple.Bad;

import java.util.ArrayList;
import java.util.List;

public class client {
    public static void main (String [] args){
        List<Crop> crops = new ArrayList<>();
        for (int i = 0 ; i < 100; i++){
            crops.add(new Crop(CropType.Carrot,1,1,new byte[4]));
        }
    }
}

/**
 * We have a farming game that includes different types of crops, such as potatoes, carrots and wheat.
 * Each crop is represented by a crop object,
 * that includes its x and y coordinates, the type of crop, and an icon.
 */

enum CropType{
    Potato,Carrot,Wheat
}

class Crop{
    CropType crop;
    float x;
    float y;
    byte [] icon;
    Crop(CropType crop, float x, float y, byte []  icon){
        this.crop = crop;
        this.x = x;
        this.y = y;
        this.icon = icon; // each one has 4KB, if you generate 1000 crops, it will take up 4KB * 1000 -
                          // you want to be able to share this
    }
    public void render(){
        System.out.println("does some rendering");
    }
}


