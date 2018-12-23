package com.jvcdp.repository;

import com.jvcdp.model.Blogpost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
@Transactional
public class BlogpostRedisTemplateRepository {
    private static final String KEY = "Blogposts";

    @Autowired
    private RedisTemplate<String, Blogpost> redisTemplate;


    public RedisTemplate<String, Blogpost> getRedisTemplate()
    {
        return redisTemplate;
    }

    public void setRedisTemplate(RedisTemplate<String, Blogpost> redisTemplate)
    {
        this.redisTemplate = redisTemplate;
    }

    public void save(Blogpost person)
    {
        this.redisTemplate.opsForHash().put(KEY, person.getId(), person);
    }

    public Blogpost find(String id)
    {
        return (Blogpost)this.redisTemplate.opsForHash().get(KEY, id);
    }

    public List<Blogpost> findAll()
    {
        Map<Object,Object> all = this.redisTemplate.opsForHash().entries(KEY);
        List<Blogpost> lst = new ArrayList<Blogpost>();
        for(Map.Entry<Object,Object> entry : all.entrySet()){
                lst.add((Blogpost)entry.getValue());
        }
        return (lst);
    }

    public void delete(String id)
    {
        this.redisTemplate.opsForHash().delete(KEY,id);
    }
    

    int countBlogposts(){
        return Math.toIntExact(redisTemplate.opsForList().size(KEY));
    }

    int countBlogpostsByCategory(String category){
       return findAll().size();
    }

    public List<Blogpost> getBlogpostsByCategory(String category){

        List<Blogpost> lst = new ArrayList<Blogpost>();
        for(Blogpost entry : findAll()){
            if((entry).getCategory().equalsIgnoreCase(category)){
                lst.add(entry);
            }
        }
        return (lst);
    }

}
