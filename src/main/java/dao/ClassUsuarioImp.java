package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;

import interfaces.Iusuario;
import model.TblUsuariocl3;

public class ClassUsuarioImp implements Iusuario {

	@Override
	public TblUsuariocl3 Autenticar(String usuario, String password) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("LPII_CL3_DIAZLUQUELEYLAANTONIA");
		EntityManager em = emf.createEntityManager();
		TblUsuariocl3 user = null;

		try {
			em.getTransaction().begin();
			user = em
					.createQuery(
							"SELECT u FROM TblUsuariocl3 u WHERE u.usuariocl3 = :usuario AND u.passwordcl3 = :password",
							TblUsuariocl3.class)
					.setParameter("usuario", usuario).setParameter("password", password).getSingleResult();
			em.getTransaction().commit();
		} catch (NoResultException e) {
			user = null;
		} finally {
			em.close();
		}

		return user;
	}
}
