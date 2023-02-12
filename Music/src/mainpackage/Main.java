package mainpackage;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Main {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)  throws UnsupportedAudioFileException, IOException, LineUnavailableException{
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
	
	boolean playing = true;
	
	AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("C:\\Users\\Shane\\Documents\\Github\\java_code\\JavaAlgo\\music\\twice_wil.wav").getAbsoluteFile());
	Clip clip = AudioSystem.getClip();
	

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
				JOptionPane.showConfirmDialog(null,"Select a data here");
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
		
		JButton back = new JButton("");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		back.setIcon(new ImageIcon(new ImageIcon("C:\\Users\\Shane\\Desktop\\Music Project\\fast-backward.png").getImage()
				.getScaledInstance(40, 40, Image.SCALE_DEFAULT)));
		back.setBounds(10, 154, 79, 47);
		panel.add(back);
		
		
		
		JButton play = new JButton("");
		play.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				try {
					
					clip.open(audioInputStream);
					long clipTimePos = 0;
					
					if(e.getClickCount()%2==1 && playing)
					{
						clip.start();
						playing = false;
					}
					else
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
		play.setIcon(new ImageIcon(new ImageIcon("C:\\Users\\Shane\\Desktop\\Music Project\\play.png").getImage()
				.getScaledInstance(40, 40, Image.SCALE_DEFAULT)));
	
		play.setBounds(149, 154, 79, 47);
		panel.add(play);
		
		JButton next = new JButton("");
		next.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		next.setIcon(new ImageIcon(new ImageIcon("C:\\Users\\Shane\\Desktop\\Music Project\\fast-forward.png").getImage()
				.getScaledInstance(40, 40, Image.SCALE_DEFAULT)));
		next.setBounds(295, 154, 79, 47);
		panel.add(next);
		
		
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	}
}
