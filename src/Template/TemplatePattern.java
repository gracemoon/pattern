package Template;

public class TemplatePattern {
    public static void main(String[] args) {
        Template template=new SubTemplate();
        template.TemplateMethod();
    }
}

abstract class Template{
    public void TemplateMethod() {
        this.specificMethod();
        this.abstractMethod();
    }

    public void specificMethod() {
        System.out.println("specific method");
    }

    public abstract void abstractMethod();
}


class SubTemplate extends Template{
    public void abstractMethod() {
        System.out.println("abstract method");
    }
}
