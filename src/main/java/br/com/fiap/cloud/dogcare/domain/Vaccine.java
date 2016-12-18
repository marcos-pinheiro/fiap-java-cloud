package br.com.fiap.cloud.dogcare.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity @Table(name = "vaccine")
@Data @AllArgsConstructor @EqualsAndHashCode
public class Vaccine {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonIgnore
	private int id;
	
	private String name;
	
	@ManyToOne(fetch = FetchType.EAGER) @JoinColumn(name = "dog_id")
	@JsonIgnore @JsonBackReference
	private Dog dog;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "vaccine_date")
	private Date date;
	
	public Vaccine() {
	}
}
