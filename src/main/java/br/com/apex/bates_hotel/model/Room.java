package br.com.apex.bates_hotel.model;

import java.math.BigDecimal;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Room {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "room_id")
	private Integer id;
	private Integer number;
	@Column(scale = 2)
	private BigDecimal dailyValue;
	private RoomType type;
	@OneToMany(mappedBy = "room", cascade = CascadeType.ALL)
	private Set<Booking> bookings;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public BigDecimal getDailyValue() {
		return dailyValue;
	}

	public void setDailyValue(BigDecimal dailyValue) {
		this.dailyValue = dailyValue;
	}

	public RoomType getType() {
		return type;
	}

	public void setType(RoomType type) {
		this.type = type;
	}

	public Set<Booking> getBookings() {
		return bookings;
	}

	public void setBookings(Set<Booking> bookings) {
		this.bookings = bookings;
	}

	@Override
	public String toString() {
		return "Room [id=" + id + ", number=" + number + ", dailyValue=" + dailyValue + ", type=" + type + "]";
	}

}
