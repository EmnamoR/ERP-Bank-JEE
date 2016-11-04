package tn.esprit.interfaces;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.entites.Supplier;

@Local
public interface IgestionSupplierLocal {

	Boolean addSupplier(Supplier supplier);
	Boolean deleteSupplier(Supplier supplier);
	Boolean updateSupplier(Supplier supplier);
	Supplier FindSupplierById(Integer IdSupplier);
    List<Supplier> FindAllSuppliers ();
    public List<Supplier> findSupplierByName(String name);
}
