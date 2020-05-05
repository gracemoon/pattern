package Principle;

public class LowofDemeter {
    public static void main(String[] args) {
        Star star=new Singer("Madonna");
        Fans fans=new GirlFans("Monica");
        Company company=new TeleVisionCompany("Elijah");
        Broker broker=new Broker();
        broker.setStar(star);
        broker.setCompany(company);
        broker.setFans(fans);
        broker.FansMeeting();
        broker.business();
    }
}



interface Star{
    public String getName();
}


class Singer implements Star{
    private String name;
    public Singer(String name){
        this.name=name;
    }
    public String getName(){
        return this.name;
    }
}

interface Fans{
    public String getName();
}


class GirlFans implements Fans{
    private String name;
    public GirlFans(String name){
        this.name=name;
    }
    public String getName(){
        return this.name;
    }
}


interface Company{
    public String getName();
}

class TeleVisionCompany implements Company{
    private String name;
    public TeleVisionCompany(String name){
        this.name=name;
    }
    public String getName(){
        return this.name;
    }
}


class Broker{
    private Company company;
    private Star star;
    private Fans fans;

    public void setCompany(Company company) {
        this.company=company;
    }
    public void setStar(Star star) {
        this.star=star;
    }
    public void setFans(Fans fans) {
        this.fans=fans;
    }
    public void FansMeeting() {
        System.out.println(this.star.getName()+" --- "+this.fans.getName());
    }
    public void business() {
        System.out.println(this.star.getName()+" --- "+this.company.getName());
    }
}