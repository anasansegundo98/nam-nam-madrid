package controlador;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.FotosComida;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import dao.FotosComidaDAO;

/**
 * Servlet implementation class AltaFotosComida
 */
@WebServlet("/AltaFotosComida")
public class AltaFotosComida extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AltaFotosComida() {
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
		doGet(request, response);

		int idfotos_comida = Integer.parseInt(request.getParameter("idfotos_comida"));
		int restaurante_id = Integer.parseInt(request.getParameter("restaurante_id"));
		int usuario_id = Integer.parseInt(request.getParameter("usuario_id"));
		String url_imagen = request.getParameter("url_imagen");
		String descripcion = request.getParameter("descripcion");
		String accion = request.getParameter("accion");

		PrintWriter out = response.getWriter();

		try {
			switch (accion) {

			case "insertar":
				FotosComida f1 = new FotosComida(idfotos_comida, restaurante_id, usuario_id, url_imagen, descripcion);
				FotosComidaDAO.getInstance().insertar(f1);
				out.println("Alta realizada correctamente");
				break;

			case "modificar":
				FotosComida f2 = new FotosComida(idfotos_comida, restaurante_id, usuario_id, url_imagen, descripcion);
				FotosComidaDAO.getInstance().modificar(f2);
				out.println("Modificación realizada correctamente");
				break;

			case "eliminar":
				FotosComidaDAO.getInstance().eliminar(idfotos_comida);
				out.println("Baja realizada correctamente");
				break;

			case "consultar":
				FotosComida f3 = FotosComidaDAO.getInstance().consultar(idfotos_comida);
				if (f3 != null) {
					out.println(f3.toString());
				} else {
					out.println("Foto no encontrada");
				}
				break;
			}

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			out.println("Error en la base de datos");
		}
	}
}
