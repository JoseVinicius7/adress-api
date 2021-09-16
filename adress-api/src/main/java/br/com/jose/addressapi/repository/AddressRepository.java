package br.com.jose.addressapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.jose.addressapi.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

}
