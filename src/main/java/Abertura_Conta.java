import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

public class Abertura_Conta {

	public JFrame frame;
	private JTextField txtcodigobco;
	private JTextField txtinscricao;
	private JTextField txtcnpj;
	private JTextField txtagencia;
	private JTextField txtconta;
	private JTextField txtconvenio;
	private JTextField txtdv;
	private JTextField txtempresa;
	private JTextField txtbanco;
	private JTextField txtremessa;
	private JTextField txtnsa;
	private JTextField txtnome;
	private JTextField txt_cpf;
	private JTextField txtufnasc;
	private JTextField txtrg;
	private JTextField txtdn;
	private JTextField txtsexo;
	private JTextField txtcivil;
	private JTextField txtmae;
	private JTextField txtrua;
	private JTextField txtnresid;
	private JTextField txtcompresid;
	private JTextField txtbairro;
	private JTextField txtcidade;
	private JTextField txtestado;
	private JTextField txtadmissao;
	private JTextField txtocorrencias;
	private JTextField txtsalario;
	private JTextField txttelefone;
	private JTextField txtdvcolab;
	private JTextField txtcontacolab;
	private JTextField txtddd;
	private JTextField txtemail;
	private JTextField txtagenciacolab;
	private JTextField txtcargo;
	private JTextField txtcep;
	private JTextField cnpjEmpresaConsulta;

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
		frame.setTitle("Abertura de Conta");
		frame.setBounds(100, 100, 700, 780);
		frame.getContentPane().setLayout(null);
		
		JLabel lbcnab = new JLabel("Gera\u00E7\u00E3o do Arquivo CNAB 240 - Abertura de Conta");
		lbcnab.setBounds(10, 10, 645, 60);
		lbcnab.setHorizontalAlignment(SwingConstants.CENTER);
		lbcnab.setFont(new Font("Calibri", Font.PLAIN, 30));
		frame.getContentPane().add(lbcnab);
		
		JPanel panelBanco = new JPanel();
		panelBanco.setBorder(UIManager.getBorder("ComboBox.border"));
		panelBanco.setBounds(20, 96, 635, 95);
		frame.getContentPane().add(panelBanco);
		panelBanco.setLayout(null);
		
		JLabel lbEmpresa = new JLabel("CNPJ da Empresa");
		lbEmpresa.setFont(new Font("Calibri", Font.BOLD, 16));
		lbEmpresa.setBounds(15, 16, 288, 24);
		panelBanco.add(lbEmpresa);
		
