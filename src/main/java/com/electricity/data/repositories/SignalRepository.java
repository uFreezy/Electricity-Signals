package com.electricity.data.repositories;

import com.electricity.model.Signal;
import com.electricity.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SignalRepository extends JpaRepository<Signal, Long> {
    List<Signal> findByOwner(User user);
}
