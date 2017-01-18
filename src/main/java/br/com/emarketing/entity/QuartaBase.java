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
	@NamedQuery(name="QuartaBase.listar",query="from QuartaBase base")
})
public class QuartaBase implements Serializable{
	
	private long idQuartaBase;
	private Base base;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public long getIdQuartaBase() {
		return idQuartaBase;
	}
	public void setIdQuartaBase(long idQuartaBase) {
		this.idQuartaBase = idQuartaBase;
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
		result = prime * result + (int) (idQuartaBase ^ (idQuartaBase >>> 32));
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
		QuartaBase other = (QuartaBase) obj;
		if (idQuartaBase != other.idQuartaBase)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "QuartaBase [idQuartaBase=" + idQuartaBase + ", base=" + base + "]";
	}
	
	
}
