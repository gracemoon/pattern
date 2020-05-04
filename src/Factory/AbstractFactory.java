package Factory;

interface Product{
    public void show();
}

class ConcreteProduct1 implements Product{
    public void show() {
        System.out.println("I am is concrete product 1.");
    }
}

class ConcreteProduct2 implements Product{
    public void show() {
        System.out.println("I am is concrete product 2.");
    }
}

interface Factory{
    public Product createProduct();
}


class concreteFactory1 implements Factory{
    public Product createProduct() {
        return new ConcreteProduct1();
    }
}

class concreteFactory2 implements Factory{
    public Product createProduct() {
        return new ConcreteProduct2();
    }
}
