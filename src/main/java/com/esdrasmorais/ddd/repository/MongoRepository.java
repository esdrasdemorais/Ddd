
package com.esdrasmorais.ddd.repository;

import com.mongodb.DBCursor;
import com.mongodb.Function;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.util.JSON;
import com.mongodb.DBCollection;

import java.net.UnknownHostException;
import java.util.List;

import org.bson.Document;

import com.esdrasmorais.ddd.repository.interfaces.IClient;
import com.esdrasmorais.ddd.repository.interfaces.IContext;
import com.esdrasmorais.ddd.repository.interfaces.IDb;
import com.mongodb.BasicDBObject;

public class MongoRepository<T> extends RepositoryImpl<T> {
	public MongoRepository(IContext context, IClient client, IDb db) {
		super(context, client, db);
	}

	@Override
	public <T> List<T> find(String query, Object[] params) {
		FindIterable<Document> result = this.findByKey(
			"Employee", "age", 32, (value) -> new Integer(value));
		/*while (result.hasNext()) {
		}*/
		return (List<T>) result;
	}

	public <T, X> FindIterable<Document> findByKey(String collectionName, 
		String key, T value, Function<T, X> convertDataType)
	{
		MongoCollection<Document> collection = this.getMongoDatabase()
			.getCollection(collectionName);
		BasicDBObject searchQuery = new BasicDBObject();
		searchQuery.put(key, convertDataType.apply(value));
		FindIterable<Document> cursor = collection.find(searchQuery);
		return cursor;
	}

	@Override
	public Boolean save(T object) {
		DBCollection collection = this.getMongoDatabase()
			.getCollection(object.getClass().getName());
		Gson gson = new Gson();
		BasicDBObject document = (BasicDBObject)JSON.parse(
			gson.toJson(object)
		collection.save(document);
		return true;
	}

	@Override
	public Boolean remove(T object) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<T> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}
}
