package com.backendspringbootapi.backendspringbootapi.freedom;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/freedom")
public class FreedomController
{
    private final FreedomService freedomService;
    //TODO: validate data with xsd and json schema

    public FreedomController(FreedomService freedomService)
    {
        this.freedomService = freedomService;
    }

    @RequestMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<FreedomModel> getAllFreedom()
    {
        return freedomService.getAllFreedom();
    }

    @RequestMapping("/store")
    @ResponseStatus(HttpStatus.OK)
    public FreedomModel save(FreedomModel freedomModel) {return freedomService.saveFreedomData(freedomModel);}
}
