package controlador;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Restaurante;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import dao.RestauranteDAO;

/**
 * Servlet implementation class AltaRestaurante
 */
@WebServlet("/AltaRestaurante")
public class AltaRestaurante extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AltaRestaurante() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
	    int idrestaurante = Integer.parseInt(request.getParameter("idrestaurante"));
	    String nombre = request.getParameter("nombre");
	    int zona_id = Integer.parseInt(request.getParameter("zona_id"));
	    String direccion = request.getParameter("direccion");
	    String categoria_id = request.getParameter("categoria_id");
	    int precio_medio = Integer.parseInt(request.getParameter("precio_medio"));
	    String url_google_maps = request.getParameter("url_google_maps");
	    String descripcion = request.getParameter("descripcion");
	    int destacado = Integer.parseInt(request.getParameter("destacado"));
	    int creado_por = Integer.parseInt(request.getParameter("creado_por"));
	    String accion = request.getParameter("accion");

	    
	    
	    PrintWriter out = response.getWriter();
	
	    
	    try {
	        switch (accion) {
	            case "insertar":
	            	Restaurante r1 = new Restaurante(idrestaurante, nombre, zona_id, direccion, categoria_id, precio_medio, url_google_maps, descripcion, destacado, creado_por);
	            	RestauranteDAO.getInstance().insertar(r1);
	                out.println("Alta realizada correctamente");
	                break;
	            case "modificar":
	            	Restaurante r2 = new Restaurante(idrestaurante, nombre, zona_id, direccion, categoria_id, precio_medio, url_google_maps, descripcion, destacado, creado_por);
	            	RestauranteDAO.getInstance().modificar(r2);
	                out.println("Modificación realizada correctamente");
	                break;
	            case "eliminar":
	            	RestauranteDAO.getInstance().eliminar(idrestaurante);
	                out.println("Baja realizada correctamente");
	                break;
	            case "consultar":
	            	Restaurante r3 = RestauranteDAO.getInstance().consultar(idrestaurante);
	                if (r3 != null) {
	                    out.println(r3.informacion());
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
