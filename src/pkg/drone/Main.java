package pkg.drone;

import java.util.*;



//Author Name: Connor Blanton
//Date: 8/25/2019
//Program Name: Blanton_Drone
//Purpose: Simulation using button, drone movement in x, y,z location


public class Main {

	public static void main(String[] args) {
		
		System.out.println("Drone Controller initialising..");
		Drone d1 = new Drone();
		Scanner IN = new Scanner(System.in); // input
		
		int SENT = 0;
		String command = "";
		while (SENT < 1) {
			
			System.out.println("DRONE ID: " + d1.getID());
		System.out.println("CURRENT POSITION: " + "Relative Position(X):" + d1.getX() + " Height(Y): " + d1.getY()+  " Orientation in degrees(Z):"+ d1.getZ());
		
		System.out.println("W = Forward");
		System.out.println("S = Backward");
		System.out.println("A = Left");
		System.out.println("D = Right");
		System.out.println("Q = Up");
		System.out.println("E = Down");
		System.out.println("X = Exit");
		System.out.println("Input command and hit the button to execute:");
	
		command = IN.next();
		command = command.toUpperCase(); // Ensure we have no case issue
		// Only the first letter counts
		 if (command.contains("W"))
		{
			 d1.setX(d1.getX() + 1);
			 
			 System.out.println("Command Accepted");
		}
		
		 if (command.contains("S"))
			{
				 d1.setX(d1.getX() - 1);
				 
				 System.out.println("Command Accepted");
			}
			 
		 if (command.contains("A"))
			{
				 d1.setZ(d1.getZ() - 1);
				 
				 System.out.println("Command Accepted");
			}
			
		 if (command.contains("D"))
			{
				 d1.setZ(d1.getZ() + 1);
				 
				 System.out.println("Command Accepted");
			}
		 
		 if (command.contains("Q"))
			{
				 d1.setY(d1.getY() + 1);
				 
				 System.out.println("Command Accepted");
			}
		 
		 if (command.contains("E"))
			{
				 d1.setY(d1.getY() - 1);
				 
				 System.out.println("Command Accepted");
			}
		 
		else if (command.contains("X"))
		{
		System.out.println("Exit command issued");	
		 SENT = 2; // kill switch
		 IN.close();
		}
	
	
		}
		
		System.out.println("Drone Controller shutdown");
		System.out.println("Goodbye");
		
		
	}
}
