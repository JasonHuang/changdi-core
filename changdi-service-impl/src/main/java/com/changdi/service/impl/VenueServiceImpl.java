package com.changdi.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.changdi.dao.AppUserDao;
import com.changdi.dao.VenueDao;
import com.changdi.service.VenueService;
import com.changdi.vo.UserVO;

@Service
public class VenueServiceImpl implements VenueService {

	@Autowired
	private VenueDao venueDao;

	@Autowired
	private AppUserDao appUserDao;

	@Override
	public List<Map<String, Object>> showAllVenue() {
		return venueDao.findAllVenue();
	}

	@Override
	public UserVO addAppUser(UserVO uo) {
		AppUser user = appUserDao.insertVenue(UserDTO.convertToVO(uo);
		return UserDTO.convertToVO(user);
	}

}
