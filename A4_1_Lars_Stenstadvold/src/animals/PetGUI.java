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
	private JTextField textFieldInfo;
	private Human human;
	private Dog dog;
	private JTextField textFieldError;


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
				textFieldError.setText("");
				textFieldInfo.setText("");
				if(textFieldHuman.getText().length() >= 3){
				human = new Human(textFieldHuman.getText());//create new human with the name given in textFieldHuman
				}else{
					textFieldError.setText("Name is too short");
				}
			}
		});
		btnNewHuman.setBounds(223, 35, 117, 29);
		contentPane.add(btnNewHuman);
		
		JButton btnBuyDog = new JButton("Buy Dog");
		btnBuyDog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(human != null) { //check if human has been created
					dog = new Dog(textFieldDog.getText()); //create new dog with the name given in textFieldDog
					human.buyDog(dog);//assigns the dog to the given Human
				}else{ 
					textFieldError.setText("That doggie needs an owner!");
				}
			}
		});
		btnBuyDog.setBounds(223, 75, 117, 29);
		contentPane.add(btnBuyDog);
		
		JButton btnPrintInfo = new JButton("Print Info");
		btnPrintInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldInfo.setText(human.getInfo());
			}
		});
		btnPrintInfo.setBounds(223, 116, 117, 29);
		contentPane.add(btnPrintInfo);
		
		
		
		JLabel lblInfo = new JLabel("Info");
		lblInfo.setBounds(17, 147, 61, 16);
		contentPane.add(lblInfo);
		
		JLabel lblErrormessage = new JLabel("ErrorMessage");
		lblErrormessage.setBounds(17, 217, 117, 23);
		contentPane.add(lblErrormessage);
		
		textFieldInfo = new JTextField();
		textFieldInfo.setBounds(17, 175, 415, 28);
		contentPane.add(textFieldInfo);
		textFieldInfo.setColumns(10);
		
		textFieldError = new JTextField();
		textFieldError.setBounds(17, 244, 415, 28);
		contentPane.add(textFieldError);
		textFieldError.setColumns(10);
	}
}
