/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.service;

import java.util.Date;
import java.util.List;
import ma.projet.dao.IDao;
import ma.projet.entity.Produit;
import ma.projet.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author hp
 */
public class ProduitService implements IDao<Produit > {

    @Override
    public boolean create(Produit  o) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(o);
            session.getTransaction().commit();
            return true;
        } catch (HibernateException e) {
            session.getTransaction().rollback();
        }finally{
           session.close();
        }
        return false;
    }

    @Override
    public boolean delete(Produit  o) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(o);
            session.getTransaction().commit();
            return true;
        } catch (HibernateException e) {
            session.getTransaction().rollback();
        }finally{
            session.close();
        }
        return false;
    }

    @Override
    public boolean update(Produit  o) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(o);
            session.getTransaction().commit();
            return true;
        } catch (HibernateException e) {
            session.getTransaction().rollback();
        }finally{
            session.close();
        }
        return false;
    }

    @Override
    public Produit  findById(int id) {
        Session session = null;
        Produit  e  = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            e = (Produit ) session.get(Produit .class, id);
            session.getTransaction().commit();
            return e;
        } catch (HibernateException ex) {
            session.getTransaction().rollback();
        }finally{
            session.close();
        }
        return e;
    }

    @Override
    public List<Produit > findAll() {
        Session session = null;
        List<Produit >  salles = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            salles = session.createQuery("from Produit ").list();
            session.getTransaction().commit();
            return salles;
        } catch (HibernateException e) {
            session.getTransaction().rollback();
        }finally{
            session.close();
        }
        return salles;
    }
    
    public List<Produit> findBetweenDates(Date startDate, Date endDate) {
    Session session = null;
    List<Produit> produits = null;
    try {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        // Utiliser de HQL pour récupérer les produits entre deux dates
        produits = session.createQuery("from Produit p where p.dateAchat between :startDate and :endDate")
                          .setParameter("startDate", startDate)
                          .setParameter("endDate", endDate)
                          .list();
                          
        session.getTransaction().commit();
        return produits;
    } catch (HibernateException e) {
        session.getTransaction().rollback();
        e.printStackTrace();
    } finally {
        session.close();
    }
    return produits;
}
}
    
    