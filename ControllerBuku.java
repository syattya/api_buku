package com.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.Conn;
import com.entity.BukuEntity;
import com.service.serviceBuku;

@RestController
public class ControllerBuku {

	public static final Logger logger = LoggerFactory.getLogger(ControllerBuku.class);
	
	@Autowired
	ServiceBuku serviceBuku;
		
	@RequestMapping(value = "/getDataBuku", method = RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> getDataBuku(@RequestBody BukuEntity entity) {
		List<Map<String, Object>> listBuku = new ArrayList<Map<String, Object>>();
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			listBuku = serviceBuku.getDataBuku(entity);
			map.put("msg_id", 0);
			map.put("status", true);
			map.put("data", listBuku);
			return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
		} catch (Exception e) {
			map.put("msg_desc", e.getMessage());
			map.put("msg_id", 1);
			return new ResponseEntity<Map<String, Object>>(map, HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "/insertDataBuku", method = RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> insertDataBuku(@RequestBody BukuEntity entity) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Map<String, Object>> hasil = new ArrayList<Map<String, Object>>();
		try {
			hasil = serviceBuku.insertDataBuku(entity);
			map.put("status", true);
			map.put("data", hasil);
			return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			map.put("notif", "gagal");
			map.put("data", e.getMessage());
			map.put("status", false);
			e.printStackTrace();
			return new ResponseEntity<Map<String, Object>>(map, HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "/updateDataBuku", method = RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> updateDataBuku(@RequestBody BukuEntity entity) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<BukuEntity> hasil = new ArrayList<BukuEntity>();
		try {
			hasil = serviceBuku.updateDataBuku(entity);
			map.put("status", true);
			map.put("data", hasil);
			return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			map.put("notif", "gagal");
			map.put("data", e.getMessage());
			map.put("status", false);
			e.printStackTrace();
			return new ResponseEntity<Map<String, Object>>(map, HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "/deleteDetailBuku", method = RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> deleteDetailBuku(@RequestBody BukuEntity entity) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<BukuEntity> hasil = new ArrayList<BukuEntity>();
		try {
			hasil = serviceBuku.deleteDetailBuku(entity);
			map.put("status", true);
			map.put("data", hasil);
			return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			map.put("notif", "gagal");
			map.put("data", e.getMessage());
			map.put("status", false);
			e.printStackTrace();
			return new ResponseEntity<Map<String, Object>>(map, HttpStatus.BAD_REQUEST);
		}
	}
}
