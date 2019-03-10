
package com.esdrasmorais.ddd.repository;

import com.esdrasmorais.ddd.repository.interfaces.IClient;
import com.mongodb.DBCollection;
import com.mongodb.client.MongoDatabase;

public class MongoDb extends DbImpl {
	public MongoDb(MongoDatabase database) {
		super(null, database);
	}
	
	public MongoDb(IClient client, MongoDatabase database) {
		super(client, database);
	}

	public DBCollection getCollection(String collectionName) {
		return this.getDb().getCollection(collectionName);
	}

	public String getName() {
		return this.getDb().getName();
	}
}