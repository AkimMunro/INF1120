
/**
 * UQAM INF1120 - TP3
 * 
 * Dans le cadre du projet Expert Plancher
 * 
 * L'application principale livree a Expert-Planchers
 * 
 * Tp2Inf1120Grpe21A2021 1.0:  Ce programme aide dans la création de factures pour l'entreprise Expert-Plancher.
 * Le programme enregistre la superficie de plancher a vernir, le nombre de marches et contremarches 
 * s'ils ont lieux, et le type de finition et calcule le prix selon ces paramètres
 * Le programme perment aussi a l'entreprise de visualiser le nombre de finitions facturés, 
 * ainsi que le total facturé.
 *
 * Version 2.0 : La version 2 utilise des methodes
 * 
 * Version 3.0 : (2021-11-26) La version 3 utilise plusieurs classes pour definir le client, la finition choisie, le vernis choisi, le nombre descaliers, le contrat et la facture
 * Version 3.1 : (2021-11-29) Ajout de la gestion d'exceptions
 * 
 * @author Akim Munro
 * @version 2021-12-03
 *
 * MUNA29058309
 * @munro.akim@courrier.uqam.ca
 */
public class ApplicationPrincipale
{
    // Constantes de validation
    public static final String TYPES_ESCALIERS = "NO";
    public static final byte OPTION_MENU_PRINCIPAL_INFERIEUR = 1;
    public static final byte OPTION_MENU_PRINCIPAL_SUPERIEUR = 4;
    public static final byte OPTION_MENU_VERNIS_INFERIEUR = 101;
    public static final byte OPTION_MENU_VERNIS_SUPERIEUR = 103;
    public static final byte OPTION_MENU_FINITION_INFERIEUR = 1;
    public static final byte OPTION_MENU_FINITION_SUPERIEUR = 4;
    public static final byte LONGEUR_NOM_MIN = 2;
    public static final byte LONGEUR_NOM_MAX = 25;
    public static final byte LONGEUR_ADRESSE_MIN = 10;
    public static final byte LONGEUR_ADRESSE_MAX = 80;
    public static final String TYPES_PAIEMENT = " CDR";


    /**
     * Affiche le message de bienvenue
     * 
     * @return void
     * @param void
     */
    public static void bienvenue(){


        System.out.println(Message.TIRETS_LONG);
        System.out.println(Message.BIENVENUE);
        System.out.println(Message.TIRETS_LONG);

    }

    /**
     * menuPrincipal - affiche le menu principal (Message.MENU) et valide le choix selon OPTION_MENU_PRINCIPAL_INFERIEUR et OPTION_MENU_PRINCIPAL_SUPERIEUR
     * 
     * @return le choix de menu
     * @param void
     */
    public static byte menuPrincipal(){


        boolean invalide = true;
        byte choix =0;

        do{
            try{

                System.out.print(Message.MENU);
                choix = Clavier.lireByte();

                if ( Fonction.valider(choix,OPTION_MENU_PRINCIPAL_INFERIEUR,OPTION_MENU_PRINCIPAL_SUPERIEUR) ){
                    invalide = false;
                }else{
                    System.out.println(Message.MENU_INVALIDE);
                }
            }catch(Exception e){
                System.out.println(Message.MENU_INVALIDE);
            }

        } while (invalide);

        return choix;
    }

    /**
     * saisirNom - affiche le messag Message.ENTREZ_NOM, enleve les espaces vide au debut et a la fin, ensuite
     * saisit le nom du client et le valide la longeur selon les variables LONGEUR_NOM_MIN et LONGEUR_NOM_MAX et la methode validerStr
     * 
     * 
     * @return String nom du client
     * @param void
     */
    public static String saisirNom(){

        boolean invalide = true;
        String nom;

        do{
            System.out.print(Message.ENTREZ_NOM);
            nom = Clavier.lireString();
            nom = nom.trim();

            if ( Fonction.valider(nom,LONGEUR_NOM_MIN,LONGEUR_NOM_MAX) ){
                invalide = false;
            }else{
                System.out.println(Message.NOM_INVALIDE);
            }

        } while (invalide);

        return nom;
    }

