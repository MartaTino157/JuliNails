/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import entity.Depilation;
import entity.Manicure;
import entity.Pedicure;
import entity.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import sessions.DepilationFacade;
import sessions.ManicureFacade;
import sessions.PedicureFacade;

/**
 *
 * @author Alice
 */
@WebServlet(name = "AdminServlet", urlPatterns = {
    "/manicure",
    "/newManItem",
    "/createManItem",
    "/editManicureItemForm",
    "/editManicureItem",
    "/deleteManItem",
    
    "/pedicure",
    "/newPedItem",
    "/createPedItem",
    "/editPedicureItemForm",
    "/editPedicureItem",
    "/deletePedItem",
    
    "/depilation",
    "/newDepItem",
    "/createDepItem",
    "/editDepilationItemForm",
    "/editDepilationItem",
    "/deleteDepItem"
})
public class AdminServlet extends HttpServlet {
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
        HttpSession httpSession = request.getSession(false);
        if(httpSession == null){
            request.setAttribute("info", "Чтобы продолжить, пожалуйста, войдите!");
            request.getRequestDispatcher("/loginForm").forward(request, response);
            return;
        }
        User authUser = (User) httpSession.getAttribute("user");
        if(authUser == null){
            request.setAttribute("info", "Чтобы продолжить, пожалуйста, войдите!");
            request.getRequestDispatcher("/loginForm").forward(request, response);
            return;
        }
        if(!"admin".equals(authUser.getLogin())){
            request.setAttribute("info", "У вас нет прав для доступа!");
            request.getRequestDispatcher("/loginForm").forward(request, response);
            return;
        }
        switch (path) {
            case "/manicure": 
                List<Manicure> listManicure = manicureFacade.findAll();
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
            case "/editManicureItemForm":
                String manicureId = request.getParameter("manServiceId");
                manicure = manicureFacade.find(Long.parseLong(manicureId));
                request.setAttribute("manicure", manicure);
                request.getRequestDispatcher("/WEB-INF/editManItemForm.jsp").forward(request, response);
                break;
            case "/editManicureItem":
                manicureId = request.getParameter("manServiceId");
                name = request.getParameter("servManName");
                price = request.getParameter("servManPrice");
                if("".equals(name) || name == null
                        ||"".equals(price) || price == null){
                    request.setAttribute("name", name);
                    request.setAttribute("price", price);
                    request.setAttribute("info", "Поля не должны быть пустыми");
                    request.getRequestDispatcher("/editManicureItemForm").forward(request, response);
                    break;
                }
                manicure = manicureFacade.find(Long.parseLong(manicureId));
                manicure.setName(name);
                manicure.setPrice(price);
                manicureFacade.edit(manicure);
                request.setAttribute("manicureId", manicureId);
                request.setAttribute("info", "Запись\"" + manicure.getName() + "\" изменена");
                request.getRequestDispatcher("/manicure").forward(request, response);
                break;
            case "/deleteManItem":
                manicureId = request.getParameter("manServiceId");
                manicure = manicureFacade.find(Long.parseLong(manicureId));
                manicureFacade.remove(manicure);
                request.setAttribute("manicureId", manicureId);
                request.setAttribute("info", "Запись\"" + manicure.getName() + "\" удалена");
                request.getRequestDispatcher("/manicure").forward(request, response);
                break;
            case "/pedicure": 
                List<Pedicure> listPedicure = pedicureFacade.findAll();
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
            case "/editPedicureItemForm":
                String pedicureId = request.getParameter("pedServiceId");
                pedicure = pedicureFacade.find(Long.parseLong(pedicureId));
                request.setAttribute("pedicure", pedicure);
                request.getRequestDispatcher("/WEB-INF/editPedItemForm.jsp").forward(request, response);
                break;
            case "/editPedicureItem":
                pedicureId = request.getParameter("pedServiceId");
                name = request.getParameter("servPedName");
                price = request.getParameter("servPedPrice");
                if("".equals(name) || name == null
                        ||"".equals(price) || price == null){
                    request.setAttribute("name", name);
                    request.setAttribute("price", price);
                    request.setAttribute("info", "Поля не должны быть пустыми");
                    request.getRequestDispatcher("/editPedicureItemForm").forward(request, response);
                    break;
                }
                pedicure = pedicureFacade.find(Long.parseLong(pedicureId));
                pedicure.setName(name);
                pedicure.setPrice(price);
                pedicureFacade.edit(pedicure);
                request.setAttribute("pedicureId", pedicureId);
                request.setAttribute("info", "Запись\"" + pedicure.getName() + "\" изменена");
                request.getRequestDispatcher("/pedicure").forward(request, response);
                break;
            case "/deletePedItem":
                pedicureId = request.getParameter("pedServiceId");
                pedicure = pedicureFacade.find(Long.parseLong(pedicureId));
                pedicureFacade.remove(pedicure);
                request.setAttribute("pedicureId", pedicureId);
                request.setAttribute("info", "Запись\"" + pedicure.getName() + "\" удалена");
                request.getRequestDispatcher("/pedicure").forward(request, response);
                break;
            case "/depilation": 
                List<Depilation> listDepilation = depilationFacade.findAll();
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
            case "/editDepilationItemForm":
                String depilationId = request.getParameter("depServiceId");
                depilation = depilationFacade.find(Long.parseLong(depilationId));
                request.setAttribute("depilation", depilation);
                request.getRequestDispatcher("/WEB-INF/editDepItemForm.jsp").forward(request, response);
                break;
            case "/editDepilationItem":
                depilationId = request.getParameter("depServiceId");
                name = request.getParameter("servDepName");
                price = request.getParameter("servDepPrice");
                if("".equals(name) || name == null
                        ||"".equals(price) || price == null){
                    request.setAttribute("name", name);
                    request.setAttribute("price", price);
                    request.setAttribute("info", "Поля не должны быть пустыми");
                    request.getRequestDispatcher("/editDepilationItemForm").forward(request, response);
                    break;
                }
                depilation = depilationFacade.find(Long.parseLong(depilationId));
                depilation.setName(name);
                depilation.setPrice(price);
                depilationFacade.edit(depilation);
                request.setAttribute("depilationId", depilationId);
                request.setAttribute("info", "Запись\"" + depilation.getName() + "\" изменена");
                request.getRequestDispatcher("/depilation").forward(request, response);
                break;
            case "/deleteDepItem":
                depilationId = request.getParameter("depServiceId");
                depilation = depilationFacade.find(Long.parseLong(depilationId));
                depilationFacade.remove(depilation);
                request.setAttribute("depilationId", depilationId);
                request.setAttribute("info", "Запись\"" + depilation.getName() + "\" удалена");
                request.getRequestDispatcher("/depilation").forward(request, response);
                break;
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
