package br.com.emarketing.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import br.com.emarketing.entity.Email;
import br.com.emarketing.util.HibernateUtil;

public class EmailDAO {
	
	@SuppressWarnings("unchecked")
	public List<Email> listarEmail(){
		Session session = HibernateUtil.getFabricaDeSessoes().openSession();
		List<Email> emails = null;
		try {
			Query query = session.getNamedQuery("Email.listar");
			emails = query.list();
		} catch (RuntimeException e) {
			throw e;
		}finally{
			session.close();
		}return emails;
	}

}
