package chem.ristorante.servlets;

import chem.ristorante.logic.EmpleadoLogic;
import chem.ristorante.objects.EmpleadoObj;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "EmpleadoServlet", urlPatterns = {"/EmpleadoServlet"})
public class EmpleadoServlet extends HttpServlet 
{

    protected void processRequest(HttpServletRequest request, 
            HttpServletResponse response)
            throws ServletException, IOException 
    {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) 
        {
            /* your code */
            String strFormId = request.getParameter("formid");
            
            if(strFormId.equals("1"))
            {
                //get parameters
                String strName = request.getParameter("nombre");
                String strApellido = request.getParameter("apellido");
                String strFechaNac = request.getParameter("fechaNac");
                String strSexo = request.getParameter("sexo");
                String strEmail = request.getParameter("email");
                String strDUI = request.getParameter("dui");
                String strUsuario = request.getParameter("usuario");
                String strContrasenia = request.getParameter("contrasenia");
                
                
                //access logic
                EmpleadoLogic CLogic = new EmpleadoLogic();
                int iRows = CLogic.insertEmpleadoRows(strName, strApellido, strFechaNac, strSexo, strEmail, strDUI, strUsuario, strContrasenia);
                System.out.println("insert Empleados rows: " + iRows);
                
                //send to frontend
                request.getSession().setAttribute("rows", new Integer(iRows) );
                response.sendRedirect("genericMessage.jsp");
            }
            
            if(strFormId.equals("2"))
            {
                //access logic
                EmpleadoLogic CLogic = new EmpleadoLogic();
                ArrayList<EmpleadoObj> CArray = CLogic.getAllEmpleados();
                
                //envair un correo
                
                //send to frontend
                request.getSession().setAttribute("empleados", CArray);
                response.sendRedirect("empleadoForm.jsp");
            }
            
            if(strFormId.equals("3"))
            {
                //get parameters
                String strId = request.getParameter("id");
                int iId = Integer.parseInt(strId);
                
                //access logic
                EmpleadoLogic CLogic = new EmpleadoLogic();
                int iRows = CLogic.deleteEmpleadoRows(iId);
                
                //send to frontend
                request.getSession().setAttribute("rows", iRows);
                response.sendRedirect("genericMessage.jsp");
            }
            
            if(strFormId.equals("4"))
            {
                //get parameters
                String strId = request.getParameter("id");
                int iId = Integer.parseInt(strId);
                
                //access logic
                EmpleadoLogic CLogic = new EmpleadoLogic();
                EmpleadoObj CEmpleado = CLogic.getEmpleadoById(iId);
                
                //send to frontend
                request.getSession().setAttribute("empleado", CEmpleado);
                response.sendRedirect("empleadoUpdateForm.jsp");
            }   
            
            if(strFormId.equals("5"))
            {
                //get parameters
                String strId = request.getParameter("id");
                String strName = request.getParameter("nombre");
                String strApellido = request.getParameter("apellido");
                String strFechaNac = request.getParameter("fechaNac");
                String strSexo = request.getParameter("sexo");
                String strEmail = request.getParameter("email");
                String strDUI = request.getParameter("dui");
                String strUsuario = request.getParameter("usuario");
                String strContrasenia = request.getParameter("contrasenia");
                int iId = Integer.parseInt(strId);
                
                //access logic
                EmpleadoLogic CLogic = new EmpleadoLogic();
                int iRows = CLogic.updateEmpleadoRows(iId,strName, strApellido, strFechaNac, strSexo, strEmail, strDUI, strUsuario, strContrasenia);
                System.out.println("update Empleados rows: " + iRows);
                
                //send to frontend
                request.getSession().setAttribute("rows", new Integer(iRows) );
                response.sendRedirect("genericMessage.jsp");
                
            }
            if(strFormId.equals("6"))
            {
                //get parameters
                
                String strUsuario = request.getParameter("uname");
                String strContrasenia = request.getParameter("psw");
                
                
                //access logic
                EmpleadoLogic CLogic = new EmpleadoLogic();
                String Pass = CLogic.VPass(strUsuario);
                
                //send to frontend
                
                if(Pass.equals(strContrasenia))
                {
                    response.sendRedirect("index.html");
                }
                else{
                    response.sendRedirect("Login.html");
                }
                
            }
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
