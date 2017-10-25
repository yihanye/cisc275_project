package project.src.cisc275_project;

public class Net {
	double xPos, yPos;
	double xInc, yInc;
	int rotation;
	int rotationDeg;
	boolean swing;
	
	public Net(int xPos, int yPos, int xInc, int yInc, int rotation, int rotationDeg) {
		this.xPos = xPos;
		this.yPos = yPos;
		this.xInc = xInc;
		this.yInc = yInc;
		this.rotation = rotation;
		this.rotationDeg = rotationDeg;
		this.swing = true;
	}
	public double getxPos() {
		return xPos;
	}
	public double getyPos() {
		return yPos;
	}
	public void updateInc(){
		this.xInc = -Math.sin(Math.toRadians(rotation))*5;
		this.yInc = Math.cos(Math.toRadians(rotation))*5;
	}
	public void changeSwing(){
		if(getSwing()){
		this.swing = !this.swing;}
	}
	public boolean getSwing (){
		return this.swing;
	}
	public int getRotation() {
		return rotation;
	}
	public static Net createNet(){
		return new Net(500,50,0,0,0,10);
	}
	public void updateRotationDeg() {
		if (rotation>70||rotation<-70) {
			rotationDeg*=-1;
		}
	}
	public void updateRotation() {
			if(swing){
			updateRotationDeg();
			rotation += rotationDeg;}
	}
	public void updatePosition() {
		if(xPos<=50||xPos>=950||yPos>=550 ){
			goBack();
		}
		xPos +=xInc;
		yPos += yInc;
	}
	public void goBack(){
		xInc *= -1;
		yInc *= -1;
	}
	//this is bad code
	public void resetNet(){
		if(yPos<50) {
			this.xPos = 500;
			this.yPos = 50;
			this.swing = true;
		}
	}

	public void update() {
		updateRotation();
		if(!getSwing()){
		updatePosition();}
		else{
			updateInc();
		}
		resetNet();
	}
	public String toString() {
		return ""+rotation+" xPos: "+ xPos+" xInc: "+ xInc;
	}
	public static void main(String[] args) {
		Net n = new Net(500, 100, 3,3,45,10);
		n.changeSwing();
		System.out.println(n);
		for(int i = 0; i < 1000; i++){
			n.update();
			System.out.println(n);
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
