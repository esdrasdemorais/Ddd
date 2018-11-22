
package com.esdrasmorais.ddd.repository;

import java.net.UnknownHostException;

import com.esdrasmorais.ddd.repository.interfaces.IClient;
import com.esdrasmorais.ddd.repository.interfaces.IContext;
import com.esdrasmorais.ddd.repository.Context;
import com.esdrasmorais.ddd.repository.interfaces.IDb;

import java.util.function.Function;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;

public class MongoContext extends Context {

    private static MongoContext ctx = new MongoContext();
    
    private MongoClient client;
    private DB db;
    private IContext context = null;
    
    private MongoContext() {
    	super(null, null, null);
    	try {
            init();
        } catch(Exception ex) {
        	ex.printStackTrace();
        }
    }
    
	public MongoContext(IContext context, IClient client, IDb db) {
		super(context, client, db);
		if (context == null) {
			MongoClientImpl mongoCli = new MongoClientImpl(
				System.getProperty("mongo.uri"), 
				27017);
			this.context = new MongoContext(
				null, 
				mongoCli, 
				new MongoDb(mongoCli, "Fisco")
			);
		}
	}

    private void init() throws UnknownHostException {
	    this.client = new MongoClient("localhost", 27017);
    }

	public MongoContext get() {	
	    return ctx;
    }

	public MongoContext connectDb(String dbname) {
	    if(db != null) {
	    	throw new RuntimeException(
	    		"Already conected to " + db.getName() + 
	    		"can't connect " + dbname
	    	);
        }
	    
	    this.db = client.getDB(dbname);
	
	    System.out.println("DB Details :: " + db.getName());
	
	    return ctx;
	}

	public <T,X> DBCursor findByKey(
		String collectionName,
		String key,
		T value,
		Function<T,X> convertDataType)
	{
	    DBCollection collection = db.getCollection(collectionName);
	
	    BasicDBObject searchQuery = new BasicDBObject();
	
	    searchQuery.put(key, convertDataType.apply(value));
	
	    System.out.println("search Query ::" + searchQuery);
	
		DBCursor cursor = collection.find(searchQuery);
		
    	return cursor;
    }

	@Override
	public void init(IContext context) throws UnknownHostException {
		// TODO Auto-generated method stub
		
	}
}
