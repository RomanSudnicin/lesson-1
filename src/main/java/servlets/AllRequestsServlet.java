package servlets;

import templater.PageGenerator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by roman on 06.08.16.
 */
public class AllRequestsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, Object> pageVariables = createPageVariables(req);
        pageVariables.put("message" , "");
        resp.getWriter().println(PageGenerator.instance().getPage("page.html",pageVariables));
        resp.setStatus(HttpServletResponse.SC_OK);
    }

    private Map<String,Object> createPageVariables(HttpServletRequest req) {
        Map<String, Object> pageVariables = new HashMap();
        pageVariables.put("method", req.getMethod());
        pageVariables.put("URL", req.getRequestURL().toString());
        pageVariables.put("pathInfo", req.getPathInfo());
        pageVariables.put("sessionId", req.getSession().getId());
        pageVariables.put("parameters", req.getParameterMap().toString());
        return pageVariables;
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println("Response");
        resp.setStatus(HttpServletResponse.SC_OK);
    }
}
