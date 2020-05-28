import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Retorno_Conta {

	public JFrame frame;

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

	private void initialize() {
		
		frame = new JFrame();
		frame.setTitle("Retorno de Arquivos de Remessa - Banco Original");
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
			    		cnab.setNomeColaborador(linhas.get(contador).substring(15, 45));
			    		cnab.setcpf(linhas.get(contador).substring(55, 66));
			    		cnab.setTipoRetorno(linhas.get(contador).substring(230, 232));
			    		continue;
			    	}
			    	cnab.setNumeroAgencia(linhas.get(contador).substring(211, 216));
			    	cnab.setDigitoVerificador(linhas.get(contador).substring(229, 230));
			    	cnab.setNumeroConta(linhas.get(contador).substring(217, 229));		    	
			    	
			    	cnabs.add(cnab);
			    	
			    	System.out.println(cnab);
			    }
			    
			    if (cnabs != null && cnabs.size() > 0) {
			    	
			    	final StringBuilder sb = new StringBuilder();
			    	
			    	
			    	for (int i = 0; i < cnabs.size(); i++) {
			    		sb.append("UPDATE fopagdb.cadastrotb SET agencia = '" + cnabs.get(i).getNumeroAgencia().trim() + "', conta = '" + cnabs.get(i).getNumeroConta().trim() + "', dv = '" + cnabs.get(i).getDigitoVerificador().trim() + "' WHERE cpf = '" + cnabs.get(i).getcpf().trim() + "'");
			    		
			    		try
			    		{
			    			Fopag.connection.insertData(sb.toString());
			    		}
			    		catch (SQLException ex)
			    		{
			    			ex.printStackTrace();
			    		}
			    		System.out.println(sb.toString());
			    	}
			    	
			    }
			}
		});

	}		
}
