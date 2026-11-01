package org.example.Decorator.PrintTextExample;

public class PrintAddedText extends PrintTextDecorator{

    public PrintAddedText(PrintText inner){
        super(inner);
    }

    @Override
    public void print(String text){

        inner.print("Testing Decorator Pattern \n" + text);
    }
}
