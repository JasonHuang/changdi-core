package com.changdi.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.changdi.dao.UserDao;
import com.changdi.dao.base.BaseDao;
import com.changdi.vo.User;

@Transactional
public class UserDaoImpl extends BaseDao implements UserDao {

	protected SimpleJdbcInsert insertActor;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.insertActor = new SimpleJdbcInsert(dataSource).withTableName(
				"app_user").usingGeneratedKeyColumns("id");
	}

	public final RowMapper<User> rMapper = new RowMapper<User>() {

		public User mapRow(ResultSet rs, int rowNum) throws SQLException {
			User user = new User();
			user.setId(rs.getLong("id"));
			user.setName(rs.getString("name"));
			user.setHead(rs.getString("head"));
			user.setBirth_day(rs.getString("birth_day"));
			user.setBirth_month(rs.getString("birth_month"));
			user.setBirth_year(rs.getString("birth_year"));
			user.setNick(rs.getString("nick"));
			user.setSex(rs.getString("sex"));
			user.setEmail(rs.getString("email"));
			user.setIntroduction(rs.getString("introduction"));
			user.setLastLogin(rs.getTimestamp("last_login_time"));
			user.setCreateAt(rs.getTimestamp("createAt"));
			user.setUpdateAt(rs.getTimestamp("updateAt"));
			return user;
		}
	};

	@Transactional(readOnly = false, propagation = Propagation.MANDATORY)
	public User insertAppUser(User user) {
		logger.debug("in VenueDaoImpl....");
		Map<String, Object> map = new HashMap<String, Object>(4);
		map.put("name", user.getName());
		map.put("nick", user.getNick());
		map.put("head", user.getHead());
		Timestamp now = new Timestamp(System.currentTimeMillis());
		map.put("last_login_time", now);
		map.put("createAt", now);
		map.put("updateAt", now);
		map.put("sex", user.getSex());
		map.put("birth_year", user.getBirth_year());
		map.put("birth_month", user.getBirth_month());
		map.put("birth_day", user.getBirth_day());
		map.put("email", user.getEmail());
		map.put("introduction", user.getIntroduction());
		Number id = insertActor.executeAndReturnKey(map);

		user.setId(id.longValue());

		logger.debug(String.format("user=%s", user));

		return user;
	}

	@Override
	public User getUserIdByName(String name) {
		String sql = "select * from app_user where name=?";
		List<User> uList = simpleJdbcTemplate.query(sql, rMapper, name);
		User user = null;
		if (uList != null && uList.size() >= 1) {
			user = uList.get(0);
		}
		return user;
	}

	@Override
	public void updateUser(User uo) {
		StringBuffer sb = new StringBuffer();
		sb.append("update app_user");
		sb.append(" set name=:name");
		sb.append(",nick=:nick");
		sb.append(",sex=:sex");
		sb.append(",head=:head");
		sb.append(",birth_year=:birth_year");
		sb.append(",birth_month=:birth_month");
		sb.append(",birth_day=:birth_day");
		sb.append(",email=:email");
		sb.append(",introduction=:introduction");
		sb.append(",last_login_time=:lastLogin");
		sb.append(",updateAt=:updateAt");
		sb.append(" where id=:id");
		Timestamp now = new Timestamp(System.currentTimeMillis());
		uo.setLastLogin(now);
		uo.setUpdateAt(now);
		SqlParameterSource parameters = new BeanPropertySqlParameterSource(uo);
		simpleJdbcTemplate.update(sb.toString(), parameters);

	}
}
