package com.changdi.dao.impl;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import com.changdi.dao.VenueDao;
import com.changdi.dao.base.BaseDao;
import com.changdi.dao.persist.Venue;

public class VenueDaoImpl extends BaseDao implements VenueDao {

	protected SimpleJdbcInsert insertActor;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.insertActor = new SimpleJdbcInsert(dataSource).withTableName(
				"venue").usingGeneratedKeyColumns("id");
	}

	@Override
	public void insertVenue(Venue v) {

		logger.debug("in VenueDaoImpl....");
		Map<String, Object> map = new HashMap<String, Object>(4);
		map.put("name", v.getName());
		map.put("description", v.getDescription());
		map.put("createAt", new Timestamp(System.currentTimeMillis()));
		Number newId = insertActor.execute(map);

		v.setId(newId.longValue());

		logger.debug(String.format("ret=%s", newId));
	}

	@Override
	public List<Map<String, Object>> findAllVenue() {
		String sql = "select * from venue order by createAt desc";
		return simpleJdbcTemplate.queryForList(sql);
	}
}
