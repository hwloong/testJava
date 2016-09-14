package com.filter.web;

import org.junit.Test;

public class FilterTest {
	
	@Test
	public void testFilter(){
		String str = "<script> adfadfadfaandadfadtao";
		Filter htmlFilter = new HTMLFilter();
		Filter sqlFilter = new SQLFilter();
		Filter stringFilter  = new StringFilter();
		FiltercChain c = new FiltercChain();
		Request r = new Request();
		r.setRequestStr(str);
		Response p = new Response();
		p.setResponseStr("response");
		c.addFilter(htmlFilter).addFilter(stringFilter).addFilter(sqlFilter);
		c.doFile(r,p,c);
		System.out.println(r.getRequestStr());
		System.out.println(p.getResponseStr());

	}
}
