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
	public JTextField textFieldStation;
	public JTextArea textAreaStation;
	public JTextField textFieldFrom;
	public JTextField textFieldTo;
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
		
		textFieldStation = new JTextField();
		textFieldStation.setBounds(6, 25, 294, 28);
		contentPane.add(textFieldStation);
		textFieldStation.setColumns(10);
		
		JButton btnSearchStation = new JButton("Search");
		btnSearchStation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textAreaStation.setText("Searching :) ... \n\n");
				StationThread stationThread = new StationThread(GUI.this);
				stationThread.start();
			}
		});
		btnSearchStation.setBounds(312, 26, 117, 29);
		contentPane.add(btnSearchStation);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 63, 439, 229);
		contentPane.add(scrollPane);
		
		textAreaStation = new JTextArea();
		scrollPane.setViewportView(textAreaStation);
		
		JLabel lblSearchStations = new JLabel("Search Stations");
		lblSearchStations.setBounds(6, 6, 109, 16);
		contentPane.add(lblSearchStations);
		
		JPanel panel = new JPanel();
		panel.setBounds(6, 304, 471, 261);
		contentPane.add(panel);
		panel.setLayout(null);
		
		textFieldFrom = new JTextField();
		textFieldFrom.setBounds(17, 53, 134, 28);
		panel.add(textFieldFrom);
		textFieldFrom.setColumns(10);
		
		JLabel lblSearchJourneys = new JLabel("Search Journeys");
		lblSearchJourneys.setBounds(6, 6, 99, 16);
		panel.add(lblSearchJourneys);
		
		textFieldTo = new JTextField();
		textFieldTo.setColumns(10);
		textFieldTo.setBounds(177, 53, 134, 28);
		panel.add(textFieldTo);
		
		JLabel lblFrom = new JLabel("From:");
		lblFrom.setBounds(17, 39, 99, 16);
		panel.add(lblFrom);
		
		JLabel lblTo = new JLabel("To:");
		lblTo.setBounds(177, 39, 99, 16);
		panel.add(lblTo);
		
		JButton btnSearchJourney = new JButton("Search");
		btnSearchJourney.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textAreaJourneys.setText("Searching :) \n\n");
				JourneyThread journeyThread = new JourneyThread(GUI.this);
				journeyThread.start();

			}
		});
		
		btnSearchJourney.setBounds(315, 54, 117, 29);
		panel.add(btnSearchJourney);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(6, 83, 459, 178);
		panel.add(scrollPane_1);
		
		textAreaJourneys = new JTextArea();
		scrollPane_1.setViewportView(textAreaJourneys);
		
	}
}
		
		
		
