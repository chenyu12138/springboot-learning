package com.chenyu.Repository;

import com.chenyu.domain.Students;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentsRepository extends JpaRepository<Students,Long> {

    List<Students> findByName(String name);

    Page<Students> findAll(Pageable pageable);

    List<Students> findById(long id);

}
