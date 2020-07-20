import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class WebsiteListWindow extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4645964253808456953L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WebsiteListWindow frame = new WebsiteListWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public WebsiteListWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 414, 200);
		contentPane.add(scrollPane);
		
		JTextArea jTextArea = new JTextArea();
		try {
			
			jTextArea.read(new FileReader("websites_list.txt"), null);
			
		} catch (IOException e) {
			
			e.printStackTrace();
			
		}
		scrollPane.setViewportView(jTextArea);
		
		JButton btnNewButton = new JButton("Save & Exit");
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent event) {
				
				try {
					
					jTextArea.write(new FileWriter("websites_list.txt"));
					
				} catch (IOException e) {
					
					e.printStackTrace();
					
				}
				dispose();
				
			}
			
		});
		btnNewButton.setBounds(10, 227, 130, 23);
		contentPane.add(btnNewButton);
		setLocationRelativeTo(null);
		
	}
	
}
