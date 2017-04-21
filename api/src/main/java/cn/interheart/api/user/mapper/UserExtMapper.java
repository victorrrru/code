package cn.interheart.api.user.mapper;

import cn.com.iotrust.common.mybatis.criteria.Criteria;
import cn.interheart.api.user.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * MyBatis Mapper 接口 - 表：user
 * @since 2017-04-18 17:05:48
 */
@Repository
public interface UserExtMapper {
	/**
	 * 按照username查询
	 */
	User selectByUsername(String username);
}