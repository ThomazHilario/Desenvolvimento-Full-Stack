/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import model.Produto;

/**
 *
 * @author Thomaz Alves
 */
public class ProdutoJpaController {
    private EntityManager em;

    public ProdutoJpaController(EntityManager em) {
        this.em = em;
    }
    
    public List<Produto> findProdutos() {
        try {
            Query query = em.createQuery("SELECT p FROM Produto p");
            return (List<Produto>) query.getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }
    
    public Produto findProduto(int idProduto){
       try {
            Query query = em.createQuery("SELECT p FROM Produto p WHERE p.idProduto = :idProduto");
            query.setParameter("idProduto", idProduto);
            return (Produto) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        } 
    }
}
