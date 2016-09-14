package com.filter;

import java.util.ArrayList;
import java.util.List;



public class FiltercChain {

	public List<Filter> filtercChain = new ArrayList<Filter>();
	
	public FiltercChain addFilter(Filter f){
		filtercChain.add(f);
		return this;
	}
	
	public String doFilter(String str){
		for(Filter f : filtercChain){
			str = f.doFile(str);
		}
		return str;
	}
}
