package br.com.algaworks.msrapi.domain.repository;

import br.com.algaworks.msrapi.domain.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long>{
    Optional<Client> findByEmail(String email);

}
