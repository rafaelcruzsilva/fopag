import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class InsEmpresa {

	public JFrame frame;
	private JTextField txtcnpj;
	private JTextField txtempresa;
	private JTextField txtconvenio;
	private JTextField txtnresid;
	private JTextField txtcompresid;
	private JTextField txtbairro;
	private JTextField txtcidade;
	private JTextField txtcep;
	private JTextField txtbanco;
	private JTextField txtagencia;
	private JTextField txtddd;
	private JTextField txtdv;
	private JTextField txtrua;
	private JTextField txtemail;
	private JTextField txtconta;
	private JTextField txttelefone;
	


	/**
	 * OriginalApp
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InsEmpresa window = new InsEmpresa();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public InsEmpresa() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Calibri", Font.PLAIN, 16));
		frame.setBounds(100, 100, 700, 780);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(678, 0, -678, 744);
		frame.getContentPane().add(scrollPane);
		
		JLabel lbempresa = new JLabel("Cadastro de Empresa");
		lbempresa.setHorizontalAlignment(SwingConstants.CENTER);
		lbempresa.setFont(new Font("Calibri", Font.PLAIN, 30));
		lbempresa.setBounds(10, 10, 645, 60);
		frame.getContentPane().add(lbempresa);
		
		JButton btnGravar = new JButton("Gravar");
		btnGravar.setFont(new Font("Calibri", Font.PLAIN, 16));
		btnGravar.setBounds(10, 120, 120, 30);
		frame.getContentPane().add(btnGravar);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setFont(new Font("Calibri", Font.PLAIN, 16));
		btnEditar.setBounds(10, 167, 120, 30);
		frame.getContentPane().add(btnEditar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setFont(new Font("Calibri", Font.PLAIN, 18));
		btnExcluir.setBounds(10, 212, 120, 30);
		frame.getContentPane().add(btnExcluir);
		
		JButton btfechar = new JButton("Fechar");
		btfechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btfechar.setFont(new Font("Calibri", Font.PLAIN, 18));
		btfechar.setBounds(10, 256, 120, 30);
		frame.getContentPane().add(btfechar);
		
		JButton btnpesquisar = new JButton("Pesquisar");
		btnpesquisar.setFont(new Font("Calibri", Font.PLAIN, 16));
		btnpesquisar.setBounds(533, 120, 120, 25);
		frame.getContentPane().add(btnpesquisar);
		
		JLabel lbcnpj = new JLabel("*CNPJ");
		lbcnpj.setFont(new Font("Calibri", Font.PLAIN, 16));
		lbcnpj.setBounds(145, 120, 120, 25);
		frame.getContentPane().add(lbcnpj);
		
		JLabel lbnomeempresa = new JLabel("*Nome");
		lbnomeempresa.setFont(new Font("Calibri", Font.PLAIN, 16));
		lbnomeempresa.setBounds(145, 190, 120, 25);
		frame.getContentPane().add(lbnomeempresa);
		
		JLabel lbconvenio = new JLabel("*Conv\u00EAnio");
		lbconvenio.setFont(new Font("Calibri", Font.PLAIN, 16));
		lbconvenio.setBounds(145, 155, 120, 25);
		frame.getContentPane().add(lbconvenio);
		
		JLabel lbrua = new JLabel("*Rua");
		lbrua.setFont(new Font("Calibri", Font.PLAIN, 16));
		lbrua.setBounds(145, 225, 120, 25);
		frame.getContentPane().add(lbrua);
		
		JLabel lbnresid = new JLabel("N\u00FAmero");
		lbnresid.setFont(new Font("Calibri", Font.PLAIN, 16));
		lbnresid.setBounds(145, 260, 120, 25);
		frame.getContentPane().add(lbnresid);
		
		JLabel lbcompresid = new JLabel("Complemento");
		lbcompresid.setFont(new Font("Calibri", Font.PLAIN, 16));
		lbcompresid.setBounds(399, 260, 120, 25);
		frame.getContentPane().add(lbcompresid);
		
		JLabel lbbairro = new JLabel("*Bairro");
		lbbairro.setFont(new Font("Calibri", Font.PLAIN, 16));
		lbbairro.setBounds(145, 295, 120, 25);
		frame.getContentPane().add(lbbairro);
		
		JLabel lbcidade = new JLabel("*Cidade");
		lbcidade.setFont(new Font("Calibri", Font.PLAIN, 16));
		lbcidade.setBounds(399, 295, 120, 25);
		frame.getContentPane().add(lbcidade);
		
		JLabel lbestado = new JLabel("*Estado");
		lbestado.setFont(new Font("Calibri", Font.PLAIN, 16));
		lbestado.setBounds(399, 330, 120, 25);
		frame.getContentPane().add(lbestado);
		
		JLabel lbcep = new JLabel("*CEP");
		lbcep.setFont(new Font("Calibri", Font.PLAIN, 16));
		lbcep.setBounds(145, 330, 120, 25);
		frame.getContentPane().add(lbcep);
		
		JLabel lbbanco = new JLabel("Banco");
		lbbanco.setFont(new Font("Calibri", Font.PLAIN, 16));
		lbbanco.setBounds(145, 365, 120, 25);
		frame.getContentPane().add(lbbanco);
		
		JLabel lbagencia = new JLabel("Ag\u00EAncia");
		lbagencia.setFont(new Font("Calibri", Font.PLAIN, 16));
		lbagencia.setBounds(399, 365, 120, 25);
		frame.getContentPane().add(lbagencia);
		
		JLabel lbconta = new JLabel("Conta Corrente");
		lbconta.setFont(new Font("Calibri", Font.PLAIN, 16));
		lbconta.setBounds(145, 400, 120, 25);
		frame.getContentPane().add(lbconta);
		
		JLabel lbdv = new JLabel("Digito verificador");
		lbdv.setFont(new Font("Calibri", Font.PLAIN, 16));
		lbdv.setBounds(399, 400, 120, 25);
		frame.getContentPane().add(lbdv);
		
		JLabel lbddd = new JLabel("*DDD");
		lbddd.setFont(new Font("Calibri", Font.PLAIN, 16));
		lbddd.setBounds(145, 435, 120, 25);
		frame.getContentPane().add(lbddd);
		
		JLabel lbtelefone = new JLabel("*Celular");
		lbtelefone.setFont(new Font("Calibri", Font.PLAIN, 16));
		lbtelefone.setBounds(399, 435, 120, 25);
		frame.getContentPane().add(lbtelefone);
		
		JLabel lbemail = new JLabel("*email");
		lbemail.setFont(new Font("Calibri", Font.PLAIN, 16));
		lbemail.setBounds(145, 470, 120, 25);
		frame.getContentPane().add(lbemail);
		
		txtcnpj = new JTextField();
		txtcnpj.setFont(new Font("Calibri", Font.PLAIN, 16));
		txtcnpj.setColumns(10);
		txtcnpj.setBounds(266, 120, 252, 25);
		frame.getContentPane().add(txtcnpj);
		
		txtempresa = new JTextField();
		txtempresa.setFont(new Font("Calibri", Font.PLAIN, 16));
		txtempresa.setColumns(10);
		txtempresa.setBounds(268, 190, 387, 25);
		frame.getContentPane().add(txtempresa);
		
		txtconvenio = new JTextField();
		txtconvenio.setFont(new Font("Calibri", Font.PLAIN, 16));
		txtconvenio.setColumns(10);
		txtconvenio.setBounds(266, 155, 387, 25);
		frame.getContentPane().add(txtconvenio);
		
		txtnresid = new JTextField();
		txtnresid.setFont(new Font("Calibri", Font.PLAIN, 16));
		txtnresid.setColumns(10);
		txtnresid.setBounds(266, 260, 120, 25);
		frame.getContentPane().add(txtnresid);
		
		txtcompresid = new JTextField();
		txtcompresid.setFont(new Font("Calibri", Font.PLAIN, 16));
		txtcompresid.setColumns(10);
		txtcompresid.setBounds(531, 260, 120, 25);
		frame.getContentPane().add(txtcompresid);
		
		txtbairro = new JTextField();
		txtbairro.setFont(new Font("Calibri", Font.PLAIN, 16));
		txtbairro.setColumns(10);
		txtbairro.setBounds(266, 295, 120, 25);
		frame.getContentPane().add(txtbairro);
		
		txtcidade = new JTextField();
		txtcidade.setFont(new Font("Calibri", Font.PLAIN, 16));
		txtcidade.setColumns(10);
		txtcidade.setBounds(531, 295, 120, 25);
		frame.getContentPane().add(txtcidade);
		
		txtcep = new JTextField();
		txtcep.setFont(new Font("Calibri", Font.PLAIN, 16));
		txtcep.setColumns(10);
		txtcep.setBounds(264, 330, 120, 25);
		frame.getContentPane().add(txtcep);
		
		txtbanco = new JTextField();
		txtbanco.setFont(new Font("Calibri", Font.PLAIN, 16));
		txtbanco.setColumns(10);
		txtbanco.setBounds(266, 365, 120, 25);
		frame.getContentPane().add(txtbanco);
		
		txtagencia = new JTextField();
		txtagencia.setFont(new Font("Calibri", Font.PLAIN, 16));
		txtagencia.setColumns(10);
		txtagencia.setBounds(531, 365, 120, 25);
		frame.getContentPane().add(txtagencia);
		
		txtddd = new JTextField();
		txtddd.setFont(new Font("Calibri", Font.PLAIN, 16));
		txtddd.setColumns(10);
		txtddd.setBounds(264, 435, 120, 25);
		frame.getContentPane().add(txtddd);
		
		txtdv = new JTextField();
		txtdv.setFont(new Font("Calibri", Font.PLAIN, 16));
		txtdv.setColumns(10);
		txtdv.setBounds(531, 400, 120, 25);
		frame.getContentPane().add(txtdv);
		
		txtrua = new JTextField();
		txtrua.setFont(new Font("Calibri", Font.PLAIN, 16));
		txtrua.setColumns(10);
		txtrua.setBounds(266, 225, 387, 25);
		frame.getContentPane().add(txtrua);
		
		txtemail = new JTextField();
		txtemail.setFont(new Font("Calibri", Font.PLAIN, 16));
		txtemail.setColumns(10);
		txtemail.setBounds(264, 470, 387, 25);
		frame.getContentPane().add(txtemail);
		
		txtconta = new JTextField();
		txtconta.setFont(new Font("Calibri", Font.PLAIN, 16));
		txtconta.setColumns(10);
		txtconta.setBounds(264, 400, 120, 25);
		frame.getContentPane().add(txtconta);
		
		txttelefone = new JTextField();
		txttelefone.setFont(new Font("Calibri", Font.PLAIN, 16));
		txttelefone.setColumns(10);
		txttelefone.setBounds(531, 435, 120, 25);
		frame.getContentPane().add(txttelefone);
		
		JComboBox comboEstado = new JComboBox();
		comboEstado.setFont(new Font("Calibri", Font.PLAIN, 16));
		comboEstado.setModel(new DefaultComboBoxModel(new String[] {"AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO"}));
		comboEstado.setBounds(531, 330, 120, 25);
		frame.getContentPane().add(comboEstado);
		
		JLabel lblNewLabel = new JLabel("*Tipo de Inscri\u00E7ao");
		lblNewLabel.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblNewLabel.setBounds(145, 505, 120, 25);
		frame.getContentPane().add(lblNewLabel);
		
		JComboBox<Tpinscricao> comboInscricao = new JComboBox<Tpinscricao>();
		comboInscricao.setFont(new Font("Calibri", Font.PLAIN, 16));
		comboInscricao.addItem(new Tpinscricao("1", "Pessoa Fisica"));
		comboInscricao.addItem(new Tpinscricao("2", "Pessoa Juridica"));
		comboInscricao.setBounds(266, 505, 120, 25);
		frame.getContentPane().add(comboInscricao);
		
		JLabel lblNewLabel_2 = new JLabel("C\u00F3digo Banco");
		lblNewLabel_2.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(145, 540, 120, 25);
		frame.getContentPane().add(lblNewLabel_2);
		
		JComboBox<Bancos> comboBancos = new JComboBox<Bancos>();
		comboBancos.setFont(new Font("Calibri", Font.PLAIN, 16));
		comboBancos.addItem(new Bancos("212", "Banco Original S.A."));
		comboBancos.addItem(new Bancos("000", "..."));
		comboBancos.setBounds(266, 540, 120, 25);
		frame.getContentPane().add(comboBancos);
		
		btnGravar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
		            String query = "INSERT INTO `fopagdb`.`empresatb`\n" +  // Aqui inicia a Query de cadastro
		            "(`cnpj`,\n" +
		            "`empresa`,\n" +
		            "`convenio`,\n" +
		            "`rua`,\n" +
		            "`nresid`,\n" +
		            "`compresid`,\n" +
		            "`bairro`,\n" +
		            "`cidade`,\n" +
		            "`cep`,\n" +
		            "`estado`,\n"+
		            "`banco`,\n" +
		            "`agencia`,\n" +
		            "`conta`,\n" +
		            "`dv`,\n" +
		            "`ddd`,\n" +
		            "`telefone`,\n" +
		            "`inscricao`,\n" +
		            "`codigobco`,\n" +
		            "`email`)\n" +
		            "VALUES\n" +
		            "('" + txtcnpj.getText() + "',\n" +
		            "'" + txtempresa.getText() + "',\n" +
		            "'" + txtconvenio.getText() + "',\n" +
		            "'" + txtrua.getText() + "',\n" +
		            "'" + txtnresid.getText() + "',\n" +
		            "'" + txtcompresid.getText() + "',\n" +
		            "'" + txtbairro.getText() + "',\n" +
		            "'" + txtcidade.getText() + "',\n" +
		            "'" + txtcep.getText() + "',\n" +
		            "'" + comboEstado.getSelectedItem().toString() + "',\n" +
		            "'" + txtbanco.getText() + "',\n" +
		            "'" + txtagencia.getText() + "',\n" +
		            "'" + txtconta.getText() + "',\n" +
		            "'" + txtdv.getText() + "',\n" +
		            "'" + txtddd.getText() + "',\n" +
		            "'" + txttelefone.getText() + "',\n" +
		            "'" + ((Tpinscricao) comboInscricao.getSelectedItem()).getKey() + "',\n" +
		            "'" + ((Bancos) comboBancos.getSelectedItem()).getKey() + "',\n" +
		            "'" + txtemail.getText() + "')";
		            
					Fopag.connection.insertData(query);
					JOptionPane.showMessageDialog(btnGravar, "Empresa cadastrada com sucesso!");
				}
				catch (SQLException ex)
				{
					JOptionPane.showMessageDialog(btnGravar, "Hum... algo deu errado!!!");
	            ex.printStackTrace();
				}
				  	txtcnpj.setText("");  		
				  	txtempresa.setText("");   	
				  	txtconvenio.setText(""); 
				  	txtrua.setText("");
				  	txtnresid.setText("");
				  	txtcompresid.setText("");
				  	txtbairro.setText("");
				  	txtcidade.setText("");
				  	txtcep.setText("");
				  	comboEstado.getSelectedItem();
				  	txtbanco.setText("");
				  	txtagencia.setText("");
				  	txtconta.setText("");
				  	txtdv.setText("");
				  	txtddd.setText("");
				  	txttelefone.setText("");
				  	comboInscricao.getSelectedItem();
				  	comboBancos.getSelectedItem();
				  	txtemail.setText("");
			}
		});
	}
}
