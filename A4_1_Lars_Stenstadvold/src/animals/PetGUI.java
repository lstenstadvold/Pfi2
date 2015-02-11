package animals;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PetGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldHuman;
	private JTextField textFieldDog;
	private Human human;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PetGUI frame = new PetGUI();
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
	public PetGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblHumansAndDogs = new JLabel("Humans and Dogs");
		lblHumansAndDogs.setBounds(157, 6, 123, 16);
		contentPane.add(lblHumansAndDogs);
		
		textFieldHuman = new JTextField();
		textFieldHuman.setBounds(67, 34, 134, 28);
		contentPane.add(textFieldHuman);
		textFieldHuman.setColumns(10);
		
		textFieldDog = new JTextField();
		textFieldDog.setColumns(10);
		textFieldDog.setBounds(67, 74, 134, 28);
		contentPane.add(textFieldDog);
		
		JButton btnNewHuman = new JButton("New Human");
		btnNewHuman.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Human newHuman = new Human(textFieldHuman.getText());
			}
		});
		btnNewHuman.setBounds(223, 35, 117, 29);
		contentPane.add(btnNewHuman);
		
		JButton btnBuyDog = new JButton("Buy Dog");
		btnBuyDog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnBuyDog.setBounds(223, 75, 117, 29);
		contentPane.add(btnBuyDog);
		
		JButton btnPrintInfo = new JButton("Print Info");
		btnPrintInfo.setBounds(223, 116, 117, 29);
		contentPane.add(btnPrintInfo);
		
		JTextArea textAreaInfo = new JTextArea();
		textAreaInfo.setBounds(17, 165, 415, 47);
		contentPane.add(textAreaInfo);
		
		JLabel lblInfo = new JLabel("Info");
		lblInfo.setBounds(17, 147, 61, 16);
		contentPane.add(lblInfo);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(17, 237, 415, 35);
		contentPane.add(textArea);
		
		JLabel lblErrormessage = new JLabel("ErrorMessage");
		lblErrormessage.setBounds(17, 217, 117, 23);
		contentPane.add(lblErrormessage);
	}
}
