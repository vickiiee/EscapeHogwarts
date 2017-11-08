package caveExplorer;

public class Inventory {
	
	private String map;
	private static int attack;
	private static int hp;
	public boolean wand;
	private static int money;
	
	public Inventory()
	{
		updateMap();
		hp = 100;
		money = 0;
		attack = (int)(Math.random()*15 +1);
		wand = false;
	}

	public boolean hasWand() {
		return wand;
	}
	public static int getHp() {
		return hp;
	}

	public static int getAttack() {
		return attack;
	}

	public static void setHp(int hp) {
		Inventory.hp = hp;
	}

	public static int getMoney(){
		return money;
	}
	
	public static void setMoney(int mon){
		Inventory.money = mon;
	}
	
	public void updateMap() {
		
		map = " ";
		//horizontal line 
		for(int i =0; i<CaveExplorer.caves[0].length -1; i++)
		{
			map += "____";
		}
		//for symmetry add 3 underscores
		map += "___\n";
		for(CaveRoom[] row: CaveExplorer.caves)
		{
			for(int i=0; i <3; i++)
			{
				String text = "";
				for(CaveRoom cr:row)
				{
					//if a wall is present draw a line otherwise draw a "\"
					if(cr.getDoor(CaveRoom.WEST) != null &&
							cr.getDoor(CaveRoom.WEST).isOpen())
					{
						text += " ";
					}
					else
					{
						text += "|";
					}
					if(i ==0)
					{
						text += "   ";
					}
					else if( i== 1)
					{
						text+= " " + cr.getContents() + " ";
					}
					else if(i == 2)
					{
						if(cr.getDoor(CaveRoom.SOUTH) != null && 
								cr.getDoor(CaveRoom.SOUTH).isOpen())
						{
							text += "   ";
						}
						else
						{
							text += "___"; //closed door/wall
						}
					}
					
				}
				text += "|";
				map += text + "\n";
			}
		}
	}
	
	public String getDescription()
	{
		return map;
	}


}
