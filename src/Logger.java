
public class Logger {

	public long testExecutedInMs(long start, long end){
		long time = end - start;
		System.out.println("Test performed in:" + " " + time + "[ms]");
		return time;
	}
}
