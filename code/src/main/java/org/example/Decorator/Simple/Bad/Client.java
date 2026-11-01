package org.example.Decorator.Simple.Bad;

public class Client {
    public static void main (String [] args){
        Pizza pizza1 = new PizzaWithPepperoni();
        Pizza pizza2 = new PizzaWithVegetable();
        Pizza pizza3 = new PizzaWithVegetableAndPepperoni();
    }
}
interface Pizza{
    public void addToppings();
}

class PizzaWithPepperoni implements Pizza{

    @Override
    public void addToppings() {
        System.out.println("added toppings");
    }
}
    

class PizzaWithVegetable implements Pizza{
    @Override
    public void addToppings() {
        System.out.println("added vegetable");
    }
}

class PizzaWithVegetableAndPepperoni implements Pizza{
    @Override
    public void addToppings() {
        System.out.println("added vegetable and pepperoni");
    }
}