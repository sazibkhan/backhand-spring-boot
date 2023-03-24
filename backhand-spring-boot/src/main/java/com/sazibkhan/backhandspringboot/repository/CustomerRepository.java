package com.sazibkhan.backhandspringboot.repository;
import com.sazibkhan.backhandspringboot.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {


}
