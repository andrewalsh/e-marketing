package br.com.emarketing.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import br.com.emarketing.entity.Base;
import br.com.emarketing.entity.PrimeiraBase;
import br.com.emarketing.entity.QuartaBase;
import br.com.emarketing.entity.QuintaBase;
import br.com.emarketing.entity.SegundaBase;
import br.com.emarketing.entity.TerceiraBase;
import br.com.emarketing.util.HibernateUtil;

public class BaseDAO {

	@SuppressWarnings("unchecked")
	public List<Base> listarBase(){
		Session session = HibernateUtil.getFabricaDeSessoes().openSession();
		List<Base> emails = null;
		try {
			Query query = session.getNamedQuery("Base.listar");
			emails = query.list();
		} catch (RuntimeException e) {
			throw e;
		}finally{
			session.close();
		}return emails;
	}
	
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
	public List<SegundaBase> listrarSegundaBase() {
		Session session = HibernateUtil.getFabricaDeSessoes().openSession();
		List<SegundaBase> emails = null;
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
	public List<TerceiraBase> listrarTerceiraBase() {
		Session session = HibernateUtil.getFabricaDeSessoes().openSession();
		List<TerceiraBase> emails = null;
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
	public List<QuartaBase> listrarQuartaBase() {
		Session session = HibernateUtil.getFabricaDeSessoes().openSession();
		List<QuartaBase> emails = null;
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
	public List<QuintaBase> listrarQuintaBase() {
		Session session = HibernateUtil.getFabricaDeSessoes().openSession();
		List<QuintaBase> emails = null;
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
