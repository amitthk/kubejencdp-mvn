package com.jvcdp;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import com.jvcdp.repository.BlogpostRedisTemplateRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;

import com.jvcdp.controller.BlogpostController;
import com.jvcdp.model.Blogpost;

public class BlogpostControllerTest {
	@InjectMocks
	private BlogpostController sc;

	@Mock
	private BlogpostRedisTemplateRepository blogpostRepository;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }
	
	@Test
	public void testBlogpostGet() {
    	Blogpost sw = new Blogpost();
    	String id = java.util.UUID.randomUUID().toString();
    	sw.setId(id);
		when(blogpostRepository.find(id)).thenReturn(sw);

		Blogpost wreck = sc.get(id);

		verify(blogpostRepository).find(id);

//		assertEquals(1l, wreck.getId().longValue());	
		assertThat(wreck.getId(), is(id));
	}

}
