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

}
