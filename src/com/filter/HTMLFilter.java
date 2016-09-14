package com.filter;

public class HTMLFilter implements Filter {

	
	@Override
	public String doFile(String str) {
		str = str.replace("<", "[").replace(">", "]");
		return str;
	}

}
