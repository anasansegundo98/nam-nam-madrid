package controlador;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Valoraciones;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.time.LocalDate;

import dao.ValoracionesDAO;

/**
 * Servlet implementation class AltaValoraciones
 */
@WebServlet("/AltaValoraciones")
public class AltaValoraciones extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AltaValoraciones() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
			int idvaloraciones = Integer.parseInt(request.getParameter("idvaloraciones"));
			int restaurante_id = Integer.parseInt(request.getParameter("restaurante_id"));
			int usuario_id = Integer.parseInt(request.getParameter("usuario_id"));
			double rating = Double.parseDouble(request.getParameter("rating"));
			int visitado = Integer.parseInt(request.getParameter("visitado"));
			LocalDate fecha_visita = LocalDate.parse(request.getParameter("fecha_visita"));
			String notas_privadas = request.getParameter("notas_privadas");
	
			String accion = request.getParameter("accion");

		    
		    
		    PrintWriter out = response.getWriter();
		
		    
		    try {
		        switch (accion) {
		            case "insertar":
		            	Valoraciones v1 = new Valoraciones(idvaloraciones, restaurante_id, usuario_id, rating, visitado, fecha_visita, notas_privadas);
		            	ValoracionesDAO.getInstance().insertar(v1);
		                out.println("Alta realizada correctamente");
		                break;
		            case "modificar":
		            	Valoraciones v2 = new Valoraciones(idvaloraciones, restaurante_id, usuario_id, rating, visitado, fecha_visita, notas_privadas);
		            	ValoracionesDAO.getInstance().modificar(v2);
		                out.println("Modificación realizada correctamente");
		                break;
		            case "eliminar":
		            	ValoracionesDAO.getInstance().eliminar(idvaloraciones);
		                out.println("Baja realizada correctamente");
		                break;
		            case "consultar":
		            	Valoraciones v3 = ValoracionesDAO.getInstance().consultar(idvaloraciones);
		                if (v3 != null) {
		                    out.println(v3.informacion());
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
