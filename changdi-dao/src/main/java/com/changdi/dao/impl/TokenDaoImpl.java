package com.changdi.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import com.changdi.dao.TokenDao;
import com.changdi.dao.base.BaseDao;
import com.changdi.vo.User;
import com.changdi.vo.UserToken;

public class TokenDaoImpl extends BaseDao implements TokenDao {

	protected SimpleJdbcInsert insertActor;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.insertActor = new SimpleJdbcInsert(dataSource).withTableName(
				"u_token").usingGeneratedKeyColumns("id");
	}

	private RowMapper<UserToken> rm = new RowMapper<UserToken>() {

		@Override
		public UserToken mapRow(ResultSet rs, int rowNum) throws SQLException {
			UserToken ut = new UserToken();
			ut.setId(rs.getLong("id"));
			ut.setTokenKey(rs.getString("tokenKey"));
			ut.setTokenSecret(rs.getString("tokenSecret"));
			ut.setU_id(rs.getLong("u_id"));
			ut.setVerifier(rs.getString("verifier"));
			return ut;
		}

	};

	@Override
	public void inserToken(User uo) {
		SqlParameterSource parameters = new MapSqlParameterSource()
				.addValue("tokenKey", uo.getTokenKey())
				.addValue("tokenSecret", uo.getTokenSecret())
				.addValue("verifier", uo.getVerifier())
				.addValue("u_id", uo.getId());
		insertActor.execute(parameters);
	}

	@Override
	public UserToken getUserTokenById(long id) {
		SqlParameterSource parameters = new MapSqlParameterSource().addValue(
				"u_id", id);

		logger.debug(String.format("id:%d", id));

		String sql = "select * from u_token where u_id = :u_id";
		List<UserToken> ulist = simpleJdbcTemplate.query(sql, rm, parameters);

		logger.debug(String.format("ulist.size():%d", ulist.size()));

		if (ulist != null && ulist.size() > 0) {
			return ulist.get(0);
		}
		return null;
	}

	@Override
	public void updateToken(UserToken ut) {
		SqlParameterSource parameters = new BeanPropertySqlParameterSource(ut);
		StringBuffer sb = new StringBuffer();
		sb.append("update u_token set");
		sb.append(" tokenKey=:tokenKey");
		sb.append(",tokenSecret=:tokenSecret");
		sb.append(",verifier=:verifier");
		sb.append(" where u_id=:u_id");
		simpleJdbcTemplate.update(sb.toString(), parameters);
	}

	@Override
	public UserToken loadUserTokenByName(String name) {
		StringBuffer sb = new StringBuffer();
		sb.append("select ut.* from u_token ut inner join app_user u");
		sb.append(" on ut.u_id = u.id ");
		sb.append(" where u.name = :name");

		SqlParameterSource ps = new MapSqlParameterSource().addValue("name",
				name);
		List<UserToken> list = simpleJdbcTemplate.query(sb.toString(), rm, ps);
		if (list != null && list.size() > 0)
			return list.get(0);
		return null;
	}

}
