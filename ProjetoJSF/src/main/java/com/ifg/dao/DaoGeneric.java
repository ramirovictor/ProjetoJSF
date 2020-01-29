package com.ifg.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.ifg.jpautil.JPAUtil;

public class DaoGeneric <E>{
	
	public void salvar(E entity) {
		
			//EntityManger para prover a persistência
			EntityManager entityManager  = JPAUtil.getEntityManager();
			//fazer uma transação no BD
			EntityTransaction entityTransaction = entityManager.getTransaction();
			//iniciar a transação, colocando-a como ativa!
			entityTransaction.begin();
			
			//salvar o objeto passado
			entityManager.persist(entity);
			
			entityTransaction.commit();
			entityManager.close();
	}
	

}
