package project.src.cisc275_project;

public class Net {
	double xPos, yPos;
	double xInc, yInc;
	int rotation;
	int rotationDeg;
	boolean swing;
	boolean caught;
	
	public Net(int xPos, int yPos, int xInc, int yInc, int rotation, int rotationDeg) {
		this.xPos = xPos;
		this.yPos = yPos;
		this.xInc = xInc;
		this.yInc = yInc;
		this.rotation = rotation;
		this.rotationDeg = rotationDeg;
		this.swing = true;
		this.caught = false;
	}
	public double getxPos() {
		return xPos;
	}
	public double getyPos() {
		return yPos;
	}
	public double getxInc() { return xInc;}
	public double getyInc() { return yInc;}
	public boolean getSwing (){
		return this.swing;
	}
	public int getRotation() {
		return rotation;
	}
	public static Net createNet(){
		return new Net(500,50,0,0,0,10);
	}

	public void updateInc(){
		this.xInc = -Math.sin(Math.toRadians(rotation))*5;
		this.yInc = Math.cos(Math.toRadians(rotation))*5;
	}
	public void stopSwing(){
//		if(swing){
//		this.swing = false;}
		this.swing = false;
	}

	public void updateRotationDeg() {
		if (rotation>80||rotation<-80) {
			rotationDeg*=-1;
		}
	}

	public void updateRotation() {
			if(swing){
			updateRotationDeg();
			rotation += rotationDeg;}
	}
	public boolean atEdge() {
		return xPos<=50||xPos>=950||yPos>=550;
	}
	public void updatePosition() {
		if(caught){
			xPos -=xInc;
			yPos -= yInc;
		}
		else{
			if(atEdge()){
				goBack();
			}
			xPos +=xInc;
			yPos += yInc;
		}
	}

	public void goBack(){
		xInc *= -1;
		yInc *= -1;
	}

	public boolean goDown(){
		return !swing & (yInc>0);
	}
	public void resetNet(){
		if(yPos<50) {
			this.xPos = 500;
			this.yPos = 50;
			this.swing = true;
			this.caught = false;
		}
	}

	public void updateCollision(){
			caught = true;
	}

	public void update() {

		if(swing){
			updateRotation();
			updateInc();
		}
		else{
			updatePosition();
		}

		resetNet();
	}

	public String toString() {
		return " net is on position " + "( "+(int)xPos+", "+(int)yPos+" ) with degree of " + rotation;
	}
	public static void main(String[] args) {
		Net n = new Net(500, 100, 3,3,45,10);
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
