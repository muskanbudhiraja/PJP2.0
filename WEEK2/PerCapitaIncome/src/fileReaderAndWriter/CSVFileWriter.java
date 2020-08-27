package fileReaderAndWriter;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import p1.Income;

public class CSVFileWriter {
	private static String SEPARATOR=",";
	public static void Write(List<Income> list,String filename) {
		
		try {
			FileWriter writer=new FileWriter(filename);
			BufferedWriter out=new BufferedWriter(writer);
			String heading="Country/City Name , Gender , Average Income(USD)";
			out.append(heading);
			out.newLine();
			for(Income tr: list)
			{
				String data;
				if(tr.getCountry().isBlank())
					data=tr.getCity();
				else
					data=tr.getCountry();
				
				data+=SEPARATOR+tr.getGender()+SEPARATOR+tr.getAverageIncome();
				out.append(data);
				out.newLine();
				
			}
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
