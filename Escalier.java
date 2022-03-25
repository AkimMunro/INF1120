
/**
 * UQAM INF1120 - TP3
 * 
 * Dans le cadre du projet Expert Plancher
 * 
 * Une classe qui contient les details sur le nombre de marches et contremarches choisi par le client ainsi que le prix de ces derniers
 * contient aussi:
 * les constructeurs pour le nombre de marches et contremarches ainsi que leur prix
 * getters pour retourner le nombre de marches et contremarches ainsi que leur prix
 * 
 * @author Akim Munro
 * @version 2021-11-26
 *
 * MUNA29058309
 * @munro.akim@courrier.uqam.ca
 */
public class Escalier
{
    //attributs de classe----------------------------------------------------------------------------------------------------
    private int marchesClient;
    private int contremarchesClient;
    
    //variables de classe-------------------------------------------------------------------------------------------------
    private float prixMarche;
    private float prixContremarche;
    
    
    //debut des methodes--------------------------------------------------------------------------------
    /**
     * Initialise tous les attributs de la classe escalier
     * @param marchesClient le nombre de marches du client
     * @param contremarchesClient le nombre de contremarches du client
     * @param prixMarche le prix de chaque marche
     * @param prixContremarche le prix de chaque contremarche
     */
    public Escalier (int marchesClient, int contremarchesClient, float prixMarche, float prixContremarche){
        this.marchesClient = marchesClient;
        this.contremarchesClient = contremarchesClient;
        this.prixMarche = prixMarche;
        this.prixContremarche = prixContremarche;
    }
    
    /**
     * Obtient le nombre de marches
     * @return marchesClient le nombre de marches
     */
    public int getMarches(){
        return marchesClient;
    }
    
    /**
     * Obtient le nombre de contremarches
     * @return contremarchesClient le nombre de contremarches
     */
    public int getContremarches(){
        return contremarchesClient;
    }
    
    /**
     * Obtient le prix par marche
     * @return prixMarche le prix d'une marche
     */
    public float getPrixMarches(){
        return prixMarche;
    }
    
    /**
     * Obtient le prix par contremarche
     * @return prixContremarche le prix d'une contremarche
     */
    public float getPrixContremarches(){
        return prixContremarche;
    }
    
}
