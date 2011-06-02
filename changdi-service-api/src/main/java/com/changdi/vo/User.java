package com.changdi.vo;

import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;

public class User {
	private String name;
	private String nick;
	private String uid;
	private String head;
	private String location;
	private String country_code;
	private Integer birth_day;
	private Integer birth_month;
	private Integer birth_year;
	private String city_code;
	private String email;
	private Integer fansnum;
	private String introduction;
	private Integer idolnum;
	private Integer isent;
	private Integer isvip;
	private String province_code;
	private Integer sex;
	// private List<Edu> edu;
	private List<Tag> tag;
	private Integer tweetnum;
	private String verifyinfo;

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

	public Integer getBirth_day() {
		return birth_day;
	}

	public void setBirth_day(Integer birth_day) {
		this.birth_day = birth_day;
	}

	public Integer getBirth_month() {
		return birth_month;
	}

	public void setBirth_month(Integer birth_month) {
		this.birth_month = birth_month;
	}

	public Integer getBirth_year() {
		return birth_year;
	}

	public void setBirth_year(Integer birth_year) {
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

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
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

	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return new ToStringBuilder(this)
				.append("birth_month", this.birth_month)
				.append("introduction", this.introduction)
				.append("province_code", this.province_code)
				.append("city_code", this.city_code).append("uid", this.uid)
				.append("verifyinfo", this.verifyinfo)
				.append("fansnum", this.fansnum).append("tag", this.tag)
				.append("tweetnum", this.tweetnum).append("isvip", this.isvip)
				.append("isent", this.isent).append("email", this.email)
				.append("head", this.head).append("location", this.location)
				.append("birth_year", this.birth_year)
				.append("birth_day", this.birth_day).append("name", this.name)
				.append("country_code", this.country_code)
				.append("nick", this.nick).append("sex", this.sex)
				.append("idolnum", this.idolnum).toString();
	}

}
