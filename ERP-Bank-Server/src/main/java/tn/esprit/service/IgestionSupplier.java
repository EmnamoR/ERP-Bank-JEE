package tn.esprit.service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.esprit.entites.Supplier;
import tn.esprit.interfaces.IgestionSupplierLocal;
import tn.esprit.interfaces.IgestionSupplierRemote;

/**
 * Session Bean implementation class IgestionSupplier
 */
@Stateless
@LocalBean
public class IgestionSupplier implements IgestionSupplierRemote, IgestionSupplierLocal {

	@PersistenceContext(unitName="ERP-Bank")
    EntityManager entitymanager;
    public IgestionSupplier() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public Boolean addSupplier(Supplier supplier) {

		try {
			entitymanager.persist(supplier);
			return true;
		} catch (Exception e) {
		return false;
				}
	}

	@Override
	public Boolean deleteSupplier(Supplier supplier) {
		try {
			entitymanager.remove(entitymanager.merge(supplier));
			return true;
		} catch (Exception e) {
		return false;
				}		
	}

	@Override
	public Boolean updateSupplier(Supplier supplier) {
		try {
			entitymanager.merge(supplier);
			return true;
		} catch (Exception e) {
		return false;
				}	
	}

	@Override
	public Supplier FindSupplierById(Integer IdSupplier) {
		Supplier supplier=null;	
		try {
			supplier=entitymanager.find(Supplier.class,IdSupplier);				
			} catch (Exception e) {
			
					}				return supplier;
	}

	@Override
	public List<Supplier> FindAllSuppliers() {
//Query query=entitymanager.createNamedQuery("select s from Supplier s");
//		
//		return query.getResultList();
		return entitymanager.createQuery("select e from Supplier e").getResultList();
	}

	@Override
	public List<Supplier> findSupplierByName(String name) {
		name = name+"%";
		String jpql = "select c from Supplier c where c.name like :name";
		Query query = entitymanager.createQuery(jpql);
		return  query.setParameter("name", name).getResultList();
	}


}
