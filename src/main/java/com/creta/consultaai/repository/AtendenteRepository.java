package com.creta.consultaai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.creta.consultaai.domain.Atendente;

@Repository
public interface AtendenteRepository extends JpaRepository<Atendente, Long> {
	
	/*
	 * extends JpaRepository<BeerOrder, UUID> 
	 * 
	 * Page<BeerOrder> findAllByCustomer(Customer customer, Pageable pageable);

    List<BeerOrder> findAllByOrderStatus(OrderStatusEnum orderStatusEnum);

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    BeerOrder findOneById(UUID id);
	 * 
	 * */

}
