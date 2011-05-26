package com.changdi;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(value=SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="/WEB-INF/applicationContext.xml")
public class DaoTestBase {
	public Log logger = LogFactory.getLog(DaoTestBase.class);
}
