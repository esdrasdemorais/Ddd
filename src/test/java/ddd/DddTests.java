package ddd;

import org.junit.Test;
import static org.junit.Assert.*;
import com.esdrasmorais.ddd.repository.MongoRepository;

/**
 * This java source file was generated by the Gradle 'init' task.
 */
public class DddTests {
    @Test public void testRepository() {
    	assertTrue(
    		System.getProperty("mongo_uri") == System.getProperty("mongo.uri")
    	);
    	
    	MongoRepository<User> mongoRepository = new MongoRepository<User>(
    		null, null, null
    	);
        assertTrue(
			"should return 'true'", 
			mongoRepository instanceof MongoRepository<?>
        );
    }
}