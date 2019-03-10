
package com.esdrasmorais.ddd.repository.interfaces;

import com.mongodb.MongoClient;

public interface IClient {
	public void setHost(String host);

	public void setPort(Integer port);

	public IDb getDb(String name);
	
	public MongoClient getMongoClient();
}