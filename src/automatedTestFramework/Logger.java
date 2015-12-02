package automatedTestFramework;

import java.util.Arrays;

public class Logger {
	public String separator = "----------------------------------------------------------------------------------------------------------------------------";
	BasicFunctions func = new BasicFunctions();
	
	public long testExecutedInMs(long start, long end){
		long time = end - start;
		System.out.println("Test performed in:" + " " + time + "[ms]");
		return time;
	}
	
	/**
	 * Sum up test results, general information all pass or fail.
	 *  
	 * @param results	boolean list of test results
	 */
	public void sumUp (boolean [] results){
		boolean[] trueList = func.generateTrueList(results.length);
		if(Arrays.equals(results, trueList)){
			System.out.printf("----------------------\n");
			System.out.printf("TEST RESULT: SUCCESS\n");
			System.out.printf("All " + results.length + " tests passed\n");
			System.out.printf("----------------------");
		}else{
			int fails = countFails(results);
			System.out.printf("----------------------\n");
			System.out.printf("TEST RESULT: FAIL\n");
			System.out.printf(fails + " tests of " + results.length + " failed\n");
			System.out.printf("----------------------");
		}	
	}
	
	public int countFails (boolean [] results){
		int numberOfFails = 0;
		for (int i=0; i< results.length; i++){
			if (results[i] == false){
				numberOfFails++;
			}
		}
		return numberOfFails;
	}
}