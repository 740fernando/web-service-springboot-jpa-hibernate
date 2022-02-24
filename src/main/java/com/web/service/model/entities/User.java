package com.web.service.model.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_user")
public class User implements Serializable{
	
	/**
	 * Serializable -Essa interface é definida para que seja possível transformar o objeto em cadeia de bytes
	 * É importante converter o objeto em cadeia de bytes para seguintes finalidades:
	 * - Tráfego na rede;
	 * - Gravado em arquivos
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //auto incremento do atributo id
	private Long Id;
	private String name;
	private String email;
	private String phone;
	private String password;
	
	@JsonIgnore // para evitar associação de mão dupla(looping infinito onde user chamar order e order chamar user) obs: pode ser colocado em qualqer lado ( order ou user)
	@OneToMany(mappedBy = "client") // Esse muitos para um está mapeado pelo atributo client da classe Order
	private List<Order> order = new ArrayList<>();
	
	public User() {
		
	}

	public User(Long id, String name, String email, String phone, String password) {
		super();
		this.Id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.password = password;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		this.Id = id;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Order> getOrder() {
		return order;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(Id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(Id, other.Id);
	}


}
