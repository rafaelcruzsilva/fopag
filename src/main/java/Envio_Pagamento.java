import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

public class Envio_Pagamento {
	
	private static final SimpleDateFormat DATE_FORMAT_BR = new SimpleDateFormat("ddMMYYYY");
	
	private static final SimpleDateFormat DATE_FORMAT_US = new SimpleDateFormat("YYYYMMdd");
	
	private static final SimpleDateFormat HH_MM_SS_FORMAT = new SimpleDateFormat("HHmmss");


	public JFrame frame;
	private JTextField txtCodbancoemp;
	private JTextField txtTpinscricao;
	private JTextField txtConvenio;
	private JTextField txtAgenciaemp;
	private JTextField txtBancoemp;
	private JTextField txtDvemp;
	private JTextField txtContacorrenteemp;
	private JTextField txtEmpresa;
	private JTextField txtRuaemp;
	private JTextField txtNresidemp;
	private JTextField txtCompemp;
	private JTextField txtCidadeemp;
	private JTextField txtCepemp;
	private JTextField txtEstadoemp;
	private JTextField txtAgenciacolab;
	private JTextField txtBancocolab;
	private JTextField txtDvcolab;
	private JTextField txtContacorrentecolab;
	private JTextField txtCodigobcocolab;
	private JTextField txtValor;
	private JTextField txtDatapagto;
	private JTextField txtCpf;
	private JTextField txtColaborador;
	private JTextField txtRuacolab;
	private JTextField txtNresidcolab;
	private JTextField txtCompresidcolab;
	private JTextField txtCidadecolab;
	private JTextField txtCepcolab;
	private JTextField txtEstadocolab;
	private JTextField txtCnpj;

