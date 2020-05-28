import java.awt.Component;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class Febraban {

	private JFrame frame;
	JLabel figura;
	BufferedImage imagem;
	JLabel rotulo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Febraban window = new Febraban();
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
	public Febraban() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
//		 JPanel painel = new JPanel();
//	        painel.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
//	         
//	        try
//	        {
//	            imagem = ImageIO.read(new File("./Imagens/ManualCNAB/ManualCnab.png"));     
//	        }
//	        catch ( IOException e)
//	        {           
//	            e.printStackTrace();
//	        }
//	         
//	        ImageIcon fig = new ImageIcon(imagem);
//	        painel.setLayout(null);
//	        
//	        figura = new JLabel(fig);
//	        figura.setDisplayedMnemonic(KeyEvent.VK_PASTE);
//	        figura.setBounds(115, 49, 440, 332);
//	        painel.add(figura);
//      	  figura.setAlignmentX(Component.CENTER_ALIGNMENT);
		frame = new JFrame();
		frame.setContentPane(criaPainel());
		frame.setSize(700,780);
        frame.setVisible(true);
		
		
//		JPanel panel = new JPanel();
//        panel.setAutoscrolls(true);
//        panel.setBounds(0, 0, 690, 725);
//        painel.add(panel);
//        panel.setLayout(null);
//		frame.getContentPane().add(panel);
//		
//		JScrollPane scrollPane = new JScrollPane();
//		scrollPane.setBounds(0, 0, 690, 725);
//		panel.add(scrollPane);
	}
	
	public Container criaPainel()
    {
    	
 
        JPanel painel = new JPanel();
        painel.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
         
        try
        {
            imagem = ImageIO.read(new File("./Imagens/ManualCNAB/ManualCnab.png"));     
        }
        catch ( IOException e)
        {           
            e.printStackTrace();
        }
         
        ImageIcon fig = new ImageIcon(imagem);
        painel.setLayout(null);
        
        JPanel panel = new JPanel();
        panel.setAutoscrolls(true);
        panel.setBounds(0, 0, 690, 725);
        painel.add(panel);
        panel.setLayout(null);
        
        rotulo = new JLabel("Manual CNAB240");
        rotulo.setBounds(237, 16, 123, 20);
        panel.add(rotulo);
        
        rotulo.setAlignmentX(Component.CENTER_ALIGNMENT);
//        figura = new JLabel(new ImageIcon("C:\\Users\\Rafael Cruz\\eclipse-workspace\\Fopag\\src\\main\\resources\\ManualCNAB\\ManualCnab.png"));
        figura = new JLabel();
        figura.setIcon(new ImageIcon(Febraban.class.getResource("/imagens/ManualCnab.png")));
        figura.setDisplayedMnemonic(KeyEvent.VK_PASTE);
        figura.setBounds(115, 49, 440, 332);
        panel.add(figura);
        figura.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        JScrollPane scrollPane = new JScrollPane(figura);
        scrollPane.setBounds(0, 0, 690, 725);
        panel.add(scrollPane);
         
        return painel;
    }

}
