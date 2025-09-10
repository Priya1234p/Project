package com.blog.entity;

import java.util.*;

import jakarta.persistence.*;

@Entity
public class Stop {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String stopName;
    
    @ManyToMany(mappedBy = "stops")
    private List<Bus> buses = new ArrayList<>();
    
    

	public List<Bus> getBuses() {
		return buses;
	}

	public void setBuses(List<Bus> buses) {
		this.buses = buses;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStopName() {
		return stopName;
	}

	public void setStopName(String stopName) {
		this.stopName = stopName;
	}
    
    

}
