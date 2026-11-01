package org.example.Decorator.classcode;

public class Button implements GuiComponent {
    @Override
    public void render() {
        System.out.println("Render a basic button");
    }
}
