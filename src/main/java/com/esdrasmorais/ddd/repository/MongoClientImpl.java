
package com.esdrasmorais.ddd.repository;

import com.esdrasmorais.ddd.repository.interfaces.IDb;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

public class MongoClientImpl extends Client {	
	private void setMongoClient() {
		MongoClientURI mongoClientURI = new MongoClientURI(
			System.getProperty("mongo.uri")
		);
		this.mongoClient = new MongoClient(
			mongoClientURI
		);
	}
	
	public MongoClient getMongoClient() {
		return this.mongoClient;
	}
	
	public MongoClientImpl(String host, Integer port) {
		super(host, port);
		this.setMongoClient();
	}
	
	public MongoClientImpl(String connectionString) {
		super(null, null);
		this.setMongoClient();
	}

	@Override
	public IDb getDb(String database) {
		this.mongoDatabase = this.mongoClient.getDatabase(database);
		return new MongoDb(this, database);
	}
}