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
	@NamedQuery(name="QuintaBase.listar",query="from QuintaBase base")
})
public class QuintaBase implements Serializable{

	private long idQuintaBase;
	private Base base;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public long getIdQuintaBase() {
		return idQuintaBase;
	}
	public void setIdQuintaBase(long idQuintaBase) {
		this.idQuintaBase = idQuintaBase;
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
		result = prime * result + (int) (idQuintaBase ^ (idQuintaBase >>> 32));
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
		QuintaBase other = (QuintaBase) obj;
		if (idQuintaBase != other.idQuintaBase)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "QuintaBase [idQuintaBase=" + idQuintaBase + ", base=" + base + "]";
	}
	
	
}
