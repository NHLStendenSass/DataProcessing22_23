package com.backendspringbootapi.backendspringbootapi.Freedom;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;
import java.util.Objects;

@Entity
@Table(schema = "dbo",name = "freedom")
@NoArgsConstructor
public class FreedomModel {
    @Id
    @GeneratedValue
    @Api
    private int id;
}
