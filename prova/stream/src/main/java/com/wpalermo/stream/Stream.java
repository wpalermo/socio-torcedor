package com.wpalermo.stream;

public class Stream implements IStream{
	
	private String input;
	

	public Stream(String input) {
		this.input = input;
	}
	
	@Override
	public char getNext() {
		return 0;
	}

	@Override
	public boolean hasNext() {
		return false;
	}


	
	
	
}
