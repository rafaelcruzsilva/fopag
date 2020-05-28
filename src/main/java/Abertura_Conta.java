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

public class Abertura_Conta {

	public JFrame frame;
	private JTextField txtCodigobcoemp;
	private JTextField txtTpinscricao;
	private JTextField txtAgenciaemp;
	private JTextField txtContacorrenteemp;
	private JTextField txtConvenio;
	private JTextField txtDvemp;
	private JTextField txtEmpresa;
	private JTextField txtBancoemp;
	private JTextField txtColaborador;
	private JTextField txtUfnasc;
	private JTextField txtRg;
	private JTextField txtCnpj;
	private JLabel lblGeraoDoArquivo;
	private JPanel panelDadosempresa;
	private JLabel lbcnpj;
	private JLabel lbdadosempresa;
	private JLabel lbtpinscricao;
	private JLabel lbconvenio;
	private JLabel lbempresa;
	private JPanel panelDadosconta;
	private JLabel lbAgencia;
	private JLabel lbcontacorrenteemp;
	private JLabel lbdv;
	private JLabel lbContacorrente;
	private JLabel lbCodbanco;
	private JLabel lbNomebanco;
	private JPanel panelDadoscolab;
	private JLabel lbdadosdobeneficiário;
	private JLabel lbcpf;
	private JTextField txtCpf;
	private JButton btnPesquisarcpf;
	private JLabel lbcolaborador;
	private JLabel lbruacolab;
	private JLabel lbnresidcolab;
	private JLabel lbcompresidcolab;
	private JLabel lbcidadecolab;
	private JLabel lbcepcolab;
	private JLabel lbestadocolab;
	private JPanel panelDadoscomplementarescolab;
	private JLabel lbrg;
	private JLabel lbcotadestino;
	private JLabel lbsexo;
	private JLabel lbdatanascimento;
	private JLabel lbufnascimento;
	private JLabel lbmae;
	private JPanel panelDadoscomplementaresCS;
	private JLabel lbconta;
	private JLabel lbdadospagto;
	private JLabel lbdvcolab_1;
	private JLabel lbcccolab;
	private JLabel lbagencia;
	private JButton btnGravarpagto;
	private JButton btnCancelarpagto;
	private JTextField txtRuacolab;
	private JTextField txtNresidcolab;
	private JTextField txtCompresidcolab;
	private JTextField txtCidadecolab;
	private JTextField txtCepcolab;
	private JTextField txtEstadocolab;
	private JTextField txtBairrocolab;
	private JTextField txtDn;
	private JTextField txtSexo;
	private JTextField txtMae;
	private JTextField txtEmailcolab;
	private JTextField txtDddcolab;
	private JTextField txtTelefonecolab;
	private JTextField txtSalario;
	private JTextField txtAdmissao;
	private JTextField txtCargo;
	private JTextField txtAgenciacolab;
	private JTextField txtContasalariocolab;
	private JLabel lbtpremessa;
	private JLabel lbestadocivil;
	private JTextField txtCivil;

