package com.blog.entity;
import java.util.*;
import jakarta.persistence.*;

@Entity
public class Bus {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String busName;
	
	@ManyToMany
	@JoinTable
	(
			name = "bus_stop",
			joinColumns=@JoinColumn(name = "bus_id"),
			inverseJoinColumns = @JoinColumn(name ="stop_id")
			)
	private List<Stop> stops = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBusName() {
		return busName;
	}

	public void setBusName(String busName) {
		this.busName = busName;
	}

	public List<Stop> getStops() {
		return stops;
	}

	public void setStops(List<Stop> stops) {
		this.stops = stops;
	}

	
	
}
