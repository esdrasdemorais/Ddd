
package com.esdrasmorais.ddd.repository;

import com.esdrasmorais.ddd.repository.interfaces.IClient;
import com.esdrasmorais.ddd.repository.interfaces.IDb;
import com.mongodb.client.MongoDatabase;

public abstract class DbImpl implements IDb {
	private static IDb db = null;
	protected IClient client;
	protected MongoDatabase mongoDatabase;

	public DbImpl(IClient client, MongoDatabase database) {
		//boolean auth = mongoDb.authenticate("username", "pwd".toCharArray());
		this.client = client;
		this.mongoDatabase = database;
		DbImpl.db = this;
	}
	
	public void setDb(IClient client, String name) {
		if (db == null)
			db = client.getDb(name);
	}

	public IDb getDb() {
		return db;
	}
	
	public MongoDatabase getMongoDatabase() {
		return this.mongoDatabase;
	}
}