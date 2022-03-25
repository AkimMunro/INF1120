import java.util.Date;
import java.text.SimpleDateFormat;
/**
 * UQAM INF1120 - TP3
 * 
 * Dans le cadre du projet Expert Plancher
 * 
 * Une classe qui contient les details necessaire pour creer une facture client
 * contient les constantes relatives a l'entreprise (types de paiement dipsonible, taux de taxes, coordonees de l'entreprise, l'unite d'argent, le format de la date)
 * les attributs relatifs au client (le numero de facture, le mode de pqiement choisi, le Contrat, tous les sous totaux, le total de la facture)
 * constructeurs
 * getters
 * methodes pour calculer les sous-totaux variees
 * methode pour afficher la facture
 * 
 * Requiert des comopsantes d'affichage dans la classe Message
 * 
 * @author Akim Munro
 * @version 2021-12-03
 *
 * MUNA29058309
 * @munro.akim@courrier.uqam.ca
 */
public class Facture
{
    //Declaration des constantes------------------------------------------

    //Declaration des constantes relatifs au type de paiement
    public static final char[] PAIEMENT_ID = {'C', 'D', 'R'};
    public static final String[] PAIEMENT_TYPE = {"Comptant","Débit","Crédit"};
    //Declaration des constantes relatifs aux taxes
    public static final float TAXE_TPS = 0.05f;
    public static final float TAXE_TVQ = 0.09975f;
    //Declaration des constantes relatifs a l'entreprise
    public static final String EP_NOM = "Expert-Plancher";
    public static final String EP_ADRESSE = "1800 boulevard Java, Informatique, QC";
    public static final String EP_TELEPHONE = "(450) 281-0011";
    //Declaration des constantes relatifs a l'unite d'argent
    public static final char UNITE_ARGENT = '$';
    //Declaration des constantes relatifs a la date
    public static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

    
    //declaration des attributs et variables-------------------------------------------------------------
    private static int numeroFacture = 0; //numero de la facture
    private char typePaiement; //type de paiement choisi par le client
    private ContratSablageVernissage contrat;
    private float sousTotalVernissage;
    private float sousTotalMarches;
    private float sousTotalContremarches;
    private float sousTotal;
    private float taxeTPS;
    private float taxeTVQ;
    private float total;

    
    //debut des methodes--------------------------------------------------------------------------------
    /**
     * Initialise les attributs de la classe Facture
     * @param contrat le contrat actuel
     * @param typePaiement la type de paiement du client actuel
     */
    public Facture (ContratSablageVernissage contrat, char typePaiement){
        this.contrat = contrat;
        this.typePaiement = typePaiement;
    }

    /**
     * Obtient le total de la facture
     * @return total le montant total de la facture
     */
    public float getTotal(){
        return total;
    }
    

    /**
     * Obtient la chaine de carateres du mode de paiement choisi par le client
     * @return le mode de paiement choisi par le client
     */
    public String getPaiement(){
        return PAIEMENT_TYPE[Fonction.findIndex(PAIEMENT_ID, Character.toUpperCase(typePaiement))];
    }

    /**
     * calcule le sous total du sablage et vernissage selon le nombre de pieds carrees et le prix par pied carre du vernis applique
     */
    public void calculerSousTotalVernissage(){

        sousTotalVernissage = contrat.getSurface() * contrat.getVernis().getPrixVernis();

    }

    /**
     * calcule le sous total du cout des marches 
     */
    public void calculerSousTotalMarches(){

        sousTotalMarches = contrat.getEscalier().getMarches() * contrat.getEscalier().getPrixMarches();

    }

    /**
     * calcule le sous total du cout des contremarches 
     */
    public void calculerSousTotalContremarches(){

        sousTotalContremarches = contrat.getEscalier().getContremarches() * contrat.getEscalier().getPrixContremarches();

    }

    /**
     * calcule le sous total du cout de la surface a sabler et vernir, les marches et contremarches 
     */
    public void calculerSousTotal(){

        sousTotal = sousTotalVernissage + sousTotalMarches + sousTotalContremarches;

    }

