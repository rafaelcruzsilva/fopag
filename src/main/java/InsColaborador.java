import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class InsColaborador {

	public JFrame frame;
	private JTextField txtcpf;
	private JTextField txtnome;
	private JTextField txtrg;
	private JTextField txtdn;
	private JTextField txtnresid;
	private JTextField txtcompresid;
	private JTextField txtbairro;
	private JTextField txtcidade;
	private JTextField txtcep;
	private JTextField txtbanco;
	private JTextField txtagencia;
	private JTextField txtconta;
	private JTextField txtdv;
	private JTextField txtmae;
	private JTextField txtrua;
	private JTextField txtemail;
	private JTextField txtddd;
	private JTextField txttelefone;
	private JTextField txtcargo;
	private JTextField txtadmissao;
	private JTextField txtsalario;

	/**
	 * OriginalApp
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InsColaborador window = new InsColaborador();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public InsColaborador() {
		initialize();
	}

	private void initialize() {
		
		frame = new JFrame();
		frame.setTitle("Inserir Colaboradores");
		frame.getContentPane().setFont(new Font("Calibri", Font.PLAIN, 16));
		frame.getContentPane().addContainerListener(new ContainerAdapter() {
			@Override
			public void componentRemoved(ContainerEvent arg0) {
				
			}
		});
		
		frame.setBounds(100, 100, 700, 780);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 430, 470);
		frame.getContentPane().add(panel);
		
		JScrollPane scrollPane = new JScrollPane(panel);
		panel.setLayout(null);
		scrollPane.setBounds(678, 0, -678, 744);
		frame.getContentPane().add(scrollPane);
		
		JLabel Colaborador_Label = new JLabel("Cadastro de Colaboradores");
		Colaborador_Label.setHorizontalAlignment(SwingConstants.CENTER);
		Colaborador_Label.setFont(new Font("Calibri", Font.PLAIN, 30));
		Colaborador_Label.setBounds(10, 10, 645, 60);
		frame.getContentPane().add(Colaborador_Label);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setFont(new Font("Calibri", Font.PLAIN, 16));
		btnEditar.setBounds(15, 167, 120, 30);
		frame.getContentPane().add(btnEditar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setFont(new Font("Calibri", Font.PLAIN, 16));
		btnExcluir.setBounds(15, 212, 120, 30);
		frame.getContentPane().add(btnExcluir);
		
		JButton btnFechar = new JButton("Fechar");
		btnFechar.setFont(new Font("Calibri", Font.PLAIN, 16));
		btnFechar.setBounds(15, 257, 120, 30);
		frame.getContentPane().add(btnFechar);
		
		JButton btnpesquisar = new JButton("Pesquisar");
		btnpesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {				
				try {
					
					String query = ("SELECT * FROM fopagdb.cadastrotb WHERE `cpf` = " + txtcpf.getText()); 
		            ResultSet resultado = Fopag.connection.getData(query);
		            
		            while (resultado.next()) {
		            	
		                txtcpf.setText(resultado.getString("cpf")); // Apresentando os valores nos campos
		                txtnome.setText(resultado.getString("nome"));
		                txtrg.setText(resultado.getString("rg"));
		                txtdn.setText(resultado.getString("dn"));
		                txtnresid.setText(resultado.getString("nresid"));
		                txtcompresid.setText(resultado.getString("compresid"));
		                txtbairro.setText(resultado.getString("bairro"));
		                txtcidade.setText(resultado.getString("cidade"));
		                txtcep.setText(resultado.getString("cep"));
		                txtbanco.setText(resultado.getString("banco"));
		                txtagencia.setText(resultado.getString("agencia"));
		                txtconta.setText(resultado.getString("conta"));
		                txtdv.setText(resultado.getString("dv"));
		                txtmae.setText(resultado.getString("mae"));
		                txtrua.setText(resultado.getString("rua"));
		                txtemail.setText(resultado.getString("email"));
		                txtddd.setText(resultado.getString("ddd"));
		                txttelefone.setText(resultado.getString("telefone"));
		                txtcargo.setText(resultado.getString("cargo"));
		                txtadmissao.setText(resultado.getString("admissao"));
		                txtsalario.setText(resultado.getString("salario"));
		                
		            }
				}
				
				catch (Exception ex) {
					
				    ex.printStackTrace();
				}
			}
		});
		
		btnpesquisar.setFont(new Font("Calibri", Font.PLAIN, 16));
		btnpesquisar.setBounds(548, 122, 120, 29);
		frame.getContentPane().add(btnpesquisar);
		
		JLabel lbcpf = new JLabel("*CPF");
		lbcpf.setFont(new Font("Calibri", Font.PLAIN, 16));
		lbcpf.setBounds(160, 122, 120, 30);
		frame.getContentPane().add(lbcpf);
		
		JLabel lbnome = new JLabel("*Nome");
		lbnome.setFont(new Font("Calibri", Font.PLAIN, 16));
		lbnome.setBounds(160, 165, 120, 25);
		frame.getContentPane().add(lbnome);
		
		JLabel lbrg = new JLabel("*Identidade");
		lbrg.setFont(new Font("Calibri", Font.PLAIN, 16));
		lbrg.setBounds(160, 200, 120, 25);
		frame.getContentPane().add(lbrg);
		
		JLabel lbdn = new JLabel("Nascimento");
		lbdn.setFont(new Font("Calibri", Font.PLAIN, 16));
		lbdn.setBounds(160, 240, 120, 25);
		frame.getContentPane().add(lbdn);
		
		JLabel lbufnasc = new JLabel("Local nasc");
		lbufnasc.setFont(new Font("Calibri", Font.PLAIN, 16));
		lbufnasc.setBounds(423, 240, 120, 25);
		frame.getContentPane().add(lbufnasc);
		
		JComboBox comboUf = new JComboBox();
		comboUf.setFont(new Font("Calibri", Font.PLAIN, 16));
		comboUf.setModel(new DefaultComboBoxModel(new String[] {"AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO"}));
		comboUf.setBounds(548, 240, 120, 25);
		frame.getContentPane().add(comboUf);
		
		JLabel lbmae = new JLabel("*M\u00E3e");
		lbmae.setFont(new Font("Calibri", Font.PLAIN, 16));
		lbmae.setBounds(160, 280, 120, 25);
		frame.getContentPane().add(lbmae);
		
		JLabel lbsexo = new JLabel("*Sexo");
		lbsexo.setFont(new Font("Calibri", Font.PLAIN, 16));
		lbsexo.setBounds(160, 315, 120, 25);
		frame.getContentPane().add(lbsexo);
		
		JComboBox<Sexo> comboSexo = new JComboBox<Sexo>();
		comboSexo.setFont(new Font("Calibri", Font.PLAIN, 16));
		comboSexo.addItem(new Sexo("1", "Masculino"));
		comboSexo.addItem(new Sexo("2", "Feminino"));
		comboSexo.setBounds(281, 315, 120, 25);
		frame.getContentPane().add(comboSexo);
		
		JLabel lbcivil = new JLabel("*Estado Civil");
		lbcivil.setFont(new Font("Calibri", Font.PLAIN, 16));
		lbcivil.setBounds(423, 315, 120, 25);
		frame.getContentPane().add(lbcivil);
		
		JComboBox<Civil> comboCivil = new JComboBox<Civil>();
		comboCivil.setFont(new Font("Calibri", Font.PLAIN, 16));
		comboCivil.addItem(new Civil("1", "Solteiro (a)"));
		comboCivil.addItem(new Civil("2", "casado (a)"));
		comboCivil.addItem(new Civil("3", "Uniao Estável"));
		comboCivil.addItem(new Civil("4", "Divorciado (a)"));
		comboCivil.setBounds(548, 315, 120, 25);
		frame.getContentPane().add(comboCivil);
		
		JLabel lbrua = new JLabel("*Rua");
		lbrua.setFont(new Font("Calibri", Font.PLAIN, 16));
		lbrua.setBounds(160, 350, 120, 25);
		frame.getContentPane().add(lbrua);
		
		JLabel lbnresid = new JLabel("N\u00FAmero");
		lbnresid.setFont(new Font("Calibri", Font.PLAIN, 16));
		lbnresid.setBounds(160, 385, 120, 25);
		frame.getContentPane().add(lbnresid);
		
		JLabel lbcompresid = new JLabel("Complemento");
		lbcompresid.setFont(new Font("Calibri", Font.PLAIN, 16));
		lbcompresid.setBounds(423, 385, 120, 25);
		frame.getContentPane().add(lbcompresid);
		
		JLabel lbbairro = new JLabel("*Bairro");
		lbbairro.setFont(new Font("Calibri", Font.PLAIN, 16));
		lbbairro.setBounds(160, 420, 120, 25);
		frame.getContentPane().add(lbbairro);
		
		JLabel lbcidade = new JLabel("*Cidade");
		lbcidade.setFont(new Font("Calibri", Font.PLAIN, 16));
		lbcidade.setBounds(423, 420, 120, 25);
		frame.getContentPane().add(lbcidade);
		
		JComboBox comboEstado = new JComboBox();
		comboEstado.setFont(new Font("Calibri", Font.PLAIN, 16));
		comboEstado.setModel(new DefaultComboBoxModel(new String[] {"AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO"}));
		comboEstado.setBounds(548, 455, 120, 25);
		frame.getContentPane().add(comboEstado);
		
		JLabel lbestado = new JLabel("*Estado");
		lbestado.setFont(new Font("Calibri", Font.PLAIN, 16));
		lbestado.setBounds(423, 455, 120, 25);
		frame.getContentPane().add(lbestado);
		
		JLabel lbcep = new JLabel("*CEP");
		lbcep.setFont(new Font("Calibri", Font.PLAIN, 16));
		lbcep.setBounds(160, 455, 120, 25);
		frame.getContentPane().add(lbcep);
		
		JLabel lbbanco = new JLabel("Banco");
		lbbanco.setFont(new Font("Calibri", Font.PLAIN, 16));
		lbbanco.setBounds(160, 495, 120, 25);
		frame.getContentPane().add(lbbanco);
		
		JLabel lbagencia = new JLabel("Ag\u00EAncia");
		lbagencia.setFont(new Font("Calibri", Font.PLAIN, 16));
		lbagencia.setBounds(423, 495, 120, 25);
		frame.getContentPane().add(lbagencia);
		
		JLabel lbconta = new JLabel("Conta Sal\u00E1rio");
		lbconta.setFont(new Font("Calibri", Font.PLAIN, 16));
		lbconta.setBounds(160, 535, 120, 25);
		frame.getContentPane().add(lbconta);
		
		JLabel lbdv = new JLabel("Digito verificador");
		lbdv.setFont(new Font("Calibri", Font.PLAIN, 16));
		lbdv.setBounds(423, 535, 120, 25);
		frame.getContentPane().add(lbdv);
		
		JLabel lbddd = new JLabel("*DDD");
		lbddd.setFont(new Font("Calibri", Font.PLAIN, 16));
		lbddd.setBounds(160, 575, 120, 25);
		frame.getContentPane().add(lbddd);
		
		JLabel lbtelefone = new JLabel("*Celular");
		lbtelefone.setFont(new Font("Calibri", Font.PLAIN, 16));
		lbtelefone.setBounds(423, 575, 120, 25);
		frame.getContentPane().add(lbtelefone);
		
		JLabel lbemail = new JLabel("*email");
		lbemail.setFont(new Font("Calibri", Font.PLAIN, 16));
		lbemail.setBounds(160, 615, 120, 25);
		frame.getContentPane().add(lbemail);
		
		txtcpf = new JTextField();
		txtcpf.setFont(new Font("Calibri", Font.PLAIN, 16));
		txtcpf.setBounds(281, 123, 252, 25);
		frame.getContentPane().add(txtcpf);
		txtcpf.setColumns(10);
		
		txtnome = new JTextField();
		txtnome.setFont(new Font("Calibri", Font.PLAIN, 16));
		txtnome.setBounds(281, 165, 387, 25);
		frame.getContentPane().add(txtnome);
		txtnome.setColumns(10);
		
		txtrg = new JTextField();
		txtrg.setFont(new Font("Calibri", Font.PLAIN, 16));
		txtrg.setColumns(10);
		txtrg.setBounds(281, 200, 387, 25);
		frame.getContentPane().add(txtrg);
		
		txtdn = new JTextField();
		txtdn.setFont(new Font("Calibri", Font.PLAIN, 16));
		txtdn.setColumns(10);
		txtdn.setBounds(281, 240, 120, 25);
		frame.getContentPane().add(txtdn);
		
		txtnresid = new JTextField();
		txtnresid.setFont(new Font("Calibri", Font.PLAIN, 16));
		txtnresid.setColumns(10);
		txtnresid.setBounds(281, 385, 120, 25);
		frame.getContentPane().add(txtnresid);
		
		txtcompresid = new JTextField();
		txtcompresid.setFont(new Font("Calibri", Font.PLAIN, 16));
		txtcompresid.setColumns(10);
		txtcompresid.setBounds(548, 385, 120, 25);
		frame.getContentPane().add(txtcompresid);
		
		txtbairro = new JTextField();
		txtbairro.setFont(new Font("Calibri", Font.PLAIN, 16));
		txtbairro.setColumns(10);
		txtbairro.setBounds(281, 420, 120, 25);
		frame.getContentPane().add(txtbairro);
		
		txtcidade = new JTextField();
		txtcidade.setFont(new Font("Calibri", Font.PLAIN, 16));
		txtcidade.setColumns(10);
		txtcidade.setBounds(548, 420, 120, 25);
		frame.getContentPane().add(txtcidade);
		
		txtcep = new JTextField();
		txtcep.setFont(new Font("Calibri", Font.PLAIN, 16));
		txtcep.setColumns(10);
		txtcep.setBounds(281, 455, 120, 25);
		frame.getContentPane().add(txtcep);
		
		txtbanco = new JTextField();
		txtbanco.setFont(new Font("Calibri", Font.PLAIN, 16));
		txtbanco.setColumns(10);
		txtbanco.setBounds(281, 495, 120, 25);
		frame.getContentPane().add(txtbanco);
		
		txtagencia = new JTextField();
		txtagencia.setFont(new Font("Calibri", Font.PLAIN, 16));
		txtagencia.setColumns(10);
		txtagencia.setBounds(548, 495, 120, 25);
		frame.getContentPane().add(txtagencia);
		
		txtconta = new JTextField();
		txtconta.setFont(new Font("Calibri", Font.PLAIN, 16));
		txtconta.setColumns(10);
		txtconta.setBounds(281, 535, 120, 25);
		frame.getContentPane().add(txtconta);
		
		txtdv = new JTextField();
		txtdv.setFont(new Font("Calibri", Font.PLAIN, 16));
		txtdv.setColumns(10);
		txtdv.setBounds(548, 535, 120, 25);
		frame.getContentPane().add(txtdv);
		
		txtmae = new JTextField();
		txtmae.setFont(new Font("Calibri", Font.PLAIN, 16));
		txtmae.setColumns(10);
		txtmae.setBounds(281, 280, 387, 25);
		frame.getContentPane().add(txtmae);
		
		txtrua = new JTextField();
		txtrua.setFont(new Font("Calibri", Font.PLAIN, 16));
		txtrua.setColumns(10);
		txtrua.setBounds(281, 350, 387, 25);
		frame.getContentPane().add(txtrua);
		
		txtemail = new JTextField();
		txtemail.setFont(new Font("Calibri", Font.PLAIN, 16));
		txtemail.setColumns(10);
		txtemail.setBounds(281, 615, 387, 25);
		frame.getContentPane().add(txtemail);
		
		txtddd = new JTextField();
		txtddd.setFont(new Font("Calibri", Font.PLAIN, 16));
		txtddd.setColumns(10);
		txtddd.setBounds(281, 575, 120, 25);
		frame.getContentPane().add(txtddd);
		
		txttelefone = new JTextField();
		txttelefone.setFont(new Font("Calibri", Font.PLAIN, 16));
		txttelefone.setColumns(10);
		txttelefone.setBounds(548, 575, 120, 25);
		frame.getContentPane().add(txttelefone);
		
		JLabel lbcargo = new JLabel("Cargo");
		lbcargo.setFont(new Font("Calibri", Font.PLAIN, 16));
		lbcargo.setBounds(160, 650, 120, 30);
		frame.getContentPane().add(lbcargo);
		
		JLabel lbadmissao = new JLabel("Data admissao");
		lbadmissao.setFont(new Font("Calibri", Font.PLAIN, 16));
		lbadmissao.setBounds(423, 650, 120, 25);
		frame.getContentPane().add(lbadmissao);
		
		JComboBox<Cargo> comboCargo = new JComboBox<Cargo>();
		comboCargo.setFont(new Font("Calibri", Font.PLAIN, 16));
		
		
		comboCargo.addItem(new Cargo("4277", "Administrador de empresas"));
		comboCargo.addItem(new Cargo("4171", "Advogado"));
		comboCargo.addItem(new Cargo("4270", "Aeronauta, Aeroviário"));
		comboCargo.addItem(new Cargo("4199", "Agente e viagem"));
		comboCargo.addItem(new Cargo("4182", "Agente financeiro"));
		comboCargo.addItem(new Cargo("4266", "Agronomo"));
		comboCargo.addItem(new Cargo("4267", "Arquiteto, Decorador"));
		comboCargo.addItem(new Cargo("4184", "Atleta, esportista, treinador e árbitro"));
		comboCargo.addItem(new Cargo("4195", "Auxiliar administrativo"));
		comboCargo.addItem(new Cargo("4258", "bombeiro"));
		comboCargo.addItem(new Cargo("4284", "Funcionário do poder judiciário"));
		comboCargo.addItem(new Cargo("4283", "Funcionário do poder legislativo"));
		comboCargo.addItem(new Cargo("4175", "Jornalista"));
		comboCargo.addItem(new Cargo("4203", "Mecânico de motores, máq. e equipamentos"));
		comboCargo.addItem(new Cargo("4155", "Médico"));
		comboCargo.addItem(new Cargo("4178", "Membro das forças armadas"));
		comboCargo.addItem(new Cargo("4194", "Motorista"));
		comboCargo.addItem(new Cargo("4156", "Odontologista"));
		comboCargo.addItem(new Cargo("4197", "Operador de máq. e equipamentos"));
		comboCargo.addItem(new Cargo("4205", "Operador de telemarketing"));
		comboCargo.addItem(new Cargo("4166", "Caixa"));
		comboCargo.addItem(new Cargo("4202", "Operário construção, mecânico, elétrico"));
		comboCargo.addItem(new Cargo("4235", "Carregador"));
		comboCargo.addItem(new Cargo("4210", "Outras profissões"));
		comboCargo.addItem(new Cargo("4165", "Comerciante"));
		comboCargo.addItem(new Cargo("4276", "Pecuarista"));
		comboCargo.addItem(new Cargo("4269", "Corretor"));
		comboCargo.addItem(new Cargo("4154", "Produtor cênico"));
		comboCargo.addItem(new Cargo("4272", "Desenhista, Designer"));
		comboCargo.addItem(new Cargo("4257", "Policial"));
		comboCargo.addItem(new Cargo("4144", "Diretor de empresa"));
		comboCargo.addItem(new Cargo("4275", "Produtor Rural"));
		comboCargo.addItem(new Cargo("4172", "Economista"));
		comboCargo.addItem(new Cargo("4163", "Professor, Pedagogo"));
		comboCargo.addItem(new Cargo("4206", "Empregado Doméstico"));
		comboCargo.addItem(new Cargo("4192", "Profissional de limpeza ou segurança"));
		comboCargo.addItem(new Cargo("4140", "Empresário"));
		comboCargo.addItem(new Cargo("4193", "Profissional da arte, publicidade ou moda"));
		comboCargo.addItem(new Cargo("4201", "Encarregado geral"));
		comboCargo.addItem(new Cargo("4189", "Profissional do agronegócio"));
		comboCargo.addItem(new Cargo("4157", "Enfermeiro"));
		comboCargo.addItem(new Cargo("4250", "Profissional do ramo alimentar"));
		comboCargo.addItem(new Cargo("4153", "Engenheiro"));
		comboCargo.addItem(new Cargo("4253", "Profissional da saúde"));
		comboCargo.addItem(new Cargo("4242", "Entregadores, operadores de logística"));
		comboCargo.addItem(new Cargo("4263", "Psicólogo"));
		comboCargo.addItem(new Cargo("4191", "Esteticista"));
		comboCargo.addItem(new Cargo("4237", "Recepcionista, Secretária"));
		comboCargo.addItem(new Cargo("4158", "Farmacêutico"));
		comboCargo.addItem(new Cargo("4148", "Supervisor"));
		comboCargo.addItem(new Cargo("4188", "Fazendeiro"));
		comboCargo.addItem(new Cargo("4164", "Vendedor"));
		comboCargo.addItem(new Cargo("4152", "Funcionário do poder executivo"));
		comboCargo.addItem(new Cargo("4159", "Veterinário, Zootecnista"));
		comboCargo.setBounds(281, 650, 120, 25);
		frame.getContentPane().add(comboCargo);
		
		txtadmissao = new JTextField();
		txtadmissao.setFont(new Font("Calibri", Font.PLAIN, 16));
		txtadmissao.setColumns(10);
		txtadmissao.setBounds(548, 650, 120, 25);
		frame.getContentPane().add(txtadmissao);
		
		JButton btnGravar = new JButton("Gravar");
		btnGravar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					
					if (!FopagUtils.isCPFValido(txtcpf.getText())) {
						JOptionPane.showMessageDialog(null, "CPF inválido", "Dados inválidos", JOptionPane.ERROR_MESSAGE);
						return;
					}
					
		            String query = "INSERT INTO `fopagdb`.`cadastrotb`\n" +  // Aqui inicia a Query de cadastro
		            "(`nome`,\n" +
		            "`cpf`,\n" +
		            "`banco`,\n" +
		            "`agencia`,\n" +
		            "`conta`,\n" +
		            "`rua`,\n" +
		            "`bairro`,\n" +
		            "`cidade`,\n" +
		            "`estado`,\n" +
		            "`cep`,\n"+
		            "`ufnasc`,\n" +
		            "`rg`,\n" +
		            "`dn`,\n" +
		            "`sexo`,\n" +
		            "`civil`,\n" +
		            "`mae`,\n" +
		            "`ddd`,\n" +
		            "`telefone`,\n" +
		            "`nresid`,\n" +
		            "`compresid`,\n" +
		            "`email`,\n" +
		            "`salario`,\n" +
		            "`admissao`,\n" +
		            "`cargo`,\n" +
		            "`dv`)\n" +
		            "VALUES\n" +
		            "('" + txtnome.getText() + "',\n" +
		            "'" + txtcpf.getText() + "',\n" +
		            "'" + txtbanco.getText() + "',\n" +
		            "'" + txtagencia.getText() + "',\n" +
		            "'" + txtconta.getText() + "',\n" +
		            "'" + txtrua.getText() + "',\n" +
		            "'" + txtbairro.getText() + "',\n" +
		            "'" + txtcidade.getText() + "',\n" +
		            "'" + comboEstado.getSelectedItem().toString() + "',\n" +
		            "'" + txtcep.getText() + "',\n" +
		            "'" + comboUf.getSelectedItem().toString() + "',\n" +
		            "'" + txtrg.getText() + "',\n" +
		            "'" + txtdn.getText() + "',\n" +
		            "'" + ((Sexo) comboSexo.getSelectedItem()).getKey() + "',\n" +
		            "'" + ((Civil) comboCivil.getSelectedItem()).getKey() + "',\n" +
		            "'" + txtmae.getText() + "',\n" +
		            "'" + txtddd.getText() + "',\n" +
		            "'" + txttelefone.getText() + "',\n" +
		            "'" + txtnresid.getText() + "',\n" +
		            "'" + txtcompresid.getText() + "',\n" +
		            "'" + txtemail.getText() + "',\n" +
		            "'" + txtsalario.getText() + "',\n" +
		            "'" + txtadmissao.getText() + "',\n" +
		            "'" + ((Cargo) comboCargo.getSelectedItem()).getKey() + "',\n" +
		            "'" + txtdv.getText() + "')";
		            
		            System.out.println(query);
		            
					Fopag.connection.insertData(query);
					JOptionPane.showMessageDialog(btnGravar, "Opa... Tudo certo até aqui!!!.");
				}
				catch (SQLException ex)
				{
					JOptionPane.showMessageDialog(btnGravar, "Hum... algo deu errado!!!");
					
	            ex.printStackTrace();
				}
					
				  	txtnome.setText("");  // Criei todos os campos
				  	txtcpf.setText("");   // Verificar onde adicionar 
				  	txtbanco.setText(""); 
				  	txtagencia.setText("");
				  	txtconta.setText("");
				  	txtrua.setText("");
				  	txtbairro.setText("");
				  	txtcidade.setText("");
				  	comboEstado.getSelectedItem();
				  	txtcep.setText("");
				  	comboUf.getSelectedItem();
				  	txtrg.setText("");
				  	txtdn.setText("");
				  	comboSexo.getSelectedItem();
				  	comboCivil.getSelectedItem();
				  	txtmae.setText("");
				  	txtddd.setText("");
				  	txttelefone.setText("");
				  	txtnresid.setText("");
				  	txtcompresid.setText("");
				  	txtemail.setText("");
				  	txtsalario.setText("");
				  	txtadmissao.setText("");
				  	comboCargo.getSelectedItem();
				  	txtdv.setText("");
				  	
			}
		});
		btnGravar.setFont(new Font("Calibri", Font.PLAIN, 16));
		btnGravar.setBounds(15, 122, 120, 30);
		frame.getContentPane().add(btnGravar);
		
		JLabel lblNewLabel = new JLabel("Inserir  apenas  n\u00FAmeros");
		lblNewLabel.setFont(new Font("Calibri", Font.PLAIN, 10));
		lblNewLabel.setBounds(281, 151, 252, 10);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Inserir  apenas  n\u00FAmeros");
		lblNewLabel_1.setFont(new Font("Calibri", Font.PLAIN, 10));
		lblNewLabel_1.setBounds(281, 226, 387, 10);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Inserir  apenas  n\u00FAmeros");
		lblNewLabel_1_1.setFont(new Font("Calibri", Font.PLAIN, 10));
		lblNewLabel_1_1.setBounds(281, 482, 120, 10);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Inserir  apenas  n\u00FAmeros");
		lblNewLabel_1_1_1.setFont(new Font("Calibri", Font.PLAIN, 11));
		lblNewLabel_1_1_1.setBounds(281, 561, 120, 13);
		frame.getContentPane().add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Inserir  apenas  n\u00FAmeros");
		lblNewLabel_1_1_2.setFont(new Font("Calibri", Font.PLAIN, 10));
		lblNewLabel_1_1_2.setBounds(548, 522, 120, 10);
		frame.getContentPane().add(lblNewLabel_1_1_2);
		
		JLabel lblNewLabel_1_1_3 = new JLabel("Inserir  apenas  n\u00FAmeros");
		lblNewLabel_1_1_3.setFont(new Font("Calibri", Font.PLAIN, 11));
		lblNewLabel_1_1_3.setBounds(548, 561, 120, 13);
		frame.getContentPane().add(lblNewLabel_1_1_3);
		
		JLabel lblNewLabel_1_1_4 = new JLabel("Inserir  apenas  n\u00FAmeros");
		lblNewLabel_1_1_4.setFont(new Font("Calibri", Font.PLAIN, 11));
		lblNewLabel_1_1_4.setBounds(548, 600, 120, 13);
		frame.getContentPane().add(lblNewLabel_1_1_4);
		
		JLabel lblNewLabel_1_1_5 = new JLabel("Inserir  apenas  n\u00FAmeros");
		lblNewLabel_1_1_5.setFont(new Font("Calibri", Font.PLAIN, 11));
		lblNewLabel_1_1_5.setBounds(281, 600, 120, 13);
		frame.getContentPane().add(lblNewLabel_1_1_5);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Ex.: DDMMAAAA");
		lblNewLabel_1_1_1_1.setFont(new Font("Calibri", Font.PLAIN, 10));
		lblNewLabel_1_1_1_1.setBounds(281, 267, 120, 10);
		frame.getContentPane().add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Ex.: DDMMAAAA");
		lblNewLabel_1_1_1_1_1.setFont(new Font("Calibri", Font.PLAIN, 11));
		lblNewLabel_1_1_1_1_1.setBounds(548, 676, 120, 13);
		frame.getContentPane().add(lblNewLabel_1_1_1_1_1);
		
		JLabel lssalario = new JLabel("Renda");
		lssalario.setFont(new Font("Calibri", Font.PLAIN, 16));
		lssalario.setBounds(160, 690, 120, 25);
		frame.getContentPane().add(lssalario);
		
		txtsalario = new JTextField();
		txtsalario.setFont(new Font("Calibri", Font.PLAIN, 16));
		txtsalario.setBounds(281, 690, 120, 25);
		frame.getContentPane().add(txtsalario);
		txtsalario.setColumns(10);
	}
}
