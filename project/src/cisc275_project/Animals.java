package project.src.cisc275_project;

import java.util.List;

public class Animals {
	private String name;
	private List<Animal> animals;
	
	public Animals(String name, List<Animal> animals) {
		this.name = name;
		this.animals = animals;
	}

	public List<Animal> getAnimals() {
		return animals;
	}

	public String toString(){
		String result = "";
		for(Animal a: this.animals){
			result += " xPox:" + a.getxPos();
		}
		return result;
	}


	public void update(Net n) {
		for(Animal a: animals) {
			a.update(n);
			a.isCollision(n);
		}
	}

}