	/**
	 * OriginalApp
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Envio_Pagamento window = new Envio_Pagamento();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Envio_Pagamento() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Remessa de Pagamento - Banco Original");
		frame.setBounds(100, 100, 660, 930);
		frame.getContentPane().setLayout(null);
		
//		MaskFormatter dataMascara = null;
		
//		try {
//			dataMascara = new MaskFormatter("##/##/####");
//		} catch (ParseException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
		
		JLabel lblGeraoDoArquivo = new JLabel("Gera\u00E7\u00E3o do Arquivo CNAB 240 - Pagamento de Sal\u00E1rio");
		lblGeraoDoArquivo.setHorizontalAlignment(SwingConstants.CENTER);
		lblGeraoDoArquivo.setFont(new Font("Calibri", Font.PLAIN, 25));
		lblGeraoDoArquivo.setBounds(5, 2, 635, 60);
		frame.getContentPane().add(lblGeraoDoArquivo);
		
		JPanel panelDadosempresa = new JPanel();
		panelDadosempresa.setLayout(null);
		panelDadosempresa.setBorder(UIManager.getBorder("ComboBox.border"));
		panelDadosempresa.setBounds(5, 65, 635, 181);
		frame.getContentPane().add(panelDadosempresa);
		
		JLabel lbcnpj = new JLabel("CNPJ");
		lbcnpj.setFont(new Font("Calibri", Font.PLAIN, 16));
		lbcnpj.setBounds(15, 30, 140, 20);
		panelDadosempresa.add(lbcnpj);
		
		JLabel lddadospagto = new JLabel("Dados do Empresa");
		lddadospagto.setFont(new Font("Calibri", Font.BOLD, 16));
		lddadospagto.setBounds(15, 5, 412, 20);
		panelDadosempresa.add(lddadospagto);
		
		JLabel lbtpinscricao = new JLabel("Tipo de Inscri\u00E7ao");
		lbtpinscricao.setFont(new Font("Calibri", Font.PLAIN, 16));
		lbtpinscricao.setBounds(320, 80, 140, 20);
		panelDadosempresa.add(lbtpinscricao);
		
		txtTpinscricao = new JTextField();
		txtTpinscricao.setFont(new Font("Calibri", Font.PLAIN, 16));
		txtTpinscricao.setColumns(10);
		txtTpinscricao.setBounds(488, 80, 140, 20);
		panelDadosempresa.add(txtTpinscricao);
		
		JLabel lbconvenio = new JLabel("Convenio");
		lbconvenio.setFont(new Font("Calibri", Font.PLAIN, 16));
		lbconvenio.setBounds(15, 80, 140, 20);
		panelDadosempresa.add(lbconvenio);
		
		txtConvenio = new JTextField();
		txtConvenio.setFont(new Font("Calibri", Font.PLAIN, 16));
		txtConvenio.setColumns(10);
		txtConvenio.setBounds(170, 80, 140, 20);
		panelDadosempresa.add(txtConvenio);
		
		JLabel lbempresa = new JLabel("Nome da Empresa");
		lbempresa.setFont(new Font("Calibri", Font.PLAIN, 16));
		lbempresa.setBounds(15, 55, 140, 20);
		panelDadosempresa.add(lbempresa);
		
		txtEmpresa = new JTextField();
		txtEmpresa.setFont(new Font("Calibri", Font.PLAIN, 16));
		txtEmpresa.setColumns(10);
		txtEmpresa.setBounds(170, 55, 458, 20);
		panelDadosempresa.add(txtEmpresa);
		
		JLabel lbruaemp = new JLabel("Rua");
		lbruaemp.setFont(new Font("Calibri", Font.PLAIN, 16));
		lbruaemp.setBounds(15, 105, 140, 20);
		panelDadosempresa.add(lbruaemp);
		
		txtRuaemp = new JTextField();
		txtRuaemp.setFont(new Font("Calibri", Font.PLAIN, 16));
		txtRuaemp.setColumns(10);
		txtRuaemp.setBounds(170, 105, 310, 20);
		panelDadosempresa.add(txtRuaemp);
		
		JLabel lblNr = new JLabel("Nr");
		lblNr.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblNr.setBounds(488, 105, 40, 20);
		panelDadosempresa.add(lblNr);
		
		JLabel lbcompemp = new JLabel("Complemento");
		lbcompemp.setFont(new Font("Calibri", Font.PLAIN, 16));
		lbcompemp.setBounds(15, 130, 140, 20);
		panelDadosempresa.add(lbcompemp);
		
		txtNresidemp = new JTextField();
		txtNresidemp.setFont(new Font("Calibri", Font.PLAIN, 16));
		txtNresidemp.setColumns(10);
		txtNresidemp.setBounds(528, 105, 100, 20);
		panelDadosempresa.add(txtNresidemp);
		
		txtCompemp = new JTextField();
		txtCompemp.setFont(new Font("Calibri", Font.PLAIN, 16));
		txtCompemp.setColumns(10);
		txtCompemp.setBounds(170, 130, 140, 20);
		panelDadosempresa.add(txtCompemp);
		
		JLabel lbcidade = new JLabel("Cidade");
		lbcidade.setFont(new Font("Calibri", Font.PLAIN, 16));
		lbcidade.setBounds(340, 130, 140, 20);
		panelDadosempresa.add(lbcidade);
		
		txtCidadeemp = new JTextField();
		txtCidadeemp.setFont(new Font("Calibri", Font.PLAIN, 16));
		txtCidadeemp.setColumns(10);
		txtCidadeemp.setBounds(488, 130, 140, 20);
		panelDadosempresa.add(txtCidadeemp);
		
		JLabel lbcep = new JLabel("CEP");
		lbcep.setFont(new Font("Calibri", Font.PLAIN, 16));
		lbcep.setBounds(15, 155, 140, 25);
		panelDadosempresa.add(lbcep);
		
		txtCepemp = new JTextField();
		txtCepemp.setFont(new Font("Calibri", Font.PLAIN, 16));
		txtCepemp.setColumns(10);
		txtCepemp.setBounds(170, 155, 140, 20);
		panelDadosempresa.add(txtCepemp);
		
		JLabel lbestado = new JLabel("Estado");
		lbestado.setFont(new Font("Calibri", Font.PLAIN, 16));
		lbestado.setBounds(340, 155, 140, 20);
		panelDadosempresa.add(lbestado);
		
		txtEstadoemp = new JTextField();
		txtEstadoemp.setFont(new Font("Calibri", Font.PLAIN, 16));
		txtEstadoemp.setColumns(10);
		txtEstadoemp.setBounds(488, 155, 140, 20);
		panelDadosempresa.add(txtEstadoemp);
		
		txtCnpj = new JTextField();
		txtCnpj.setHorizontalAlignment(SwingConstants.RIGHT);
		txtCnpj.setFont(new Font("Calibri", Font.PLAIN, 16));
		txtCnpj.setColumns(10);
		txtCnpj.setBounds(170, 30, 310, 20);
		panelDadosempresa.add(txtCnpj);
		
		JButton btnPesquisarcnpj = new JButton("Pesquisar");
		btnPesquisarcnpj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
			    {
					
					if (!FopagUtils.isCNPJValido(txtCnpj.getText())) {
						JOptionPane.showMessageDialog(null, "CNPJ inválido", "Erro", JOptionPane.ERROR_MESSAGE);
						return;
					}
					
			    	ResultSet resultado = Fopag.connection.getData(String.format("SELECT * FROM fopagdb.empresatb WHERE cnpj LIKE '%s'", txtCnpj.getText()));
			    	
				    while (resultado.next())
		            {
		                txtEmpresa.setText(resultado.getString("empresa"));
		                txtConvenio.setText(resultado.getString("convenio"));
		                txtTpinscricao.setText(resultado.getString("inscricao"));
		                txtRuaemp.setText(resultado.getString("rua"));
		                txtNresidemp.setText(resultado.getString("nresid"));
		                txtCompemp.setText(resultado.getString("compresid"));
		                txtCidadeemp.setText(resultado.getString("cidade"));
		                txtCepemp.setText(resultado.getString("cep"));
		                txtEstadoemp.setText(resultado.getString("estado"));
		                txtCodbancoemp.setText(resultado.getString("codigobco"));
		                txtAgenciaemp.setText(resultado.getString("agencia"));
		                txtContacorrenteemp.setText(resultado.getString("conta"));
		                txtDvemp.setText(resultado.getString("dv"));
		                txtBancoemp.setText(resultado.getString("banco"));
		            }
			    }
			    catch (Exception ex)
				{
				    ex.printStackTrace();
				}
			}
		});
		btnPesquisarcnpj.setFont(new Font("Calibri", Font.PLAIN, 16));
		btnPesquisarcnpj.setBounds(488, 30, 140, 20);
		panelDadosempresa.add(btnPesquisarcnpj);
		
		JPanel panelDadosconta = new JPanel();
		panelDadosconta.setLayout(null);
		panelDadosconta.setBorder(UIManager.getBorder("ComboBox.border"));
		panelDadosconta.setBounds(5, 248, 635, 106);
		frame.getContentPane().add(panelDadosconta);
		
		JLabel lbAgencia = new JLabel("Agencia");
		lbAgencia.setHorizontalAlignment(SwingConstants.LEFT);
		lbAgencia.setFont(new Font("Calibri", Font.PLAIN, 16));
		lbAgencia.setBounds(320, 30, 140, 20);
		panelDadosconta.add(lbAgencia);
		
		txtAgenciaemp = new JTextField();
		txtAgenciaemp.setFont(new Font("Calibri", Font.PLAIN, 16));
		txtAgenciaemp.setColumns(10);
		txtAgenciaemp.setBounds(488, 30, 140, 20);
		panelDadosconta.add(txtAgenciaemp);
		
		JLabel lbcontaorigem = new JLabel("Dados da Conta Corrente de origem");
		lbcontaorigem.setFont(new Font("Calibri", Font.BOLD, 16));
		lbcontaorigem.setBounds(15, 5, 412, 20);
		panelDadosconta.add(lbcontaorigem);
		
		txtBancoemp = new JTextField();
		txtBancoemp.setFont(new Font("Calibri", Font.PLAIN, 16));
		txtBancoemp.setColumns(10);
		txtBancoemp.setBounds(170, 80, 458, 20);
		panelDadosconta.add(txtBancoemp);
		
		JLabel lbdv = new JLabel("D\u00EDgito verificador");
		lbdv.setFont(new Font("Calibri", Font.PLAIN, 16));
		lbdv.setBounds(320, 55, 140, 20);
		panelDadosconta.add(lbdv);
		
		txtDvemp = new JTextField();
		txtDvemp.setFont(new Font("Calibri", Font.PLAIN, 16));
		txtDvemp.setColumns(10);
		txtDvemp.setBounds(488, 55, 140, 20);
		panelDadosconta.add(txtDvemp);
		
		JLabel lbContacorrente = new JLabel("Conta Corrente");
		lbContacorrente.setFont(new Font("Calibri", Font.PLAIN, 16));
		lbContacorrente.setBounds(15, 55, 140, 20);
		panelDadosconta.add(lbContacorrente);
		
		txtContacorrenteemp = new JTextField();
		txtContacorrenteemp.setFont(new Font("Calibri", Font.PLAIN, 16));
		txtContacorrenteemp.setColumns(10);
		txtContacorrenteemp.setBounds(170, 55, 140, 20);
		panelDadosconta.add(txtContacorrenteemp);
		
		JLabel lbCodbanco = new JLabel("C\u00F3digo do Banco");
		lbCodbanco.setBounds(15, 30, 140, 20);
		panelDadosconta.add(lbCodbanco);
		lbCodbanco.setFont(new Font("Calibri", Font.PLAIN, 16));
		
		txtCodbancoemp = new JTextField();
		txtCodbancoemp.setBounds(170, 30, 140, 20);
		panelDadosconta.add(txtCodbancoemp);
		txtCodbancoemp.setFont(new Font("Calibri", Font.PLAIN, 16));
		txtCodbancoemp.setColumns(10);
		
		JLabel lbNomebanco = new JLabel("Nome do Banco");
		lbNomebanco.setFont(new Font("Calibri", Font.PLAIN, 16));
		lbNomebanco.setBounds(15, 80, 140, 20);
		panelDadosconta.add(lbNomebanco);
		
		JPanel panelDadosarquivo = new JPanel();
		panelDadosarquivo.setLayout(null);
		panelDadosarquivo.setBorder(UIManager.getBorder("ComboBox.border"));
		panelDadosarquivo.setBounds(5, 356, 635, 132);
		frame.getContentPane().add(panelDadosarquivo);
		
		JLabel lbinforemessa = new JLabel("Informa\u00E7oes do Arquivo de Remessa");
		lbinforemessa.setFont(new Font("Calibri", Font.BOLD, 16));
		lbinforemessa.setBounds(15, 5, 412, 20);
		panelDadosarquivo.add(lbinforemessa);
		
		JLabel lbtiporemessa = new JLabel("Selecione o tipo de Remessa / Retorno");
		lbtiporemessa.setBounds(15, 30, 300, 20);
		panelDadosarquivo.add(lbtiporemessa);
		lbtiporemessa.setFont(new Font("Calibri", Font.PLAIN, 16));
		
		JLabel lbtiposervico = new JLabel("Selecione o tipo de servi\u00E7o");
		lbtiposervico.setFont(new Font("Calibri", Font.PLAIN, 16));
		lbtiposervico.setBounds(15, 55, 300, 20);
		panelDadosarquivo.add(lbtiposervico);
		
		JComboBox<Tpremessa> comboTpremessa = new JComboBox<Tpremessa>();
		comboTpremessa.setFont(new Font("Calibri", Font.PLAIN, 16));
		comboTpremessa.addItem(new Tpremessa("1", "Remessa (Cliente para Banco)"));
		comboTpremessa.addItem(new Tpremessa("2", "Remessa (Banco para Cliente)"));
		comboTpremessa.setBounds(378, 30, 250, 20);
		panelDadosarquivo.add(comboTpremessa);
		
		JComboBox<Tpservico> comboTpservico = new JComboBox<Tpservico>();
		comboTpservico.setFont(new Font("Calibri", Font.PLAIN, 16));
		comboTpservico.addItem(new Tpservico("20", "Pagamento a Fornecedores"));
		comboTpservico.addItem(new Tpservico("30", "Pagamento de Salários"));
		comboTpservico.setBounds(378, 55, 250, 20);
		panelDadosarquivo.add(comboTpservico);
		
		JLabel lblTipoDeMovimento = new JLabel("Tipo de movimento");
		lblTipoDeMovimento.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblTipoDeMovimento.setBounds(15, 80, 300, 20);
		panelDadosarquivo.add(lblTipoDeMovimento);
		
		JComboBox<Tpmovimento> comboTpmovimento = new JComboBox<Tpmovimento>();
		comboTpmovimento.setFont(new Font("Calibri", Font.PLAIN, 16));
		comboTpmovimento.addItem(new Tpmovimento("0", "Inclusao"));
		comboTpmovimento.addItem(new Tpmovimento("5", "Alteracao"));
		comboTpmovimento.addItem(new Tpmovimento("7", "Liquidacao"));
		comboTpmovimento.addItem(new Tpmovimento("9", "Exclusao"));
		comboTpmovimento.setBounds(378, 80, 250, 20);
		panelDadosarquivo.add(comboTpmovimento);
		
		JLabel lbidfavorecido = new JLabel("Identifica\u00E7ao para o favorecido");
		lbidfavorecido.setFont(new Font("Calibri", Font.PLAIN, 16));
		lbidfavorecido.setBounds(15, 105, 300, 20);
		panelDadosarquivo.add(lbidfavorecido);
		
		
		JComboBox<Tpidentificacao> comboTpidentificacao = new JComboBox<Tpidentificacao>();
		comboTpidentificacao.setFont(new Font("Calibri", Font.PLAIN, 16));
		comboTpidentificacao.addItem(new Tpidentificacao("PS01", "Salário"));
		comboTpidentificacao.addItem(new Tpidentificacao("PS02", "Férias"));
		comboTpidentificacao.addItem(new Tpidentificacao("PS03", "13 Salário"));
		comboTpidentificacao.addItem(new Tpidentificacao("PS04", "Pagamento Quinzenal"));
		comboTpidentificacao.addItem(new Tpidentificacao("PS05", "Comissao"));
		comboTpidentificacao.addItem(new Tpidentificacao("PS06", "Adiantamento"));
		comboTpidentificacao.addItem(new Tpidentificacao("PS07", "Rescisao"));
		comboTpidentificacao.addItem(new Tpidentificacao("PS08", "Rescisao Complementar"));
		comboTpidentificacao.addItem(new Tpidentificacao("PS09", "Pensao Alimenticia"));
		comboTpidentificacao.addItem(new Tpidentificacao("PS10", "PLR / Bonus"));
		comboTpidentificacao.addItem(new Tpidentificacao("PS11", "Auxílio Creche / Educaçao"));
		comboTpidentificacao.addItem(new Tpidentificacao("PS12", "Vale Transporte"));
		comboTpidentificacao.addItem(new Tpidentificacao("PS13", "Reembolso"));
		comboTpidentificacao.addItem(new Tpidentificacao("PS14", "Evento Esporádico"));
		comboTpidentificacao.addItem(new Tpidentificacao("PS15", "Outros"));
		comboTpidentificacao.addItem(new Tpidentificacao("PS16", "Auxílio Alimentaçao"));
		comboTpidentificacao.addItem(new Tpidentificacao("PS17", "Bolsa Estágio"));
		comboTpidentificacao.setBounds(378, 105, 250, 20);
		panelDadosarquivo.add(comboTpidentificacao);
		
		JPanel panelDadosconta_1 = new JPanel();
		panelDadosconta_1.setLayout(null);
		panelDadosconta_1.setBorder(UIManager.getBorder("ComboBox.border"));
		panelDadosconta_1.setBounds(5, 650, 635, 106);
		frame.getContentPane().add(panelDadosconta_1);
		
		JLabel lbagenciacolab = new JLabel("Agencia");
		lbagenciacolab.setHorizontalAlignment(SwingConstants.LEFT);
		lbagenciacolab.setFont(new Font("Calibri", Font.PLAIN, 16));
		lbagenciacolab.setBounds(320, 30, 140, 20);
		panelDadosconta_1.add(lbagenciacolab);
		
		txtAgenciacolab = new JTextField();
		txtAgenciacolab.setFont(new Font("Calibri", Font.PLAIN, 16));
		txtAgenciacolab.setColumns(10);
		txtAgenciacolab.setBounds(488, 30, 140, 20);
		panelDadosconta_1.add(txtAgenciacolab);
		
		JLabel lbcotadestino = new JLabel("Dados da Conta Corrente do benefici\u00E1rio");
		lbcotadestino.setFont(new Font("Calibri", Font.BOLD, 16));
		lbcotadestino.setBounds(15, 5, 412, 20);
		panelDadosconta_1.add(lbcotadestino);
		
		txtBancocolab = new JTextField();
		txtBancocolab.setFont(new Font("Calibri", Font.PLAIN, 16));
		txtBancocolab.setColumns(10);
		txtBancocolab.setBounds(170, 80, 458, 20);
		panelDadosconta_1.add(txtBancocolab);
		
		JLabel lbdvcolab = new JLabel("D\u00EDgito verificador");
		lbdvcolab.setFont(new Font("Calibri", Font.PLAIN, 16));
		lbdvcolab.setBounds(320, 55, 140, 20);
		panelDadosconta_1.add(lbdvcolab);
		
		txtDvcolab = new JTextField();
		txtDvcolab.setFont(new Font("Calibri", Font.PLAIN, 16));
		txtDvcolab.setColumns(10);
		txtDvcolab.setBounds(488, 55, 140, 20);
		panelDadosconta_1.add(txtDvcolab);
		
		JLabel lccontacorrentecolab = new JLabel("Conta Corrente");
		lccontacorrentecolab.setFont(new Font("Calibri", Font.PLAIN, 16));
		lccontacorrentecolab.setBounds(15, 55, 140, 20);
		panelDadosconta_1.add(lccontacorrentecolab);
		
		txtContacorrentecolab = new JTextField();
		txtContacorrentecolab.setFont(new Font("Calibri", Font.PLAIN, 16));
		txtContacorrentecolab.setColumns(10);
		txtContacorrentecolab.setBounds(170, 55, 140, 20);
		panelDadosconta_1.add(txtContacorrentecolab);
		
		JLabel lbcodigobcocolab = new JLabel("C\u00F3digo do Banco");
		lbcodigobcocolab.setFont(new Font("Calibri", Font.PLAIN, 16));
		lbcodigobcocolab.setBounds(15, 30, 140, 20);
		panelDadosconta_1.add(lbcodigobcocolab);
		
		txtCodigobcocolab = new JTextField();
		txtCodigobcocolab.setFont(new Font("Calibri", Font.PLAIN, 16));
		txtCodigobcocolab.setColumns(10);
		txtCodigobcocolab.setBounds(170, 30, 140, 20);
		panelDadosconta_1.add(txtCodigobcocolab);
		
		JLabel lbbancocolab = new JLabel("Nome do Banco");
		lbbancocolab.setFont(new Font("Calibri", Font.PLAIN, 16));
		lbbancocolab.setBounds(15, 80, 140, 20);
		panelDadosconta_1.add(lbbancocolab);
		
		JPanel panelDadosconta_1_1 = new JPanel();
		panelDadosconta_1_1.setLayout(null);
		panelDadosconta_1_1.setBorder(UIManager.getBorder("ComboBox.border"));
		panelDadosconta_1_1.setBounds(5, 490, 635, 158);
		frame.getContentPane().add(panelDadosconta_1_1);
		
		JLabel lbdadosdobeneficiário = new JLabel("Dados do benefici\u00E1rio");
		lbdadosdobeneficiário.setFont(new Font("Calibri", Font.BOLD, 16));
		lbdadosdobeneficiário.setBounds(15, 5, 412, 20);
		panelDadosconta_1_1.add(lbdadosdobeneficiário);
		
		JLabel lbcpf = new JLabel("CPF");
		lbcpf.setFont(new Font("Calibri", Font.PLAIN, 16));
		lbcpf.setBounds(15, 30, 140, 20);
		panelDadosconta_1_1.add(lbcpf);
		
		txtCpf = new JTextField();
		txtCpf.setHorizontalAlignment(SwingConstants.RIGHT);
		txtCpf.setFont(new Font("Calibri", Font.PLAIN, 16));
		txtCpf.setColumns(10);
		txtCpf.setBounds(170, 30, 310, 20);
		panelDadosconta_1_1.add(txtCpf);
		
		JButton btnPesquisarcpf = new JButton("Pesquisar");
		btnPesquisarcpf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					if (!FopagUtils.isCPFValido(txtCpf.getText())) {
						JOptionPane.showMessageDialog(null, "CPF inválido", "Dados inválidos", JOptionPane.ERROR_MESSAGE);
						return;
					}
					
					String query = ("SELECT * FROM fopagdb.cadastrotb WHERE `cpf` = " + txtCpf.getText()); 
		            ResultSet resultado = Fopag.connection.getData(query);
		            
		            while (resultado.next())
		            {
		                txtColaborador.setText(resultado.getString("nome")); 
		                txtRuacolab.setText(resultado.getString("rua"));
		                txtNresidcolab.setText(resultado.getString("nresid"));
		                txtCompresidcolab.setText(resultado.getString("compresid"));
		                txtCidadecolab.setText(resultado.getString("cidade"));
		                txtCepcolab.setText(resultado.getString("cep"));
		                txtEstadocolab.setText(resultado.getString("estado"));
		                txtCodigobcocolab.setText(resultado.getString("codigobco"));
		                txtAgenciacolab.setText(resultado.getString("agencia"));
		                txtContacorrentecolab.setText(resultado.getString("conta"));
		                txtDvcolab.setText(resultado.getString("dv"));
		                txtBancocolab.setText(resultado.getString("banco"));
		            }
				}
				catch (Exception ex)
				{
				    ex.printStackTrace();
				}
			}
		});
		btnPesquisarcpf.setFont(new Font("Calibri", Font.PLAIN, 16));
		btnPesquisarcpf.setBounds(488, 30, 140, 20);
		panelDadosconta_1_1.add(btnPesquisarcpf);
		
		JLabel lbcolaborador = new JLabel("Colaborador");
		lbcolaborador.setFont(new Font("Calibri", Font.PLAIN, 16));
		lbcolaborador.setBounds(15, 55, 140, 20);
		panelDadosconta_1_1.add(lbcolaborador);
		
		txtColaborador = new JTextField();
		txtColaborador.setFont(new Font("Calibri", Font.PLAIN, 16));
		txtColaborador.setColumns(10);
		txtColaborador.setBounds(170, 55, 458, 20);
		panelDadosconta_1_1.add(txtColaborador);
		
		JLabel lbruacolab = new JLabel("Rua");
		lbruacolab.setFont(new Font("Calibri", Font.PLAIN, 16));
		lbruacolab.setBounds(15, 80, 140, 20);
		panelDadosconta_1_1.add(lbruacolab);
		
		txtRuacolab = new JTextField();
		txtRuacolab.setFont(new Font("Calibri", Font.PLAIN, 16));
		txtRuacolab.setColumns(10);
		txtRuacolab.setBounds(170, 80, 310, 20);
		panelDadosconta_1_1.add(txtRuacolab);
		
		JLabel lblNr_1 = new JLabel("Nr");
		lblNr_1.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblNr_1.setBounds(488, 80, 40, 20);
		panelDadosconta_1_1.add(lblNr_1);
		
		txtNresidcolab = new JTextField();
		txtNresidcolab.setFont(new Font("Calibri", Font.PLAIN, 16));
		txtNresidcolab.setColumns(10);
		txtNresidcolab.setBounds(528, 80, 100, 20);
		panelDadosconta_1_1.add(txtNresidcolab);
		
		JLabel lbcompresidcolab = new JLabel("Complemento");
		lbcompresidcolab.setFont(new Font("Calibri", Font.PLAIN, 16));
		lbcompresidcolab.setBounds(15, 105, 140, 20);
		panelDadosconta_1_1.add(lbcompresidcolab);
		
		txtCompresidcolab = new JTextField();
		txtCompresidcolab.setFont(new Font("Calibri", Font.PLAIN, 16));
		txtCompresidcolab.setColumns(10);
		txtCompresidcolab.setBounds(170, 105, 140, 20);
		panelDadosconta_1_1.add(txtCompresidcolab);
		
		JLabel lbcidadecolab = new JLabel("Cidade");
		lbcidadecolab.setFont(new Font("Calibri", Font.PLAIN, 16));
		lbcidadecolab.setBounds(340, 105, 140, 20);
		panelDadosconta_1_1.add(lbcidadecolab);
		
		txtCidadecolab = new JTextField();
		txtCidadecolab.setFont(new Font("Calibri", Font.PLAIN, 16));
		txtCidadecolab.setColumns(10);
		txtCidadecolab.setBounds(488, 105, 140, 20);
		panelDadosconta_1_1.add(txtCidadecolab);
		
		JLabel lbcepcolab = new JLabel("CEP");
		lbcepcolab.setFont(new Font("Calibri", Font.PLAIN, 16));
		lbcepcolab.setBounds(15, 130, 140, 20);
		panelDadosconta_1_1.add(lbcepcolab);
		
		txtCepcolab = new JTextField();
		txtCepcolab.setFont(new Font("Calibri", Font.PLAIN, 16));
		txtCepcolab.setColumns(10);
		txtCepcolab.setBounds(170, 130, 140, 20);
		panelDadosconta_1_1.add(txtCepcolab);
		
		JLabel lbestadocolab = new JLabel("Estado");
		lbestadocolab.setFont(new Font("Calibri", Font.PLAIN, 16));
		lbestadocolab.setBounds(340, 130, 140, 20);
		panelDadosconta_1_1.add(lbestadocolab);
		
		txtEstadocolab = new JTextField();
		txtEstadocolab.setFont(new Font("Calibri", Font.PLAIN, 16));
		txtEstadocolab.setColumns(10);
		txtEstadocolab.setBounds(488, 130, 140, 20);
		panelDadosconta_1_1.add(txtEstadocolab);
		
		JPanel panelDadosconta_1_1_1 = new JPanel();
		panelDadosconta_1_1_1.setLayout(null);
		panelDadosconta_1_1_1.setBorder(UIManager.getBorder("ComboBox.border"));
		panelDadosconta_1_1_1.setBounds(5, 758, 635, 82);
		frame.getContentPane().add(panelDadosconta_1_1_1);
		
		JLabel lbvalorpagto = new JLabel("Valor");
		lbvalorpagto.setHorizontalAlignment(SwingConstants.LEFT);
		lbvalorpagto.setFont(new Font("Calibri", Font.PLAIN, 16));
		lbvalorpagto.setBounds(320, 30, 140, 20);
		panelDadosconta_1_1_1.add(lbvalorpagto);
		
		txtValor = new JTextField();
		txtValor.setHorizontalAlignment(SwingConstants.RIGHT);
		txtValor.setFont(new Font("Calibri", Font.PLAIN, 16));
		txtValor.setColumns(10);
		txtValor.setBounds(488, 30, 140, 20);
		panelDadosconta_1_1_1.add(txtValor);
		
		JLabel lbdadospagto = new JLabel("Dados para pagamento");
		lbdadospagto.setFont(new Font("Calibri", Font.BOLD, 16));
		lbdadospagto.setBounds(15, 5, 412, 20);
		panelDadosconta_1_1_1.add(lbdadospagto);
		
		JLabel lbdvcolab_1 = new JLabel("D\u00EDgito verificador");
		lbdvcolab_1.setFont(new Font("Calibri", Font.PLAIN, 16));
		lbdvcolab_1.setBounds(320, 141, 140, 25);
		panelDadosconta_1_1_1.add(lbdvcolab_1);
		
		JLabel lbcccolab_1 = new JLabel("Conta Corrente");
		lbcccolab_1.setFont(new Font("Calibri", Font.PLAIN, 16));
		lbcccolab_1.setBounds(15, 141, 140, 25);
		panelDadosconta_1_1_1.add(lbcccolab_1);
		
		JLabel lbdatapagto = new JLabel("Data do pagamento");
		lbdatapagto.setFont(new Font("Calibri", Font.PLAIN, 16));
		lbdatapagto.setBounds(15, 30, 140, 20);
		panelDadosconta_1_1_1.add(lbdatapagto);
		
		txtDatapagto = new JTextField();
		txtDatapagto.setHorizontalAlignment(SwingConstants.CENTER);
		txtDatapagto.setFont(new Font("Calibri", Font.PLAIN, 16));
		txtDatapagto.setColumns(10);
		txtDatapagto.setBounds(170, 30, 140, 20);
		panelDadosconta_1_1_1.add(txtDatapagto);
		
		JLabel lbformalancamento = new JLabel("Tipo de lan\u00E7amento");
		lbformalancamento.setBounds(15, 55, 300, 20);
		panelDadosconta_1_1_1.add(lbformalancamento);
		lbformalancamento.setFont(new Font("Calibri", Font.PLAIN, 16));
		
		JComboBox<Tplancamento> comboTplancamento = new JComboBox<Tplancamento>();
		comboTplancamento.setBounds(378, 55, 250, 20);
		panelDadosconta_1_1_1.add(comboTplancamento);
		comboTplancamento.setFont(new Font("Calibri", Font.PLAIN, 16));
		comboTplancamento.addItem(new Tplancamento("01", "Crédito em Conta Corrente Original"));
		comboTplancamento.addItem(new Tplancamento("03", "TED"));
		comboTplancamento.addItem(new Tplancamento("04", "Cartao Salário"));
		comboTplancamento.addItem(new Tplancamento("30", "Liquidacao de Titulos do Proprio Banco"));
		comboTplancamento.addItem(new Tplancamento("31", "Pagamento de Titulos de Outros Bancos"));
		comboTplancamento.addItem(new Tplancamento("41", "TED - Outra Titularidade"));
		comboTplancamento.addItem(new Tplancamento("43", "TED - Mesma Titularidade"));
		comboTplancamento.addItem(new Tplancamento("44", "TED para Transferencia de Conta Investimento"));
		comboTplancamento.addItem(new Tplancamento("99", "Manutencao Conta Salário"));
		
		JButton btnGravarpagto = new JButton("Gravar");
		btnGravarpagto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					try
					{
						String query = "INSERT INTO `fopagdb`.`pagamentostb`\n" +
			            "(`cnpj`,\n" +
			            "`empresa`,\n" +
			            "`convenio`,\n" +
			            "`tpinscricao`,\n" +
			            "`ruaemp`,\n" +
			            "`nresidemp`,\n" +
			            "`compresidemp`,\n" +
			            "`cidadeemp`,\n" +
			            "`cepemp`,\n" +
			            "`estadoemp`,\n" +
			            "`codigobcoemp`,\n" +
			            "`agenciaemp`,\n" +
			            "`contaemp`,\n" +
			            "`dvemp`,\n" +
			            "`bancoemp`,\n" +
			            "`tpremessa`,\n" +
			            "`tpservico`,\n" +
			            "`tpmovimento`,\n" +
			            "`tpidentificacao`,\n" +
			            "`cpf`,\n" +
			            "`colaborador`,\n" +
			            "`ruacolab`,\n" +
			            "`nresidcolab`,\n" +
			            "`compresidcolab`,\n" +
			            "`cidadecolab`,\n" +
			            "`cepcolab`,\n" +
			            "`estadocolab`,\n" +
			            "`codigobcocolab`,\n" +
			            "`agenciacolab`,\n" +
			            "`contacolab`,\n" +
			            "`dvcolab`,\n" +
			            "`bancocolab`,\n" +
			            "`datapagto`,\n" +
			            "`valor`,\n" +
			            "`tplancamento`,\n" +
			            "`data`)\n" +
					    "VALUES\n" +
					    "('" + txtCnpj.getText() + "',\n" +
					    "'" + txtEmpresa.getText() + "',\n" +
					    "'" + txtConvenio.getText() + "',\n" +
					    "'" + txtTpinscricao.getText() + "',\n" +
					    "'" + txtRuaemp.getText() + "',\n" +
					    "'" + txtNresidemp.getText() + "',\n" +
					    "'" + txtCompemp.getText() + "',\n" +
					    "'" + txtCidadeemp.getText() + "',\n" +
					    "'" + txtCepemp.getText() + "',\n" +
					    "'" + txtEstadoemp.getText() + "',\n" +
					    "'" + txtCodbancoemp.getText() + "',\n" +
					    "'" + txtAgenciaemp.getText() + "',\n" +
					    "'" + txtContacorrenteemp.getText() + "',\n" +
					    "'" + txtDvemp.getText() + "',\n" +
					    "'" + txtBancoemp.getText() + "',\n" +
					    "'" + ((Tpremessa) comboTpremessa.getSelectedItem()).getKey() + "',\n" +
					    "'" + ((Tpservico) comboTpservico.getSelectedItem()).getKey() + "',\n" +
					    "'" + ((Tpmovimento) comboTpmovimento.getSelectedItem()).getKey() + "',\n" +
					    "'" + ((Tpidentificacao) comboTpidentificacao.getSelectedItem()).getKey() + "',\n" +
					    "'" + txtCpf.getText() + "',\n" +
					    "'" + txtColaborador.getText() + "',\n" +
					    "'" + txtRuacolab.getText() + "',\n" +
					    "'" + txtNresidcolab.getText() + "',\n" +
					    "'" + txtCompresidcolab.getText() + "',\n" +
					    "'" + txtCidadecolab.getText() + "',\n" +
					    "'" + txtCepcolab.getText() + "',\n" +
					    "'" + txtEstadocolab.getText() + "',\n" +
					    "'" + txtCodigobcocolab.getText() + "',\n" +
					    "'" + txtAgenciacolab.getText() + "',\n" +
					    "'" + txtContacorrentecolab.getText() + "',\n" +
					    "'" + txtDvcolab.getText() + "',\n" +
					    "'" + txtBancocolab.getText() + "',\n" +
					    "'" + txtDatapagto.getText() + "',\n" +
					    "'" + txtValor.getText() + "',\n" +
					    "'" + ((Tplancamento) comboTplancamento.getSelectedItem()).getKey() + "',\n" +
					    "'" + new SimpleDateFormat("ddMMYYYY").format(new Date()) + "')";
			            
					System.out.println(query);
				
					Fopag.connection.insertData(query);
					JOptionPane.showMessageDialog(btnGravarpagto, "Pagamento registrado.");
					}
				catch (SQLException ex)
					{
					JOptionPane.showMessageDialog(btnGravarpagto, "Alguma coisa está errada! Por favor, verifique as informaçoes digitadas ");
					ex.printStackTrace();
					}
					
				txtCnpj.setText("");
	            txtEmpresa.setText("");
	            txtConvenio.setText("");
	            txtTpinscricao.setText("");
	            txtRuaemp.setText("");
	            txtNresidemp.setText("");
	            txtCompemp.setText("");
	            txtCidadeemp.setText("");
	            txtCepemp.setText("");
	            txtEstadoemp.setText("");
	            txtCodbancoemp.setText("");
	            txtAgenciaemp.setText("");
	            txtContacorrenteemp.setText("");
	            txtDvemp.setText("");
	            txtBancoemp.setText("");
	            comboTpremessa.getSelectedItem();
	            comboTpservico.getSelectedItem();
	            comboTpmovimento.getSelectedItem();
	            comboTpidentificacao.getSelectedItem();
	            txtCpf.setText("");
	            txtColaborador.setText("");
	            txtRuacolab.setText("");
	            txtNresidcolab.setText("");
	            txtCompresidcolab.setText("");
	            txtCidadecolab.setText("");
	            txtCepcolab.setText("");
	            txtEstadocolab.setText("");
	            txtCodigobcocolab.setText("");
	            txtAgenciacolab.setText("");
	            txtContacorrentecolab.setText("");
	            txtDvcolab.setText("");
	            txtBancocolab.setText("");
	            txtDatapagto.setText("");
	            txtValor.setText("");
	            comboTplancamento.getSelectedItem();
			}
		});
		btnGravarpagto.setFont(new Font("Calibri", Font.PLAIN, 16));
		btnGravarpagto.setBounds(5, 842, 317, 30);
		frame.getContentPane().add(btnGravarpagto);
		
		JButton btnCancelarpagto = new JButton("Cancelar");
		btnCancelarpagto.setFont(new Font("Calibri", Font.PLAIN, 16));
		btnCancelarpagto.setBounds(321, 842, 317, 30);
		frame.getContentPane().add(btnCancelarpagto);
		
        txtEmpresa.setEditable(false);
        txtConvenio.setEditable(false);
        txtTpinscricao.setEditable(false);
        txtRuaemp.setEditable(false);
        txtNresidemp.setEditable(false);
        txtCompemp.setEditable(false);
        txtCidadeemp.setEditable(false);
        txtCepemp.setEditable(false);
        txtEstadoemp.setEditable(false);
        txtCodbancoemp.setEditable(false);
        txtAgenciaemp.setEditable(false);
        txtContacorrenteemp.setEditable(false);
        txtDvemp.setEditable(false);
        txtBancoemp.setEditable(false);
        txtColaborador.setEditable(false);
        txtRuacolab.setEditable(false);
        txtNresidcolab.setEditable(false);
        txtCompresidcolab.setEditable(false);
        txtCidadecolab.setEditable(false);
        txtCepcolab.setEditable(false);
        txtEstadocolab.setEditable(false);
        txtCodigobcocolab.setEditable(false);
        txtAgenciacolab.setEditable(false);
        txtContacorrentecolab.setEditable(false);
        txtDvcolab.setEditable(false);
        txtBancocolab.setEditable(false);
	}
}
