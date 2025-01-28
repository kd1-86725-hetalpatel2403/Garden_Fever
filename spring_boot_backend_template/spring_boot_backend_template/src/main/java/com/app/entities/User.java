package com.app.entities;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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
import lombok.Value;


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

    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private Set<Role> role = new HashSet<>();
    
    

    
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        List<SimpleGrantedAuthority> collect = this.role.stream()
//                .map(role -> new SimpleGrantedAuthority(role.getRoleName()))
//                .collect(Collectors.toList());
//
//        return collect;
//    }




//	@Override
//	public String getUsername() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//
//
//
//	@Override
//	public boolean isAccountNonExpired() {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//
//
//
//	@Override
//	public boolean isAccountNonLocked() {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//
//
//
//	@Override
//	public boolean isCredentialsNonExpired() {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//
//
//
//	@Override
//	public boolean isEnabled() {
//		// TODO Auto-generated method stub
//		return false;
//	}
//	

}
