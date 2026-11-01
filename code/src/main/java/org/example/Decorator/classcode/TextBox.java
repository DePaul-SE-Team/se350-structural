package org.example.Decorator.classcode;

public class TextBox implements GuiComponent {
    @Override
    public void render() {
        System.out.println("Render a basic text box");
    }
}
