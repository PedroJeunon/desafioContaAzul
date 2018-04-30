import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringApplicationTests.class)
@TestPropertySource(locations = "classpath:test.properties")
@ComponentScan("br.com.desafio")
public class SpringApplicationTests {

	@Test
	public void contextLoads() {
	}

}