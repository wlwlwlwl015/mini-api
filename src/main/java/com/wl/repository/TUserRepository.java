package com.wl.repository;

import com.wl.bean.TUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by wangliang on 2018/5/5.
 */
public interface TUserRepository extends JpaRepository<TUser, Integer> {

}
