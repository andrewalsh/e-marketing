package br.com.emarketing.main;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import br.com.emarketing.dao.BaseDAO;
import br.com.emarketing.entity.Base;
import br.com.emarketing.entity.PrimeiraBase;
import br.com.emarketing.util.HibernateUtil;

public class Principal {

	public static void main(String[] args) {
		BaseDAO dao = new BaseDAO();
		List<Base> base = new ArrayList<>();
		
		base = dao.listarBase();
		
		for (Base base2 : base) {
			System.out.println(base2.toString());
		}

	}

}
