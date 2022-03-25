import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
/**
 * UQAM INF1120 - TP3
 * 
 * Dans le cadre du projet Expert Plancher
 * 
 * Une classe qui s'occupe de la lecture des fichiers qui contiennent les prix des services offerts par Expert-Plancher
 * le fichier Vernis.txt contient les prix des types de vernis
 * le fichier Escalier.txt contient les prix des marches et contremarches
 * 
 *
 * @author Akim Munro
 * @version 2021-12-03
 * 
 * MUNA29058309
 * @munro.akim@courrier.uqam.ca
 */
public class ListeDesPrix
{
    //constaqntes de declaration des noms de fichiers avec les prix----------------------------------------
    public static final String FIC_VERNIS = "Vernis.txt";
    public static final String FIC_ESCALIER = "Escalier.txt";
        
    //arrtibuts de classe--------------------------------------------------------------------------------
    private static Vernis[] vernisDisponible = new Vernis[Vernis.VERNIS_ID.length]; 
    private static Escalier escalierDisponible;

    //debut des methodes--------------------------------------------------------------------------------
    
    /**
     * Lis le contenu de FIC_VERNIS, stocke les donnees  dans la variable Vernis(int XXX, float Y.YY)
     * le fichier a le format:
     * 
     * Identifiant du vernis|prix par pied carré
     * XXX|Y.YY
     * 
     */
    public static void lireVernis(){
        int i = 0;
        Vernis vernisTemp;

        try {

            BufferedReader fluxTampon = new BufferedReader(new FileReader(FIC_VERNIS));

            // lecture ligne par ligne
            for(String ligne ; (ligne = fluxTampon.readLine()) != null;){

                
                if(!ligne.trim().isEmpty() && ligne.trim().charAt(0) == '1'){  //p-e a changer, on chereche le caractere '1' pour voir si la ligne peut etre lu et interpretee comme un prix
                    String [] parties = ligne.split("\\|"); 
                    int type = Integer.parseInt(parties[0].trim());
                    float prix = Float.parseFloat(parties[1].trim());
                    vernisTemp = new Vernis(type,prix);
                    vernisDisponible[i] = vernisTemp;

                    i++;
                }
            }
            // Fermeture d'un fichier

            fluxTampon.close();

        } catch (FileNotFoundException e) {
            System.out.println("Erreur : Fichier non trouvé ");

        } catch (IOException e) {
            System.out.println("Erreur d'entrée / sortie");
        }
    }

    /**
     * Lis le contenu de FIC_ESCALIER, stocke les donnees  dans la variable Escalier(int AAA, float B.BB,int CCC, float D.DD)
     * le fichier a le format:
     * 
     * Nombre de marches|prix par marche|Nombre de contremarches|prix par contremarche
     * AAA|B.BB|CCC|D.DD
     * 
     */
    public static void lireEscaliers(){
       
        try {

            BufferedReader fluxTampon = new BufferedReader(new FileReader(FIC_ESCALIER));

            // lecture ligne par ligne
            for(String ligne ; (ligne = fluxTampon.readLine()) != null;){

                // ligne = fluxTampon.readLine(); 
                if(!ligne.trim().isEmpty() && ligne.trim().charAt(0) == '1'){ //p-e a changer, on chereche le caractere '1' pour voir si la ligne peut etre lu et interpretee comme un prix
                    
                    String [] parties = ligne.split("\\|"); 
                    int nombreMarches = Integer.parseInt(parties[0].trim());
                    float prixMarches = Float.parseFloat(parties[1].trim());
                    int nombreContremarches = Integer.parseInt(parties[2].trim());
                    float prixContremarches = Float.parseFloat(parties[3].trim());
                    escalierDisponible = new Escalier(nombreMarches,nombreContremarches,prixMarches,prixContremarches);
                    
                }
            }
            // Fermeture d'un fichier

            fluxTampon.close();

        } catch (FileNotFoundException e) {
            System.out.println("Erreur : Fichier non trouvé ");

        } catch (IOException e) {
            System.out.println("Erreur d'entrée / sortie");
        }
    }
    
    /**
     * Obtient la chaine de carateres du type de vernis choisi par le client
     * @param idVernis l'identifiant du type de vernis
     * @return le prix du vernis choisi
     */
    public static float getPrixVernis(int idVernis){
        return vernisDisponible[Fonction.findIndex(vernisDisponible, idVernis)].getPrixVernis();
    }
    
    /**
     * donne le prix par marche comme specifie dans le fichier texte
     * @return le prix par marche
     */
    public static float getPrixMarche(){
        return escalierDisponible.getPrixMarches();
    }
    
    /**
     * donne le prix par contremarche comme specifie dans le fichier texte
     * @return le prix par contremarche
     */
    public static float getPrixContremarche(){
        return escalierDisponible.getPrixContremarches();
    }
    
    
    
    
}
