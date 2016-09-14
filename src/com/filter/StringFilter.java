package com.filter;

public class StringFilter implements Filter {

	@Override
	public String doFile(String str) {
		str = str.replace("tao", "aadf");
		return str;
	}

}