		cnpjEmpresaConsulta = new JTextField();
		cnpjEmpresaConsulta.setBounds(15, 52, 208, 19);
		panelBanco.add(cnpjEmpresaConsulta);
		cnpjEmpresaConsulta.setColumns(10);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
			    {
					
					if (!FopagUtils.isCNPJValido(cnpjEmpresaConsulta.getText())) {
						JOptionPane.showMessageDialog(null, "CNPJ inválido", "Erro", JOptionPane.ERROR_MESSAGE);
						return;
					}
					
			    	ResultSet resultado = Fopag.connection.getData(String.format("SELECT * FROM fopagdb.empresatb WHERE cnpj LIKE '%s'", cnpjEmpresaConsulta.getText()));
			    	
				    while (resultado.next())
		            {
		                txtcodigobco.setText(resultado.getString("codigobco")); // Apresentando os valores nos campos
		                txtinscricao.setText(resultado.getString("inscricao"));
		                txtcnpj.setText(resultado.getString("cnpj"));
		                txtconvenio.setText(resultado.getString("convenio"));
		                txtagencia.setText(resultado.getString("agencia"));
		                txtconta.setText(resultado.getString("conta"));
		                txtdv.setText(resultado.getString("dv"));
		                txtempresa.setText(resultado.getString("empresa"));
		                txtbanco.setText(resultado.getString("banco"));
		                //txtremessa.setText(resultado.getString("remessa"));
		                //txtnsa.setText(resultado.getString("nsa"));
		            }
			    }
			    catch (Exception ex)
				{
				    ex.printStackTrace();
				}
			}
		});
		btnPesquisar.setBounds(386, 49, 117, 25);
		panelBanco.add(btnPesquisar);
		
		JPanel panelColaborador = new JPanel();
		panelColaborador.setLayout(null);
		panelColaborador.setBorder(UIManager.getBorder("ComboBox.border"));
		panelColaborador.setBounds(20, 207, 635, 181);
		frame.getContentPane().add(panelColaborador);
		
		JLabel lbColaborador = new JLabel("Selecione o(s) colaborador(es)");
		lbColaborador.setFont(new Font("Calibri", Font.BOLD, 16));
		lbColaborador.setBounds(15, 16, 288, 24);
		panelColaborador.add(lbColaborador);
		
		JTextArea txtcpf = new JTextArea();
		txtcpf.setFont(new Font("Calibri", Font.PLAIN, 16));
		txtcpf.setBounds(15, 92, 343, 30);
		panelColaborador.add(txtcpf);
		
		JLabel lblNewLabel = new JLabel("Digite o cpf do colaborador (apenas n\u00FAmeros)");
		lblNewLabel.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblNewLabel.setBounds(15, 56, 343, 20);
		panelColaborador.add(lblNewLabel);
		
		JButton btnPesqColaborador = new JButton("Pesquisar");
		btnPesqColaborador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{	
				try
				{
					String query = ("SELECT * FROM fopagdb.cadastrotb WHERE `cpf` = " + txtcpf.getText()); 
		            ResultSet resultado = Fopag.connection.getData(query);
		            
		            while (resultado.next())
		            {
		                txt_cpf.setText(resultado.getString("cpf")); // Apresentando os valores nos campos
		                txtnome.setText(resultado.getString("nome"));
		                txtufnasc.setText(resultado.getString("ufnasc"));
		                txtrg.setText(resultado.getString("rg"));
		                txtdn.setText(resultado.getString("dn"));
		                txtsexo.setText(resultado.getString("sexo"));
		                txtcivil.setText(resultado.getString("civil"));
		                txtmae.setText(resultado.getString("mae"));
		                txtrua.setText(resultado.getString("rua"));
		                txtnresid.setText(resultado.getString("nresid"));
		                txtcompresid.setText(resultado.getString("compresid"));
		                txtbairro.setText(resultado.getString("bairro"));
		                txtcidade.setText(resultado.getString("cidade"));
		                txtestado.setText(resultado.getString("estado"));
		                txtcep.setText(resultado.getString("cep"));
		                txtemail.setText(resultado.getString("email"));
		                txtddd.setText(resultado.getString("ddd"));
		                txttelefone.setText(resultado.getString("telefone"));
		                txtsalario.setText(resultado.getString("salario"));
		                txtadmissao.setText(resultado.getString("admissao"));
		                txtcargo.setText(resultado.getString("cargo"));
		                txtagenciacolab.setText(resultado.getString("agencia"));
		                txtcontacolab.setText(resultado.getString("conta"));
		                txtdvcolab.setText(resultado.getString("dv"));
		                
		            }
				}
				catch (Exception ex)
				{
				    ex.printStackTrace();
				}
			}
		});
		btnPesqColaborador.setFont(new Font("Calibri", Font.PLAIN, 16));
		btnPesqColaborador.setBounds(373, 92, 247, 30);
		panelColaborador.add(btnPesqColaborador);
		
		JButton btnLimColaborador = new JButton("Limpar Sele\u00E7\u00E3o");
		btnLimColaborador.setFont(new Font("Calibri", Font.PLAIN, 16));
		btnLimColaborador.setBounds(318, 138, 302, 30);
		panelColaborador.add(btnLimColaborador);
		
		JButton btnIncColaborador = new JButton("Incluir Colaborador");
		btnIncColaborador.setBounds(15, 138, 302, 30);
		panelColaborador.add(btnIncColaborador);
		btnIncColaborador.setFont(new Font("Calibri", Font.PLAIN, 16));
		
		btnIncColaborador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.out.println("Chamando cadastro");
				
				try
				{
				String query = "INSERT INTO `fopagdb`.`contastb`\n" +  // Aqui inicia a Query de cadastro
			            "(`codigobco`,\n" +
			            "`inscricao`,\n" +
			            "`cnpj`,\n" +
			            "`convenio`,\n" +
			            "`agenciaemp`,\n" +
			            "`contaemp`,\n" +
			            "`dvemp`,\n" +
			            "`empresa`,\n" +
			            "`bancoemp`,\n" +
			            //"`remessa`,\n" +
			            //"`nsa`,\n" +
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
			            "`agenciacolab`,\n" +
			            "`contacolab`,\n" +
			            "`dvcolab`,\n" +
			            "`ocorrencias`,\n" +
			            "`data`)\n" +
			            "VALUES\n" +
			            "('" + txtcodigobco.getText() + "',\n" +
			            "'" + txtinscricao.getText() + "',\n" +
			            "'" + txtcnpj.getText() + "',\n" +
			            "'" + txtconvenio.getText() + "',\n" +
			            "'" + txtagencia.getText() + "',\n" +
			            "'" + txtconta.getText() + "',\n" +
			            "'" + txtdv.getText() + "',\n" +
			            "'" + txtempresa.getText() + "',\n" +
			            "'" + txtbanco.getText() + "',\n" +
			            //"'" + txtremessa.getText() + "',\n" +
			            //"'" + txtnsa.getText() + "',\n" +
			            "'" + txtnome.getText() + "',\n" +
			            "'" + txt_cpf.getText() + "',\n" +
			            "'" + txtufnasc.getText() + "',\n" +
			            "'" + txtrg.getText() + "',\n" +
			            "'" + txtdn.getText() + "',\n" +
			            "'" + txtsexo.getText() + "',\n" +
			            "'" + txtcivil.getText() + "',\n" +
			            "'" + txtmae.getText() + "',\n" +
			            "'" + txtrua.getText() + "',\n" +
			            "'" + txtnresid.getText() + "',\n" +
			            "'" + txtcompresid.getText() + "',\n" +
			            "'" + txtbairro.getText() + "',\n" +
			            "'" + txtcidade.getText() + "',\n" +
			            "'" + txtestado.getText() + "',\n" +
			            "'" + txtcep.getText() + "',\n" +
			            "'" + txtemail.getText() + "',\n" +
			            "'" + txtddd.getText() + "',\n" +
			            "'" + txttelefone.getText() + "',\n" +
			            "'" + txtsalario.getText() + "',\n" +
			            "'" + txtadmissao.getText() + "',\n" +
			            "'" + txtcargo.getText() + "',\n" +
			            "'" + txtagenciacolab.getText() + "',\n" +
			            "'" + txtcontacolab.getText() + "',\n" +
			            "'" + txtdvcolab.getText() + "',\n" +
			            "'" + txtocorrencias.getText() + "',\n" +
			            "'" + new SimpleDateFormat("ddMMYYYY").format(new Date()) + "')";
			            
			            
				System.out.println(query);
				
				Fopag.connection.insertData(query);
				JOptionPane.showMessageDialog(btnIncColaborador, "Colaborador inserido!!!!!!.");
			}
			catch (SQLException ex)
			{
				JOptionPane.showMessageDialog(btnIncColaborador, "Algo deu errado, confira as posiï¿½oes por favor!!!");
            ex.printStackTrace();
			}
			  	txtcodigobco.setText("");  // Inicio do Limpa Campo
			  	txtinscricao.setText("");   
			  	txtcnpj.setText("");
			  	txtconvenio.setText("");
			  	txtagencia.setText("");
			  	txtconta.setText("");
			  	txtdv.setText("");
			  	txtempresa.setText("");
			  	txtbanco.setText("");
			  	//txtremessa.setText("");
			  	//txtnsa.setText("");
			  	txtnome.setText("");
			  	txt_cpf.setText("");
			  	txtufnasc.setText("");
			  	txtrg.setText("");
			  	txtdn.setText("");
			  	txtsexo.setText("");
			  	txtcivil.setText("");
			  	txtmae.setText("");
			  	txtrua.setText("");
			  	txtnresid.setText("");
			  	txtcompresid.setText("");
			  	txtbairro.setText("");
			  	txtcidade.setText("");
			  	txtestado.setText("");
			  	txtcep.setText("");
			  	txtemail.setText("");
			  	txtddd.setText("");
			  	txttelefone.setText("");
			  	txtsalario.setText("");
			  	txtadmissao.setText("");
			  	txtcargo.setText("");
			  	txtagenciacolab.setText("");
			  	txtcontacolab.setText("");
			  	txtdvcolab.setText("");
			  	txtocorrencias.setText("");
			}
		});
		
		JButton btnGravar = new JButton("Gravar");
		btnGravar.setFont(new Font("Calibri", Font.PLAIN, 16));
		btnGravar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnGravar.setBounds(411, 679, 120, 30);
		frame.getContentPane().add(btnGravar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Calibri", Font.PLAIN, 16));
		btnCancelar.setBounds(535, 679, 120, 30);
		frame.getContentPane().add(btnCancelar);
		
		JPanel panelSelecao = new JPanel();
		panelSelecao.setBorder(UIManager.getBorder("ComboBox.border"));
		panelSelecao.setBounds(20, 423, 635, 156);
		frame.getContentPane().add(panelSelecao);
		panelSelecao.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(789, 344, -785, -339);
		scrollPane.setToolTipText("");
		panelSelecao.add(scrollPane);
		
		txtinscricao = new JTextField();
		txtinscricao.setHorizontalAlignment(SwingConstants.CENTER);
		txtinscricao.setFont(new Font("Calibri", Font.PLAIN, 18));
		txtinscricao.setBounds(106, 0, 105, 25);
		panelSelecao.add(txtinscricao);
		txtinscricao.setColumns(10);
		
		txtcnpj = new JTextField();
		txtcnpj.setHorizontalAlignment(SwingConstants.CENTER);
		txtcnpj.setFont(new Font("Calibri", Font.PLAIN, 18));
		txtcnpj.setBounds(212, 0, 105, 25);
		panelSelecao.add(txtcnpj);
		txtcnpj.setColumns(10);
		
		txtagencia = new JTextField();
		txtagencia.setHorizontalAlignment(SwingConstants.CENTER);
		txtagencia.setFont(new Font("Calibri", Font.PLAIN, 18));
		txtagencia.setBounds(424, 0, 105, 25);
		panelSelecao.add(txtagencia);
		txtagencia.setColumns(10);
		
		txtconta = new JTextField();
		txtconta.setHorizontalAlignment(SwingConstants.CENTER);
		txtconta.setFont(new Font("Calibri", Font.PLAIN, 18));
		txtconta.setBounds(530, 0, 105, 25);
		panelSelecao.add(txtconta);
		txtconta.setColumns(10);
		
		txtconvenio = new JTextField();
		txtconvenio.setHorizontalAlignment(SwingConstants.CENTER);
		txtconvenio.setFont(new Font("Calibri", Font.PLAIN, 18));
		txtconvenio.setBounds(318, 0, 105, 25);
		panelSelecao.add(txtconvenio);
		txtconvenio.setColumns(10);
		
		txtdv = new JTextField();
		txtdv.setHorizontalAlignment(SwingConstants.CENTER);
		txtdv.setFont(new Font("Calibri", Font.PLAIN, 16));
		txtdv.setColumns(10);
		txtdv.setBounds(0, 26, 105, 25);
		panelSelecao.add(txtdv);
		
		txtempresa = new JTextField();
		txtempresa.setHorizontalAlignment(SwingConstants.CENTER);
		txtempresa.setFont(new Font("Calibri", Font.PLAIN, 18));
		txtempresa.setColumns(10);
		txtempresa.setBounds(106, 26, 105, 25);
		panelSelecao.add(txtempresa);
		
		txtbanco = new JTextField();
		txtbanco.setHorizontalAlignment(SwingConstants.CENTER);
		txtbanco.setFont(new Font("Calibri", Font.PLAIN, 18));
		txtbanco.setColumns(10);
		txtbanco.setBounds(212, 26, 105, 25);
		panelSelecao.add(txtbanco);
		
		txtremessa = new JTextField();
		txtremessa.setHorizontalAlignment(SwingConstants.CENTER);
		txtremessa.setFont(new Font("Calibri", Font.PLAIN, 18));
		txtremessa.setColumns(10);
		txtremessa.setBounds(318, 26, 105, 25);
		panelSelecao.add(txtremessa);
		
		txtnsa = new JTextField();
		txtnsa.setHorizontalAlignment(SwingConstants.CENTER);
		txtnsa.setFont(new Font("Calibri", Font.PLAIN, 18));
		txtnsa.setColumns(10);
		txtnsa.setBounds(424, 26, 105, 25);
		panelSelecao.add(txtnsa);
		
		txtnome = new JTextField();
		txtnome.setHorizontalAlignment(SwingConstants.CENTER);
		txtnome.setFont(new Font("Calibri", Font.PLAIN, 18));
		txtnome.setColumns(10);
		txtnome.setBounds(530, 26, 105, 25);
		panelSelecao.add(txtnome);
		
		txt_cpf = new JTextField();
		txt_cpf.setHorizontalAlignment(SwingConstants.CENTER);
		txt_cpf.setFont(new Font("Calibri", Font.PLAIN, 16));
		txt_cpf.setColumns(10);
		txt_cpf.setBounds(0, 52, 105, 25);
		panelSelecao.add(txt_cpf);
		
		txtufnasc = new JTextField();
		txtufnasc.setHorizontalAlignment(SwingConstants.CENTER);
		txtufnasc.setFont(new Font("Calibri", Font.PLAIN, 18));
		txtufnasc.setColumns(10);
		txtufnasc.setBounds(106, 52, 105, 25);
		panelSelecao.add(txtufnasc);
		
		txtrg = new JTextField();
		txtrg.setHorizontalAlignment(SwingConstants.CENTER);
		txtrg.setFont(new Font("Calibri", Font.PLAIN, 18));
		txtrg.setColumns(10);
		txtrg.setBounds(212, 52, 105, 25);
		panelSelecao.add(txtrg);
		
		txtdn = new JTextField();
		txtdn.setHorizontalAlignment(SwingConstants.CENTER);
		txtdn.setFont(new Font("Calibri", Font.PLAIN, 18));
		txtdn.setColumns(10);
		txtdn.setBounds(318, 52, 105, 25);
		panelSelecao.add(txtdn);
		
		txtsexo = new JTextField();
		txtsexo.setHorizontalAlignment(SwingConstants.CENTER);
		txtsexo.setFont(new Font("Calibri", Font.PLAIN, 18));
		txtsexo.setColumns(10);
		txtsexo.setBounds(424, 52, 105, 25);
		panelSelecao.add(txtsexo);
		
		txtcivil = new JTextField();
		txtcivil.setHorizontalAlignment(SwingConstants.CENTER);
		txtcivil.setFont(new Font("Calibri", Font.PLAIN, 18));
		txtcivil.setColumns(10);
		txtcivil.setBounds(530, 52, 105, 25);
		panelSelecao.add(txtcivil);
		
		txtmae = new JTextField();
		txtmae.setHorizontalAlignment(SwingConstants.CENTER);
		txtmae.setFont(new Font("Calibri", Font.PLAIN, 16));
		txtmae.setColumns(10);
		txtmae.setBounds(0, 78, 105, 25);
		panelSelecao.add(txtmae);
		
		txtrua = new JTextField();
		txtrua.setHorizontalAlignment(SwingConstants.CENTER);
		txtrua.setFont(new Font("Calibri", Font.PLAIN, 18));
		txtrua.setColumns(10);
		txtrua.setBounds(106, 78, 105, 25);
		panelSelecao.add(txtrua);
		
		txtnresid = new JTextField();
		txtnresid.setFont(new Font("Calibri", Font.PLAIN, 18));
		txtnresid.setHorizontalAlignment(SwingConstants.CENTER);
		txtnresid.setColumns(10);
		txtnresid.setBounds(212, 78, 105, 25);
		panelSelecao.add(txtnresid);
		
		txtcompresid = new JTextField();
		txtcompresid.setFont(new Font("Calibri", Font.PLAIN, 18));
		txtcompresid.setColumns(10);
		txtcompresid.setBounds(318, 78, 105, 25);
		panelSelecao.add(txtcompresid);
		
		txtbairro = new JTextField();
		txtbairro.setHorizontalAlignment(SwingConstants.CENTER);
		txtbairro.setFont(new Font("Calibri", Font.PLAIN, 18));
		txtbairro.setColumns(10);
		txtbairro.setBounds(424, 78, 105, 25);
		panelSelecao.add(txtbairro);
		
		txtcidade = new JTextField();
		txtcidade.setFont(new Font("Calibri", Font.PLAIN, 18));
		txtcidade.setHorizontalAlignment(SwingConstants.CENTER);
		txtcidade.setColumns(10);
		txtcidade.setBounds(530, 78, 105, 25);
		panelSelecao.add(txtcidade);
		
		txtestado = new JTextField();
		txtestado.setHorizontalAlignment(SwingConstants.CENTER);
		txtestado.setFont(new Font("Calibri", Font.PLAIN, 16));
		txtestado.setColumns(10);
		txtestado.setBounds(0, 104, 105, 25);
		panelSelecao.add(txtestado);
		
		txtadmissao = new JTextField();
		txtadmissao.setHorizontalAlignment(SwingConstants.CENTER);
		txtadmissao.setFont(new Font("Calibri", Font.PLAIN, 16));
		txtadmissao.setColumns(10);
		txtadmissao.setBounds(0, 130, 105, 25);
		panelSelecao.add(txtadmissao);
		
		txtocorrencias = new JTextField();
		txtocorrencias.setHorizontalAlignment(SwingConstants.CENTER);
		txtocorrencias.setFont(new Font("Calibri", Font.PLAIN, 18));
		txtocorrencias.setColumns(10);
		txtocorrencias.setBounds(530, 130, 105, 25);
		panelSelecao.add(txtocorrencias);
		
		txtsalario = new JTextField();
		txtsalario.setHorizontalAlignment(SwingConstants.CENTER);
		txtsalario.setFont(new Font("Calibri", Font.PLAIN, 18));
		txtsalario.setColumns(10);
		txtsalario.setBounds(530, 104, 105, 25);
		panelSelecao.add(txtsalario);
		
		txttelefone = new JTextField();
		txttelefone.setHorizontalAlignment(SwingConstants.CENTER);
		txttelefone.setFont(new Font("Calibri", Font.PLAIN, 18));
		txttelefone.setColumns(10);
		txttelefone.setBounds(424, 104, 105, 25);
		panelSelecao.add(txttelefone);
		
		txtdvcolab = new JTextField();
		txtdvcolab.setHorizontalAlignment(SwingConstants.CENTER);
		txtdvcolab.setFont(new Font("Calibri", Font.PLAIN, 18));
		txtdvcolab.setColumns(10);
		txtdvcolab.setBounds(424, 130, 105, 25);
		panelSelecao.add(txtdvcolab);
		
		txtcontacolab = new JTextField();
		txtcontacolab.setHorizontalAlignment(SwingConstants.CENTER);
		txtcontacolab.setFont(new Font("Calibri", Font.PLAIN, 18));
		txtcontacolab.setColumns(10);
		txtcontacolab.setBounds(318, 130, 105, 25);
		panelSelecao.add(txtcontacolab);
		
		txtddd = new JTextField();
		txtddd.setHorizontalAlignment(SwingConstants.CENTER);
		txtddd.setFont(new Font("Calibri", Font.PLAIN, 18));
		txtddd.setColumns(10);
		txtddd.setBounds(318, 104, 105, 25);
		panelSelecao.add(txtddd);
		
		txtemail = new JTextField();
		txtemail.setHorizontalAlignment(SwingConstants.CENTER);
		txtemail.setFont(new Font("Calibri", Font.PLAIN, 18));
		txtemail.setColumns(10);
		txtemail.setBounds(212, 104, 105, 25);
		panelSelecao.add(txtemail);
		
		txtagenciacolab = new JTextField();
		txtagenciacolab.setHorizontalAlignment(SwingConstants.CENTER);
		txtagenciacolab.setFont(new Font("Calibri", Font.PLAIN, 18));
		txtagenciacolab.setColumns(10);
		txtagenciacolab.setBounds(212, 130, 105, 25);
		panelSelecao.add(txtagenciacolab);
		
		txtcargo = new JTextField();
		txtcargo.setHorizontalAlignment(SwingConstants.CENTER);
		txtcargo.setFont(new Font("Calibri", Font.PLAIN, 18));
		txtcargo.setColumns(10);
		txtcargo.setBounds(106, 130, 105, 25);
		panelSelecao.add(txtcargo);
		
		txtcep = new JTextField();
		txtcep.setHorizontalAlignment(SwingConstants.CENTER);
		txtcep.setFont(new Font("Calibri", Font.PLAIN, 18));
		txtcep.setColumns(10);
		txtcep.setBounds(106, 104, 105, 25);
		panelSelecao.add(txtcep);
		
		txtcodigobco = new JTextField();
		txtcodigobco.setBounds(0, 0, 105, 25);
		panelSelecao.add(txtcodigobco);
		txtcodigobco.setHorizontalAlignment(SwingConstants.CENTER);
		txtcodigobco.setFont(new Font("Calibri", Font.PLAIN, 16));
		txtcodigobco.setColumns(10);
	}
}
