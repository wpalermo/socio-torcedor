package com.wpalermo.HystrixDashboard;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Des {

	public static void main(String[] args) throws IOException {

		
		Integer qtdLinhas = 0;
		
		List<List<Integer>> values = new ArrayList<List<Integer>>();
		
		Path path = Paths.get("C:\\DEVELOP\\caso1.txt");
		
		Stream<String> lines = Files.lines(path);
		
		List<String> teste = lines.map(String::valueOf).collect(Collectors.toList());
		
		qtdLinhas = Integer.valueOf(teste.get(0));
	
		teste.remove(0);
		
		
		teste.forEach(line -> {
			
			
			
			if(line.contains(" ")) {
				List<Integer> list = new ArrayList<Integer>();
				
				for(String s : line.split(" ")) 
					list.add(Integer.valueOf(s));
				values.add(list);
			}
				
		});
		
		for(List<Integer> lista : values) {

			
			
		}
	}
	
	
	

}


class caso{
	
	private Integer qtdColunas;
	private List<Integer> colunas;
	
}
