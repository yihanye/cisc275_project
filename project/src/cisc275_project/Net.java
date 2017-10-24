package cisc275_project;

public class Net {
	int xPos, yPos;
	int xInc, yInc;
	int rotation;
	int rotationDeg;
	
	public Net(int xPos, int yPos, int xInc, int yInc, int rotation, int rotationDeg) {
		this.xPos = xPos;
		this.yPos = yPos;
		this.xInc = xInc;
		this.yInc = yInc;
		this.rotation = rotation;
		this.rotationDeg = rotationDeg;
	}

	public int getxPos() {
		return xPos;
	}
	public int getyPos() {
		return yPos;
	}
	
	public int getRotation() {
		return rotation;
	}
	public void updateRotationDeg() {
		if (rotation>80||rotation<-80) {
			rotationDeg*=-1;
		}
	}
	public void updateRotation() {
		updateRotationDeg();
		rotation += rotationDeg;
	}
	
	public void update() {
		updateRotation();
	}
	public String toString() {
		return ""+rotation;
	}
	
	public static void main(String[] args) {
		Net n = new Net(500, 100, 3,3,0,10);
		System.out.println(n);
		for(int i = 0; i < 1000; i++){
			n.updateRotation();
			System.out.println(n);
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}
