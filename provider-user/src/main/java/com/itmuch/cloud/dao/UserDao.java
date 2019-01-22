package com.itmuch.cloud.dao;


import com.itmuch.cloud.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by ZC-16-012 on 2018/12/19.
 */
@Repository
public interface UserDao  extends JpaRepository<User,Long>{


}
