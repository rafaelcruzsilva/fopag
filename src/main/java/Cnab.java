
public class Cnab {

	private String nomeColaborador;
	private String numeroConta;
	private String digitoVerificador;
	private String tipoRetorno;

	public Cnab() {
	}

	public String getNomeColaborador() {
		return nomeColaborador;
	}

	public void setNomeColaborador(String nomeColaborador) {
		this.nomeColaborador = nomeColaborador;
	}

	public String getNumeroConta() {
		return numeroConta;
	}

	public void setNumeroConta(String numeroConta) {
		this.numeroConta = numeroConta;
	}

	public String getDigitoVerificador() {
		return digitoVerificador;
	}

	public void setDigitoVerificador(String digitoVerificador) {
		this.digitoVerificador = digitoVerificador;
	}

	public String getTipoRetorno() {
		return tipoRetorno;
	}

	public void setTipoRetorno(String tipoRetorno) {
		this.tipoRetorno = tipoRetorno;
	}

	@Override
	public String toString() {
		return "Cnab [nomeColaborador=" + nomeColaborador + ", numeroConta=" + numeroConta + ", digitoVerificador="
				+ digitoVerificador + ", tipoRetorno=" + tipoRetorno + "]";
	}

}
