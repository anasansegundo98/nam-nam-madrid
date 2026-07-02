package controlador;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Usuario;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import dao.UsuarioDAO;

/**
 * Servlet implementation class AltaUsuario
 */
@WebServlet("/AltaUsuario")
public class AltaUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AltaUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @throws IOException 
	 * @throws ServletException 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		doGet(request, response);
	
	    	int idusuario = Integer.parseInt(request.getParameter("idusuario"));
		    String nombre_usuario = request.getParameter("nombre_usuario");
		    String email = request.getParameter("email");
		    String contrasena = request.getParameter("contrasena");
		    String rol = request.getParameter("rol");
		    String accion = request.getParameter("accion");

		    
		    
		    PrintWriter out = response.getWriter();
		
		    
		    try {
		        switch (accion) {
		            case "insertar":
		                Usuario u1 = new Usuario(idusuario, nombre_usuario, email, contrasena, rol);
		                UsuarioDAO.getInstance().insertar(u1);
		                out.println("Alta realizada correctamente");
		                break;
		            case "modificar":
		            	Usuario u2 = new Usuario(idusuario, nombre_usuario, email, contrasena, rol);
		            	UsuarioDAO.getInstance().modificar(u2);
		                out.println("Modificación realizada correctamente");
		                break;
		            case "eliminar":
		            	UsuarioDAO.getInstance().eliminar(idusuario);
		                out.println("Baja realizada correctamente");
		                break;
		            case "consultar":
		            	Usuario u3 = UsuarioDAO.getInstance().consultar(idusuario);
		                if (u3 != null) {
		                    out.println(u3.informacion());
		                } else {
		                    out.println("Persona no encontrada");
		                }
		                break;
		        }
		        
		    } catch (SQLException | ClassNotFoundException e) {
		        e.printStackTrace();
		        out.println("Error en la base de datos");
		    }
	
	
	
	}

	  
	
	
	
}
