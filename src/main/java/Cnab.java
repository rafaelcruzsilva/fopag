
public class Cnab {

	private String nomeColaborador;
	private String numeroConta;
	private String digitoVerificador;
	private String tipoRetorno;
	private String cpf;
	private String numeroAgencia;

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
	
	public String getcpf() {
		return cpf;
	}

	public void setcpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getNumeroAgencia() {
		return numeroAgencia;
	}

	public void setNumeroAgencia(String numeroAgencia) {
		this.numeroAgencia = numeroAgencia;
	}


	@Override
	public String toString() {
		return "Cnab [nomeColaborador=" + nomeColaborador + ", numeroConta=" + numeroConta + ", digitoVerificador="
				+ digitoVerificador + ", tipoRetorno=" + tipoRetorno + ", cpf=" + cpf + ", numeroAgencia=" + numeroAgencia + "]";
	}

}
