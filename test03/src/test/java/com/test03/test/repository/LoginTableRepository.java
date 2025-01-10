package com.test03.test.repository;

import com.test03.test.LoginTable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginTableRepository extends JpaRepository<LoginTable, Long> {
}
