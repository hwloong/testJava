package com.filter.web;

public class StringFilter implements Filter {

	@Override
	public void doFile(Request r,Response p,FiltercChain chain) {
		r.setRequestStr(r.getRequestStr().replace("tao", "aadf")); 
		chain.doFile(r, p, chain);
		p.setResponseStr(p.getResponseStr()+"-------String------");
	}

}
