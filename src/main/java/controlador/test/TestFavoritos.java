package controlador.test;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Favoritos;

import java.io.IOException;

import dao.FavoritosDAO;

/**
 * Servlet implementation class TestFavoritos
 */
@WebServlet("/TestFavoritos")
public class TestFavoritos extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TestFavoritos() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());

		String accion = request.getParameter("accion");

		try {

			FavoritosDAO dao = new FavoritosDAO();

			if ("insertar".equals(accion)) {

				Favoritos f = new Favoritos();
				
				f.setIdfavoritos(1);
				f.setUsuario_id(1);
				f.setRestaurante_id(1);

				dao.insertar(f);

				response.getWriter().println("Favorito insertado correctamente.");

			} else if ("consultar".equals(accion)) {

				Favoritos f = dao.consultar(1);

				if (f != null) {

					response.getWriter().println("ID: " + f.getIdfavoritos());
					response.getWriter().println("<br>Usuario: " + f.getUsuario_id());
					response.getWriter().println("<br>Restaurante: " + f.getRestaurante_id());

				} else {

					response.getWriter().println("No existe el favorito.");

				}

			} else if ("modificar".equals(accion)) {

				Favoritos f = new Favoritos();

				f.setIdfavoritos(5);
				f.setUsuario_id(1);
				f.setRestaurante_id(2);

				dao.modificar(f);

				response.getWriter().println("Favorito modificado correctamente.");

			} else if ("eliminar".equals(accion)) {

				dao.eliminar(5);

				response.getWriter().println("Favorito eliminado correctamente.");

			} else {

				response.getWriter().println("Acción no válida.");

			}

		} catch (Exception e) {

			e.printStackTrace();

			response.getWriter().println("Error: " + e.getMessage());

		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
