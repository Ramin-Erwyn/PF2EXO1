package TD2.exo3;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
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

    //--------------q4-------------
    public static Double moyenne(Etudiant etudiant) {
/* moyenne moyenneEtudiant = e -> {
            Predicate<Etudiant,Annee> aDEF = (b,a) -> {
                if (b.notes().containsKey(m1) && b.notes().containsKey(m2) && b.notes().containsKey(m3))
                    return false;
                return true;
            };
*/
        //  if (aDEF.test(e,a1)) return null; double boucle
        /*Double numerateur = 0D;
        Double denominateur = 0D;

        for (UE ue : a1.ues()) {
            for (Matiere mapKey : ue.ects().keySet()) {
                numerateur = numerateur + Etudiant.notes().get(mapKey) * ue.ects().get(mapKey);
                denominateur = denominateur + ue.ects().get(mapKey);
            }
        }
        return numerateur / denominateur;
    };*/

        if(aDef.test(etudiant))
            return null;

        Double numerateur = 0D;
        Double denominateur = 0D;
        Map<Matiere, Integer> LesMatECTS = getAllMatiereFromYear(Etudiant); //les matière de l'anne pour les etudiants todo

        //for (Matiere matiere : ue.ects().keySet()) {
        for (Matiere matiere : LesMatECTS.keySet()) {

            numerateur += etudiant.notes().get(matiere) * LesMatECTS.get(matiere);
            denominateur += LesMatECTS.get(matiere);
        }
        return numerateur / denominateur;
    }
    //----------------q5-------------------
//{probleme NullPointerException sur l'etudiant de moin de 6 avec un vieux 5}  à voir todo
    static final Predicate<Etudiant> naPasLaMoyennev1 = e -> moyenne(e) < 10.0;


    //----------------q6-------------- pareil que avant mais  n’ayant pas la moyenne
    static final Predicate<Etudiant> naPasLaMoyennev2 = e -> moyenne(e) == null || moyenne(e) < 10.0 ;
    /* A VOIR AVEC Mr POizat pour c'est pas bon todo test
     Predicate<Etudiant,Annee> naPasLaMoyennev2 = (e,a1) -> {
            Double laMoyenne = moyenneEtudiant.moyenne(e);
            if (laMoyenne==null || laMoyenne<10) return true;
            return false;
        };
     */


    //--------------q7-----------------savoir si un étudiant va en session 2.
    static final Predicate<Etudiant> session2v1 = e -> aDef.or(aNoteEliminatoire).or(naPasLaMoyennev1).test(e);//le or ou le not
    // --------------Q8-----------------
//cours avec le truc google import consumer etudiant probleme todo
    public static void afficheSiv2(String entete, Predicate<Etudiant> predicate, Annee annee, Consumer<Etudiant> affichageE) {
        System.out.println(entete);
        annee.etudiants().forEach(e -> {
            if(predicate.test(e))
                affichageE.accept(e);
        });
        System.out.println("\n");
    }
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

        System.out.println("q31");
        afficheSi("** Tous les etudiants **", listeEtudiants, a1);
        System.out.println("q32");
        afficheSi("** Défaillant **", aDef, a1);
        System.out.println("q33");
        afficheSi("** ETUDIANTS note eliminé **", aNoteEliminatoire, a1);
        System.out.println("q34");
        System.out.println(moyenne(e2));
        System.out.println("q35");
        afficheSi("** ETUDIANTS pas la moyenne **", naPasLaMoyennev1, a1);
        System.out.println("q36");
        afficheSi("** ETUDIANTS pas la moyenne **", naPasLaMoyennev2, a1);
        System.out.println("q37");
        System.out.println("q38");
        // afficheSiv2("** TOUS LES ETUDIANTS **", listeEtudiants, a1,listeEtudiants);//same que la 1 beug
        //afficheSi2("Tous les etidiants", tousLesEtudiantsv2, a1);
    }


}
