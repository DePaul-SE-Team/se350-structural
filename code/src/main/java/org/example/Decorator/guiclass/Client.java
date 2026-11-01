package org.example.Decorator.guiclass;

public class Client {

    public static void main(String[] args){

        GUIElement button = new Button();
        GUIElement textBox = new TextBox();
        button.render();
        textBox.render();

        GUIElement coloredButton = new ColorDecorator(button);
        coloredButton.render();
        GUIElement boldColoredButton = new FontDecorator(coloredButton);
        boldColoredButton.render();

        GUIElement boldColoredTextBox = new FontDecorator(new ColorDecorator(new TextBox()));
        boldColoredTextBox.render();


    }

}
