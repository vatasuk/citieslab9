package lab9.citieslab9;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.io.IOException;

import lab9.citieslab9.DAO.CityDbDAO;
import lab9.citieslab9.DAO.ConnectionProperty;

@WebServlet(
        name = "delcity",
        urlPatterns = {"/deletecity"}
)
public class DeleteCityServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    ConnectionProperty prop;

    public DeleteCityServlet() throws FileNotFoundException,
            IOException {
        super();
        prop = new ConnectionProperty();
    }
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {
        CityDbDAO dao = new CityDbDAO();
        String strId = request.getParameter("id");
        int deleteid = 0;
        if(strId != null) {
            deleteid = Integer.parseInt(strId);
        }
        try {
            dao.delete(deleteid);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("/citieslab9_war/city");
    }

}
