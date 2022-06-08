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

		if (request.getParameter("Param") != null) {

			request.setAttribute("listaTS", lista);

			seguroDAO sdao = new seguroDAO();

			int ultID = sdao.obtenerID() + 1;
			request.setAttribute("proxID", ultID);

			RequestDispatcher rd = request.getRequestDispatcher("/agregarSeguro.jsp");
			rd.forward(request, response);

		}

	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		tipoSeguroDAO tsdao = new tipoSeguroDAO();
		ArrayList<tipoSeguro> lista = (ArrayList<tipoSeguro>) tsdao.obtenerTipoSeguro();
		request.setAttribute("listaTS", lista);
		if (request.getParameter("btnAceptar") != null) {
			
			seguro seg = new seguro();
			seg.setDescripcion(request.getParameter("txtDescripcion"));
			tipoSeguro tipo = new tipoSeguro();
			tipo.setIdTipo(Integer.parseInt(request.getParameter("tipoSeguro").toString()));
			seg.setIdTipo(tipo);
			seg.setCostoContratacion(Float.parseFloat(request.getParameter("txtCContratacion")));
			seg.setCostoAsegurado(Float.parseFloat(request.getParameter("txtMaximoAseg")));

			seguroDAO sdao = new seguroDAO();

			boolean insert = sdao.agregarSeguro(seg);
			request.setAttribute("insert", insert);

			int ultID = sdao.obtenerID() + 1;
			request.setAttribute("proxID", ultID);

			RequestDispatcher rd = request.getRequestDispatcher("/agregarSeguro.jsp");
			rd.forward(request, response);
		}
	}

}
