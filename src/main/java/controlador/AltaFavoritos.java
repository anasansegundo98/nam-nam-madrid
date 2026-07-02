package controlador;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Favoritos;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import dao.FavoritosDAO;

/**
 * Servlet implementation class AltaFavoritos
 */
@WebServlet("/AltaFavoritos")
public class AltaFavoritos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AltaFavoritos() {
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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		int idfavoritos = Integer.parseInt(request.getParameter("idfavoritos"));
		int usuario_id = Integer.parseInt(request.getParameter("usuario_id"));
	    int restaurante_id = Integer.parseInt(request.getParameter("restaurante_id"));
	   
	    String accion = request.getParameter("accion");

	    
	    
	    PrintWriter out = response.getWriter();
	
	    
	    try {
	        switch (accion) {
	            case "insertar":
	            	Favoritos f1 = new Favoritos(idfavoritos,usuario_id,restaurante_id);
	            	FavoritosDAO.getInstance().insertar(f1);
	                out.println("Alta realizada correctamente");
	                break;
	            case "modificar":
	            	Favoritos f2 = new Favoritos(idfavoritos,usuario_id,restaurante_id);
	            	FavoritosDAO.getInstance().modificar(f2);
	                out.println("Modificación realizada correctamente");
	                break;
	            case "eliminar":
	            	FavoritosDAO.getInstance().eliminar(idfavoritos);
	                out.println("Baja realizada correctamente");
	                break;
	            case "consultar":
	            	Favoritos f3 = FavoritosDAO.getInstance().consultar(idfavoritos);
	                if (f3 != null) {
	                    out.println(f3.informacion());
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
