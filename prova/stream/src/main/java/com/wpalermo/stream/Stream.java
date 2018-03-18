package com.wpalermo.stream;

public class Stream implements IStream{
	
	private String input;
	
	private int index;
	

	public Stream(String input) {
		this.input = input;
	}
	
	@Override
	public char getNext() {
		return input.charAt(index-1);
	}

	@Override
	public boolean hasNext() {
		
		if(index < input.length()) {
			index++;
			return true;
		}
		return false;
	}


	
	
	
}
