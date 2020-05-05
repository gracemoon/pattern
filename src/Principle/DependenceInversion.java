package Principle;

public class DependenceInversion{
    public static void main(String[] args) {
        Customer customer=new ChineseCustomer();
        Shop mcDonald=new McDonald();
        customer.buy(mcDonald);
        Shop kfc=new KFC();
        customer.buy(kfc);
    }
}


interface Shop{
    public void sell();
}

class McDonald implements Shop{
    public void sell() {
        System.out.println("McDonald is selling.");
    }
}

class KFC implements Shop{
    public void sell() {
        System.out.println("KFC is selling.");
    }
}


interface Customer{
    public void buy(Shop shop);
}


class ChineseCustomer implements Customer{
    public void buy(Shop shop) {
        shop.sell();
    }
}