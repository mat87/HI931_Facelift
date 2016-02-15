package testHI931;

import testFramework.Driver;
import testFramework.GUIElement;
import testFramework.ScreenContainer;

public class DefaultHomePageTest {

    Driver driver;
    GUIElement guiElement;

    public DefaultHomePageTest(){
        driver = new Driver();
        guiElement = new GUIElement();
    }

    public boolean selectDefaultHomePage(String homePage, String expectedPage, String button){
        boolean result = false;
        driver.goToSettingsMenu2();
        guiElement.clickIfExist(ScreenContainer.Buttons.SELECT_DEFAULT_HOME_PAGE.toString());
        if(guiElement.checkIfExist(homePage)){
            guiElement.clickIfExist(button, 1);
            guiElement.clickIfExist(ScreenContainer.Buttons.OK.toString());
            if(guiElement.checkIfExist(expectedPage)){
                result = true;
            }
        }
        return result;
    }
}
