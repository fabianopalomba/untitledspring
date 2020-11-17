package com.fegh.springata.dao;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

public interface GenericRepository<I extends Serializable, E extends Serializable>
{
	@NotNull List<I> GetEvery();
	
	void Insert(@NotNull I entity);
	
	void Update(@NotNull I entity);
	
	void Delete(@NotNull I entity);
	
	void DeleteById(@NotNull E Id);
	
	I SelById(@NotNull E Id);
}
