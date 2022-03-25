
/**
 * UQAM INF1120 - TP3
 * 
 * Dans le cadre du projet Expert Plancher
 * 
 * cette classe est compose des fonctions utulisee par l'application Expert-Plancher
 * utilisee par les classes:
 *  Finition
 *  Vernis
 * 
 * @author Akim Munro
 * @version 2021-12-03
 *
 * MUNA29058309
 * @munro.akim@courrier.uqam.ca
 */
public class Fonction
{
    //debut des methodes--------------------------------------------------------------------------------
    /**
     * Une methode qui retourne l'index de la premiere occurence d'un entier dans une table
     * @param table la table avec les identifiants 
     * @param entier l'identifiant choisi
     * @return index l'index dans la table de l'identifiant 
     */
    public static int findIndex (int[] table, int entier){

        int index = -1; //valeur par defaut
        int longeur = table.length;

        for (int i = 0; i < longeur && index == -1; i++){
            if (table[i] == entier){
                index = i;
            }
        }

        return index;
    }
    
    /**
     * Une methode qui retourne l'index de la premiere occurence d'un caractere dans une table
     * @param table la table avec les identifiants 
     * @param caractere l'identifiant choisi
     * @return index l'index dans la table de l'identifiant 
     */
    public static int findIndex (char[] table, int caractere){

        int index = -1; //valeur par defaut
        int longeur = table.length;

        for (int i = 0; i < longeur && index == -1; i++){
            if (table[i] == caractere){
                index = i;
            }
        }

        return index;
    }
    /**
     * Une methode qui retourne l'index de la premiere occurence de l'identifiant de vernis
     * @param table la table Vernis avec les identifiants 
     * @param entier l'identifiant choisi
     * @return index l'index dans la table de l'identifiant 
     */
    public static int findIndex (Vernis[] table, int entier){

        int index = -1; //valeur par defaut
        int longeur = table.length;
 
        for (int i = 0; i<longeur && index == -1; i++){
            if (table[i].getIdVernis() == entier){
                index = i;
            }
        }

        return index;
    }
    
    /**
     * Valide si un int est dans l'intervalle 
     * 
     * @return boolean - true si le nombre est (inclusivement) entre le min et max - faux sinon
     * @param (nombre a valider, borne inférieure, borne supérieure)
     */
    public static boolean valider(int nombre, int min, int max){

        boolean valide = false;

        if(nombre >= min && nombre <= max){
            valide = true;
        }

        return valide;
    }

    /**
     * Enleve les espaces au debut et a la fin d'une chaine de caracteres et ensuite
     * Valide si un String a une longeur insclusivement dans l'intervalle
     * 
     * @return boolean - true si la longeur du String est (inclusivement) entre le min et max - faux sinon
     * @param (String a valider, borne inférieure, borne supérieure)
     */
    public static boolean valider(String chaine, int min, int max){

        boolean valide = false;
        chaine = chaine.trim();
        int longeurDeChaine = chaine.length();

        if(longeurDeChaine >= min && longeurDeChaine <= max){
            valide = true;
        }

        return valide;
    }
}
