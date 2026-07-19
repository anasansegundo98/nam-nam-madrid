package controlador.test;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.ZonasMadrid;

import java.io.IOException;

import dao.ZonasMadridDAO;

/**
 * Servlet implementation class TestZonas
 */
@WebServlet("/TestZonas")
public class TestZonas extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestZonas() {
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

			ZonasMadridDAO dao = new ZonasMadridDAO();

			if ("insertar".equals(accion)) {

				ZonasMadrid zona = new ZonasMadrid();

				zona.setIdzonas_madrid(1);
				zona.setNombre("San Blas-Canillejas");

				dao.insertar(zona);

				response.getWriter().println("Zona insertada correctamente");

			} else if ("consultar".equals(accion)) {

				ZonasMadrid zona = dao.consultar(1);

				if (zona != null) {

					response.getWriter().println("ID: " + zona.getIdzonas_madrid());
					response.getWriter().println("Nombre: " + zona.getNombre());

				} else {

					response.getWriter().println("No existe la zona.");

				}

			} else if ("modificar".equals(accion)) {

				ZonasMadrid zona = new ZonasMadrid();

				zona.setIdzonas_madrid(4);
				zona.setNombre("Usera");

				dao.modificar(zona);

				response.getWriter().println("Zona modificada correctamente");

			} else if ("eliminar".equals(accion)) {

				dao.eliminar(4);


				response.getWriter().println("Zona eliminada correctamente");

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
