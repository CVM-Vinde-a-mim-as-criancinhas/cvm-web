package backend.repository.base;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Default;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import javax.ws.rs.Produces;
import java.sql.Connection;
import java.sql.SQLException;

public class BaseConnection {

    @Produces
    @RequestScoped
    @Default
    public Connection getConnection() throws SQLException {
        Connection conn = null;
        try {
            Context initialContext = new InitialContext();
            DataSource dataSource = (DataSource) initialContext.lookup("java:jboss/datasources/cvmDS");
            conn = dataSource.getConnection();
        } catch (Exception e) {
            throw new SQLException("Erro conexao", e);
        }
        return conn;
    }

    public void closeConnection(Connection c) throws SQLException {
        try {
            if (c != null) {
                if (!c.isClosed()) {
                    c.close();
                }
            }

        } catch (SQLException e) {
            throw new SQLException("Erro conexao", e);
        }
    }

}