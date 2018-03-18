package com.wpalermo.stream;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		
		Stream s = new Stream("aAbBABacafe");
		
		firstChar(s);
		
	}

	public static char firstChar(IStream input) {
		
		boolean foiVogal = false;
		boolean foiCons = false;
		int contador = 0;
		List<Character> charList = new ArrayList<Character>();
		String auxx = "";
		
		while(input.hasNext()) {
			
			
			
			Character c = input.getNext();
			
			auxx = auxx.concat(c.toString());
			
			if(foiVogal && foiCons && isVogal(c)) {
				charList.add(c);
				foiCons = false;
			}
			
			
			if(isVogal(c)) {
				foiVogal = true;
			}
			
			if(foiCons && !isVogal(c))
				foiVogal = false;
			
			if(foiCons && isVogal(c))
				foiCons = false;
			
			if(foiVogal && !isVogal(c)) {
				foiCons = true;
			}


			
			
		}
		
		
		int repetidos = 0;
		Character returnable = null;
		for(Character c : charList) {
			returnable = c;
			for(char auxC : auxx.toCharArray()) {
				if(c == auxC)
					repetidos++;
				if(repetidos > 1) {
					returnable = null;
					repetidos = 0;
					break;
				}
					
			}
			
					
		}
		
		
		
		return returnable;

	}
	
	
	private static boolean isVogal(char c) {
		if(c == 'a' || c == 'e' || c == 'i'|| c == 'o'|| c == 'u'|| c == 'A'|| c == 'E'|| c == 'I'|| c == 'O'|| c == 'U')
			return true;
		else 
			return false;
	}

}
