package br.com.emarketing.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@SuppressWarnings("serial")
@Entity
@NamedQueries({
	@NamedQuery(name="Email.listar",query="from Email e")
})
public class Email implements Serializable{

	private long idElamil;
	private String email;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public long getIdElamil() {
		return idElamil;
	}
	public void setIdElamil(long idElamil) {
		this.idElamil = idElamil;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (idElamil ^ (idElamil >>> 32));
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Email other = (Email) obj;
		if (idElamil != other.idElamil)
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Email [idElamil=" + idElamil + ", email=" + email + "]";
	}
}
