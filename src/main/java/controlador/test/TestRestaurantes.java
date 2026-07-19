package controlador.test;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Restaurante;

import java.io.IOException;

import dao.RestauranteDAO;

/**
 * Servlet implementation class TestRestaurantes
 */
@WebServlet("/TestRestaurantes")
public class TestRestaurantes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestRestaurantes() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());

	
		String accion = request.getParameter("accion");

		try {

		    RestauranteDAO dao = new RestauranteDAO();

		    if ("insertar".equals(accion)) {

		        Restaurante r = new Restaurante();

		        r.setNombre("Caldero Mongol");
		        r.setZona_id(2);
		        r.setDireccion("Calle Mayor 10");
		        r.setCategoria_id(1);
		        r.setPrecio_medio(20);
		        r.setUrl_google_maps("https://maps.google.com");
		        r.setDescripcion("Hamburguesería");
		        r.setDestacado(1);
		        r.setCreado_por(1);

		        dao.insertar(r);

		        response.getWriter().println("Restaurante insertado correctamente.");

		    } else if ("consultar".equals(accion)) {

		        Restaurante r = dao.consultar(1);

		        if (r != null) {

		            response.getWriter().println("ID: " + r.getIdrestaurante());
		            response.getWriter().println("<br>Nombre: " + r.getNombre());
		            response.getWriter().println("<br>Zona: " + r.getZona_id());
		            response.getWriter().println("<br>Dirección: " + r.getDireccion());
		            response.getWriter().println("<br>Categoría: " + r.getCategoria_id());
		            response.getWriter().println("<br>Precio medio: " + r.getPrecio_medio());
		            response.getWriter().println("<br>Google Maps: " + r.getUrl_google_maps());
		            response.getWriter().println("<br>Descripción: " + r.getDescripcion());
		            response.getWriter().println("<br>Destacado: " + r.getDestacado());
		            response.getWriter().println("<br>Creado por: " + r.getCreado_por());

		        } else {

		            response.getWriter().println("No existe el restaurante.");

		        }

		    } else if ("modificar".equals(accion)) {

		        Restaurante r = new Restaurante();

		        r.setIdrestaurante(1);
		        r.setNombre("Goiko Grill");
		        r.setZona_id(1);
		        r.setDireccion("Gran Vía 25");
		        r.setCategoria_id(1);
		        r.setPrecio_medio(25);
		        r.setUrl_google_maps("https://maps.google.com");
		        r.setDescripcion("Hamburguesería Premium");
		        r.setDestacado(1);
		        r.setCreado_por(1);

		        dao.modificar(r);

		        response.getWriter().println("Restaurante modificado correctamente.");

		    } else if ("eliminar".equals(accion)) {

		        dao.eliminar(2);

		        response.getWriter().println("Restaurante eliminado correctamente.");

		    } else {

		        response.getWriter().println("Acción no válida.");
		    }

		} catch (Exception e) {

		    e.printStackTrace();
		    response.getWriter().println("Error: " + e.getMessage());

		}
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
