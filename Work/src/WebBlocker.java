import java.io.File;

public class WebBlocker {

	public static void main(String[] args) {
		
		File ftb = new File("C:\\Windows\\System32\\drivers\\etc\\hosts");
		
		int time = 10;
		long timeStarted = System.nanoTime();
		
		while ((System.nanoTime() - timeStarted) / 1000000000 < time) {
			
			System.out.println((System.nanoTime() - timeStarted) / 1000000000);
			
		}
		
		System.out.println((System.nanoTime() - timeStarted) / 1000000000);
		
	}
	
	private static void blockWebPages() {
		
		
		
	}

}
