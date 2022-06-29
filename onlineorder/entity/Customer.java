package com.alyssa.onlineorder.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "customers")
public class Customer implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private String email;

    private String firstName;

    private String lastName;

    private String password;

    private boolean enabled;

    @OneToOne(cascade = CascadeType.ALL) //1:1 / 1:N  删了这张表里面的记录，关联表中对应的记录也会自动删除
    @JoinColumn(unique = true)  //1:1
    private Cart cart;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return  enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }
}

