package dream.servlet;

import dream.model.Candidate;
import dream.store.DbStore;
import org.junit.Assert;
import org.junit.Test;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class CandidateServletTest {
    @Test
    public void whenCreateCandidate() throws IOException, ServletException {
        HttpServletRequest req = mock(HttpServletRequest.class);
        HttpServletResponse resp = mock(HttpServletResponse.class);
        when(req.getParameter("id")).thenReturn("0");
        when(req.getParameter("name")).thenReturn("name of new Candidate");
        new CandidateServlet().doPost(req, resp);
        Candidate candidate = DbStore.instOf().findCandidateByName("name of new Candidate");
        Assert.assertNotNull(candidate);
    }
}