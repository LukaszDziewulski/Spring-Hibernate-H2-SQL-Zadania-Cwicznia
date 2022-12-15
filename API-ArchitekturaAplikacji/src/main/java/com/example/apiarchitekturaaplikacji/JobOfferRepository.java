package com.example.apiarchitekturaaplikacji;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


public interface JobOfferRepository extends CrudRepository<JobOffer, Long> {

}
