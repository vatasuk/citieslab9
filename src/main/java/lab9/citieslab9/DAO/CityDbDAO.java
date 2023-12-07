package lab9.citieslab9.DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import lab9.citieslab9.City;

public class CityDbDAO {
    private static final String select_all_city = "SELECT id, cityname, pop FROM city ORDER BY cityname ASC";
    private static final String select_city_ById = "SELECT id, cityname,pop FROM city WHERE id = ?";
    private static final String insert_city = "INSERT INTO city(cityname,pop) VALUES(?,?)";
    private static final String edit_city = "UPDATE city SET cityname = ?, pop = ? WHERE id = ?";
    private static final String delete_city = "DELETE FROM city WHERE id = ?";
    private ConnectionBuilder builder = new DbConnectionBuilder();
    private Connection getConnection() throws SQLException {
        return builder.getConnection();
    }
    public Integer insert (City city) throws Exception {
        try (Connection con = getConnection();
             PreparedStatement pst =
                     con.prepareStatement(insert_city, new String[] { "id" })) {
            int Id = -1;
            pst.setString(1, city.getName());
            pst.setInt(2, city.getPop());
            pst.executeUpdate();
            ResultSet gk = pst.getGeneratedKeys();

            if (gk.next()) {
                Id = gk.getInt("id");
            }
            gk.close();
            return Id;
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    public void update(City city) throws Exception {
        try (Connection con = getConnection(); PreparedStatement pst
                = con.prepareStatement(edit_city)) {
            pst.setString(1, city.getName());
            pst.setInt(2, city.getPop());
            pst.setInt(3, city.getId());
            pst.executeUpdate();
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    public void delete(Integer Id) throws Exception {
        try (Connection con = getConnection(); PreparedStatement pst
                = con.prepareStatement(delete_city)) {
            pst.setInt(1, Id);
            pst.executeUpdate();
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    public City findById(Integer Id) throws Exception {
        City city = null;
        try (Connection con = getConnection()) {
            PreparedStatement pst =
                    con.prepareStatement(select_city_ById);
            pst.setInt(1, Id);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                city = new City(rs.getInt(1),rs.getString(2),rs.getInt(3));
            }
            rs.close();
            pst.close();
        } catch (Exception e) {

            throw new Exception(e);
        }
        return city;
    }

    public List<City> findAll() throws Exception {
        List<City> cities = new LinkedList<>();
        try (Connection con = getConnection();
             PreparedStatement pst =
                     con.prepareStatement(select_all_city);
             ResultSet rs = pst.executeQuery()) {
            while (rs.next()) {
                cities.add(new City(rs.getInt(1),rs.getString(2),rs.getInt(3)));
            }
        } catch (Exception e) {
            throw new Exception(e);
        }
        return cities;
    }
    private City fillCity(ResultSet rs) throws SQLException {
        City city = new City();
        city.setId(rs.getInt("id"));
        city.setName(rs.getString("cityname"));
        city.setPop(rs.getInt("pop"));
        return city;
    }
    public City FindById(Integer id, List<City> cities) {
        if (cities != null) {
            for (City r : cities) {
                if ((r.getId())==(id)) {
                    return r;
                }
            }
        } else {
            return null;
        }
        return null;
    }
}

