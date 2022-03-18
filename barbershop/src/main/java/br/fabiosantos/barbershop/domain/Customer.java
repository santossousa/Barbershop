package br.fabiosantos.barbershop.domain;

import br.fabiosantos.barbershop.domain.Customer;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@EqualsAndHashCode
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString(exclude = {"phone"})
public class Customer {

    private  String name;
    private  String email;
    private  String phone;
    public Customer(String name, String email, String phone) {
		this.name = name;
		this.email = email;
		this.phone = phone;
	}
	public static Customer of(String name, String email, String phone) {
        return new Customer(name, email, phone);
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public static class Builder{
		private  String name;
	    private  String email;
	    private  String phone;
	    public Builder name(String name) {
	    	this.name = name;
	    	return this;
	    }
	    public Builder email(String email) {
	    	this.email = email;
	    	return this;
	    }
	    public Builder phone(String phone) {
	    	this.phone = phone;
	    	return this;
	    }
	    public Customer build() {
	    	return new Customer(name, email, phone);
	    }
	    
		
	}
	public static Builder builder() {
		return new Builder();
	}
	
}
