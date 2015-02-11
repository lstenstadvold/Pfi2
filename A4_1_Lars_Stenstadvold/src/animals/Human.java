package animals;

public class Human {
	private Dog dog;
	private String name;
	
	public Human(String name){ 
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	public void buyDog(Dog dog){
		this.dog = dog;
	}
	public String getInfo(){
		String info;
		if(dog == null && dog.getName().equals("")){ //if the human doesn't own a dog, or owns an "empty" dog
			info = this.name + " does not own a dog.";
		}else{
			info = this.name + " owns a dog named " + dog.getName();
		}
		return info;
	}
		
}

