package animals;

public abstract class Mammal extends Animal {
	
	private int gestationTime;
	
	public Mammal(String latinName, int gestationTime){
		super(latinName);
		this.gestationTime = gestationTime;
	}
	
	public int getGestationTime() {
		return gestationTime;
	}

	public void setGestationTime(int gestationTime) {
		this.gestationTime = gestationTime;
	}
}
