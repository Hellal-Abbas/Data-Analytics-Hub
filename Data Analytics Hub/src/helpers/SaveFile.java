package helpers;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SaveFile {

	public static void saveTextToFile(String content, File file) {
		try {
			PrintWriter writer;
			writer = new PrintWriter(file);
			writer.println(content);
			writer.close();
		} catch (IOException ex) {
			Logger.getLogger(SaveFile.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

}
