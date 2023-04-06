package com.wipro.service_app.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.service_app.entity.ServiceEntity;

@Repository
public interface ServicesRepos extends JpaRepository<ServiceEntity, Integer> {
}
