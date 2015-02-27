package se.mah.k3lara.skaneAPI.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import se.mah.k3lara.skaneAPI.control.Constants;
import se.mah.k3lara.skaneAPI.model.Journey;
import se.mah.k3lara.skaneAPI.model.Journeys;
import se.mah.k3lara.skaneAPI.model.Station;
import se.mah.k3lara.skaneAPI.xmlparser.JourneyThread;
import se.mah.k3lara.skaneAPI.xmlparser.Parser;
import se.mah.k3lara.skaneAPI.xmlparser.StationThread;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;

public class GUI extends JFrame {

	private JPanel contentPane;
	public JTextField textField;
	public JTextArea textArea;
	public JTextField textField_1;
	public JTextField textField_2;
	public JTextArea textAreaJourneys;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
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
	public GUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 483, 588);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(6, 25, 294, 28);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText("Loading :) ... \n\n");
				StationThread stationThread = new StationThread(GUI.this);
				stationThread.start();
			}
		});
		btnSearch.setBounds(312, 26, 117, 29);
		contentPane.add(btnSearch);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 63, 439, 229);
		contentPane.add(scrollPane);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		JLabel lblSearchStations = new JLabel("Search Stations");
		lblSearchStations.setBounds(6, 6, 109, 16);
		contentPane.add(lblSearchStations);
		
		JPanel panel = new JPanel();
		panel.setBounds(6, 304, 471, 261);
		contentPane.add(panel);
		panel.setLayout(null);
		
		textField_1 = new JTextField();
		textField_1.setBounds(17, 53, 134, 28);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblSearchJourneys = new JLabel("Search Journeys");
		lblSearchJourneys.setBounds(6, 6, 99, 16);
		panel.add(lblSearchJourneys);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(177, 53, 134, 28);
		panel.add(textField_2);
		
		JLabel lblFrom = new JLabel("From:");
		lblFrom.setBounds(17, 39, 99, 16);
		panel.add(lblFrom);
		
		JLabel lblTo = new JLabel("To:");
		lblTo.setBounds(177, 39, 99, 16);
		panel.add(lblTo);
		
		JButton btnSearch_1 = new JButton("Search");
		btnSearch_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textAreaJourneys.setText("Loading :) \n\n");
				JourneyThread journeyThread = new JourneyThread(GUI.this);
				journeyThread.start();

			}
		});
		
		btnSearch_1.setBounds(315, 54, 117, 29);
		panel.add(btnSearch_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(6, 83, 459, 178);
		panel.add(scrollPane_1);
		
		textAreaJourneys = new JTextArea();
		scrollPane_1.setViewportView(textAreaJourneys);
		
	}
}
		
		
		
