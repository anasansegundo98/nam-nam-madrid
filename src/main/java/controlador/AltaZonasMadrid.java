package controlador;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import modelo.ZonasMadrid;
import dao.ZonasMadridDAO;

/**
 * Servlet implementation class AltaZonasMadrid
 */
@WebServlet("/AltaZonasMadrid")
public class AltaZonasMadrid extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AltaZonasMadrid() {
		super();
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);

		int idzona = Integer.parseInt(request.getParameter("idzona"));
		String nombre = request.getParameter("nombre");

		String accion = request.getParameter("accion");


		PrintWriter out = response.getWriter();


		try {

			switch (accion) {

			case "insertar":

				ZonasMadrid z1 = new ZonasMadrid(idzona, nombre);

				ZonasMadridDAO.getInstance().insertar(z1);

				out.println("Alta realizada correctamente");

				break;


			case "modificar":

				ZonasMadrid z2 = new ZonasMadrid(idzona, nombre);

				ZonasMadridDAO.getInstance().modificar(z2);

				out.println("Modificación realizada correctamente");

				break;


			case "eliminar":

				ZonasMadridDAO.getInstance().eliminar(idzona);

				out.println("Baja realizada correctamente");

				break;


			case "consultar":

				ZonasMadrid z3 = ZonasMadridDAO.getInstance().consultar(idzona);

				if (z3 != null) {
					out.println(z3.informacion());
				} else {
					out.println("Zona no encontrada");
				}

				break;
			}


		} catch (SQLException | ClassNotFoundException e) {

			e.printStackTrace();

			out.println("Error en la base de datos");
		}

	}

}