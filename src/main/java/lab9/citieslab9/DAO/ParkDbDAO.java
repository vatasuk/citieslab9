package lab9.citieslab9.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import lab9.citieslab9.Park;

/**
 * Класс реализации функций взаимодействия с базой данных для таблицы
 persons
 * (Сотрудники)
 */
public class ParkDbDAO {
    // SQL-запросы к таблице persons базы данных
    private static final String select_all_person = "SELECT id, cityid, pl, water, parktype, parkname,parkdate FROM park ORDER BY cityid ASC";

    private static final String select_person_ById = "SELECT id, cityid, pl, water, parktype, parkname,parkdate FROM park WHERE id = ?";
    private static final String insert_person = "INSERT INTO park( cityid, pl, water, parktype, parkname,parkdate) VALUES(?,?,?,?,?,?)";
    private static final String edit_person = "UPDATE park SET cityid = ?, pl = ?, water = ?, parktype = ?, parkname = ?,parkdate = ? WHERE id = ?";
    private static final String delete_person = "DELETE FROM park WHERE id = ?";

    private ConnectionBuilder builder = new DbConnectionBuilder();
    private Connection getConnection() throws SQLException {
        return builder.getConnection();
    }
    CityDbDAO dao = new CityDbDAO();
    public ParkDbDAO() {
// TODO Auto-generated constructor stub
    }

    public Integer insert (Park park) throws Exception {
        try (Connection con = getConnection();
             PreparedStatement pst =
                     con.prepareStatement(insert_person, new String[] { "id" })) {
            int Id = -1;
            getPark(park, pst);
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

    public void update(Park park) throws Exception {

        try (Connection con = getConnection(); PreparedStatement pst
                = con.prepareStatement(edit_person)) {
            getPark(park, pst);
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    private void getPark(Park park, PreparedStatement pst) throws SQLException {
        pst.setInt(1, park.getCityID());
        pst.setInt(2, park.getS());
        pst.setString(3, park.getWater());
        pst.setString(4, park.getType());
        pst.setString(5, park.getName());
        pst.setString(6, park.getDate());
        pst.executeUpdate();
    }


    public void delete(Integer Id) throws Exception {
        try (Connection con = getConnection(); PreparedStatement pst
                = con.prepareStatement(delete_person)) {
            pst.setLong(1, Id);
            pst.executeUpdate();
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    public Park findById(Integer Id) throws Exception {
        Park park = null;
        try (Connection con = getConnection()) {
            PreparedStatement pst =
                    con.prepareStatement(select_person_ById);
            pst.setLong(1, Id);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                park = fillPerson(rs);
            }
            rs.close();
            pst.close();
        } catch (Exception e) {
            throw new Exception(e);
        }
        return park;
    }

    public List<Park> findAll() throws Exception {
        List<Park> list = new LinkedList<>();
        try (Connection con = getConnection();
             PreparedStatement pst =
                     con.prepareStatement(select_all_person);
             ResultSet rs = pst.executeQuery()) {
            while (rs.next()) {

                list.add(fillPerson(rs));
            }
            rs.close();
        } catch (Exception e) {
            throw new Exception(e);
        }
        return list;
    }
    private Park fillPerson(ResultSet rs) throws SQLException,
            Exception {
        Integer idcity = rs.getInt("cityid");
        Park park = new Park();
        park.setId(rs.getInt("id"));
        park.setS(rs.getInt("pl"));
        park.setWater(rs.getString("water"));
        park.setType(rs.getString("parktype"));
        park.setName(rs.getString("parkname"));
        park.setCityID(idcity);
        return park;
    }
}