    /**
     * saisirPrenom - affiche le message Message.ENTREZ_PRENOM, enleve les espaces vide au debut et a la fin, ensuite
     * saisit le prenom du client et le valide la longeur selon les variables LONGEUR_NOM_MIN et LONGEUR_NOM_MAX et la m/thode validerStr
     * 
     * 
     * @return String prenom du client
     * @param void
     */
    public static String saisirPrenom(){

        boolean invalide = true;
        String prenom;

        do{
            System.out.print(Message.ENTREZ_PRENOM);
            prenom = Clavier.lireString();
            prenom = prenom.trim();

            if ( Fonction.valider(prenom,LONGEUR_NOM_MIN,LONGEUR_NOM_MAX) ){
                invalide = false;
            }else{
                System.out.println(Message.PRENOM_INVALIDE);
            }

        } while (invalide);

        return prenom;
    }

    /**
     * saisirTelephone - affiche le message Message.ENTREZ_TELEPHONE, enleve les espaces vide au debut et a la fin, ensuite
     * saisit le numero de telephone du client et la valide selon le format FORMAT_TELEPHONE
     * 
     * 
     * @return String numero de telephone du client
     * @param void
     */
    public static String saisirTelephone(){

        //constante definissant le format du numero de telephone
        final String FORMAT_TELEPHONE = "(\\d)(\\d)(\\d)( )(\\d)(\\d)(\\d)(-)(\\d)(\\d)(\\d)(\\d)"; //  //d represente un numero, ceci donne le format XXX XXX-XXXX

        boolean invalide = true;
        String telephone;

        do{
            System.out.print(Message.ENTREZ_TELEPHONE);
            telephone = Clavier.lireString();
            telephone = telephone.trim();

            if ( telephone.matches(FORMAT_TELEPHONE)){
                invalide = false;
            }else{
                System.out.println(Message.TELEPHONE_INVALIDE);
            }

        } while (invalide);

        return telephone;
    }

    /**
     * saisirAdresse - affiche le message Message.ENTREZ_ADRESSE, enleve les espaces vide au debut et a la fin, ensuite
     * saisit l'adresse du client et le valide la longeur selon les variables LONGEUR_NOM_MIN et LONGEUR_NOM_MAX et la m/thode validerStr
     * 
     * 
     * @return String adresse du client
     * @param void
     */
    public static String saisirAdresse(){

        boolean invalide = true;
        String adresse;

        do{
            System.out.print(Message.ENTREZ_ADRESSE);
            adresse = Clavier.lireString();
            adresse = adresse.trim();

            if ( Fonction.valider(adresse,LONGEUR_ADRESSE_MIN,LONGEUR_ADRESSE_MAX) ){
                invalide = false;
            }else{
                System.out.println(Message.ADRESSE_INVALIDE);
            }

        } while (invalide);

        return adresse;
    }

    /**
     * saisirSurface - affiche le message Message.ENTREZ_SURFACE,et valide que le choix est superieur a 0
     * 
     * @return float surface a vernir
     * @param void
     */
    public static float saisirSurface(){


        boolean invalide = true;
        float surface = 0;

        do{
            try{

                System.out.print(Message.ENTREZ_SURFACE);
                surface = Clavier.lireFloat();

                if ( surface > 0 ){
                    invalide = false;
                }else{
                    System.out.println(Message.SURFACE_INVALIDE);
                }
            }catch(Exception e){
                System.out.println(Message.SURFACE_INVALIDE);
            }
        } while (invalide);

        return surface;
    }

    /**
     * saisirVernis - affiche les types de vernis (Message.ENTREZ_VERNIS) et valide le choix selon OPTION_MENU_VERNIS_INFERIEUR et OPTION_MENU_VERNIS_SUPERIEUR
     * 
     * @return le choix de vernis
     * @param void
     */
    public static byte saisirVernis(){

        boolean invalide = true;
        byte vernis = 0;

        do{
            try{
                System.out.print(Message.ENTREZ_VERNIS);
                vernis = Clavier.lireByte();

                if ( Fonction.valider(vernis,OPTION_MENU_VERNIS_INFERIEUR,OPTION_MENU_VERNIS_SUPERIEUR) ){
                    invalide = false;
                }else{
                    System.out.println(Message.VERNIS_INVALIDE);
                }
            }catch(Exception e){
                System.out.println(Message.VERNIS_INVALIDE);
            }
        } while (invalide);

        return vernis;
    }

