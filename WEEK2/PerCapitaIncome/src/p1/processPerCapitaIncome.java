package p1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import fileReaderAndWriter.CSVFileReader;
import fileReaderAndWriter.CSVFileWriter;

public class processPerCapitaIncome {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);

		String file_input;
		String file_output;
		
		System.out.println("input file path:");
		file_input=sc.nextLine();
		
		System.out.println("output file path:");
		file_output=sc.nextLine();
		
		List<Income> list=new ArrayList<Income>();
		list=CSVFileReader.read(file_input); 
				
		processAverageIncome.newAverageIncome(list);
		
		List<Income> groupedList=new ArrayList<Income>();
		groupedList=groupByCountryAndGender.groupData(list);
		
		CSVFileWriter.Write(groupedList, file_output);
		System.out.println("Done successfully");
	}

}
