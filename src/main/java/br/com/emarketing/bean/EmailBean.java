package br.com.emarketing.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.emarketing.dao.ControleDAO;
import br.com.emarketing.entity.ControleDeEnvio;
import br.com.emarketing.entity.PrimeiraBase;
import br.com.emarketing.entity.QuartaBase;
import br.com.emarketing.entity.QuintaBase;
import br.com.emarketing.entity.SegundaBase;
import br.com.emarketing.entity.TerceiraBase;
import br.com.emarketing.facesutil.FacesuUtil;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class EmailBean implements Serializable{

	private ControleDeEnvio envio;
	private List<PrimeiraBase> primeiraBase;
	private List<SegundaBase> segundaBase;
	private List<TerceiraBase> terceiraBase;
	private List<QuartaBase> quartaBase;
	private List<QuintaBase> quintaBase;
	private List<ControleDeEnvio> envios;
	private boolean btn1;
	private boolean btn2;
	private boolean btn3;
	private boolean btn4;
	private boolean btn5;
	
	
	public ControleDeEnvio getEnvio() {
		if(this.envio == null){
			this.envio = new ControleDeEnvio();
		}
		return envio;
	}
	public void setEnvio(ControleDeEnvio envio) {
		this.envio = envio;
	}
	public List<PrimeiraBase> getPrimeiraBase() {
		return primeiraBase;
	}
	public void setPrimeiraBase(List<PrimeiraBase> primeiraBase) {
		this.primeiraBase = primeiraBase;
	}
	public List<SegundaBase> getSegundaBase() {
		return segundaBase;
	}
	public void setSegundaBase(List<SegundaBase> segundaBase) {
		this.segundaBase = segundaBase;
	}
	public List<TerceiraBase> getTerceiraBase() {
		return terceiraBase;
	}
	public void setTerceiraBase(List<TerceiraBase> terceiraBase) {
		this.terceiraBase = terceiraBase;
	}
	public List<QuartaBase> getQuartaBase() {
		return quartaBase;
	}
	public void setQuartaBase(List<QuartaBase> quartaBase) {
		this.quartaBase = quartaBase;
	}
	public List<QuintaBase> getQuintaBase() {
		return quintaBase;
	}
	public void setQuintaBase(List<QuintaBase> quintaBase) {
		this.quintaBase = quintaBase;
	}
	public List<ControleDeEnvio> getEnvios() {
		return envios;
	}
	public void setEnvios(List<ControleDeEnvio> envios) {
		this.envios = envios;
	}
	public boolean isBtn1() {
		return btn1;
	}
	public void setBtn1(boolean btn1) {
		this.btn1 = btn1;
	}
	public boolean isBtn2() {
		return btn2;
	}
	public void setBtn2(boolean btn2) {
		this.btn2 = btn2;
	}
	public boolean isBtn3() {
		return btn3;
	}
	public void setBtn3(boolean btn3) {
		this.btn3 = btn3;
	}
	public boolean isBtn4() {
		return btn4;
	}
	public void setBtn4(boolean btn4) {
		this.btn4 = btn4;
	}
	public boolean isBtn5() {
		return btn5;
	}
	public void setBtn5(boolean btn5) {
		this.btn5 = btn5;
	}
	
	
	
	public void listarControle(){
		try {
			ControleDAO dao = new ControleDAO();
			this.envio = dao.listar();
			habilitarEnvio();
		} catch (RuntimeException e) {
			FacesuUtil.msgErro("Ocorreu um erro ao carregar o controle de envio de e-mails! "+e.getMessage());
		}
	}
	
	private void habilitarEnvio(){
		if(this.envio == null || this.envio.getNomeBase().equals(NomeBase.QUINTA_BASE)){
			setBtn1(false);
			setBtn2(true);
			setBtn3(true);
			setBtn4(true);
			setBtn5(true);
		}else if(this.envio.getNomeBase().equals(NomeBase.SEGUNDA_BASE)){
			setBtn1(true);
			setBtn2(false);
			setBtn3(true);
			setBtn4(true);
			setBtn5(true);
		}else if(this.envio.getNomeBase().equals(NomeBase.TERCEIRA_BASE)){
			setBtn1(true);
			setBtn2(true);
			setBtn3(false);
			setBtn4(true);
			setBtn5(true);
		}else if(this.envio.getNomeBase().equals(NomeBase.QUARTA_BASE)){
			setBtn1(true);
			setBtn2(true);
			setBtn3(true);
			setBtn4(false);
			setBtn5(true);
		}else if(this.envio.getNomeBase().equals(NomeBase.QUINTA_BASE)){
			setBtn1(true);
			setBtn2(true);
			setBtn3(true);
			setBtn4(true);
			setBtn5(false);
		}
	}
}
