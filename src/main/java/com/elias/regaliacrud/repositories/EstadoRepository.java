package com.elias.regaliacrud.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.elias.regaliacrud.domain.Estado;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Integer> {


}
