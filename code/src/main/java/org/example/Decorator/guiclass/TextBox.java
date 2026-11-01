package org.example.Decorator.guiclass;

public class TextBox implements GUIElement {
    @Override
    public void render() {
        System.out.println("Rendering a simple TextBox");
    }
}
