package com.wpalermo.socioTorcedor.hystrix;

public class RemoteServerSimulator {
	
	private long wait;
	 
    public RemoteServerSimulator(long wait) throws InterruptedException {
        this.wait = wait;
    }
 
    String execute() throws InterruptedException {
        System.out.println("inicio");
        Thread.sleep(wait);
        System.out.println("fim");
        return "Success";
    }

}
