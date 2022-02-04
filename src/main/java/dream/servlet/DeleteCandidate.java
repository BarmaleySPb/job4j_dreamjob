package dream.servlet;

import dream.store.DbStore;
import dream.utils.GetProperties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;


public class DeleteCandidate extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fileName = req.getParameter("id");
        DbStore.instOf().deleteCandidate(Integer.parseInt(fileName));
        File file = new File(
                GetProperties.config("store.properties").getProperty("photostore")
                        + File.separator + fileName
        );
        if (file.exists()) {
            file.delete();
        }
        resp.sendRedirect(req.getContextPath() + "/candidates.do");
    }
}
