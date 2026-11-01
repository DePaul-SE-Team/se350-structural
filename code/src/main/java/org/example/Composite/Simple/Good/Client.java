package org.example.Composite.Simple.Good;

import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main (String [] args){
        Box pack = new Box();
        Box box1 = new Box();
        Box box2 = new Box();
        Box box3 = new Box();
        box1.addItem(new Microphone());
        box2.addItem(new Mouse());
        box3.addItem(new Keyboard());

        box3.addItem(box2);
        box1.addItem(box3);
        pack.addItem(box1);
        System.out.println(pack.getPrice() == (10+11+12));

    }
}

interface BoxComposite{
    public double getPrice();
}

class Box implements BoxComposite{

    List<BoxComposite> items = new ArrayList<>();

    public void addItem(BoxComposite item){
        items.add(item);
    }

    @Override
    public double getPrice() {
        double total = 0;
        for(var item : items){
            total += item.getPrice();
        }
        return total;
    }
}

class Microphone implements BoxComposite{
    @Override
    public double getPrice() {
        return 10;
    }
}

class Mouse implements BoxComposite{
    @Override
    public double getPrice() {
        return 11;
    }
}

class Keyboard implements BoxComposite{

    @Override
    public double getPrice() {
        return 12;
    }
}

