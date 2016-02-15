package testFramework;

public class ScreenContainer {

    public enum Buttons{
        OK ("OK.JPG"),
        OFF ("OFF.JPG"),
        CLEAN_SCREEN ("CleanScreenButton.JPG"),
        CONFIRM_BUTTON ("ConfirmButton.JPG"),
        CONFIRM_OK_BUTTON ("ConfirmOKButton.JPG"),
        RIGHT ("Right.JPG"),
        LEFT ("Left.JPG"),
        BACK ("Back.JPG"),
        FAVORITES_SELECT ("FavouritiesSelectButton.JPG"),
        PLUS ("Plus.JPG"),
        MINUS ("Minus.JPG"),
        SELECT ("Select.JPG"),
        HOME ("Home.JPG"),
        ENERGY_COCKPIT ("EnergyCockpitButton.JPG"),
        MENU ("Menu.jpg"),
        DHW_MENU ("DhwMenu.JPG"),
        SELECT_DEFAULT_HOME_PAGE ("SelectDefaultHomePage.JPG"),
        SETTINGS_MENU ("SettingsButton.JPG"),
        ENERGY_COCKPIT_CHECKBOX ("EnergyCockpitCheckBox.JPG"),
        FAVOURITES_CHECKBOX ("FavouritesCheckBox.JPG"),
        HEATING_CHECKBOX ("HeatingCheckBox.JPG");

        private String button;

        Buttons(String button) {
            this.button = button;
        }

        @Override
        public String toString() {
            return this.button;
        }
    }

    public enum Popups{
        TEST_OPERATION ("TestOperationPopup.JPG"),
        SERVICE ("ServicePopup.JPG"),
        FAULT ("FaultPopup.JPG"),
        FAULT_2 ("FaultPopup2.JPG"),
        BURNER_FAULT ("BurnerFaultPopup.JPG");

        private String popup;

        Popups(String popup){
            this.popup = popup;
        }

        @Override
        public String toString() {
            return this.popup;
        }
    }

    public enum Pages{
        CLEAN_SCREEN ("CleanScreenMenu.JPG"),
        DHW_MENU_ITEMS ("DhwMenuItems.JPG"),
        FAVOURITIES_MENU_1 ("FavouritiesMenu1.JPG"),
        FAVOURITIES_MENU_1_1 ("FavouritiesMenu1_1.JPG"),
        FAVOURITIES_MENU_2 ("FavouritiesMenu2.JPG"),
        FAVOURITIES_SELECT_MENU ("FavouritiesSelectMenu.JPG"),
        MAIN_MENU_1 ("MainMenu1.JPG"),
        MAIN_SCREEN ("MainScreen.JPG"),
        SETTINGS_MENU_1 ("SettingsMenu1.JPG"),
        SETTINGS_MENU_2 ("SettingsMenu2.JPG"),
        STANDBY_SCREEN_1 ("StandbyScreen1.JPG");

        private String page;

        Pages(String page){
            this.page = page;
        }

        @Override
        public String toString() {
            return this.page;
        }
    }

    public enum Screens{
        STAND_BY_MODE ("StandbyMode.JPG"),
        SETTING_HEADER ("SettingsHeader.JPG"),
        ROOM_TEMPERATURE_MAIN_MENU_LOWEST ("RoomTemperatureMainMenuLowest.JPG"),
        ROOM_TEMPERATURE_MAIN_MENU_HIGHEST ("RoomTemperatureMainMenuHighest.JPG"),
        ROOM_TEMPERATURE_MAIN_MENU_34 ("RoomTemperatureMainMenu34.JPG"),
        ROOM_TEMPERATURE_MAIN_Menu_6 ("RoomTemperatureMainMenu6.JP"),
        ROOM_TEMPERATURE_MAIN_MENU ("RoomTemperatureMainMenu.JPG"),
        ROOM_TEMPERATURE_HEADER ("RoomTemperatureHeader.JPG"),
        PLUS_MINUS_ON_HOME_SCRREN ("PlusMinusOnHomeScreen.JPG"),
        OUTSIDE_TEMPERATURE_12 ("OutsideTemperature12.JPG"),
        OPERATING_PROGRAM_STAND_BY ("OperatingProgramStandby.JPG"),
        OPERATING_PROGRAM_HEATING_DHW ("OperatingProgramHeatingDHW.JPG"),
        OPERATING_PROGRAM_DHW ("OperatingProgramDHW.JPG"),
        ONLY_DHW ("OnlyDHW.JPG"),
        MAIN_SCREEN ("MainScreen.JPG"),
        HEATING_AND_DHW ("HeatingAndDHW.JPG"),
        HC1_OPERATING_PROGRAM_HEADER ("HC1OperatingProgramHeader.JPG"),
        HC1_OPERATING_PROGRAM_FOOTER ("HC1OperatingProgramFooter.JPG"),
        FAVORITES_HEADER_2 ("FavouritiesHeader2.JPG"),
        FAVORITES_HEADER_1 ("FavouritiesHeader1.JPG"),
        DHW_ONLY ("DHWOnly.JPG"),
        DHW_MENU_HEADER ("DhwMenuHeader.JPG"),
        CLEAN_SCRREN ("CleanScreen.JPG"),
        BOILER_TEMPERATURE_47 ("BoilerTemperature47.JPG"),
        HEATING_HOME_PAGE ("HeatingHomePage.JPG"),
        ENERGY_COCKPIT_HOME_PAGE ("EnergyCockpitHomePage.JPG"),
        FAVOURITES_HOME_PAGE ("FavouritesHomePage.JPG"),
        HEATING_HOME_PAGE_HEADER ("HeatingPageHeader.JPG"),
        ENERGY_COCKPIT_HOME_PAGE_HEADER ("EnergyCockpitPageHeader.JPG"),
        FAVOURITES_HOME_PAGE_HEADER ("FavouritesPageHeader.JPG"),
        BOILER_TEMPEARTURE_5 ("BoilerTemperature5.JPG");

        private String screen;

        Screens(String screen){
            this.screen = screen;
        }

        @Override
        public String toString() {
            return this.screen;
        }
    }
}
