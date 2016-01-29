package testHI931;

import automatedTestFramework.BasicFunctions;
import automatedTestFramework.ScreenContainer;

public class FavouritesTest {
    BasicFunctions basicFunction = new BasicFunctions();


    public boolean checkFavouritiesHeader(){
        boolean result = false;

        basicFunction.goToMainMenu();
        basicFunction.goToFavouritesMenu();
        if (basicFunction.checkIfExist(ScreenContainer.Screens.FAVORITES_HEADER_1.toString())){
            result = true;
        }
        return result;
    }

    public boolean checkFavouritiesMenuItems(){
        boolean result = false;
        basicFunction.goToMainMenu();
        basicFunction.goToFavouritesMenu();
        if (basicFunction.checkIfExist(ScreenContainer.Pages.FAVOURITIES_MENU_1.toString())){
            result = true;
        }
        return result;
    }

    public boolean changeFavouritiesMenuItems(){
        boolean result = false;
        basicFunction.goToMainMenu();
        basicFunction.goToFavouritesMenu();
        basicFunction.clickIfExist(ScreenContainer.Buttons.FAVORITES_SELECT.toString());
        if(basicFunction.checkIfExist(ScreenContainer.Pages.FAVOURITIES_SELECT_MENU.toString())){
            basicFunction.clickIfExist(ScreenContainer.Buttons.SELECT.toString());
            basicFunction.clickIfExist(ScreenContainer.Buttons.SELECT.toString());
            basicFunction.clickIfExist(ScreenContainer.Buttons.OK.toString());
            if(basicFunction.checkIfExist(ScreenContainer.Screens.FAVORITES_HEADER_2.toString()) &&
                                            basicFunction.checkIfExist(ScreenContainer.Screens.FAVORITES_HEADER_1.toString())){
                basicFunction.clickIfExist(ScreenContainer.Buttons.LEFT.toString());
                if(basicFunction.checkIfExist(ScreenContainer.Pages.FAVOURITIES_MENU_1_1.toString())){
                    result = true;
                }
            }
        }
        return result;
    }
}
