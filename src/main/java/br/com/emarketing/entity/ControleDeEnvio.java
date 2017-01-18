package br.com.emarketing.entity;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity

public class ControleDeEnvio {
	
	private long idControleDeEnvio;
	private String nomeBase;
	private Date dataEnvio;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public long getIdControleDeEnvio() {
		return idControleDeEnvio;
	}
	public void setIdControleDeEnvio(long idControleDeEnvio) {
		this.idControleDeEnvio = idControleDeEnvio;
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
		result = prime * result + (int) (idControleDeEnvio ^ (idControleDeEnvio >>> 32));
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
		if (idControleDeEnvio != other.idControleDeEnvio)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "ControleDeEnvio [idControleDeEnvio=" + idControleDeEnvio + ", nome base=" + nomeBase
				+ ", dataEnvio=" + dataEnvio + "]";
	}
	
	
}
