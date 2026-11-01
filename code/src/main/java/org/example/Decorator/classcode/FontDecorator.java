package org.example.Decorator.classcode;

public class FontDecorator extends Decorator {
    public FontDecorator(GuiComponent component) {
        super(component);
    }

    @Override
    public void render() {
        super.render();
        System.out.println("Adding font to the component");
    }
}
