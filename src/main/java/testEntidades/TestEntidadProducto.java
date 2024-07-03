package testEntidades;

import java.util.List;

import dao.ClassProductoImp;
import model.TblProductocl3;

public class TestEntidadProducto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Instanciar
		ClassProductoImp crudProd = new ClassProductoImp();

		TblProductocl3 prodPrueba = new TblProductocl3();

		// 1. CREAR PRODUCTO ----------------------------------
		/*
		 * prodPrueba.setNombrecl2("lapicero"); prodPrueba.setPrecioventacl2(7);
		 * prodPrueba.setPreciocompcl2(3); prodPrueba.setEstadocl2("Disponible");
		 * prodPrueba.setDescripcl2("negro");
		 * 
		 * crudProd.RegistrarProducto(prodPrueba);
		 */

		// 2. ACTUALIZAR PRODUCTO ------------------------------
		/*
		prodPrueba.setIdproductoscl3(7);
		prodPrueba.setNombrecl3("Lapicero Actualizado");
		prodPrueba.setPrecioventacl3(10);
		prodPrueba.setPreciocompcl3(5);
		prodPrueba.setEstadocl3("No Disponible");
		prodPrueba.setDescripcl3("rojo");

		crudProd.ActualizarProducto(prodPrueba);
		*/
		
		// 3. ELIMINAR PRODUCTO
		/*
		prodPrueba.setIdproductoscl3(7);
		crudProd.EliminarProducto(prodPrueba);
		*/
		// 4.- LISTAR PRODUCTOS --------------------------------
		List<TblProductocl3> listadoProductos = crudProd.ListadoProducto();

		for (TblProductocl3 listar : listadoProductos) {

			System.out.println( "\n***************************"
					+ "ID: " + listar.getIdproductoscl3() + "\nNombre: " + listar.getNombrecl3()
					+ "\nPrecio venta: " + listar.getPrecioventacl3() + "\nPrecio compra: " + listar.getPreciocompcl3()
					+ "\nEstado: " + listar.getEstadocl3() + "\nDescripción: " + listar.getDescripcl3()
					+ "\n***************************");
		}

	}

}
