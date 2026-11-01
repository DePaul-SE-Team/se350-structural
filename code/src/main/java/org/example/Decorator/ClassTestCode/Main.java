package org.example.Decorator.ClassTestCode;

public class Main {

    public static void main (String[] args){
        String inputText = "Happy Halloween!";

        PrintText basicPrint = new PrintAsciiText();

        basicPrint.print(inputText);

        PrintText hexDecorator = new PrintTextHexDecorator(basicPrint);

        hexDecorator.print(inputText);

        PrintText hexDecDec = new PrintTextHexDecorator(new PrintTextHexDecorator(new PrintAsciiText()));

        hexDecDec.print(inputText);
    }
}
