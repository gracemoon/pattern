package Basic;

public class StringMethod {
    public static void main(String[] args) {
        String a="abc";
        String c="abc";
        String b=new String("abc");
        if(a==b){
            System.out.println("true");
        }else{
            System.out.println("false");
        }
        if(a==c){
            System.out.println("true");
        }else{
            System.out.println("false");
        }
        if(a.equals(b)){
            System.out.println("true");
        }else{
            System.out.println("false");
        }
    }
}