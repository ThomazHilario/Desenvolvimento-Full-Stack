/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import model.Movimentos;

/**
 *
 * @author Thomaz Alves
 */
public class MovimentosJpaController implements Serializable {

    private EntityManager em;
    
    public MovimentosJpaController(EntityManager em) {
       this.em = em;
    }
    
    public void create(Movimentos movimento) {
        try {
            em.getTransaction().begin();
            em.persist(movimento);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new RuntimeException("Erro ao criar movimento", e);
        }
    }
    
    public List<Movimentos> findMovimentos(){
       try {
            Query query = em.createQuery("SELECT m FROM Movimentos m");
            return (List<Movimentos>) query.getResultList();
        } catch (NoResultException e) {
            return null;
        } 
    }
}
