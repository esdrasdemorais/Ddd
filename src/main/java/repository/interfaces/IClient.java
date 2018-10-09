
package com.esdrasmorais.util.repository.interfaces;

import com.mongodb.client.MongoDatabase;

public interface IClient {
	public void setHost(String host);

	public void setPort(Integer port);

	public IDb getDb(String name);
	
	public MongoDatabase getMongoDatabase();
}
