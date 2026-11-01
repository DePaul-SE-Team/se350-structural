package org.example.Composite.Simple.Bad;

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
        box3.addItem(new KeyBoard());

        box2.addItem(box3);
        pack.addItem(box1);
        pack.addItem(box2);

        System.out.println(pack.calculateTotal() == (10+11+12));
    }
}

class Box{
    private List<Object> items = new ArrayList();
    public void addItem(Object item){
        items.add(item);
    }

    // this is pretty ugly
    public double calculateTotal(){
        double total = 0;
        for (var item : items){
            if (item instanceof Microphone){
                total += ((Microphone) item).getPrice();
            }
            else if (item instanceof KeyBoard){
                total += ((KeyBoard) item).getPrice();
            }
            else if (item instanceof Mouse){
                total += ((Mouse) item).getPrice();
            }
            else if (item instanceof Box){
                total += ((Box) item).calculateTotal();
            }
        }
        return total;
    }
}

class KeyBoard{
    public double getPrice(){
        return 10;
    }
}
class Mouse{
    public double getPrice(){
        return 11;
    }
}
class Microphone{
    public double getPrice(){
        return 12;
    }
}