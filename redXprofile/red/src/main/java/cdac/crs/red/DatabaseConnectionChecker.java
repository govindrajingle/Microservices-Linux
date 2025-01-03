package cdac.crs.red;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class DatabaseConnectionChecker implements CommandLineRunner {

	private static final Logger logger = LoggerFactory.getLogger(DatabaseConnectionChecker.class);

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void run(String... args) throws Exception {
		try {
			jdbcTemplate.execute("SELECT 1");
			logger.info("Successfully connected to the database.");
		} catch (Exception e) {
			logger.error("Failed to connect to the database.", e);
		}
	}
}
