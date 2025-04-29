package com.application.rest.service.impl;

import com.application.rest.entities.Maker;
import com.application.rest.persistence.IMakerDAO;
import com.application.rest.service.IMakerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MakerServiceImpl implements IMakerService {
    @Autowired
    private IMakerDAO MakerDAO;

    @Override
    public Optional<Maker> findById(Long id) {
        return MakerDAO.findById(id);
    }

    @Override
    public List<Maker> findAll() {
        return MakerDAO.findAll();
    }

    @Override
    public void save(Maker m) {
        MakerDAO.save(m);
    }

    @Override
    public void deleteById(Long id) {
        MakerDAO.deleteById(id);
    }
}
