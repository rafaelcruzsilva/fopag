import br.com.caelum.stella.validation.CPFValidator;

public class FopagUtils {

	private final static CPFValidator cpfValidator = new CPFValidator();

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

}
