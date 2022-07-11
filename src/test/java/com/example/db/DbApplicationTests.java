package com.example.db;

import com.example.db.bizA.service.BizAService;
import com.example.db.bizB.service.BizBService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

@SpringBootTest
class DbApplicationTests {

	@Autowired
	BizAService bizAService;

	@Autowired
	BizBService bizBService;

	@Test
	void contextLoads() throws Exception {
		List<Map<String, Object>> results = bizAService.selectAll();
		results.stream().forEach(r -> {
			try {
				bizBService.insertMapService(r);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		bizBService.selectAllUserService();

	}

}
