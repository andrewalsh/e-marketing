package br.com.emarketing.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import br.com.emarketing.entity.PrimeiraBase;
import br.com.emarketing.util.HibernateUtil;

public class BaseDAO {

	
	@SuppressWarnings("unchecked")
	public List<PrimeiraBase> listrarPrimeiraBase() {
		Session session = HibernateUtil.getFabricaDeSessoes().openSession();
		List<PrimeiraBase> emails = null;
		try {
			Query query = session.getNamedQuery("PrimeiraBase.listar");
			emails = query.list();
		} catch (RuntimeException e) {
			throw e;
		}finally{
			session.close();
		}return emails;
	}
	
	
	@SuppressWarnings("unchecked")
	public List<PrimeiraBase> listrarSegundaBase() {
		Session session = HibernateUtil.getFabricaDeSessoes().openSession();
		List<PrimeiraBase> emails = null;
		try {
			Query query = session.getNamedQuery("SegundaBase.listar");
			emails = query.list();
		} catch (RuntimeException e) {
			throw e;
		}finally{
			session.close();
		}return emails;
	}
	
	
	@SuppressWarnings("unchecked")
	public List<PrimeiraBase> listrarTerceiraBase() {
		Session session = HibernateUtil.getFabricaDeSessoes().openSession();
		List<PrimeiraBase> emails = null;
		try {
			Query query = session.getNamedQuery("TerceiraBase.listar");
			emails = query.list();
		} catch (RuntimeException e) {
			throw e;
		}finally{
			session.close();
		}return emails;
	}
	
	
	
	@SuppressWarnings("unchecked")
	public List<PrimeiraBase> listrarQuartaBase() {
		Session session = HibernateUtil.getFabricaDeSessoes().openSession();
		List<PrimeiraBase> emails = null;
		try {
			Query query = session.getNamedQuery("QuartaBase.listar");
			emails = query.list();
		} catch (RuntimeException e) {
			throw e;
		}finally{
			session.close();
		}return emails;
	}
	
	
	
	@SuppressWarnings("unchecked")
	public List<PrimeiraBase> listrarQuintaBase() {
		Session session = HibernateUtil.getFabricaDeSessoes().openSession();
		List<PrimeiraBase> emails = null;
		try {
			Query query = session.getNamedQuery("QuintaBase.listar");
			emails = query.list();
		} catch (RuntimeException e) {
			throw e;
		}finally{
			session.close();
		}return emails;
	}

}
