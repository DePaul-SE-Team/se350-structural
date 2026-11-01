package org.example.Decorator.CarExample;

public class SportsCar extends CarDecorator {

    public SportsCar(Car c) {
        super(c);
    }

    @Override
    public void assemble(){
        super.assemble();
        System.out.print("\n Adding features of Sports Car.");
    }
}
