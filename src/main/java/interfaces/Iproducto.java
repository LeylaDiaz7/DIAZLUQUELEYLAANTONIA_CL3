package interfaces;

import java.util.List;

import model.TblProductocl3;

public interface Iproducto {

	// Declarar métodos para el CRUD de productos
		public void RegistrarProducto(TblProductocl3 producto);

		public void ActualizarProducto(TblProductocl3 producto);

		public void EliminarProducto(TblProductocl3 producto);

		public List<TblProductocl3> ListadoProducto();
		
}
