package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "ow_user")
@Data
public class UserEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator = "userid_seq")
	@SequenceGenerator(name = "userid_seq", sequenceName = "userid_seq", allocationSize = 1)
	private int id;

	private String name;

	private String email;

	private String password;
}
