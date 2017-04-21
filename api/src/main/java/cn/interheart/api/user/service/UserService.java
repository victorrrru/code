package cn.interheart.api.user.service;

import cn.com.iotrust.common.ServiceException;
import cn.com.iotrust.common.mybatis.criteria.Criteria;
import cn.com.iotrust.common.mybatis.result.Pager;
import cn.interheart.api.user.entity.User;
import cn.interheart.api.user.mapper.UserMapper;
import java.io.Serializable;
import java.util.List;
import javax.annotation.Resource;

import cn.interheart.api.user.mapper.UserExtMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 业务实现层 - 表：user
 * @since 2017-04-18 17:05:48
 */
@Service("userService")
public class UserService implements Serializable {
	private static final long serialVersionUID = 1L;

	@Resource
	private UserMapper userMapper;
	@Resource
	private UserExtMapper userExtMapper;

	public void add(User entity) {
		try {
			userMapper.insertSelective(entity);
		}catch (Exception e) {
			throw new ServiceException(e.getMessage(),e);
		}
	}

	public User findByUsername(String username) {
		try {
			return userExtMapper.selectByUsername(username);
		}catch (Exception e) {
			throw new ServiceException(e.getMessage(),e);
		}
	}

	public void insert(User entity) throws ServiceException {
		try {
			userMapper.insert(entity);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public void delete(User entity) throws ServiceException {
		try {
			userMapper.deleteByPrimaryKey(entity.getId());
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	@Transactional
	public void batchDelete(List<Integer> ids) throws ServiceException {
		try {
			for (Integer id : ids) {
				userMapper.deleteByPrimaryKey(id);
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public void update(User entity) throws ServiceException {
		try {
			userMapper.updateByPrimaryKey(entity);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public void updateSelective(User entity) throws ServiceException {
		try {
			userMapper.updateByPrimaryKeySelective(entity);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public User findByPrimaryKey(Integer id) throws ServiceException {
		try {
			return userMapper.selectByPrimaryKey(id);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public Pager<User> findPage(Criteria<User> criteria) throws ServiceException {
		try {
			if (criteria == null) {
				 criteria = Criteria.create(User.class);
			}
			criteria.pagination(true);
			List<User> list = userMapper.selectByCriteria(criteria);
			return new Pager<User>(criteria, list);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public List<User> findAll(Criteria<User> criteria) throws ServiceException {
		try {
			if (criteria == null) {
				 criteria = Criteria.create(User.class);
			}
			criteria.pagination(false);
			return userMapper.selectByCriteria(criteria);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}
}