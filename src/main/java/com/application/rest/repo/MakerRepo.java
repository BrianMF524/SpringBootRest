package com.application.rest.repo;

import com.application.rest.entities.Maker;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MakerRepo extends CrudRepository<Maker,Long> {

}
