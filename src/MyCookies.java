import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Date;
import java.net.URLDecoder;
import java.net.URLEncoder;


@WebServlet(name="MyCookies", urlPatterns = "/MyCookies")
public class MyCookies extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("dopost");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] allCookies=request.getCookies();
        String currentDate=(new Date()).toString();
        String DATE_COOKIE_KEY = "date_cookie_key";
        String lastDate = null;



        HttpSession session = request.getSession();
        Integer count = (Integer)session.getAttribute("count");
        String iD = session.getId();
        long createDateSession = session.getLastAccessedTime();
        long currentDateSession = session.getCreationTime();

        if (count == null) count = new Integer(1);
        else count = new Integer(count.intValue() + 1);
        session.setAttribute("count", count);
        System.out.println("Vous avez visité cette page " + count + " fois.");

        for (int i = 0; i < allCookies.length; i++) {
            Cookie cookie = allCookies[i];
            if(cookie.getName().equals(DATE_COOKIE_KEY)){

                lastDate= URLDecoder.decode(cookie.getValue(), "UTF-8");

                break;
            }
        }
        System.out.println("<BR>Nb cookies = "+allCookies.length);
        request.setAttribute( "lastDate", lastDate );
        request.setAttribute( "iD", iD );
        request.setAttribute( "createDateSession", createDateSession );
        request.setAttribute( "currentDateSession", currentDateSession );
        Cookie myCookie = new Cookie(DATE_COOKIE_KEY, URLEncoder.encode(currentDate.toString(), "UTF-8"));
        response.addCookie(myCookie);
        this.getServletContext().getRequestDispatcher("/lecture_cookie.jsp").forward(request, response);

    }
}
