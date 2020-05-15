import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.ArrayList;
import java.util.List;

import br.com.caelum.stella.validation.CNPJValidator;
import br.com.caelum.stella.validation.CPFValidator;

public class FopagUtils {

	private final static CPFValidator cpfValidator = new CPFValidator();
	
	private final static CNPJValidator cnpjValidator = new CNPJValidator();

	public static Boolean isCPFValido(final String cpf) {
		try {
			cpfValidator.assertValid(cpf);
			return true;
		}
		catch (final Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static Boolean isCNPJValido(final String cnpj) {
		try {
			cnpjValidator.assertValid(cnpj);
			return true;
		}
		catch (final Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static String getSomenteDigitos(final String texto) {
		final String digitos = texto.replaceAll("\\D+","");
		return digitos;
	}
	
	@SuppressWarnings("unused")
	public static boolean isDataValida(final String dataString) {
	    
		String dateFormat = "dd/MM/uuuu";

	    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(dateFormat).withResolverStyle(ResolverStyle.STRICT);
	    
	    try {
	        final LocalDate date = LocalDate.parse(dataString, dateTimeFormatter);	        
	        return true;
	    }
	    catch (DateTimeParseException e) {
	       return false;
	    } 
	}
	
	public static List<String> retornarLinhasArquivo (final String filePath) {		
		try {			
			final List<String> linhas = new ArrayList<String>();
			
			final BufferedReader br = new BufferedReader(new FileReader(filePath));
		    
		    String line = br.readLine();
		    
		    while (line != null) {
		    	linhas.add(line);    	
		    	line = br.readLine();
		    }
		    
		    br.close();
		    
		    return linhas;
		}
		catch(Exception e) {
		   System.out.println("ERRO");
		   System.out.println(e);
		   return null;
		}
	}

}
