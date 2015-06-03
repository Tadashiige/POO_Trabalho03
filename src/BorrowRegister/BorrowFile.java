package BorrowRegister;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class BorrowFile {
final static private String fileName = "borrowData.csv";
	
	public BorrowFile(){		
	}
	
	
	private static ArrayList<BorrowRegister> readFile (BufferedReader in){		
		
		ArrayList<BorrowRegister> bookList = new ArrayList<BorrowRegister>();
    	String csv;
        try {
			while((csv = in.readLine()) != null) {
			    bookList.add(BorrowParser.parse(csv));
			}
			in.close();
		} catch (IOException e) {
			System.out.println("Error reading the file!");
		}
        return bookList;
	}
	
	//le a coleção de book do arquivo
	public static ArrayList<BorrowRegister> loadFile (){		
		 
		BufferedReader in = null;
		
		//tentar abrir arquivo. Caso não encontre criar um novo.
	    try {
	        in = new BufferedReader(new FileReader(fileName));	        
	    }
	    
	    catch(FileNotFoundException e) {
	        try {
				new PrintWriter(new FileWriter(fileName)).close();
				in = new BufferedReader(new FileReader(fileName));
			} catch (IOException e1) {
				System.out.println("Error creating the file!");
			}
	    }
	    
	    return readFile(in);
	    	   
	}
	
	
	//salva coleção de book no arquivo
	public static void writeFile (ArrayList<BorrowRegister> borrowList){
		try {
			PrintWriter out = new PrintWriter(new FileWriter(fileName));
			borrowList
				.stream()
				.forEach(borrow -> out.println(borrow));
			out.close();
		}
	    catch(IOException e) {
	        System.out.println("Error writing the file!");
	    }
	}

}
