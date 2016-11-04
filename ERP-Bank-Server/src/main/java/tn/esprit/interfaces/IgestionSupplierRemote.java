package tn.esprit.interfaces;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.entites.Supplier;

@Remote
public interface IgestionSupplierRemote {
	Boolean addSupplier(Supplier supplier);
	Boolean deleteSupplier(Supplier supplier);
	Boolean updateSupplier(Supplier supplier);
	Supplier FindSupplierById(Integer IdSupplier);
    List<Supplier> FindAllSuppliers ();
    public List<Supplier> findSupplierByName(String name);
}
