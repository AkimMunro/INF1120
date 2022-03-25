import java.util.Date;
import java.text.SimpleDateFormat;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * UQAM INF1120 - TP3
 * 
 * Dans le cadre du projet Expert Plancher
 * 
 * Une classe qui s'occupe de se souvenir de toutes les ventes effectues durant une session et que sauvegarde ces informations une fois l'application est fermee
 * les informations sonts sauvegardes dans le fichier nomme dans FIC_STAT_VENTES
 * 
 *
 * @author Akim Munro
 * @version 2021-12-03
 * 
 * MUNA29058309
 * @munro.akim@courrier.uqam.ca
 */
public class StatistiquesVentes
{
    
    //debut des constantes--------------------------------------------------------------------------------
    public static final String NOM_ENTREPRISE = "Expert-Plancher";
    public static final String FIC_STAT_VENTES = "StatistiquesVentes.txt";
    public static final SimpleDateFormat FORMATTER = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

    // declaration d'attributs----------------------------------------------------------------------------
    private static double totalToutesFactures = 0;
    private static int[] sommeVernis = {0,0,0};

    //debut des methodes--------------------------------------------------------------------------------
    /**
     * Incremente le total de la variable sommeVernis de 1 selon l'identifiant passe
     * @param idVernis l'identifiant a incrementer
     */
    public static void incrementerVernis(int idVernis){
        int index = Fonction.findIndex(Vernis.VERNIS_ID,idVernis);
        if ( index != -1){
            sommeVernis[index]++;
        }

    }

    /**
     * ajoute le total d'une facture passe a la somme totale de toutes les factures
     * @param totalFacture le total a ajouter au total
     */
    public static void sommerTotal(float totalFacture){
        totalToutesFactures = totalToutesFactures + totalFacture;
    }

    /**
     * affiche la somme de toutes les totals
     */
    public static void afficherTotal(){
        
        Date dateHeureSysteme = new Date();
        System.out.println("");
        System.out.println(Message.TIRETS_MOYEN);
        System.out.printf("  %s\n",NOM_ENTREPRISE);
        System.out.printf("  %s %s\n",Message.DATE_HEURE, FORMATTER.format(dateHeureSysteme));  
        System.out.println(Message.TIRETS_MOYEN +"\n");
        System.out.printf("  %s  %8.2f%c\n",Message.MONTANT_FACTURES,totalToutesFactures,Facture.UNITE_ARGENT);
        System.out.println("\n" +Message.TIRETS_MOYEN);

    }

    /**
     * affiche la somme de tous les types de vernis
     */
    public static void afficherVernisTotal(){

        Date dateHeureSysteme = new Date();
        System.out.println("");
        System.out.println(Message.TIRETS_MOYEN);
        System.out.printf("  %s\n",NOM_ENTREPRISE);
        System.out.printf("  %s %s\n",Message.DATE_HEURE,FORMATTER.format(dateHeureSysteme));  
        System.out.println(Message.TIRETS_MOYEN +"\n");
        System.out.printf("  %s\n",Message.VERNIS_CLIENTS);
        System.out.printf("  %s\n\n",Message.ETOILES);
        System.out.printf("  %s       %d\n",Vernis.VERNIS_TYPE[0], sommeVernis[0]);
        System.out.printf("  %s     %d\n",Vernis.VERNIS_TYPE[1], sommeVernis[1]);
        System.out.printf("  %s         %d\n",Vernis.VERNIS_TYPE[2], sommeVernis[2]);
        System.out.println("\n" +Message.TIRETS_MOYEN);
    }

    /**
     * ecrit les sommes des statistiques de vents au fichier specifie par FICHIER_STATISTIQUE
     */
    public static void ecrireStatistiques(){

        try{
            
            PrintWriter fluxPrintWriter = new PrintWriter(FIC_STAT_VENTES); 
            
            int i = 0;
            
            for(String ligne: Vernis.VERNIS_TYPE){
                fluxPrintWriter.println(ligne +"|"+ sommeVernis[i]);
                i++;
            }
            
            fluxPrintWriter.close();
            
        } catch (IOException e) {
            System.out.println("Erreur d'entrée / sortie");
        }
        
    }

    

}
