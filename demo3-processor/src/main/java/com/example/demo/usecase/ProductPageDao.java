package com.example.demo.usecase;

import org.seasar.doma.Dao;
import org.seasar.doma.Select;
import org.seasar.doma.Update;
import org.seasar.doma.boot.ConfigAutowireable;

@ConfigAutowireable
@Dao
public interface ProductPageDao {

  @Select
  ProductPageRecord findById(String productId);
  
  @Update
  int update(ProductPageRecord record);
}
