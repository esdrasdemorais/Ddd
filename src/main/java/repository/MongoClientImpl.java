
package com.esdrasmorais.util.repository;

import com.esdrasmorais.util.repository.interfaces.IDb;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

public class MongoClientImpl extends Client {	
	private void setMongoClient() {
		this.mongoClient = new MongoClient(this.getHost(), this.getPort());
	}
	
	public MongoClient getMongoClient() {
		return this.mongoClient;
	}
	
	public MongoClientImpl(String host, Integer port) {
		super(host, port);
		this.setMongoClient();
	}

	@Override
	public IDb getDb(String database) {
		this.mongoDatabase = this.mongoClient.getDatabase(database);
		return new MongoDb(this, database);
	}
}
