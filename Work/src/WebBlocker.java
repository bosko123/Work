import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

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
	
	private static void blockWebPages(File file) {
		
		BufferedReader bufferedReader = null;
		BufferedWriter bufferedWriter = null;
		
		try {
			
			bufferedReader = new BufferedReader(new FileReader("websites-list.txt"));
			bufferedWriter = new BufferedWriter(new FileWriter(new File(file.getName() + ".backup"), false));
			
			while (bufferedReader.ready()) {
				
				bufferedWriter.write("127.0.0.1 " + bufferedReader.readLine() + " \n");
				
			}
			
		} catch (IOException e) {
			
			e.printStackTrace();
			
		}
		finally {
			
			try {
				
				bufferedReader.close();
				bufferedWriter.close();
				
			} catch (IOException e) {
				
				e.printStackTrace();
				
			}
			
		}
		
	}

}
