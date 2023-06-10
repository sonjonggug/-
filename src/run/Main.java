package run;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Main {

	
	public static void main(String[] args) {
			
		String processName = "가"; 
		// processName 을 | 기준으로 잘라서 리스트에 넣기
    	List<String> list = Arrays.asList(processName.split("\\|"));    	
    	    	    
    	// 리스트 사이즈만큼 돌면서 map에 담기
    	for(int i = 0 ; list.size() > i; i++) {
    		System.out.println(list.get(i));        	
    	}

		
		
		
		
		  
	 }
	
}
