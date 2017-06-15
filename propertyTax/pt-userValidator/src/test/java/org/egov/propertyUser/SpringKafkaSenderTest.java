package org.egov.propertyUser;


import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.egov.models.AuditDetails;
import org.egov.models.OwnerInfo;
import org.egov.models.Property;
import org.egov.models.PropertyRequest;
import org.egov.models.RequestInfo;
import org.egov.models.Role;
import org.egov.models.UserDetails;
import org.egov.propertyUser.userConsumer.Producer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.KafkaMessageListenerContainer;
import org.springframework.kafka.listener.MessageListener;
import org.springframework.kafka.listener.config.ContainerProperties;
import org.springframework.kafka.test.utils.ContainerTestUtils;
import org.springframework.kafka.test.utils.KafkaTestUtils;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringKafkaSenderTest {


	@Autowired
	Environment environment;

	@Autowired
	private Producer producer;

	private KafkaMessageListenerContainer<String, PropertyRequest> container;

	private BlockingQueue<ConsumerRecord<String, PropertyRequest>> records;

	@Before
	public void setUp() throws Exception {
		// set up the Kafka consumer properties
		Map<String, Object> consumerProperties =
				KafkaTestUtils.consumerProps("sender_group", "false", PtUserValidatorApplicationTests.embeddedKafka);

		// create a Kafka consumer factory
		DefaultKafkaConsumerFactory<String, PropertyRequest> consumerFactory =
				new DefaultKafkaConsumerFactory<String, PropertyRequest>(consumerProperties);

		// set the topic that needs to be consumed
		ContainerProperties containerProperties =
				new ContainerProperties(PtUserValidatorApplicationTests.SENDER_TOPIC);

		// create a Kafka MessageListenerContainer
		container = new KafkaMessageListenerContainer<>(consumerFactory, containerProperties);

		// create a thread safe queue to store the received message
		records = new LinkedBlockingQueue<>();

		// setup a Kafka message listener
		container.setupMessageListener(new MessageListener<String, PropertyRequest>() {
			@Override
			public void onMessage(ConsumerRecord<String, PropertyRequest> record) {
				System.out.println("record: " + record.toString());
				records.add(record);
			}
		});

		// start the container and underlying message listener
		container.start();
		// wait until the container has the required number of assigned partitions
		ContainerTestUtils.waitForAssignment(container,
				PtUserValidatorApplicationTests.embeddedKafka.getPartitionsPerTopic());
	}

	@After
	public void tearDown() {
		// stop the container
		container.stop();
	}

	@Test
	public void testSend() throws Exception {
		// send the message
		try {
			PropertyRequest propertyRequest = new PropertyRequest();
			List<Property> properties = new ArrayList<Property>();

			Property property = new Property();

			RequestInfo requestInfo = new RequestInfo();

			requestInfo.setApiId("emp");
			requestInfo.setVer("1.0");
			requestInfo.setTs((long) 20171205);
			requestInfo.setAction("create");
			requestInfo.setDid("1");
			requestInfo.setKey("abcdkey");
			requestInfo.setMsgId("20170310130900");
			requestInfo.setRequesterId("rajesh");
			requestInfo.setAuthToken("08db73a8-945e-4164-94e3-63ccef7856d4");

			List<OwnerInfo> owners = property.getOwners();

			OwnerInfo owner = new OwnerInfo();
			owner.setTenantId("default");
			owner.setUserName("9703080696");
			owner.setAuthToken("08db73a8-945e-4164-94e3-63ccef7856d4");
			owner.salutation("testing");
			owner.setName("anil");
			owner.setGender("male");
			owner.setMobileNumber("9333555666");
			owner.setEmailId("anil@wtc.com");
			owner.setAadhaarNumber("123456789123");
			owner.setActive(true);
			owner.setLocale("no");
			owner.setType("house");
			owner.setAccountLocked(true);

			List<Role> roles = new ArrayList<Role>();
			Role role = new Role();

			role.setName("kumar");
			role.setDescription("Testing");
			roles.add(role);
			owner.setRoles(roles);

			AuditDetails auditDetails = new AuditDetails();


			auditDetails.setCreatedBy("Anil");
			auditDetails.setLastModifiedBy("Anil");
			auditDetails.setCreatedTime((long) 564644560);
			auditDetails.setLastModifiedTime((long) 564644560);

			owner.setAuditDetails(auditDetails);

			UserDetails userDetails = new UserDetails();

			userDetails.setFirstName("Anil");
			userDetails.setMiddleName("Kumar");
			userDetails.setLastName("Sandrapati");
			userDetails.setDob("25/09/1989");
			userDetails.setAltContactNumber("9703080696");
			userDetails.setFatherName("svs");
			userDetails.setHusbandName("not applicable");
			userDetails.setBloodGroup("O+");
			userDetails.setPan("stvt5854k");
			userDetails.setPermanentAddress("eluru");
			userDetails.setPermanentCity("eluru");
			userDetails.setPermanentPincode("534001");
			userDetails.setCorrespondenceCity("Hyderabad");
			userDetails.setCorrespondencePincode("500004");
			userDetails.setCorrespondenceAddress("Khirathabad");
			userDetails.setSignature("S Anilkumar");
			userDetails.setIdentificationMark("mole on right hand");
			userDetails.setPhoto("anil.png");

			owner.setIsPrimaryOwner(true);
			owner.setIsSecondaryOwner(true);
			owner.setOwnerShipPercentage((double) 10);
			owner.setOwnerType("Sandrapati Anilkumar");

			owner.setUserDetails(userDetails);

			property.setOwners(owners);

			propertyRequest.setProperties(properties);
			propertyRequest.setRequestInfo(requestInfo);
			producer.send(PtUserValidatorApplicationTests.SENDER_TOPIC, propertyRequest);
			assertNotNull(records.poll(10, TimeUnit.SECONDS));
			assertTrue(true);

			
		} catch (Exception e) {
			e.printStackTrace();
			assertTrue(false);
		}
	}

}



