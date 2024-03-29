package com.backendspringbootapi.backendspringbootapi.freedom;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FreedomService
{
    private final FreedomRepository freedomRepository;

    public FreedomService(FreedomRepository freedomRepository) {
        this.freedomRepository = freedomRepository;
    }

    public List<FreedomModel> getAllFreedom()
    {
        return freedomRepository.findAll();
    }
    public FreedomModel saveFreedomData(FreedomModel freedomModel)
    {
        return freedomRepository.save(freedomModel);
    }
}
