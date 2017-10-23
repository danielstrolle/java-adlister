import java.sql.*;
import com.mysql.cj.jdbc.Driver;
import java.util.ArrayList;
import java.util.List;

public class MySQLAdsDao implements Ads {
    Connection connection = null;

    public MySQLAdsDao() {
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                    Config.getUrl(),
                    Config.getUser(),
                    Config.getPassword()
            );

        } catch (SQLException e) {
            throw new RuntimeException("Error establishing database connection!", e);
        }

    }

    @Override
    public List<Ad> all() {
        String selectQuery = "SELECT * FROM adlister_db.ads";
        List<Ad> ads = new ArrayList<>();

        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(selectQuery);
            while (rs.next()) {
                ads.add(
                        new Ad(
                                rs.getLong("id"),
                                rs.getLong("user_id"),
                                rs.getString("title"),
                                rs.getString("description")
                        ));
            }
            return ads;
        } catch (SQLException e) {
            throw new RuntimeException("Error Fetching all Ads!", e);
        }

    }

    @Override
    public Long insert(Ad ad) {
        String query = "INSERT INTO ads(user_id, title, description) VALUES(";
        query += "1, ";
        query += "'" + ad.getTitle() + "', ";
        query += "'" + ad.getDescription() + "')";
        try {
            Statement stmt = connection.createStatement();
            stmt.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                return rs.getLong(1);
            } else {
                throw new RuntimeException("No id found after inserting ad!");
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error inserting an ad!");
        }
    }
}
