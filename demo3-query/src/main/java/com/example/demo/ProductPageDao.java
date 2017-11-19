package com.example.demo;

import java.util.List;

import org.seasar.doma.Dao;
import org.seasar.doma.Select;
import org.seasar.doma.boot.ConfigAutowireable;
import org.springframework.transaction.annotation.Transactional;

@ConfigAutowireable
@Dao
public interface ProductPageDao {

  @Select
  @Transactional
  List<ProductPageRecord> findAll();
}
