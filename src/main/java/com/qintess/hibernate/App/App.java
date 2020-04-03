package com.qintess.hibernate.App;

import java.util.ArrayList;
import java.util.List;
import com.qintess.hibernate.Classes.ItemVenda;
import com.qintess.hibernate.Classes.Produto;
import com.qintess.hibernate.Classes.Venda;
import com.qintess.hibernate.Dao.GenericDao;

public class App {
	
	public static Double total = 0.0;
	
	public static void main(String[] args){
		
		System.out.println("Hello");
		System.out.println("H2 Funcionando!");
		System.out.println("Hibernate Funcionando!");

		Produto produto1 = new Produto();
		Produto produto2 = new Produto();
		Produto produto3 = new Produto();
		
		GenericDao<Produto> daoProduto = new GenericDao<Produto>();		
		
		produto1.setNome("Iphone");
		produto1.setPreco(7000.00);
		daoProduto.saveOrUpdate(produto1);
		
		produto2.setNome("Iphonex");
		produto2.setPreco(15000.00);
		daoProduto.saveOrUpdate(produto2);
		
		produto3.setNome("Xbox");
		produto3.setPreco(4000.00);
		daoProduto.saveOrUpdate(produto3);
		
		Venda venda1 = new Venda();
		
		GenericDao<Venda> daoVenda = new GenericDao<Venda>();		
		
		venda1.setTotal(0);
		daoVenda.saveOrUpdate(venda1);
		
		List<ItemVenda> Itens = new ArrayList<ItemVenda>();		
		
		Itens.add(new ItemVenda (produto1, venda1, 4, 0));
		Itens.add(new ItemVenda (produto2, venda1, 5, 0));
		Itens.add(new ItemVenda (produto3, venda1, 10, 0));
		
		GenericDao<ItemVenda> daoItem = new GenericDao<ItemVenda>();
		
		ItemVenda item1 = new ItemVenda();
		ItemVenda item2 = new ItemVenda();
		ItemVenda item3 = new ItemVenda();
		
		//item1
		item1.setProduto(produto1);
		item1.setSubtotal(0);
		item1.setQtd(4);
		item1.setVenda(venda1);
		daoItem.saveOrUpdate(item1);
		
		total += item1.getSubtotal();
		venda1.setTotal(total);
		daoVenda.saveOrUpdate(venda1);
		
		//item2
		item2.setProduto(produto2);
		item2.setSubtotal(0);
		item2.setQtd(5);
		item2.setVenda(venda1);
		daoItem.saveOrUpdate(item2);
		
		total += item2.getSubtotal();
		venda1.setTotal(total);
		daoVenda.saveOrUpdate(venda1);
	
		//item3
		item3.setProduto(produto3);
		item3.setSubtotal(0);
		item3.setQtd(10);
		item3.setVenda(venda1);
		daoItem.saveOrUpdate(item3);
		
		total += item3.getSubtotal();
		venda1.setTotal(total);
		daoVenda.saveOrUpdate(venda1);
		
		System.out.println("=============================================");
		System.out.println("            LISTAGEM DE PRODUTOS            ");
		
		for (Produto produto : daoProduto.BuscarTodos(Produto.class)) {
			System.out.println(produto.toString());
		}
		
		System.out.println("=============================================");
		System.out.println("              LISTAGEM DE VENDAS             ");

		for (Venda vendas : daoVenda.BuscarTodos(Venda.class)) {
			System.out.println(vendas.toString());
		}
		
		System.out.println("=============================================");
		System.out.println("         LISTAGEM DE ITENS DA VENDAS         ");
		
		for (ItemVenda ivenda : daoItem.BuscarTodos(ItemVenda.class)) {
			System.out.println(ivenda.toString());
		}
		System.out.println("=============================================");
		
		System.out.println("Acabou!!");
		
	}
}