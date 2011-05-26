package com.changdi;

import java.sql.Timestamp;

import javax.annotation.Resource;

import org.junit.Test;

import com.changdi.dao.VenueDao;
import com.changdi.persist.Venue;

public class VenueDaoTest extends DaoTestBase {
	@Resource
	private VenueDao venueDao;

	@Test
	public void crud() throws Exception {
		Venue v = new Venue();

		v.setCreateAt(new Timestamp(System.currentTimeMillis()));
		v.setName("联合大学文理学院网球场");
		v.setDescription("周六下午畅打.");

		venueDao.insertVenue(v);

		logger.debug(String.format("v=%s", v));

		logger.debug(venueDao.findAllVenue());
	}
}
