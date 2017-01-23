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
	private String assunto;
	private String mensagem;
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

	public String getBase() {
		return base;
	}

	public void setBase(String base) {
		this.base = base;
	}

	public String getAssunto() {
		return assunto;
	}
	
	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}
	
	public String getMensagem() {
		return mensagem;
	}
	
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	
	public void listarControle() {
		try {
			ControleDAO dao = new ControleDAO();
			this.envio = dao.listar();
		} catch (RuntimeException e) {
			FacesuUtil.msgErro("Ocorreu um erro ao carregar o controle de envio de e-mails! " + e.getMessage());
		}
	}

	public void eviarEmail() {
		try {
			ControleDAO dao = new ControleDAO();
			this.envio = new ControleDeEnvio();
			dao.salvar(envio);
			mail(this.base,this.caminho);
		} catch (RuntimeException e) {
			FacesuUtil.msgErro("Ocorreu um erro ao enviar os e-mails da base! ERRO: [ " + e.getMessage() + " ]");
		}
	}
	
	public void upload(FileUploadEvent evt){
		//UploadedFile arquivoUpload =  evt.getFile();
		try {
			Path arquivoTemp = Files.createTempFile(null, null);
			//Files.copy(arquivoUpload.getInputstream(), arquivoTemp, StandardCopyOption.REPLACE_EXISTING);
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
			this.envio.setNomeBase("PRIMEIRA");
			this.envio.setDataEnvio(new Date());
			
			carregarPrimeiraBase();
			//for (int i = 0; i < primeiraBase.size(); i++) {
				try {
					MimeMessage message = new MimeMessage(session);
					message.setSubject(this.assunto);
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
					String htmlText = "<h4>"+this.mensagem
							+ "</h4><br/><img src=\"cid:image\">";
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

					//Transport.send(message);
					System.out.println("Sucesso");
				} catch (MessagingException e) {
					System.out.println("Erro ao enviar e-mail! ERRO: [ " + e.getMessage() + " ]");
					e.printStackTrace();
				}
			//}
			try {
				ControleDAO dao = new ControleDAO();
				ControleDeEnvio controle = dao.listar();
				this.envio = controle;
				this.envio.setDataTerminoEnvio(new Date());
				//dao.atualizar(envio);
			} catch (RuntimeException e) {
				FacesuUtil.msgErro("Ocorreu um erro: [ "+e.getMessage()+" ]");
			}
			break;

		case "b2":
			this.envio.setNomeBase("SEGUNDA");
			this.envio.setDataEnvio(new Date());
			carregarSegundaBase();
			break;

		case "b3":
			this.envio.setNomeBase("TERCEIRA");
			this.envio.setDataEnvio(new Date());
			carregarTerceiraBase();
			break;

		case "b4":
			this.envio.setNomeBase("QUARTA");
			this.envio.setDataEnvio(new Date());
			carregarQuartaBase();
			break;

		case "b5":
			this.envio.setNomeBase("QUINTA");
			this.envio.setDataEnvio(new Date());
			carregarQuintaBase();
			break;

		}
	}
}
