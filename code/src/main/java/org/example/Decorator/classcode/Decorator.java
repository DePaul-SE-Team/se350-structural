package org.example.Decorator.classcode;

public abstract class Decorator implements GuiComponent {

    public GuiComponent component;

    public Decorator(GuiComponent component) {
        this.component = component;
    }
    @Override
    public void render() {
        this.component.render();
    }
}
