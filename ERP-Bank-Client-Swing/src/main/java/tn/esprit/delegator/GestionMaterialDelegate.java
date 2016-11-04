package tn.esprit.delegator;

import java.util.List;

import tn.esprit.entites.Material;
import tn.esprit.interfaces.IgestionMaterialRemote;
import tn.esprit.locator.ServiceLocator;

public class GestionMaterialDelegate {

	//private static IgestionMaterialRemote remote;
		private static final String jndi="ERP-Bank/IgestionMaterial!tn.esprit.interfaces.IgestionMaterialRemote";
		
		private static IgestionMaterialRemote getProxy(){
			return (IgestionMaterialRemote) ServiceLocator.getInstance().getRemoteProxy(jndi);
		}
		public static Boolean doAddMaterial(Material material){
			return getProxy().addMaterial(material);
			
		}
		public static Boolean doDeleteMaterial(Material material){
			return getProxy().deleteMaterial(material);
			
		}
		public static Boolean doUpdateMaterial(Material material){
			return getProxy().updateMaterial(material);
		}
		public static Material doFindMaterialById(Integer IdMaterial){
			return getProxy().FindMaterialById(IdMaterial);
			
		}
		public static List<Material> doFindAllMaterial (){
			return getProxy().FindAllMaterial();
	    	
	    }
		public static List<Material> doFindMaterialbyDesignation(String designation){
			return getProxy().findMaterialBydesignation(designation);
		}

}
