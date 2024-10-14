package exo1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import ma.projet.entity.Produit;
import ma.projet.service.ProduitService;
import ma.projet.util.HibernateUtil;

public class Exo1 {
    private static Object scanner;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException {
        ProduitService ps = new ProduitService();
        Scanner scanner = new Scanner(System.in);
        

        //Créez 5 produits
        // ps.create(new Produit("HB2", "ref 1", new Date(), 10.00, "dsg 1"));
        // ps.create(new Produit("ABC", "ref 2", new Date(), 120.00, "dsg 2"));
        //ps.create(new Produit("1HB2", "ref 3", new Date(), 60.00, "dsg 3"));
        //ps.create(new Produit("1HB2", "ref 4", new Date(), 52.00, "dsg 4"));
        // ps.create(new Produit("1HB2", "ref 5", new Date(), 38.00, "dsg 5"));
        //Liste de produits
        List<Produit> produits = ps.findAll();
        if (produits != null) {
            System.out.println("\n***** Liste des produits *****");
            for (Produit p : produits) {
                System.out.println(p.getId() + " " + p.getMrq() + " " + p.getRef() + " " + p.getDsg() + " " + p.getPrix() + " "
                        + p.getDateAchat());
            }
        } else {
            System.out.println("La liste des produits est vide ou n'a pas pu être récupérée.");
        }

        //Afficher les informations du produit dont id = 2,
        System.out.println("\n***** Informations du produit avec ID = 2 *****");
        Produit produitId2 = ps.findById(2);
        if (produitId2 != null) {
            System.out.println(produitId2);
        } else {
            System.out.println("Aucun produit trouvé avec l'ID = 2");
        }
        
                // Supprimer le produit dont id = 3
        System.out.println("\n***** Suppression du produit avec ID = 3 *****");
        Produit produitId3 = ps.findById(3);
        if (produitId3 != null) {
            ps.delete(produitId3);
            System.out.println("Produit avec ID = 3 supprimé avec succès.");
        } else {
            System.out.println("Aucun produit trouvé avec l'ID = 3");
        }
        
                // Modifier les informations du produit dont id = 1
        System.out.println("\n***** Modification du produit avec ID = 1 *****");
        Produit produitId1 = ps.findById(1);
        if (produitId1 != null) {
            produitId1.setMrq(produitId1.getMrq() + " Eflo");
            produitId1.setPrix(produitId1.getPrix() + 50.00);
            ps.update(produitId1);
            System.out.println("Produit avec ID = 1 modifié avec succès.");
        } else {
            System.out.println("Aucun produit trouvé avec l'ID = 1");
        }
        
            // Méthode pour afficher la liste des produits dont le prix est supérieur à 100 DH
    
        System.out.println("\n *****Produits dont le prix est supérieur à 100 DH*****");
        for (Produit produit : produits) {
            if (produit.getPrix() > 100.00) {
                System.out.println(produit.getMrq());
            }
        }
    

    // Méthode pour afficher la liste des produits commandés entre deux dates saisies au clavier

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        // Lire les deux dates au clavier
        System.out.print("Entrez la première date (format dd/MM/yyyy): ");
        String date1String = scanner.nextLine();
        Date date1 = dateFormat.parse(date1String);

        System.out.print("Entrez la deuxième date (format dd/MM/yyyy): ");
        String date2String = scanner.nextLine();
        Date date2 = dateFormat.parse(date2String);

        System.out.println("Produits commandés entre " + date1String + " et " + date2String + ":");
        for (Produit produit : produits) {
            if (!produit.getDateAchat().before(date1) && !produit.getDateAchat().after(date2)) {
                System.out.println(produit.getMrq());
            }
        }
    }
        
    }

