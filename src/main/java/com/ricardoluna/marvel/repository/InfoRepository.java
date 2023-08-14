package com.ricardoluna.marvel.repository;

import com.ricardoluna.marvel.entity.Info;
import com.ricardoluna.marvel.entity.InfoID;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface for CRUD operations on Info entities.
 */
public interface InfoRepository extends JpaRepository<Info, InfoID> {

}