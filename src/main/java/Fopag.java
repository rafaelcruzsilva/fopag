import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import javax.swing.JLabel;

public class Fopag {

	private JFrame frmFolhaDePagamento;
	public static SQLConnection connection;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		try
		{
			connection = new SQLConnection();
			connection.connect("jdbc:mysql://localhost:3306/fopagdb?useTimezone=true&serverTimezone=UTC", "root", "Mudar123");
		}
		catch (SQLException | ClassNotFoundException ex)
		{
			ex.printStackTrace();
		}
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Fopag window = new Fopag();
					window.frmFolhaDePagamento.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Fopag() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmFolhaDePagamento = new JFrame();
		frmFolhaDePagamento.setTitle("Folha de Pagamento - OriginalApp");
		frmFolhaDePagamento.setBounds(100, 100, 700, 780);
		frmFolhaDePagamento.getContentPane().setLayout(null);
		
		JLabel jldata = new JLabel("");
		jldata.setFont(new Font("Calibri", Font.PLAIN, 18));
		jldata.setBounds(578, 753, 100, 30);
		frmFolhaDePagamento.getContentPane().add(jldata);
		
		JMenuBar menuBar = new JMenuBar();
		frmFolhaDePagamento.setJMenuBar(menuBar);
		
		JMenu MenuArquivo = new JMenu("Iniciar");
		MenuArquivo.setFont(new Font("Calibri", Font.PLAIN, 16));
		menuBar.add(MenuArquivo);
		
		JMenuItem ItemColaborador = new JMenuItem("Inserir Colaborador");
		ItemColaborador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InsColaborador insColaborador = new InsColaborador();
				insColaborador.frame.setVisible(true);
			}
		});
		ItemColaborador.setFont(new Font("Calibri", Font.PLAIN, 16));
		MenuArquivo.add(ItemColaborador);
		
		JMenuItem ItemEmpresa = new JMenuItem("Inserir Empresa");
		ItemEmpresa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				InsEmpresa insEmpresa = new InsEmpresa();
				insEmpresa.frame.setVisible(true);
			}
		});
		ItemEmpresa.setFont(new Font("Calibri", Font.PLAIN, 16));
		MenuArquivo.add(ItemEmpresa);
		
		JMenuItem ItemImprimir = new JMenuItem("Imprimir");
		ItemImprimir.setFont(new Font("Calibri", Font.PLAIN, 16));
		MenuArquivo.add(ItemImprimir);
		
		JMenuItem ItemSair = new JMenuItem("Sair");
		ItemSair.setFont(new Font("Calibri", Font.PLAIN, 16));
		MenuArquivo.add(ItemSair);
		
		JMenu MenuRemessa = new JMenu("Remessa");
		MenuRemessa.setFont(new Font("Calibri", Font.PLAIN, 16));
		menuBar.add(MenuRemessa);
		
		JMenuItem ItemRemConta = new JMenuItem("Gerar remessa abertura de conta");
		ItemRemConta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Abertura_Conta abertura_conta = new Abertura_Conta();
				abertura_conta.frame.setVisible(true);
			}
		});
		ItemRemConta.setFont(new Font("Calibri", Font.PLAIN, 16));
		MenuRemessa.add(ItemRemConta);
		
		JMenuItem ItemRemPagto = new JMenuItem("Gerar remessa folha de Pagto");
		ItemRemPagto.setFont(new Font("Calibri", Font.PLAIN, 16));
		MenuRemessa.add(ItemRemPagto);
		
		JMenuItem ItemRemRetorno = new JMenuItem("Retorno de remessa");
		ItemRemRetorno.setFont(new Font("Calibri", Font.PLAIN, 16));
		MenuRemessa.add(ItemRemRetorno);
		
		JMenu MenuEnvio = new JMenu("Envio de arquivos");
		MenuEnvio.setFont(new Font("Calibri", Font.PLAIN, 16));
		menuBar.add(MenuEnvio);
		
		JMenuItem EnvioConta = new JMenuItem("Abertura de conta");
		EnvioConta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Gera_Conta gera_conta = new Gera_Conta();
				gera_conta.frame.setVisible(true);
			}
		});
		EnvioConta.setFont(new Font("Calibri", Font.PLAIN, 16));
		MenuEnvio.add(EnvioConta);
		
		JMenuItem EnvioPagto = new JMenuItem("Folha de pagamento");
		EnvioPagto.setFont(new Font("Calibri", Font.PLAIN, 16));
		MenuEnvio.add(EnvioPagto);
		
		JMenu MenuAjuda = new JMenu("Ajuda");
		MenuAjuda.setFont(new Font("Calibri", Font.PLAIN, 16));
		menuBar.add(MenuAjuda);
		
		JMenuItem ItemContatos = new JMenuItem("Contatos");
		ItemContatos.setFont(new Font("Calibri", Font.PLAIN, 16));
		MenuAjuda.add(ItemContatos);
		
		JMenuItem ItemDocumentacao = new JMenuItem("Documenta\u00E7\u00E3o");
		ItemDocumentacao.setFont(new Font("Calibri", Font.PLAIN, 16));
		MenuAjuda.add(ItemDocumentacao);
		
		JMenuItem ItemSobre = new JMenuItem("Sobre");
		ItemSobre.setFont(new Font("Calibri", Font.PLAIN, 16));
		MenuAjuda.add(ItemSobre);
	}
}
