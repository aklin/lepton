package org.example.lepton.store.postgres;

import lombok.experimental.UtilityClass;
import lombok.extern.java.Log;
import org.postgresql.jdbc3.Jdbc3ConnectionPool;

import javax.sql.*;
import java.sql.Connection;
import java.sql.SQLException;

@UtilityClass
class ConnectionManager {
	private static final String magicUrl = "127.0.0.1";
	private static PooledConnection pool;

	public static void init() throws SQLException {
		final PoolConnectionLogger connectionLogger = new PoolConnectionLogger();
		pool = new Jdbc3ConnectionPool().getPooledConnection();
		pool.addStatementEventListener(connectionLogger);
		pool.addConnectionEventListener(connectionLogger);
	}

	public static Connection getConnection() throws SQLException {
		return pool.getConnection();
	}

	@Log
	private class PoolConnectionLogger
		implements ConnectionEventListener, StatementEventListener {

		@Override
		public void connectionClosed(ConnectionEvent connectionEvent) {
			log.finer(connectionEvent.toString());
		}

		@Override
		public void connectionErrorOccurred(ConnectionEvent connectionEvent) {
			log.severe(connectionEvent.toString());
		}

		@Override
		public void statementClosed(StatementEvent statementEvent) {
			log.finer(statementEvent.toString());
		}

		@Override
		public void statementErrorOccurred(StatementEvent statementEvent) {
			log.severe(statementEvent.toString());
		}
	}

}
