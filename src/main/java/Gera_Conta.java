import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
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

	/**
	 * Create the application.
	 */
	public Gera_Conta() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
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
				
				final String dataConsulta = rdbtnDataatual.isSelected() ? new SimpleDateFormat("ddMMYYYY").format(new Date()) : txtData.getText();
				
				try {
					System.out.println("Chamando consulta");
					
					String query = String.format("SELECT * FROM fopagdb.contastb WHERE data LIKE '%s'", dataConsulta);
					
					System.out.println(query);
					
					ResultSet resultado = Fopag.connection.getData(query);
					
					String codigobco;
					String cnpj;
					String data;
					String inscricao;
					
					 while (resultado.next()) {
						 codigobco = StringUtils.leftPad(resultado.getString("codigobco"), 15, ".");
						 cnpj = StringUtils.leftPad(resultado.getString("cnpj"), 20, ".");
						 data = StringUtils.leftPad(resultado.getString("data"), 15, ".");
						 inscricao = StringUtils.leftPad(resultado.getString("inscricao"), 15, ".");
						 
						 System.out.println(codigobco.concat(cnpj).concat(data).concat(inscricao));
					 }
					
					
					/*
			    	//ResultSet resultado = Fopag.connection.getData("SELECT * FROM fopagdb.contastb WHERE `data` = 07052020");
			    
				    while (resultado.next())
		            {
		                txtCnab.setText(resultado.getString("codigobco")); // Apresentando os valores nos campos
		                txtCnab.setText(resultado.getString("inscricao"));
		                txtCnab.setText(resultado.getString("cnpj"));
		                txtCnab.setText(resultado.getString("convenio"));
		                txtCnab.setText(resultado.getString("agencia"));
		                txtCnab.setText(resultado.getString("conta"));
		                txtCnab.setText(resultado.getString("dv"));
		                txtCnab.setText(resultado.getString("empresa"));
		                txtCnab.setText(resultado.getString("banco"));
		                //txtremessa.setText(resultado.getString("remessa"));
		                //txtnsa.setText(resultado.getString("nsa"));
		            }
		            */
			    }
			    catch (Exception ex) {
				    ex.printStackTrace();
				}

				JOptionPane.showMessageDialog(null, "Gerando arquivo com data atual");
				
			}
		});
		
		btnEnviar.setFont(new Font("Calibri", Font.PLAIN, 18));
		btnEnviar.setBounds(505, 99, 115, 29);
		panelBanco.add(btnEnviar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Calibri", Font.PLAIN, 18));
		btnCancelar.setBounds(529, 751, 120, 30);
		frame.getContentPane().add(btnCancelar);
		
		JTextArea txtCnab = new JTextArea();
		txtCnab.setBounds(20, 255, 635, 464);
		frame.getContentPane().add(txtCnab);
	}
}
