package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import db.DbException;
import dto.Matricula;
import util.interfaceDao;

public class MatriculaDao implements interfaceDao<Matricula>{

	EntityManagerFactory emf;
	EntityManager em;
	
	public MatriculaDao() {
		emf = Persistence.createEntityManagerFactory("school");
		em = emf.createEntityManager();
	}
	
	public void insert (Matricula obj) {
		em.getTransaction().begin();
		
		try {
			em.persist(obj);
			em.getTransaction().commit();
		} 
		catch (RuntimeException e) {
			em.getTransaction().rollback();
			throw new DbException(e.getMessage());
		}
		finally {
			em.close();
		}
	}
	
	public void update (Matricula obj) {
		em.getTransaction().begin();
		
		try {
			em.merge(obj);
			em.getTransaction().commit();
		}
		catch(RuntimeException e) {
			em.getTransaction().rollback();
			throw new DbException(e.getMessage());
		}
		finally {
			em.close();
		}
	}
	
	public void delete (Long id) {
		em.getTransaction().begin();
		try {
			Matricula aluno = findById(id);
			em.remove(aluno);
			em.getTransaction().commit();
		}
		catch (RuntimeException e) {
			em.getTransaction().rollback();
			throw new DbException(e.getMessage());
		}
		em.close();
	}

	public Matricula findById (Long id) {
		try {
			return em.find(Matricula.class, id);
		} 
		catch(RuntimeException e) {
			throw new DbException(e.getMessage());
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Matricula> findAll() {
		try {
			return em.createQuery("FROM " +
					Matricula.class.getName()).getResultList();
		} 
		catch(RuntimeException e) {
			throw new DbException(e.getMessage());
		}
	}	
}
