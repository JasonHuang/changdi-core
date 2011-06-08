package com.changdi.vo;

import java.sql.Timestamp;
import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;

public class User {
	private long id;
	private String name;
	private String nick;
	private String uid;
	private String head;
	private String location;
	private String country_code;
	private String birth_day;
	private String birth_month;
	private String birth_year;
	private String city_code;
	private String email;
	private Integer fansnum;
	private String introduction;
	private Integer idolnum;
	private Integer isent;
	private Integer isvip;
	private String province_code;
	private String sex;
	// private List<Edu> edu;
	private List<Tag> tag;
	private Integer tweetnum;
	private String verifyinfo;
	private Timestamp lastLogin;
	private Timestamp createAt;
	private Timestamp updateAt;
	
	private String tokenKey;
	private String tokenSecret;
	private String verifier;
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public static class Tag {
		private String id;
		private String name;

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		/**
		 * @see java.lang.Object#toString()
		 */
		public String toString() {
			return new ToStringBuilder(this).append("name", this.name)
					.append("id", this.id).toString();
		}

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getHead() {
		return head;
	}

	public void setHead(String head) {
		this.head = head;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getCountry_code() {
		return country_code;
	}

	public void setCountry_code(String country_code) {
		this.country_code = country_code;
	}

	public String getBirth_day() {
		return birth_day;
	}

	public void setBirth_day(String birth_day) {
		this.birth_day = birth_day;
	}

	public String getBirth_month() {
		return birth_month;
	}

	public void setBirth_month(String birth_month) {
		this.birth_month = birth_month;
	}

	public String getBirth_year() {
		return birth_year;
	}

	public void setBirth_year(String birth_year) {
		this.birth_year = birth_year;
	}

	public String getCity_code() {
		return city_code;
	}

	public void setCity_code(String city_code) {
		this.city_code = city_code;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getFansnum() {
		return fansnum;
	}

	public void setFansnum(Integer fansnum) {
		this.fansnum = fansnum;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public Integer getIdolnum() {
		return idolnum;
	}

	public void setIdolnum(Integer idolnum) {
		this.idolnum = idolnum;
	}

	public Integer getIsent() {
		return isent;
	}

	public void setIsent(Integer isent) {
		this.isent = isent;
	}

	public Integer getIsvip() {
		return isvip;
	}

	public void setIsvip(Integer isvip) {
		this.isvip = isvip;
	}

	public String getProvince_code() {
		return province_code;
	}

	public void setProvince_code(String province_code) {
		this.province_code = province_code;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public List<Tag> getTag() {
		return tag;
	}

	public void setTag(List<Tag> tag) {
		this.tag = tag;
	}

	public Integer getTweetnum() {
		return tweetnum;
	}

	public void setTweetnum(Integer tweetnum) {
		this.tweetnum = tweetnum;
	}

	public String getVerifyinfo() {
		return verifyinfo;
	}

	public void setVerifyinfo(String verifyinfo) {
		this.verifyinfo = verifyinfo;
	}

	public Timestamp getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Timestamp lastLogin) {
		this.lastLogin = lastLogin;
	}

	public Timestamp getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Timestamp createAt) {
		this.createAt = createAt;
	}

	public Timestamp getUpdateAt() {
		return updateAt;
	}

	public void setUpdateAt(Timestamp updateAt) {
		this.updateAt = updateAt;
	}

	public String getTokenKey() {
		return tokenKey;
	}

	public void setTokenKey(String tokenKey) {
		this.tokenKey = tokenKey;
	}

	public String getTokenSecret() {
		return tokenSecret;
	}

	public void setTokenSecret(String tokenSecret) {
		this.tokenSecret = tokenSecret;
	}

	public String getVerifier() {
		return verifier;
	}

	public void setVerifier(String verifier) {
		this.verifier = verifier;
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return new ToStringBuilder(this)
				.append("birth_month", this.birth_month)
				.append("introduction", this.introduction)
				.append("updateAt", this.updateAt)
				.append("city_code", this.city_code)
				.append("province_code", this.province_code)
				.append("tag", this.tag).append("tweetnum", this.tweetnum)
				.append("isvip", this.isvip).append("email", this.email)
				.append("createAt", this.createAt)
				.append("tokenSecret", this.tokenSecret)
				.append("nick", this.nick).append("id", this.id)
				.append("lastLogin", this.lastLogin).append("uid", this.uid)
				.append("verifyinfo", this.verifyinfo)
				.append("fansnum", this.fansnum).append("isent", this.isent)
				.append("location", this.location).append("head", this.head)
				.append("birth_year", this.birth_year)
				.append("birth_day", this.birth_day).append("name", this.name)
				.append("country_code", this.country_code)
				.append("verifier", this.verifier)
				.append("tokenKey", this.tokenKey)
				.append("idolnum", this.idolnum).append("sex", this.sex)
				.toString();
	}


}
