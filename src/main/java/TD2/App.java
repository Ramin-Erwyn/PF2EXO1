package TD2;

public class App {
    //Question 1.1
    public static void q11(){
    //pour le int
    Somme<Integer> sumInteger = (nb1,nb2) -> nb1+nb2;
    System.out.println("sum Integer est :"+sumInteger.somme(1,1));
    //pour le double
    Somme<Double> sumDouble = (nb1,nb2) -> nb1+nb2;
    System.out.println("sum Double est :"+sumDouble.somme(23.1,12.8));
    //pour le long
    Somme<Long> sumLong = (nb1,nb2) -> nb1+nb2;
    System.out.println("sum Long est :"+sumLong.somme(12345L,12345L));
    //pour le String
    Somme<String> sumString =(nb1,nb2) -> nb1+nb2;


}

    public static void main(String[] args) {
        System.out.println("#########question1###########");
        q11();
    }
}
