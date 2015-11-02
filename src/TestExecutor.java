
public class TestExecutor {
	
	public void testToExecute(){
		
		OperatingProgramTest opt = new OperatingProgramTest();
		
		boolean[] results = new boolean[]{
				opt.setOperatingProgram(),
				opt.checkOperatingProgramButton(),
				opt.checkOperatingProgramHeader(),
				opt.checkOperatingProgramFooter()
		};
			
		if(results.equals(true)){
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
