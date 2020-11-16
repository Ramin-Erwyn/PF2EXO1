package TD2.exo3;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;

public class App {
    public static void afficheSi2(String entete,Predicate<Etudiant> condition, Annee annee) {
        System.out.println(String.format("** %s", entete));
        for (Etudiant e : annee.etudiants()) {
            if (condition.test(e)) {
                System.err.println(e);

            }

        }
    }
        /*
        Iterator<Etudiant> itEtudiants =annee.etudiant().

                System.out.println(String.format("** %s",entete));
                annee.etudiant().forEach(e -> {
                if(condition.test(e)){
                System.out.prinln(e);
        }
        });

        * */



    public static void q31(){
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
        e2.noter(m1, 14.0);
        e2.noter(m3, 14.0);
        Etudiant e3 = new Etudiant("39003", "Charles", "Chaplin", a1);
        e3.noter(m1, 18.0);
        e3.noter(m2, 5.0);
        e3.noter(m3, 14.0);

        List<Etudiant> listeEtudiants = new ArrayList<>();
        listeEtudiants.add(e1);
        listeEtudiants.add(e2);
        listeEtudiants.add(e3);

Set<Etudiant> etudiants = Set.of(e1,e2,e3);
Map<Etudiant,Double> notes = Map.of(e1,10.0,e2, 14.0,e3,9.0);


        Predicate<Etudiant> tousLesEtudiant = new Predicate<>() {
            @Override
            public boolean test(Etudiant t) {
                return true;
            }
        };
        Predicate<Etudiant> tousLesEtudiantsv2=etudiant -> true;
        afficheSi2("Tous les etidiants",tousLesEtudiantsv2,a1);
    }
    public static void q32(){
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
        e2.noter(m1, 14.0);
        e2.noter(m3, 14.0);
        Etudiant e3 = new Etudiant("39003", "Charles", "Chaplin", a1);
        e3.noter(m1, 18.0);
        e3.noter(m2, 5.0);
        e3.noter(m3, 14.0);

        List<Etudiant> listeEtudiants = new ArrayList<>();
        listeEtudiants.add(e1);
        listeEtudiants.add(e2);
        listeEtudiants.add(e3);

        Set<Etudiant> etudiants = Set.of(e1,e2,e3);
        Map<Etudiant,Double> notes = Map.of(e1,10.0,e2, 14.0,e3,9.0);


        Predicate<Etudiant> tousLesEtudiant = new Predicate<>() {
            @Override
            public boolean test(Etudiant t) {
                return true;
            }
        };
        afficheSi2(ENTETE_TOUS,etudiant -> true,a1);
        Predicate<Etudiant> estDefaillant=etudiant e ->{

        };
        afficheSi2("Tous les etidiants",estDefaillant,a1);
    }

    public static void main(String[] args) {
        System.out.println("EXERCICE 3");
        q31();
    }
}
