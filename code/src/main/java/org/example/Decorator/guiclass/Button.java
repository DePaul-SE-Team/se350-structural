package org.example.Decorator.guiclass;

public class Button implements GUIElement {
    @Override
    public void render() {
        System.out.println("Rendering a simple Button");
    }
}
