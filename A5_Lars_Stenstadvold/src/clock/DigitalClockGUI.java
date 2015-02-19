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
	public String time;
	
	
	
	

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
		
		lblShowTime = new JLabel("New label");
		lblShowTime.setHorizontalAlignment(SwingConstants.CENTER);
		lblShowTime.setBounds(89, 89, 179, 48);
		contentPane.add(lblShowTime);
	
	}
	
	
	
	public void setTextOnLabel(String timeIn){
		lblShowTime.setText(timeIn);
	}
	
	public void setAlarmText(String alarmTime){
		lblAlarmAt.setText(alarmTime);
	}
	
	public void alarm(boolean activate){
		
	}

}
