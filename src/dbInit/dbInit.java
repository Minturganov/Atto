package dbInit;

import util.dbConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class dbInit {

    public static void createTableProfile() {

        Connection connection = util.dbConnection.getConnection();
        try {
            Statement statement = connection.createStatement();
            String sql = "create table if not exists profile(" +
                    "id bigserial primary key," +
                    "name varchar(100) not null," +
                    "surname varchar(100)," +
                    "phone varchar(13) unique not null," +
                    "password varchar(100) not null," +
                    "login varchar(100) unique not null," +
                    "created_date timestamp default now()," +
                    "status varchar(50) not null," +
                    "role varchar(50) not null  )";
            statement.executeUpdate(sql);
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void createTableCard(){

        Connection connection= dbConnection.getConnection();
        try {
            Statement statement=connection.createStatement();
            String sql="create table if not exists card(" +
                    "card_number bigint primary key," +
                    "crated_date timestamp default now()," +
                    "exp_date date not null," +
                    "balance numeric(10,2) not null," +
                    "status varchar(50) not null," +
                    "phone varchar not null," +
                    "Foreign key (phone) references profile(phone))";
            statement.executeUpdate(sql);
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}
