import java.awt.EventQueue;

import javax.swing.JFrame;

public class Envio_Pagamento {

	private JFrame frame;

	/**
	 * OriginalApp
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Envio_Pagamento window = new Envio_Pagamento();
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
	public Envio_Pagamento() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 700, 780);
	}

}
