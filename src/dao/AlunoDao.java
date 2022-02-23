package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import db.DbException;
import dto.Aluno;
import util.interfaceDao;

public class AlunoDao implements interfaceDao<Aluno>{

	EntityManagerFactory emf;
	EntityManager em;
	
	public AlunoDao() { 
		emf = Persistence.createEntityManagerFactory("school");
		em = emf.createEntityManager();
	}
	
	public void insert (Aluno obj) {
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
	
	public void update (Aluno obj) {
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
			Aluno aluno = findById(id);
			em.remove(aluno);
			em.getTransaction().commit();
		}
		catch (RuntimeException e) {
			em.getTransaction().rollback();
			throw new DbException(e.getMessage());
		}
		em.close();
	}
	
	public Aluno findById (Long id) {
		try {
			return em.find(Aluno.class, id);
		} 
		catch(RuntimeException e) {
			throw new DbException(e.getMessage());
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Aluno> findAll() {
		try {
			return em.createQuery("FROM " +
					Aluno.class.getName()).getResultList();
		} 
		catch(RuntimeException e) {
			throw new DbException(e.getMessage());
		}
	}	
}
