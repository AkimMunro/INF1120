
/**
 * UQAM INF1120 - TP3
 * 
 * Dans le cadre du projet Expert Plancher
 * 
 * cette classe est compose de toutes les constantes relatifs aux texte de la facture et l'application principale
 * utilisee par les classes:
 *  Facture
 *  ApplicationPrincipale

 * 
 * @author Akim Munro
 * @version 2021-12-03
 *
 * MUNA29058309
 * @munro.akim@courrier.uqam.ca
 */
public class Message
{
    
        public static final String TIRETS_LONG = "---------------------------------------------------------------------------------------";
        public static final String TIRETS_MOYEN = "----------------------------------------------------------";
        public static final String TIRETS_COURT = "\t     ------------------------------------------------------";
        public static final String ETOILES = "****************************************";
        
        
        //Initialisation des constantes de Facture.afficher
        public static final String FACTURE_NO = "Facture No: ";
        public static final String DATE_HEURE = "Date  et Heure: ";
        public static final String FACTURE_NOM = "Nom et prénom : ";
        public static final String FACTURE_TELEPHONE = "Téléphone : ";
        public static final String FACTURE_ADRESSE = "Adresse du client : ";
        public static final String FACTURE_VERNIS = "Type de vernis à appliquer : ";
        public static final String FINI_0 = " avec le fini ";
        public static final String FACTURE_PAIEMENT = "Mode de paiement : ";
        public static final String FACTURE_SURFACE = "Surface à sabler et à vernir";
        public static final String PC = "pied carré x ";
        public static final String FACTURE_MARCHES = "Nombre de marches";
        public static final String FACTURE_CONTREMARCHES = "Nombre de contremarches";
        public static final String FACTURE_SOUS_TOTAL = "Sous-total";
        public static final String FACTURE_TPS = "Montant TPS";
        public static final String FACTURE_TVQ = "Montant TVQ";
        public static final String FACTURE_TOTAL = "Montant total";
        public static final String FACTURE_MERCI = "Merci pour votre confiance!";
        
        
        //constantes ApplicationPrincipale.main
               
        public static final String MONTANT_FACTURES = "Le montant total de toutes les factures";
        
        public static final String VERNIS_CLIENTS = "Type de vernis       Nombre de clients ";
                
        public static final String QUITTER = "Merci et à la prochaine !";
        
        
        //constantes d'interface ApplicationPrincipale.saisirPaiement
        public static final String ENTREZ_MODE_PAIEMENT = "\n Entrez le mode de paiement (C ou c = Comptant, D ou d = Débit, et R ou r = Crédit): "; //sert aussi de point de reference pour l'identification du type de paiement sur la facture. respecter ce format ou voir la méthode identifierPaiementClient
        public static final String PAIEMENT_INVALIDE = " L’identifiant du mode de paiement est invalide!";
        
        //constantes d'interface ApplicationPrincipale.saisirContremarches
        public static final String ENTREZ_CONTREMARCHES = "\n Entrez le nombre de contremarches (supérieur à 0): ";
        public static final String CONTREMARCHES_INVALIDE = " Le nombre de contremarches est invalide!";
        
        //constantes d'interface ApplicationPrincipale.saisirMarches
        public static final String ENTREZ_MARCHES = "\n Entrez le nombre de marches (supérieur à 0): ";
        public static final String MARCHES_INVALIDE = " Le nombre de marches est invalide!";
        
        //constantes d'interface ApplicationPrincipale.saisirEscaliers
        public static final String ESCALIERS_ON = "\n Avez-vous des escaliers à sabler et à vernir (O ou o = Oui, N ou n = Non): ";
        public static final String ESCALIERS_INVALIDE = " La réponse est invalide!";
        
        //constantes d'interface ApplicationPrincipale.saisirFinition
        public static final String ENTREZ_FINITION = "\n Entrez le type de finition (1 = Mat, 2 = Satiné, 3 = Semi-Lustré, 4 = Lustré):"; // sert aussi de point de reference pour l'identification de la finition sur la facture. respecter ce format ou voir la méthode identifierVernisClient
        public static final String FINITION_INVALIDE = " L’identifiant du type  de  finition  est invalide!";
        
        //constantes d'interface ApplicationPrincipale.saisirVernis
        public static final String ENTREZ_VERNIS = 
            "\n Entrez l'identifiant du vernis (101 = Le vernis à base d'eau \n"
            +"\t \t \t         102 = Le vernis a base d'huile \n"
            +"\t \t \t         103 = Le vernis à l'alcool): ";  // sert aussi de point de reference pour l'identification du vernis sur la facture. respecter ce format ou voir la méthode identifierVernisClient
        public static final String VERNIS_INVALIDE = " L’identifiant du type de vernis est invalide!"; 
        
        //constantes d'interface ApplicationPrincipale.saisirVernis
        public static final String ENTREZ_SURFACE = "\n Entrez la surface à sabler et à vernir en pied carré (supérieur à 0) : ";
        public static final String SURFACE_INVALIDE = " La surface est invalide!";
        
        //constantes d'interface ApplicationPrincipale.saisirAdresse
        public static final String ENTREZ_ADRESSE = "\n Entrez l'adresse du client (entre 10 et 80 caractères inclusivement): ";
        public static final String ADRESSE_INVALIDE = " L’adresse  du  client  est invalide!";
        
        //constantes d'interface ApplicationPrincipale.saisirTelephone
        public static final String ENTREZ_TELEPHONE = "\n Entrez le numéro de téléphone du client (format : NNN NNN-NNNN): ";
        public static final String TELEPHONE_INVALIDE = " Le numéro de téléphone est invalide!";


        //constantes d'interface ApplicationPrincipale.saisirPrenom
        public static final String ENTREZ_PRENOM = "\n Entrez le prénom du client (entre 2 et 25 caractères inclusivement): ";
        public static final String PRENOM_INVALIDE = " Le prénom est invalide!";
        
        //Constantes d'interface ApplicationPrincipale.saisirNom
        public static final String ENTREZ_NOM = "\n Entrez le nom du client (entre 2 et 25 caractères inclusivement): ";
        public static final String NOM_INVALIDE = " Le  nom  est invalide!";
        
        //Constantes de l'interface ApplicationPrincipale.menuPrincipale
        public static final String MENU = "\n\n" 
            +" *** Menu de choix *** \n"
            +" 1. Facturer le sablage et le vernissage de planchers et d'escaliers\n"
            +" 2. Afficher le montant total de toutes les factures\n" 
            +" 3. Afficher le nombre de clients par type de vernis\n"
            +" 4. Quitter le programme\n\n\n Entrez votre choix :";
        public static final String MENU_INVALIDE = " L’option choisie est invalide!";
        
        //Constantes de l'interface ApplicationPrincipale.bienvenue
        public static final String BIENVENUE = 
            "Bienvenue dans le système de facturation d'expert-Plancher. \n"
            +"Ce programme permet de calculer la facture de sablage et de vernissage de plancher \n"
            +"selon le prix par pied carré et le type de vernis choisi. Il affiche aussi le montant \n"
            +"total de toutes les factures, et le nombre de clients par type de vernis ";
    
    }
