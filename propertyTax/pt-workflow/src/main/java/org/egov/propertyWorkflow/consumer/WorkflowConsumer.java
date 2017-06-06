package org.egov.propertyWorkflow.consumer;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.egov.models.Property;
import org.egov.models.PropertyRequest;
import org.egov.models.WorkFlowDetails;
import org.egov.propertyWorkflow.models.WorkflowDetailsRequestInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

@EnableKafka
@Service
public class WorkflowConsumer {
	@Autowired
	private WorkFlowUtil workflowUtil;

	@Autowired
	Environment environment;
	
	@Bean
	public Map<String,Object> consumerConfig(){
		Map<String,Object> consumerProperties=new HashMap<String,Object>();
		consumerProperties.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, environment.getProperty("auto.offset.reset"));
		consumerProperties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, environment.getProperty("bootstrap.server.config"));
		consumerProperties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		consumerProperties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
	
		consumerProperties.put(ConsumerConfig.GROUP_ID_CONFIG, environment.getProperty("consumer.groupId"));
		return consumerProperties;
	}
	
    
	@Bean
	public ConsumerFactory<String, PropertyRequest> consumerFactory(){
		return new DefaultKafkaConsumerFactory<>(consumerConfig(),new StringDeserializer(),
		        new JsonDeserializer<>(PropertyRequest.class));
		
	}
	
	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, PropertyRequest> kafkaListenerContainerFactory(){
		ConcurrentKafkaListenerContainerFactory<String, PropertyRequest> factory=new ConcurrentKafkaListenerContainerFactory<String,PropertyRequest>();
		 factory.setConsumerFactory(consumerFactory());
		 return factory;
	}

	@KafkaListener(containerFactory = "kafkaListenerContainerFactory", topics = "#{environment.getProperty('property.start.workflow')}")
	public void listen(ConsumerRecord<String, PropertyRequest> record) throws Exception {

		ObjectMapper objectMapper = new ObjectMapper();

		if (record.topic().equalsIgnoreCase(environment.getProperty("property.start.workflow"))) {

			PropertyRequest propertyRequest = null;
			propertyRequest =record.value();
			//propertyRequest=	objectMapper.readValue(propertyRequestData, PropertyRequest.class);
			for(Property property:propertyRequest.getProperties()){
				WorkFlowDetails workflowDetails=property.getPropertyDetail().getWorkFlowDetails();
				WorkflowDetailsRequestInfo workflowDetailsRequestInfo=new WorkflowDetailsRequestInfo();
				workflowDetailsRequestInfo.setRequestInfo(propertyRequest.getRequestInfo());
				workflowDetailsRequestInfo.setTenantId(property.getTenantId());
				workflowDetailsRequestInfo.setWorkflowDetails(workflowDetails);
				workflowUtil.startWorkflow(workflowDetailsRequestInfo);
			}
		}
		else if(record.topic().equals(environment.getProperty("property.update.workflow"))) {

			PropertyRequest propertyRequest = null;

			//propertyRequest = objectMapper.readValue(record.value(), PropertyRequest.class);

			for(Property property:propertyRequest.getProperties()){
				WorkFlowDetails workflowDetails=property.getPropertyDetail().getWorkFlowDetails();
				WorkflowDetailsRequestInfo workflowDetailsRequestInfo=new WorkflowDetailsRequestInfo();
				workflowDetailsRequestInfo.setTenantId(property.getTenantId());
				workflowDetailsRequestInfo.setWorkflowDetails(workflowDetails);
				workflowDetailsRequestInfo.setRequestInfo(propertyRequest.getRequestInfo());
				workflowUtil.updateWorkflow(workflowDetailsRequestInfo);
			}
		}

	}
}
