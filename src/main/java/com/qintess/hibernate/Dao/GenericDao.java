package com.qintess.hibernate.Dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import com.qintess.hibernate.Config.Config;
import com.qintess.hibernate.Dao.Modelo;

@SuppressWarnings("unused")
public class GenericDao<T extends Modelo > {
	Session session = Config.getSessionFactory().openSession();
			public void saveOrUpdate(T obj) {
		Transaction transacao = null;
		try {

			transacao = session.beginTransaction();

			if (obj.getId() == 0) {
				session.save(obj);

			}else {
				session.merge(obj);
			}

			transacao.commit();

		} catch (Exception e) {
			session.getTransaction().rollback();
			
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	public List<T> BuscarTodos (Class<T> clazz) {
		//Session session = Config.getSessionFactory().openSession();
		return (List<T>) session.createQuery("select t from " + clazz.getName() + " t").getResultList();
	}

	public T BuscaPorId (Class<T> clazz, int id) {
		//Session session = Config.getSessionFactory().openSession();
		return session.find(clazz, id);
	}

	public void delete(Class<T> clazz, int id) {
		//Session session = Config.getSessionFactory().openSession();
		T t = BuscaPorId(clazz, id);
		try{
			session.getTransaction().begin();
			session.remove(t);
			session.getTransaction().commit();
		}catch (Exception e) {
			session.getTransaction().rollback();
		}
	}
}