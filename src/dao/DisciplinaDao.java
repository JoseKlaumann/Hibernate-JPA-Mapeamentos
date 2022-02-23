package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import db.DbException;
import dto.Disciplina;
import util.interfaceDao;

public class DisciplinaDao implements interfaceDao<Disciplina>{

	EntityManagerFactory emf;
	EntityManager em;
	
	public DisciplinaDao() {
		emf = Persistence.createEntityManagerFactory("school");
		em = emf.createEntityManager();
	}
	
	public void insert (Disciplina obj) {
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
	
	public void update (Disciplina obj) {
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
			Disciplina aluno = findById(id);
			em.remove(aluno);
			em.getTransaction().commit();
		}
		catch (RuntimeException e) {
			em.getTransaction().rollback();
			throw new DbException(e.getMessage());
		}
		em.close();
	}
	
	public Disciplina findById (Long id) {
		try {
			return em.find(Disciplina.class, id);
		} 
		catch(RuntimeException e) {
			throw new DbException(e.getMessage());
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Disciplina> findAll() {
		try {
			return em.createQuery("FROM " +
					Disciplina.class.getName()).getResultList();
		} 
		catch(RuntimeException e) {
			throw new DbException(e.getMessage());
		}
	}
	
}
