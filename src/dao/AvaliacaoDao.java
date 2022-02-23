package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import db.DbException;
import dto.Avaliacao;
import util.interfaceDao;

public class AvaliacaoDao implements interfaceDao<Avaliacao>{

	EntityManagerFactory emf;
	EntityManager em;
	
	public AvaliacaoDao() {
		emf = Persistence.createEntityManagerFactory("school");
		em = emf.createEntityManager();
	}
	
	public void insert (Avaliacao obj) {
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
	
	public void update (Avaliacao obj) {
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
			Avaliacao aluno = findById(id);
			em.remove(aluno);
			em.getTransaction().commit();
		}
		catch (RuntimeException e) {
			em.getTransaction().rollback();
			throw new DbException(e.getMessage());
		}
		em.close();
	}
	
	public Avaliacao findById (Long id) {
		try {
			return em.find(Avaliacao.class, id);
		} 
		catch(RuntimeException e) {
			throw new DbException(e.getMessage());
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Avaliacao> findAll() {
		try {
			return em.createQuery("FROM " + 
					Avaliacao.class.getName()).getResultList();
		} 
		catch(RuntimeException e) {
			throw new DbException(e.getMessage());
		}
	}
	
}
