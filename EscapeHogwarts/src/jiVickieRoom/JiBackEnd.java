package jiVickieRoom;

import caveExplorer.CaveExplorer;

public class JiBackEnd implements VickieSupport {
	
	private int[][] magicSquares;
	private String numbers;//a symbol showing you what is in the room... //RENAME!!!!kjk
	
	private JiSupport frontend;
	
	private int total = 15;
	private int random;
	private int currentNumber;
	private int newNumber;
	private String usedNumbers;
	private String outerNumbers = "2648";
	private String innerNumbers = "7931";
	private int initiatedNum;
	private String StrInitiatedNum;

	public JiBackEnd(JiSupport frontend) {
		this.frontend = frontend;
		//magicSquares = magicSquares[3][3];
		magicSquares = new int[3][3];
		//createTheBox();
	}
/*
	public static void createTheBox() {
		for(int row = 0; row < magicSquares.length; row++){
			for(int col = 0; col < magicSquares[row].length; col++){
				magicSquares[row][col] = new magicSquares(row, col);
			}
		}
	}
*/

	public void checkMultiples(String character) {
		if(checkValid(character) == true) {
			newNumber = currentNumber;
			if(usedNumbers().indexOf(newNumber) > -1) {
				//replace original number with space or 'x' (FRONT END)
				//add number in new box (FRONT END)
			}else {
				usedNumbers += Integer.toString(newNumber);
				//add number in new box (FRONT END)
			}
		}
	}
	
	public boolean checkValid(String character) {
		if(validNumbers().indexOf(character) > -1 && character.length() == 1) {
			currentNumber = Integer.parseInt(character);
			return true;
		}else {
			return false;
		}
	}
	
	public String usedNumbers() {
		return usedNumbers;
	}

	public String validNumbers() {
		return "1234567890";
	}
	
	public void chooseStartingPoint() {
		createInitiateNum();
		isOuterNumber(initiatedNum);
		if(initiatedNum == 5) {
			magicSquares[1][1] = 5;
		}else {
			if(isOuterNumber(initiatedNum)) {
				//randomize outer starting box
				// (0,0) (0,2) (2,0) (2,2)
				int rowNum;
				int colNum;
				if(Math.random() < .5) {
					rowNum = 0;
				}else {
					rowNum = 2;
				}
				
				if(Math.random() < .5) {
					colNum = 0;
				}else {
					colNum = 2;
				}
				magicSquares[rowNum][colNum] = initiatedNum;
			}
			else {
				//randomize inner starting box
				// (0,1) (1,0) (1,2) (2,1)
				generateNumber(4);
				if(random == 1) {
					magicSquares[0][1] = initiatedNum;
				}else {
					if(random == 2) 
					{
						magicSquares[1][0] = initiatedNum;
					}
					else {
						if(random == 3) {
							magicSquares[1][2] = initiatedNum;
						}else {
							magicSquares[2][1] = initiatedNum;
						}
					}
				
				}
			}
		}
	}
	
	public boolean isOuterNumber(int num) {
		StrInitiatedNum = Integer.toString(num);
		if(outerNumbers.indexOf(StrInitiatedNum) > -1) {
			return true;
		}else {
			if(innerNumbers.indexOf(StrInitiatedNum) > -1) {
				return false;
			}else {
				getMid();
			}
		}
		return false;
	}
	
	public void createInitiateNum() {
		initiatedNum = (int)(Math.random() * 9) + 1;
	}

	public int generateNumber(int max) {
		random = (int)(Math.random() * max);
		return random;
	}
	
	public int getMid() {
		initiatedNum = 5;
		return initiatedNum;
	}
	
	public static boolean isNumeric(String str)  
	{  
	  try  
	  {  
	    Double.parseDouble(str);  
	  }  
	  catch(NumberFormatException nfe)  
	  {  
	    return false;  
	  }  
	  return true;  
	}
	
	public void checkTotal() {
		//check each row, column, diagonal == 15
		if(magicSquares[0][0] + magicSquares[0][1] + magicSquares[0][2] == 15) {
			if(magicSquares[1][0] + magicSquares[1][1] + magicSquares[1][2] == 15) {
				if(magicSquares[2][0] + magicSquares[2][1] + magicSquares[2][2] == 15) {
					
				}
			}
		}
	}

	public void cheatCode() {
		//VickieFrontEnd.endGame();
		
	}

	public int[][] getBoxes() {
		return magicSquares;
	}

}
