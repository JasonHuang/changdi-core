package com.changdi.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.changdi.dao.VenueDao;
import com.changdi.service.VenueService;
import com.changdi.vo.User;

@Service
public class VenueServiceImpl implements VenueService {

	@Autowired
	private VenueDao venueDao;

	@Autowired
	private VenueDao appUserDao;

	@Override
	public List<Map<String, Object>> showAllVenue() {
		return venueDao.findAllVenue();
	}

	@Override
	public User addAppUser(User uo) {
		// AppUser user = appUserDao.insertVenue(VenueDTO.convertToVO(uo);
		// return UserDTO.convertToVO(user);
		return null;
	}

}
