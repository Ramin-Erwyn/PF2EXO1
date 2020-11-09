package TD2.exo2;

import java.util.function.Predicate;

public class APP {
    public static void q21()
    {
        //des new ppl
        Paire<Integer, Double> bob = new Paire<>(80, 15.0);
        Paire<Integer, Double> pat = new Paire<>(120, 123.0);
        Paire<Integer, Double> titi = new Paire<>(120, 13.0);
        Paire<Integer, Double> grominet = new Paire<>(20, 240.0);

        //predicat
        Predicate<Paire<Integer,Double>> TaillePetite = x -> x.fst < 100;
        Predicate<Paire<Integer,Double>> TailleGrande = x -> x.fst > 200;
        Predicate<Paire<Integer,Double>> TailleIncorrecte = TaillePetite.or(TailleGrande);
        Predicate<Paire<Integer,Double>> TailleCorrecte = TailleIncorrecte.negate();
        Predicate<Paire<Integer,Double>> PoidsLourd = x -> x.snd > 150.0;
        Predicate<Paire<Integer,Double>> PoidCorrect = PoidsLourd.negate();
        Predicate<Paire<Integer,Double>> AccesAutorise = TailleCorrecte.and(PoidCorrect);

        //pour bob l'éponge
        System.out.println("BOB");
        System.out.println("sa taille est t'elle trop petite < à 100cm  : " + TaillePetite.test(bob));
        System.out.println("sa taille est t'elle trop grande > à 200cm  : " + TailleGrande.test(bob));
        System.out.println("sa taille est t'elle incorrecte < à 100cm et  à 200cm : " + TailleIncorrecte.test(bob));
        System.out.println("est t'il trop lourd Poids trop lourd > à 150.0kg : " + PoidsLourd.test(bob));
        System.out.println("son accès et t'il  autorisé 100<=taille=<200 et poids<=150.0 : " + AccesAutorise.test(bob)+"\n");
        //pour pat
        System.out.println("PAT");
        System.out.println("sa taille est t'elle trop petite < à 100cm : " + TaillePetite.test(pat));
        System.out.println("sa taille est t'elle trop grande > à 200cm : " + TailleGrande.test(pat));
        System.out.println("sa taille est t'elle incorrecte < à 100cm et  à 200cm : " + TailleIncorrecte.test(pat));
        System.out.println("est t'il trop lourd Poids trop lourd > à 150.0kg : " + PoidsLourd.test(pat));
        System.out.println("son accès et t'il  autorisé 100<=taille=<200 et poids<=150.0 : " + AccesAutorise.test(pat)+"\n");
        //pour titi
        System.out.println("TITI");
        System.out.println("sa taille est t'elle trop petite < à 100cm  : "+ TaillePetite.test(titi));
        System.out.println("sa taille est t'elle trop grande > à 200cm  : " + TailleGrande.test(titi));
        System.out.println("sa taille est t'elle incorrecte < à 100cm et  à 200cm : " + TailleIncorrecte.test(titi));
        System.out.println("est t'il trop lourd Poids trop lourd > à 150.0kg : " + PoidsLourd.test(titi));
        System.out.println("son accès et t'il  autorisé 100<=taille=<200 et poids<=150.0 : " + AccesAutorise.test(titi)+"\n");
        //pour grominet
        System.out.println("grominet");
        System.out.println("sa taille est t'elle trop petite < à 100cm  : " + TaillePetite.test(grominet));
        System.out.println("sa taille est t'elle trop grande > à 200cm : "+ TailleGrande.test(grominet));
        System.out.println("sa taille est t'elle incorrecte < à 100cm et  à 200cm : " + TailleIncorrecte.test(grominet));
        System.out.println("est t'il trop lourd Poids trop lourd > à 150.0kg : " + PoidsLourd.test(grominet));
        System.out.println("son accès et t'il  autorisé 100<=taille=<200 et poids<=150.0 : " + AccesAutorise.test(grominet)+"\n");
    }

    public static void main(String[] args) {
        System.out.println("\n\n\nQuestion 1 de l'Exo 2\n\n\n");
        q21();
    }
}
