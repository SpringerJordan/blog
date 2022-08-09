package com.domain.login.repos;


import com.domain.login.models.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface LoginRepository extends JpaRepository<Login, Long> {
    Optional<Login> findByUserName(String userName);
}