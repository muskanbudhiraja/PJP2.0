package fileReaderAndWriter;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import p1.Transaction;


public class CSVFileReader {

	public static final String delimiter=",";
	static List<Transaction> list= new ArrayList<Transaction>();
	
	public static List<Transaction> read(String filename) {

		FileReader fr;
		BufferedReader reader = null;
		try {
			fr= new FileReader(filename);
			reader= new BufferedReader(fr);
			String[] tempArr;
			String st="";
			
			while((st=reader.readLine())!=null)
			{
				tempArr=st.split(delimiter);
				/*Transaction t=new Transaction(tempArr);
				if(t==null)
					System.out.println("my bad");
				else
					System.out.println(t);*/
				list.add(new Transaction(tempArr));
				
			}
			//System.out.println("list"+ list);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;
		

	}
}