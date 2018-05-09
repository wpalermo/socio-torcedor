package com.wpalermo.socioTorcedor.service.impl;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

public class HystrixTest extends HystrixCommand<String>{

	protected HystrixTest(HystrixCommandGroupKey group) {
		super(group);
	}

	@Override
	protected String run() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
