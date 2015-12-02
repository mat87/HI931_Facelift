package automatedTestFramework;

import testsHI931.*;
import testsVITOTROL300.*;

public class Suite {
	boolean[] results;
	OperatingProgramTest opt = new OperatingProgramTest();
	OutsideTemperatureTest ott = new OutsideTemperatureTest();
	BoilerTemperatureTest btt = new BoilerTemperatureTest();
	RoomTemperatureTest rtt = new RoomTemperatureTest();
	DhwTest dhwt = new DhwTest();
	StandbyTest sbt = new StandbyTest();
	CleanScreenTest cst = new CleanScreenTest();
	SettingsTest stt = new SettingsTest();
	FavouritesTest ftt = new FavouritesTest();
	
	energyGasConsumptionTest energyGas = new energyGasConsumptionTest();
	Logger log = new Logger();
	
	public void executeSuite(String projectName, String suiteName){
		
		if(projectName.equals("HI931")){	
			switch (suiteName) {
		        case "REGRESSION": results = new boolean[]{
						opt.setOperatingProgram(),
						opt.checkOperatingProgramHeader(),
						opt.checkOperatingProgramFooter()
						};
		        		break;
		        case "SMOKE": results = new boolean[]{
		        		opt.setOperatingProgram(),
		        		opt.checkOperatingProgramHeader(),
						opt.checkOperatingProgramFooter(),
						ott.checkOutsideTemperature(),
						btt.checkBoilerTemperature(),
						rtt.checkRoomTemperatureHeader(),
						rtt.SetRoomTemperatureTest(),
						dhwt.checkDhwMenu(),
						cst.checkClearScreen(),
						stt.checkSettingsHeader(),
						stt.checkSettingsMenuItems(),
						ftt.checkFavouritiesHeader(),
						ftt.checkFavouritiesMenuItems(),
						sbt.check2minutesStandby()
						};
		                break;
		        default: break;
			}
		}else if(projectName.equals("VITOTROL300")){
			switch (suiteName){
		        case "REGRESSION": results = new boolean[]{
		        		energyGas.checkGas(),
		        		energyGas.checkEnergy()
						};
		        		break;
		        case "SMOKE": results = new boolean[]{
		        		energyGas.checkGas(),
		        		energyGas.checkEnergy()
		        		};
		                 break;
		        default: break;
			}
		}
		log.sumUp(results);	
	}
}
