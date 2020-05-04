package AbstractFactory;
/**
 * ProductFactory
 */
public class ProductFactory {

    public static void main(String[] args) {
        Factory factory=new ConcreteFactory();
        Product phone=factory.createProduct1();
        Product Television=factory.createProduct2();
        phone.function();
        Television.function();
    }
}


interface Product{
    public void function();
}


class Phone implements Product{
    public void function() {
        System.out.println("call phone");
    }
}

class Television implements Product{
    public void function() {
        System.out.println("watch TV");
    }
}


interface Factory{
    public Product createProduct1();
    public Product createProduct2();
}


class ConcreteFactory implements Factory{
    public Product createProduct1() {
        return new Phone();
    }

    public Product createProduct2() {
        return new Television();
    }
}