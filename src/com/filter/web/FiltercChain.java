package com.filter.web;

import java.util.ArrayList;
import java.util.List;



public class FiltercChain implements Filter{

	public List<Filter> filtercChain = new ArrayList<Filter>();
	
	int index = 0;
	public FiltercChain addFilter(Filter f){
		filtercChain.add(f);
		return this;
	}
	
	public void doFile(Request requestStr,Response responseStr,FiltercChain chain){
		if(filtercChain.size()== index){
			return;
		}
		Filter f = filtercChain.get(index);
		index ++;
		f.doFile(requestStr, responseStr, chain);
	}

}
