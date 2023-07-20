package com.muf.cms.dao;

import java.util.List;
import java.util.Map;

import com.muf.cms.Conn;
import com.muf.cms.entity.CancelRltEntity;
import com.muf.cms.entity.CetakLaporanEntity;
import com.muf.cms.entity.EntryResultEntity;

public interface DaoBuku {

	List<Map<String, Object>> getDataBuku(BukuEntity entity, Conn conn)throws Exception;
	
	public List<BukuEntity> insertDataBuku(Conn conn, BukuEntity entity) throws Exception;

	boolean cekDataBuku(BukuEntity bukuEntity, Conn conn)throws Exception;

	Map<String, Object> updateDataBuku(BukuEntity bukuEntity, Conn conn)throws Exception;

	List<Map<String, Object>> deleteDataBuku(BukuEntity entity, Conn conn)throws Exception;
}
