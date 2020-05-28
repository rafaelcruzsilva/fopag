import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import org.apache.commons.lang3.StringUtils;

public class Imprime_Formulario {
	
	private static final SimpleDateFormat DATE_FORMAT_BR = new SimpleDateFormat("ddMMYYYY");
	
	private static final SimpleDateFormat DATE_FORMAT_US = new SimpleDateFormat("YYYYMMdd");
	
	private static final SimpleDateFormat HH_MM_SS_FORMAT = new SimpleDateFormat("HHmmss");

	public JFrame frame;
	public JTextField txtNome;
	public JTextArea txtCnab;
	public JTextField txtCpf;

	/**
	 * OriginaApp
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Imprime_Formulario window = new Imprime_Formulario();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Imprime_Formulario() {
		initialize();
	}

	private void initialize() {
		
		frame = new JFrame();
		frame.setTitle("Abertura de Conta - Banco Original");
		frame.setBounds(100, 100, 700, 780);
		frame.getContentPane().setLayout(null);
		
		JPanel panelBanco = new JPanel();
		panelBanco.setLayout(null);
		panelBanco.setBorder(UIManager.getBorder("ComboBox.border"));
		panelBanco.setBounds(20, 92, 643, 262);
		frame.getContentPane().add(panelBanco);
		
		JRadioButton rdbtnCpf = new JRadioButton("Gerar Relat\u00F3rio por CPF");
		rdbtnCpf.setFont(new Font("Calibri", Font.PLAIN, 16));
		rdbtnCpf.setBounds(11, 60, 200, 25);
		rdbtnCpf.setSelected(Boolean.TRUE);
		panelBanco.add(rdbtnCpf);
		
		JLabel ldSelecaodata = new JLabel("Insira a data da solicita\u00E7ao da Conta Sal\u00E1rio");
		ldSelecaodata.setFont(new Font("Calibri", Font.BOLD, 16));
		ldSelecaodata.setBounds(15, 16, 412, 24);
		panelBanco.add(ldSelecaodata);
		
		JRadioButton rdbtnNome = new JRadioButton("Gerar Relat\u00F3rio por Nome");
		rdbtnNome.setFont(new Font("Calibri", Font.PLAIN, 16));
		rdbtnNome.setBounds(11, 108, 200, 25);
		panelBanco.add(rdbtnNome);
		
		JRadioButton rdbtnBranco = new JRadioButton("Gerar Relat\u00F3rio em Branco");
		rdbtnBranco.setFont(new Font("Calibri", Font.PLAIN, 16));
		rdbtnBranco.setBounds(11, 156, 235, 25);
		panelBanco.add(rdbtnBranco);
		
		txtNome = new JTextField();
		txtNome.setHorizontalAlignment(SwingConstants.CENTER);
		txtNome.setFont(new Font("Calibri", Font.PLAIN, 16));
		txtNome.setBounds(325, 107, 300, 25);
		panelBanco.add(txtNome);
		txtNome.setColumns(10);
		
		txtCpf = new JTextField();
		txtCpf.setHorizontalAlignment(SwingConstants.CENTER);
		txtCpf.setFont(new Font("Calibri", Font.PLAIN, 16));
		txtCpf.setColumns(10);
		txtCpf.setBounds(325, 60, 300, 25);
		panelBanco.add(txtCpf);
		
		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(rdbtnCpf);
		buttonGroup.add(rdbtnNome);
		buttonGroup.add(rdbtnBranco);
		
		JButton btnGerar = new JButton("Gerar");

		btnGerar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String cpf = null;
				String nome = null;
				String rg = null;
				String dn = null;
				String nresid = null;
				String compresid = null;
				String bairro = null;
				String cidade = null;
				String cep = null;
				String banco = null;
				String agencia = null;
				String conta = null;
				String dv = null;
				String mae = null;
				String rua = null;
				String email = null;
				String ddd = null;
				String telefone = null;
				String cargo = null;
				String admissao = null;
				String salario = null;
				String data = null;
				String hora = null;
				String cpffixo = null;
				String nomefixo = null;
				String rgfixo = null;
				String dnfixo = null;
				String nresidfixo = null;
				String compresidfixo = null;
				String bairrofixo = null;
				String cidadefixo = null;
				String cepfixo = null;
				String bancofixo = null;
				String agenciafixo = null;
				String contafixo = null;
				String dvfixo = null;
				String maefixo = null;
				String ruafixo = null;
				String emailfixo = null;
				String dddfixo = null;
				String telefonefixo = null;
				String cargofixo = null;
				String admissaofixo = null;
				String salariofixo = null;
				String separador = null;
				String filler5 = null;
				String datafixo = null;
				String horafixo = null;

				try {
					
					if (rdbtnCpf.isSelected() && txtCpf.getText().length() != 11) {
						JOptionPane.showMessageDialog(null, "Insira o CPF", "Erro", JOptionPane.ERROR_MESSAGE);
						return;
						
					} else if (rdbtnNome.isSelected() && txtNome.getText().trim().equals("")) {
						JOptionPane.showMessageDialog(null, "Insira o Nome Completo", "Erro", JOptionPane.ERROR_MESSAGE);
						return;
					}
					
					else if (rdbtnBranco.isSelected()) {
						JOptionPane.showMessageDialog(null, "Formulário para preenchimento manual", "AVISO", JOptionPane.WARNING_MESSAGE);
					}
					
					final JFileChooser fileChooser = new JFileChooser();					
					fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
					final Integer directoryOption = fileChooser.showOpenDialog(frame);
					
					if (directoryOption != JFileChooser.APPROVE_OPTION) {
						JOptionPane.showMessageDialog(null, "Diretorio invalido", "Erro", JOptionPane.ERROR_MESSAGE);
						return;
					}
										
					String nomeArquivo = "";
					if (rdbtnCpf.isSelected())
					{
						nomeArquivo = String.format("FORMULARIO_%s.txt", txtCpf.getText());
					}
					else if (rdbtnNome.isSelected())
					{
						nomeArquivo = String.format("FORMULARIO_%s.txt", txtNome.getText());					
					}
					
					
					final File file = new File(fileChooser.getSelectedFile(), nomeArquivo);
					
					System.out.println("Chamando consulta");
					
					String query = "";
					if (rdbtnCpf.isSelected())
					{
						query = String.format("SELECT * FROM fopagdb.cadastrotb WHERE `cpf` = " + txtCpf.getText());
					}
					else if (rdbtnNome.isSelected())
					{
						query = String.format("SELECT * FROM fopagdb.cadastrotb WHERE `nome` = '" + txtNome.getText() + "'");						
					}
					
					System.out.println(query);
					
					ResultSet resultado = Fopag.connection.getData(query);
						
					final FileWriter fileWriter = new FileWriter(file);
					
					Boolean setFileHeader = Boolean.TRUE;
					Boolean hasLines = Boolean.FALSE;
					
					Integer contador = 0;
					
					 while (resultado.next()) {
						 
						 hasLines = Boolean.TRUE;
						 
						 data = DATE_FORMAT_US.format(new Date()); 
						 hora = HH_MM_SS_FORMAT.format(new Date()); 
						 cpf = StringUtils.rightPad(resultado.getString("cpf") != null ? resultado.getString("cpf") : "", 30, "_");
						 nome = StringUtils.rightPad(resultado.getString("nome") != null ? resultado.getString("nome") : "", 30, "_");
						 rg = StringUtils.rightPad(resultado.getString("rg") != null ? resultado.getString("rg") : "", 30, "_");
						 dn = StringUtils.rightPad(resultado.getString("dn") != null ? resultado.getString("dn") : "", 30, "_");
						 nresid = StringUtils.rightPad(resultado.getString("nresid") != null ? resultado.getString("nresid") : "", 30, "_");
						 compresid = StringUtils.rightPad(resultado.getString("compresid") != null ? resultado.getString("compresid") : "", 30, "_");
						 bairro = StringUtils.rightPad(resultado.getString("bairro") != null ? resultado.getString("bairro") : "", 30, "_");
						 cidade = StringUtils.rightPad(resultado.getString("cidade") != null ? resultado.getString("cidade") : "", 30, "_");
						 cep = StringUtils.rightPad(resultado.getString("cep") != null ? resultado.getString("cep") : "", 30, "_");
						 banco = StringUtils.rightPad(resultado.getString("banco") != null ? resultado.getString("banco") : "", 30, "_");
						 agencia = StringUtils.rightPad(resultado.getString("agencia") != null ? resultado.getString("agencia") : "", 30, "_");
						 conta = StringUtils.rightPad(resultado.getString("conta") != null ? resultado.getString("conta") : "", 30, "_");
						 dv = StringUtils.rightPad(resultado.getString("dv") != null ? resultado.getString("dv") : "", 30, "_");
						 mae = StringUtils.rightPad(resultado.getString("mae") != null ? resultado.getString("mae") : "", 30, "_");
						 rua = StringUtils.rightPad(resultado.getString("rua") != null ? resultado.getString("rua") : "", 30, "_");
						 email = StringUtils.rightPad(resultado.getString("email") != null ? resultado.getString("email") : "", 30, "_");
						 ddd = StringUtils.rightPad(resultado.getString("ddd") != null ? resultado.getString("ddd") : "", 30, "_");
						 telefone = StringUtils.rightPad(resultado.getString("telefone") != null ? resultado.getString("telefone") : "", 30, "_");
						 cargo = StringUtils.rightPad(resultado.getString("cargo") != null ? resultado.getString("cargo") : "", 30, "_");
						 admissao = StringUtils.rightPad(resultado.getString("admissao") != null ? resultado.getString("admissao") : "", 30, "_");
						 salario = StringUtils.rightPad(resultado.getString("salario") != null ? resultado.getString("salario") : "", 30, "_");
						 
						 separador = ":"; 	
						 filler5 = StringUtils.rightPad(" ", 5, " ");
						 cpffixo = StringUtils.rightPad("CPF", 20, " ");
						 nomefixo = StringUtils.rightPad("Nome Completo", 20, " ");
						 rgfixo = StringUtils.rightPad("RG", 20, " ");
						 dnfixo = StringUtils.rightPad("Data de Nascimento", 20, " ");
						 nresidfixo = StringUtils.rightPad("Numero Residencial", 20, " ");
						 compresidfixo = StringUtils.rightPad("Complemento", 20, " ");
						 bairrofixo = StringUtils.rightPad("Bairro", 20, " ");
						 cidadefixo = StringUtils.rightPad("Cidade", 20, " ");
						 cepfixo = StringUtils.rightPad("CEP", 20, " ");
						 bancofixo = StringUtils.rightPad("Banco", 20, " ");
						 agenciafixo = StringUtils.rightPad("Agencia", 20, " ");
						 contafixo = StringUtils.rightPad("Conta Salário", 20, " ");
						 dvfixo = StringUtils.rightPad("Digito Verificador", 20, " ");
						 maefixo = StringUtils.rightPad("Nome da Mãe", 20, " ");
						 ruafixo = StringUtils.rightPad("Rua/Avenida", 20, " ");
						 emailfixo = StringUtils.rightPad("e-mail", 20, " ");
						 dddfixo = StringUtils.rightPad("DDD", 20, " ");
						 telefonefixo = StringUtils.rightPad("Telefone Celular", 20, " ");
						 cargofixo = StringUtils.rightPad("Cargo", 20, " ");
						 admissaofixo = StringUtils.rightPad("Data de Admissão", 20, " ");
						 salariofixo = StringUtils.rightPad("Salário", 20, " ");
						 datafixo = StringUtils.rightPad("Impresso em", 20, " ");
						 horafixo = StringUtils.rightPad("Às", 20, " ");
						 
						 if (setFileHeader) {
							 
							 setFileHeader = Boolean.FALSE;
							 
							//Nome
							 fileWriter.write(datafixo);
							 fileWriter.write(separador);
							 fileWriter.write(filler5);
							 fileWriter.write(data);
							 fileWriter.write("\r\n");
							//CPF
							 fileWriter.write(horafixo);
							 fileWriter.write(separador);
							 fileWriter.write(filler5);
							 fileWriter.write(hora);
							 fileWriter.write("\r\n");
							 //Nome
							 fileWriter.write(nomefixo);
							 fileWriter.write(separador);
							 fileWriter.write(filler5);
							 fileWriter.write(nome);
							 fileWriter.write("\r\n");
							//CPF
							 fileWriter.write(cpffixo);
							 fileWriter.write(separador);
							 fileWriter.write(filler5);
							 fileWriter.write(cpf);
							 fileWriter.write("\r\n");
							 //RG
							 fileWriter.write(rgfixo);
							 fileWriter.write(separador);
							 fileWriter.write(filler5);
							 fileWriter.write(rg);
							 fileWriter.write("\r\n");
							 //Nome da Mãe
							 fileWriter.write(maefixo);
							 fileWriter.write(separador);
							 fileWriter.write(filler5);
							 fileWriter.write(mae);
							 fileWriter.write("\r\n");
							 //Data de Nascimento
							 fileWriter.write(dnfixo);
							 fileWriter.write(separador);
							 fileWriter.write(filler5);
							 fileWriter.write(dn);
							 fileWriter.write("\r\n");
							 //Rua/Avenida
							 fileWriter.write(ruafixo);
							 fileWriter.write(separador);
							 fileWriter.write(filler5);
							 fileWriter.write(rua);
							 fileWriter.write("\r\n");
							 //Numero Residencial
							 fileWriter.write(nresidfixo);
							 fileWriter.write(separador);
							 fileWriter.write(filler5);
							 fileWriter.write(nresid);
							 fileWriter.write("\r\n");
							 //Complemento
							 fileWriter.write(compresidfixo);
							 fileWriter.write(separador);
							 fileWriter.write(filler5);
							 fileWriter.write(compresid);
							 fileWriter.write("\r\n");
							 //Bairro
							 fileWriter.write(bairrofixo);
							 fileWriter.write(separador);
							 fileWriter.write(filler5);
							 fileWriter.write(bairro);
							 fileWriter.write("\r\n");
							 //Cidade
							 fileWriter.write(cidadefixo);
							 fileWriter.write(separador);
							 fileWriter.write(filler5);
							 fileWriter.write(cidade);
							 fileWriter.write("\r\n");
							 //CEP
							 fileWriter.write(cepfixo);
							 fileWriter.write(separador);
							 fileWriter.write(filler5);
							 fileWriter.write(cep);
							 fileWriter.write("\r\n");
							 //DDD
							 fileWriter.write(dddfixo);
							 fileWriter.write(separador);
							 fileWriter.write(filler5);
							 fileWriter.write(ddd);
							 fileWriter.write("\r\n");
							 //Telefone Celular
							 fileWriter.write(telefonefixo);
							 fileWriter.write(separador);
							 fileWriter.write(filler5);
							 fileWriter.write(telefone);
							 fileWriter.write("\r\n");
							 //e-mail
							 fileWriter.write(emailfixo);
							 fileWriter.write(separador);
							 fileWriter.write(filler5);
							 fileWriter.write(email);
							 fileWriter.write("\r\n");
							 //Cargo
							 fileWriter.write(cargofixo);
							 fileWriter.write(separador);
							 fileWriter.write(filler5);
							 fileWriter.write(cargo);
							 fileWriter.write("\r\n");
							 //Salário
							 fileWriter.write(salariofixo);
							 fileWriter.write(separador);
							 fileWriter.write(filler5);
							 fileWriter.write(salario);
							 fileWriter.write("\r\n");
							 //Data de Admissão
							 fileWriter.write(admissaofixo);
							 fileWriter.write(separador);
							 fileWriter.write(filler5);
							 fileWriter.write(admissao);
							 fileWriter.write("\r\n");
							 //Banco
							 fileWriter.write(bancofixo);
							 fileWriter.write(separador);
							 fileWriter.write(filler5);
							 fileWriter.write(banco);
							 fileWriter.write("\r\n");
							 //Agencia
							 fileWriter.write(agenciafixo);
							 fileWriter.write(separador);
							 fileWriter.write(filler5);
							 fileWriter.write(agencia);
							 fileWriter.write("\r\n");
							 //Conta
							 fileWriter.write(contafixo);
							 fileWriter.write(separador);
							 fileWriter.write(filler5);
							 fileWriter.write(conta);
							 fileWriter.write("\r\n");
							 //Digito Verificador
							 fileWriter.write(dvfixo);
							 fileWriter.write(separador);
							 fileWriter.write(filler5);
							 fileWriter.write(dv);
							 fileWriter.write("\r\n");	 
						 }
						 
						 }
					 
					fileWriter.close();
			    }
			    catch (Exception ex) {
				    ex.printStackTrace();
				    JOptionPane.showMessageDialog(null, "Erro ao gerar arquivo", "Erro", JOptionPane.ERROR_MESSAGE);
				    return;
				}

				JOptionPane.showMessageDialog(null, "Processamento concluido!", "Sucesso", JOptionPane.DEFAULT_OPTION);
				
			}
		});
		
		btnGerar.setFont(new Font("Calibri", Font.PLAIN, 16));
		btnGerar.setBounds(325, 216, 300, 30);
		panelBanco.add(btnGerar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnCancelar.setFont(new Font("Calibri", Font.PLAIN, 16));
		btnCancelar.setBounds(340, 678, 315, 30);
		frame.getContentPane().add(btnCancelar);
		
		JLabel lbcnab = new JLabel("Gera\u00E7\u00E3o do Arquivo CNAB 240 - Gerar Relat\u00F3rio");
		lbcnab.setBounds(20, 10, 643, 60);
		frame.getContentPane().add(lbcnab);
		lbcnab.setHorizontalAlignment(SwingConstants.CENTER);
		lbcnab.setFont(new Font("Calibri", Font.PLAIN, 25));
	
	}
}