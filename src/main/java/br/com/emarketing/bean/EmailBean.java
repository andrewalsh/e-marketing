package br.com.emarketing.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.emarketing.dao.BaseDAO;
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
	private String base;
	
	
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
	public String getBase() {
		return base;
	}
	public void setBase(String base) {
		this.base = base;
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
	
	public void eviarEmail(String base){
		try {
			ControleDAO dao = new ControleDAO();
			this.base = base;
			popularEnvio(this.base);
			
		} catch (RuntimeException e) {
			// TODO: handle exception
		}
	}
	
	
	private void carregarPrimeiraBase(){
		try {
			BaseDAO dao = new BaseDAO();
			primeiraBase = dao.listrarPrimeiraBase();
		} catch (RuntimeException e) {
			FacesuUtil.msgErro("Ocorreu um erro ao carregar os e-mails da base! ERRO: [ "+e.getMessage()+" ]");
		}
	}
	
	private void carregarSegundaBase(){
		try {
			BaseDAO dao = new BaseDAO();
			segundaBase = dao.listrarSegundaBase();
		} catch (RuntimeException e) {
			FacesuUtil.msgErro("Ocorreu um erro ao carregar os e-mails da base! ERRO: [ "+e.getMessage()+" ]");
		}
	}
	
	
	private void carregarTerceiraBase(){
		try {
			BaseDAO dao = new BaseDAO();
			terceiraBase = dao.listrarTerceiraBase();
		} catch (RuntimeException e) {
			FacesuUtil.msgErro("Ocorreu um erro ao carregar os e-mails da primeira base! ERRO: [ "+e.getMessage()+" ]");
		}
	}
	
	private void carregarQuartaBase(){
		try {
			BaseDAO dao = new BaseDAO();
			quartaBase = dao.listrarQuartaBase();
		} catch (RuntimeException e) {
			FacesuUtil.msgErro("Ocorreu um erro ao carregar os e-mails da base! ERRO: [ "+e.getMessage()+" ]");
		}
	}
	
	private void carregarQuintaBase(){
		try {
			BaseDAO dao = new BaseDAO();
			quintaBase = dao.listrarQuintaBase();
		} catch (RuntimeException e) {
			FacesuUtil.msgErro("Ocorreu um erro ao carregar os e-mails da base! ERRO: [ "+e.getMessage()+" ]");
		}
	}
	
	
	private void popularEnvio(String base){
		this.envio.setDataEnvio(new Date());
		switch (base) {
		case "b1":
			this.envio.setNomeBase("PRIMEIRA");
			break;
			
		case "b2":
			this.envio.setNomeBase("SEGUNDA");
			break;
			
		case "b3":
			this.envio.setNomeBase("TERCEIRA");
			break;
		
		case "b4":
			this.envio.setNomeBase("QUARTA");
			break;
			
		case "b5":
			this.envio.setNomeBase("QUINTA");
			break;
		default:
			break;
		}
	}
	
	private void habilitarEnvio(){
		if(this.envio == null || this.envio.getNomeBase().equals("QUINTA")){
			setBtn1(false);
			setBtn2(true);
			setBtn3(true);
			setBtn4(true);
			setBtn5(true);
			carregarPrimeiraBase();
		}else if(this.envio.getNomeBase().equals("SEGUNDA")){
			setBtn1(true);
			setBtn2(false);
			setBtn3(true);
			setBtn4(true);
			setBtn5(true);
			carregarSegundaBase();
		}else if(this.envio.getNomeBase().equals("TERCEIRA")){
			setBtn1(true);
			setBtn2(true);
			setBtn3(false);
			setBtn4(true);
			setBtn5(true);
			carregarTerceiraBase();
		}else if(this.envio.getNomeBase().equals("QUARTA")){
			setBtn1(true);
			setBtn2(true);
			setBtn3(true);
			setBtn4(false);
			setBtn5(true);
			carregarQuartaBase();
		}else if(this.envio.getNomeBase().equals("QUINTA")){
			setBtn1(true);
			setBtn2(true);
			setBtn3(true);
			setBtn4(true);
			setBtn5(false);
			carregarQuintaBase();
		}
	}
}
