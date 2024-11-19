package com.exo1.exo1.service;

import com.exo1.exo1.dto.ProjetDto;
import com.exo1.exo1.dto.ProjetTaskCountDto;
import com.exo1.exo1.entity.Projet;
import com.exo1.exo1.entity.ProjetTaskCount;
import com.exo1.exo1.mapper.ProjetTaskCountMapper;
import com.exo1.exo1.repository.ProjetTaskCountRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;

@Service
@AllArgsConstructor
public class ProjetTaskCountService {
    private ProjetTaskCountRepository projetTaskCountRepository;
    private ProjetTaskCountMapper projetTaskCountMapper;

    public List<ProjetTaskCountDto> findAll() {
        return projetTaskCountMapper.toDtos(projetTaskCountRepository.findAll());
    }

    public ProjetTaskCountDto findById(long id) {
        ProjetTaskCount projetTaskCount = projetTaskCountRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Projet not found with id " + id));
        return projetTaskCountMapper.toDto(projetTaskCount);
    }
}
