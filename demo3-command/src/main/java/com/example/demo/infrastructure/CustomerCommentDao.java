package com.example.demo.infrastructure;

import org.seasar.doma.Dao;
import org.seasar.doma.Insert;
import org.seasar.doma.boot.ConfigAutowireable;

@ConfigAutowireable
@Dao
public interface CustomerCommentDao {

  @Insert
  int insert(CustomerCommentRecord customerCommentRecord);
  
}
