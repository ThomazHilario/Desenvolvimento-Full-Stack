/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cadastroee.model;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 *
 * @author Thomaz Alves
 */
@jakarta.persistence.Entity
@jakarta.persistence.Table(name = "Movimentos")
@jakarta.persistence.NamedQueries({
    @jakarta.persistence.NamedQuery(name = "Movimentos.findAll", query = "SELECT m FROM Movimentos m"),
    @jakarta.persistence.NamedQuery(name = "Movimentos.findByIdMovimento", query = "SELECT m FROM Movimentos m WHERE m.idMovimento = :idMovimento"),
    @jakarta.persistence.NamedQuery(name = "Movimentos.findByIdUsuario", query = "SELECT m FROM Movimentos m WHERE m.idUsuario = :idUsuario"),
    @jakarta.persistence.NamedQuery(name = "Movimentos.findByQuantidade", query = "SELECT m FROM Movimentos m WHERE m.quantidade = :quantidade"),
    @jakarta.persistence.NamedQuery(name = "Movimentos.findByTipo", query = "SELECT m FROM Movimentos m WHERE m.tipo = :tipo"),
    @jakarta.persistence.NamedQuery(name = "Movimentos.findByPrecoUnitario", query = "SELECT m FROM Movimentos m WHERE m.precoUnitario = :precoUnitario")})
public class Movimentos implements Serializable {

    private static final long serialVersionUID = 1L;
    @jakarta.persistence.Id
    @jakarta.persistence.Basic(optional = false)
    @jakarta.persistence.Column(name = "idMovimento")
    private Integer idMovimento;
    @jakarta.persistence.Column(name = "idUsuario")
    private Integer idUsuario;
    @jakarta.persistence.Column(name = "quantidade")
    private Integer quantidade;
    @jakarta.persistence.Column(name = "tipo")
    private String tipo;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @jakarta.persistence.Column(name = "preco_unitario")
    private BigDecimal precoUnitario;
    @jakarta.persistence.JoinColumn(name = "idPessoa", referencedColumnName = "idPessoa")
    @jakarta.persistence.ManyToOne
    private Pessoa idPessoa;
    @jakarta.persistence.JoinColumn(name = "idProduto", referencedColumnName = "idProduto")
    @jakarta.persistence.ManyToOne
    private Produto idProduto;

    public Movimentos() {
    }

    public Movimentos(Integer idMovimento) {
        this.idMovimento = idMovimento;
    }

    public Integer getIdMovimento() {
        return idMovimento;
    }

    public void setIdMovimento(Integer idMovimento) {
        this.idMovimento = idMovimento;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public BigDecimal getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(BigDecimal precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public Pessoa getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(Pessoa idPessoa) {
        this.idPessoa = idPessoa;
    }

    public Produto getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Produto idProduto) {
        this.idProduto = idProduto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMovimento != null ? idMovimento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Movimentos)) {
            return false;
        }
        Movimentos other = (Movimentos) object;
        if ((this.idMovimento == null && other.idMovimento != null) || (this.idMovimento != null && !this.idMovimento.equals(other.idMovimento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cadastroee.model.Movimentos[ idMovimento=" + idMovimento + " ]";
    }
    
}
