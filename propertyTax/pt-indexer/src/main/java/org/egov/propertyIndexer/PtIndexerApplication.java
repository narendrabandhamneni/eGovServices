package org.egov.propertyIndexer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
/**
 * 
 * @author Prasad
 *
 * This is the starting class of the Property indexer
 */
@SpringBootApplication
@EnableElasticsearchRepositories(basePackages={"org.egov.propertyindexer"})
public class PtIndexerApplication {
	public static void main(String[] args) {
		SpringApplication.run(PtIndexerApplication.class, args);

	}
}
