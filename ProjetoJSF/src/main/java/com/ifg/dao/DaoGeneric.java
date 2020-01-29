package com.ifg.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.ifg.jpautil.JPAUtil;

public class DaoGeneric<E> {

	public void salvar(E entity) {

		// EntityManger para prover a persistência
		EntityManager entityManager = JPAUtil.getEntityManager();
		// fazer uma transação no BD
		EntityTransaction entityTransaction = entityManager.getTransaction();
		// iniciar a transação, colocando-a como ativa!
		entityTransaction.begin();

		// salvar o objeto passado
		entityManager.persist(entity);

		entityTransaction.commit();
		entityManager.close();
	}

	public E merge(E entity) {
		EntityManager entityManager = JPAUtil.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		E retorno = entityManager.merge(entity);
		entityTransaction.commit();
		entityManager.close();
		return retorno;
	}
	public void delete(E entity) {
		EntityManager entityManager = JPAUtil.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		
		entityManager.remove(entity);
		 
		entityTransaction.commit();
		entityManager.close();
	}

}
