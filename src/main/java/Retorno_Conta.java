import java.awt.EventQueue;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JRadioButton;

public class Retorno_Conta {

	private JFrame frmRetornodeArquivosDe;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Retorno_Conta window = new Retorno_Conta();
					window.frmRetornodeArquivosDe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * OriginalApp
	 */
	public Retorno_Conta() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmRetornodeArquivosDe = new JFrame();
		frmRetornodeArquivosDe.setTitle("Retornode Arquivos de Remessa - Banco Original");
		frmRetornodeArquivosDe.setBounds(100, 100, 660, 780);
		frmRetornodeArquivosDe.getContentPane().setLayout(null);
		
		JLabel lblRetornoDeArquivos = new JLabel("Retorno de Arquivos de Remessa");
		lblRetornoDeArquivos.setBounds(5, 5, 630, 60);
		lblRetornoDeArquivos.setHorizontalAlignment(SwingConstants.CENTER);
		lblRetornoDeArquivos.setFont(new Font("Calibri", Font.PLAIN, 25));
		frmRetornodeArquivosDe.getContentPane().add(lblRetornoDeArquivos);
		
		JRadioButton rdbtnRemessaconta = new JRadioButton("Importar Arquivo de Remessa de Abertura de Conta Sal\u00E1rio");
		rdbtnRemessaconta.setBounds(28, 123, 474, 29);
		frmRetornodeArquivosDe.getContentPane().add(rdbtnRemessaconta);
		
		JRadioButton rdbtnArquivosalario = new JRadioButton("Importar Arquivo de Remessa de Pagamento de Sal\u00E1rios");
		rdbtnArquivosalario.setBounds(28, 176, 455, 29);
		frmRetornodeArquivosDe.getContentPane().add(rdbtnArquivosalario);
		
		JRadioButton rdbtnOutrospagamentos = new JRadioButton("Outros Pagamentos");
		rdbtnOutrospagamentos.setBounds(28, 228, 455, 29);
		frmRetornodeArquivosDe.getContentPane().add(rdbtnOutrospagamentos);
		
		JButton btnImportararquivo = new JButton("Importar Arquivo");
		btnImportararquivo.setBounds(321, 326, 302, 29);
		frmRetornodeArquivosDe.getContentPane().add(btnImportararquivo);
		
		
		 
//		public class Retorno_Conta {
//			public static void main(String[] args) {		
				Scanner scanner = null;
				try {
					scanner = new Scanner(new FileReader("cantores.txt")).useDelimiter("\n");
					while (scanner.hasNext()) {
						String nome = scanner.next();
						System.out.println(nome);				
					}
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					System.out.println("ERRO: O arquivo não pôde ser lido!");
					e.printStackTrace();
				} finally {
					scanner.close();
				}		
			}
	}

//}
