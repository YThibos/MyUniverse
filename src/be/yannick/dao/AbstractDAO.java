package be.yannick.dao;

import javax.sql.DataSource;

abstract class AbstractDAO {
	
	public static final String JDNI_NAME = "jdbc/MyUniverse";
	
	protected DataSource dataSource;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

}
