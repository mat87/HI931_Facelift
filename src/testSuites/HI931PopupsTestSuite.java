package testSuites;

import org.testng.Assert;
import org.testng.annotations.Test;

import automatedTestFramework.Constants;
import testsHI931.PopupTest;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class HI931PopupsTestSuite {
	
	PopupTest put = new PopupTest();
	Socket s;
	
	public HI931PopupsTestSuite() throws UnknownHostException, IOException{
		s = new Socket("localhost", 8899);
	}
	
	@Test
	public void testFaultPopup(){
		boolean result = put.checkPopup(s, Constants.FAULT_POPUP, "FaultPopup.JPG", "ConfirmButton.JPG", "PlusMinusOnHomeScreen.JPG");
		Assert.assertEquals(result, true);
	} 
	
	@Test
	public void testServicePopup(){
		boolean result = put.checkPopup(s, Constants.SERVICE_POPUP, "ServicePopup.JPG", "ConfirmButton.JPG", "PlusMinusOnHomeScreen.JPG");
		Assert.assertEquals(result, true);
	}
	
	@Test
	public void testBurnerFaultPopup(){
		boolean result = put.checkPopup(s, Constants.BURNER_FAULT_POPUP, "BurnerFaultPopup.JPG", "ConfirmOKButton.JPG", "PlusMinusOnHomeScreen.JPG");
		Assert.assertEquals(result, true);
	}
	
	@Test
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
