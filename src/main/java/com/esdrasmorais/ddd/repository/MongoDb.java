
package com.esdrasmorais.ddd.repository;

import com.esdrasmorais.ddd.repository.interfaces.IClient;
import com.esdrasmorais.ddd.repository.interfaces.IDb;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.client.MongoDatabase;

public class MongoDb extends DbImpl {
	public MongoDb(IClient client, String database) {
		super(client, database);
	}

	public DBCollection getCollection(String collectionName) {
		return this.getDb().getCollection(collectionName);
	}
}
