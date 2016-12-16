package com.designpatterns.Strategy;

public class BusinessContext {

	IDoAnything iDo;
	
	public BusinessContext(IDoAnything iDo) {
		this.iDo = iDo;
	}
	
	public void doAnything(){
		iDo.doAnything();
	}

}
