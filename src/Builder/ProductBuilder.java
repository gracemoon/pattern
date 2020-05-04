package Builder;

public class ProductBuilder {
    public static void main(String[] args) {
        Builder builder;
        builder=new Builder1();
        Director director=new Director(builder);
        Product product=director.management();
        product.show();
    }
}


class Product{
    private String part1;
    private String part2;
    private String part3;

    public void setPart1(String part) {
        this.part1=part;
    }

    public void setPart2(String part) {
        this.part2=part;
    }

    public void setPart3(String part) {
        this.part3=part;
    }

    public void show(){
        System.out.println(this.part1);
        System.out.println(this.part2);
        System.out.println(this.part3);
    }
}


abstract class Builder{
    protected Product product=new Product();
    public abstract void buildPart1();
    public abstract void buildPart2();
    public abstract void buildPart3();
    public Product getInstance(){
        return this.product;
    }
}


class Builder1 extends Builder{
    public void buildPart1() {
        this.product.setPart1("builder 1");
    }
    public void buildPart2() {
        this.product.setPart2("builder 1");
    }
    public void buildPart3() {
        this.product.setPart3("builder 1");
    }
}

class Builder2 extends Builder{
    public void buildPart1() {
        this.product.setPart1("builder 2");
    }
    public void buildPart2() {
        this.product.setPart2("builder 2");
    }
    public void buildPart3() {
        this.product.setPart3("builder 2");
    }
}


class Director{
    private Builder builder;
    public Director(Builder builder){
        this.builder=builder;
    } 
    public Product management(){
        builder.buildPart1();
        builder.buildPart2();
        builder.buildPart3();
        return builder.getInstance();
    }
}
