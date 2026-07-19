package controlador.test;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.CategoriasCocina;

import java.io.IOException;

import dao.CategoriasCocinaDAO;

/**
 * Servlet implementation class TestCategoriae
 */
@WebServlet("/TestCategoriae")
public class TestCategorias extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TestCategorias() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// response.getWriter().append("Served at: ").append(request.getContextPath());

		/*
		 * INSERTAR
		 * 
		 * try {
		 * 
		 * CategoriasCocinaDAO dao = new CategoriasCocinaDAO();
		 * 
		 * CategoriasCocina categoria = new CategoriasCocina();
		 * 
		 * categoria.setIdcategorias_cocina(1); categoria.setNombre("Japo");
		 * dao.insertar(categoria);
		 * 
		 * response.getWriter().println("Categoría insertada correctamente");
		 * 
		 * } catch (Exception e) { e.printStackTrace();
		 * response.getWriter().println("Error: " + e.getMessage()); }
		 */

		try {
			  
			  CategoriasCocinaDAO dao = new CategoriasCocinaDAO();
			  
			  CategoriasCocina categoria = new CategoriasCocina();
			  
			  categoria.setIdcategorias_cocina(1); categoria.setNombre("Japo");
			  dao.insertar(categoria);
			  
			 response.getWriter().println("Categoría insertada correctamente");
			  
			  } catch (Exception e) { e.printStackTrace();
			 response.getWriter().println("Error: " + e.getMessage()); }
		/*
		 * MODIFICAR
		 * 
		 * try { response.getWriter().println("Entrando en modificar...<br>");
		 * CategoriasCocinaDAO dao = new CategoriasCocinaDAO();
		 * 
		 * CategoriasCocina categoria = new CategoriasCocina();
		 * 
		 * categoria.setIdcategorias_cocina(1); categoria.setNombre("Italiana");
		 * 
		 * dao.modificar(categoria);
		 * response.getWriter().println("Se ha ejecutado dao.modificar()<br>");
		 * 
		 * response.getWriter().println("Usuario modificado correctamente");
		 * 
		 * } catch (Exception e) { e.printStackTrace();
		 * response.getWriter().println("Error: " + e.getMessage()); }
		 */

		/*
		 * CONSULTAR try {
		 * 
		 * CategoriasCocinaDAO dao = new CategoriasCocinaDAO();
		 * 
		 * CategoriasCocina categoria = dao.consultar(1);
		 * 
		 * if (categoria != null) { response.getWriter().println("ID: " +
		 * categoria.getIdcategorias_cocina());
		 * response.getWriter().println("<br>Nombre: " + categoria.getNombre());
		 * 
		 * } else { response.getWriter().println("No existe la categoria."); }
		 * 
		 * } catch (Exception e) { e.printStackTrace();
		 * response.getWriter().println("Error: " + e.getMessage()); }
		 */

		/*
		 * ELIMINAR CATEGORÍA DE COCINA
		 * 
		 * 
		 * try {
		 * 
		 * CategoriasCocinaDAO dao = new CategoriasCocinaDAO();
		 * 
		 * dao.eliminar(1);
		 * 
		 * response.getWriter().println("Categoría eliminada correctamente");
		 * 
		 * } catch (Exception e) { e.printStackTrace();
		 * response.getWriter().println("Error: " + e.getMessage()); }
		 * 
		 * 
		 */
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
