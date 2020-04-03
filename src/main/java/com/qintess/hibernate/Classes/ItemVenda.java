package com.qintess.hibernate.Classes;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.qintess.hibernate.Dao.Modelo;

@Entity
public class ItemVenda implements Modelo{

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private Produto produto;

    @ManyToOne
    private Venda venda;

    private int qtd;

    private double subtotal;

	@Override
	public String toString() {
		return "ItemVenda [id=" + id + ", produto=" + produto + ", qtd=" + qtd + ", subtotal="
				+ subtotal + "]";
	}

	public ItemVenda() {
		// TODO Auto-generated constructor stub
	}

	public ItemVenda(Produto produto, Venda venda, int qtd, double subtotal) {
		this.produto = produto;
		this.venda = venda;
		this.qtd = qtd;
		this.subtotal = subtotal;
	}

	public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
        this.subtotal = this.getProduto().getPreco() * this.qtd;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }
}