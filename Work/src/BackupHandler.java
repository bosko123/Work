import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BackupHandler {

	private void makeBackup(File file) {
		
		BufferedReader bufferedReader = null;
		BufferedWriter bufferedWriter = null;
		
		try {
			
			bufferedReader = new BufferedReader(new FileReader(file));
			bufferedWriter = new BufferedWriter(new FileWriter(new File(file.getName() + ".backup"), false));
			
			while (bufferedReader.ready()) {
				
				bufferedWriter.write(bufferedReader.readLine() + "\n");
				
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
	
	private void loadBackup(File file) {
		
		BufferedReader bufferedReader = null;
		BufferedWriter bufferedWriter = null;
		
		try {
			
			bufferedReader = new BufferedReader(new FileReader(new File(file.getName() + ".backup")));
			bufferedWriter = new BufferedWriter(new FileWriter(file, false));
			
			while (bufferedReader.ready()) {
				
				bufferedWriter.write(bufferedReader.readLine() + "\n");
				
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
