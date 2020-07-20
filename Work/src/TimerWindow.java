import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class TimerWindow extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3575854326816620850L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			
			public void run() {
				
				try {
					
					TimerWindow frame = new TimerWindow();
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
		
		setBounds(100, 100, 460, 320);
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
		
		JSpinner spHrs = new JSpinner();
		spHrs.setModel(new SpinnerNumberModel(0, 0, 24, 1));
		spHrs.setBounds(75, 11, 35, 20);
		panel_1.add(spHrs);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(282, 42, 120, 42);
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("Seconds:");
		lblNewLabel_4.setBounds(10, 11, 56, 20);
		panel_3.add(lblNewLabel_4);
		
		JSpinner spSec = new JSpinner();
		spSec.setModel(new SpinnerNumberModel(0, 0, 59, 1));
		spSec.setBounds(75, 11, 35, 20);
		panel_3.add(spSec);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(152, 42, 120, 42);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Minutes:");
		lblNewLabel_3.setBounds(10, 11, 56, 20);
		panel_2.add(lblNewLabel_3);
		
		JSpinner spMin = new JSpinner();
		spMin.setModel(new SpinnerNumberModel(0, 0, 59, 1));
		spMin.setBounds(75, 11, 35, 20);
		panel_2.add(spMin);
		
		JButton btnNewButton = new JButton("Start");
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
				WebBlocker webBlocker = new WebBlocker();
				
				int hrs = (int) spHrs.getValue() * 60 * 60;
				int min = (int) spMin.getValue() * 60;
				int sec = (int) spSec.getValue();
				
				webBlocker.startBlocker(hrs + min + sec);
				setVisible(true);
				
			}
			
		});
		btnNewButton.setBounds(167, 95, 90, 23);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Restore");
		btnNewButton_1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				File ftb = new File("C:\\Windows\\System32\\drivers\\etc\\hosts");
				File bu = new File(ftb.getName() + ".backup");
				BackupHandler backupHandler = new BackupHandler();
				
				if (bu.exists() && !bu.isDirectory()) {
					
					backupHandler.loadBackup(ftb);
					bu.delete();
					
				}
				
			}
			
		});
		btnNewButton_1.setBounds(284, 235, 150, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Edit websites list");
		btnNewButton_2.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				new WebsiteListWindow().setVisible(true);
				
			}
			
		});
		btnNewButton_2.setBounds(10, 235, 150, 23);
		contentPane.add(btnNewButton_2);
		
		File file = new File("websites_list.txt");
		try {
			
			if (!file.exists() || (file.exists() && file.isDirectory()))
				file.createNewFile();
			
		} catch (IOException e) {
			
			e.printStackTrace();
			
		}
	
		setLocationRelativeTo(null);
		
	}
	
}
