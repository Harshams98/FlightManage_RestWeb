package com.flight.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.flight.main.model.Users;

public interface UsersRepo  extends JpaRepository<Users,Integer>{

}
