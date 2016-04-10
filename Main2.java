package test1;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main2 {

	@SuppressWarnings({ "unused", "resource" })
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.println("Give the BaseFile path");
		String baseFilePath = scanner.next();
		FileInput fileInput1 = new FileInput(baseFilePath);

		// input file
		System.out.println("Give the InputFile path");
		String inputFilePath = scanner.next();
		FileInput fileInput2 = new FileInput(inputFilePath);

		System.out.println("Give the OutputFile path");
		String outFilePath = scanner.next();

		int data = 0;
		int flag = 0;

		boolean status = false;

		String[] chunks1 = null;
		String[] chunks2 = null;

		List<String> temp1 = new ArrayList<String>();
		List<String> temp2 = new ArrayList<String>();

		Scanner scanner1 = new Scanner(fileInput1.getFileInputStream());
		Scanner scanner2 = new Scanner(fileInput2.getFileInputStream());

		while (scanner1.hasNext()) {

			// base data
			if (fileInput1.getFileInputStream() != null) {
				String line = scanner1.nextLine();
				chunks1 = line.split(",");
				flag++;

			}
			for (String s : chunks1) {
				temp1.add(s);

			}

			// input data
			if (fileInput2.getFileInputStream() != null) {
				String line = scanner2.nextLine();
				chunks2 = line.split(",");
			}
			for (String s : chunks2) {

				temp2.add(s);

			}
		}
		int sizeOfTwoLists = Math.min(temp1.size(), temp2.size());
		StringBuilder stringBuilder = new StringBuilder();
		String line = null;
		String[] lines = null;
		for (int i = 0; i < sizeOfTwoLists; i++) {
			if (temp1.get(i).equals(temp2.get(i))) {
				
			} else {
				stringBuilder.append(temp1.get(i) + ",");

				line = temp1.get(i) + ",";
				System.out.print(line);
			}

			try {
				FileWriter fileWriter = new FileWriter(outFilePath,true);
				fileWriter.write(line);
				fileWriter.flush();
				fileWriter.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}catch (NullPointerException e) {
				// TODO: handle exception
				System.out.println("No rejections");
			}
		}

	}

}
