package cn.interheart.api.web;

import cn.com.iotrust.common.ValidatorException;
import cn.com.iotrust.common.mvc.ValidatorUtil;
import cn.com.iotrust.common.mvc.bind.annotation.FormModel;
import cn.com.iotrust.common.mybatis.criteria.Criteria;
import cn.com.iotrust.common.mybatis.criteria.Sort;
import cn.com.iotrust.common.mybatis.result.Pager;
import cn.interheart.api.entity.User;
import cn.interheart.api.service.UserService;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

import cn.interheart.api.service.UserServiceExt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * Spring MVC Controler - 表：user
 * @since 2017-04-18 17:05:48
 */
@Controller
@RequestMapping(value = "/user")
public class UserAction {
	private static final Logger logger = LoggerFactory.getLogger(UserAction.class);

	@Autowired
	private UserService userService;
	@Autowired
	private UserServiceExt userServiceExt;

	/**
	 * 注册
	 */
	@RequestMapping(value = "/userregister",method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public Object userRegister(@RequestBody User param) {
		String username = param.getUsername();
		String gendar = param.getGendar();
		String telephone = param.getTelephone();
		Date birthday = param.getBirthday();

		User user = new User();
		user.setUsername(username);
		user.setGendar(gendar);
		user.setTelephone(telephone);
		user.setBirthday(birthday);

		userServiceExt.add(user);
		return "success";
	}

	/**
	 * 列表页面
	 */
	@RequestMapping(value = "/user2", method=RequestMethod.GET)
	public Object listPage() {
		return "user";
	}

	/**
	 * 列表数据
	 */
	@RequestMapping(value = "/user1", method=RequestMethod.POST)
	@ResponseBody
	public Object listData(HttpServletRequest request) {
		Map<String,Object> resultMap = new HashMap<String,Object>();
		try {
			Criteria<User> criteria = Criteria.create(User.class);
			criteria.buildFromRequest(request);
			criteria.sortIfEmpty(Sort.asc("id"));
			Pager<User> pager = userService.findPage(criteria);
			resultMap.put("result", 1);
			resultMap.put("total", pager.getTotalRecords());
			resultMap.put("rows", pager.getList());
		} catch (Exception e) {
			resultMap.put("result", 0);
			resultMap.put("message", e.getMessage());
			logger.error(e.getMessage(), e);
		}
		return resultMap;
	}

	/**
	 * 新增页面
	 */
	@RequestMapping(value = "/useradd", method=RequestMethod.GET)
	public Object addPage() {
		return "user_add";
	}

	/**
	 * 新增保存
	 */
	@RequestMapping(value = "/useradd", method=RequestMethod.POST)
	@ResponseBody
	public Object doAdd(@FormModel("user") User user) {
		Map<String,Object> resultMap = new HashMap<String,Object>();
		try {
			ValidatorUtil.validate(user);
			userService.insert(user);
			resultMap.put("result", 1);
		} catch (ValidatorException ve) {
			resultMap.put("result", 0);
			resultMap.put("message", ve.getMessage());
		} catch (Exception e) {
			resultMap.put("result", 0);
			resultMap.put("message", e.getMessage());
			logger.error(e.getMessage(), e);
		}
		return resultMap;
	}

	/**
	 * 修改页面
	 */
	@RequestMapping(value = "/useredit", method=RequestMethod.GET)
	public Object editPage(Integer id) {
		ModelAndView model = new ModelAndView();
		try {
			User user = userService.findByPrimaryKey(id);
			model.addObject("user", user);
			model.setViewName("user_edit");
		} catch (Exception e) {
			model.addObject("exception", e.getMessage());
			model.setViewName("/error");
			logger.error(e.getMessage(), e);
		}
		return model;
	}

	/**
	 * 修改保存
	 */
	@RequestMapping(value = "/useredit", method=RequestMethod.POST)
	@ResponseBody
	public Object doEdit(@FormModel("user") User user) {
		Map<String,Object> resultMap = new HashMap<String,Object>();
		try {
			ValidatorUtil.validate(user);
			userService.update(user);
			resultMap.put("result", 1);
		} catch (ValidatorException ve) {
			resultMap.put("result", 0);
			resultMap.put("message", ve.getMessage());
		} catch (Exception e) {
			resultMap.put("result", 0);
			resultMap.put("message", e.getMessage());
			logger.error(e.getMessage(), e);
		}
		return resultMap;
	}

	/**
	 * 删除
	 */
	@RequestMapping(value = "/userdelete", method=RequestMethod.POST)
	@ResponseBody
	public Object doDelete(@FormModel("ids") List<Integer> ids) {
		Map<String,Object> resultMap = new HashMap<String,Object>();
		try {
			userService.batchDelete(ids);
			resultMap.put("result", 1);
		} catch (Exception e) {
			resultMap.put("result", 0);
			resultMap.put("message", e.getMessage());
			logger.error(e.getMessage(), e);
		}
		return resultMap;
	}
}