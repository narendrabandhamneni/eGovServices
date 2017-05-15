package org.egov.propertyindexer.repository;

import org.egov.propertyindexer.entity.PropertyDetailsElasticSearch;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PropertyElasticSearchRepository extends ElasticsearchRepository<PropertyDetailsElasticSearch, String>{
	

}
