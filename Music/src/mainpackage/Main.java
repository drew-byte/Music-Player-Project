package mainpackage;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class Main {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
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
	public Main() throws UnsupportedAudioFileException, IOException, LineUnavailableException  {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize()  throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		frame = new JFrame();
		frame.setSize(400,250);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 384, 211);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
				
		
		JButton btnNewButton = new JButton("Select");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(10, 11, 364, 47);
		panel.add(btnNewButton);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.controlShadow);
		panel_1.setBounds(10, 69, 364, 74);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("name of music");
		lblNewLabel.setBounds(139, 28, 85, 14);
		panel_1.add(lblNewLabel);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(10, 154, 89, 47);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("Play/Pause");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				boolean i = true;
				if(i)
				{
					File file = new File("amogusModified.wav");
					AudioInputStream audio;
					try {
						audio = AudioSystem.getAudioInputStream(file);
						Clip clip;
						try {
							clip = AudioSystem.getClip();
							clip.open(audio);
							
							clip.start();
						} catch (LineUnavailableException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
					} catch (UnsupportedAudioFileException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					i = false;
					
				}
				else
				{
					File file = new File("amogusModified.wav");
					AudioInputStream audio;
					try {
						audio = AudioSystem.getAudioInputStream(file);
						Clip clip;
						try {
							clip = AudioSystem.getClip();
							clip.open(audio);
							
							clip.start();
						} catch (LineUnavailableException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
					} catch (UnsupportedAudioFileException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
				
				
			}
		});
		btnNewButton_1_1.setBounds(148, 154, 89, 47);
		panel.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_2 = new JButton("Next");
		btnNewButton_1_2.setBounds(285, 154, 89, 47);
		panel.add(btnNewButton_1_2);
		
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	}
}
