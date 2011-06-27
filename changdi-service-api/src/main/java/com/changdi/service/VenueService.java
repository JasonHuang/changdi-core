package com.changdi.service;

import java.util.List;
import java.util.Map;

import com.changdi.vo.UserVO;

public interface VenueService {

	public List<Map<String, Object>> showAllVenue();

	public UserVO addAppUser(UserVO uo);

}
