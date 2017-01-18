package br.com.emarketing.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@SuppressWarnings("serial")
public class ControleDeEnvio implements Serializable{

	private long idControleDEEnvio;
	private String nomeBase;
	private Date dataEnvio;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public long getIdControleDEEnvio() {
		return idControleDEEnvio;
	}
	public void setIdControleDEEnvio(long idControleDEEnvio) {
		this.idControleDEEnvio = idControleDEEnvio;
	}
	
	public String getNomeBase() {
		return nomeBase;
	}
	public void setNomeBase(String nomeBase) {
		this.nomeBase = nomeBase;
	}
	@Temporal(TemporalType.DATE)
	public Date getDataEnvio() {
		return dataEnvio;
	}
	public void setDataEnvio(Date dataEnvio) {
		this.dataEnvio = dataEnvio;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (idControleDEEnvio ^ (idControleDEEnvio >>> 32));
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
		ControleDeEnvio other = (ControleDeEnvio) obj;
		if (idControleDEEnvio != other.idControleDEEnvio)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "ControleDeEnvio [idControleDEEnvio=" + idControleDEEnvio + ", nomeBase=" + nomeBase + ", dataEnvio="
				+ dataEnvio + "]";
	}
	
	
}
