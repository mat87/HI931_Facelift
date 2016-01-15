package testSuites;

import java.net.Socket;
import org.testng.Assert;
import org.testng.annotations.Test;
import automatedTestFramework.Constants;
import automatedTestFramework.BasicFunctions;
import testsHI931.PopupTest;


public class HI931PopupsTestSuite {
	
	PopupTest put = new PopupTest();
	BasicFunctions basicFunctions = new BasicFunctions();
	Socket s;
	
	//@Test(priority = 1)
	public void testFaultPopup(){
		s = basicFunctions.openHiSocket();
		boolean result = put.checkPopup(s, Constants.FAULT_POPUP, "FaultPopup2.JPG", "ConfirmButton.JPG", "PlusMinusOnHomeScreen.JPG");
		Assert.assertEquals(result, true);
	} 
	
	//@Test
	public void testServicePopup(){
		boolean result = put.checkPopup(s, Constants.SERVICE_POPUP, "ServicePopup.JPG", "ConfirmButton.JPG", "PlusMinusOnHomeScreen.JPG");
		basicFunctions.closeHiSocket(s);
		Assert.assertEquals(result, true);
	}
	
	@Test
	public void testBurnerFaultPopup(){
		boolean result = put.checkPopup(s, Constants.BURNER_FAULT_POPUP, "BurnerFaultPopup.JPG", "ConfirmOKButton.JPG", "PlusMinusOnHomeScreen.JPG");
		Assert.assertEquals(result, true);
	}
	
	//@Test
	public void testTestOperationPopup(){
		boolean result = put.checkPopup(s, Constants.TEST_OPERATION_POPUP, "TestOperationPopup.JPG", "OFF.JPG", "PlusMinusOnHomeScreen.JPG");
		Assert.assertEquals(result, true);
	}
	
	//@Test
	public void testTestOperationPopupTimeout() throws InterruptedException{
		boolean result = put.checkPopupTimeout(s, Constants.TEST_OPERATION_POPUP, "TestOperationPopup.JPG", "MainMenu1.JPG", 1860000);
		Assert.assertEquals(result, true);
	}
}