    /**
     * calcule le montant de taxes TPS 
     */
    public void calculerTaxeTPS(){

        taxeTPS = sousTotal * TAXE_TPS;

    }

    /**
     * calcule le montant de taxes TVQ
     */
    public void calculerTaxeTVQ(){

        taxeTVQ = sousTotal * TAXE_TVQ;

    }

    /**
     * calcule le total du cout du sous total et des deux taxes 
     */
    public void calculerTotal(){

        total = sousTotal + taxeTPS + taxeTVQ;

    }

    /**
     * Incremente le numero de la facture
     * 
     */
    public void incrementerNumeroFacture(){
        numeroFacture = numeroFacture+1;
    }
    
    /**
     * Affiche la facture
     */
    public void afficher() {
        
        

        Date dateHeureSysteme = new Date();
        //entete de facture
        System.out.println("\n" +Message.TIRETS_LONG);
        System.out.println("  "+EP_NOM);
        System.out.println("  "+EP_ADRESSE + "     " +EP_TELEPHONE);
        System.out.println("  "+Message.FACTURE_NO +numeroFacture +"\t\t\t\t    " +Message.DATE_HEURE +SIMPLE_DATE_FORMAT.format(dateHeureSysteme)); 
        System.out.println(Message.TIRETS_LONG +"\n");
        
        //partie client
        System.out.println("  "+Message.FACTURE_NOM +contrat.getClient().getNom() +" " +contrat.getClient().getPrenom() +"\t\t" +Message.FACTURE_TELEPHONE +contrat.getClient().getTelephone());
        System.out.println("  "+Message.FACTURE_ADRESSE +contrat.getClient().getAdresse());
        System.out.print("\n");

        System.out.println("  " +Message.FACTURE_VERNIS +contrat.getVernis().getVernis() +Message.FINI_0 +contrat.getVernis().getFinition().getFinition());  //choix de finition pour le message sur la facture

        System.out.println("  "+Message.FACTURE_PAIEMENT + getPaiement());  //choix de paiement du client
        System.out.print("\n");

        System.out.printf("  %s \t\t%6.2f %s %3.2f%c =%8.2f%c \n", Message.FACTURE_SURFACE, contrat.getSurface(), Message.PC, contrat.getVernis().getPrixVernis(), UNITE_ARGENT, sousTotalVernissage , UNITE_ARGENT);  //details pour la surface

        if(contrat.getEscalier().getMarches() > 0){  //inclure marches juste si present

            System.out.printf("  %s \t\t\t%d %c %4.2f%c %c %6.2f%c \n", Message.FACTURE_MARCHES, contrat.getEscalier().getMarches(), 'x', contrat.getEscalier().getPrixMarches(), UNITE_ARGENT, '=', sousTotalMarches, UNITE_ARGENT);  //details pour les marches

            System.out.printf("  %s \t\t%d %c %4.2f%c %c %6.2f%c \n", Message.FACTURE_CONTREMARCHES, contrat.getEscalier().getContremarches(), 'x', contrat.getEscalier().getPrixContremarches() , UNITE_ARGENT, '=',  sousTotalContremarches, UNITE_ARGENT);  //details pour les contremarches
        }

        System.out.printf("\n  %s \t\t\t       %8.2f%c \n", Message.FACTURE_SOUS_TOTAL, sousTotal, UNITE_ARGENT);  //afficher sous total
        System.out.printf("  %s \t\t\t       %8.2f%c \n", Message.FACTURE_TPS, taxeTPS, UNITE_ARGENT);  //afficher tps
        System.out.printf("  %s \t\t\t       %8.2f%c \n", Message.FACTURE_TVQ, taxeTVQ, UNITE_ARGENT);  //afficher tvq
        System.out.printf("  %s \t\t       %8.2f%c \n", Message.FACTURE_TOTAL, total, UNITE_ARGENT);  //afficher total
        System.out.println(Message.TIRETS_COURT);
        System.out.println("\t\t      "+Message.FACTURE_MERCI);

    }

}
