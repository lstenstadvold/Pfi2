package animals;

public class Cat extends Mammal {
	
	private int numberOfLives;

	public Cat(String latinName, int numberOfLives) {
		super(latinName, 5); //sets gestationTime for all cats to 5
		setFriendlyName("KC"); //all cats get the friendlyName "KC"
		this.numberOfLives = numberOfLives;
	}



	@Override
	public String getInfo() {
		String info;
		info = "The cat named " + getFriendlyName() + ", in latin: " + getLatinName() + ", nurses for " + 
		String.valueOf(getGestationTime()) + " months and has " + String.valueOf(numberOfLives) + " lives.";
		return info;
	}
	
}
