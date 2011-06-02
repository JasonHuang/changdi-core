package com.changdi.service;

import java.util.List;
import java.util.Map;

import com.changdi.vo.User;

public interface VenueService {

	public List<Map<String, Object>> showAllVenue();

	public User addAppUser(User uo);

}
