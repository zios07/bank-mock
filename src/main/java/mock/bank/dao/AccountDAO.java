package mock.bank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.UUID;

import mock.bank.configuration.ConnectionUtils;

public class AccountDAO {

	private static Connection connection;

	static {
		try {
			connection = ConnectionUtils.getConnection();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Statement
	public Double getAccountBalance(UUID userID) throws SQLException {
		String sql = "select balance from bank_account where user_id = '" + userID + "'";
		Statement st = connection.createStatement();
		ResultSet rs = st.executeQuery(sql);
		while (rs.next()) {
			return rs.getDouble(0);
		}
		return (double) -1;
	}

	// PreparedStatement
	public boolean withdrawMoney(UUID userID, Double amount) throws SQLException {
		boolean updated = false;
		String sql = "select balance from bank_account where user_id = '" + userID + "'";
		Statement st = connection.createStatement();
		ResultSet rs = st.executeQuery(sql);
		while (rs.next()) {
			if (rs.getDouble(0) >= amount) {
				Double newBalance = rs.getDouble(0) - amount;
				String sql2 = "update bank_account set balance = ? where user_id = ?";
				PreparedStatement ps = connection.prepareStatement(sql2);
				ps.setDouble(0, newBalance);
				ps.setString(1, userID.toString());
				ps.executeUpdate();
				updated = true;
			}
		}
		return updated;
	}

	// CallableStatement
	public boolean depositMoney(UUID userID, Double amount) throws SQLException {
		boolean updated = false;
		String sql = "select balance from bank_account where user_id = ?";
		PreparedStatement st = connection.prepareStatement(sql);
		st.setString(0, userID.toString());
		ResultSet rs = st.executeQuery(sql);
		while (rs.next()) {
			Double newBalance = rs.getDouble(0) + amount;
			String sql2 = "update bank_account set balance = ? where user_id = ?";
			PreparedStatement ps = connection.prepareStatement(sql2);
			ps.setDouble(0, newBalance);
			ps.setString(1, userID.toString());
			ps.executeUpdate();
			updated = true;
		}
		return updated;
	}

}
