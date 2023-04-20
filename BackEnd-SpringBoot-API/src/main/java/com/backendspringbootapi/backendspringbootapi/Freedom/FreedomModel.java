package com.backendspringbootapi.backendspringbootapi.Freedom;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Entity
@Table(schema = "dbo",name = "freedom")
@NoArgsConstructor
public class FreedomModel {
    @Id
    @Column(name = "Year")// check IT LATER
    private String year;
    @Column(name = "ISO_Code")
    private String isoCode;
    @Column(name = "Country")
    private String country;
    @Column(name = "PERSONAL_FREEDOM_Score")
    private String personalFreedomScore;
    @Column(name = "ECONOMIC_FREEDOM_Score")
    private String economicFreedomScore;
    @Column(name = "HUMAN_FREEDOM_Score")
    private String humanFreedomScore;
    @Column(name = "HUMAN_FREEDOM_Rank")
    private String humanFreedomRank;

    public FreedomModel(String year, String isoCode, String country, String personalFreedomScore, String economicFreedomScore, String humanFreedomScore, String humanFreedomRank) {
        this.year = year;
        this.isoCode = isoCode;
        this.country = country;
        this.personalFreedomScore = personalFreedomScore;
        this.economicFreedomScore = economicFreedomScore;
        this.humanFreedomScore = humanFreedomScore;
        this.humanFreedomRank = humanFreedomRank;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getIsoCode() {
        return isoCode;
    }

    public void setIsoCode(String isoCode) {
        this.isoCode = isoCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPersonalFreedomScore() {
        return personalFreedomScore;
    }

    public void setPersonalFreedomScore(String personalFreedomScore) {
        this.personalFreedomScore = personalFreedomScore;
    }

    public String getEconomicFreedomScore() {
        return economicFreedomScore;
    }

    public void setEconomicFreedomScore(String economicFreedomScore) {
        this.economicFreedomScore = economicFreedomScore;
    }

    public String getHumanFreedomScore() {
        return humanFreedomScore;
    }

    public void setHumanFreedomScore(String humanFreedomScore) {
        this.humanFreedomScore = humanFreedomScore;
    }

    public String getHumanFreedomRank() {
        return humanFreedomRank;
    }

    public void setHumanFreedomRank(String humanFreedomRank) {
        this.humanFreedomRank = humanFreedomRank;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FreedomModel that = (FreedomModel) o;
        return Objects.equals(year, that.year) && Objects.equals(isoCode, that.isoCode) && Objects.equals(country, that.country) && Objects.equals(personalFreedomScore, that.personalFreedomScore) && Objects.equals(economicFreedomScore, that.economicFreedomScore) && Objects.equals(humanFreedomScore, that.humanFreedomScore) && Objects.equals(humanFreedomRank, that.humanFreedomRank);
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, isoCode, country, personalFreedomScore, economicFreedomScore, humanFreedomScore, humanFreedomRank);
    }
}
