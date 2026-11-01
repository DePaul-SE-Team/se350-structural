package org.example.Decorator.PrintTextExample;

public class PrintAsciiText implements PrintText {
    public void print(String text)
    {
        System.out.println("Print ASCII: " + text);
    }
}