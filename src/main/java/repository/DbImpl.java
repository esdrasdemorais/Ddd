
package com.esdrasmorais.util.repository;

import com.esdrasmorais.util.repository.interfaces.IClient;
import com.esdrasmorais.util.repository.interfaces.IDb;
import com.mongodb.client.MongoDatabase;

public abstract class DbImpl implements IDb {
	private static IDb db = null;

	public DbImpl(IClient client, String database) {
		db = client.getDb(database);
		//boolean auth = mongoDb.authenticate("username", "pwd".toCharArray());
	}
	
	public static IDb setDb(IClient client, String name) {
		if (db == null)
			db = client.getDb(name);
		return db;
	}

	public IDb getDb() {
		return db;
	}
}
