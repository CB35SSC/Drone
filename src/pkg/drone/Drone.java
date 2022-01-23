package pkg.drone;

//Author Name: Connor Blanton
//Date: 8/25/2019
//Program Name: Blanton_Drone
//Purpose: Simulation using button, drone movement in x, y,z location


public class Drone {

	
	
	private int ID;
	private int x;
	private int y;
	private int z;
	
	public final int dID = 1111;
	public final int dX = 0;
	public final int dY = 0;
	public final int dZ = 0;
	
	public Drone() {
		this.ID = dID;
		this.x = dX;
		this.y = dY;
		this.z = dZ;
		
	}
	
	public void setX(int X){
	
		x = X;
	}
	
	public void setY(int Y){
		
		y = Y;
	}
	
	public void setZ(int Z){

		
		z = Z;
	
	}
	
	public int getID(){
		return ID;
	}
	public int getX(){
		return x;
	}
	public int getY(){
		
		if (y < 0) {
			y = 0; // Can't fly underground
			System.out.println("ERR: can't fly underground. Position not actually updated");
		}	
		return y;
	}
	public int getZ(){
		// Reset orientation
		if (z < 0) {
			z = 359;
		}	
		else if (z > 359) {
			z = 0;
		}
		
		return z;
		
		
		
	}
	
}
