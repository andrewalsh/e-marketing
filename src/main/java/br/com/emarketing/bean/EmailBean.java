package br.com.emarketing.bean;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

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
public class EmailBean implements Serializable {

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
	private String caminho;
	
	
	public ControleDeEnvio getEnvio() {
		if (this.envio == null) {
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

	public void listarControle() {
		try {
			ControleDAO dao = new ControleDAO();
			this.envio = dao.listar();
			habilitarEnvio();
		} catch (RuntimeException e) {
			FacesuUtil.msgErro("Ocorreu um erro ao carregar o controle de envio de e-mails! " + e.getMessage());
		}
	}

	public void eviarEmail() {
		try {
			ControleDAO dao = new ControleDAO();
			this.base = "b1";
			
			
			this.envio.setNomeBase("PRIMEIRA");
			this.envio.setDataEnvio(new Date());
			mail(this.base,this.caminho);
			dao.salvar(envio);
		} catch (RuntimeException e) {
			FacesuUtil.msgErro("Ocorreu um erro ao enviar os e-mails da base! ERRO: [ " + e.getMessage() + " ]");
		}
	}
	
	public void upload(FileUploadEvent evt){
		UploadedFile arquivoUpload =  evt.getFile();
		try {
			Path arquivoTemp = Files.createTempFile(null, null);
			Files.copy(arquivoUpload.getInputstream(), arquivoTemp, StandardCopyOption.REPLACE_EXISTING);
			caminho = arquivoTemp.toAbsolutePath().toString();
		} catch (IOException e) {
			FacesuUtil.msgErro("Ocorreu um erro! ERRO: [ " + e.getMessage() + " ]");
		}
	}

	private void carregarPrimeiraBase() {
		try {
			BaseDAO dao = new BaseDAO();
			primeiraBase = dao.listrarPrimeiraBase();
		} catch (RuntimeException e) {
			FacesuUtil.msgErro("Ocorreu um erro ao carregar os e-mails da base! ERRO: [ " + e.getMessage() + " ]");
		}
	}

	private void carregarSegundaBase() {
		try {
			BaseDAO dao = new BaseDAO();
			segundaBase = dao.listrarSegundaBase();
		} catch (RuntimeException e) {
			FacesuUtil.msgErro("Ocorreu um erro ao carregar os e-mails da base! ERRO: [ " + e.getMessage() + " ]");
		}
	}

	private void carregarTerceiraBase() {
		try {
			BaseDAO dao = new BaseDAO();
			terceiraBase = dao.listrarTerceiraBase();
		} catch (RuntimeException e) {
			FacesuUtil.msgErro(
					"Ocorreu um erro ao carregar os e-mails da primeira base! ERRO: [ " + e.getMessage() + " ]");
		}
	}

	private void carregarQuartaBase() {
		try {
			BaseDAO dao = new BaseDAO();
			quartaBase = dao.listrarQuartaBase();
		} catch (RuntimeException e) {
			FacesuUtil.msgErro("Ocorreu um erro ao carregar os e-mails da base! ERRO: [ " + e.getMessage() + " ]");
		}
	}

	private void carregarQuintaBase() {
		try {
			BaseDAO dao = new BaseDAO();
			quintaBase = dao.listrarQuintaBase();
		} catch (RuntimeException e) {
			FacesuUtil.msgErro("Ocorreu um erro ao carregar os e-mails da base! ERRO: [ " + e.getMessage() + " ]");
		}
	}

	
	private void habilitarEnvio() {
		if (this.envio == null || this.envio.getNomeBase().equals("QUINTA")) {
			setBtn1(false);
			setBtn2(true);
			setBtn3(true);
			setBtn4(true);
			setBtn5(true);
			carregarPrimeiraBase();
		} else if (this.envio.getNomeBase().equals("SEGUNDA")) {
			setBtn1(true);
			setBtn2(false);
			setBtn3(true);
			setBtn4(true);
			setBtn5(true);
			carregarSegundaBase();
		} else if (this.envio.getNomeBase().equals("TERCEIRA")) {
			setBtn1(true);
			setBtn2(true);
			setBtn3(false);
			setBtn4(true);
			setBtn5(true);
			carregarTerceiraBase();
		} else if (this.envio.getNomeBase().equals("QUARTA")) {
			setBtn1(true);
			setBtn2(true);
			setBtn3(true);
			setBtn4(false);
			setBtn5(true);
			carregarQuartaBase();
		} else if (this.envio.getNomeBase().equals("QUINTA")) {
			setBtn1(true);
			setBtn2(true);
			setBtn3(true);
			setBtn4(true);
			setBtn5(false);
			carregarQuintaBase();
		}
	}

	private void mail(String base, String caminho) {
		Properties properties = new Properties();

		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.socketFactory.port", "465");
		properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.port", "465");

		Session session = Session.getDefaultInstance(properties, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("andre.walsh@gmail.com", "theo@2014");
			}
		});

		session.setDebug(true);

		switch (base) {
		case "b1":
			//for (int i = 0; i < primeiraBase.size(); i++) {
				try {
					MimeMessage message = new MimeMessage(session);
					message.setSubject("TEO - Teste de envio de e-mail");
					message.setFrom(new InternetAddress("andre.walsh@gmail.com"));
					message.addRecipient(Message.RecipientType.TO,
							new InternetAddress("andre.walsh@gmail.com"));
							//new InternetAddress(primeiraBase.get(i).getBase().getEmail()));
					//
					// Este email HTML tem 2 partes, BODY e imagem embutida
					//
					MimeMultipart multipart = new MimeMultipart("related");
					// 1a parte- html
					BodyPart messageBodyPart = new MimeBodyPart();
					String htmlText = "<H3>18/01/2017 Teste 3 de e-mail, imagem no corpo da mensagem...</H3><br/>"
							+ "<h3>Testando formato de imagem suportado... imagem formato JPG apresentou erro</h3><br/>"
							+ "<h3>Adicionando outra imagem no formato PNG</h3>"
							+ "<img src=\"cid:image\">";
					message.setSubject("E-mail - Teste ");
					messageBodyPart.setContent(htmlText, "text/html");
					// Adiciona
					multipart.addBodyPart(messageBodyPart);
					// Segunda parte - a imagem
					File file = new File(caminho);
					messageBodyPart = new MimeBodyPart();
					FileDataSource da = new FileDataSource(file);
					messageBodyPart.setDataHandler(new DataHandler(da));
					messageBodyPart.setHeader("Content-ID", "<image>");
					// Adiciona
					multipart.addBodyPart(messageBodyPart);
					// coloca tudo junto
					message.setContent(multipart);

					Transport.send(message);
					System.out.println("Sucesso");
				} catch (MessagingException e) {
					System.out.println("Erro ao enviar e-mail! ERRO: [ " + e.getMessage() + " ]");
					e.printStackTrace();
				}
			//}
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

		}
	}
}
