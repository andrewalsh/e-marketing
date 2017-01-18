package br.com.emarketing.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;


@SuppressWarnings("serial")
@Entity
@NamedQuery(name="Base.listar",query="from Base b")

public class Base implements Serializable{

	private long idBase;
	private String email;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public long getIdBase() {
		return idBase;
	}
	public void setIdBase(long idBase) {
		this.idBase = idBase;
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
		result = prime * result + (int) (idBase ^ (idBase >>> 32));
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
		Base other = (Base) obj;
		if (idBase != other.idBase)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Base [idEmail=" + idBase + ", email=" + email + "]";
	}
}
