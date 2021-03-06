package com.changdi.dao.impl;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import com.changdi.dao.AppUserDao;
import com.changdi.dao.base.BaseDao;
import com.changdi.vo.User;

public class AppUserDaoImpl extends BaseDao implements AppUserDao {
	private SimpleJdbcInsert insertActor;

	@Override
	public void insertAppUser(User user) {
		logger.debug("in VenueDaoImpl....");
		Map<String, Object> map = new HashMap<String, Object>(4);
		map.put("id", 1234);
		map.put("name", "name1234");
		map.put("description", "description1234");
		map.put("createAt", new Timestamp(System.currentTimeMillis()));
		int ret = insertActor.withTableName("venue").execute(map);

		logger.debug(String.format("ret=%s", ret));
	}
}
