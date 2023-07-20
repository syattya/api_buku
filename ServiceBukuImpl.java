package com.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Conn;
import com.DbConnectionBuku;
import com.dao.DaoBuku;
import com.entity.BukuEntity;
import com.service.ServiceBuku;

@Service
public class ServiceBukuImpl extends DbConnectionBuku implements ServiceBuku{

	@Autowired
	DaoBuku daoBuku;
	
	@Override
	public List<Map<String, Object>> getDataBuku(BukuEntity entity) throws Exception {
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		Conn conn = new Conn();
		try {
			conn.connection = getConnection();
			result = daoBuku.getDataBuku(entity, conn);
		} catch (Exception e) {
			throw new Exception(e);
		} finally {
			conn.closeConnection();
		}
		return result;
	}

	@Override
	public List<BukuEntity> insertDataBuku(BukuEntity entity) throws Exception {
		List<BukuEntity> result = null; //new ArrayList<Map<String, Object>>();
		Conn conn = new Conn();
		try {
			conn.connection = getConnection();
			result = daoBuku.insertDataBuku(conn, entity);
		} catch (Exception e) {
			throw new Exception(e);
		} finally {
			conn.closeConnection();
		}
		return null;
		}

	@Override
	public List<BukuEntity> updateDataBuku(BukuEntity entity) throws Exception {
		Conn conn = new Conn();
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		Map<String, Object> map = new HashMap<String, Object>();
		boolean cekDataBuku = false;
		try {
			 conn.connection = getConnection();
			  for (int i = 0; i < insertDataBuku.size(); i++) {	
			   cekDataBuku=this.daoBuku.cekDataBuku(insertDataBuku.get(i), conn);
			    if ( cekDataBuku == true ) {
				 map = this.daoBuku.updateDataBuku(insertDataBuku.get(i),conn);
				  result.add(map);
				  cekDataBuku = false;
				} else {
				   map = this.daoBuku.insertDataBuku(insertDataBuku.get(i),conn);
				   result.add(map);
				}	
			  }
				} catch (Exception e) {
					throw new Exception(e);
				} finally {
					conn.closeConnection();
				}
				return result;
	}

	@Override
	public List<BukuEntity> deleteDataBuku(BukuEntity entity) throws Exception {
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		Conn conn = new Conn();
		try {
			conn.connection = getConnection();
			result = daoBuku.deleteDataBuku(entity, conn);
		} catch (Exception e) {
			throw new Exception(e);
		} finally {
			conn.closeConnection();
		}
		return result;
	}
}
	
