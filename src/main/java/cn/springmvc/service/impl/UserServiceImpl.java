package cn.springmvc.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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
	/*@Autowired 
	private StringRedisTemplate redisTemplate;*/

	@Override
	public int insertUser(User user) {
		int count = userDAO.insertUser(user);
		System.out.println(count);
		return count;
	}

	@Override
	public void cleanRedis(String key) {
		/*ValueOperations<String, String> ops = this.redisTemplate.opsForValue(); 
		String key1 = "spring.boot.redis.test"; 
		if (!this.redisTemplate.hasKey(key1)) { 
			ops.set(key1, "foo"); 
		} 
		System.out.println("Found key " + key + ", value=" + ops.get(key)); */
	}

	@Override
	public List<User> queryUserList() {
		return userDAO.queryUserList();
	}
	
	
	
	
	
}
