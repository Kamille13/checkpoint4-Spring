package com.checkpoint4.checkpoint4.repository;

import com.checkpoint4.checkpoint4.model.FreakShow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FreakShowRepository extends JpaRepository<FreakShow,Long> {
}
