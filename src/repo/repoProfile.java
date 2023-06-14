package repo;

import dto.dtoProfile;
import util.dbConnection;
import attoEnum.enumProfile;
import attoEnum.enumRole;

import java.sql.*;

public class repoProfile {

    public dtoProfile getProfileByPhone(String data){
        Connection connection = null;

        String sql="select * from profile where login=? or phone=?";
        try {
            connection= dbConnection.getConnection();
            PreparedStatement ps= connection.prepareStatement(sql);
            ps.setString(1,data);
            ps.setString(2,data);
            ResultSet resultSet =ps.executeQuery();
            if (resultSet.next()){
                dtoProfile profileDto=new dtoProfile();
                profileDto.setId(resultSet.getInt("id"));
                profileDto.setName(resultSet.getString("name"));
                profileDto.setSurname(resultSet.getString("surname"));
                profileDto.setPhone(resultSet.getString("phone"));
                profileDto.setLogin(resultSet.getString("login"));
                profileDto.setPassword(resultSet.getString("password"));
                profileDto.setStatus(enumProfile.valueOf(resultSet.getString("status")));
                profileDto.setCreated_date(resultSet.getTimestamp("created_date").toLocalDateTime());
                profileDto.setRole(enumRole.valueOf(resultSet.getString("role")));
                return profileDto;

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return null;
    }

    /////    !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    /////    <<<<<<<< addProfile >>>>>>>> !!!!!!!!!
    /////    ??????????????????????????????????????

    public  boolean  addProfile(dtoProfile profileDto) {
        Connection connection = dbConnection.getConnection();
        String sql = "insert into profile(name,surname, phone, password, login, created_date, status,role)" +
                "values(?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement pr= connection.prepareStatement(sql);
            pr.setString(1,profileDto.getName());
            pr.setString(2,profileDto.getSurname());
            pr.setString(3,profileDto.getPhone());
            pr.setString(4,profileDto.getPassword());
            pr.setString(5,profileDto.getLogin());
            pr.setTimestamp(6, Timestamp.valueOf(profileDto.getCreated_date()));
            pr.setString(7,profileDto.getStatus().toString());
            pr.setString(8,profileDto.getRole().toString());
            pr.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
