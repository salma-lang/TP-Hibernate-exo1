/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package h1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import ma.projet.entity.Produit;
import ma.projet.service.ProduitService;
import ma.projet.util.HibernateUtil;

/**
 *
 * @author hp
 */
public class H1 {

 
    public static void main(String[] args) throws ParseException {
        // Creer cinq produits
        HibernateUtil.getSessionFactory();
       ProduitService  ps = new ProduitService ();
//            ps.create(new Produit("Marque1", "Ref1", new Date(), 150.0, "Description1"));
//            ps.create(new Produit("Marque2", "Ref2", new Date(), 80.0, "Description2"));
//            ps.create(new Produit("Marque3", "Ref3", new Date(), 190.0, "Description3"));
//            ps.create(new Produit("Marque4", "Ref4", new Date(), 300.0, "Description4"));
//            ps.create(new Produit("Marque5", "Ref5", new Date(), 700.0, "Description5"));
       //Afficher la liste des produits
         List<Produit> produits = ps.findAll();
         for (Produit p : produits) {
             System.out.println("La refencece du produit est : " + p.getReference() + " ,la marque est : " + p.getMarque() + " ,la date d'achat est: " + p.getDateAchat()+ " et le prix est : " + p.getPrix());
}
       //Afficher les informations du produit dont l'id = 2
         Produit produit = ps.findById(2);
         System.out.println("La refencece du produit est : " + produit.getReference() + " ,la marque est : " + produit.getMarque() + " ,la date d'achat est: " + produit.getDateAchat()+ " et le prix est : " + produit.getPrix());

       //Supprimer le produit dont l'id=3
          Produit pt = ps.findById(3);
           //ps.delete(pt);
          
         //Modifier les informations du produit dont l'id = 1 
          Produit pro = ps.findById(1);
          pro.setMarque("NouvelleMarque");
          pro.setPrix(600.0);
          ps.update(pro);
          
          //Afficher la liste des produits dont le prix est superieur a 100
          List<Produit> prds = ps.findAll();
          for (Produit pr : prds) {
            if (pr.getPrix() > 100) {
                System.out.println("La refencece du produit est : " + pr.getReference() + " ,la marque est : " + pr.getMarque() + " ,la date d'achat est: " + pr.getDateAchat()+ " et le prix est : " + pr.getPrix());

    }
          
  }
          //Afficher la liste des produits commandés entre deux dates
          System.out.println("\nProduits achetés entre deux dates :");
          SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

        Date DateDeDebut = sdf.parse("2024-10-10 17:02:41");
        Date DateDeFin = sdf.parse("2024-10-10 18:15:00");

        List<Produit> produitsEntreDeuxDates = ps.findBetweenDates(DateDeDebut, DateDeFin);

        for (Produit prt : produitsEntreDeuxDates) {
            System.out.println( "La refencece du produit est :" + prt.getReference() + " ,la marque est : " + prt.getMarque() + " ,la date d'achat est: " +  sdf.format(prt.getDateAchat())+ " et le prix est : " + prt.getPrix());

  }
  }
}



   

            
           
     

          
    

