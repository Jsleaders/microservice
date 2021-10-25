package com.service.recla;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReclaRepository extends JpaRepository <Recla,Integer> {
    @Query(value="select * from recla u where u.subject LIKE %:subject%",nativeQuery=true)
    List<Recla> findReclaBySubject(@Param("subject") String subject);
}