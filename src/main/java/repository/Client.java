
package com.esdrasmorais.util.repository;

import com.esdrasmorais.util.repository.interfaces.IClient;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

public abstract class Client implements IClient {
	private String database;
	private String host;
	private Integer port;
	protected MongoDatabase mongoDatabase = null;
	protected MongoClient mongoClient = null;
	
	public Client(String host, Integer port) {
		this.host = host;
		this.port = port;
	}

	public void setHost(String host) {
		this.host = host;
	}
	
	public String getHost() {
		return this.host;
	}

	public void setPort(Integer port) {
		this.port = port;
	}
	
	public Integer getPort() {
		return this.port;
	}
	
	public void setDatabase(String database) {
		this.database = database;
	}
	
	public String getDatabase() {
		return this.database;
	}
	
	public MongoDatabase getMongoDatabase() {
		return this.mongoDatabase;
	}
}
