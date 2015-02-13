package animals;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JLabel;

public class AnimalsGUI extends JFrame {

	private JPanel contentPane;
	private ArrayList<Animal> animalList = new ArrayList<Animal>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AnimalsGUI frame = new AnimalsGUI();
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
	public AnimalsGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 523, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 25, 511, 248);
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		JLabel lblNewLabel = new JLabel("Animal List");
		lblNewLabel.setBounds(6, 6, 435, 16);
		contentPane.add(lblNewLabel);
		
		animalList.add(new Snake("Python regius", true));
		animalList.add(new Snake("Boa constrictus", false));
		Cat cat = new Cat("Feline mean", 9);
		cat.setFriendlyName("friendly name"); //sets a friendlyName for cat even though friendlyName is not included in the Cat constructor
		animalList.add(cat);
		animalList.add(new Cat("Feline tigris", 1));
		
		animalList.add(new Dog("Canis lazynis", true));
		animalList.add(new Dog("Canis atleticus", "Sporty Spice", false));
		
		for(Animal animal : animalList){
			textArea.append(animal.getInfo() + "\n");
		}
		
		
		
		for(Animal animal : animalList){
			System.out.println(animal.getInfo() +"\n");
		}
	}

}
