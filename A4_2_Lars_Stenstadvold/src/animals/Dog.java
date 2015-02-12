package animals;

public class Dog extends Mammal {
	
	private boolean stupid;

	public Dog(String latinName, boolean stupid) {
		super(latinName, 3); //sets gestationTime for all dogs without a friendlyName to 3
		setLatinName(latinName);
		this.stupid = stupid;
		
	}
	
	public Dog(String latinName, String friendlyName, boolean stupid) {
		super(latinName, 4); //sets gestationTime for all dogs without a friendlyName to 4
		setFriendlyName(friendlyName);
		setLatinName(latinName);
		this.stupid = stupid;
	}

	public void isStupid() {
		stupid = true;
	}

	@Override
	public String getInfo() {
		String info;
		if(stupid){
			info = "The dog named " + getFriendlyName() + ", in latin: " + getLatinName() + ", nurses for " + 
					String.valueOf(getGestationTime()) + " months and is stupid.";
		}else{
			info = "The dog named " + getFriendlyName() + ", in latin: " + getLatinName() + ", nurses for " + 
					String.valueOf(getGestationTime()) + " months and is not stupid.";
		}
		return info;
	}

}
