package br.com.sprintters.prettystyle.command.paymentsteps;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.UUID;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import br.com.caelum.stella.boleto.Banco;
import br.com.caelum.stella.boleto.Beneficiario;
import br.com.caelum.stella.boleto.Boleto;
import br.com.caelum.stella.boleto.Datas;
import br.com.caelum.stella.boleto.Endereco;
import br.com.caelum.stella.boleto.Pagador;
import br.com.caelum.stella.boleto.bancos.BancoDoBrasil;
import br.com.caelum.stella.boleto.transformer.GeradorDeBoleto;
import br.com.sprintters.prettystyle.command.Command;
import br.com.sprintters.prettystyle.model.Item;
import br.com.sprintters.prettystyle.model.ItemRequest;
import br.com.sprintters.prettystyle.model.Request;
import br.com.sprintters.prettystyle.model.User;
import br.com.sprintters.prettystyle.model.generic.Json;
import br.com.sprintters.prettystyle.model.virtual.Cart;
import br.com.sprintters.prettystyle.service.ItemService;
import br.com.sprintters.prettystyle.service.RequestService;
import br.com.sprintters.prettystyle.service.UserService;

public class Pay implements Command {
	private static final String SAVE_DIR = "pretty-style\\bankSlips";
	private static final String SAVE_DIR_PDF = "\\PDF";
	private static final String SAVE_DIR_PNG = "\\PNG";
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, Exception {
		try {
			int idUser = (int)request.getAttribute("idUser");
			String typePayment = request.getParameter("paymentType");
			boolean isJson = Boolean.parseBoolean(request.getParameter("json"));
			
			ItemService is = new ItemService();
			RequestService rs = new RequestService();
			UserService us = new UserService();
			
			User user = us.find(idUser);
			Cart cart = null;
			
			if(user.isProvider()) cart = is.listItemsInCartByIdClient(user.getProvider().getId());
			else cart = is.listItemsInCartByIdClient(user.getClient().getId());				
			
			ArrayList<Item> lista = cart.getItems();
			
			double total = 0.0;
			double totalItems = 0.0;
			double frete = 0.0;
			double bankSlip = 0.0;
			
			for (Item item : lista) {
				totalItems += item.getProduct().getPrice() * item.getQuantity();
				if (item.getProduct().getPrice() > 400) {
					frete += item.getProduct().getPrice() * 0.02;
				} else {
					frete += item.getProduct().getPrice() * 0.082;
				}
			}
			
			total = totalItems + frete;
			bankSlip = total - (total * 0.05);
  			
  			double totalPrice = 0.0;
  			
  			String boletoPDFPath = "";
  			String boletoPNGPath = "";
  			UUID uuidRandom = UUID.randomUUID();
  			
  			String idClientPadded = "";
  			
  			if(user.isProvider()) idClientPadded = String.format("%03d" , user.getProvider().getId());
  			else idClientPadded = String.format("%03d" , user.getClient().getId());
  			
  			String numberRequest = idClientPadded + "-" + uuidRandom.toString();
  			
  			if (typePayment.equals("creditCard")) {
  				int numberParcels = Integer.parseInt(request.getParameter("cardParcels"));
  				if (numberParcels == 1) {
  					totalPrice = bankSlip;
  				}
				else {
					totalPrice = total;
				}
  			} else {
  				String appPath = request.getServletContext().getRealPath("");
  				String savePath = "";
  				
  				for (int i = 0; i < appPath.length(); i++) {
  					if (!String.valueOf(appPath.charAt(i)).equals(".")) {
  						savePath += appPath.charAt(i);
  					}
  					else break;
  				}
  				
  				checkIfDirectoryExists(savePath);
  				checkIfDirectoryExists(appPath.replace("pretty-style", ""));
  				
  				Datas datas = Datas.novasDatas()
					.comDocumento(1, 5, 2008)
	                .comProcessamento(1, 5, 2008)
	                .comVencimento(2, 5, 2008);
  				
  				Endereco enderecoBeneficiario = Endereco.novoEndereco()
	        		.comLogradouro("Av das Empresas, 555")  
	        		.comBairro("Bairro Grande")  
	        		.comCep("01234-555")  
	        		.comCidade("São Paulo")  
	        		.comUf("SP");
  				
  				Beneficiario beneficiario = Beneficiario.novoBeneficiario()  
	                .comNomeBeneficiario("Fulano de Tal")  
	                .comAgencia("1824").comDigitoAgencia("4")  
	                .comCodigoBeneficiario("76000")  
	                .comDigitoCodigoBeneficiario("5")  
	                .comNumeroConvenio("1207113")  
	                .comCarteira("18")  
	                .comEndereco(enderecoBeneficiario)
	                .comNossoNumero("9000206")
	                .comDigitoNossoNumero("347-1");
  				
  				Endereco enderecoPagador = Endereco.novoEndereco()
	        		.comLogradouro("Av dos testes, 111 apto 333")  
	        		.comBairro("Bairro Teste")  
	        		.comCep("01234-111")  
	        		.comCidade("São Paulo")  
	        		.comUf("SP");
  				
  		        Pagador pagador = Pagador.novoPagador()  
	                .comNome("Fulano da Silva")  
	                .comDocumento("111.222.333-12")
	                .comEndereco(enderecoPagador);

  		        Banco banco = new BancoDoBrasil();

  		        Boleto boleto = Boleto.novoBoleto()
	                .comBanco(banco)
	                .comDatas(datas)
	                .comBeneficiario(beneficiario)
	                .comPagador(pagador)
	                .comValorBoleto("200.00")
	                .comNumeroDoDocumento("1234")
	                .comInstrucoes("instrucao 1", "instrucao 2", "instrucao 3", "instrucao 4", "instrucao 5")
	                .comLocaisDePagamento("local 1", "local 2");

  		        GeradorDeBoleto gerador = new GeradorDeBoleto(boleto);
 
  		        byte[] bPDF = gerador.geraPDF();
  		        byte[] bPNG = gerador.geraPNG();
  		        
  		        String pdfFileName = numberRequest + ".pdf";
  		        String pngFileName = numberRequest + ".png";
  		        
  		        OutputStream out = new FileOutputStream(savePath+SAVE_DIR+SAVE_DIR_PDF+"\\"+pdfFileName);
	  		    out.write(bPDF);
	  		    out.close();
  		        
  		        ByteArrayInputStream bis = new ByteArrayInputStream(bPNG);
  		        BufferedImage bImage2 = ImageIO.read(bis);
				ImageIO.write(bImage2, "png", new File(savePath+SAVE_DIR+SAVE_DIR_PNG+"\\"+pngFileName));
  				
  				totalPrice = bankSlip;
  				
  				Files.copy(Paths.get(savePath + "\\pretty-style\\bankSlips\\" + SAVE_DIR_PDF + "\\" + pdfFileName), Paths.get(appPath + "\\bankSlips\\" + SAVE_DIR_PDF + "\\" + pdfFileName));
  				Files.copy(Paths.get(savePath + "\\pretty-style\\bankSlips\\" + SAVE_DIR_PNG + "\\" + pngFileName), Paths.get(appPath + "\\bankSlips\\" + SAVE_DIR_PNG + "\\" + pngFileName));
  				
  				boletoPDFPath = "/PrettyStyle\\bankSlips\\PDF\\"+pdfFileName;
  				boletoPNGPath = "/PrettyStyle\\bankSlips\\PNG\\"+pngFileName;
  			}
  			
  			Request req = null;
  			
  			if(user.isProvider()) {
  				req = new Request(user.getProvider().getId(), totalPrice, numberRequest.toString(), typePayment);  				
  				int idRequest = rs.create(req);
  				
  				for (Item item : lista) {
  					ItemRequest ir = new ItemRequest();
  					ir.setIdRequest(idRequest);
  					ir.setIdItem(item.getId());
  					rs.createItemRequest(ir);
  					item.setIdClient(user.getProvider().getId());
  					is.setItemPaid(item);
  					is.updateQuantity(item);
  				}
  			}
  			else {
  				req = new Request(user.getClient().getId(), totalPrice, numberRequest.toString(), typePayment);  				
  				int idRequest = rs.create(req);
  				
  				for (Item item : lista) {
  					ItemRequest ir = new ItemRequest();
  					ir.setIdRequest(idRequest);
  					ir.setIdItem(item.getId());
  					rs.createItemRequest(ir);
  					item.setIdClient(user.getClient().getId());
  					is.setItemPaid(item);
  					is.updateQuantity(item);
  				
  				}
  			}
			
			if (isJson) {
				Json json = new Json(true, "", lista);
				
				response.setContentType("application/json");
				response.getWriter().write(new Gson().toJson(json).toString());
			} else {
				HttpSession session = request.getSession();
				
				session.setAttribute("numberRequest", numberRequest);
				
				if(user.isProvider()) {
					session.setAttribute("numberClient", user.getProvider().getId());
					session.setAttribute("clientName", user.getProvider().getFantasyName());
				} else {
					session.setAttribute("numberClient", user.getClient().getId());
					session.setAttribute("clientName", user.getClient().getName());
					session.setAttribute("clientSurname", user.getClient().getSurname());
				}
				
				session.setAttribute("boletoPDF", boletoPDFPath);
				session.setAttribute("boletoPNG", boletoPNGPath);
				
				response.sendRedirect("/PrettyStyle/App/pages/thanks/thanks.jsp");
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	static void checkIfDirectoryExists(String savePath) {
		String bankSlipsPath = savePath + SAVE_DIR;
		String pdfPath = savePath + SAVE_DIR + SAVE_DIR_PDF;
		String pngPath = savePath + SAVE_DIR + SAVE_DIR_PNG;
		
		File bankSlipsDirectory = new File(bankSlipsPath);
		File pdfDirectory = new File(pdfPath);
		File pngDirectory = new File(pngPath);
		
		if (!bankSlipsDirectory.exists()) bankSlipsDirectory.mkdir();
		if (!pdfDirectory.exists()) pdfDirectory.mkdir();
		if (!pngDirectory.exists()) pngDirectory.mkdir();
	}
}
