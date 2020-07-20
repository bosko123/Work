import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TimerWindow extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			
			public void run() {
				
				try {
					
					TimerWindow frame = new TimerWindow();
					Toolkit toolkit = Toolkit.getDefaultToolkit();
					int width = frame.getWidth();
					int height = frame.getHeight();
					
					int x = (toolkit.getScreenSize().width - width) / 2;
					int y = (toolkit.getScreenSize().height - height) / 2;
					
					frame.setBounds(x, y, width, height);
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
	public TimerWindow() {
		setResizable(false);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 460, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Website Blocker");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 424, 64);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(10, 86, 424, 138);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Set block time:");
		lblNewLabel_1.setBounds(10, 11, 300, 20);
		panel.add(lblNewLabel_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(20, 42, 120, 42);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Hours:");
		lblNewLabel_2.setBounds(10, 11, 56, 20);
		panel_1.add(lblNewLabel_2);
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(0, 0, 24, 1));
		spinner.setBounds(75, 11, 35, 20);
		panel_1.add(spinner);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(282, 42, 120, 42);
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("Seconds:");
		lblNewLabel_4.setBounds(10, 11, 56, 20);
		panel_3.add(lblNewLabel_4);
		
		JSpinner spinner_2 = new JSpinner();
		spinner_2.setModel(new SpinnerNumberModel(0, 0, 59, 1));
		spinner_2.setBounds(75, 11, 35, 20);
		panel_3.add(spinner_2);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(152, 42, 120, 42);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Minutes:");
		lblNewLabel_3.setBounds(10, 11, 56, 20);
		panel_2.add(lblNewLabel_3);
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setModel(new SpinnerNumberModel(0, 0, 59, 1));
		spinner_1.setBounds(75, 11, 35, 20);
		panel_2.add(spinner_1);
		
		JButton btnNewButton = new JButton("Start");
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				WebBlocker webBlocker = new WebBlocker();
				webBlocker.startBlocker();
				
			}
			
		});
		btnNewButton.setBounds(167, 95, 90, 23);
		panel.add(btnNewButton);
		
	}
}