	/**
	 * OriginalApp
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Abertura_Conta window = new Abertura_Conta();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Abertura_Conta() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Abertura de Conta - Banco Original");
		frame.setBounds(100, 100, 660, 930);
		frame.getContentPane().setLayout(null);
		
		lblGeraoDoArquivo = new JLabel("Gera\u00E7\u00E3o do Arquivo CNAB 240 - Abertura de Conta Sal\u00E1rio");
		lblGeraoDoArquivo.setHorizontalAlignment(SwingConstants.CENTER);
		lblGeraoDoArquivo.setFont(new Font("Calibri", Font.PLAIN, 25));
		lblGeraoDoArquivo.setBounds(5, 0, 635, 60);
		frame.getContentPane().add(lblGeraoDoArquivo);
		
		panelDadosempresa = new JPanel();
		panelDadosempresa.setLayout(null);
		panelDadosempresa.setBorder(UIManager.getBorder("ComboBox.border"));
		panelDadosempresa.setBounds(5, 63, 635, 106);
		frame.getContentPane().add(panelDadosempresa);
		
		lbcnpj = new JLabel("CNPJ");
		lbcnpj.setFont(new Font("Calibri", Font.PLAIN, 16));
		lbcnpj.setBounds(15, 30, 140, 20);
		panelDadosempresa.add(lbcnpj);
		
		lbdadosempresa = new JLabel("Dados do Empresa");
		lbdadosempresa.setFont(new Font("Calibri", Font.BOLD, 16));
		lbdadosempresa.setBounds(15, 5, 412, 20);
		panelDadosempresa.add(lbdadosempresa);
		
		lbtpinscricao = new JLabel("Tipo de Inscri\u00E7ao");
		lbtpinscricao.setFont(new Font("Calibri", Font.PLAIN, 16));
		lbtpinscricao.setBounds(320, 80, 140, 20);
		panelDadosempresa.add(lbtpinscricao);
		
		lbconvenio = new JLabel("Convenio");
		lbconvenio.setFont(new Font("Calibri", Font.PLAIN, 16));
		lbconvenio.setBounds(15, 80, 140, 20);
		panelDadosempresa.add(lbconvenio);
		
		lbempresa = new JLabel("Nome da Empresa");
		lbempresa.setFont(new Font("Calibri", Font.PLAIN, 16));
		lbempresa.setBounds(15, 55, 140, 20);
		panelDadosempresa.add(lbempresa);
		
		JButton btnPesquisarcnpj = new JButton("Pesquisar");
		btnPesquisarcnpj.setBounds(488, 30, 140, 20);
		panelDadosempresa.add(btnPesquisarcnpj);
		btnPesquisarcnpj.setFont(new Font("Calibri", Font.PLAIN, 16));
		
		txtCnpj = new JTextField();
		txtCnpj.setHorizontalAlignment(SwingConstants.RIGHT);
		txtCnpj.setBounds(170, 30, 310, 20);
		panelDadosempresa.add(txtCnpj);
		txtCnpj.setFont(new Font("Calibri", Font.PLAIN, 16));
		txtCnpj.setColumns(10);
		
		txtEmpresa = new JTextField();
		txtEmpresa.setBounds(170, 55, 458, 20);
		panelDadosempresa.add(txtEmpresa);
		txtEmpresa.setHorizontalAlignment(SwingConstants.CENTER);
		txtEmpresa.setFont(new Font("Calibri", Font.PLAIN, 16));
		txtEmpresa.setColumns(10);
		txtEmpresa.setEditable(false);
		
		txtTpinscricao = new JTextField();
		txtTpinscricao.setBounds(488, 80, 140, 20);
		panelDadosempresa.add(txtTpinscricao);
		txtTpinscricao.setHorizontalAlignment(SwingConstants.CENTER);
		txtTpinscricao.setFont(new Font("Calibri", Font.PLAIN, 16));
		txtTpinscricao.setColumns(10);
		txtTpinscricao.setEditable(false);
		
		txtConvenio = new JTextField();
		txtConvenio.setBounds(170, 80, 140, 20);
		panelDadosempresa.add(txtConvenio);
		txtConvenio.setHorizontalAlignment(SwingConstants.CENTER);
		txtConvenio.setFont(new Font("Calibri", Font.PLAIN, 16));
		txtConvenio.setColumns(10);
		txtConvenio.setEditable(false);
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
		                txtCodigobcoemp.setText(resultado.getString("codigobco"));
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
		
		panelDadosconta = new JPanel();
		panelDadosconta.setLayout(null);
		panelDadosconta.setBorder(UIManager.getBorder("ComboBox.border"));
		panelDadosconta.setBounds(5, 173, 635, 106);
		frame.getContentPane().add(panelDadosconta);
		
		lbAgencia = new JLabel("Agencia");
		lbAgencia.setHorizontalAlignment(SwingConstants.LEFT);
		lbAgencia.setFont(new Font("Calibri", Font.PLAIN, 16));
		lbAgencia.setBounds(320, 30, 140, 20);
		panelDadosconta.add(lbAgencia);
		
		lbcontacorrenteemp = new JLabel("Dados da Conta Corrente da Empresa");
		lbcontacorrenteemp.setFont(new Font("Calibri", Font.BOLD, 16));
		lbcontacorrenteemp.setBounds(15, 5, 412, 20);
		panelDadosconta.add(lbcontacorrenteemp);
		
		lbdv = new JLabel("D\u00EDgito verificador");
		lbdv.setFont(new Font("Calibri", Font.PLAIN, 16));
		lbdv.setBounds(320, 55, 140, 20);
		panelDadosconta.add(lbdv);
		
		lbContacorrente = new JLabel("Conta Corrente");
		lbContacorrente.setFont(new Font("Calibri", Font.PLAIN, 16));
		lbContacorrente.setBounds(15, 55, 140, 20);
		panelDadosconta.add(lbContacorrente);
		
		lbCodbanco = new JLabel("C\u00F3digo do Banco");
		lbCodbanco.setFont(new Font("Calibri", Font.PLAIN, 16));
		lbCodbanco.setBounds(15, 30, 140, 20);
		panelDadosconta.add(lbCodbanco);
		
		lbNomebanco = new JLabel("Nome do Banco");
		lbNomebanco.setFont(new Font("Calibri", Font.PLAIN, 16));
		lbNomebanco.setBounds(15, 80, 140, 20);
		panelDadosconta.add(lbNomebanco);
		
		txtCodigobcoemp = new JTextField();
		txtCodigobcoemp.setBounds(170, 30, 140, 20);
		panelDadosconta.add(txtCodigobcoemp);
		txtCodigobcoemp.setHorizontalAlignment(SwingConstants.CENTER);
		txtCodigobcoemp.setFont(new Font("Calibri", Font.PLAIN, 16));
		txtCodigobcoemp.setColumns(10);
		
		txtCodigobcoemp.setEditable(false);
		
		txtAgenciaemp = new JTextField();
		txtAgenciaemp.setBounds(480, 30, 140, 20);
		panelDadosconta.add(txtAgenciaemp);
		txtAgenciaemp.setHorizontalAlignment(SwingConstants.CENTER);
		txtAgenciaemp.setFont(new Font("Calibri", Font.PLAIN, 16));
		txtAgenciaemp.setColumns(10);
		txtAgenciaemp.setEditable(false);
		
		txtContacorrenteemp = new JTextField();
		txtContacorrenteemp.setBounds(170, 55, 140, 20);
		panelDadosconta.add(txtContacorrenteemp);
		txtContacorrenteemp.setHorizontalAlignment(SwingConstants.CENTER);
		txtContacorrenteemp.setFont(new Font("Calibri", Font.PLAIN, 16));
		txtContacorrenteemp.setColumns(10);
		txtContacorrenteemp.setEditable(false);
		
		txtDvemp = new JTextField();
		txtDvemp.setBounds(480, 55, 140, 20);
		panelDadosconta.add(txtDvemp);
		txtDvemp.setHorizontalAlignment(SwingConstants.CENTER);
		txtDvemp.setFont(new Font("Calibri", Font.PLAIN, 16));
		txtDvemp.setColumns(10);
		txtDvemp.setEditable(false);
		
		txtBancoemp = new JTextField();
		txtBancoemp.setBounds(170, 80, 450, 20);
		panelDadosconta.add(txtBancoemp);
		txtBancoemp.setHorizontalAlignment(SwingConstants.CENTER);
		txtBancoemp.setFont(new Font("Calibri", Font.PLAIN, 16));
		txtBancoemp.setColumns(10);
		txtBancoemp.setEditable(false);
		
		panelDadoscolab = new JPanel();
		panelDadoscolab.setLayout(null);
		panelDadoscolab.setBorder(UIManager.getBorder("ComboBox.border"));
		panelDadoscolab.setBounds(5, 283, 635, 181);
		frame.getContentPane().add(panelDadoscolab);
		
		lbdadosdobeneficiário = new JLabel("Dados do colaborador");
		lbdadosdobeneficiário.setFont(new Font("Calibri", Font.BOLD, 16));
		lbdadosdobeneficiário.setBounds(15, 5, 412, 20);
		panelDadoscolab.add(lbdadosdobeneficiário);
		
		lbcpf = new JLabel("CPF");
		lbcpf.setFont(new Font("Calibri", Font.PLAIN, 16));
		lbcpf.setBounds(15, 30, 140, 20);
		panelDadoscolab.add(lbcpf);
		
		txtCpf = new JTextField();
		txtCpf.setHorizontalAlignment(SwingConstants.RIGHT);
		txtCpf.setFont(new Font("Calibri", Font.PLAIN, 16));
		txtCpf.setColumns(10);
		txtCpf.setBounds(170, 30, 310, 20);
		panelDadoscolab.add(txtCpf);
		
		btnPesquisarcpf = new JButton("Pesquisar");
		btnPesquisarcpf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try
				{
					if (!FopagUtils.isCPFValido(txtCpf.getText())) {
						JOptionPane.showMessageDialog(null, "CPF inválido", "Dados inválidos", JOptionPane.ERROR_MESSAGE);
						return;
					}

					ResultSet resultado = Fopag.connection.getData(String.format("SELECT * FROM fopagdb.cadastrotb WHERE cpf LIKE '%s'", txtCpf.getText()));
		            
		            while (resultado.next())
		            {
		                txtColaborador.setText(resultado.getString("nome")); 
		                txtRuacolab.setText(resultado.getString("rua"));
		                txtNresidcolab.setText(resultado.getString("nresid"));
		                txtCompresidcolab.setText(resultado.getString("compresid"));
		                txtBairrocolab.setText(resultado.getString("bairro"));
		                txtCidadecolab.setText(resultado.getString("cidade"));
		                txtCepcolab.setText(resultado.getString("cep"));
		                txtEstadocolab.setText(resultado.getString("estado"));
		                txtUfnasc.setText(resultado.getString("ufnasc"));
		                txtRg.setText(resultado.getString("rg"));
		                txtDn.setText(resultado.getString("dn"));
		                txtSexo.setText(resultado.getString("sexo"));
		                txtMae.setText(resultado.getString("mae"));
		                txtEmailcolab.setText(resultado.getString("email"));
		                txtDddcolab.setText(resultado.getString("ddd"));
		                txtTelefonecolab.setText(resultado.getString("telefone"));
		                txtSalario.setText(resultado.getString("salario"));
		                txtAdmissao.setText(resultado.getString("admissao"));
		                txtCargo.setText(resultado.getString("cargo"));
		                txtCivil.setText(resultado.getString("civil"));
		                txtAgenciacolab.setText(resultado.getString("agencia"));
		                txtContasalariocolab.setText(resultado.getString("conta"));
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
		panelDadoscolab.add(btnPesquisarcpf);
		
		lbcolaborador = new JLabel("Colaborador");
		lbcolaborador.setFont(new Font("Calibri", Font.PLAIN, 16));
		lbcolaborador.setBounds(15, 55, 140, 20);
		panelDadoscolab.add(lbcolaborador);
		
		lbruacolab = new JLabel("Rua");
		lbruacolab.setFont(new Font("Calibri", Font.PLAIN, 16));
		lbruacolab.setBounds(15, 80, 140, 20);
		panelDadoscolab.add(lbruacolab);
		
		lbnresidcolab = new JLabel("Numero");
		lbnresidcolab.setFont(new Font("Calibri", Font.PLAIN, 16));
		lbnresidcolab.setBounds(15, 105, 140, 20);
		panelDadoscolab.add(lbnresidcolab);
		
		lbcompresidcolab = new JLabel("Complemento");
		lbcompresidcolab.setFont(new Font("Calibri", Font.PLAIN, 16));
		lbcompresidcolab.setBounds(340, 105, 140, 20);
		panelDadoscolab.add(lbcompresidcolab);
		
		lbcidadecolab = new JLabel("Cidade");
		lbcidadecolab.setFont(new Font("Calibri", Font.PLAIN, 16));
		lbcidadecolab.setBounds(340, 130, 140, 20);
		panelDadoscolab.add(lbcidadecolab);
		
		lbcepcolab = new JLabel("CEP");
		lbcepcolab.setFont(new Font("Calibri", Font.PLAIN, 16));
		lbcepcolab.setBounds(15, 155, 140, 20);
		panelDadoscolab.add(lbcepcolab);
		
		lbestadocolab = new JLabel("Estado");
		lbestadocolab.setFont(new Font("Calibri", Font.PLAIN, 16));
		lbestadocolab.setBounds(340, 155, 140, 20);
		panelDadoscolab.add(lbestadocolab);
		
		txtColaborador = new JTextField();
		txtColaborador.setBounds(170, 55, 458, 20);
		panelDadoscolab.add(txtColaborador);
		txtColaborador.setHorizontalAlignment(SwingConstants.CENTER);
		txtColaborador.setFont(new Font("Calibri", Font.PLAIN, 16));
		txtColaborador.setColumns(10);
		txtColaborador.setEditable(false);
		
		txtRuacolab = new JTextField();
		txtRuacolab.setHorizontalAlignment(SwingConstants.CENTER);
		txtRuacolab.setFont(new Font("Calibri", Font.PLAIN, 16));
		txtRuacolab.setEditable(false);
		txtRuacolab.setColumns(10);
		txtRuacolab.setBounds(170, 80, 458, 20);
		panelDadoscolab.add(txtRuacolab);
		
		txtNresidcolab = new JTextField();
		txtNresidcolab.setHorizontalAlignment(SwingConstants.CENTER);
		txtNresidcolab.setFont(new Font("Calibri", Font.PLAIN, 16));
		txtNresidcolab.setEditable(false);
		txtNresidcolab.setColumns(10);
		txtNresidcolab.setBounds(170, 105, 140, 20);
		panelDadoscolab.add(txtNresidcolab);
		
		txtCompresidcolab = new JTextField();
		txtCompresidcolab.setHorizontalAlignment(SwingConstants.CENTER);
		txtCompresidcolab.setFont(new Font("Calibri", Font.PLAIN, 16));
		txtCompresidcolab.setEditable(false);
		txtCompresidcolab.setColumns(10);
		txtCompresidcolab.setBounds(488, 105, 140, 20);
		panelDadoscolab.add(txtCompresidcolab);
		
		txtCidadecolab = new JTextField();
		txtCidadecolab.setHorizontalAlignment(SwingConstants.CENTER);
		txtCidadecolab.setFont(new Font("Calibri", Font.PLAIN, 16));
		txtCidadecolab.setEditable(false);
		txtCidadecolab.setColumns(10);
		txtCidadecolab.setBounds(488, 130, 140, 20);
		panelDadoscolab.add(txtCidadecolab);
		
		txtCepcolab = new JTextField();
		txtCepcolab.setHorizontalAlignment(SwingConstants.CENTER);
		txtCepcolab.setFont(new Font("Calibri", Font.PLAIN, 16));
		txtCepcolab.setEditable(false);
		txtCepcolab.setColumns(10);
		txtCepcolab.setBounds(170, 155, 140, 20);
		panelDadoscolab.add(txtCepcolab);
		
		txtEstadocolab = new JTextField();
		txtEstadocolab.setHorizontalAlignment(SwingConstants.CENTER);
		txtEstadocolab.setFont(new Font("Calibri", Font.PLAIN, 16));
		txtEstadocolab.setEditable(false);
		txtEstadocolab.setColumns(10);
		txtEstadocolab.setBounds(488, 155, 140, 20);
		panelDadoscolab.add(txtEstadocolab);
		
		JLabel lbbairrocolab = new JLabel("Bairro");
		lbbairrocolab.setBounds(15, 130, 140, 20);
		panelDadoscolab.add(lbbairrocolab);
		lbbairrocolab.setFont(new Font("Calibri", Font.PLAIN, 16));
		
		txtBairrocolab = new JTextField();
		txtBairrocolab.setBounds(170, 129, 140, 20);
		panelDadoscolab.add(txtBairrocolab);
		txtBairrocolab.setHorizontalAlignment(SwingConstants.CENTER);
		txtBairrocolab.setFont(new Font("Calibri", Font.PLAIN, 16));
		txtBairrocolab.setEditable(false);
		txtBairrocolab.setColumns(10);
		
		panelDadoscomplementarescolab = new JPanel();
		panelDadoscomplementarescolab.setLayout(null);
		panelDadoscomplementarescolab.setBorder(UIManager.getBorder("ComboBox.border"));
		panelDadoscomplementarescolab.setBounds(5, 469, 635, 207);
		frame.getContentPane().add(panelDadoscomplementarescolab);
		
		lbrg = new JLabel("Identidade");
		lbrg.setHorizontalAlignment(SwingConstants.LEFT);
		lbrg.setFont(new Font("Calibri", Font.PLAIN, 16));
		lbrg.setBounds(320, 30, 140, 20);
		panelDadoscomplementarescolab.add(lbrg);
		
		lbcotadestino = new JLabel("Dados complementares do colaborador");
		lbcotadestino.setFont(new Font("Calibri", Font.BOLD, 16));
		lbcotadestino.setBounds(15, 5, 412, 20);
		panelDadoscomplementarescolab.add(lbcotadestino);
		
		lbsexo = new JLabel("Sexo");
		lbsexo.setFont(new Font("Calibri", Font.PLAIN, 16));
		lbsexo.setBounds(320, 55, 140, 20);
		panelDadoscomplementarescolab.add(lbsexo);
		
		lbdatanascimento = new JLabel("Data de nascimento");
		lbdatanascimento.setFont(new Font("Calibri", Font.PLAIN, 16));
		lbdatanascimento.setBounds(15, 55, 140, 20);
		panelDadoscomplementarescolab.add(lbdatanascimento);
		
		lbufnascimento = new JLabel("UF nascimento");
		lbufnascimento.setFont(new Font("Calibri", Font.PLAIN, 16));
		lbufnascimento.setBounds(15, 30, 140, 20);
		panelDadoscomplementarescolab.add(lbufnascimento);
		
		lbmae = new JLabel("Nome da mae");
		lbmae.setFont(new Font("Calibri", Font.PLAIN, 16));
		lbmae.setBounds(15, 80, 140, 20);
		panelDadoscomplementarescolab.add(lbmae);
		
		txtUfnasc = new JTextField();
		txtUfnasc.setBounds(165, 29, 140, 20);
		panelDadoscomplementarescolab.add(txtUfnasc);
		txtUfnasc.setHorizontalAlignment(SwingConstants.CENTER);
		txtUfnasc.setFont(new Font("Calibri", Font.PLAIN, 16));
		txtUfnasc.setColumns(10);
		txtUfnasc.setEditable(false);
		
		txtRg = new JTextField();
		txtRg.setBounds(488, 30, 140, 20);
		panelDadoscomplementarescolab.add(txtRg);
		txtRg.setHorizontalAlignment(SwingConstants.CENTER);
		txtRg.setFont(new Font("Calibri", Font.PLAIN, 16));
		txtRg.setColumns(10);
		txtRg.setEditable(false);
		
		txtDn = new JTextField();
		txtDn.setHorizontalAlignment(SwingConstants.CENTER);
		txtDn.setFont(new Font("Calibri", Font.PLAIN, 16));
		txtDn.setEditable(false);
		txtDn.setColumns(10);
		txtDn.setBounds(165, 55, 140, 20);
		panelDadoscomplementarescolab.add(txtDn);
		
		txtSexo = new JTextField();
		txtSexo.setHorizontalAlignment(SwingConstants.CENTER);
		txtSexo.setFont(new Font("Calibri", Font.PLAIN, 16));
		txtSexo.setEditable(false);
		txtSexo.setColumns(10);
		txtSexo.setBounds(488, 55, 140, 20);
		panelDadoscomplementarescolab.add(txtSexo);
		
		txtMae = new JTextField();
		txtMae.setHorizontalAlignment(SwingConstants.CENTER);
		txtMae.setFont(new Font("Calibri", Font.PLAIN, 16));
		txtMae.setEditable(false);
		txtMae.setColumns(10);
		txtMae.setBounds(165, 80, 463, 20);
		panelDadoscomplementarescolab.add(txtMae);
		
		JLabel lbemail = new JLabel("Email");
		lbemail.setFont(new Font("Calibri", Font.PLAIN, 16));
		lbemail.setBounds(15, 105, 140, 20);
		panelDadoscomplementarescolab.add(lbemail);
		
		txtEmailcolab = new JTextField();
		txtEmailcolab.setHorizontalAlignment(SwingConstants.CENTER);
		txtEmailcolab.setFont(new Font("Calibri", Font.PLAIN, 16));
		txtEmailcolab.setEditable(false);
		txtEmailcolab.setColumns(10);
		txtEmailcolab.setBounds(165, 105, 463, 20);
		panelDadoscomplementarescolab.add(txtEmailcolab);
		
		JLabel lbddd = new JLabel("DDD");
		lbddd.setFont(new Font("Calibri", Font.PLAIN, 16));
		lbddd.setBounds(15, 130, 140, 20);
		panelDadoscomplementarescolab.add(lbddd);
		
		txtDddcolab = new JTextField();
		txtDddcolab.setHorizontalAlignment(SwingConstants.CENTER);
		txtDddcolab.setFont(new Font("Calibri", Font.PLAIN, 16));
		txtDddcolab.setEditable(false);
		txtDddcolab.setColumns(10);
		txtDddcolab.setBounds(165, 130, 140, 20);
		panelDadoscomplementarescolab.add(txtDddcolab);
		
		JLabel lbtelefone = new JLabel("Telefone");
		lbtelefone.setFont(new Font("Calibri", Font.PLAIN, 16));
		lbtelefone.setBounds(320, 130, 140, 20);
		panelDadoscomplementarescolab.add(lbtelefone);
		
		txtTelefonecolab = new JTextField();
		txtTelefonecolab.setHorizontalAlignment(SwingConstants.CENTER);
		txtTelefonecolab.setFont(new Font("Calibri", Font.PLAIN, 16));
		txtTelefonecolab.setEditable(false);
		txtTelefonecolab.setColumns(10);
		txtTelefonecolab.setBounds(488, 130, 140, 20);
		panelDadoscomplementarescolab.add(txtTelefonecolab);
		
		JLabel lbsalario = new JLabel("Salario");
		lbsalario.setFont(new Font("Calibri", Font.PLAIN, 16));
		lbsalario.setBounds(15, 155, 140, 20);
		panelDadoscomplementarescolab.add(lbsalario);
		
		txtSalario = new JTextField();
		txtSalario.setHorizontalAlignment(SwingConstants.CENTER);
		txtSalario.setFont(new Font("Calibri", Font.PLAIN, 16));
		txtSalario.setEditable(false);
		txtSalario.setColumns(10);
		txtSalario.setBounds(165, 155, 140, 20);
		panelDadoscomplementarescolab.add(txtSalario);
		
		JLabel lbadmissao = new JLabel("Data de admissao");
		lbadmissao.setFont(new Font("Calibri", Font.PLAIN, 16));
		lbadmissao.setBounds(320, 155, 140, 20);
		panelDadoscomplementarescolab.add(lbadmissao);
		
		txtAdmissao = new JTextField();
		txtAdmissao.setHorizontalAlignment(SwingConstants.CENTER);
		txtAdmissao.setFont(new Font("Calibri", Font.PLAIN, 16));
		txtAdmissao.setEditable(false);
		txtAdmissao.setColumns(10);
		txtAdmissao.setBounds(488, 155, 140, 20);
		panelDadoscomplementarescolab.add(txtAdmissao);
		
		JLabel lbcargo = new JLabel("Cargo");
		lbcargo.setFont(new Font("Calibri", Font.PLAIN, 16));
		lbcargo.setBounds(15, 180, 140, 20);
		panelDadoscomplementarescolab.add(lbcargo);
		
		txtCargo = new JTextField();
		txtCargo.setHorizontalAlignment(SwingConstants.CENTER);
		txtCargo.setFont(new Font("Calibri", Font.PLAIN, 16));
		txtCargo.setEditable(false);
		txtCargo.setColumns(10);
		txtCargo.setBounds(165, 180, 140, 20);
		panelDadoscomplementarescolab.add(txtCargo);
		
		lbestadocivil = new JLabel("Estado Civil");
		lbestadocivil.setFont(new Font("Calibri", Font.PLAIN, 16));
		lbestadocivil.setBounds(320, 180, 140, 20);
		panelDadoscomplementarescolab.add(lbestadocivil);
		
		txtCivil = new JTextField();
		txtCivil.setHorizontalAlignment(SwingConstants.CENTER);
		txtCivil.setFont(new Font("Calibri", Font.PLAIN, 16));
		txtCivil.setEditable(false);
		txtCivil.setColumns(10);
		txtCivil.setBounds(488, 180, 140, 20);
		panelDadoscomplementarescolab.add(txtCivil);
		
		panelDadoscomplementaresCS = new JPanel();
		panelDadoscomplementaresCS.setLayout(null);
		panelDadoscomplementaresCS.setBorder(UIManager.getBorder("ComboBox.border"));
		panelDadoscomplementaresCS.setBounds(5, 679, 635, 113);
		frame.getContentPane().add(panelDadoscomplementaresCS);
		
		lbconta = new JLabel("Conta Sal\u00E1rio");
		lbconta.setHorizontalAlignment(SwingConstants.LEFT);
		lbconta.setFont(new Font("Calibri", Font.PLAIN, 16));
		lbconta.setBounds(320, 30, 140, 20);
		panelDadoscomplementaresCS.add(lbconta);
		
		lbdadospagto = new JLabel("Dados Complementares para a Conta Sal\u00E1rio (quando houver)");
		lbdadospagto.setFont(new Font("Calibri", Font.BOLD, 16));
		lbdadospagto.setBounds(15, 5, 464, 20);
		panelDadoscomplementaresCS.add(lbdadospagto);
		
		lbdvcolab_1 = new JLabel("D\u00EDgito verificador");
		lbdvcolab_1.setFont(new Font("Calibri", Font.PLAIN, 16));
		lbdvcolab_1.setBounds(320, 141, 140, 25);
		panelDadoscomplementaresCS.add(lbdvcolab_1);
		
		lbcccolab = new JLabel("Conta Corrente");
		lbcccolab.setFont(new Font("Calibri", Font.PLAIN, 16));
		lbcccolab.setBounds(15, 141, 140, 25);
		panelDadoscomplementaresCS.add(lbcccolab);
		
		lbagencia = new JLabel("Agencia");
		lbagencia.setFont(new Font("Calibri", Font.PLAIN, 16));
		lbagencia.setBounds(15, 30, 140, 20);
		panelDadoscomplementaresCS.add(lbagencia);
		
		JLabel lbtipomovimento = new JLabel("Tipo de Movimento");
		lbtipomovimento.setBounds(15, 55, 300, 20);
		panelDadoscomplementaresCS.add(lbtipomovimento);
		lbtipomovimento.setFont(new Font("Calibri", Font.PLAIN, 16));
		
		JComboBox<Tpmovimento> comboTpmovimento = new JComboBox<Tpmovimento>();
		comboTpmovimento.setFont(new Font("Calibri", Font.PLAIN, 16));
		comboTpmovimento.addItem(new Tpmovimento("0", "Inclusao"));
		comboTpmovimento.addItem(new Tpmovimento("5", "Alteracao"));
		comboTpmovimento.addItem(new Tpmovimento("7", "Liquidacao"));
		comboTpmovimento.addItem(new Tpmovimento("9", "Exclusao"));
		comboTpmovimento.setBounds(320, 55, 307, 20);
		panelDadoscomplementaresCS.add(comboTpmovimento);
		
		
		txtAgenciacolab = new JTextField();
		txtAgenciacolab.setHorizontalAlignment(SwingConstants.CENTER);
		txtAgenciacolab.setFont(new Font("Calibri", Font.PLAIN, 16));
		txtAgenciacolab.setEditable(false);
		txtAgenciacolab.setColumns(10);
		txtAgenciacolab.setBounds(165, 30, 140, 20);
		panelDadoscomplementaresCS.add(txtAgenciacolab);
		
		txtContasalariocolab = new JTextField();
		txtContasalariocolab.setHorizontalAlignment(SwingConstants.CENTER);
		txtContasalariocolab.setFont(new Font("Calibri", Font.PLAIN, 16));
		txtContasalariocolab.setEditable(false);
		txtContasalariocolab.setColumns(10);
		txtContasalariocolab.setBounds(487, 30, 140, 20);
		panelDadoscomplementaresCS.add(txtContasalariocolab);
		
		lbtpremessa = new JLabel("Tipo de Remessa");
		lbtpremessa.setFont(new Font("Calibri", Font.PLAIN, 16));
		lbtpremessa.setBounds(15, 80, 300, 20);
		panelDadoscomplementaresCS.add(lbtpremessa);
		
		
		JComboBox<Tpremessa> comboTpremessa = new JComboBox<Tpremessa>();
		comboTpremessa.setFont(new Font("Calibri", Font.PLAIN, 16));
		comboTpremessa.addItem(new Tpremessa("1", "Remessa (Cliente para Banco)"));
		comboTpremessa.addItem(new Tpremessa("2", "Remessa (Banco para Cliente)"));
		comboTpremessa.setBounds(320, 80, 307, 20);
		panelDadoscomplementaresCS.add(comboTpremessa);
		
		btnGravarpagto = new JButton("Gravar");
		btnGravarpagto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					String query = "INSERT INTO `fopagdb`.`contastb`\n" +
		            "(`codigobco`,\n" +
		            "`inscricao`,\n" +
		            "`cnpj`,\n" +
		            "`convenio`,\n" +
		            "`agenciaemp`,\n" +
		            "`contaemp`,\n" +
		            "`dvemp`,\n" +
		            "`empresa`,\n" +
		            "`bancoemp`,\n" +
		            "`nome`,\n" +
		            "`cpf`,\n" +
		            "`ufnasc`,\n" +
		            "`rg`,\n" +
		            "`dn`,\n" +
		            "`sexo`,\n" +
		            "`civil`,\n" +
		            "`mae`,\n" +
		            "`ruacolab`,\n" +
		            "`nresidcolab`,\n" +
		            "`compresidcolab`,\n" +
		            "`bairrocolab`,\n" +
		            "`cidadecolab`,\n" +
		            "`estadocolab`,\n" +
		            "`cepcolab`,\n" +
		            "`emailcolab`,\n" +
		            "`dddcolab`,\n" +
		            "`telefonecolab`,\n" +
		            "`salario`,\n" +
		            "`admissao`,\n" +
		            "`cargo`,\n" +
		            "`tpmovimento`,\n" +
		            "`tpremessa`,\n" +
		            "`data`)\n" +
				    "VALUES\n" +
				    "('" + txtCodigobcoemp.getText() + "',\n" +
				    "'" + txtTpinscricao.getText() + "',\n" +
				    "'" + txtCnpj.getText() + "',\n" +
				    "'" + txtConvenio.getText() + "',\n" +
				    "'" + txtAgenciaemp.getText() + "',\n" +
				    "'" + txtContacorrenteemp.getText() + "',\n" +
				    "'" + txtDvemp.getText() + "',\n" +
				    "'" + txtEmpresa.getText() + "',\n" +
				    "'" + txtBancoemp.getText() + "',\n" +
				    "'" + txtColaborador.getText() + "',\n" +
				    "'" + txtCpf.getText() + "',\n" +
				    "'" + txtUfnasc.getText() + "',\n" +
				    "'" + txtRg.getText() + "',\n" +
				    "'" + txtDn.getText() + "',\n" +
				    "'" + txtSexo.getText() + "',\n" +
				    "'" + txtCivil.getText() + "',\n" +
				    "'" + txtMae.getText() + "',\n" +
				    "'" + txtRuacolab.getText() + "',\n" +
				    "'" + txtNresidcolab.getText() + "',\n" +
				    "'" + txtCompresidcolab.getText() + "',\n" +
				    "'" + txtBairrocolab.getText() + "',\n" +
				    "'" + txtCidadecolab.getText() + "',\n" +
				    "'" + txtEstadocolab.getText() + "',\n" +
				    "'" + txtCepcolab.getText() + "',\n" +
				    "'" + txtEmailcolab.getText() + "',\n" +
				    "'" + txtDddcolab.getText() + "',\n" +
				    "'" + txtTelefonecolab.getText() + "',\n" +
				    "'" + txtSalario.getText() + "',\n" +
				    "'" + txtAdmissao.getText() + "',\n" +
				    "'" + txtCargo.getText() + "',\n" +
					"'" + ((Tpmovimento) comboTpmovimento.getSelectedItem()).getKey() + "',\n" +
				    "'" + ((Tpremessa) comboTpremessa.getSelectedItem()).getKey() + "',\n" +
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
					
			    txtCodigobcoemp.setText("");
			    txtTpinscricao.setText("");
			    txtCnpj.setText("");
			    txtConvenio.setText("");
			    txtAgenciaemp.setText("");
			    txtContacorrenteemp.setText("");
			    txtDvemp.setText("");
			    txtEmpresa.setText("");
			    txtColaborador.setText("");
			    txtCpf.setText("");
			    txtUfnasc.setText("");
			    txtRg.setText("");
			    txtDn.setText("");
			    txtSexo.setText("");
			    txtCivil.setText("");
			    txtMae.setText("");
			    txtRuacolab.setText("");
			    txtNresidcolab.setText("");
			    txtCompresidcolab.setText("");
			    txtBairrocolab.setText("");
			    txtCidadecolab.setText("");
			    txtEstadocolab.setText("");
			    txtCepcolab.setText("");
			    txtEmailcolab.setText("");
			    txtDddcolab.setText("");
			    txtTelefonecolab.setText("");
			    txtSalario.setText("");
			    txtAdmissao.setText("");
			    txtCargo.setText("");
				comboTpmovimento.getSelectedItem();
			    comboTpremessa.getSelectedItem();
			    
			}
		});
		btnGravarpagto.setFont(new Font("Calibri", Font.PLAIN, 16));
		btnGravarpagto.setBounds(5, 840, 317, 30);
		frame.getContentPane().add(btnGravarpagto);
		
		btnCancelarpagto = new JButton("Cancelar");
		btnCancelarpagto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnCancelarpagto.setFont(new Font("Calibri", Font.PLAIN, 16));
		btnCancelarpagto.setBounds(321, 840, 317, 30);
		frame.getContentPane().add(btnCancelarpagto);
		
	}
}
