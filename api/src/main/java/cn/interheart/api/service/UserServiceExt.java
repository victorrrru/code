package cn.interheart.api.service;

import cn.com.iotrust.common.ServiceException;
import cn.interheart.api.entity.User;
import cn.interheart.api.mapper.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;

/**
 * 业务实现层 - 表：user
 * @since 2017-04-18 17:05:48
 */
@Service("userServiceExt")
public class UserServiceExt implements Serializable {
	private static final long serialVersionUID = 1L;


	@Resource
	private UserMapper userMapper;

	public void add(User entity) {
		try {
			userMapper.insertSelective(entity);
		}catch (Exception e) {
			throw new ServiceException(e.getMessage(),e);
		}
	}

}