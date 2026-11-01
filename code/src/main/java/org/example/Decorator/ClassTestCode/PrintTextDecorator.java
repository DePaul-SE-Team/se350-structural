package org.example.Decorator.ClassTestCode;

public abstract class PrintTextDecorator implements PrintText{

    public  PrintText printText;

    public PrintTextDecorator(PrintText txt){
        this.printText = txt;
    }
}
