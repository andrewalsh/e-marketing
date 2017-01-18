package br.com.emarketing.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

@SuppressWarnings("serial")
@Entity
@NamedQueries({
	@NamedQuery(name="PrimeiraBase.listar",query="from PrimeiraBase base")
})
public class PrimeiraBase implements Serializable{
	private long idPrimeiraBase;
	private Base base;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public long getIdPrimeiraBase() {
		return idPrimeiraBase;
	}
	public void setIdPrimeiraBase(long idPrimeiraBase) {
		this.idPrimeiraBase = idPrimeiraBase;
	}
	
	@OneToOne
	@JoinColumn(name="idBase",referencedColumnName="idBase",nullable=false)
	public Base getBase() {
		return base;
	}
	public void setBase(Base base) {
		this.base = base;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (idPrimeiraBase ^ (idPrimeiraBase >>> 32));
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
		PrimeiraBase other = (PrimeiraBase) obj;
		if (idPrimeiraBase != other.idPrimeiraBase)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "PrimeiraBase [idPrimeiraBase=" + idPrimeiraBase + ", base=" + base + "]";
	}
}
