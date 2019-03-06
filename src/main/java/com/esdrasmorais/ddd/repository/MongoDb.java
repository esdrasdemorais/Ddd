
package com.esdrasmorais.ddd.repository;

import com.esdrasmorais.ddd.repository.interfaces.IClient;
import com.mongodb.DBCollection;

public class MongoDb extends DbImpl {
	public MongoDb(IClient client, String database) {
		super(client, database);
	}

	public DBCollection getCollection(String collectionName) {
		return this.getDb().getCollection(collectionName);
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return this.getDb().getName();
	}
}