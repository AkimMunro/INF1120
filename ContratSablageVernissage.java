
/**
 * UQAM INF1120 - TP3
 * 
 * Dans le cadre du projet Expert Plancher
 * 
 * Une classe qui contient les details d'un contrat Expert-Plancher. inclut un client, une surface, le nombre d'escaliers et le type de vernis
 * les constructeurs pour le client, la surface, le nombre d'escaliers et le type de vernis
 * getters pour retourner client, la surface, le nombre d'escaliers et le type de vernis
 * 
 * @author Akim Munro
 * @version 2021-11-26
 *
 * MUNA29058309
 * @munro.akim@courrier.uqam.ca
 */

public class ContratSablageVernissage
{
    //attributs de classe-------------------------------------------------------------------------------
    private Client clientActuel;
    private float surfaceActuel;
    private Escalier escalierActuel;
    private Vernis vernisActuel;
    
    
    //debut des methodes--------------------------------------------------------------------------------
    /**
     * Initialise tous les attributs de la classe ContratSablageVernissage
     * @param clientActuel le client actuel
     * @param surfaceActuel la surface a sabler du client actuel
     * @param escalierActuel les details des marches du client actuel
     * @param vernisActuel les details de vernis du client actuel
     */
    public ContratSablageVernissage (Client clientActuel, float surfaceActuel, Escalier escalierActuel, Vernis vernisActuel){
        this.clientActuel = clientActuel;
        this.surfaceActuel = surfaceActuel;
        this.escalierActuel = escalierActuel;
        this.vernisActuel = vernisActuel;
    }
    
    /**
     * Obtient les details du client actuel
     * @return clientActuel les details du client actuel
     */
    public Client getClient(){
        return clientActuel;
    }
    
    /**
     * Obtient la surface a sabler du client actuel
     * @return surfaceActuel la surface a sabler du client actuel
     */
    public float getSurface(){
        return surfaceActuel;
    }
    
    /**
     * Obtient les details des escaliers du client actuel
     * @return escalierActuel les details des escaliers du client actuel
     */
    public Escalier getEscalier(){
        return escalierActuel;
    }
    
    /**
     * Obtient les details du type de vernis du cleient actuel
     * @return vernisActuel les details du type de vernis du cleient actuel
     */
    public Vernis getVernis(){
        return vernisActuel;
    }
}
