package com.filter;

public class SQLFilter implements Filter {

	@Override
	public String doFile(String str) {
		str = str.replace("and", "[and]");
		return str;
	}

}
