package com.gavin.mongodb.bean;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.gavin.mongodb.common.MorphiaBean;
import com.github.jmkgreen.morphia.Datastore;

public class HotalTest {

	@Test
	public void testHotalCreate() {
		ApplicationContext ct = new ClassPathXmlApplicationContext(
				"applicationContext.xml");

		MorphiaBean mb = (MorphiaBean) ct.getBean("morphia");
		Datastore ds = mb.getDatastore();
		for (int i = 0; i < 10; i++) {
			Hotal hotle = new Hotal();
			Address address = new Address();
			address.setCity("北京" + i);
			address.setCountry("中国" + i);
			address.setPostCode("100080");
			address.setStreet("海淀中街" + i);

			hotle.setName("悦来酒店" + i);
			hotle.setStars(i);
			hotle.setAddress(address);
			ds.save(hotle);
		}
	}

}
