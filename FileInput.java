package test1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class FileInput {

	private FileInputStream fileInputStream = null;

	public FileInput(String fileInputStream) {
		super();
		try {
			this.fileInputStream=new FileInputStream(fileInputStream);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public FileInputStream getFileInputStream() {
		return fileInputStream;
	}

	public void setFileInputStream(FileInputStream fileInputStream) {
		this.fileInputStream = fileInputStream;
	}

}
