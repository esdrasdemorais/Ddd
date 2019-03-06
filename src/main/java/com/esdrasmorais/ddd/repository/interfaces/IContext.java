
package com.esdrasmorais.ddd.repository.interfaces;

import java.net.UnknownHostException;

public interface IContext {
	public void init(IContext context) throws UnknownHostException;

	public IContext get();

	public IContext connect(String name);
	
	public IClient getClient();
}
