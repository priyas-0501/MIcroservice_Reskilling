package com.ibm.poc.db.repositories;

import com.ibm.poc.db.entities.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ibm.poc.db.entities.Store;

@Repository
public interface StoreRepository extends JpaRepository<Store, Integer> {

}
