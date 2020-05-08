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
@WebServlet(name="SelectSpeisekarte", urlPatterns={"/SelectSpeisekarte"})
public class SelectSpeisekarte extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

        ArrayList<Gericht> gerichteListe = new ArrayList<>();
        String sql = "select * order by kategorie";
        
        ConnectionPool dbPool = (ConnectionPool)getServletContext().getAttribute("dbPool");
        Connection conn = dbPool.getConnection();

        try{
            PreparedStatement pstm = conn.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            
            int nummer = 0;
            String name = null;
            double preis = null;
            String beschreibung = null;
            String kategorie = null;

            while(rs.next()){
                nummer = rs.getInt("nummer");
                name = rs.getString("name");
                preis = rs.getDouble("preis");
                beschreibung = rs.getString("beschreibung");
                kategorie = rs.getString("kategorie");

                gerichteListe.add(new Gericht(nummer,name,preis,beschreibung,allergene,kategorie));
            }
            
            dbPool.releaseConnection();
        }
        catch{
            request.setAttribute("gerichteListe", gerichteListe);
            RequestDispatcher view = request.getRequestDispatcher("gerichteAusgeben.jsp");
            view.forward(request, response);
        }
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
