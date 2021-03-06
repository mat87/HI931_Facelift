package testSuites;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import testFramework.Constants;
import testFramework.Driver;
import testFramework.ScreenContainer;
import testHI931.DefaultHomePageTest;

public class HI931DefaultHomePageSuite {

    DefaultHomePageTest defHomePage;
    Driver driver;

    public HI931DefaultHomePageSuite(){
        defHomePage = new DefaultHomePageTest();
        driver = new Driver();
    }


    @DataProvider(name = "homePageProvider")
    public Object[][] getData(){
        return new Object[][]{
                {ScreenContainer.Screens.FAVOURITES_HOME_PAGE.toString(), ScreenContainer.Screens.FAVOURITES_HOME_PAGE_HEADER.toString(), ScreenContainer.Buttons.FAVOURITES_CHECKBOX.toString(), ScreenContainer.Buttons.FAVOURITES_CHECKBOX_2.toString()},
                {ScreenContainer.Screens.ENERGY_COCKPIT_HOME_PAGE.toString(), ScreenContainer.Screens.ENERGY_COCKPIT_HOME_PAGE_HEADER.toString(), ScreenContainer.Buttons.ENERGY_COCKPIT_CHECKBOX.toString(), ScreenContainer.Buttons.ENERGY_COCKPIT_CHECKBOX_2.toString()},
                {ScreenContainer.Screens.HEATING_HOME_PAGE.toString(), ScreenContainer.Screens.HEATING_HOME_PAGE_HEADER.toString(), ScreenContainer.Buttons.HEATING_CHECKBOX.toString(), ScreenContainer.Buttons.HEATING_CHECKBOX_2.toString()}
        };
    }

    @Test(dataProvider = "homePageProvider")
    public void checkDefaultHomePage(String page, String expectedPage, String button, String button2){
        driver.goToSettingsMenu2();
        boolean result = defHomePage.selectDefaultHomePage(page, expectedPage, button, button2);
        if(!result){
            driver.getScreenShoot(Constants.FILE_PATH, page);
        }
        Assert.assertTrue(result);
    }
}
