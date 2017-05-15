package org.egov.propertyIndexer.repository;

import org.egov.propertyIndexer.entity.PropertyDetailsElasticSearch;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PropertyElasticSearchRepository extends ElasticsearchRepository<PropertyDetailsElasticSearch, String>{
	

}
