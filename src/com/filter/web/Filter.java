package com.filter.web;

public interface Filter {

	public void doFile(Request requestStr,Response responseStr,FiltercChain chain);
}
