package com.changdi.dao.impl;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import com.changdi.dao.VenueDao;
import com.changdi.dao.base.BaseDao;
import com.changdi.persist.Venue;

@Repository
public class VenueDaoImpl extends BaseDao implements VenueDao {

	private Log logger = LogFactory.getLog(VenueDaoImpl.class);

	@Override
	public void insertVenue(Venue v) {
		logger.debug("in VenueDaoImpl....");
		Map<String, Object> map = new HashMap<String, Object>(4);
		map.put("id", 1234);
		map.put("name", "name1234");
		map.put("description", "description1234");
		map.put("createAt", new Timestamp(System.currentTimeMillis()));
		int ret = insertActor.withTableName("venue").execute(map);

		logger.debug(String.format("ret=%s", ret));
	}

	@Override
	public List<Map<String, Object>> findAllVenue() {
		String sql = "select * from venue order by createAt desc";
		return simpleJdbcTemplate.queryForList(sql);
	}
}
