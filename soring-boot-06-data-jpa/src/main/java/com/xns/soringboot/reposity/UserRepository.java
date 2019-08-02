package com.xns.soringboot.reposity;

import com.xns.soringboot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Classname UserRepository
 * @Description TODO
 * @Date 19-8-2 上午9:53
 * @Created by xns
 */

/**
 * 继承JpaRepository来完成对数据库的操作
 */
public interface UserRepository extends JpaRepository<User,Integer> {

}
