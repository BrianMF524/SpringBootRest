package com.application.rest.persistence.Impl;

import com.application.rest.entities.Maker;
import com.application.rest.persistence.IMakerDAO;
import com.application.rest.repo.MakerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class MakerDAOImpl implements IMakerDAO {
    @Autowired
    private MakerRepo makerRepo;

    @Override
    public Optional<Maker> findById(Long id) {
        return makerRepo.findById(id);
    }

    @Override
    public List<Maker> findAll() {
        return (List<Maker>) makerRepo.findAll();
    }

    @Override
    public void save(Maker m) {
        makerRepo.save(m);
    }

    @Override
    public void deleteById(Long id) {
        makerRepo.deleteById(id);
    }
}
