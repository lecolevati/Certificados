package persistence;

import java.sql.Connection;
import java.sql.SQLException;

public class CertificadosDao {

	private Connection c;
	
	public CertificadosDao() throws SQLException{
		GenericoDao gDao = new GenericoDao();
		c = gDao.getConnection();
	}
	
}
