/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import model.Pessoa;

/**
 *
 * @author Thomaz Alves
 */
public class PessoaJpaController {
    private EntityManager em;
    
    public PessoaJpaController(EntityManager em) {
        this.em = em;
    }
    
    public Pessoa findPessoa(int idPessoa){
        try {
            Query query = em.createQuery("SELECT p FROM Pessoa p WHERE p.idPessoa = :idPessoa");
            query.setParameter("idPessoa", idPessoa);
            return (Pessoa) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
}
