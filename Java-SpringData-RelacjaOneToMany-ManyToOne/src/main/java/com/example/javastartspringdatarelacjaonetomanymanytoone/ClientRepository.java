package com.example.javastartspringdatarelacjaonetomanymanytoone;

import org.springframework.data.repository.CrudRepository;

public interface ClientRepository extends CrudRepository<Client,Long> {
}
