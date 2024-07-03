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
		System.out.println("Producto fue registrado en la BD");

		// Confirmar
		em.getTransaction().commit();

		// Cerrar
		em.close();
	}

	@Override
	public List<TblProductocl3> ListadoProducto() {
		// Establecer la conexión con la unidad de persistencia
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("LPII_CL3_DIAZLUQUELEYLAANTONIA");

		// Gestionar entidades
		EntityManager em = emf.createEntityManager();

		// Iniciamos la transaccion
		em.getTransaction().begin();

		List<TblProductocl3> listado = em.createQuery("SELECT p FROM TblProductocl2 p", TblProductocl3.class)
				.getResultList();

		// Confirmamos
		em.getTransaction().commit();

		// Cerramos
		em.close();

		// Retornar lista de Productos
		return listado;
	}

	@Override
	public void ActualizarProducto(TblProductocl3 producto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void EliminarProducto(TblProductocl3 producto) {
		// TODO Auto-generated method stub
		
	}

}
