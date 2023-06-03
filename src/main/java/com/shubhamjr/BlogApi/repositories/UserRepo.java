package com.shubhamjr.BlogApi.repositories;

import com.shubhamjr.BlogApi.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer> {
}
