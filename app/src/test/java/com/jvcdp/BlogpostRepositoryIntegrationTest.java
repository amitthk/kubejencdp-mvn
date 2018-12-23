package com.jvcdp;

import com.jvcdp.repository.BlogpostRedisTemplateRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.jvcdp.model.Blogpost;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BlogpostRepositoryIntegrationTest {

	@Autowired
	private BlogpostRedisTemplateRepository blogpostRepository;

	@Test
	public void testFindAll() {
		Iterable<Blogpost> wrecks = blogpostRepository.findAll();
		assertThat(wrecks.iterator().next(), notNullValue());
	}
	
}
