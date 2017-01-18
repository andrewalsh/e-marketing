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
	@NamedQuery(name="TerceiraBase.listar",query="from TerceiraBase base")
})
public class TerceiraBase implements Serializable{
	private long idTerceiraBase;
	private Base base;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public long getidTerceiraBase() {
		return idTerceiraBase;
	}
	public void setidTerceiraBase(long idTerceiraBase) {
		this.idTerceiraBase = idTerceiraBase;
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
		result = prime * result + (int) (idTerceiraBase ^ (idTerceiraBase >>> 32));
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
		TerceiraBase other = (TerceiraBase) obj;
		if (idTerceiraBase != other.idTerceiraBase)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "PrimeiraBase [idTerceiraBase=" + idTerceiraBase + ", base=" + base + "]";
	}
}
