package org.example.lepton.store.postgres;

import com.lepton.api.v1.core.Exceptions;
import com.lepton.api.v1.core.Resource;
import com.lepton.api.v1.store.Store;
import lombok.extern.java.Log;
import org.codejargon.fluentjdbc.api.FluentJdbc;
import org.codejargon.fluentjdbc.api.FluentJdbcBuilder;

import javax.validation.constraints.NotNull;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@Log
public class PostgresStore implements Store {

	static {
		try {
			ConnectionManager.init();
		} catch (SQLException e) {
			log.severe(e.getSQLState());
			log.severe(e.getMessage());
		}
	}

	public static Resource toResource(
		final long id,
		final String uri,
		final Object data
	) {
		return null;
	}

	@Override
	public boolean contains(String uri) {
		return false;
	}

	@Override
	public boolean contains(@NotNull Resource resource) {
		return false;
	}

	@Override
	public Resource get(@NotNull String uri) {

		try (final Connection connection = ConnectionManager.getConnection()) {
			FluentJdbc fluent = new FluentJdbcBuilder().build();

			return fluent.queryOn(connection)
				.select("SELECT * FROM RESOURCES WHERE URI = ?")
				.params(uri)
				.firstResult(resultSet ->
					toResource(resultSet.getLong("id"),
						resultSet.getString("uri"),
						resultSet.getObject("jsonData")
					)).get()
				;

		} catch (SQLException e) {
			log.severe(e.getSQLState());
		}

		return null;
	}

	@Override
	public Resource set(@NotNull Resource resource) {
		return null;
	}

	@Override
	public Resource initialise(@NotNull Resource resource) throws
		Exceptions.StoreException {

		try (final Connection connection = ConnectionManager.getConnection()) {
			FluentJdbc fluentJdbc = new FluentJdbcBuilder().build();

		} catch (SQLException e) {
			log.severe(e.getSQLState());
		}

		return null;
	}

	@Override
	public Resource replace(@NotNull Resource resource) throws
		Exceptions.StoreException {
		return null;
	}

	@Override
	public Resource remove(@NotNull Resource resource) throws
		Exceptions.StoreException {
		return null;
	}

	@Override
	public boolean isEmpty() {
		return false;
	}

	@Override
	public void close() throws IOException {

	}
}
