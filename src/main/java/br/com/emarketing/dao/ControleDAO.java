package br.com.emarketing.dao;

import java.util.Date;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.emarketing.entity.ControleDeEnvio;
import br.com.emarketing.util.HibernateUtil;

public class ControleDAO {
	
	public void salvar(ControleDeEnvio controleDeEnvio){
		Session session = HibernateUtil.getFabricaDeSessoes().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			//controleDeEnvio.setDataEnvio(new Date());
			session.save(controleDeEnvio);
			transaction.commit();
		} catch (RuntimeException e) {
			if(transaction != null){
				transaction.rollback();
			}
			throw e;
		}finally{
			session.close();
		}
	}
	
	public void atualizar(ControleDeEnvio controleDeEnvio){
		Session session = HibernateUtil.getFabricaDeSessoes().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			//controleDeEnvio.setDataEnvio(new Date());
			session.update(controleDeEnvio);
			transaction.commit();
		} catch (RuntimeException e) {
			if(transaction != null){
				transaction.rollback();
			}
			throw e;
		}finally{
			session.close();
		}
	}
	
	public ControleDeEnvio listar(){
		Session session = HibernateUtil.getFabricaDeSessoes().openSession();
		ControleDeEnvio controle = null;
		try {
			Query query = session.createQuery("select max(c.idControleDEEnvio) from ControleDeEnvio c");
			
			
			Long id = (Long) query.uniqueResult();
			
			
			Query query2 = session.createQuery("from ControleDeEnvio ce where ce.idControleDEEnvio ="+id);
			
			controle = (ControleDeEnvio) query2.uniqueResult();
		} catch (RuntimeException e) {
			throw e;
		}finally{
			session.close();
		}return controle;
	}

}
