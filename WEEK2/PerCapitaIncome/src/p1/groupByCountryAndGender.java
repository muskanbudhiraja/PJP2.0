package p1;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class groupByCountryAndGender {
	
	public static List<Income> groupData(List<Income> income) {
		
		List<Income> newList=new ArrayList<Income>();
		List<Income> list=new ArrayList<Income>();
		newList.addAll(income);
		for(Income in:newList) {
			
			if(in.getCountry().isBlank()) {
				
				in.setCountry(in.getCity());
			}
		}
		
		Map<String,Map<String,List<Income>>> groupedData=newList.stream().
				collect(Collectors.groupingBy(p-> p.getCountry() ,
						Collectors.groupingBy(p-> p.getGender())));
		//List<Income> list1=groupedData.Collectors.toList();
		
		for (var grpKey1 : groupedData.keySet()) {
			Map<String, List<Income>> m2 = groupedData.get(grpKey1);
			for (var grpKey2 : m2.keySet()) {
				var grpOutput = m2.get(grpKey2);
				list.addAll(grpOutput);
			}
		}

		for(Income in:list) {
			
			if(in.getCountry().equals(in.getCity())) {
				
				in.setCountry("");
			}
		}
		return list;
	}
}
