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
        name = "edircity",
        urlPatterns = {"/editcity"}
)
public class EditCityServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    ConnectionProperty prop;

    public EditCityServlet()
            throws FileNotFoundException, IOException {
        super();
        prop = new ConnectionProperty();
    }
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        String userPath;
        List<City> cities;
        City editcity = null;
        CityDbDAO dao = new CityDbDAO();
        try {
            cities = dao.findAll();
            request.setAttribute("cities", cities);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String strId = request.getParameter("id");
        int id = 0; // id редактируемой должности
        if(strId != null) {
            id = Integer.parseInt(strId);
        }
        try {
            editcity = dao.findById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.setAttribute("cityEdit", editcity);
        userPath = request.getServletPath();
        if ("/editcity".equals(userPath)) {
            request.getRequestDispatcher("/editcity.jsp")
                    .forward(request, response);
        }
    }
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        CityDbDAO dao = new CityDbDAO();
        String strId = request.getParameter("id");
        int id =0;
        if(strId != null) {
            id = Integer.parseInt(strId);
        }
        String name = request.getParameter("inputName");
        int pop = Integer.parseInt(request.getParameter("inputPop"));
        City editrole = new City(id, name,pop);
        try {
            dao.update(editrole);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("/citieslab9_war/city");
    }
}
