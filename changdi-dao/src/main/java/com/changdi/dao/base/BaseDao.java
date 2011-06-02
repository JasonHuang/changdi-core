package com.changdi.dao.base;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

public class BaseDao {
	@Autowired
	protected NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Autowired
	protected SimpleJdbcTemplate simpleJdbcTemplate;

	@Autowired
	protected SimpleJdbcInsert insertActor;

	protected Log logger = LogFactory.getLog(BaseDao.class);
}
