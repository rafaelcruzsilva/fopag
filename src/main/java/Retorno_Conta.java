import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;

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
		rdbtnRemessaconta.setSelected(true);
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
		
		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(rdbtnRemessaconta);
		buttonGroup.add(rdbtnArquivosalario);
		buttonGroup.add(rdbtnOutrospagamentos);
		
		JButton btnImportar = new JButton("Importar Arquivo");
		btnImportar.setBounds(378, 313, 233, 29);
		frame.getContentPane().add(btnImportar);
		
		btnImportar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				final JFileChooser fileChooser = new JFileChooser();
				final FileNameExtensionFilter fileChooserFilter = new FileNameExtensionFilter("Somente arquivo .txt", "txt");
				fileChooser.setFileFilter(fileChooserFilter);
				final Integer fileChooserOption = fileChooser.showOpenDialog(frame);
				
				if (fileChooserOption != JFileChooser.APPROVE_OPTION) {
					JOptionPane.showMessageDialog(null, "Arquivo invalido", "Erro", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				final List<String> linhas = FopagUtils.retornarLinhasArquivo(fileChooser.getSelectedFile().getPath());
				
			    final List<Cnab> cnabs = new ArrayList<Cnab>();
			    
			    Cnab cnab = null;
			    
			    for (Integer contador = 0; contador <= linhas.size(); contador++) {
			    	
			    	if (contador < 2 || contador > (linhas.size() - 2)) {
			    		continue;
			    	}
			    	
			    	if (contador % 2 == 0) {
			    		cnab = new Cnab();
			    		cnab.setNomeColaborador(linhas.get(contador).substring(105, 132));
			    		cnab.setTipoRetorno(linhas.get(contador).substring(230, 232));
			    		continue;
			    	}
			    	
			    	cnab.setDigitoVerificador(linhas.get(contador).substring(229, 230));
			    	cnab.setNumeroConta(linhas.get(contador).substring(217, 229));		    	
			    	
			    	cnabs.add(cnab);
			    	
			    	System.out.println(cnab);
			    }
			    
			    if (cnabs != null && cnabs.size() > 0) {
			    	
			    	final StringBuilder sb = new StringBuilder();
			    	
			    	sb.append("INSERT INTO NOME_DA_TABELA(nome_colaborador, tipo_retorno, digito_verificador, numero_conta)");
			    	
			    	sb.append("VALUES");
			    	
			    	for (int i = 0; i < cnabs.size(); i++) {
			    		String insert = String.format("('%s', '%s', '%s', '%s')", cnabs.get(i).getNomeColaborador().trim(), cnabs.get(i).getTipoRetorno().trim(), cnabs.get(i).getDigitoVerificador().trim(), cnabs.get(i).getNumeroConta().trim());			    		
			    		sb.append(insert);
			    		sb.append(i < (cnabs.size() - 1) ? "," : ";");
			    	}
			    	
			    	System.out.println(sb.toString());
			    }
				
			}
		});

	}		
}
