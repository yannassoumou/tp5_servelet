package servlet;

import jpa.JpaTest;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name="kanbaninfo",
        urlPatterns={"/TableauKanbanInfo"})
public class TableauKanbanInfo extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        /*super.doGet(req, resp);*/
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        //tableau des kanbans


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();


        out.println("<HTML>\n<BODY>\n" +
                "<H1>Recapitulatif des informations</H1>\n" +
                "<UL>\n" +
                " <LI>Nom: "
                + request.getParameter("kanban") + "\n" +
                "</UL>\n" +
                "</BODY></HTML>");
        //Traitement pour enregistrer la base de donnee

        response.sendRedirect("/TableauKanbanInfo");
    }
}
