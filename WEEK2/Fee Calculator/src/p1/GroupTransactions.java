package p1;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupTransactions {
	
	public static List<Transaction> group(List<Transaction> transaction)
	{
		List<Transaction> list=new ArrayList<Transaction>();
		Map<String, Map<String, Map<java.util.Date, Map<Character, List<Transaction>>>>> groupedTransactions= transaction.stream()
				.collect(Collectors.groupingBy(p->p.getClientId(),
				Collectors.groupingBy(p->p.getTransactionType(),
				Collectors.groupingBy(p->p.getTransactionDate(),
				Collectors.groupingBy(p->p.getPriorityFlag())))));
		System.out.println(groupedTransactions);
		
		for (var grpKey1 : groupedTransactions.keySet()) {
			Map<String, Map<Date, Map<Character, List<Transaction>>>> m2 = groupedTransactions.get(grpKey1);
			for (var grpKey2 : m2.keySet()) {
				Map<Date, Map<Character, List<Transaction>>> m3 = m2.get(grpKey2);
				for (var grpKey3 : m3.keySet()) {
					Map<Character, List<Transaction>> m4 = m3.get(grpKey3);
					for (var grpKey4 : m4.keySet()) {
						var grpOutput = m4.get(grpKey4);
						list.addAll(grpOutput);
					}
				}
			}
		}
		return list;
	}

}
