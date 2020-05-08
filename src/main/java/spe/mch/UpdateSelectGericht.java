package spe.mch;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Alex
 */
@WebServlet(name="UpdateSelectGericht", urlPatterns={"/UpdateSelectGericht"})
public class UpdateSelectGericht extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        int nummer = Integer.parseInt(request.getParameter("nummer"));
        String sql = "select * from gerichte where nummer = ?";
        
        ConnectionPool dbPool = (ConnectionPool)getServletContext().getAttribute("dbPool");
        Connection conn = dbPool.getConnection();
        
        Gericht gericht = null;
        try{
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, nummer);
            ResultSet rs = pstm.executeQuery();
            rs.next();
            
            String name = rs.getString("name");
            Double preis = Double.ValueOf(rs.getString("preis"));
            String beschreibung = rs.getString("beschreibung");
            String kategorie = rs.getString("kategorie");
            
            gericht = new Gericht(nummer, name, preis, beschreibung, kategorie);

            dbPool.releaseConnection(conn);
            
        }
        catch(SQLException e){}
        
        request.setAttribute("gericht", gericht);
        RequestDispatcher view = request.getRequestDispatcher("f_gerichtbearbeiten.jsp");
        view.forward(request,response);
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
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
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
