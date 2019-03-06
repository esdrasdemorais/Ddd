
package com.esdrasmorais.ddd.repository;

import java.net.UnknownHostException;

import com.esdrasmorais.ddd.repository.interfaces.IClient;
import com.esdrasmorais.ddd.repository.interfaces.IContext;
import com.esdrasmorais.ddd.repository.interfaces.IDb;
import com.mongodb.client.MongoDatabase;

public abstract class Context implements IContext {
	protected IClient client;
	protected IDb db;
	protected static IContext context = null;

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

	@Override
	public void init(IContext context) throws UnknownHostException {
		// TODO Auto-generated method stub
	}

	@Override
	public IContext get() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public IClient getClient() {
		return this.client;
	}
	
	public IDb getDB() {
		return this.db;
	}
}