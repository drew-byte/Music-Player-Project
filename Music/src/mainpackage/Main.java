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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
				
		
		JButton select = new JButton("Select");
		select.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		select.setBounds(10, 11, 364, 47);
		panel.add(select);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.controlShadow);
		panel_1.setBounds(10, 69, 364, 74);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("name of music");
		lblNewLabel.setBounds(139, 28, 85, 14);
		panel_1.add(lblNewLabel);
		
		JButton back = new JButton("Back");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		back.setBounds(10, 154, 89, 47);
		panel.add(back);
		
		
		
		JButton playpause = new JButton("Play/Pause");
		playpause.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int count = 0;
				boolean playing = true;
				
					try {
						Clip clip = AudioSystem.getClip();
						
						count++;
						if(count%2==1 && playing)
						{
							AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("C:\\Users\\Shane\\Documents\\Github\\java_code\\JavaAlgo\\music\\twice_wil.wav").getAbsoluteFile());
							
							clip.open(audioInputStream);
							clip.start();
							playing = false;
						}
						else if(playing==false)
						{
							clip.stop();
							playing = true;
						}
						
						
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} 
					
					
				}
			
		});
		

		

		
	
		playpause.setBounds(148, 154, 89, 47);
		panel.add(playpause);
		
		JButton next = new JButton("Next");
		next.setBounds(285, 154, 89, 47);
		panel.add(next);
		
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	}
}
