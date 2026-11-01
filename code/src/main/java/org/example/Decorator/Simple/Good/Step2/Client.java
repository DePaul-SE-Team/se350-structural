package org.example.Decorator.Simple.Good.Step2;

public class Client {
    public static void main (String [] args){
        Pizza pizza = new PlainPizza();
        Pizza pepperoniPizza = new PepperoniWrapper(pizza);
        pepperoniPizza.addToppings();
    }
}

// you have some object with some kind of feature,
// and you want to decorate that object with optional feature, then you should create an
// common interface and declare commonn feature there (the feature you want to decorate).
interface Pizza{
    public void addToppings();
}

// everything starts with the wrappee
class PlainPizza implements Pizza{
    @Override
    public void addToppings() {
        System.out.println("simple pizza: no toppings");
    }
}

class PepperoniWrapper implements Pizza{
    Pizza pizza;
    PepperoniWrapper(Pizza pizza){
        this.pizza = pizza;
    }

    @Override
    public void addToppings() {
        System.out.println("added pepperoni");
        this.pizza.addToppings();
    }
}

