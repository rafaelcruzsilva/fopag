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

public class Gera_Conta {
	
	private static final SimpleDateFormat DATE_FORMAT_BR = new SimpleDateFormat("ddMMYYYY");
	
	private static final SimpleDateFormat DATE_FORMAT_US = new SimpleDateFormat("YYYYMMdd");

	public JFrame frame;
	public JTextField txtData;
	public JTextArea txtCnab;

	/**
	 * OriginaApp
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gera_Conta window = new Gera_Conta();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Gera_Conta() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Abertura de conta sal\u00E1rio");
		frame.setBounds(100, 100, 700, 870);
		frame.getContentPane().setLayout(null);
		
		JLabel lbcnab = new JLabel("Gera\u00E7\u00E3o do Arquivo CNAB 240 - Abertura de Conta");
		lbcnab.setBounds(10, 10, 645, 60);
		lbcnab.setHorizontalAlignment(SwingConstants.CENTER);
		lbcnab.setFont(new Font("Calibri", Font.PLAIN, 30));
		frame.getContentPane().add(lbcnab);
		
		JPanel panelBanco = new JPanel();
		panelBanco.setLayout(null);
		panelBanco.setBorder(UIManager.getBorder("ComboBox.border"));
		panelBanco.setBounds(20, 96, 635, 143);
		frame.getContentPane().add(panelBanco);
		
		JRadioButton rdbtnDataatual = new JRadioButton("Data Atual");
		rdbtnDataatual.setFont(new Font("Calibri", Font.PLAIN, 18));
		rdbtnDataatual.setBounds(11, 52, 200, 30);
		panelBanco.add(rdbtnDataatual);
		
		JLabel ldSelecaodata = new JLabel("Insira a data da solicita\u00E7ao da Conta Sal\u00E1rio");
		ldSelecaodata.setFont(new Font("Calibri", Font.BOLD, 18));
		ldSelecaodata.setBounds(15, 16, 412, 24);
		panelBanco.add(ldSelecaodata);
		
		JRadioButton rdbtnInserirdata = new JRadioButton("Inserir Data");
		rdbtnInserirdata.setBounds(230, 52, 200, 30);
		panelBanco.add(rdbtnInserirdata);
		
		txtData = new JTextField();
		txtData.setFont(new Font("Calibri", Font.PLAIN, 18));
		txtData.setBounds(441, 53, 120, 30);
		panelBanco.add(txtData);
		txtData.setColumns(10);
		
		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(rdbtnDataatual);
		buttonGroup.add(rdbtnInserirdata);
		
		JButton btnEnviar = new JButton("Enviar");
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					final JFileChooser fileChooser = new JFileChooser();					
					fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
					final Integer directoryOption = fileChooser.showOpenDialog(frame);
					
					if (directoryOption != JFileChooser.APPROVE_OPTION) {
						JOptionPane.showMessageDialog(null, "Diretório inválido", "Erro", JOptionPane.ERROR_MESSAGE);
						return;
					}
					
					
					//String teste = String.format("Olá %s. Sua conta é %s, seu saldo é %s", "Iago", conta, saldo);					
					//"Olá Iago. Sua conta é 123, seu saldo é 500";
					
					final String nomeArquivo = String.format("TCYS_%s_%s.txt", "1", DATE_FORMAT_US.format(new Date()));
					
					final File file = new File(fileChooser.getSelectedFile(), nomeArquivo);
					
					final String dataConsulta = rdbtnDataatual.isSelected() ? DATE_FORMAT_BR.format(new Date()) : txtData.getText();
					
					System.out.println("Chamando consulta");
					
					String query = String.format("SELECT * FROM fopagdb.contastb WHERE data LIKE '%s'", dataConsulta);
					
					System.out.println(query);
					
					ResultSet resultado = Fopag.connection.getData(query);
					
					String data;
					String codigobco;
					String inscricao;
					String cnpj;
					String convenio;
					String agenciaempresa;
					String contaempresa;
					String dvempresa;
					String empresa;
					String banco;
					String remessa;
					String nsa;
					String colaborador;
					String cpf;
					String ufnasc;
					String rg;
					String dn;
					String sexo;
					String civil;
					String mae;
					String ruacolab;
					String nresidcolab;
					String compresidcolab;
					String bairrocolab;
					String cidadecolab;
					String estadocolab;
					String cepcolab;
					String emailcolab;
					String dddcolab;
					String telefonecolab;
					String salario;
					String admissao;
					String cargo;
					String agenciacolab;
					String contasalario;
					String dvcolab;
					String ocorrencias;	
						
					final FileWriter fileWriter = new FileWriter(file);
					
					 while (resultado.next()) {
						 
						 data = StringUtils.leftPad(resultado.getString("data"), 8, ".");
						 codigobco = StringUtils.leftPad(resultado.getString("codigobco"), 3, ".");
						 inscricao = StringUtils.leftPad(resultado.getString("inscricao"), 1, ".");
						 cnpj = StringUtils.leftPad(resultado.getString("cnpj"), 14, ".");
						 convenio = StringUtils.leftPad(resultado.getString("convenio"), 20, ".");
						 agenciaempresa = StringUtils.leftPad(resultado.getString("agenciaemp"), 5, ".");
						 contaempresa = StringUtils.leftPad(resultado.getString("contaemp"), 9, ".");
						 dvempresa = StringUtils.leftPad(resultado.getString("dvemp"), 1, ".");
						 empresa = StringUtils.leftPad(resultado.getString("empresa"), 30, ".");
						 banco = StringUtils.leftPad(resultado.getString("bancoemp"), 30, ".");
						 remessa = StringUtils.leftPad(resultado.getString("remessa") == null ? "1" : resultado.getString("remessa"), 1, ".");
						 nsa = StringUtils.leftPad(resultado.getString("nsa") == null ? "1" : resultado.getString("nsa"), 6, ".");
						 colaborador = StringUtils.leftPad(resultado.getString("nome"), 40, ".");
						 cpf = StringUtils.leftPad(resultado.getString("cpf"), 11, ".");
						 ufnasc = StringUtils.leftPad(resultado.getString("ufnasc"), 2, ".");
						 rg = StringUtils.leftPad(resultado.getString("rg"), 20, ".");
						 dn = StringUtils.leftPad(resultado.getString("dn"), 8, ".");
						 sexo = StringUtils.leftPad(resultado.getString("sexo"), 1, ".");
						 civil = StringUtils.leftPad(resultado.getString("civil"), 2, ".");
						 mae = StringUtils.leftPad(resultado.getString("mae"), 30, ".");
						 ruacolab = StringUtils.leftPad(resultado.getString("ruacolab"), 30, ".");
						 nresidcolab = StringUtils.leftPad(resultado.getString("nresidcolab"), 5, ".");
						 compresidcolab = StringUtils.leftPad(resultado.getString("compresidcolab"), 15, ".");
						 bairrocolab = StringUtils.leftPad(resultado.getString("bairrocolab"), 15, ".");
						 cidadecolab = StringUtils.leftPad(resultado.getString("cidadecolab"), 20, ".");
						 estadocolab = StringUtils.leftPad(resultado.getString("estadocolab"), 2, ".");
						 cepcolab = StringUtils.leftPad(resultado.getString("cepcolab"), 8, ".");
						 emailcolab = StringUtils.leftPad(resultado.getString("emailcolab"), 80, ".");
						 dddcolab = StringUtils.leftPad(resultado.getString("dddcolab"), 2, ".");
						 telefonecolab = StringUtils.leftPad(resultado.getString("telefonecolab"), 9, ".");
						 salario = StringUtils.leftPad(resultado.getString("salario"), 9, ".");
						 admissao = StringUtils.leftPad(resultado.getString("admissao"), 8, ".");
						 cargo = StringUtils.leftPad(resultado.getString("cargo"), 4, ".");
						 agenciacolab = StringUtils.leftPad(resultado.getString("agenciacolab"), 5, ".");
						 contasalario = StringUtils.leftPad(resultado.getString("contacolab"), 9, ".");
						 dvcolab = StringUtils.leftPad(resultado.getString("dvcolab"), 1, ".");
						 ocorrencias = StringUtils.leftPad(resultado.getString("ocorrencias"), 1, ".");
						 
						 fileWriter.write(cpf);
						 fileWriter.write(colaborador);
						 fileWriter.write(data);
						 fileWriter.write(codigobco);
						 fileWriter.write(inscricao);
						 fileWriter.write(cnpj);
						 fileWriter.write(convenio);
						 fileWriter.write("\n");
					 }
					 
					 fileWriter.close();
			    }
			    catch (Exception ex) {
				    ex.printStackTrace();
				}

				JOptionPane.showMessageDialog(null, "Processamento concluído!");
				
			}
		});
		
		btnEnviar.setFont(new Font("Calibri", Font.PLAIN, 18));
		btnEnviar.setBounds(505, 99, 115, 29);
		panelBanco.add(btnEnviar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Calibri", Font.PLAIN, 18));
		btnCancelar.setBounds(529, 751, 120, 30);
		frame.getContentPane().add(btnCancelar);
	}
}

