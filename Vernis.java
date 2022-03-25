
/**
 * UQAM INF1120 - TP3
 * 
 * Dans le cadre du projet Expert Plancher
 * 
 * Une classe qui contient les types de vernis disponibles
 * contient aussi:
 * les constructeurs pour le type de vernis choisi
 * getters pour retourner le type de vernis (String)
 * 
 * @author Akim Munro
 * @version 2021-12-03
 *
 * MUNA29058309
 * @munro.akim@courrier.uqam.ca
 */
public class Vernis
{
    //Definir les constantes---------------------------------------------------------------------------
    public static final int[] VERNIS_ID = {101,102,103};
    public static final String[] VERNIS_TYPE = {"Le vernis à base d’eau","Le vernis à base d’huile","Le vernis à l’alcool"};

    //Declarationdes attributs---------------------------------------------------------------------------
    private int vernisClient;
    private Finition finitionClient;
    private float prixVernisClient;

    //debut des methodes--------------------------------------------------------------------------------
    /**
     * Initialise l'attribut de l'identifiant du type de vernis choisi par le client ainsi que le prix par pied carre
     * @param vernisClient l'identifiant du type de vernis choisi par le client
     * @param prixVernisClient le prix par pied carre du type de vernis choisi
     */
    public Vernis (int vernisClient, float prixVernisCleint){
        this.vernisClient = vernisClient;
        this.prixVernisClient = prixVernisCleint;
    }
    
    /**
     * Initialise l'attribut de l'identifiant du type de vernis choisi par le client, le type de finition choisi, ainsi que le prix par pied carre
     * @param vernisClient l'identifiant du type de vernis choisi par le client
     * @param finitionClient le type de finition choisi par le client
     * @param prixVernisClient le prix par pied carre du type de vernis choisi
     */
    public Vernis (int vernisClient, Finition finitionClient, float prixVernisCleint){
        this.vernisClient = vernisClient;
        this.finitionClient = finitionClient;
        this.prixVernisClient = prixVernisCleint;
    }

    /**
     * Obtient l'identifiant du type de vernis
     * @return vernisClient l'identifiant du type de vernis
     */
    public int getIdVernis(){
        return vernisClient;
    }
    
    /**
     * Obtient la finition choisi
     * @return finitionClient le type de finition choisi par le client
     */
    public Finition getFinition(){
        return finitionClient;
    }
    
    /**
     * Obtient le prix par pied carre du type de vernis choisi
     * @return le prix du type de vernis par prix carre
     */
    public float getPrixVernis(){
        return prixVernisClient;
    }
    
    /**
     * Obtient la chaine de carateres du type de vernis choisi par le client
     * @return le type de vernis choisi par le client
     */
    public String getVernis(){
        return VERNIS_TYPE[Fonction.findIndex(VERNIS_ID, vernisClient)];
    }
        
}
