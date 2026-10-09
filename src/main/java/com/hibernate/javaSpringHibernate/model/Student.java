package com.hibernate.javaSpringHibernate.model;


import com.hibernate.javaSpringHibernate.config.StudentStatsEnum;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Set;

@Entity
@Table(name = "student_table")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(
            name = "student_fname",
            nullable = false,
            length = 100
    )
    private String name;

    @Column(
            unique = true,
            nullable = false,
            length = 100,
            insertable = true,
            updatable = true
    )
    private String email;

    @Column(
            nullable = false
    )
    private int age;

    @Column(
            name = "student_salary",
            nullable = false,
            precision = 5,
            scale = 2
    )
    private BigDecimal persantage;

    private LocalTime dateOfBirth;

    private LocalDateTime createdAt;

    @Enumerated(EnumType.STRING)
    private StudentStatsEnum status;

//    @Column(
//            nullable = false,
//            length = 100
//    )
    @Lob
    private String profileDescription;

//    @Transient // Meaning of this command is the field will not be mapped to the database means not stored in the database
    @Transient
    private String displayName;

    private boolean isMonitored;

//    @ElementCollection
//    @CollectionTable(
//            name = "student_skills",
//            joinColumns = @JoinColumn(name = "student_id")
//    )
    @ElementCollection
    @CollectionTable(
            name = "student_skill",
            joinColumns = @JoinColumn(name = "student_id")
    )
    private Set<String> skills;

    @ElementCollection
    @CollectionTable(
            name = "student_address",
            joinColumns = @JoinColumn(name = "student_id")
    )
    private Set<Address> addresses;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "street", column = @Column(name = "current_street")),
            @AttributeOverride(name = "city", column = @Column(name = "current_city")),
            @AttributeOverride(name = "state", column = @Column(name = "current_state")),
            @AttributeOverride(name = "country", column = @Column(name = "current_country")),
            @AttributeOverride(name = "zipCode", column = @Column(name = "current_zipCode"))
    })
    private Address currentAddress;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "street", column = @Column(name = "permanent_street")),
            @AttributeOverride(name = "city", column = @Column(name = "permanent_city")),
            @AttributeOverride(name = "state", column = @Column(name = "permanent_state")),
            @AttributeOverride(name = "country", column = @Column(name = "permanent_country")),
            @AttributeOverride(name = "zipCode", column = @Column(name = "permanent_zipCode"))
    })
    private Address permanentAddress;


    public Student() {
    }

    public Student(Long id, String name, String email, int age, BigDecimal persantage, LocalTime dateOfBirth, LocalDateTime createdAt, StudentStatsEnum status, String profileDescription, String displayName, boolean isMonitored) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.age = age;
        this.persantage = persantage;
        this.dateOfBirth = dateOfBirth;
        this.createdAt = createdAt;
        this.status = status;
        this.profileDescription = profileDescription;
        this.displayName = displayName;
        this.isMonitored = isMonitored;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public BigDecimal getPersantage() {
        return persantage;
    }

    public void setPersantage(BigDecimal persantage) {
        this.persantage = persantage;
    }

    public LocalTime getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalTime dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public StudentStatsEnum getStatus() {
        return status;
    }

    public void setStatus(StudentStatsEnum status) {
        this.status = status;
    }

    public String getProfileDescription() {
        return profileDescription;
    }

    public void setProfileDescription(String profileDescription) {
        this.profileDescription = profileDescription;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public boolean isMonitored() {
        return isMonitored;
    }

    public void setMonitored(boolean monitored) {
        isMonitored = monitored;
    }
}
