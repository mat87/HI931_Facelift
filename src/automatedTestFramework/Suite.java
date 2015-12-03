package automatedTestFramework;

import testsHI931.*;
import testsVITOTROL300.*;
import automatedTestFramework.BasicFunctions;
import java.net.*;

public class Suite {
	boolean[] results;
	Socket s = null;
	BasicFunctions basicFunction = new BasicFunctions();
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
		s = basicFunction.openHiSocket();
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
		        		btt.checkChangeBoilerTemperature(s),
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
		basicFunction.closeHiSocket(s);
		log.sumUp(results);	
	}
}