    /**
     * saisirFinition - affiche les types de vernis (Message.ENTREZ_FINITION) et valide le choix selon OPTION_MENU_FINITION_INFERIEUR et OPTION_MENU_FINITION_SUPERIEUR
     * 
     * @return le choix de vernis
     * @param void
     */
    public static byte saisirFinition(){

        boolean invalide = true;
        byte finition = 0;

        do{
            try{
                System.out.print(Message.ENTREZ_FINITION);
                finition = Clavier.lireByte();

                if ( Fonction.valider(finition,OPTION_MENU_FINITION_INFERIEUR,OPTION_MENU_FINITION_SUPERIEUR) ){
                    invalide = false;
                }else{
                    System.out.println(Message.FINITION_INVALIDE);
                }
            }catch(Exception e){
                System.out.println(Message.FINITION_INVALIDE);
            }

        } while (invalide);

        return finition;
    }

    /**
     * saisirEscaliers - affiche une question demandant s'il y a des marches (Message.ESCALIERS_ON) et valide le choix selon TYPES_ESCALIERS
     * 
     * @return char 'O' s'il y a des marches et 'N' si non
     * @param void
     */
    public static char saisirEscaliers(){

        boolean invalide = true;
        char escaliers = 0;

        do{
            try{

                System.out.print(Message.ESCALIERS_ON);
                escaliers = Clavier.lireCharLn();
                escaliers = Character.toUpperCase(escaliers);

                if ( TYPES_ESCALIERS.indexOf(escaliers) != -1 ){
                    invalide = false;
                }else{
                    System.out.println(Message.ESCALIERS_INVALIDE);
                }

            }catch(Exception e){
                System.out.println(Message.ESCALIERS_INVALIDE);
            }

        } while (invalide);

        return escaliers;
    }

    /**
     * saisirMarches - affiche une solicitation pour le nombre de marches (Message.ENTREZ_MARCHES) et valide que le choix est superieur a 0
     * 
     * @return int le nombre de marches
     * @param void
     */
    public static int saisirMarches(){

        boolean invalide = true;
        int marches = 0 ;

        do{
            try{
                System.out.print(Message.ENTREZ_MARCHES);
                marches = Clavier.lireInt();

                if ( marches > 0){
                    invalide = false;
                }else{
                    System.out.println(Message.MARCHES_INVALIDE);
                }
            }catch(Exception e){
                System.out.println(Message.MARCHES_INVALIDE);
            }

        } while (invalide);

        return marches;
    }

    /**
     * saisirContremarches - affiche une solicitation pour le nombre de marches (Message.ENTREZ_CONTREMARCHES) et valide que le choix est superieur a 0
     * 
     * @return int le nombre de marches
     * @param void
     */
    public static int saisirContremarches(){

        boolean invalide = true;
        int contremarches = 0;

        do{
            try{

                System.out.print(Message.ENTREZ_CONTREMARCHES);
                contremarches = Clavier.lireInt();

                if ( contremarches > 0){
                    invalide = false;
                }else{
                    System.out.println(Message.CONTREMARCHES_INVALIDE);
                }

            }catch(Exception e){
                System.out.println(Message.CONTREMARCHES_INVALIDE);
            }
        } while (invalide);

        return contremarches;
    }

    /**
     * saisirPaiement - affiche une question demandant quel type de paiement sera utilisee et valide le choix selon TYPES_PAIEMENT
     * 
     * @return char 'C' 'D' ou 'R' selon le choix
     * @param void
     */
    public static char saisirPaiement(){

        boolean invalide = true;
        char paiement;

        do{
            System.out.print(Message.ENTREZ_MODE_PAIEMENT);
            paiement = Clavier.lireCharLn();
            paiement = Character.toUpperCase(paiement);

            if ( TYPES_PAIEMENT.indexOf(paiement) != -1 ){
                invalide = false;
            }else{
                System.out.println(Message.PAIEMENT_INVALIDE);
            }

        } while (invalide);

        return paiement;
    }

