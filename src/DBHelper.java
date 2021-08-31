
import java.sql.*;
import javax.swing.table.DefaultTableModel;

public class DBHelper {

	Object[][] databaseInfo;

	Object[] columns = { "Name", "Deadline", "Description", "Date Published" };

	ResultSet rows;

	ResultSetMetaData metaData;
	DefaultTableModel dTableModel = new DefaultTableModel(databaseInfo, columns) {
		public Class getColumnClass(int column) {
			Class returnValue;
			if ((column >= 0) && (column < getColumnCount())) {
				returnValue = getValueAt(0, column).getClass();
			} else {
				returnValue = Object.class;
			}
			return returnValue;
		}
	};

	public DefaultTableModel getData() {
		Connection conn = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/EccDB", "root", "kyle123");
			Statement sqlState = conn.createStatement();
			String selectSched = "SELECT * FROM schedTBL";
			rows = sqlState.executeQuery(selectSched);
			Object[] tempRow;

			while (rows.next()) {
				tempRow = new Object[] { rows.getString(2), rows.getDate(3), rows.getString(4), rows.getDate(5) };
				dTableModel.addRow(tempRow);
			}

			return dTableModel;

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} catch (ClassNotFoundException ex) {
			System.out.println(ex.getMessage());
		}

		return dTableModel;

	}
	// query for login system
	public String Authenticate(String username, String password) {
		Connection conn = null;
		String returnType = null;
		if(username!=null&&password!=null) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				conn = DriverManager.getConnection("jdbc:mysql://localhost/EccDB", "root", "kyle123");
				Statement sqlState = conn.createStatement();
				String selectUser = "SELECT * FROM userTBL where Username='" + username + "' and Password='" + password + "'";
				rows = sqlState.executeQuery(selectUser);
				
				ResultSet rs = sqlState.executeQuery(selectUser);
				if(rs.next()) {
				 returnType= "access granted";
				}
				else {
					returnType= "There is no Record in database";
				}

			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
			} catch (ClassNotFoundException ex) {
				System.out.println(ex.getMessage());
			}
		}
		else {
			 returnType= "no data";
		}
		return returnType ;
		

	}

}
