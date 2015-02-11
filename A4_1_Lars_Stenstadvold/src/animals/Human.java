package animals;

public class Human {
	private Dog dog;
	private String name;
	
	public Human(String name) {
		this.name = name;
	}
	public Human(String name, Dog dog) {
		this.name = name;
		this.dog = dog;
	}
	
	public String getName() {
		return name;
	}
	public void buyDog(Dog dog){
		this.dog = new Dog(dog.getName());
		
	}
	public String getInfo(){
		String info;
		info = this.name + "owns a dog named " + dog.getName();
		return info;
	}
}

