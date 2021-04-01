/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import entity.Depilation;
import entity.Manicure;
import entity.Pedicure;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sessions.DepilationFacade;
import sessions.ManicureFacade;
import sessions.PedicureFacade;

/**
 *
 * @author Alice
 */
@WebServlet(name = "MainServlet", urlPatterns = {
    "/home",
    "/price",
    "/admin",
    
    "/manicure",
    "/newManItem",
    "/createManItem",
    
    "/pedicure",
    "/newPedItem",
    "/createPedItem",
    
    "/depilation",
    "/newDepItem",
    "/createDepItem",
})
public class MainServlet extends HttpServlet {
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
            case "/home": 
                request.setAttribute("info", "Вы на главной странице");
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
            case "/admin": 
                request.getRequestDispatcher("/WEB-INF/adminPanel.jsp").forward(request, response);
                break;
            case "/manicure": 
                listManicure = manicureFacade.findAll();
                request.setAttribute("listManicure", listManicure);
                request.getRequestDispatcher("/WEB-INF/adminManPage.jsp").forward(request, response);
                break;
            case "/newManItem": 
                request.getRequestDispatcher("/WEB-INF/adminManForm.jsp").forward(request, response);
                break;
            case "/createManItem": 
                String name = request.getParameter("servManName");
                String price = request.getParameter("servManPrice");
                if("".equals(name) || name == null
                        ||"".equals(price) || price == null){
                    request.setAttribute("name", name);
                    request.setAttribute("price", price);
                    request.setAttribute("info", "Заполните все поля");
                    request.getRequestDispatcher("/WEB-INF/adminManForm.jsp").forward(request, response);
                    break;
                }
                Manicure manicure = new Manicure(name, price);
                manicureFacade.create(manicure);
                request.setAttribute("info", "Запись\"" + manicure.getName() + "\" сохранена");
                request.getRequestDispatcher("/manicure").forward(request, response);
                break;
            case "/pedicure": 
                listPedicure = pedicureFacade.findAll();
                request.setAttribute("listPedicure", listPedicure);
                request.getRequestDispatcher("/WEB-INF/adminPedPage.jsp").forward(request, response);
                break;
            case "/newPedItem": 
                request.getRequestDispatcher("/WEB-INF/adminPedForm.jsp").forward(request, response);
                break;
            case "/createPedItem": 
                name = request.getParameter("servPedName");
                price = request.getParameter("servPedPrice");
                if("".equals(name) || name == null
                        ||"".equals(price) || price == null){
                    request.setAttribute("name", name);
                    request.setAttribute("price", price);
                    request.setAttribute("info", "Заполните все поля");
                    request.getRequestDispatcher("/WEB-INF/adminPedForm.jsp").forward(request, response);
                    break;
                }
                Pedicure pedicure = new Pedicure(name, price);
                pedicureFacade.create(pedicure);
                request.setAttribute("info", "Запись\"" + pedicure.getName() + "\" сохранена");
                request.getRequestDispatcher("/pedicure").forward(request, response);
                break;
            case "/depilation": 
                listDepilation = depilationFacade.findAll();
                request.setAttribute("listDepilation", listDepilation);
                request.getRequestDispatcher("/WEB-INF/adminDepPage.jsp").forward(request, response);
                break;
            case "/newDepItem": 
                request.getRequestDispatcher("/WEB-INF/adminDepForm.jsp").forward(request, response);
                break;
            case "/createDepItem": 
                name = request.getParameter("servDepName");
                price = request.getParameter("servDepPrice");
                if("".equals(name) || name == null
                        ||"".equals(price) || price == null){
                    request.setAttribute("name", name);
                    request.setAttribute("price", price);
                    request.setAttribute("info", "Заполните все поля");
                    request.getRequestDispatcher("/WEB-INF/adminDepForm.jsp").forward(request, response);
                    break;
                }
                Depilation depilation = new Depilation(name, price);
                depilationFacade.create(depilation);
                request.setAttribute("info", "Запись\"" + depilation.getName() + "\" сохранена");
                request.getRequestDispatcher("/depilation").forward(request, response);
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
