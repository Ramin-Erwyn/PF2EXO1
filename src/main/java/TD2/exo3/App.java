package TD2.exo3;

import java.util.*;

import java.util.function.Predicate;


public class App {
    //------------q1----------
    static final Predicate<Etudiant> listeEtudiants = x -> true;
    public static void afficheSi(String entete, Predicate<Etudiant> predicate, Annee annee) {
        System.out.println(entete);
        annee.etudiants().forEach( (etudiant) -> {
            if(predicate.test(etudiant))
                System.out.println(etudiant);
        });
    }
    //Set<Etudiant> etudiants = Set.of(e1, e2, e3);
    //Map<Etudiant, Double> notes = Map.of(e1, 10.0, e2, 14.0, e3, 9.0);
//----------------q2--------
    private static final Set<Matiere> getAllMatiereFromYear(Annee annee) {
        Set<Matiere> rtr = new HashSet<>();
        for (UE ue : annee.ues()) {
            rtr.addAll(ue.ects().keySet());
        }
        return rtr;
    }

    static final Predicate<Etudiant> aDef = etudiant -> {
        Set<Matiere> matiere = getAllMatiereFromYear(etudiant.annee());
        for (Matiere mat :matiere) {
            if(!etudiant.notes().containsKey(mat))
                return true;
        }
        return false;
    };
    //---------------Q3------------
    //contain.value()>6 des douvbles
    static final  Predicate<Etudiant> aNoteEliminatoire = etudiant -> {
        for (Double note : etudiant.notes().values()) {
            if(note < 6)
                return true;
        }
        return false;
    };


    public static void main(String[] args) {
        Matiere m1 = new Matiere("MAT1");
        Matiere m2 = new Matiere("MAT2");
        UE ue1 = new UE("UE1", Map.of(m1, 2, m2, 2));
        Matiere m3 = new Matiere("MAT3");
        UE ue2 = new UE("UE2", Map.of(m3, 1));
        Annee a1 = new Annee(Set.of(ue1, ue2));
        Etudiant e1 = new Etudiant("39001", "Alice", "Merveille", a1);
        e1.noter(m1, 12.0);
        e1.noter(m2, 14.0);
        e1.noter(m3, 10.0);
        System.out.println(e1);
        Etudiant e2 = new Etudiant("39002", "Bob", "Eponge", a1);
        e2.noter(m1, 20.0);
        e2.noter(m3, 20.0);
        Etudiant e3 = new Etudiant("39003", "Charles", "Chaplin", a1);
        e3.noter(m1, 18.0);
        e3.noter(m2, 5.0);
        e3.noter(m3, 14.0);

        System.out.println("EXERCICE 3");
        System.out.println("question 1");
        afficheSi("** Tous les etudiants **", listeEtudiants, a1);


        System.out.println("question 2");
        afficheSi("** Défaillant **", aDef, a1);

        System.out.println("question 3");
        afficheSi("** ETUDIANTS note eliminé **", aNoteEliminatoire, a1);


    }


}
