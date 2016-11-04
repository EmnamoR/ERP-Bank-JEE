package tn.esprit.delegator;

import java.util.List;

import tn.esprit.entites.Supplier;
import tn.esprit.interfaces.IgestionSupplierRemote;
import tn.esprit.locator.ServiceLocator;

public class GestionSupplierDelegate {

	private static final String jndi="ERP-Bank/IgestionSupplier!tn.esprit.interfaces.IgestionSupplierRemote";
	private static IgestionSupplierRemote getProxy(){
		return (IgestionSupplierRemote) ServiceLocator.getInstance().getRemoteProxy(jndi);
	}
	public static Boolean doAddSupplier(Supplier supplier){
		return getProxy().addSupplier(supplier);
		
	}
	public static Boolean doDeleteSupplier(Supplier supplier){
		return getProxy().deleteSupplier(supplier);
		
	}
	public static Boolean doUpdateSupplier(Supplier supplier){
		return getProxy().updateSupplier(supplier);
	}
	public static Supplier doFindSupplierById(Integer Idsupp){
		return getProxy().FindSupplierById(Idsupp);
		
	}
	public static List<Supplier> doFindAllSupplier (){
		return getProxy().FindAllSuppliers();
    	
    }
	public static List<Supplier> doFindSupplierbyName(String name){
		return getProxy().findSupplierByName(name);
	}

}
