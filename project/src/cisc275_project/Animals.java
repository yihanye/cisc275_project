package cisc275_project;

import java.util.List;

public class Animals {
	private String name;
	private List<Animal> animals;
	
	public Animals(String name, List<Animal> animals) {
		this.name = name;
		this.animals = animals;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Animal> getAnimals() {
		return animals;
	}

	public void setAnimals(List<Animal> animals) {
		this.animals = animals;
	}


	
	public void update() {
		for(Animal a: animals) {
			a.update();
		}
	}

}
