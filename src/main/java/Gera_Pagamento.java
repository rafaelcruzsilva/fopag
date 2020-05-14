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

public class Gera_Pagamento {
	
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
					Gera_Pagamento window = new Gera_Pagamento();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Gera_Pagamento() {
		initialize();
	}

	private void initialize() {
		
//		MaskFormatter dataMascara = null;
//		
//		try {
//			dataMascara = new MaskFormatter("##/##/####");
//		} catch (ParseException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
		
		frame = new JFrame();
		frame.setTitle("Abertura de conta sal\u00E1rio");
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
				// INICIO DO CLICK DO BOTÂO
				
				
				// IMPLEMENTAR INSERT NA TABELA NSA
				
				
				
						//try {
				
			            //String query = "INSERT INTO `fopagdb`.`nsatb`\n" +  // Aqui inicia a Query de cadastro
			            //"data)\n" +
			            //"VALUES\n" +
			            //"('now()')";
			            
			            //Fopag.connection.insertData(query);
						//JOptionPane.showMessageDialog(btnEnviar, "Opa... Tudo certo ate aqui!!!.");
						//}
						//catch (SQLException ex)
						//{
						//JOptionPane.showMessageDialog(btnEnviar, "Hum... algo deu errado!!!");
		            	//ex.printStackTrace();
						//}
					
						//comboTpregistro.getSelectedItem();
				
				// SELECT * FROM nsatb WHERE id = MAX(id)
				
				
				try {
					
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
					
					final String nomeArquivo = String.format("TCSYS_REMESSAPAGAMENTO_%s%s%s.txt", DATE_FORMAT_US.format(new Date()), "3224", "1");
					
					final File file = new File(fileChooser.getSelectedFile(), nomeArquivo);
					
					final String dataConsulta = rdbtnDataatual.isSelected() ? DATE_FORMAT_BR.format(new Date()) : FopagUtils.getSomenteDigitos(txtData.getText());
					
					System.out.println("Chamando consulta");
					
					String query = String.format("SELECT * FROM fopagdb.pagamentostb WHERE data LIKE '%s'", dataConsulta);
					
					System.out.println(query);
					
					ResultSet resultado = Fopag.connection.getData(query);
					
					// Strings variáveis
					
					String cnpj = null;
					String empresa = null;
					String convenio = null;
					String tpinscricao = null;
					String ruaemp = null;
					String nresidemp = null;
					String compresidemp = null;
					String cidadeemp = null;
					String cepemp = null;
					String estadoemp = null;
					String codigobcoemp = null;
					String agenciaemp = null;
					String contaemp = null;
					String dvemp = null;
					String bancoemp = null;
					String tpremessa = null;
					String tpservico = null;
					String tpmovimento = null;
					String tpidentificacao = null;
					String cpf = null;
					String colaborador = null;
					String ruacolab = null;
					String nresidcolab = null;
					String compresidcolab = null;
					String cidadecolab = null;
					String cepcolab = null;
					String estadocolab = null;
					String codigobcocolab = null;
					String agenciacolab = null;
					String contacolab = null;
					String dvcolab = null;
					String bancocolab = null;
					String valor = null;
					String datapagto = null;
					String tplancamento = null;
					String data = null;
					String hora = null;
					String nsa = null;
					String ocorrencias = null;
					
					// Strings fixas
					
					String lotesvcheader = null;
					String lotesvctrailerarquivo = null;
					String tprgheader = null;
					String layout = null;
					String lotesvcheaderlote = null;
					String tprgheaderlote = null;
					String tpopeheaderlote = null;
					String versaoheaderlote = null;
					String lotesvcsegmentoa = null;
					String lotesvcsegmentob = null;
					String tpregsegmentoa = null;
					String tpregsegmentob = null;
					String nrseqregistrolotea = null;
					String nrseqregistroloteb = null;
					String segmentoa = null;
					String segmentob = null;
					String moeda = null;
					String tpinscricaoFavorecido = null;
					String finalidadeted = null;
					String lotesvctrailerlote = null;
					String tprgtrailerlote = null;
					String tprgtrailer = null;
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
						 
						 // Campos variáveis
						 
						 codigobcoemp = StringUtils.leftPad(resultado.getString("codigobcoemp"), 3, "0");
						 tpinscricao = StringUtils.leftPad(resultado.getString("tpinscricao"), 1, " ");
						 cnpj = StringUtils.leftPad(resultado.getString("cnpj"), 14, "0");
						 convenio = StringUtils.rightPad(resultado.getString("convenio"), 20, " "); 
						 agenciaemp = StringUtils.leftPad(resultado.getString("agenciaemp"), 5, "0");
						 contaemp = StringUtils.leftPad(resultado.getString("contaemp"), 12, "0");
						 dvemp = StringUtils.leftPad(resultado.getString("dvemp"), 1, "0");
						 empresa = StringUtils.rightPad(resultado.getString("empresa"), 30, " ");
						 bancoemp = StringUtils.rightPad(resultado.getString("bancoemp"), 30, " ");
						 tpremessa = StringUtils.rightPad(resultado.getString("tpremessa"), 1, " ");
						 //nsa = StringUtils.leftPad(resultado.getString("nsa") == null ? "1" : resultado.getString("nsa"), 6, "0");
						 ocorrencias = StringUtils.leftPad(resultado.getString("ocorrencias"), 10, " ");
						 tpservico = StringUtils.leftPad(resultado.getString("tpservico"), 2, " ");
						 tplancamento = StringUtils.leftPad(resultado.getString("tplancamento"), 1, "0");
						 tpidentificacao = StringUtils.rightPad(resultado.getString("tpidentificacao"), 20, " ");
						 ruacolab = StringUtils.rightPad(resultado.getString("ruacolab"), 30, " ");
						 nresidcolab = StringUtils.leftPad(resultado.getString("nresidcolab"), 5, "0");
						 compresidcolab = StringUtils.rightPad(resultado.getString("compresidcolab"), 15, " ");
						 cidadecolab = StringUtils.rightPad(resultado.getString("cidadecolab"), 20, " ");
						 cepcolab = StringUtils.leftPad(resultado.getString("cepcolab"), 8, "0");
						 estadocolab = StringUtils.leftPad(resultado.getString("estadocolab"), 2, "0");
						 codigobcocolab = StringUtils.leftPad(resultado.getString("codigobcocolab"), 3, " ");
						 agenciacolab = StringUtils.leftPad(resultado.getString("agenciacolab"), 5, "0");
						 contacolab = StringUtils.leftPad(resultado.getString("contacolab"), 12, "0");
						 dvcolab = StringUtils.leftPad(resultado.getString("dvcolab"), 1, "0");
						 colaborador = StringUtils.rightPad(resultado.getString("colaborador"), 40, " ");
						 datapagto = StringUtils.leftPad(resultado.getString("datapagto"), 8, "0");
						 valor = StringUtils.leftPad(resultado.getString("valor"), 15, "0");
						 cpf = StringUtils.leftPad(resultado.getString("cpf"), 14, "0");
						 
						 // Campos fixos
						 
						 lotesvcheader = "0000";
						 tprgheader = "0";
						 tprgtrailer = "9";
						 layout = StringUtils.leftPad("100", 3, "0");
						 lotesvcheaderlote = "0001";
						 lotesvctrailerlote = "0000";
						 lotesvctrailerarquivo = "9999";
						 tprgheaderlote = "1";
						 tprgtrailerlote= "5";
						 tpopeheaderlote = "C";
						 versaoheaderlote = StringUtils.leftPad("45", 3, "0");
						 lotesvcsegmentoa = "0001";
						 lotesvcsegmentob = "0001";
						 tpregsegmentoa = "3";
						 tpregsegmentob = "3";
						 nrseqregistrolotea = "00001";
						 nrseqregistroloteb = "00001";
						 segmentoa = StringUtils.leftPad("A", 1, "0");
						 segmentob = StringUtils.leftPad("B", 1, "0");
						 moeda = "BRL";
						 tpinscricaoFavorecido = "1";
						 finalidadeted = "00010";
						 nsa = "000001";
						 filler1 = StringUtils.leftPad(" ", 1, " "); 		
						 filler2 = StringUtils.leftPad(" ", 2, " "); 		
						 filler5 = StringUtils.leftPad(" ", 5, " "); 		
						 filler9 = StringUtils.leftPad(" ", 9, " "); 		
						 filler10 = StringUtils.leftPad(" ", 10, " "); 		
						 filler15 = StringUtils.leftPad(" ", 15, " "); 		
						 filler20 = StringUtils.leftPad(" ", 20, " "); 		
						 filler100 = StringUtils.leftPad(" ", 100, " ");
						 data = StringUtils.leftPad(resultado.getString("data"), 8, "0");
						 hora = HH_MM_SS_FORMAT.format(new Date());
						 
						 if (setFileHeader) {
							 
							 setFileHeader = Boolean.FALSE;
							 
							 //Header do arquivo
							 
							 fileWriter.write(codigobcoemp); 		
							 fileWriter.write(lotesvcheader); 	
							 fileWriter.write(tprgheader); 	
							 fileWriter.write(filler9); 		
							 fileWriter.write(tpinscricao); 		
							 fileWriter.write(cnpj);			
							 fileWriter.write(convenio);		
							 fileWriter.write(agenciaemp);	
							 fileWriter.write(filler1); 		
							 fileWriter.write(contaemp);	
							 fileWriter.write(dvemp);		
							 fileWriter.write(filler1); 		
							 fileWriter.write(empresa);			
							 fileWriter.write(bancoemp);			
							 fileWriter.write(filler10); 		
							 fileWriter.write(tpremessa);			
							 fileWriter.write(data);			
							 fileWriter.write(hora);			
							 fileWriter.write(nsa);				
							 fileWriter.write(layout);			
							 fileWriter.write(filler5); 		
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
							
							//Header do lote
							 
							fileWriter.write(codigobcoemp);		
							fileWriter.write(lotesvcheaderlote); 
							fileWriter.write(tprgheaderlote); 	
							fileWriter.write(tpopeheaderlote);
							fileWriter.write(tpservico);
							fileWriter.write(tplancamento);
							fileWriter.write(versaoheaderlote);
							fileWriter.write(filler1);
							fileWriter.write(tpinscricao);
							fileWriter.write(cnpj);
							fileWriter.write(tpidentificacao);
							fileWriter.write(agenciaemp);
							fileWriter.write(filler1);
							fileWriter.write(contaemp);
							fileWriter.write(dvemp);
							fileWriter.write(filler1);
							fileWriter.write(empresa);
							fileWriter.write(filler20);
							fileWriter.write(filler20);
							fileWriter.write(ruacolab);
							fileWriter.write(nresidcolab);
							fileWriter.write(compresidcolab);
							fileWriter.write(cidadecolab);
							fileWriter.write(cepcolab);
							fileWriter.write(estadocolab);
							fileWriter.write(filler5);
							fileWriter.write(filler2);
							fileWriter.write(filler1);
							fileWriter.write(ocorrencias);
							
							fileWriter.write("\r\n");
						 }
						 
						 //Segmento A
						 						 
			 			fileWriter.write(codigobcoemp);
			 			fileWriter.write(lotesvcsegmentoa);
			 			fileWriter.write(tpregsegmentoa);
			 			fileWriter.write(nrseqregistrolotea);
			 			fileWriter.write(segmentoa);
			 			fileWriter.write(tpmovimento);
			 			fileWriter.write(filler5);
			 			fileWriter.write(codigobcocolab );
			 			fileWriter.write(agenciacolab);
			 			fileWriter.write(filler1);
			 			fileWriter.write(contacolab);
			 			fileWriter.write(dvcolab);
			 			fileWriter.write(filler1);
			 			fileWriter.write(colaborador);
			 			fileWriter.write(filler20);
			 			fileWriter.write(datapagto);
			 			fileWriter.write(moeda);
			 			fileWriter.write(filler15);
			 			fileWriter.write(valor);
			 			fileWriter.write(filler20);
			 			fileWriter.write(datapagto);
			 			fileWriter.write(valor);
			 			fileWriter.write(filler20);
			 			fileWriter.write(filler5);
			 			fileWriter.write(filler1);
			 			fileWriter.write(cpf);
			 			fileWriter.write(tpinscricaoFavorecido);
			 			fileWriter.write(filler1);
			 			fileWriter.write(finalidadeted);
			 			fileWriter.write(filler5);
			 			fileWriter.write(filler1);
			 			fileWriter.write(ocorrencias);
			 
			 			fileWriter.write("\r\n");
			 			
			 			//Segmento B
			 
			 			fileWriter.write(codigobcoemp);
			 			fileWriter.write(lotesvcsegmentob);
			 			fileWriter.write(tpregsegmentob);
			 			fileWriter.write(nrseqregistroloteb);
			 			fileWriter.write(segmentob);
			 			fileWriter.write(filler2);
			 			fileWriter.write(filler1);
			 			fileWriter.write(tpinscricaoFavorecido);
			 			fileWriter.write(cpf);
			 			fileWriter.write(ruacolab);
			 			fileWriter.write(nresidcolab);
			 			fileWriter.write(compresidcolab);
			 			fileWriter.write(filler15);  // Bairro Colaborador
			 			fileWriter.write(cidadecolab);
			 			fileWriter.write(cepcolab);
			 			fileWriter.write(estadocolab);
			 			fileWriter.write(filler100);
			 			fileWriter.write(filler2);
			 			fileWriter.write(filler1);
			 			fileWriter.write(ocorrencias);
			 			fileWriter.write(lotesvcheaderlote);
			 			fileWriter.write(tpregsegmentob);
			 			fileWriter.write(filler5);
			 			fileWriter.write(filler2);
			 			fileWriter.write(filler2);
			 			fileWriter.write(StringUtils.leftPad(String.valueOf(contador), 6, "0"));
			 			fileWriter.write(filler10); // será substituido pela soma dos valores
			 			fileWriter.write(filler5); // será substituido pela soma dos valores
			 			fileWriter.write(filler2); // será substituido pela soma dos valores
			 			fileWriter.write(filler1); // será substituido pela soma dos valores
			 			fileWriter.write(filler5); 
			 			fileWriter.write(filler2); 
			 			fileWriter.write(filler1); 
			 			fileWriter.write(filler5); //será substituido pelo aviso de débito
			 			fileWriter.write(filler1); //será substituido pelo aviso de débito
			 			fileWriter.write(filler100);
			 			fileWriter.write(filler20);
			 			fileWriter.write(filler20);
			 			fileWriter.write(filler20);
			 			fileWriter.write(filler5);
			 			fileWriter.write(ocorrencias);
			 
			 			fileWriter.write("\r\n");
					 }
					
					 if (hasLines) {
						 
						// Trailer do lote
					
				 		fileWriter.write(codigobcoemp);			
				 		fileWriter.write(lotesvctrailerlote);	 
				 		fileWriter.write(tprgtrailerlote); 	
				 		fileWriter.write(filler5);				
				 		fileWriter.write(filler2);				
				 		fileWriter.write(filler2);				
				 		fileWriter.write(StringUtils.leftPad(String.valueOf(contador), 6, "0"));			//linhas acima dele (conta com ele) exceto o header
				 		fileWriter.write(filler10); // será substituido pela soma dos valores
			 			fileWriter.write(filler5); // será substituido pela soma dos valores
			 			fileWriter.write(filler2); // será substituido pela soma dos valores
			 			fileWriter.write(filler1); // será substituido pela soma dos valores
			 			fileWriter.write(filler10); 
			 			fileWriter.write(filler5); 
			 			fileWriter.write(filler2); 
			 			fileWriter.write(filler1); 
			 			fileWriter.write(filler5); 
			 			fileWriter.write(filler1); 
				 		fileWriter.write(filler100);			
				 		fileWriter.write(filler20);			
				 		fileWriter.write(filler20);				
				 		fileWriter.write(filler20);
				 		fileWriter.write(filler5);
				 		fileWriter.write(ocorrencias);			
				 		
				 		fileWriter.write("\r\n");
						 
				 		//Trailer do arquivo
				 		
					 	fileWriter.write(codigobcoemp);		
					 	fileWriter.write(lotesvctrailerarquivo);	
					 	fileWriter.write(tprgtrailer);		
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
		btnCancelar.setFont(new Font("Calibri", Font.PLAIN, 16));
		btnCancelar.setBounds(340, 678, 315, 30);
		frame.getContentPane().add(btnCancelar);
		
		JLabel lbcnab = new JLabel("Gera\u00E7\u00E3o do Arquivo CNAB 240 - Agendamento de pagamento");
		lbcnab.setBounds(20, 10, 643, 60);
		frame.getContentPane().add(lbcnab);
		lbcnab.setHorizontalAlignment(SwingConstants.CENTER);
		lbcnab.setFont(new Font("Calibri", Font.PLAIN, 25));
	}
}
