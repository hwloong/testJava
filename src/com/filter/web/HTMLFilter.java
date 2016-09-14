package com.filter.web;

public class HTMLFilter implements Filter {

	
	@Override
	public void doFile(Request r,Response p,FiltercChain chain) {
		
		r.setRequestStr(r.getRequestStr().replace("<", "[").replace(">", "]"));
		chain.doFile(r,p,chain);
		p.setResponseStr(p.getResponseStr()+"-------HTML------");
	}

}
