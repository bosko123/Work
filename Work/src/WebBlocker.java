import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class WebBlocker {

	public void startBlocker(int time) {
		
		File ftb = new File("C:\\Windows\\System32\\drivers\\etc\\hosts");
		File bu = new File(ftb.getName() + ".backup");
		BackupHandler backupHandler = new BackupHandler();
		
		if (bu.exists() && !bu.isDirectory())
			backupHandler.loadBackup(ftb);
		
		backupHandler.makeBackup(ftb);
		blockWebPages(ftb);
		
		long timeStarted = System.nanoTime();
		
		while ((System.nanoTime() - timeStarted) / 1000000000 < time) {
			
			System.out.println((System.nanoTime() - timeStarted) / 1000000000);
			
		}
		
		System.out.println((System.nanoTime() - timeStarted) / 1000000000);
		
		backupHandler.loadBackup(ftb);
		new File(ftb.getName() + ".backup").delete();
		
	}
	
	private void blockWebPages(File file) {
		
		BufferedReader bufferedReader = null;
		BufferedWriter bufferedWriter = null;
		
		try {
			
			bufferedReader = new BufferedReader(new FileReader("websites_list.txt"));
			bufferedWriter = new BufferedWriter(new FileWriter(file, true));
			
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
