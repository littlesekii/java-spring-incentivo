package com.littlesekii.incentivo.modules.user.repository;

import com.littlesekii.incentivo.modules.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
