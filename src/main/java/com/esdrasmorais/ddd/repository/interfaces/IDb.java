
package com.esdrasmorais.ddd.repository.interfaces;

import com.mongodb.DBCollection;

public interface IDb {
	public void setDb(IClient client);

	public IDb getDb();
	
	public DBCollection getCollection(String collection);
}
