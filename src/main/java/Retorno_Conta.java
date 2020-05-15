import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.ResultSet;
import java.util.Date;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.apache.commons.lang3.StringUtils;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class Retorno_Conta {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Retorno_Conta window = new Retorno_Conta();
					window.frame.setVisible(true);
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
		frame = new JFrame();
		frame.setTitle("Retornode Arquivos de Remessa - Banco Original");
		frame.setBounds(100, 100, 660, 780);
		frame.getContentPane().setLayout(null);
		
		JLabel lblRetornoDeArquivos = new JLabel("Retorno de Arquivos de Remessa");
		lblRetornoDeArquivos.setBounds(5, 5, 630, 60);
		lblRetornoDeArquivos.setHorizontalAlignment(SwingConstants.CENTER);
		lblRetornoDeArquivos.setFont(new Font("Calibri", Font.PLAIN, 25));
		frame.getContentPane().add(lblRetornoDeArquivos);
		
		JRadioButton rdbtnRemessaconta = new JRadioButton("Importar Arquivo de Remessa de Abertura de Conta Sal\u00E1rio");
		rdbtnRemessaconta.setBounds(28, 123, 474, 29);
		frame.getContentPane().add(rdbtnRemessaconta);
		
		JRadioButton rdbtnArquivosalario = new JRadioButton("Importar Arquivo de Remessa de Pagamento de Sal\u00E1rios");
		rdbtnArquivosalario.setBounds(28, 176, 455, 29);
		frame.getContentPane().add(rdbtnArquivosalario);
		
		JRadioButton rdbtnOutrospagamentos = new JRadioButton("Outros Pagamentos");
		rdbtnOutrospagamentos.setBounds(28, 228, 455, 29);
		frame.getContentPane().add(rdbtnOutrospagamentos);
		
		JTextArea txtArea = new JTextArea();
		txtArea.setBounds(15, 572, 262, 136);
		frame.getContentPane().add(txtArea);
		
		JButton btnImportar = new JButton("Importar Arquivo");
		btnImportar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int returnVal = fileChooser.showOpenDialog(this);
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    File file = fileChooser.getSelectedFile();
                    try {
                      // What to do with the file, e.g. display it in a TextArea
                      txtArea.read( new FileReader( file.getAbsolutePath() ), null );
                    } catch (IOException ex) {
                      System.out.println("problem accessing file"+file.getAbsolutePath());
                    }
                } else {
                    System.out.println("File access cancelled by user.");
                }
				
				
				
				
				
//		            }
//		                textArea.setText(contentBuilder.toString());  Incluir o leitor de linhas
//		            }
	
				
		}
	});
		btnImportar.setBounds(378, 313, 233, 29);
		frame.getContentPane().add(btnImportar);
		
		
		
		
//				try {
//					
//					final JFileChooser fileChooser = new JFileChooser();					
//					fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
//					final Integer directoryOption = fileChooser.showOpenDialog(frame);
//					
//					if (directoryOption != JFileChooser.APPROVE_OPTION) {
//						JOptionPane.showMessageDialog(null, "Diretorio invalido", "Erro", JOptionPane.ERROR_MESSAGE);
//						return;
//					}
//					
//					if (!rdbtnRemessaconta.isSelected() && !FopagUtils.isDataValida(txtData.getText())) {
//						JOptionPane.showMessageDialog(null, "Data invalida", "Erro", JOptionPane.ERROR_MESSAGE);
//						return;
//					}
//					
//					final String nomeArquivo = String.format("TCSYS_REMESSAPAGAMENTO_%s%s%s.txt", DATE_FORMAT_US.format(new Date()), "3224", "1");
//					
//					final File file = new File(fileChooser.getSelectedFile(), nomeArquivo);
//					
//					final String dataConsulta = rdbtnDataatual.isSelected() ? DATE_FORMAT_BR.format(new Date()) : FopagUtils.getSomenteDigitos(txtData.getText());
//					
//					System.out.println("Chamando consulta");
//					
//					String query = String.format("SELECT * FROM fopagdb.pagamentostb WHERE data LIKE '%s'", dataConsulta);
//					
//					System.out.println(query);
//					
//					ResultSet resultado = Fopag.connection.getData(query);
//					 	
//					 	fileWriter.write("\r\n");
//					 }
//					 
//					fileWriter.close();
//			    }
//			    catch (Exception ex) {
//				    ex.printStackTrace();
//				    JOptionPane.showMessageDialog(null, "Erro ao gerar arquivo", "Erro", JOptionPane.ERROR_MESSAGE);
//				    return;
//				}
//
//				JOptionPane.showMessageDialog(null, "Processamento concluido!", "Sucesso", JOptionPane.DEFAULT_OPTION);
//				
//			}
//		});
//
//				
//			}
//		});
//		btnImportararquivo.setBounds(321, 326, 302, 29);
//		frmRetornodeArquivosDe.getContentPane().add(btnImportararquivo);
		
		
	}		
}
