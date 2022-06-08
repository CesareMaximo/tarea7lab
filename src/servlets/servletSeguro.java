package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dominio.seguro;
import Dominio.seguroDAO;
import Dominio.tipoSeguro;
import Dominio.tipoSeguroDAO;



@WebServlet("/servletSeguro")
public class servletSeguro extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public servletSeguro() {
        super();
    
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		tipoSeguroDAO tsdao = new tipoSeguroDAO();
		ArrayList<tipoSeguro> lista = (ArrayList<tipoSeguro>) tsdao.obtenerTipoSeguro();
		
		seguroDAO sdao = new seguroDAO();
		
		ArrayList<seguro> listaSeguro= (ArrayList<seguro>)sdao.obtenerTodosLosSeguros();
		
		request.setAttribute("listaSeg", listaSeguro);
		RequestDispatcher rd;

		if (request.getParameter("Param") != null) {

			request.setAttribute("listaTS", lista);


			int ultID = sdao.obtenerID() + 1;
			request.setAttribute("proxID", ultID);

			rd = request.getRequestDispatcher("/agregarSeguro.jsp");
			rd.forward(request, response);

		}
		
		if (request.getParameter("listar") != null) {
			request.setAttribute("listaTS", lista);


			rd = request.getRequestDispatcher("/ListarSeguros.jsp");
			rd.forward(request, response);
		}
	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		tipoSeguroDAO tsdao = new tipoSeguroDAO();
		ArrayList<tipoSeguro> lista = (ArrayList<tipoSeguro>) tsdao.obtenerTipoSeguro();
		request.setAttribute("listaTS", lista);
		seguroDAO sdao = new seguroDAO();

		RequestDispatcher rd;
		if (request.getParameter("btnAceptar") != null) {
			
			seguro seg = new seguro();
			seg.setDescripcion(request.getParameter("txtDescripcion"));
			tipoSeguro tipo = new tipoSeguro();
			tipo.setIdTipo(Integer.parseInt(request.getParameter("tipoSeguro").toString()));
			seg.setIdTipo(tipo);
			seg.setCostoContratacion(Float.parseFloat(request.getParameter("txtCContratacion")));
			seg.setCostoAsegurado(Float.parseFloat(request.getParameter("txtMaximoAseg")));


			boolean insert = sdao.agregarSeguro(seg);
			request.setAttribute("insert", insert);

			int ultID = sdao.obtenerID() + 1;
			request.setAttribute("proxID", ultID);

			rd = request.getRequestDispatcher("/agregarSeguro.jsp");
			rd.forward(request, response);
		}
		
		if(request.getParameter("btnFiltrar")!=null)
		{
			request.setAttribute("listar", 1);
			int id = Integer.parseInt(request.getParameter("tipo").toString());
			ArrayList<seguro> listaS= (ArrayList<seguro>)sdao.obtenerTodosLosSegurosPorId(id);
			
			request.setAttribute("listaSeg", listaS);
			request.setAttribute("listaTS", lista);
			rd = request.getRequestDispatcher("/ListarSeguros.jsp");  
			rd.forward(request, response);
			
		}
		
	}

}
