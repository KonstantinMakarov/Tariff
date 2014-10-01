package com.epam.tariff.logic;

import com.epam.tariff.entity.Tariff;
import com.mysql.jdbc.PreparedStatement;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Kanstantsin_Makarau on 9/25/2014.
 */
public class TariffDB {
    List<Tariff> data;
    final static String columnList = "(name, operatorName, payroll, smsPrice, intraCallPrice," +
            "externalCallPrice, landLineCallPrice, hasFavouriteNumber, typeTariff, getOperatorPrice)";

    public final static Logger logger = Logger.getLogger(com.epam.tariff.logic.TariffDB.class);

    public TariffDB(List<Tariff> data) {
        this.data = data;
        createDB();
    }

    private void createDB() {
        Connection connection = null;
        PreparedStatement statement = null;
        try{
            Class.forName("org.gjt.mm.mysql.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1/xmltojdbc", "root", "root");
            statement = (PreparedStatement) connection.prepareStatement("INSERT INTO tariffs " + columnList +
                                                                            " VALUES(?,?,?,?,?,?,?,?,?,?)");
            for(int i = 0; i < data.size(); i++){
                statement.setString(1, data.get(i).getName());
                statement.setString(2, data.get(i).getOperatorName());
                statement.setDouble(3, data.get(i).getPayroll());
                statement.setDouble(4, data.get(i).getSmsPrice());
                statement.setDouble(5, data.get(i).getCallPrice().getIntraCallPrice());
                statement.setDouble(6, data.get(i).getCallPrice().getExternalCallPrice());
                statement.setDouble(7, data.get(i).getCallPrice().getLandLineCallPrice());
                statement.setBoolean(8, data.get(i).getParameter().isHasFavouriteNumber());
                statement.setString(9, data.get(i).getParameter().getTypeTariff());
                statement.setDouble(10, data.get(i).getParameter().getGetOperatorPrice());
                statement.executeUpdate();
            }

        } catch (SQLException e) {
            logger.error("SQL working error: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            logger.error("Incorrect driver: " +e.getMessage());
        }
        finally {
            try{
                if(connection != null){ connection.close();}
                if(statement != null) {statement.close();}
            } catch (SQLException e) {
                logger.error("SQL closing error: " + e.getMessage());
            }
        }
    }

}