    public static void main(String[]args){

        //decrlaration des variables ------------------------------------------------

        char identifiantModePaiement;
        char reponse;

        int identifiantVernis;
        int identifiantFinition;
        int nbMarches = 0;
        int nbContremarches = 0;
        int choixMenu;

        float surfaceASablerVernir;
        float prixParPiedCarre;
        float prixParMarche;
        float prixParContreMarche;

        String nomClient;
        String prenomClient;
        String numeroTelephoneClient;
        String adresseClient;

        Client client;
        Finition finition;
        Vernis vernis;
        Escalier escalier;
        ContratSablageVernissage contrat;
        Facture facture;

        //appeler les methodes qui lisent les prix ------------------------------------------------
        ListeDesPrix.lireVernis();
        ListeDesPrix.lireEscaliers();

        bienvenue();
        do{

            choixMenu = menuPrincipal();

            switch (choixMenu){
                case 1:
                    //saisir et generer l'objet client
                    
                    nomClient = saisirNom();
                    prenomClient = saisirPrenom();
                    numeroTelephoneClient = saisirTelephone();
                    adresseClient = saisirAdresse();
                    client = new Client (nomClient, prenomClient, adresseClient, numeroTelephoneClient);
                     
                    //saisir l'objet vernis
                    surfaceASablerVernir = saisirSurface();
                    identifiantVernis = saisirVernis();

                    //saisir et generer l'objet finition
                    identifiantFinition = saisirFinition();
                    finition = new Finition(identifiantFinition);

                    // obtenir le prix par pied carre a partir de l'identifiant
                    prixParPiedCarre = ListeDesPrix.getPrixVernis(identifiantVernis);   

                    //generer l'objet vernis
                    vernis = new Vernis(identifiantVernis, finition, prixParPiedCarre); 

                    //saisir et generer l'objet Escalier
                    reponse = saisirEscaliers();
                    if (TYPES_ESCALIERS.indexOf(reponse) == 1){
                        nbMarches = saisirMarches();
                        nbContremarches = saisirContremarches();

                        //obtient le prix de chaque marche et contremarche
                        prixParMarche = ListeDesPrix.getPrixMarche();
                        prixParContreMarche = ListeDesPrix.getPrixContremarche();

                        //creer l'opbjet marche
                        escalier = new Escalier (nbMarches,nbContremarches,prixParMarche,prixParContreMarche); 

                    }else{
                        escalier = new Escalier (0,0,0,0);
                    }

                    identifiantModePaiement = saisirPaiement();

                    contrat = new ContratSablageVernissage(client, surfaceASablerVernir, escalier, vernis);

                    facture = new Facture(contrat, identifiantModePaiement);

                    //faire les calculs
                    facture.calculerSousTotalVernissage();
                    facture.calculerSousTotalMarches();
                    facture.calculerSousTotalContremarches();
                    facture.calculerSousTotal();
                    facture.calculerTaxeTPS();
                    facture.calculerTaxeTVQ();
                    facture.calculerTotal();
                    facture.incrementerNumeroFacture();

                    facture.afficher();
                    // Calcul du montant total de toutes les factures.
                    StatistiquesVentes.sommerTotal(facture.getTotal());

                    // Incrémentation du nombre de clients par type de vernis.
                    StatistiquesVentes.incrementerVernis(vernis.getIdVernis());

                    break;
                case 2:
                    StatistiquesVentes.afficherTotal();

                    break;

                case 3:
                    StatistiquesVentes.afficherVernisTotal();
                    break;

                case 4:

                    StatistiquesVentes.ecrireStatistiques();
                    System.out.println("\n "+Message.QUITTER);

                    break;
            }

        }while (choixMenu != OPTION_MENU_PRINCIPAL_SUPERIEUR);

    }

}
