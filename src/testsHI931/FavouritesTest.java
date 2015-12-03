package testsHI931;

import automatedTestFramework.BasicFunctions;
import automatedTestFramework.Logger;

public class FavouritesTest {

	BasicFunctions basicFunction = new BasicFunctions();
	Logger log = new Logger();
	
	public boolean checkFavouritiesHeader(){
		System.out.println("++++++++++++++++++++++++++++++++++++++++ checkFavouritiesHeader() test ++++++++++++++++++++++++++++++++++++++++");
		System.out.println(log.separator);
		long startTest = System.currentTimeMillis();
		boolean result = false;
		
		basicFunction.goToMainMenu();
		basicFunction.goToFavouritesMenu();
		if (basicFunction.checkIfExist("FavouritiesHeader1.JPG")){
			result = true;
			System.out.println("Favourities header is correct.");			
			System.out.println("Test: Success" + '\n' + log.separator);
		}else{
			System.out.println("Favourities header is not correct.");
			System.out.println("Test: Fail" + '\n' + log.separator);
		}
		long endTest = System.currentTimeMillis();
		log.testExecutedInMs(startTest, endTest);
		return result;
	}
	
	public boolean checkFavouritiesMenuItems(){
		System.out.println("++++++++++++++++++++++++++++++++++++++++ checkFavouritiesMenuItems() test ++++++++++++++++++++++++++++++++++++++++");
		System.out.println(log.separator);
		long startTest = System.currentTimeMillis();
		boolean result = false;
		basicFunction.goToMainMenu();
		basicFunction.goToFavouritesMenu();
		if (basicFunction.checkIfExist("FavouritiesMenu1.JPG")){
			result = true;
			System.out.println("Favourities Menu is correct.");			
			System.out.println("Test: Success" + '\n' + log.separator);
		}else{
			System.out.println("Favourities Menu is not correct.");
			System.out.println("Test: Fail" + '\n' + log.separator);
		}
		long endTest = System.currentTimeMillis();
		log.testExecutedInMs(startTest, endTest);
		return result;
	}

	public boolean changeFavouritiesMenuItems(){
		System.out.println("++++++++++++++++++++++++++++++++++++++++ checkSettingsMenuItems() test ++++++++++++++++++++++++++++++++++++++++");
		System.out.println(log.separator);
		long startTest = System.currentTimeMillis();
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
						System.out.println("Favourities Menu change is correct.");			
						System.out.println("Test: Success" + '\n' + log.separator);
					}else{
						System.out.println("Favourities Menu change is not correct.");
						System.out.println("Test: Fail" + '\n' + log.separator);
					}
				}else{
					System.out.println("Favourities Menu change is not correct.");
					System.out.println("Test: Fail" + '\n' + log.separator);
				}
			}else{
				System.out.println("Favourities Menu change is not correct.");
				System.out.println("Test: Fail" + '\n' + log.separator);
			}
		long endTest = System.currentTimeMillis();
		log.testExecutedInMs(startTest, endTest);
		return result;
	}

}
