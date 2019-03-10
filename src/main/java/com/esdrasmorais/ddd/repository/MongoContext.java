
package com.esdrasmorais.ddd.repository;

import com.esdrasmorais.ddd.repository.interfaces.IClient;
import java.net.UnknownHostException;
import com.esdrasmorais.ddd.repository.interfaces.IContext;
import com.esdrasmorais.ddd.repository.interfaces.IDb;

import java.util.function.Function;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;

public class MongoContext extends Context {    
    public MongoContext() {
    	super(null, null, null);
    	try {
            init();
        } catch(Exception ex) {
        	ex.printStackTrace();
        }
    }
    
    public MongoContext(IDb db) {
    	super(null, null, db);
    	this.db = db;
    	try {
            init();
        } catch(Exception ex) {
        	ex.printStackTrace();
        }
    }

	public MongoContext(IContext context, IClient client, IDb db) 
		throws UnknownHostException
	{
		super(context, client, db);
		this.init();
	}
	
    private void init() throws UnknownHostException {
		if (MongoContext.context == null) {
			MongoClientImpl mongoCli = new MongoClientImpl(
				System.getProperty("mongo.uri")
			);
		    this.client = mongoCli;
			MongoContext.context = new MongoContext(
				null, 
				this.client, 
				null
			);
		}
    }

	public void init(IContext context) throws UnknownHostException {
	
	}
	
	public IContext get() {	
	    return MongoContext.context;
    }

	public IContext connectDb(String dbname) {
	    if(db != null) {
	    	throw new RuntimeException(
	    		"Already conected to " + db.getName() + 
	    		"can't connect " + dbname
	    	);
        }
	    
	    this.db = this.client.getDb(dbname);
	
	    System.out.println("DB Details :: " + db.getName());
	
	    return MongoContext.context;
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
}