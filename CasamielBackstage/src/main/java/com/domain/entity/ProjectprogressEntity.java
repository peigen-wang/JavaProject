package com.domain.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "projectprogress", schema = "camielbackage")
public class ProjectprogressEntity {
    private int id;
    private int avgCount;
    private int allCount;
    private BigDecimal avgAmount;
    private BigDecimal donationAmount;
    private BigDecimal allDonation;

    @Id
    @Column(name = "Id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "AvgCount")
    public int getAvgCount() {
        return avgCount;
    }

    public void setAvgCount(int avgCount) {
        this.avgCount = avgCount;
    }

    @Basic
    @Column(name = "AllCount")
    public int getAllCount() {
        return allCount;
    }

    public void setAllCount(int allCount) {
        this.allCount = allCount;
    }

    @Basic
    @Column(name = "AvgAmount")
    public BigDecimal getAvgAmount() {
        return avgAmount;
    }

    public void setAvgAmount(BigDecimal avgAmount) {
        this.avgAmount = avgAmount;
    }

    @Basic
    @Column(name = "DonationAmount")
    public BigDecimal getDonationAmount() {
        return donationAmount;
    }

    public void setDonationAmount(BigDecimal donationAmount) {
        this.donationAmount = donationAmount;
    }

    @Basic
    @Column(name = "AllDonation")
    public BigDecimal getAllDonation() {
        return allDonation;
    }

    public void setAllDonation(BigDecimal allDonation) {
        this.allDonation = allDonation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ProjectprogressEntity that = (ProjectprogressEntity) o;
        return id == that.id &&
                avgCount == that.avgCount &&
                allCount == that.allCount &&
                Objects.equals(avgAmount, that.avgAmount) &&
                Objects.equals(donationAmount, that.donationAmount) &&
                Objects.equals(allDonation, that.allDonation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, avgCount, allCount, avgAmount, donationAmount, allDonation);
    }
}
