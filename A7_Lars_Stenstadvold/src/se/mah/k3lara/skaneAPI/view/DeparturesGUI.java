package se.mah.k3lara.skaneAPI.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.text.SimpleDateFormat;
import java.util.Calendar;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;


import se.mah.k3lara.skaneAPI.control.Helpers;
import se.mah.k3lara.skaneAPI.model.Line;
import se.mah.k3lara.skaneAPI.model.Lines;
import se.mah.k3lara.skaneAPI.model.Station;
import se.mah.k3lara.skaneAPI.xmlparser.Parser;
import java.awt.Color;
import java.awt.Font;

public class DeparturesGUI extends JFrame {

	private JPanel contentPane;
	private JTextArea textAreaLine;
	private JTextArea textAreaDestination;
	private JTextArea textAreaDeparts;
	private JTextArea textAreaLate;
	
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeparturesGUI frame = new DeparturesGUI();
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
	public DeparturesGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Ubåtshallen");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(135, 6, 156, 33);
		contentPane.add(lblNewLabel);
		
		JLabel lblLine = new JLabel("Line:");
		lblLine.setForeground(Color.WHITE);
		lblLine.setBounds(6, 41, 61, 16);
		contentPane.add(lblLine);
		
		JLabel lblDestination = new JLabel("Destination:");
		lblDestination.setForeground(Color.WHITE);
		lblDestination.setBounds(53, 41, 94, 16);
		contentPane.add(lblDestination);
		
		JLabel lblDeparts = new JLabel("Departs:");
		lblDeparts.setForeground(Color.WHITE);
		lblDeparts.setBounds(237, 41, 94, 16);
		contentPane.add(lblDeparts);
		
		textAreaLine = new JTextArea();
		textAreaLine.setForeground(Color.YELLOW);
		textAreaLine.setBackground(Color.BLACK);
		textAreaLine.setBounds(6, 56, 35, 216);
		contentPane.add(textAreaLine);
		
		textAreaDestination = new JTextArea();
		textAreaDestination.setForeground(Color.YELLOW);
		textAreaDestination.setBackground(Color.BLACK);
		textAreaDestination.setBounds(56, 56, 169, 216);
		contentPane.add(textAreaDestination);
		
		textAreaDeparts = new JTextArea();
		textAreaDeparts.setForeground(Color.YELLOW);
		textAreaDeparts.setBackground(Color.BLACK);
		textAreaDeparts.setBounds(237, 56, 132, 216);
		contentPane.add(textAreaDeparts);
		
		textAreaLate = new JTextArea();
		textAreaLate.setForeground(Color.RED);
		textAreaLate.setBackground(Color.BLACK);
		textAreaLate.setText("");
		textAreaLate.setBounds(381, 56, 58, 216);
		contentPane.add(textAreaLate);
		
		JLabel lblDelays = new JLabel("Delays:");
		lblDelays.setForeground(Color.WHITE);
		lblDelays.setBounds(380, 41, 94, 16);
		contentPane.add(lblDelays);
		
		
		updateLines();
		
		Thread updateThread = new Update(this);
		updateThread.start();
		System.out.println("thread started");
		
		
		
		
	}
	//Updates every thirty seconds (every time thread runs)
	public void updateLines() {
		Lines lines = Parser.getStationResults(new Station("80046"));
		
		//sign prints the next 10 departures
		int nrOfResults = 10;
		
		//clears the sign before every update
		textAreaLine.setText("");
		
		for (int i = 0; i < nrOfResults; i ++){
			//updates the line numbers
			textAreaLine.append(lines.getLines().get(i).getLine()+ "\n");
			//textAreaLine.append(l.getLine() + "\n");
		}
		
		textAreaDestination.setText("");
		
		for (int i = 0; i < nrOfResults; i ++){
			//updates the destinations
			textAreaDestination.append(lines.getLines().get(i).getTowards() + "\n");
		}
		
		textAreaDeparts.setText("");
		
		for (int i = 0; i < nrOfResults; i ++){
			//calculates the time left to departure
			textAreaDeparts.append(Helpers.timeToDeparture(lines.getLines().get(i).getJourneyDateTime()) + " minutes" + "\n");
	
		}
		
		textAreaLate.setText("");
		
		
		for (int i = 0; i < nrOfResults; i ++){
			//if there is a delay, print how many minutes the delay is
			if(lines.getLines().get(i).getDepTimeDeviation() != ""){
				textAreaLate.append("+ " + lines.getLines().get(i).getDepTimeDeviation() + " min \n");
		}
			//if there isn't any delay, just leave an empty space
			if(lines.getLines().get(i).getDepTimeDeviation() == ""){
				textAreaLate.append(lines.getLines().get(i).getDepTimeDeviation() +"\n");
			}
		}
		
	}
}

	
