package com.constand;

public class ConstandSQLBuku {
	
	public static final String getDataBuku = 
			"SELECT * FROM DETAIL_BUKU";

	public static final String insertDataBuku = 
			"INSERT INTO DETAIL_BUKU\n" +
					"  (ID_BUKU,\n" + 
					"   JUDUL_BUKU,\n" + 
					"   PENGARANG_BUKU,\n" + 
					"   PENERBIT_BUKU,\n" + 
					"   TANGGAL_TERBIT_BUKU,\n" + 
					"   TEBAL_BUKU)\n" + 
					"VALUES\n" + 
					"  ('A0001',\n" + 
					"   'HARRY POTTER DAN BATU BERTUAH',\n" + 
					"   'J.K ROWLING',\n" + 
					"   'GRAMEDIA',\n" + 
					"   '29-JUN-1997',\n" + 
					"   '384')";

	public static final String cekDataBuku = "SELECT * FROM DETAIL_BUKU A WHERE ID_BUKU = 'SZBUKUID'";
	
	public static final String updateDataBuku = 
			"UPDATE DETAIL_BUKU SET STATUS_BUKU = '1' WHERE STATUS_BUKU = '0'";

	public static final String deleteDataBuku = 
			"DELETE FROM DETAIL_BUKU WHERE ID_BUKU = 'SZBUKUID'";
	
}