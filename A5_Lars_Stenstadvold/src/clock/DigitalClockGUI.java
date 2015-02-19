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
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DigitalClockGUI extends JFrame {

	private JPanel contentPane;
	private ClockLogic clockLogic = new ClockLogic(this);;
	private JTextField textAlarmHours;
	private JTextField textAlarmMinutes;
	public JLabel lblAlarmAt;
	public JLabel lblShowTime;
	JLabel lblAlarmIcon;
	private JLabel lblTime4Tele;
	private JLabel lblAllTeletubies;
	
	
	
	

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
		setTitle("teletubby o'clock");
		
		//clockLogic = new ClockLogic(this);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.RED);
		panel.setBounds(221, 246, 173, 126);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblHourz = new JLabel("hourz:");
		lblHourz.setForeground(Color.WHITE);
		lblHourz.setBounds(30, 12, 40, 16);
		panel.add(lblHourz);
		
		JLabel lblMinitz = new JLabel("minitz:");
		lblMinitz.setForeground(Color.WHITE);
		lblMinitz.setBounds(30, 45, 44, 16);
		panel.add(lblMinitz);
		
		textAlarmHours = new JTextField();
		textAlarmHours.setBounds(82, 6, 56, 28);
		panel.add(textAlarmHours);
		textAlarmHours.setColumns(10);
		
		textAlarmMinutes = new JTextField();
		textAlarmMinutes.setBounds(82, 39, 56, 28);
		panel.add(textAlarmMinutes);
		textAlarmMinutes.setColumns(10);
		
		JButton btnSet = new JButton("set");
		btnSet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clockLogic.setAlarm(Integer.parseInt(textAlarmHours.getText()),Integer.parseInt(textAlarmMinutes.getText()));
			}
		});
		btnSet.setBounds(6, 73, 73, 47);
		panel.add(btnSet);
		
		JButton btnClr = new JButton("clr");
		btnClr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clockLogic.clearAlarm();
			}
		});
		btnClr.setBounds(92, 73, 73, 47);
		panel.add(btnClr);
		
		lblAlarmAt = new JLabel("alarm");
		lblAlarmAt.setForeground(Color.RED);
		lblAlarmAt.setBounds(221, 229, 113, 16);
		contentPane.add(lblAlarmAt);
		
		lblShowTime = new JLabel("00:00:00");
		lblShowTime.setForeground(Color.BLACK);
		lblShowTime.setBackground(Color.WHITE);
		lblShowTime.setFont(new Font("SansSerif", Font.PLAIN, 32));
		lblShowTime.setHorizontalAlignment(SwingConstants.CENTER);
		lblShowTime.setBounds(221, 158, 179, 48);
		contentPane.add(lblShowTime);
		
		lblAlarmIcon = new JLabel("");
		lblAlarmIcon.setIcon(new ImageIcon(DigitalClockGUI.class.getResource("/images/alarmclock40.jpg")));
		lblAlarmIcon.setBounds(72, 187, 61, 48);
		lblAlarmIcon.setVisible(false);
		contentPane.add(lblAlarmIcon);
		
		lblTime4Tele = new JLabel("TIME 4 TELETUBBIES!!!");
		lblTime4Tele.setHorizontalAlignment(SwingConstants.CENTER);
		lblTime4Tele.setFont(new Font("Casual", Font.PLAIN, 24));
		lblTime4Tele.setBounds(113, 6, 287, 36);
		contentPane.add(lblTime4Tele);
		lblTime4Tele.setVisible(false);
		
		lblAllTeletubies = new JLabel("New label");
		lblAllTeletubies.setIcon(new ImageIcon(DigitalClockGUI.class.getResource("/images/time4teletubbies.jpg")));
		lblAllTeletubies.setBounds(0, 0, 400, 378);
		contentPane.add(lblAllTeletubies);
		lblAllTeletubies.setVisible(false);
		
		JLabel lblPIC = new JLabel("");
		lblPIC.setIcon(new ImageIcon(DigitalClockGUI.class.getResource("/images/popoPIC.jpg")));
		lblPIC.setBounds(0, 0, 400, 378);
		contentPane.add(lblPIC);
	
	}
	
	
	
	public void setTextOnLabel(String timeIn){
		lblShowTime.setText(timeIn);
	}
	
	public void setAlarmText(String alarmTime){
		lblAlarmAt.setText(alarmTime);
	}
	
	public void alarm(boolean activate){
		lblTime4Tele.setVisible(activate);
		lblAllTeletubies.setVisible(activate);
		lblAlarmIcon.setVisible(!activate);
		
	}
}
