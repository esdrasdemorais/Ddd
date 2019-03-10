package ddd;

import com.esdrasmorais.ddd.repository.MongoRepository;
import com.esdrasmorais.ddd.repository.interfaces.IClient;
import com.esdrasmorais.ddd.repository.interfaces.IContext;
import com.esdrasmorais.ddd.repository.interfaces.IDb;

public class UserRepository extends MongoRepository<User> {
	public UserRepository(IContext context, IClient client, IDb db) {
		super(context, client, db);
	}
}