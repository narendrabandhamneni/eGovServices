package org.egov.id;

import org.egov.id.api.IdGenerationController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebMvcTest(IdGenerationController.class)
public class PtIdGenerationApplicationTests {

	@Test
	public void test_Should_Generate_Id() {
		
	}
}
