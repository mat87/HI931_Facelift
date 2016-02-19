package testHI931;

import testFramework.GUIElement;
import testFramework.ScreenContainer;

public class DefaultHomePageTest {

    GUIElement guiElement;

    public DefaultHomePageTest(){
        guiElement = new GUIElement();
    }

    public boolean selectDefaultHomePage(String homePage, String expectedPage, String button, String button2){
        boolean result = false;
        guiElement.clickIfExist(ScreenContainer.Buttons.SELECT_DEFAULT_HOME_PAGE.toString());
        if(guiElement.checkIfExist(homePage)){
            if(guiElement.clickIfExist(button, 1) || guiElement.clickIfExist(button2, 1))
            guiElement.clickIfExist(ScreenContainer.Buttons.OK.toString());
            if(guiElement.checkIfExist(expectedPage)){
                result = true;
            }
        }
        return result;
    }
}
