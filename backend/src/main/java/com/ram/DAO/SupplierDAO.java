package com.ram.DAO;

import java.util.List;


import com.ram.model.Supplier;

public interface SupplierDAO {
	public boolean addSupplier(Supplier supplier);
	public boolean deleteSupplier(Supplier supplier);
	public boolean updateSupplier(Supplier supplier);
	public List<Supplier>ListSupplieries();
	public Supplier getSupplier(int SupplierId);
	
	
	

}
