package com.changdi.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.changdi.dao.VenueDao;
import com.changdi.service.VenueService;

@Service
public class VenueServiceImpl implements VenueService {

	@Autowired
	private VenueDao venueDao;

	@Override
	public List<Map<String, Object>> showAllVenue() {
		return venueDao.findAllVenue();
	}

}
