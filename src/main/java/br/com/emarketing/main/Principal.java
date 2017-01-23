package br.com.emarketing.main;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import br.com.emarketing.dao.BaseDAO;
import br.com.emarketing.dao.ControleDAO;
import br.com.emarketing.entity.Base;
import br.com.emarketing.entity.ControleDeEnvio;
import br.com.emarketing.entity.PrimeiraBase;
import br.com.emarketing.util.HibernateUtil;

public class Principal {

	public static void main(String[] args) {
		ControleDAO dao = new ControleDAO();
		ControleDeEnvio controleDeEnvio = new ControleDeEnvio();
		try {
			controleDeEnvio = dao.listar();
		} catch (RuntimeException e) {
			System.out.println("erro: "+e.getMessage());
		}
		System.out.println(controleDeEnvio.toString());
	}

}
