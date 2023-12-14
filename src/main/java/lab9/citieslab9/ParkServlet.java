package lab9.citieslab9;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import lab9.citieslab9.Park;
import lab9.citieslab9.DAO.CityDbDAO;
import lab9.citieslab9.DAO.ParkDbDAO;
import lab9.citieslab9.DAO.ConnectionProperty;


@WebServlet("/park")
public class ParkServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    ConnectionProperty prop;

    public ParkServlet() throws FileNotFoundException, IOException {
        super();
// TODO Auto-generated constructor stub
        prop = new ConnectionProperty();
    }
    /**
     * @see HttpServlet#doGet(HttpServletRequest request,
            HttpServletResponse
     * response)
     */
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        String userPath;
        List<City> cities;
        List<Park> parks;
        CityDbDAO daoCity = new CityDbDAO();
        ParkDbDAO dao = new ParkDbDAO();
        try {
            parks = dao.findAll();
            cities = daoCity.findAll();
            for (Park park: parks) {
                park.setCity(daoCity.FindById(park.getCityID(), cities));
            }
            request.setAttribute("parks", parks);
        } catch (Exception e) {
// TODO Auto-generated catch block
            e.printStackTrace();
        }
        userPath = request.getServletPath();
        if("/park".equals(userPath)){
            request.getRequestDispatcher("/park.jsp").forward(request
                    , response);
        }
    }


    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {
// TODO Auto-generated method stub
        doGet(request, response);
    }
}