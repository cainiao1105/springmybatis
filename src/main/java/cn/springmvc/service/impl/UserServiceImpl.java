package cn.springmvc.service.impl;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.springmvc.dao.UserDAO;
import cn.springmvc.model.User;
import cn.springmvc.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDAO userDAO;
	@Autowired 
	private StringRedisTemplate redisTemplate;

	public int insertUser(User user) {
		int count = userDAO.insertUser(user);
		return count;
	}

	public void cleanRedis(String key){
		ValueOperations<String, String> ops = this.redisTemplate.opsForValue(); 
		String key1 = "spring.boot.redis.test"; 
		if (!this.redisTemplate.hasKey(key1)) { 
			ops.set(key1, "foo"); 
		} 
		System.out.println("Found key " + key + ", value=" + ops.get(key)); 
		
		
//		System.out.println("开始删除key=" + key);
//		redisTemplate.delete(key);
//		System.out.println("删除完成");
	}

	@Override
	public List<User> queryUserList() {
		return userDAO.queryUserList();
	}
}
