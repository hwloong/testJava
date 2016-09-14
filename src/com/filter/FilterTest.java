package com.filter;

import org.junit.Test;

public class FilterTest {
	
	@Test
	public void testFilter(){
		String str = "<script> adfadfadfaandadfadtao";
		Filter htmlFilter = new HTMLFilter();
		Filter sqlFilter = new SQLFilter();
		Filter stringFilter  = new StringFilter();
		FiltercChain c = new FiltercChain();
		c.addFilter(htmlFilter).addFilter(stringFilter).addFilter(sqlFilter);
		str = c.doFilter(str);
		System.out.println(str);
	}
}
