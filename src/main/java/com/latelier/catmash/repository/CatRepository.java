package com.latelier.catmash.repository;

import com.latelier.catmash.entity.Cat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatRepository extends JpaRepository<Cat, Long> {
    Cat findByImageId(String imageId);
}
