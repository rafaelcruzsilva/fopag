import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
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
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
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
		rdbtnDataatual.setFont(new Font("Calibri", Font.PLAIN, 16));
		rdbtnDataatual.setBounds(11, 52, 200, 30);
		rdbtnDataatual.setSelected(Boolean.TRUE);
		panelBanco.add(rdbtnDataatual);
		
		JLabel ldSelecaodata = new JLabel("Insira a data da solicita\u00E7ao da Conta Sal\u00E1rio");
		ldSelecaodata.setFont(new Font("Calibri", Font.BOLD, 16));
		ldSelecaodata.setBounds(15, 16, 412, 24);
		panelBanco.add(ldSelecaodata);
		
		JRadioButton rdbtnInserirdata = new JRadioButton("Inserir Data");
		rdbtnInserirdata.setBounds(230, 52, 200, 30);
		panelBanco.add(rdbtnInserirdata);
		
		txtData = new JFormattedTextField(dataMascara);
		txtData.setFont(new Font("Calibri", Font.PLAIN, 16));
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
						JOptionPane.showMessageDialog(null, "Diret�rio inv�lido", "Erro", JOptionPane.ERROR_MESSAGE);
						return;
					}
					
					if (!rdbtnDataatual.isSelected() && !FopagUtils.isDataValida(txtData.getText())) {
						JOptionPane.showMessageDialog(null, "Data inválida", "Erro", JOptionPane.ERROR_MESSAGE);
						return;
					}
					
					//String teste = String.format("Ol� %s. Sua conta � %s, seu saldo � %s", "Iago", conta, saldo);					
					//"Ol� Iago. Sua conta � 123, seu saldo � 500";
					
					final String nomeArquivo = String.format("TCSYS_REMESSAAGENDAMENTO_%s%s%s.txt", DATE_FORMAT_US.format(new Date()), "3224", "1");
					
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
					String tpheaderarq = null;
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
					String nsa = null;
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
					String segmentoe = null;
					String movimento = null;
					String cxpostal = null;
					String filler1 = null;
					String filler2 = null;
					String filler5 = null;
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
						 convenio = StringUtils.leftPad(resultado.getString("convenio"), 20, "0");
						 agenciaempresa = StringUtils.leftPad(resultado.getString("agenciaemp"), 5, "0");
						 contaempresa = StringUtils.leftPad(resultado.getString("contaemp"), 12, "0");
						 dvempresa = StringUtils.leftPad(resultado.getString("dvemp"), 1, "0");
						 empresa = StringUtils.leftPad(resultado.getString("empresa"), 30, "0");
						 banco = StringUtils.leftPad(resultado.getString("bancoemp"), 30, "0");
						 remessa = StringUtils.leftPad(resultado.getString("remessa") == null ? "1" : resultado.getString("remessa"), 1, "0");
						 nsa = StringUtils.leftPad(resultado.getString("nsa") == null ? "1" : resultado.getString("nsa"), 6, "0");
						 colaborador = StringUtils.leftPad(resultado.getString("nome"), 40, "0");
						 cpf = StringUtils.leftPad(resultado.getString("cpf"), 11, "0");
						 ufnasc = StringUtils.leftPad(resultado.getString("ufnasc"), 2, "0");
						 rg = StringUtils.leftPad(resultado.getString("rg"), 20, "0");
						 dn = StringUtils.leftPad(resultado.getString("dn"), 8, "0");
						 sexo = StringUtils.leftPad(resultado.getString("sexo"), 1, "0");
						 civil = StringUtils.leftPad(resultado.getString("civil"), 2, "0");
						 mae = StringUtils.leftPad(resultado.getString("mae"), 30, "0");
						 ruacolab = StringUtils.leftPad(resultado.getString("ruacolab"), 30, "0");
						 nresidcolab = StringUtils.leftPad(resultado.getString("nresidcolab"), 5, "0");
						 compresidcolab = StringUtils.leftPad(resultado.getString("compresidcolab"), 15, "0");
						 bairrocolab = StringUtils.leftPad(resultado.getString("bairrocolab"), 15, "0");
						 cidadecolab = StringUtils.leftPad(resultado.getString("cidadecolab"), 20, "0");
						 estadocolab = StringUtils.leftPad(resultado.getString("estadocolab"), 2, "0");
						 cepcolab = StringUtils.leftPad(resultado.getString("cepcolab"), 8, "0");
						 emailcolab = StringUtils.leftPad(resultado.getString("emailcolab"), 80, "0");
						 dddcolab = StringUtils.leftPad(resultado.getString("dddcolab"), 2, "0");
						 telefonecolab = StringUtils.leftPad(resultado.getString("telefonecolab"), 9, "0");
						 salario = StringUtils.leftPad(resultado.getString("salario"), 9, "0");
						 admissao = StringUtils.leftPad(resultado.getString("admissao"), 8, "0");
						 cargo = StringUtils.leftPad(resultado.getString("cargo"), 4, "0");
						 agenciacolab = StringUtils.leftPad(resultado.getString("agenciacolab"), 5, "0");
						 contasalario = StringUtils.leftPad(resultado.getString("contacolab"), 12, "0");
						 dvcolab = StringUtils.leftPad(resultado.getString("dvcolab"), 1, "0");
						 ocorrencias = StringUtils.leftPad(resultado.getString("ocorrencias"), 10, "0");
						 tpmovimento = StringUtils.leftPad(resultado.getString("tpmovimento"), 1, "0");
						 
						 lotesvcheader = "0000";							//valor fixo
						 lotesvctrailer = "9999";							//valor fixo
						 lotesvcheaderlote = "0000";						//valor fixo
						 lotesvctrailerlote = "0000";						//valor fixo
						 lotesvcsegmentod = "0001";							//valor fixo
						 lotesvcsegmentoe = "0000";							//valor fixo
						 tpheaderarq = "0";									//valor fixo
						 tpheaderlote = "1";								//valor fixo
						 tptrailerlote = "5";								//valor fixo
						 tptrailer = "9";									//valor fixo
						 tpopelote = "C";									//valor fixo
						 tpservlote = "30";									//valor fixo
						 tplanclote = "99";									//valor fixo
						 tpregsegd = "3";									//valor fixo
						 tpregsege = "3";									//valor fixo
						 nsrloted = "00001";								//verificar as variacoes
						 versaolote = StringUtils.leftPad("45", 3, "0"); 	//valor fixo
						 segmentod = StringUtils.leftPad("D", 1, "0"); 		//valor fixo
						 segmentoe = StringUtils.leftPad("E", 1, "0"); 		//valor fixo
						 movimento = StringUtils.leftPad("0", 1, "0"); 		//valor fixo
						 cxpostal = StringUtils.leftPad("0", 9, "0"); 		//valor fixo
						 layout = StringUtils.leftPad("100", 3, "0"); 		//valor fixo
						 filler1 = StringUtils.leftPad("0", 1, " "); 		//valor fixo
						 filler2 = StringUtils.leftPad("0", 2, " "); 		//valor fixo
						 filler5 = StringUtils.leftPad("0", 5, " "); 		//valor fixo
						 filler10 = StringUtils.leftPad("0", 10, " "); 		//valor fixo
						 filler15 = StringUtils.leftPad("0", 15, " "); 		//valor fixo
						 filler20 = StringUtils.leftPad("0", 20, " "); 		//valor fixo
						 filler100 = StringUtils.leftPad("0", 100, " "); 		//valor fixo
						 
						 
						 if (setFileHeader) {
							 
							 setFileHeader = Boolean.FALSE;
							 
							 fileWriter.write(codigobco); 		//Header do arquivo//
							 fileWriter.write(lotesvcheader); 	//Header do arquivo//
							 fileWriter.write(tpheaderarq); 	//Header do arquivo//
							 fileWriter.write(filler5); 		//Header do arquivo//
							 fileWriter.write(filler2); 		//Header do arquivo//
							 fileWriter.write(filler2); 		//Header do arquivo//
							 fileWriter.write(inscricao); 		//Header do arquivo//
							 fileWriter.write(cnpj);			//Header do arquivo//
							 fileWriter.write(convenio);		//Header do arquivo//
							 fileWriter.write(agenciaempresa);	//Header do arquivo//
							 fileWriter.write(filler1); 		//Header do arquivo//
							 fileWriter.write(contaempresa);	//Header do arquivo//
							 fileWriter.write(dvempresa);		//Header do arquivo//
							 fileWriter.write(filler1); 		//Header do arquivo//
							 fileWriter.write(empresa);			//Header do arquivo//
							 fileWriter.write(banco);			//Header do arquivo//
							 fileWriter.write(filler10); 		//Header do arquivo//
							 fileWriter.write(remessa);			//Header do arquivo//
							 fileWriter.write(data);			//Header do arquivo//
							 fileWriter.write(hora);			//Header do arquivo//
							 fileWriter.write(nsa);				//Header do arquivo//
							 fileWriter.write(layout);			//Header do arquivo//
							 fileWriter.write(filler5); 		//Header do arquivo//
							 //inserir String Uso Banco			com 20 digitos
							 //inserir String Uso empresa		com 20 digitos
							 fileWriter.write(filler20); 		//Header do arquivo Reservado Banco - enviar campos em branco//
							 fileWriter.write(filler20); 		//Header do arquivo Reservado Empresa - enviar campos em banco//
							 fileWriter.write(filler20); 		//Header do arquivo//
							 fileWriter.write(filler5); 		//Header do arquivo//
							 fileWriter.write(filler2); 		//Header do arquivo//
							 fileWriter.write(filler2); 		//Header do arquivo//
							 fileWriter.write(ocorrencias); 	//Header do arquivo//
							 
							 fileWriter.write("\r\n");
						 }
						 
						 if (setBatchHeader) {
							setBatchHeader = Boolean.FALSE;
							 
							fileWriter.write(codigobco);		//Header de lote//
							fileWriter.write(lotesvcheaderlote);//Header de lote// 
							fileWriter.write(tpheaderlote); 	//Header de lote//
							fileWriter.write(tpopelote);		//Header de lote//
							fileWriter.write(tpservlote);		//Header de lote//
							fileWriter.write(tplanclote);		//Header de lote//
							fileWriter.write(versaolote);		//Header de lote//
							fileWriter.write(filler1);			//Header de lote//
							fileWriter.write(inscricao);		//Header de lote//
							fileWriter.write(cnpj);				//Header de lote//
							fileWriter.write(filler20);			//Header de lote//
							fileWriter.write(filler20);			//Header de lote//
							fileWriter.write(empresa);			//Header de lote//
							fileWriter.write(filler100);		//Header de lote//
							fileWriter.write(filler20);			//Header de lote//
							fileWriter.write(filler5);			//Header de lote//
							fileWriter.write(filler2);			//Header de lote//
							fileWriter.write(filler1);			//Header de lote//
							fileWriter.write(ocorrencias);		//Header de lote//
							
							
							fileWriter.write("\r\n");
						 }
						 						 
			 			fileWriter.write(codigobco);		//Segmento D//
			 			fileWriter.write(lotesvcsegmentod);	//Segmento D//
			 			fileWriter.write(tpregsegd); 		//Segmento D// Ajustar
			 			fileWriter.write(nsrloted);			//Segmento D//
			 			fileWriter.write(segmentod);		//Segmento D//
			 			fileWriter.write(tpmovimento);		//Segmento D//
			 			fileWriter.write(colaborador);		//Segmento D//
			 			fileWriter.write(cpf);				//Segmento D//
			 			fileWriter.write(ufnasc);			//Segmento D//
			 			fileWriter.write(rg);				//Segmento D//
			 			fileWriter.write(dn);				//Segmento D//
			 			fileWriter.write(sexo);				//Segmento D//
			 			fileWriter.write(civil);			//Segmento D//
			 			fileWriter.write(filler5);			//Segmento D//
			 			fileWriter.write(filler1);			//Segmento D//
			 			fileWriter.write(mae);				//Segmento D//
			 			fileWriter.write(ruacolab);			//Segmento D//
			 			fileWriter.write(nresidcolab);		//Segmento D//
			 			fileWriter.write(compresidcolab);	//Segmento D//
			 			fileWriter.write(bairrocolab);		//Segmento D//
			 			fileWriter.write(cidadecolab);		//Segmento D//
			 			fileWriter.write(estadocolab);		//Segmento D//
			 			fileWriter.write(cepcolab);			//Segmento D//
			 			fileWriter.write(ocorrencias);		//Segmento D//
			 
			 			fileWriter.write("\r\n");
			 
			 			fileWriter.write(codigobco);		//Segmento E//
			 			fileWriter.write(lotesvcsegmentoe);	//Segmento E//
			 			fileWriter.write(tpregsege); 		//Segmento E// Ajustar
			 			fileWriter.write(nsa);				//Segmento E//
			 			fileWriter.write(segmentoe);		//Segmento E//
			 			fileWriter.write(filler1);			//Segmento E//
			 			fileWriter.write(emailcolab);		//Segmento E//
			 			fileWriter.write(filler20);			//Segmento E//
			 			fileWriter.write(dddcolab);			//Segmento E//
			 			fileWriter.write(telefonecolab);	//Segmento E//
			 			fileWriter.write(filler10);			//Segmento E//
			 			fileWriter.write(cxpostal);			//Segmento E//
			 			fileWriter.write(salario);			//Segmento E//
			 			fileWriter.write(filler10);			//Segmento E//
			 			fileWriter.write(admissao);			//Segmento E//
			 			fileWriter.write(filler20);			//Segmento E//
			 			fileWriter.write(cargo);			//Segmento E//
			 			fileWriter.write(filler15);			//Segmento E//
			 			fileWriter.write(agenciacolab);		//Segmento E//
			 			fileWriter.write(filler1);			//Segmento E//
			 			fileWriter.write(contasalario);		//Segmento E//
			 			fileWriter.write(dvcolab);			//Segmento E//
			 			fileWriter.write(ocorrencias);		//Segmento E//
			 
			 			fileWriter.write("\r\n");
					 }
					 
					
					 if (hasLines) {
					
				 		fileWriter.write(codigobco);			//Trailer lote
				 		fileWriter.write(lotesvctrailerlote);	//Trailer lote 
				 		fileWriter.write(tptrailerlote); 		//Trailer lote
				 		fileWriter.write(filler5);				//Trailer lote
				 		fileWriter.write(filler2);				//Trailer lote
				 		fileWriter.write(filler2);				//Trailer lote
				 		fileWriter.write(StringUtils.leftPad(String.valueOf(contador), 6, "0"));			//Trailer lote
				 		fileWriter.write(filler100);			//Trailer lote
				 		fileWriter.write(filler100);			//Trailer lote
				 		fileWriter.write(filler5);				//Trailer lote
				 		fileWriter.write(filler2);				//Trailer lote
				 		fileWriter.write(ocorrencias);			//Trailer lote
				 		
				 		fileWriter.write("\r\n");
						 
				 		
					 	fileWriter.write(codigobco);		//Trailer arquivo
					 	fileWriter.write(lotesvctrailer);	//Trailer arquivo
					 	fileWriter.write(tptrailer);		//Trailer arquivo
					 	fileWriter.write(filler5);			//Trailer arquivo
					 	fileWriter.write(filler2);			//Trailer arquivo
					 	fileWriter.write(filler2);			//Trailer arquivo
					 	fileWriter.write(StringUtils.leftPad(String.valueOf(contador), 6, "0"));			//Trailer arquivo
					 	fileWriter.write(StringUtils.leftPad(String.valueOf(contador), 6, "0"));			//Trailer arquivo
					 	fileWriter.write(filler100);		//Trailer arquivo
					 	fileWriter.write(filler100);		//Trailer arquivo
					 	fileWriter.write(filler10);			//Trailer arquivo
					 	fileWriter.write(filler1);			//Trailer arquivo
					 	
					 	fileWriter.write("\r\n");
					 }
					 
					fileWriter.close();
			    }
			    catch (Exception ex) {
				    ex.printStackTrace();
				    JOptionPane.showMessageDialog(null, "Erro ao gerar arquivo", "Erro", JOptionPane.ERROR_MESSAGE);
				    return;
				}

				JOptionPane.showMessageDialog(null, "Processamento conclu�do!", "Sucesso", JOptionPane.DEFAULT_OPTION);
				
			}
		});
		
		btnEnviar.setFont(new Font("Calibri", Font.PLAIN, 16));
		btnEnviar.setBounds(505, 99, 115, 29);
		panelBanco.add(btnEnviar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Calibri", Font.PLAIN, 16));
		btnCancelar.setBounds(529, 751, 120, 30);
		frame.getContentPane().add(btnCancelar);
	}
}

