/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import entity.Depilation;
import entity.Manicure;
import entity.Messages;
import entity.Pedicure;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Properties;
import javax.ejb.EJB;
import javax.mail.Session;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sessions.DepilationFacade;
import sessions.ManicureFacade;
import sessions.MessagesFacade;
import sessions.PedicureFacade;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;



/**
 *
 * @author Alice
 */
@WebServlet(name = "MainServlet", urlPatterns = {
    "/home",
    "/price",
    "/sendMessage"
})
public class MainServlet extends HttpServlet {
    @EJB 
    private MessagesFacade messagesFacade;
    @EJB 
    private ManicureFacade manicureFacade;
    @EJB 
    private PedicureFacade pedicureFacade;
    @EJB 
    private DepilationFacade depilationFacade;
    

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String path = request.getServletPath();
        switch (path) {
            case "/sendMessage":
                String name = request.getParameter("customerName");
                String from = request.getParameter("customerEmail");
                String message = request.getParameter("message");
                if("".equals(name) || name == null
                        ||"".equals(from) || from == null
                        ||"".equals(message) || message == null){
                    request.setAttribute("name", name);
                    request.setAttribute("from", from);
                    request.setAttribute("message", message);
                    request.setAttribute("info", "?????????????????? ?????? ????????");
                    request.getRequestDispatcher("/home").forward(request, response);
                    break;
                }
                String to = "gusar.alice@gmail.com";
                // ??????????????????????, ?????? ???? ?????????????????????? ?????????????????????? ???????????? ?? localhost
                String host = "localhost";
                  // ???????????????? ???????????????? ??????????????
                Properties properties =   System.getProperties();
                  // ?????????????????? ???????????????? ????????????
                properties.setProperty("mail.smtp.host", host);
                  // ?????????????????? ?????????????? Session ???? ??????????????????
                Session session = Session.getDefaultInstance(properties);
                try {
                    // ???????????????? ?????????????? MimeMessage ???? ??????????????????
                    MimeMessage mineMessage = new MimeMessage(session);
                    // ????
                    mineMessage.setFrom(new InternetAddress(from));
                     // ????????
                    mineMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
                     // ???????? ????????????
                    mineMessage.setSubject("?? ?????? ?????????? ????????????!");
                     // ???????????? ???????????????????? ?????????????????????? ??????????????????
                    mineMessage.setText(message);
                     // ?????????????????? ??????????????????
                    Transport.send(mineMessage);
                    Messages messages = new Messages(name, from, message, new GregorianCalendar().getTime());
                    messagesFacade.create(messages);
                    request.setAttribute("info", "???????? ?????????????????? ?????????????? ????????????????????");
                    request.getRequestDispatcher("/WEB-INF/confirmation.jsp").forward(request, response);
                } catch (MessagingException mex) {
                    mex.printStackTrace();
                }
                break;
            case "/home": 
                request.setAttribute("info", "???? ???? ?????????????? ????????????????");
                request.getRequestDispatcher("/index.jsp").forward(request, response);
                break;
            case "/price": 
                List<Manicure> listManicure = manicureFacade.findAll();
                List<Pedicure> listPedicure = pedicureFacade.findAll();
                List<Depilation> listDepilation = depilationFacade.findAll();
                request.setAttribute("listManicure", listManicure);
                request.setAttribute("listPedicure", listPedicure);
                request.setAttribute("listDepilation", listDepilation);
                request.getRequestDispatcher("/WEB-INF/price.jsp").forward(request, response);
                break;
            default:
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
