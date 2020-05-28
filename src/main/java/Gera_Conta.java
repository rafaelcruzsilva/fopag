import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
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
import javax.swing.text.MaskFormatter;
import org.apache.commons.lang3.StringUtils;

public class Gera_Conta {
	
	private static final SimpleDateFormat DATE_FORMAT_BR = new SimpleDateFormat("ddMMYYYY");
	
	private static final SimpleDateFormat DATE_FORMAT_US = new SimpleDateFormat("YYYYMMdd");
	
	private static final SimpleDateFormat HH_MM_SS_FORMAT = new SimpleDateFormat("HHmmss");

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
		
		MaskFormatter dataMascara = null;
		
		try {
			dataMascara = new MaskFormatter("##/##/####");
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		
		frame = new JFrame();
		frame.setTitle("Abertura de Conta - Banco Original");
		frame.setBounds(100, 100, 700, 780);
		frame.getContentPane().setLayout(null);
		
		JPanel panelBanco = new JPanel();
		panelBanco.setLayout(null);
		panelBanco.setBorder(UIManager.getBorder("ComboBox.border"));
		panelBanco.setBounds(20, 92, 643, 143);
		frame.getContentPane().add(panelBanco);
		
		JRadioButton rdbtnDataatual = new JRadioButton("Data Atual");
		rdbtnDataatual.setFont(new Font("Calibri", Font.PLAIN, 16));
		rdbtnDataatual.setBounds(11, 60, 120, 25);
		rdbtnDataatual.setSelected(Boolean.TRUE);
		panelBanco.add(rdbtnDataatual);
		
		JLabel ldSelecaodata = new JLabel("Insira a data da solicita\u00E7ao da Conta Sal\u00E1rio");
		ldSelecaodata.setFont(new Font("Calibri", Font.BOLD, 16));
		ldSelecaodata.setBounds(15, 16, 412, 24);
		panelBanco.add(ldSelecaodata);
		
		JRadioButton rdbtnInserirdata = new JRadioButton("Inserir Data");
		rdbtnInserirdata.setFont(new Font("Calibri", Font.PLAIN, 16));
		rdbtnInserirdata.setBounds(307, 60, 120, 25);
		panelBanco.add(rdbtnInserirdata);
		
		txtData = new JTextField();
		txtData.setHorizontalAlignment(SwingConstants.CENTER);
		txtData.setFont(new Font("Calibri", Font.PLAIN, 16));
		txtData.setBounds(441, 60, 184, 25);
		panelBanco.add(txtData);
		txtData.setColumns(10);
		
		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(rdbtnDataatual);
		buttonGroup.add(rdbtnInserirdata);
		
		JButton btnEnviar = new JButton("Enviar");

		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					try {String query = "INSERT INTO `fopagdb`.`nsatb`\n" +
				            "(`data`)\n" +
						    "VALUES\n" +
						    "('" + new SimpleDateFormat("ddMMYYYY").format(new Date()) + "')";
			            
			            Fopag.connection.insertData(query);
						JOptionPane.showMessageDialog(btnEnviar, "O sistema gerou um novo Numero Sequencial (NSA)");
						}
				
					catch (SQLException ex){
						
							JOptionPane.showMessageDialog(btnEnviar, "O sistema nao gerou um novo Numero Sequencial (NSA) automáticamente! Por Favor, refaça a operaçao!");
							ex.printStackTrace();
						}
		
				try {
					
					String queryNSA = "SELECT MAX(id) FROM fopagdb.nsatb";
					ResultSet resultadoNSA = Fopag.connection.getData(queryNSA);
					
					String nsa = null;
					String maxID = "";
					while(resultadoNSA.next())
					{
						System.out.println("next");
						maxID = resultadoNSA.getString("MAX(id)");
					}
					
					String queryNSA2 = "SELECT * FROM fopagdb.nsatb where id='" + maxID + "'";
					ResultSet resultadoNSA2 = Fopag.connection.getData(queryNSA2);
					
					while (resultadoNSA2.next())
					{
						nsa = resultadoNSA2.getString("id");
					}
					
					final JFileChooser fileChooser = new JFileChooser();					
					fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
					final Integer directoryOption = fileChooser.showOpenDialog(frame);
					
					if (directoryOption != JFileChooser.APPROVE_OPTION) {
						JOptionPane.showMessageDialog(null, "Diretorio invalido", "Erro", JOptionPane.ERROR_MESSAGE);
						return;
					}
					
					if (!rdbtnDataatual.isSelected() && !FopagUtils.isDataValida(txtData.getText())) {
						JOptionPane.showMessageDialog(null, "Data invalida", "Erro", JOptionPane.ERROR_MESSAGE);
						return;
					}
					
					final String nomeArquivo = String.format("TCSYS_REMESSAAGENDAMENTO_%s%s%s%s.txt", DATE_FORMAT_US.format(new Date()), HH_MM_SS_FORMAT.format(new Date()), "1", nsa);
					
					final File file = new File(fileChooser.getSelectedFile(), nomeArquivo);
					
					final String dataConsulta = rdbtnDataatual.isSelected() ? DATE_FORMAT_BR.format(new Date()) : FopagUtils.getSomenteDigitos(txtData.getText());
					
					System.out.println("Chamando consulta");
					
					String query = String.format("SELECT * FROM fopagdb.contastb WHERE data LIKE '%s'", dataConsulta);
					
					System.out.println(query);
					
					ResultSet resultado = Fopag.connection.getData(query);
					
					String data = null;
					String hora = null;
					String codigobco = null;
					String lotesvcheader = null;
					String lotesvctrailer = null;
					String lotesvcheaderlote = null;
					String lotesvctrailerlote = null;
					String lotesvcsegmentod = null;
					String lotesvcsegmentoe = null;
					String tpheaderreg = null;
					String tpheaderlote = null;
					String tptrailerlote = null;
					String tptrailer = null;
					String tpopelote = null;
					String tpservlote = null;
					String tplanclote = null;
					String versaolote = null;
					String inscricao = null;
					String cnpj = null;
					String convenio = null;
					String agenciaempresa = null;
					String contaempresa = null;
					String dvempresa = null;
					String empresa = null;
					String banco = null;
					String remessa = null;
					String layout = null;
					String colaborador = null;
					String cpf = null;
					String ufnasc = null;
					String rg = null;
					String dn = null;
					String sexo = null;
					String civil = null;
					String mae = null;
					String ruacolab = null;
					String nresidcolab = null;
					String compresidcolab = null;
					String bairrocolab = null;
					String cidadecolab = null;
					String estadocolab = null;
					String cepcolab = null;
					String emailcolab = null;
					String dddcolab = null;
					String telefonecolab = null;
					String salario = null;
					String admissao = null;
					String cargo = null;
					String agenciacolab = null;
					String contasalario = null;
					String dvcolab = null;
					String ocorrencias = null;
					String tpmovimento = null;
					String segmentod = null;
					String tpregsegd = null;
					String tpregsege = null;
					String nsrloted = null;
					String nsrlotee = null;
					String segmentoe = null;
					String movimento = null;
					String cxpostal = null;
					String filler1 = null;
					String filler2 = null;
					String filler5 = null;
					String filler9 = null;
					String filler10 = null;
					String filler15 = null;
					String filler20 = null;
					String filler100 = null;
						
					final FileWriter fileWriter = new FileWriter(file);
					
					Boolean setFileHeader = Boolean.TRUE;
					Boolean setBatchHeader = Boolean.TRUE;
					Boolean hasLines = Boolean.FALSE;
					
					Integer contador = 0;
					
					 while (resultado.next()) {
						 
						 hasLines = Boolean.TRUE;
						 
						 contador++;
						 
						 data = StringUtils.leftPad(resultado.getString("data"), 8, "0"); 
						 hora = HH_MM_SS_FORMAT.format(new Date()); 
						 codigobco = StringUtils.leftPad(resultado.getString("codigobco"), 3, "0");
						 inscricao = StringUtils.leftPad(resultado.getString("inscricao"), 1, "0");
						 cnpj = StringUtils.leftPad(resultado.getString("cnpj"), 14, "0");
						 convenio = StringUtils.rightPad(resultado.getString("convenio"), 20, " ");
						 agenciaempresa = StringUtils.leftPad(resultado.getString("agenciaemp"), 5, "0");
						 contaempresa = StringUtils.leftPad(resultado.getString("contaemp"), 12, "0"); //
						 dvempresa = StringUtils.leftPad(resultado.getString("dvemp"), 1, "0"); //
						 empresa = StringUtils.rightPad(resultado.getString("empresa"), 30, " "); //
						 banco = StringUtils.rightPad(resultado.getString("bancoemp"), 30, " "); //
						 remessa = StringUtils.leftPad(resultado.getString("remessa") == null ? "1" : resultado.getString("remessa"), 1, "0"); //
						 colaborador = StringUtils.rightPad(resultado.getString("nome"), 40, " ");
						 cpf = StringUtils.leftPad(resultado.getString("cpf"), 11, "0");
						 ufnasc = StringUtils.leftPad(resultado.getString("ufnasc"), 2, "0");
						 rg = StringUtils.rightPad(resultado.getString("rg"), 20, " ");
						 dn = StringUtils.leftPad(resultado.getString("dn"), 8, "0");
						 nsa = StringUtils.leftPad(nsa, 6, "0");
						 sexo = StringUtils.leftPad(resultado.getString("sexo"), 1, "0");
						 civil = StringUtils.leftPad(resultado.getString("civil"), 2, "0");
						 mae = StringUtils.rightPad(resultado.getString("mae"), 30, " ");
						 ruacolab = StringUtils.rightPad(resultado.getString("ruacolab"), 30, " ");
						 nresidcolab = StringUtils.leftPad(resultado.getString("nresidcolab"), 5, "0");
						 compresidcolab = StringUtils.leftPad(resultado.getString("compresidcolab") != null ? resultado.getString("compresidcolab") : "", 15, " ");
						 bairrocolab = StringUtils.rightPad(resultado.getString("bairrocolab"), 15, " ");
						 cidadecolab = StringUtils.rightPad(resultado.getString("cidadecolab"), 20, " ");
						 estadocolab = StringUtils.leftPad(resultado.getString("estadocolab"), 2, "0");
						 cepcolab = StringUtils.leftPad(resultado.getString("cepcolab"), 8, "0");
						 emailcolab = StringUtils.rightPad(resultado.getString("emailcolab"), 80, " ");
						 dddcolab = StringUtils.leftPad(resultado.getString("dddcolab"), 2, "0");
						 telefonecolab = StringUtils.leftPad(resultado.getString("telefonecolab"), 9, "0");
						 salario = StringUtils.leftPad(resultado.getString("salario"), 9, "0");
						 admissao = StringUtils.leftPad(resultado.getString("admissao"), 8, "0");
						 cargo = StringUtils.leftPad(resultado.getString("cargo"), 4, "0");
						 agenciacolab = StringUtils.leftPad(resultado.getString("agenciacolab") != null ? resultado.getString("agenciacolab") : "", 5, "0");
						 contasalario = StringUtils.leftPad(resultado.getString("contacolab") != null ? resultado.getString("contacolab") : "", 12, "0");
						 dvcolab = StringUtils.leftPad(resultado.getString("dvcolab") != null ? resultado.getString("dvcolab") : "", 1, "0");
						 ocorrencias = StringUtils.leftPad(resultado.getString("ocorrencias") != null ? resultado.getString("ocorrencias") : "", 10, " ");
						 tpmovimento = StringUtils.leftPad(resultado.getString("tpmovimento"), 1, "0");
						 
						 lotesvcheader = "0000";							
						 lotesvctrailer = "9999";							
						 lotesvcheaderlote = "0001";						
						 lotesvctrailerlote = "0001";						
						 lotesvcsegmentod = "0001";							
						 lotesvcsegmentoe = "0001";							
						 tpheaderreg = "0";									
						 tpheaderlote = "1";								
						 tptrailerlote = "5";								
						 tptrailer = "9";									
						 tpopelote = "C";									
						 tpservlote = "30";									
						 tplanclote = "99";									
						 tpregsegd = "3";									
						 tpregsege = "3";									
						 nsrloted = "00001";								
						 nsrlotee = "00001";								
						 versaolote = StringUtils.leftPad("45", 3, "0"); 	
						 segmentod = StringUtils.leftPad("D", 1, "0"); 		
						 segmentoe = StringUtils.leftPad("E", 1, "0"); 		
						 movimento = StringUtils.leftPad("0", 1, "0"); 		
						 cxpostal = StringUtils.leftPad("0", 9, "0"); 		
						 layout = StringUtils.leftPad("100", 3, "0"); 		
						 filler1 = StringUtils.leftPad(" ", 1, " "); 		
						 filler2 = StringUtils.leftPad(" ", 2, " "); 		
						 filler5 = StringUtils.leftPad(" ", 5, " "); 		
						 filler9 = StringUtils.leftPad(" ", 9, " "); 		
						 filler10 = StringUtils.leftPad(" ", 10, " "); 		
						 filler15 = StringUtils.leftPad(" ", 15, " "); 		
						 filler20 = StringUtils.leftPad(" ", 20, " "); 		
						 filler100 = StringUtils.leftPad(" ", 100, " "); 	
						 
						 if (setFileHeader) {
							 
							 setFileHeader = Boolean.FALSE;
							 
							 fileWriter.write(codigobco); 		
							 fileWriter.write(lotesvcheader); 	
							 fileWriter.write(tpheaderreg); 	
							 fileWriter.write(filler9); 		
							 fileWriter.write(inscricao); 		
							 fileWriter.write(cnpj);			
							 fileWriter.write(convenio);		
							 fileWriter.write(agenciaempresa);	
							 fileWriter.write(filler1); 		
							 fileWriter.write(contaempresa);	
							 fileWriter.write(dvempresa);		
							 fileWriter.write(filler1); 		
							 fileWriter.write(empresa);			
							 fileWriter.write(banco);			
							 fileWriter.write(filler10); 		
							 fileWriter.write(remessa);			
							 fileWriter.write(data);			
							 fileWriter.write(hora);			
							 fileWriter.write(nsa);				
							 fileWriter.write(layout);			
							 fileWriter.write(filler5); 		
							 //inserir String Uso Banco			com 20 digitos
							 //inserir String Uso empresa		com 20 digitos
							 fileWriter.write(filler20); 		
							 fileWriter.write(filler20); 		
							 fileWriter.write(filler15); 		
							 fileWriter.write(filler2); 		
							 fileWriter.write(filler2); 		
							 fileWriter.write(ocorrencias); 	
							 
							 fileWriter.write("\r\n");
						 }
						 
						 if (setBatchHeader) {
							setBatchHeader = Boolean.FALSE;
							 
							fileWriter.write(codigobco);		
							fileWriter.write(lotesvcheaderlote); 
							fileWriter.write(tpheaderlote); 	
							fileWriter.write(tpopelote);		
							fileWriter.write(tpservlote);		
							fileWriter.write(tplanclote);		
							fileWriter.write(versaolote);		
							fileWriter.write(filler1);			
							fileWriter.write(inscricao);		
							fileWriter.write(cnpj);				
							fileWriter.write(filler20);			
							fileWriter.write(filler20);			
							fileWriter.write(empresa);			
							fileWriter.write(filler100);		
							fileWriter.write(filler20);			
							fileWriter.write(filler5);			
							fileWriter.write(filler2);			
							fileWriter.write(filler1);			
							fileWriter.write(ocorrencias);		
							
							fileWriter.write("\r\n");
						 }
						 						 
			 			fileWriter.write(codigobco);		
			 			fileWriter.write(lotesvcsegmentod);	
			 			fileWriter.write(tpregsegd); 		
			 			fileWriter.write(nsrloted);			
			 			fileWriter.write(segmentod);		
			 			fileWriter.write(tpmovimento);		
			 			fileWriter.write(colaborador);		
			 			fileWriter.write(cpf);				
			 			fileWriter.write(ufnasc);			
			 			fileWriter.write(rg);				
			 			fileWriter.write(dn);				
			 			fileWriter.write(sexo);				
			 			fileWriter.write(civil);			
			 			fileWriter.write(filler5);			
			 			fileWriter.write(filler1);			
			 			fileWriter.write(mae);				
			 			fileWriter.write(ruacolab);			
			 			fileWriter.write(nresidcolab);		
			 			fileWriter.write(compresidcolab);	
			 			fileWriter.write(bairrocolab);		
			 			fileWriter.write(cidadecolab);		
			 			fileWriter.write(estadocolab);		
			 			fileWriter.write(cepcolab);			
			 			fileWriter.write(ocorrencias);		
			 
			 			fileWriter.write("\r\n");
			 
			 			fileWriter.write(codigobco);		
			 			fileWriter.write(lotesvcsegmentoe);	
			 			fileWriter.write(tpregsege); 		
			 			fileWriter.write(nsrlotee);			
			 			fileWriter.write(segmentoe);		
			 			fileWriter.write(filler1);			
			 			fileWriter.write(emailcolab);		
			 			fileWriter.write(filler20);			
			 			fileWriter.write(dddcolab);			
			 			fileWriter.write(telefonecolab);	
			 			fileWriter.write(filler10);			
			 			fileWriter.write(cxpostal);			
			 			fileWriter.write(salario);			
			 			fileWriter.write(filler10);			
			 			fileWriter.write(admissao);			
			 			fileWriter.write(filler20);			
			 			fileWriter.write(cargo);			
			 			fileWriter.write(filler15);			
			 			fileWriter.write(agenciacolab);		
			 			fileWriter.write(filler1);			
			 			fileWriter.write(contasalario);		
			 			fileWriter.write(dvcolab);			
			 			fileWriter.write(ocorrencias);		
			 
			 			fileWriter.write("\r\n");
					 }
					
					 if (hasLines) {
					
				 		fileWriter.write(codigobco);			
				 		fileWriter.write(lotesvctrailerlote);	 
				 		fileWriter.write(tptrailerlote); 		
				 		fileWriter.write(filler5);				
				 		fileWriter.write(filler2);				
				 		fileWriter.write(filler2);				
				 		fileWriter.write(StringUtils.leftPad(String.valueOf(contador), 6, "0"));			//linhas acima dele (conta com ele) exceto o header
				 		fileWriter.write(filler100);			
				 		fileWriter.write(filler100);			
				 		fileWriter.write(filler5);				
				 		fileWriter.write(filler2);				
				 		fileWriter.write(ocorrencias);			
				 		
				 		fileWriter.write("\r\n");
						 
					 	fileWriter.write(codigobco);		
					 	fileWriter.write(lotesvctrailer);	
					 	fileWriter.write(tptrailer);		
					 	fileWriter.write(filler5);			
					 	fileWriter.write(filler2);			
					 	fileWriter.write(filler2);			
					 	fileWriter.write(StringUtils.leftPad(String.valueOf(contador), 6, "0"));			//Trailer arquivo
					 	fileWriter.write(StringUtils.leftPad(String.valueOf(contador), 6, "0"));			//Trailer arquivo
					 	fileWriter.write(filler100);		
					 	fileWriter.write(filler100);		
					 	fileWriter.write(filler10);			
					 	fileWriter.write(filler1);			
					 	
					 	fileWriter.write("\r\n");
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
		
		btnEnviar.setFont(new Font("Calibri", Font.PLAIN, 16));
		btnEnviar.setBounds(325, 97, 300, 30);
		panelBanco.add(btnEnviar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnCancelar.setFont(new Font("Calibri", Font.PLAIN, 16));
		btnCancelar.setBounds(340, 678, 315, 30);
		frame.getContentPane().add(btnCancelar);
		
		JLabel lbcnab = new JLabel("Gera\u00E7\u00E3o do Arquivo CNAB 240 - Abertura de Conta");
		lbcnab.setBounds(20, 10, 643, 60);
		frame.getContentPane().add(lbcnab);
		lbcnab.setHorizontalAlignment(SwingConstants.CENTER);
		lbcnab.setFont(new Font("Calibri", Font.PLAIN, 25));
	}
}

