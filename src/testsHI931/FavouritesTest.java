package testsHI931;

import automatedTestFramework.BasicFunctions;

public class FavouritesTest {
	BasicFunctions basicFunction = new BasicFunctions();

	
	public boolean checkFavouritiesHeader(){
		boolean result = false;
		
		basicFunction.goToMainMenu();
		basicFunction.goToFavouritesMenu();
		if (basicFunction.checkIfExist("FavouritiesHeader1.JPG")){
			result = true;
		}
		return result;
	}
	
	public boolean checkFavouritiesMenuItems(){
		boolean result = false;
		basicFunction.goToMainMenu();
		basicFunction.goToFavouritesMenu();
		if (basicFunction.checkIfExist("FavouritiesMenu1.JPG")){
			result = true;
		}
		return result;
	}

	public boolean changeFavouritiesMenuItems(){
		boolean result = false;
		basicFunction.goToMainMenu();
		basicFunction.goToFavouritesMenu();
		basicFunction.clickIfExist("FavouritiesSelectButton.JPG");
			if(basicFunction.checkIfExist("FavouritiesSelectMenu.JPG")){
				basicFunction.clickIfExist("Select.JPG");
				basicFunction.clickIfExist("Select.JPG");
				basicFunction.clickIfExist("OK.JPG");
				if(basicFunction.checkIfExist("FavouritiesHeader2.JPG") && basicFunction.checkIfExist("FavouritiesMenu1.JPG")){
					basicFunction.clickIfExist("Left.JPG");
					if(basicFunction.checkIfExist("FavouritiesMenu1_1.JPG")){
						result = true;
					}
				}
			}
		return result;
	}
}
