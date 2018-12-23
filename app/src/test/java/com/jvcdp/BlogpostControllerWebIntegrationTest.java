package com.jvcdp;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BlogpostControllerWebIntegrationTest {
	
    @Autowired
    private TestRestTemplate restTemplate;

	
	@Test
	public void testListAll() throws IOException {
		ResponseEntity<String> response = restTemplate.getForEntity("http://localhost:8080/api/v1/blogposts", String.class);

	    assertThat( response.getStatusCode() , equalTo(HttpStatus.OK));

	    ObjectMapper objectMapper = new ObjectMapper();
	    JsonNode responseJson = objectMapper.readTree(response.getBody());

	    assertThat( responseJson.isMissingNode() , is(false) );
	    assertThat( responseJson.toString() , equalTo("[]") );
		
	}

}
