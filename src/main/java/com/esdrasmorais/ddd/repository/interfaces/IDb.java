
package com.esdrasmorais.ddd.repository.interfaces;

import com.mongodb.DBCollection;
import com.mongodb.client.MongoDatabase;

public interface IDb {
	public void setDb(IClient client, String database);

	public IDb getDb();
	
	public DBCollection getCollection(String collection);
	
	public String getName();
	
	public MongoDatabase getMongoDatabase();
}