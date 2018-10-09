
package com.esdrasmorais.util.repository;

import java.net.UnknownHostException;

import com.esdrasmorais.util.repository.interfaces.IClient;
import com.esdrasmorais.util.repository.interfaces.IContext;
import com.esdrasmorais.util.repository.interfaces.IDb;
import com.mongodb.client.MongoDatabase;

public abstract class Context implements IContext {
	private IClient client;
	private IDb db;
	private static IContext context = null;

	public Context(IContext context, IClient client, IDb db) {
		if (context != null)
			Context.context = context;
		if (client != null)
			this.client = client;
		if (db != null)
			this.db = db;
		try {
			this.init(context);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void init(IClient client) throws UnknownHostException {
		if (client == null)
			this.client = client;
	}

	public static IContext getContext() {
		return context;
	}
	
	public MongoDatabase getMongoDatabase() {
		return this.client.getMongoDatabase();
	}

	public IContext connect(String name) {
		if (this.db == null)
			this.db = DbImpl.setDb(client, name);
		return context;
	}
}