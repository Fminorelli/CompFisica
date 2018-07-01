/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Banco;

import java.math.BigDecimal;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author wesle
 */
public class IluminaçaoDao {

    public void persist(Iluminaçao iluminaçao) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProjetoCompFisicaPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(iluminaçao);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
   
    public Iluminaçao find(Class<Iluminaçao> aClass, int l){
         EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProjetoCompFisicaPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Iluminaçao teste = em.find(aClass,l);
        
        return teste;
        
    }
    

    public BigDecimal soma(int numlampada){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProjetoCompFisicaPU");
        EntityManager em = emf.createEntityManager();
    Query query = em.createNativeQuery("select sum(tempoaceso) from iluminaÇao where numlampada = "+numlampada);
    BigDecimal soma;
    soma =  (BigDecimal) query.getSingleResult();
    return soma;
    }

    
    
    public List<Iluminaçao> lista(){
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProjetoCompFisicaPU");
    EntityManager em = emf.createEntityManager();
    Query query = em.createNativeQuery("select  from iluminaÇao;");
    return query.getResultList();
  }
    
  
    
    
}
