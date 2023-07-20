package com.muf.cms.service;

import java.util.List;
import java.util.Map;

import com.Conn;
import com.entity.BukuEntity;

public interface ServiceBuku {

	List<Map<String, Object>> getDataBuku(BukuEntity entity) throws Exception;
	
	public List<Map<String, Object>> insertDataBuku(BukuEntity entity) throws Exception;
	
	List<Map<String, Object>> updateDataBuku(List<BukuEntity> updateDataBuku)throws Exception;
	
	List<Map<String, Object>> deleteDataBuku(BukuEntity entity) throws Exception;

}
