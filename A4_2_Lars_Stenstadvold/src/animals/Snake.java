package animals;

public class Snake extends Animal {
	private boolean poisonous;

	public Snake(String latinName, boolean poisonous) {
		super(latinName);
		// TODO Auto-generated constructor stub
	}
	
	public void isPoisonous() {
		poisonous = true;
	}

	@Override
	public String getInfo() {
		String info;
		if(poisonous){
			info = "The snake named " + getFriendlyName() + ", in latin: " + getLatinName() +", is poisonous.";
		}else{
			info = "The snake named " + getFriendlyName() + ", in latin: " + getLatinName() +", is not poisonous.";
		}
		return info;
	}

}
