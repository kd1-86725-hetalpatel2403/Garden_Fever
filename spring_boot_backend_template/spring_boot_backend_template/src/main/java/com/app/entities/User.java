package com.app.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "user_info")
@Getter
@Setter
public class User{
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int userId;
	
	@Column(nullable = false)
    private String name;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String about;

    @Column(nullable = false)
    private String gender;

    @Column(nullable = false)
    private String phone;
    
    
    @Column(name = "CreateAt",nullable = false)
    private Date date;

    private boolean active;

    @OneToOne(mappedBy = "user")
    private Cart cart;

    private Role role;
    
    
    

    
}