package com.example.javastartspringdatarelacje;

import org.springframework.data.repository.CrudRepository;

public interface UserDetailsRepository extends CrudRepository<UserDetails,Long> {
}
