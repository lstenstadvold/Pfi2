package clock;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

public class DigitalClockGUI extends JFrame {

	private JPanel contentPane;
	private ClockLogic clockLogic;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DigitalClockGUI frame = new DigitalClockGUI();
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
	public DigitalClockGUI() {
		clockLogic = new ClockLogic(this);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTime = new JLabel("00:00:00");
		lblTime.setHorizontalAlignment(SwingConstants.CENTER);
		lblTime.setBounds(109, 97, 158, 29);
		contentPane.add(lblTime);
		
		/**
		 *  To set the text to the gui you need to make an instance of this class that can be accessed
		 *	in the runnable ClockThread. Easiest would be to make a string method that updates the label.
		 */
		
		
		lblTime.setText("");
		
		//lblTime.setText(String.valueOf(Calendar.getInstance().get(Calendar.HOUR_OF_DAY)) + ":" +  String.valueOf(Calendar.getInstance().get(Calendar.MINUTE)) + 
			//	":" + String.valueOf(Calendar.getInstance().get(Calendar.SECOND)));
		
	}
}
