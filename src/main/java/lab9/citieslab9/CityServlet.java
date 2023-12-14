package lab9.citieslab9;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import lab9.citieslab9.City;
import lab9.citieslab9.DAO.CityDbDAO;
import lab9.citieslab9.DAO.ConnectionProperty;



@WebServlet(
        name = "city",
        urlPatterns = {"/city"}
)
public class CityServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    ConnectionProperty prop;
    public CityServlet() throws FileNotFoundException, IOException {

        prop = new ConnectionProperty();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        String userPath;
        List<City> cities;
        CityDbDAO dao = new CityDbDAO();
        try {
            cities = dao.findAll();
            request.setAttribute("cities", cities);
        } catch (Exception e) {
            e.printStackTrace();
        }
        userPath = request.getServletPath();
        if ("/city".equals(userPath)) {
            request.getRequestDispatcher("/city.jsp").forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CityDbDAO dao = new CityDbDAO();
        String name = request.getParameter("inputName");
        int pop = Integer.parseInt(request.getParameter("inputPop"));
        City newCity = new City(name,pop);
        try {
            Integer index = dao.insert(newCity);
            System.out.println("Adding result: " + index );
        } catch (Exception e) {

            e.printStackTrace();
        }
        doGet(request, response);
    }

}
