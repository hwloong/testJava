package com.filter.web;

public class SQLFilter implements Filter {

	@Override
	public void doFile(Request r,Response p,FiltercChain chain) {
		r.setRequestStr(r.getRequestStr().replace("and", "[and]")); 
		chain.doFile(r, p, chain);
		p.setResponseStr(p.getResponseStr()+"-------SQL------");
	}

}
