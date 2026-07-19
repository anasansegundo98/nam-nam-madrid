package controlador.test;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.FotosComida;

import java.io.IOException;

import dao.FotosComidaDAO;

/**
 * Servlet implementation class TestFotosComida
 */
@WebServlet("/TestFotosComida")
public class TestFotosComida extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestFotosComida() {
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

			FotosComidaDAO dao = new FotosComidaDAO();

			if ("insertar".equals(accion)) {

				FotosComida f = new FotosComida();

				f.setRestaurante_id(1);
				f.setUsuario_id(1);
				f.setUrl_imagen("https://imagenes.com/hamburguesa.jpg");
				f.setDescripcion("Hamburguesa completa");

				dao.insertar(f);

				response.getWriter().println("Foto insertada correctamente.");

			} else if ("consultar".equals(accion)) {

				FotosComida f = dao.consultar(1);

				if (f != null) {

					response.getWriter().println("ID: " + f.getIdfotos_comida());
					response.getWriter().println("<br>Restaurante: " + f.getRestaurante_id());
					response.getWriter().println("<br>Usuario: " + f.getUsuario_id());
					response.getWriter().println("<br>URL: " + f.getUrl_imagen());
					response.getWriter().println("<br>Descripción: " + f.getDescripcion());

				} else {

					response.getWriter().println("No existe la foto.");

				}

			} else if ("modificar".equals(accion)) {

				FotosComida f = new FotosComida();

				f.setIdfotos_comida(1);
				f.setRestaurante_id(1);
				f.setUsuario_id(1);
				f.setUrl_imagen("https://imagenes.com/pizza.jpg");
				f.setDescripcion("Pizza cuatro quesos");

				dao.modificar(f);

				response.getWriter().println("Foto modificada correctamente.");

			} else if ("eliminar".equals(accion)) {

				dao.eliminar(1);

				response.getWriter().println("Foto eliminada correctamente.");

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
