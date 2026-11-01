package org.example.Flyweight.Simple.Good;

import java.util.ArrayList;
import java.util.HashMap;

public class Client {
    public static void main (String [] args){
        ArrayList<Crop> crops = new ArrayList<>();
        FactoryFlyweight factory = new FactoryFlyweight();
        for (int  i = 0; i < 100 ;i++){
            crops.add(new Crop(factory.getIcon(CropType.Potato),0,0));
        }
    }
}
/**
 * We have a farming game that includes different types of crops, such as potatoes, carrots and wheat.
 * Each crop is represented by a crop object,
 * that includes its x and y coordinates, the type of crop, and an icon.
 */

enum CropType{
    Potato,Carrot,Whheat
}

class Crop{
    float x;
    float y;
    CropFlyweight icon;

    Crop(CropFlyweight crop, float x, float y){
        this.x = x;
        this.y = y;
        this.icon = crop;
    }
    public void render(){
        System.out.println("does some rendering");
    }

}

class CropFlyweight {
    byte [] icon;
    CropType cropType;
    CropFlyweight(CropType t){
        this.cropType = t;
        this.icon = new byte[4];
    }
    public CropType getCropType(){
        return this.cropType;
    }
}

class FactoryFlyweight{
    HashMap<CropType,CropFlyweight> collections =  new HashMap<>();
    public CropFlyweight getIcon(CropType t){
        if (!collections.containsKey(t)){
            collections.put(t, new CropFlyweight(t));
        }
        return collections.get(t);
    }
}



