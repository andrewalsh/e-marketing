package br.com.emarketing.main;

import org.hibernate.Session;

import br.com.emarketing.util.HibernateUtil;

public class Principal {

	public static void main(String[] args) {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		sessao.close();
		HibernateUtil.getFabricaDeSessoes().close();

	}

}
