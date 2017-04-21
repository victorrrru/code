package cn.interheart.api.mapper;

import cn.com.iotrust.common.mybatis.criteria.Criteria;
import cn.interheart.api.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * MyBatis Mapper 接口 - 表：user
 * @since 2017-04-18 17:05:48
 */
@Repository
public interface UserMapper {
	/**
	 * 按主键删除
	 * @since 2017-04-18 17:05:48
	 */
	int deleteByPrimaryKey(Integer id);

	/**
	 * 插入 - 全字段保存
	 * @since 2017-04-18 17:05:48
	 */
	int insert(User record);

	/**
	 * 插入 - 仅保存给定实体类中非null的字段
	 * @since 2017-04-18 17:05:48
	 */
	int insertSelective(User record);

	/**
	 * 按主键查询
	 * @since 2017-04-18 17:05:48
	 */
	User selectByPrimaryKey(Integer id);

	/**
	 * 按主键更新 - 仅更新给定实体类中非null的字段
	 * @since 2017-04-18 17:05:48
	 */
	int updateByPrimaryKeySelective(User record);

	/**
	 * 按主键更新 - 全更新
	 * @since 2017-04-18 17:05:48
	 */
	int updateByPrimaryKey(User record);

	/**
	 * 按 Criteria 条件查询, 支持分页
	 * @since 2017-04-18 17:05:48
	 */
	List<User> selectByCriteria(Criteria<User> criteria);
}