package com.changdi.dao;

import java.util.List;
import java.util.Map;

import com.changdi.dao.persist.Venue;

public interface VenueDao {

	public void insertVenue(Venue v);

	public List<Map<String, Object>> findAllVenue();
	
}
