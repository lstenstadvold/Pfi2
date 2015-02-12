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
		if(dog == null) { //if the human doesn't own a dog or if dog has no name
			info = this.name + " does not own a dog.";
		}else if(dog.getName().isEmpty()){ //checks if the dog does not have a name
			info = this.name + " owns a dog who doesn't even have a name.";
		}else{
			info = this.name + " owns a dog named " + dog.getName();
		}
		return info;
	}
		
}

