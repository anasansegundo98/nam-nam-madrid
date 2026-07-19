package controlador.test;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Usuario;

import java.io.IOException;

import dao.UsuarioDAO;

/**
 * Servlet implementation class TestUsuario
 */
@WebServlet("/TestUsuario")
public class TestUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TestUsuario() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());

		/*
		 * INSERTAR USUARIO try {
		 * 
		 * UsuarioDAO dao = new UsuarioDAO();
		 * 
		 * Usuario usuario = new Usuario();
		 * 
		 * usuario.setIdusuario(1); usuario.setNombre_usuario("usuarioPrueba");
		 * usuario.setEmail("prueba@gmail.com"); usuario.setContrasena("1234");
		 * usuario.setRol("USER"); dao.insertar(usuario);
		 * 
		 * response.getWriter().println("Usuario insertado correctamente");
		 * 
		 * } catch (Exception e) { e.printStackTrace();
		 * response.getWriter().println("Error: " + e.getMessage()); } }
		 * 
		 */

		try {
			 
			  UsuarioDAO dao = new UsuarioDAO();
			  
			  Usuario usuario = new Usuario();
			  
			  usuario.setIdusuario(1); usuario.setNombre_usuario("usuarioPrueba");
			  usuario.setEmail("prueba@gmail.com"); usuario.setContrasena("1234");
			  usuario.setRol("USER"); dao.insertar(usuario);
			  
			  response.getWriter().println("Usuario insertado correctamente");
			  
			  } catch (Exception e) { e.printStackTrace();
			  response.getWriter().println("Error: " + e.getMessage()); } }
		
		/*
		 * CONSULTAR ATRIBUTOS DEL USUARIO
			  	try {
	
				UsuarioDAO dao = new UsuarioDAO();
	
				Usuario usuario = dao.consultar(1);
	
				if (usuario != null) {
					response.getWriter().println("ID: " + usuario.getIdusuario());
					response.getWriter().println("<br>Nombre: " + usuario.getNombre_usuario());
					response.getWriter().println("<br>Email: " + usuario.getEmail());
					response.getWriter().println("<br>Rol: " + usuario.getRol());
				} else {
					response.getWriter().println("No existe el usuario.");
				}
	
			} catch (Exception e) {
				e.printStackTrace();
				response.getWriter().println("Error: " + e.getMessage());
			}
		 */
		
		/* MODIFICAR USUARIO
		try {
			response.getWriter().println("Entrando en modificar...<br>");
		    UsuarioDAO dao = new UsuarioDAO();

		    Usuario usuario = new Usuario();

		    usuario.setIdusuario(1);
		    usuario.setNombre_usuario("Ana");
		    usuario.setEmail("ana@gmail.com");
		    usuario.setContrasena("5678");
		    usuario.setRol("ADMIN");

		    dao.modificar(usuario);
		    response.getWriter().println("Se ha ejecutado dao.modificar()<br>");

		    response.getWriter().println("Usuario modificado correctamente");

		} catch (Exception e) {
		    e.printStackTrace();
		    response.getWriter().println("Error: " + e.getMessage());
		}
		*/
		
		
		/* ELIMINAR USUARIO
		 * 
		 * 		try {

		    UsuarioDAO dao = new UsuarioDAO();

		    dao.eliminar(1); 

		    response.getWriter().println("Usuario eliminado correctamente");

		} catch (Exception e) {
		    e.printStackTrace();
		    response.getWriter().println("Error: " + e.getMessage());
		}
		
		*/
		
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
