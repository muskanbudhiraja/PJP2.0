package p1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class TransactionFee {

	public static void processFee(List<Transaction> transactions) {
		for(Transaction t: transactions) {
			normalTransaction(t);
		}
		intraDayTransaction(transactions);
	}
	public static void normalTransaction(Transaction obj) {

		if (obj.getPriorityFlag() == 'Y') {

			obj.setFee(500);
		} else if (obj.getTransactionType().equalsIgnoreCase("sell")
				|| obj.getTransactionType().equalsIgnoreCase("withdraw")) {
			obj.setFee(100);
		} else {
			obj.setFee(50);
		}
	}
		
	public static void intraDayTransaction(List<Transaction> list)
	{
		HashSet<String> set=new HashSet<String>();
		HashMap<String,String> map=new HashMap<String,String>();
		
		for(Transaction tr:list) {
			String key=tr.getClientId()+"_"+tr.getSecurityId()+"_"+
					tr.getTransactionDate();
			if(tr.getTransactionType().equalsIgnoreCase("sell")) {
				String findKey=key+"_buy";
				if(map.containsKey(findKey))
				{
					set.add(map.get(findKey));
					map.remove(findKey);
				}
				else {
					key=key+"_sell";
					map.put(key, tr.getExtTransactionId());
				}
			}
			else if(tr.getTransactionType().equalsIgnoreCase("buy")) {
				String findKey=key+"_sell";
				if(map.containsKey(findKey))
				{
					set.add(map.get(findKey));
					map.remove(findKey);
				}
				else {
					key=key+"_buy";
					map.put(key, tr.getExtTransactionId());
				}
			}
			
		}
		
		for(Transaction tr:list) {
			if(set.contains(tr.getExtTransactionId()))
			{
				int fee=tr.getFee()+10;
				tr.setFee(fee);
				set.remove(tr.getExtTransactionId());
			}
		}
	}

}
