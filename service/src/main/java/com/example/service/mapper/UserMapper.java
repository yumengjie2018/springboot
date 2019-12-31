package com.example.service.mapper;

import com.example.service.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * title：UserMapper
 * description:
 *
 * @author yumengjie
 * @date 2019/12/18 15:57
 */

@Repository
public interface UserMapper extends JpaRepository<User, Long> {

}
