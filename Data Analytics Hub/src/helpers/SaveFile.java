package helpers;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

//This class provides a method for saving text content to a file.
public class SaveFile {
	// Method to save the provided content to the specified file.
	public static void saveTextToFile(String content, File file) {
		try {
			// Initializing a PrintWriter to write content to the file.
			PrintWriter writer;
			writer = new PrintWriter(file);
			// Writing the content to the file.
			writer.println(content);
			writer.close();
		} catch (IOException ex) {
			Logger.getLogger(SaveFile.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

}
