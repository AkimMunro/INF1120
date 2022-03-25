
/**
 * UQAM INF1120 - TP3
 * 
 * Dans le cadre du projet Expert Plancher
 * 
 * Une classe qui contient le nom, prenom une adresse et un numero de telephone
 * contient aussi:
 * les constructeurs  pour chaque attribut
 * getters pour le nom, prenom et adresse
 * un getter pour le numero de telephone qui met le code regional dans des parentheses
 *
 * @author Akim Munro
 * @version 2021-11-26
 * 
 * MUNA29058309
 * @munro.akim@courrier.uqam.ca
 */
public class Client
{
    //Declaration des attributs
    private String nom;
    private String prenom;
    private String adresse;
    private String telephone;
    
    /**
     * Initialise tous les attributs
     * @param nom Le nom du client
     * @param prenom Le prenom du client
     * @param adresse L'adresse du client
     * @param telephone Le numero de telephone du client sous le format XXX XXX-XXXX
     */
    public Client (String nom, String prenom, String adresse, String telephone){
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.telephone = telephone;
    }
    
    /**
     * Retourne le nom
     * @return le nom du client
     */
    public String getNom(){
        return nom;
    }
    
    /**
     * Retourne le prenom
     * @return le prenom du client
     */
    public String getPrenom(){
        return prenom;
    }
    
    /**
     * Retourne l'adresse
     * @return l'adresse du client
     */
    public String getAdresse(){
        return adresse;
    }
    
    /**
     * Retourne le numero de telephone du client sous la forme (XXX) XXX-XXXX
     * @return le numero de telephone du client
     */
    public String getTelephone(){
        return "(" +telephone.substring(0,3) +")" + telephone.substring(3,12);
    }
}
