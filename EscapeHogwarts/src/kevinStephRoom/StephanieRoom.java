package kevinStephRoom;

import caveExplorer.CaveExplorer;
import caveExplorer.CaveRoom;
import caveExplorer.Inventory;
import caveExplorer.NPCRoom;
import caveExplorer.NPC;

public class StephanieRoom extends NPCRoom {
	
	NPC npc;
	
	public StephanieRoom(String description) {
		super(description);
		
	}
	
	public String validMoves() {
		return "wdsa";
	}
	
	public void printValidMoves()
	{
		System.out.println("You can only enter 'w', 'a', 's', or 'd'");
	}
	
	public void interpretInput(String input) {
		while(!isValid(input)) {
			printValidMoves();
			
			input = CaveExplorer.in.nextLine();
		}
		int direction =  validMoves().indexOf(input); 
		if(direction < 4) {
			goToRoom(direction);
		}else {
			performAction(direction);
		}
		
	}
	
	private boolean isValid(String input) {
		return validMoves().indexOf(input) != -1 && input.length() == 1;
	}
	
	public void performAction (int direction)
	{
		if(direction == 4) {
			if(npc != null && npc.isActive()) {
				npc.interact();
			}else {
				CaveExplorer.print("There is nothing to interect with.");
			}
		}else {
			CaveExplorer.print("That key does nothing.");
		}
	}
	
	public static void userEntered() {
		if(CaveExplorer.inventory.wand != true) {
			CaveExplorer.print("You see a wand laying on the floor and you pick it up in case it comes in handy. However, it comes with a price. You lose 10 HP.");	
			CaveExplorer.inventory.wand = true;
			int userHp = Inventory.getHp() - 10;
			Inventory.setHp(userHp);
			CaveExplorer.print("Your HP is now: " + userHp + ".");
		}else {
			CaveExplorer.print("There is nothing in here.");	
		}
	}
}	
	