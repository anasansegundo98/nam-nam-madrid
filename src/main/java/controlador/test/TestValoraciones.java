package controlador.test;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Valoraciones;

import java.io.IOException;
import java.time.LocalDate;

import dao.ValoracionesDAO;

/**
 * Servlet implementation class tes
 */
@WebServlet("/TestValoraciones")
public class TestValoraciones extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestValoraciones() {
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

			ValoracionesDAO dao = new ValoracionesDAO();

			if ("insertar".equals(accion)) {

				Valoraciones v = new Valoraciones();

				v.setRestaurante_id(1);
				v.setUsuario_id(1);
				v.setRating(4.5);
				v.setVisitado(1);
				v.setFecha_visita(LocalDate.now());
				v.setNotas_privadas("Muy recomendable");

				dao.insertar(v);

				response.getWriter().println("Valoración insertada correctamente.");

			} else if ("consultar".equals(accion)) {

				Valoraciones v = dao.consultar(1);

				if (v != null) {

					response.getWriter().println("ID: " + v.getIdvaloraciones());
					response.getWriter().println("<br>Restaurante: " + v.getRestaurante_id());
					response.getWriter().println("<br>Usuario: " + v.getUsuario_id());
					response.getWriter().println("<br>Rating: " + v.getRating());
					response.getWriter().println("<br>Visitado: " + v.getVisitado());
					response.getWriter().println("<br>Fecha visita: " + v.getFecha_visita());
					response.getWriter().println("<br>Notas: " + v.getNotas_privadas());

				} else {

					response.getWriter().println("No existe la valoración.");

				}

			} else if ("modificar".equals(accion)) {

				Valoraciones v = new Valoraciones();

				v.setIdvaloraciones(1);
				v.setRestaurante_id(1);
				v.setUsuario_id(1);
				v.setRating(5.0);
				v.setVisitado(1);
				v.setFecha_visita(LocalDate.now());
				v.setNotas_privadas("Excelente restaurante");

				dao.modificar(v);

				response.getWriter().println("Valoración modificada correctamente.");

			} else if ("eliminar".equals(accion)) {

				dao.eliminar(1);

				response.getWriter().println("Valoración eliminada correctamente.");

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
