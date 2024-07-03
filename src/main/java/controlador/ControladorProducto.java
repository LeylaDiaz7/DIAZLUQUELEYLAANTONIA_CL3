package controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ClassProductoImp;
import model.TblProductocl3;

/**
 * Servlet implementation class ControladorProducto
 */
public class ControladorProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ControladorProducto() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// RECUPERAMOS ACCIÓN Y CÓDIGO
		String accion = request.getParameter("accion");
		TblProductocl3 producto = new TblProductocl3();
		ClassProductoImp crud = new ClassProductoImp();

		// Aplicar condicion

		if (accion != null) {
			switch (accion) {
			case "Modificar":
				int id = Integer.parseInt(request.getParameter("id"));
				producto.setIdproductoscl3(id);
				TblProductocl3 buscarcod = crud.BuscarProducto(producto);

				// ENVIAR LOS VALORES BUSCADOS POR CODIGO EN LA BD AL ACTUALIZAR
				request.setAttribute("id", buscarcod.getIdproductoscl3());
				request.setAttribute("nom", buscarcod.getNombrecl3());
				request.setAttribute("pv", buscarcod.getPrecioventacl3());
				request.setAttribute("pc", buscarcod.getPreciocompcl3());
				request.setAttribute("estado", buscarcod.getEstadocl3());
				request.setAttribute("descrip", buscarcod.getDescripcl3());

				// REDIRECCIONAR
				request.getRequestDispatcher("/actualizarProducto.jsp").forward(request, response);
				break;

			case "Eliminar":
				int codigoEliminar = Integer.parseInt(request.getParameter("id"));
				producto.setIdproductoscl3(codigoEliminar);
				crud.EliminarProducto(producto);
				// refrescar el listado..
				List<TblProductocl3> listado = crud.ListadoProducto();
				request.setAttribute("listadoProductos", listado);
				// redireccionar
				request.getRequestDispatcher("/listaProductos.jsp").forward(request, response);
				break;

			case "Listar":
				List<TblProductocl3> listadoProducto = crud.ListadoProducto();
				// invocamos el listado de productos para la vista
				request.setAttribute("listadoProductos", listadoProducto);
				// Redireccionamos
				request.getRequestDispatcher("/listaProductos.jsp").forward(request, response);
				break;
			}// fin del switch...

		} else {
			// Si no hay acción, simplemente mostrar el listado de clientes
			producto = new TblProductocl3();
			crud = new ClassProductoImp();
			List<TblProductocl3> listadoProductos = crud.ListadoProducto();
			// Invocamos el listado de productos a la vista
			request.setAttribute("listadoProductos", listadoProductos);
			// Redireccionamos
			request.getRequestDispatcher("/listaProductos.jsp").forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// recuperar valores del formulario
		String id = request.getParameter("id");
		String nombre = request.getParameter("nom");
		String pVenta = request.getParameter("pv");
		String pCompra = request.getParameter("pc");
		String estado = request.getParameter("estado");
		String descrip = request.getParameter("descrip");

		// Instanciar entidades...
		TblProductocl3 product = new TblProductocl3();
		ClassProductoImp crud = new ClassProductoImp();

		// Asignar valores
		product.setNombrecl3(nombre);
		product.setPrecioventacl3(Double.parseDouble(pVenta));
		product.setPreciocompcl3(Double.parseDouble(pCompra));
		product.setEstadocl3(estado);
		product.setDescripcl3(descrip);

		if (id != null) {
			// REcuperar codigo a actualizar
			int codigo = Integer.parseInt(id);
			// Asignar el codigo a actualizar
			product.setIdproductoscl3(codigo);
			// Invocar metodo actualizar
			crud.ActualizarProducto(product);
		} else {
			// invocamos la metodo registrar...
			crud.RegistrarProducto(product);

		}

		// actualizador listado productos
		List<TblProductocl3> listadoProductos = crud.ListadoProducto();
		
		request.setAttribute("listadoProductos", listadoProductos);
		request.getRequestDispatcher("/listaProductos.jsp").forward(request, response);
	}

}
