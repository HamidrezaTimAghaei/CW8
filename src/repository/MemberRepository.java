package repository;

import config.DataBaseConnection;
import entity.Member;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MemberRepository {
    public void addMember(Member member) {
        String query = "insert into members ( member_name,member_date) values(?,?)";
        Connection connection = DataBaseConnection.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, member.getMemberName());
            statement.setDate(2, new java.sql.Date(member.getMemberDate().getTime()));
            statement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void update(int id, String name) {
        String query = "update members Set member_name = ?  Where member_id =?";
        Connection connection = DataBaseConnection.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, name);
            statement.setInt(2, id);

            statement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public boolean existById(int id) {
        String query = "select * from members where member_id = ?";
        Connection connection = DataBaseConnection.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setInt(1, id);
            return statement.executeQuery().next();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


    public void delete(int id) {
        String query = "delete from members  Where member_id =?";
        Connection connection = DataBaseConnection.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);

            statement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public List<Member> membersList() {
        String query = "select * from members";
        Connection connection = DataBaseConnection.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(query);

            ResultSet rs = statement.executeQuery();
            List<Member> member = new ArrayList<>();

            while (rs.next()) {
                Member member1 = new Member();
                member1.setMemberId(rs.getInt("member_id"));
                member1.setMemberName(rs.getString("member_name"));
                member1.setMemberDate(rs.getDate("member_date"));
                member.add(member1);
            }
            return member;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


}