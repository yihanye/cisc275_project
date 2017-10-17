class Animal 
{
	String name;
	String description;
	int xPos, yPos; //Position of center of the animal
	int xInc, yInc; //speed of the certain animal
	int weith, height; //weith and height of the image of a certain animal
	int[] position = {xPos, yPos, xInc, yInc};
	bool caught; //check if the animal is caught

	public int[] getPostion() //getter for position
	{
		return position;
	}

	public void setPostion(int[] position) //setter for position
	{
		this.xPos = position[0];
		this.yPos = position[1];
		this.xInc = position[2];
		this.yInc = Position[3];
	}

	//move the animal
	public void move() {}

	//change the direction of image of animal
	public void changeOrientation() {}

}

class JellyFish extends Animal //a subclass for animal sea star
{
	//when this animal is caught, invoke bonus
	public void bonus() {}
}

class BlueCrab extends Animal //a subclass for animal blue crab 
{
	
}

class Net 
{
	int xInc, yInc;

	//will be invoked when the mouse is clicked
	public bool catch() {}

	//check if the net reaches the animal
	public bool checkCollision() {} 
}

class Game 
{
	private Net net;
	private Animal animal;

	int animalNeeded; //the number of animals that is needed for this research
	int aninmalACaught, aninmalBCaught, aninmalCCaught; //record the number of animals that are caught already
	LocalTime startTime, endTime; //start and end time for the game

	int numOfAniamls; //the total number of animal on the screeen 

	//summon random type of animal with a random time period
	public void summonAnimal() {}

	//Increment score based on the specific animal caught
	public void incrementScore(Animal a) {}
}






















