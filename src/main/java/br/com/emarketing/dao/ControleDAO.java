package br.com.emarketing.dao;

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
	
	public ControleDeEnvio listar(){
		Session session = HibernateUtil.getFabricaDeSessoes().openSession();
		ControleDeEnvio controle = null;
		try {
			Query query = session.createQuery("from ControleDeEnvio ce where ce.idControleDeEnvio = "
					+ "(select max(idControleDeEnvio) from ControleDeEnvio c)");
			//query.setString("assunto", assunto);
			controle = (ControleDeEnvio) query.uniqueResult();
		} catch (RuntimeException e) {
			throw e;
		}finally{
			session.close();
		}return controle;
	}

}
