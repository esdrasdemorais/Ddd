
package com.esdrasmorais.util.repository;

import java.net.UnknownHostException;

import com.esdrasmorais.util.repository.interfaces.IClient;
import com.esdrasmorais.util.repository.interfaces.IContext;
import com.esdrasmorais.util.repository.interfaces.IDb;

import java.net.UnknownHostException;

import java.util.function.Function;

import com.mongodb.BasicDBObject;

import com.mongodb.DB;

import com.mongodb.DBCollection;

import com.mongodb.DBCursor;

import com.mongodb.MongoClient;



public class MongoContext extends Context {

    private static MongoContext ctx = new MongoContext();

        private  MongoClient client;

            private  DB db;

                private MongoContext(){

                            try{

                                            init();

                                                    }catch(Exception ex){

                                                                    ex.printStackTrace();

                                                                            }

                                }

                    private void init() throws UnknownHostException{

                                this.client = new MongoClient("localhost" , 27017);

                                    }

                        public static MongoContext get(){

                                    return ctx;

                                        }

                            public MongoContext connectDb(String dbname){

                                        if(db !=null){

                                                        throw new RuntimeException("Already conected to " + db.getName() + "can't connect " + dbname);

                                                                }

                                                this.db = client.getDB(dbname);

                                                        System.out.println("DB Details :: " + db.getName());

                                                                return ctx;

                                                                    }

                                public <T,X> DBCursor findByKey(String collectionName,String key,T value,Function<T,X> convertDataType){

                                            DBCollection collection = db.getCollection(collectionName);

                                                    BasicDBObject searchQuery = new BasicDBObject();

                                                            searchQuery.put(key, convertDataType.apply(value));

                                                                    System.out.println("search Query ::" + searchQuery);

                                                                            DBCursor cursor = collection.find(searchQuery);

                                                                                    return cursor;

                                                                                        }

	private IContext context = null;
	public MongoContext(IContext context, IClient client, IDb db) {
		super(context, client, db);
		if (context == null) {
			MongoClientImpl mongoCli = new MongoClientImpl("localhost", 27017);
			this.context = new MongoContext(
				null, 
				mongoCli, 
				new MongoDb(mongoCli, "Fisco")
			);
		}
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
}
