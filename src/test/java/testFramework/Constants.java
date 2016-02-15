package testFramework;

import org.sikuli.api.Screen;
import org.sikuli.api.ScreenLocation;
import org.sikuli.api.ScreenRegion;

/**
 * Class to store constant variables inside HI931 project.
 */
public final class Constants {

    public static final double HIGH_MINSCORE = 0.95;
    public static final double DEFAULT_MINSCORE = 0.9;
    public static final double LOWER_MINSCORE = 0.85;

    public static final String BOILER_TEMP_5 = "0101081002d601";

    public static final String FORMAT = ".jpg";

    public static final String FILE_PATH = "C:\\Workspace\\Viessmann.HI931.Automated.Tests\\images\\capturedScreens\\";
    /*
     * POP-UPs
     * */
    public final class Popup {
        public static final String FAULT_POPUP = "01017480200400000000000000000000000000000000000000000000000000000000000000";
        public static final String SERVICE_POPUP = "01017480200001000000000000000000000000000000000000000000000000000000000000";
        public static final String BURNER_FAULT_POPUP = "01017480200010000000000000000000000000000000000000000000000000000000000000";
        public static final String HYDRAULIC_BALANCING_POPUP_ON = "010179500101";
        public static final String HYDRAULIC_BALANCING_POPUP_OFF = "010179500100";
        public static final String PANEL_LOCKED_POPUP = "0101778F0101";
        public static final String TEST_OPERATION_POPUP = "010175800101";
    }
    /*
    * BOILERS
    * */
    public final class Boiler {
        public static final String VD300 = "010189000100";
        public static final String VD333F = "010189000102";
        public static final String VD343 = "010189000103";
        public static final String VITOSOLAR_300F = "010189000104";
    }
    /*
    * CYLINDERS
    * */
    public final class Cylinder {
        public static final String MONOVALENT = "010189000100";
        public static final String DUAL = "010167050103";
        public static final String CUVC = "010167050104";
    }

}
