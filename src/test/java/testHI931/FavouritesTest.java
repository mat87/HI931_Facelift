package testHI931;

import testFramework.Driver;
import testFramework.ScreenContainer;
import testFramework.GUIElement;

public class FavouritesTest {

    Driver driver;
    GUIElement guielem;

    public FavouritesTest(){
        guielem = new GUIElement();
        driver = new Driver();
    }

    public boolean checkFavouritiesHeader(){
        boolean result = false;

        driver.goToMainMenu();
        driver.goToFavouritesMenu();
        if (guielem.checkIfExist(ScreenContainer.Screens.FAVORITES_HEADER_1.toString())){
            result = true;
        }
        return result;
    }

    public boolean checkFavouritiesMenuItems(){
        boolean result = false;
        driver.goToMainMenu();
        driver.goToFavouritesMenu();
        if (guielem.checkIfExist(ScreenContainer.Pages.FAVOURITIES_MENU_1.toString())){
            result = true;
        }
        return result;
    }

    public boolean changeFavouritiesMenuItems(){
        boolean result = false;
        driver.goToMainMenu();
        driver.goToFavouritesMenu();
        guielem.clickIfExist(ScreenContainer.Buttons.FAVORITES_SELECT.toString());
        if(guielem.checkIfExist(ScreenContainer.Pages.FAVOURITIES_SELECT_MENU.toString())){
            guielem.clickIfExist(ScreenContainer.Buttons.SELECT.toString());
            guielem.clickIfExist(ScreenContainer.Buttons.SELECT.toString());
            guielem.clickIfExist(ScreenContainer.Buttons.OK.toString());
            if(guielem.checkIfExist(ScreenContainer.Screens.FAVORITES_HEADER_2.toString()) &&
                                            guielem.checkIfExist(ScreenContainer.Screens.FAVORITES_HEADER_1.toString())){
                guielem.clickIfExist(ScreenContainer.Buttons.LEFT.toString());
                if(guielem.checkIfExist(ScreenContainer.Pages.FAVOURITIES_MENU_1_1.toString())){
                    result = true;
                }
            }
        }
        return result;
    }
}
