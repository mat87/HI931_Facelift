import java.util.Arrays;

public class TestExecutor {
	
	public void testToExecute(){
		
		OperatingProgramTest opt = new OperatingProgramTest();
		BasicFunctions func = new BasicFunctions();
		
		boolean[] results = new boolean[]{
				opt.setOperatingProgram(),
				opt.checkOperatingProgramButton(),
				opt.checkOperatingProgramHeader(),
				opt.checkOperatingProgramFooter()
		};
		
		boolean[] trueList = func.generateTrueList(results.length);
		
		if(Arrays.equals(results, trueList)){
			System.out.printf("----------------------\n");
			System.out.printf("TEST RESULT: SUCCESS\n");
			System.out.printf("----------------------");
		}
		else{
			System.out.printf("----------------------\n");
			System.out.printf("TEST RESULT: FAIL\n");
			System.out.printf("----------------------");
		}
				
	}
}
