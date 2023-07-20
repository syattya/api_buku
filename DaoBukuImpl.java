package com.dao.impl;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import com.Conn;
import com.constand.ConstandSQLBuku;
import com.dao.DaoBuku;
import com.entity.BukuEntity;
import com.muf.cms.entity.BukuEntity;
import oracle.jdbc.OracleTypes;


@Repository
public class DaoBukuImpl implements DaoBuku{
	
	private static final Logger logger = LoggerFactory.getLogger(DaoBukuImpl.class);
	
	@Override
	public List<Map<String, Object>> getDataBuku(BukuEntity entity, Conn conn) throws Exception {
		List<Map<String, Object>> listBuku = new ArrayList<Map<String, Object>>();
	   try {
			query = ConstandSQLBuku.getDataBuku;
			conn.cl = conn.connection.prepareCall(query);
			conn.cl.setString(1, entity.getId_buku());
			conn.cl.registerOutParameter(2, OracleTypes.CURSOR);
			conn.cl.executeQuery();
			conn.rs = (ResultSet) conn.cl.getObject(2);
			while (conn.rs.next()) {
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("ID_BUKU", conn.rs.getString("ID_BUKU"));
				map.put("JUDUL_BUKU", conn.rs.getString("JUDUL_BUKU"));
				map.put("PENGARANG_BUKU", conn.rs.getString("PENGARANG_BUKU"));
				map.put("PENERBIT_BUKU", conn.rs.getString("PENERBIT_BUKU"));
				map.put("TANGGAL_TERBIT_BUKU", conn.rs.getString("TANGGAL_TERBIT_BUKU"));
				map.put("TEBAL_BUKU", conn.rs.getString("TEBAL_BUKU"));
				map.put("STATUS_BUKU", conn.rs.getString("STATUS_BUKU"));
				listBuku.add(map);
			}
		} catch (Exception e) {
			e.getMessage();
			logger.error(e.getMessage(), e);
			throw new Exception(e);
		} finally {
			conn.closeStatement();
		}
		return list;
	}
	
	@Override
	public List<BukuEntity> insertDataBuku(Conn conn, BukuEntity entity) throws Exception {
		List<BukuEntity> result = new ArrayList<>();
		String query = ConstandSQLBuku.insertDataBuku
				.replaceAll("SZBUKUID", entity.getId_buku());
		conn.pr = conn.connection.prepareStatement(query);
		conn.rs = conn.pr.executeQuery();
		System.out.println(query);
		try {
			while (conn.rs.next()) {
				BukuEntity insertDataBuku = new BukuEntity();
				insertDataBuku.setId_buku(conn.rs.getString(1) == null ? "" : conn.rs.getString(1));
				insertDataBuku.setJudul_buku(conn.rs.getString(2) == null ? "" : conn.rs.getString(2));
				insertDataBuku.setPengarang_buku(conn.rs.getString(3) == null ? "" : conn.rs.getString(3));
				insertDataBuku.setPenerbit_buku(conn.rs.getString(4) == null ? "" : conn.rs.getString(4));
				insertDataBuku.setTanggal_terbit_buku(conn.rs.getString(5) == null ? "" : conn.rs.getString(5));
				insertDataBuku.setStatus_buku(conn.rs.getString(6) == null ? "" : conn.rs.getString(6));
				
				BukuEntity entityResult = new BukuEntity();
				result.add(entityResult);
			}
			if (result.isEmpty()) {
				BukuEntity insertDataBuku = new BukuEntity();
				insertDataBuku.setId_buku("");
				insertDataBuku.setJudul_buku("");
				insertDataBuku.setPengarang_buku("");
				insertDataBuku.setPenerbit_buku("");
				insertDataBuku.setTanggal_terbit_buku("");
				insertDataBuku.setStatus_buku("");
				
				BukuEntity entityResult = new BukuEntity();
				result.add(entityResult);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e);
		} finally {
			conn.closeStatement();
		}
		System.out.println(result);
		return result;
	}
	
	@Override
	public boolean cekDataBuku(BukuEntity bukuEntity, Conn conn) throws Exception {
		boolean result = false;
		try {
			String query = ConstandSQLBuku.cekDataBuku;
			conn.pr = conn.connection.prepareStatement(query);
			conn.pr.setString(1, bukuEntity.getId_buku());
			conn.rs = conn.pr.executeQuery();
			while (conn.rs.next()) {
				result = true;
			}
		}catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e);			
		} finally {
			conn.closeStatement();
		}
		return result;
	}
	
	@Override
	public Map<String, Object> updateDataBuku(BukuEntity bukuEntity, Conn conn) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
		conn.cl = conn.connection.prepareCall(ConstandSQLBuku.updateDataBuku);
		conn.cl.setString(1, bukuEntity.getId_buku());
		conn.cl.setString(2, bukuEntity.getJudul_buku());
		conn.cl.setString(3, bukuEntity.getPengarang_buku());
		conn.cl.setString(4, bukuEntity.getPenerbit_buku());
		conn.cl.setString(5, bukuEntity.getTanggal_terbit_buku());
		conn.cl.setString(6, bukuEntity.getTebal_buku());
		conn.cl.registerOutParameter(7, OracleTypes.VARCHAR);
		conn.cl.executeQuery();
		
		conn.rs = (ResultSet) conn.cl.getObject(9);
		String x = conn.cl.getString(9);
		
		map.put("msg", x);
	} catch (Exception e) {
		e.printStackTrace();
		throw new Exception(e);			
	} finally {
		conn.closeStatement();
	}
		return map;
	}
	
	@Override
	public List<Map<String, Object>> deleteDataBuku(BukuEntity entity, Conn conn) throws Exception {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
	   try {
			query = ConstandSQLBuku.deleteDataBuku;
			conn.cl = conn.connection.prepareCall(query);
			conn.cl.setString(1, entity.getId_buku());
			conn.cl.registerOutParameter(2, OracleTypes.CURSOR);
			conn.cl.executeQuery();
			conn.rs = (ResultSet) conn.cl.getObject(2);
			while (conn.rs.next()) {
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("ID_BUKU", conn.rs.getString("ID_BUKU"));
				list.add(map);
			}
		} catch (Exception e) {
			e.getMessage();
			logger.error(e.getMessage(), e);
			throw new Exception(e);
		} finally {
			conn.closeStatement();
		}
		return list;
	}
}