package org.example.Decorator.ClassTestCode;

import java.util.stream.Collectors;

public class PrintTextHexDecorator extends PrintTextDecorator {

    public PrintTextHexDecorator(PrintText txt) {
        super(txt);
    }

    public void print(String text){
        String hex = text.chars()
                .boxed()
                .map(x -> "0x" + Integer.toHexString(x))
                .collect(Collectors.joining(" "));

        printText.print(text + "====> HEX:" + hex);

    }
}
