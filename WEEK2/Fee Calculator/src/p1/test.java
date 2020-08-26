package p1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import fileReaderAndWriter.CSVFileReader;
import fileReaderAndWriter.CSVFileWriter;

public class test {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		
		String file_input;
		String file_output;
		
		System.out.println("input file path:");
		file_input=sc.nextLine();
		
		System.out.println("output file path:");
		file_output=sc.nextLine();
		
		
		List<Transaction> list=new ArrayList<Transaction>();
		list=CSVFileReader.read(file_input); 
		
		TransactionFee.processFee(list);

		List<Transaction> groupedList=new ArrayList<Transaction>();
		groupedList=GroupTransactions.group(list);
		
		CSVFileWriter.Write(groupedList, file_output);
		
	}
}
