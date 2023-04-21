package com.backendspringbootapi.backendspringbootapi.freedom;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FreedomRepository extends JpaRepository<FreedomModel, Long>, JpaSpecificationExecutor<FreedomModel>
{
    public List<FreedomModel> findAll();
}
