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
		rdbtnDataatual.setSelected(Boolean.TRUE);
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
					
					final String nomeArquivo = String.format("TCYS_REMESSAAGENDAMENTO_%s_%s.txt", DATE_FORMAT_US.format(new Date()));
					
					final File file = new File(fileChooser.getSelectedFile(), nomeArquivo);
					
					final String dataConsulta = rdbtnDataatual.isSelected() ? DATE_FORMAT_BR.format(new Date()) : txtData.getText();
					
					System.out.println("Chamando consulta");
					
					String query = String.format("SELECT * FROM fopagdb.contastb WHERE data LIKE '%s'", dataConsulta);
					
					System.out.println(query);
					
					ResultSet resultado = Fopag.connection.getData(query);
					
					String data;
					String codigobco;
					String lotesvcheader;
					String lotesvcsegmentod;
					String lotesvcsegmentoe;
					String tiporegistro;
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
					String layout;
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
					String segmentod;
					String segmentoe;
					String movimento;
					String cxpostal;
					String filler1;
					String filler2;
					String filler5;
					String filler10;
					String filler15;
					String filler20;
						
					final FileWriter fileWriter = new FileWriter(file);
					
					Boolean setHeader = Boolean.TRUE;
					
					 while (resultado.next()) {
						 
						 data = StringUtils.leftPad(resultado.getString("data"), 8, "0");
						 codigobco = StringUtils.leftPad(resultado.getString("codigobco"), 3, "0");
						 lotesvcheader = "0000";
						 lotesvcsegmentod = "0001";
						 lotesvcsegmentoe = "0000";
						 tiporegistro = "0";
						 inscricao = StringUtils.leftPad(resultado.getString("inscricao"), 1, "0");
						 cnpj = StringUtils.leftPad(resultado.getString("cnpj"), 14, "0");
						 convenio = StringUtils.leftPad(resultado.getString("convenio"), 20, "0");
						 agenciaempresa = StringUtils.leftPad(resultado.getString("agenciaemp"), 5, "0");
						 contaempresa = StringUtils.leftPad(resultado.getString("contaemp"), 9, "0");
						 dvempresa = StringUtils.leftPad(resultado.getString("dvemp"), 1, "0");
						 empresa = StringUtils.leftPad(resultado.getString("empresa"), 30, "0");
						 banco = StringUtils.leftPad(resultado.getString("bancoemp"), 30, "0");
						 remessa = StringUtils.leftPad(resultado.getString("remessa") == null ? "1" : resultado.getString("remessa"), 1, "0");
						 nsa = StringUtils.leftPad(resultado.getString("nsa") == null ? "1" : resultado.getString("nsa"), 6, "0");
						 layout = StringUtils.leftPad("100", 3, "0"); //valor fixo
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
						 contasalario = StringUtils.leftPad(resultado.getString("contacolab"), 9, "0");
						 dvcolab = StringUtils.leftPad(resultado.getString("dvcolab"), 1, "0");
						 ocorrencias = StringUtils.leftPad(resultado.getString("ocorrencias"), 10, "0");
						 
						 /*
						 segmentod = StringUtils.leftPad(resultado.getString("segmentod") == null ? "D" : resultado.getString("segmentod"), 1, "0"); //valor fixo
						 segmentoe = StringUtils.leftPad(resultado.getString("segmentoe") == null ? "E" : resultado.getString("segmentoe"), 1, "0"); //valor fixo
						 movimento = StringUtils.leftPad(resultado.getString("movimento") == null ? "0" : resultado.getString("movimento"), 1, "0"); //valor fixo
						 cxpostal = StringUtils.leftPad(resultado.getString("cxpostal") == null ? "0" : resultado.getString("cxpostal"), 9, "0"); //valor fixo
						 filler1 = StringUtils.leftPad(resultado.getString("filler1") == null ? "0" : resultado.getString("filler1"), 1, "0"); //valor fixo
						 filler2 = StringUtils.leftPad(resultado.getString("filler2") == null ? "0" : resultado.getString("filler2"), 2, "0"); //valor fixo
						 filler5 = StringUtils.leftPad(resultado.getString("filler5") == null ? "0" : resultado.getString("filler5"), 5, "0"); //valor fixo
						 filler10 = StringUtils.leftPad(resultado.getString("filler10") == null ? "0" : resultado.getString("filler10"), 10, "0"); //valor fixo
						 filler15 = StringUtils.leftPad(resultado.getString("filler15") == null ? "0" : resultado.getString("filler15"), 15, "0"); //valor fixo
						 filler20 = StringUtils.leftPad(resultado.getString("filler20") == null ? "0" : resultado.getString("filler20"), 20, "0"); //valor fixo
						 layout = StringUtils.leftPad(resultado.getString("layout") == null ? "100" : resultado.getString("nsa"), 3, "0"); //valor fixo
						 lotesvc = StringUtils.leftPad(resultado.getString("lotesvc") == null ? "0000" : resultado.getString("lotesvc"), 4, "0");
						 tiporegistro = StringUtils.leftPad(resultado.getString("tiporegistro") == null ? "0" : resultado.getString("tiporegistro"), 1, "0");
						 */
						 
						 segmentod = StringUtils.leftPad("D", 1, "0"); 		//valor fixo
						 segmentoe = StringUtils.leftPad("E", 1, "0"); 		//valor fixo
						 movimento = StringUtils.leftPad("0", 1, "0"); 		//valor fixo
						 cxpostal = StringUtils.leftPad("0", 9, "0"); 		//valor fixo
						 filler1 = StringUtils.leftPad("0", 1, ""); 		//valor fixo
						 filler2 = StringUtils.leftPad("0", 2, ""); 		//valor fixo
						 filler5 = StringUtils.leftPad("0", 5, ""); 		//valor fixo
						 filler10 = StringUtils.leftPad("0", 10, ""); 		//valor fixo
						 filler15 = StringUtils.leftPad("0", 15, ""); 		//valor fixo
						 filler20 = StringUtils.leftPad("0", 20, ""); 		//valor fixo
						 
						 if (setHeader) {
							 
							 setHeader = Boolean.FALSE;
							 
							 fileWriter.write(codigobco); 		//Header do arquivo
							 fileWriter.write(lotesvcheader); 	//Header do arquivo
							 fileWriter.write(tiporegistro); 	//Header do arquivo
							 fileWriter.write(filler5); 		//Header do arquivo
							 fileWriter.write(filler2); 		//Header do arquivo
							 fileWriter.write(filler2); 		//Header do arquivo
							 fileWriter.write(inscricao); 		//Header do arquivo
							 fileWriter.write(cnpj);			//Header do arquivo
							 fileWriter.write(convenio);		//Header do arquivo
							 fileWriter.write(agenciaempresa);	//Header do arquivo
							 fileWriter.write(filler1); 		//Header do arquivo
							 fileWriter.write(contaempresa);	//Header do arquivo
							 fileWriter.write(dvempresa);		//Header do arquivo
							 fileWriter.write(filler1); 		//Header do arquivo
							 fileWriter.write(empresa);			//Header do arquivo
							 fileWriter.write(banco);			//Header do arquivo
							 fileWriter.write(filler10); 		//Header do arquivo
							 fileWriter.write(remessa);			//Header do arquivo
							 fileWriter.write(data);			//Header do arquivo
							 //fileWriter.write(hora);			//Header do arquivo
							 fileWriter.write(nsa);				//Header do arquivo
							 fileWriter.write(layout);			//Header do arquivo
							 fileWriter.write(filler5); 		//Header do arquivo
							 fileWriter.write(filler20); 		//Header do arquivo Reservado Banco - enviar campos em branco
							 fileWriter.write(filler20); 		//Header do arquivo Reservado Empresa - enviar campos em banco
							 fileWriter.write(filler20); 		//Header do arquivo
							 fileWriter.write(filler5); 		//Header do arquivo
							 fileWriter.write(filler2); 		//Header do arquivo
							 fileWriter.write(filler2); 		//Header do arquivo
							 fileWriter.write(ocorrencias); 	//Header do arquivo
							 
							 fileWriter.write("\n");
						 }
						 
						 		fileWriter.write(codigobco);		//Header de lote
						 		fileWriter.write(lotesvcsegmentod); //Header de lote 
						 		fileWriter.write(tiporegistro); 	//Header de lote
						 		fileWriter.write(nsa);				//Header de lote 
						 		fileWriter.write(segmentod);		//Header de lote 
						 		fileWriter.write(movimento);		//Header de lote 
						 		fileWriter.write(colaborador);		//Header de lote 
						 		fileWriter.write(cpf);				//Header de lote 
						 		fileWriter.write(ufnasc);			//Header de lote 
						 		fileWriter.write(rg);				//Header de lote 
						 		fileWriter.write(dn);				//Header de lote 
						 		fileWriter.write(sexo);				//Header de lote 
						 		fileWriter.write(civil);			//Header de lote 
						 		fileWriter.write(filler5);			//Header de lote 
						 		fileWriter.write(filler1);			//Header de lote
						 		fileWriter.write(mae);				//Header de lote
						 		fileWriter.write(ruacolab);			//Header de lote
						 		fileWriter.write(nresidcolab);		//Header de lote
						 		fileWriter.write(compresidcolab);	//Header de lote
						 		fileWriter.write(bairrocolab);		//Header de lote
						 		fileWriter.write(cidadecolab);		//Header de lote
						 		fileWriter.write(estadocolab);		//Header de lote
						 		fileWriter.write(cepcolab);			//Header de lote
						 
						 
						 						 
						 			fileWriter.write(codigobco);		//Seg D
						 			fileWriter.write(lotesvcsegmentod);	//Seg D
						 			fileWriter.write(tiporegistro); 	//Seg D Ajustar
						 			fileWriter.write(nsa);				//Seg D
						 			fileWriter.write(segmentod);		//Seg D
						 			fileWriter.write(movimento);		//Seg D
						 			fileWriter.write(colaborador);		//Seg D
						 			fileWriter.write(cpf);				//Seg D
						 			fileWriter.write(ufnasc);			//Seg D
						 			fileWriter.write(rg);				//Seg D
						 			fileWriter.write(dn);				//Seg D
						 			fileWriter.write(sexo);				//Seg D
						 			fileWriter.write(civil);			//Seg D
						 			fileWriter.write(filler5);			//Seg D
						 			fileWriter.write(filler1);			//Seg D
						 			fileWriter.write(mae);				//Seg D
						 			fileWriter.write(ruacolab);			//Seg D
						 			fileWriter.write(nresidcolab);		//Seg D
						 			fileWriter.write(compresidcolab);	//Seg D
						 			fileWriter.write(bairrocolab);		//Seg D
						 			fileWriter.write(cidadecolab);		//Seg D
						 			fileWriter.write(estadocolab);		//Seg D
						 			fileWriter.write(cepcolab);			//Seg D
						 
						 			fileWriter.write("\n");
						 
						 			fileWriter.write(codigobco);		//Seg E
						 			fileWriter.write(lotesvcsegmentoe);	//Seg E
						 			fileWriter.write(tiporegistro); 	//Seg E Ajustar
						 			fileWriter.write(filler1);			//Seg E
						 			fileWriter.write(nsa);				//Seg E
						 			fileWriter.write(segmentoe);		//Seg E
						 			fileWriter.write(emailcolab);		//Seg E
						 			fileWriter.write(filler20);			//Seg E
						 			fileWriter.write(dddcolab);			//Seg E
						 			fileWriter.write(telefonecolab);	//Seg E
						 			fileWriter.write(filler10);			//Seg E
						 			fileWriter.write(cxpostal);			//Seg E
						 			fileWriter.write(salario);			//Seg E
						 			fileWriter.write(filler10);			//Seg E
						 			fileWriter.write(admissao);			//Seg E
						 			fileWriter.write(filler20);			//Seg E
						 			fileWriter.write(cargo);			//Seg E
						 			fileWriter.write(filler15);			//Seg E
						 			fileWriter.write(agenciacolab);		//Seg E
						 			fileWriter.write(filler1);			//Seg E
						 			fileWriter.write(contasalario);		//Seg E
						 			fileWriter.write(dvcolab);			//Seg E
						 			fileWriter.write(ocorrencias);		//Seg E
						 
						 			fileWriter.write("\n");
						 			
						 		fileWriter.write(codigobco);		//Trailer lote
						 		fileWriter.write(lotesvcsegmentoe);	//Trailer lote 
						 		fileWriter.write(tiporegistro); 	//Trailer lote  Ajustar
						 		fileWriter.write(filler1);			//Trailer lote 
						 		fileWriter.write(nsa);				//Trailer lote 
						 		fileWriter.write(segmentoe);		//Trailer lote 
						 		fileWriter.write(emailcolab);		//Trailer lote 
						 		fileWriter.write(filler20);			//Trailer lote 
						 		fileWriter.write(dddcolab);			//Trailer lote 
						 		fileWriter.write(telefonecolab);	//Trailer lote 
						 		fileWriter.write(filler10);			//Trailer lote 
						 		fileWriter.write(cxpostal);			//Trailer lote 
						 		fileWriter.write(salario);			//Trailer lote 
						 		fileWriter.write(filler10);			//Trailer lote 
						 		fileWriter.write(admissao);			//Trailer lote 
						 		fileWriter.write(filler20);			//Trailer lote 
						 		fileWriter.write(cargo);			//Trailer lote 
						 		fileWriter.write(filler15);			//Trailer lote 
						 		fileWriter.write(agenciacolab);		//Trailer lote 
						 		fileWriter.write(filler1);			//Trailer lote 
						 		fileWriter.write(contasalario);		//Trailer lote 
						 		fileWriter.write(dvcolab);			//Trailer lote 
						 		fileWriter.write(ocorrencias);		//Trailer lote 
						 
						 		fileWriter.write("\n");
						 		
						 	fileWriter.write(codigobco);		//Trailer arquivo
						 	fileWriter.write(lotesvcsegmentoe);	//Trailer arquivo 
						 	fileWriter.write(tiporegistro); 	//Trailer arquivo  Ajustar
						 	fileWriter.write(filler1);			//Trailer arquivo 
						 	fileWriter.write(nsa);				//Trailer arquivo 
						 	fileWriter.write(segmentoe);		//Trailer arquivo 
						 	fileWriter.write(emailcolab);		//Trailer arquivo 
						 	fileWriter.write(filler20);			//Trailer arquivo 
						 	fileWriter.write(dddcolab);			//Trailer arquivo 
						 	fileWriter.write(telefonecolab);	//Trailer arquivo 
						 	fileWriter.write(filler10);			//Trailer arquivo 
						 	fileWriter.write(cxpostal);			//Trailer arquivo 
						 	fileWriter.write(salario);			//Trailer arquivo 
						 	fileWriter.write(filler10);			//Trailer arquivo 
						 	fileWriter.write(admissao);			//Trailer arquivo 
						 	fileWriter.write(filler20);			//Trailer arquivo 
						 	fileWriter.write(cargo);			//Trailer arquivo 
						 	fileWriter.write(filler15);			//Trailer arquivo 
						 	fileWriter.write(agenciacolab);		//Trailer arquivo 
						 	fileWriter.write(filler1);			//Trailer arquivo 
						 	fileWriter.write(contasalario);		//Trailer arquivo 
						 	fileWriter.write(dvcolab);			//Trailer arquivo 
						 	fileWriter.write(ocorrencias);		//Trailer arquivo 
						 
						 		fileWriter.write("\n");		
						 
						 
					 }
					 
					 fileWriter.close();
			    }
			    catch (Exception ex) {
				    ex.printStackTrace();
				    JOptionPane.showMessageDialog(null, "Erro ao gerar arquivo", "Erro", JOptionPane.ERROR_MESSAGE);
				    return;
				}

				JOptionPane.showMessageDialog(null, "Processamento concluído!", "Sucesso", JOptionPane.DEFAULT_OPTION);
				
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

