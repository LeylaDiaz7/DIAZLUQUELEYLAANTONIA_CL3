package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import interfaces.Iproducto;
import model.TblProductocl3;

public class ClassProductoImp implements Iproducto {

	@Override
	public void RegistrarProducto(TblProductocl3 producto) {
		// Establecer la conexión con la unidad de persistencia
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("LPII_CL3_DIAZLUQUELEYLAANTONIA");

		// Gestionar entidades
		EntityManager em = emf.createEntityManager();

		// Iniciamos la transaccion
		em.getTransaction().begin();

		// Registramos
		em.persist(producto);

		// Emitir mensaje por consola
		System.out.println("El producto fue registrado en la BD");

		// Confirmar
		em.getTransaction().commit();

		// Cerrar
		em.close();
	}

	@Override
	public void ActualizarProducto(TblProductocl3 producto) {
		// Establecer la conexión con la unidad de persistencia
		EntityManagerFactory em = Persistence.createEntityManagerFactory("LPII_CL3_DIAZLUQUELEYLAANTONIA");

		// Gestionar las entidades
		EntityManager emanager = em.createEntityManager();

		// Iniciamos la transaccion
		emanager.getTransaction().begin();

		// Actualizammos
		emanager.merge(producto);

		// Emitir el mensaje
		System.out.println("El producto actualizado en la BD");

		// Confirmamos
		emanager.getTransaction().commit();

		// Cerramos
		emanager.close();
	}

	@Override
	public List<TblProductocl3> ListadoProducto() {
		// Establecer la conexión con la unidad de persistencia
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("LPII_CL3_DIAZLUQUELEYLAANTONIA");

		// Gestionar entidades
		EntityManager em = emf.createEntityManager();

		// Iniciamos la transaccion
		em.getTransaction().begin();

		List<TblProductocl3> listado = em.createQuery("SELECT p FROM TblProductocl3 p", TblProductocl3.class)
				.getResultList();

		// Confirmamos
		em.getTransaction().commit();

		// Cerramos
		em.close();

		// Retornar lista de Productos
		return listado;
	}

	@Override
	public void EliminarProducto(TblProductocl3 producto) {
		// Establecemos la conexión con la unidad de persistencia.
		EntityManagerFactory em = Persistence.createEntityManagerFactory("LPII_CL3_DIAZLUQUELEYLAANTONIA");

		// Gestionar las entidades
		EntityManager emanager = em.createEntityManager();

		// Iniciamos la transaccion
		emanager.getTransaction().begin(); // BEGIN

		// Recuperamos el código a eliminar
		TblProductocl3 elim = emanager.merge(producto);

		// Procedemos a eliminar
		emanager.remove(elim);

		// Emitimos mensaje por consola
		System.out.println("Producto eliminado den la BD");

		// Confirmamos
		emanager.getTransaction().commit();

		// Cerramos
		emanager.close();

	}

	@Override
	public TblProductocl3 BuscarProducto(TblProductocl3 cliente) {
		// Establecemos la conexión con la unidad de persistencia...
		EntityManagerFactory fbr = Persistence.createEntityManagerFactory("LPII_CL3_DIAZLUQUELEYLAANTONIA");

		// Gestionar las entidades
		EntityManager emanager = fbr.createEntityManager();

		// Iniciamos la transacción
		emanager.getTransaction().begin();

		// Recuperamos el codigo a buscar...
		TblProductocl3 buscarcli = emanager.find(TblProductocl3.class, cliente.getIdproductoscl3());

		// Confirmamos
		emanager.getTransaction().commit();

		// Cerramos
		emanager.close();

		// Retornamos al cliente buscado de la BD
		return buscarcli;
	}

}
