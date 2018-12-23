package com.jvcdp.controller;

import java.util.List;

import com.google.common.collect.Lists;
import com.jvcdp.repository.BlogpostRedisTemplateRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jvcdp.model.Blogpost;

@RestController
@RequestMapping("blogposts")
public class BlogpostController {
    
	@Autowired
	private BlogpostRedisTemplateRepository blogpostRedisTemplateRepository;

	@GetMapping(value = "")
	public List<Blogpost> list() {
		return Lists.newArrayList(blogpostRedisTemplateRepository.findAll());
	}

	@GetMapping(value = "/category/{category}")
	public List<Blogpost> blogpostsByCategory(@PathVariable String category) {
		return blogpostRedisTemplateRepository.getBlogpostsByCategory(category);
	}

	@PostMapping(value = "")
	public Blogpost create(@RequestBody Blogpost blogpost) {
		blogpostRedisTemplateRepository.save(blogpost);
		return  blogpost;
	}

	@GetMapping(value = "/{id}")
	public Blogpost get(@PathVariable String id) {
		return blogpostRedisTemplateRepository.find(id);
	}

	@PutMapping(value = "/{id}")
	public Blogpost update(@PathVariable String id, @RequestBody Blogpost blogpost) {
		Blogpost existingBlogpost = blogpostRedisTemplateRepository.find(id);
		BeanUtils.copyProperties(blogpost, existingBlogpost);
		blogpostRedisTemplateRepository.save(existingBlogpost);
		return blogpost;
	}

	@DeleteMapping(value = "/{id}")
	public Blogpost delete(@PathVariable String id) {
		Blogpost existingBlogpost = blogpostRedisTemplateRepository.find(id);
		blogpostRedisTemplateRepository.delete(existingBlogpost.getId());
		return existingBlogpost;
	}
	
}
