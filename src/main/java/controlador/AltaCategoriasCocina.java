package controlador;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.CategoriasCocina;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import dao.CategoriasCocinaDAO;

/**
 * Servlet implementation class AltaCategoriasCocina
 */
@WebServlet("/AltaCategoriasCocina")
public class AltaCategoriasCocina extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AltaCategoriasCocina() {
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
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);

		int idcategorias_cocina = Integer.parseInt(request.getParameter("idcategorias_cocina"));
		String nombre = request.getParameter("nombre");
		String accion = request.getParameter("accion");

		PrintWriter out = response.getWriter();

		try {
			switch (accion) {
			case "insertar":
				CategoriasCocina c1 = new CategoriasCocina(idcategorias_cocina, nombre);
				CategoriasCocinaDAO.getInstance().insertar(c1);
				out.println("Alta realizada correctamente");
				break;
			case "modificar":
				CategoriasCocina c2 = new CategoriasCocina(idcategorias_cocina, nombre);
				CategoriasCocinaDAO.getInstance().modificar(c2);
				out.println("Modificación realizada correctamente");
				break;
			case "eliminar":
				CategoriasCocinaDAO.getInstance().eliminar(idcategorias_cocina);
				out.println("Baja realizada correctamente");
				break;
			case "consultar":
				CategoriasCocina c3 = CategoriasCocinaDAO.getInstance().consultar(idcategorias_cocina);
				if (c3 != null) {
					out.println(c3.informacion());
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
