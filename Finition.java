
/**
 * UQAM INF1120 - TP3
 * 
 * Dans le cadre du projet Expert Plancher
 * 
 * Une classe qui contient les types de finition disponibles
 * contient aussi:
 * les constructeurs pour le type de finition choisi
 * getters pour retourner le type de finition (String)
 * 
 * 
 * @author Akim Munro
 * @version 2021-12-03
 *
 * MUNA29058309
 * @munro.akim@courrier.uqam.ca
 */
public class Finition
{
    //Definir les constantes-------------------------------------------------------------------------------
    public static final int[] FINITION_ID = {1,2,3,4};
    public static final String[] FINITION_TYPE = {"Mat","Satiné","Semi-Lustré","Lustré"};

    //Declarationdes attributs-------------------------------------------------------------------------------
    private int finitionClient;

    //debut des methodes--------------------------------------------------------------------------------
    /**
     * Initialise l'attribut de l'identifiant du type de finition
     * @param finitionClient l'identifiant du type de finition choisi par le client
     */
    public Finition (int finitionClient){
        this.finitionClient = finitionClient;
    }

    /**
     * Obtient la chaine de carateres du type de finition choisi par le client
     * @return le type de finition choisi par le client
     */
    public String getFinition(){
        return FINITION_TYPE[Fonction.findIndex(FINITION_ID, finitionClient)];
    }
 
}
