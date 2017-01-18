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
	@NamedQuery(name="SegundaBase.listar",query="from SegundaBase base")
})
public class SegundaBase implements Serializable{
	private long idSegundaBase;
	private Base base;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public long getIdSegundaBase() {
		return idSegundaBase;
	}
	public void setIdSegundaBase(long idSegundaBase) {
		this.idSegundaBase = idSegundaBase;
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
		result = prime * result + (int) (idSegundaBase ^ (idSegundaBase >>> 32));
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
		SegundaBase other = (SegundaBase) obj;
		if (idSegundaBase != other.idSegundaBase)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "PrimeiraBase [idSegundaBase=" + idSegundaBase + ", base=" + base + "]";
	}
}
