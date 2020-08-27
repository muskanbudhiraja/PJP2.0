package fileReaderAndWriter;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import p1.Income;


public class CSVFileReader {

	public static final String delimiter=",";
	static List<Income> list= new ArrayList<Income>();
	
	public static List<Income> read(String filename) {

		FileReader fr;
		BufferedReader reader = null;
		try {
			fr= new FileReader(filename);
			reader= new BufferedReader(fr);
			String[] tempArr;
			String st="";
			
			reader.readLine();
			while((st=reader.readLine())!=null)
			{
				tempArr=st.split(delimiter);
				/*Transaction t=new Transaction(tempArr);
				if(t==null)
					System.out.println("my bad");
				else
					System.out.println(t);*/
				list.add(new Income(tempArr));
				
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