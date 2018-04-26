package br.com.desafio.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Boleto {

	@Id
	private String id;
	@NotNull
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date due_date;
	@NotNull
	private int total_in_cents;
	@NotNull
	private String customer;
	@NotNull
	private String status;

	public Boleto() {

	}

	public Boleto(String id, Date due_date, int total_in_cents, String customer, String status) {
		this.id = id;
		this.due_date = due_date;
		this.total_in_cents = total_in_cents;
		this.customer = customer;
		this.status = status;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the due_date
	 */
	public Date getDue_date() {
		return due_date;
	}

	/**
	 * @param due_date
	 *            the due_date to set
	 */
	public void setDue_date(Date due_date) {
		this.due_date = due_date;
	}

	/**
	 * @return the total_in_cents
	 */
	public int getTotal_in_cents() {
		return total_in_cents;
	}

	/**
	 * @param total_in_cents
	 *            the total_in_cents to set
	 */
	public void setTotal_in_cents(int total_in_cents) {
		this.total_in_cents = total_in_cents;
	}

	/**
	 * @return the customer
	 */
	public String getCustomer() {
		return customer;
	}

	/**
	 * @param customer
	 *            the customer to set
	 */
	public void setCustomer(String customer) {
		this.customer = customer;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((customer == null) ? 0 : customer.hashCode());
		result = prime * result + ((due_date == null) ? 0 : due_date.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + total_in_cents;
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Boleto other = (Boleto) obj;
		if (customer == null) {
			if (other.customer != null)
				return false;
		} else if (!customer.equals(other.customer))
			return false;
		if (due_date == null) {
			if (other.due_date != null)
				return false;
		} else if (!due_date.equals(other.due_date))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (status != other.status)
			return false;
		if (total_in_cents != other.total_in_cents)
			return false;
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Boleto [id=" + id + ", due_date=" + due_date + ", total_in_cents=" + total_in_cents + ", customer="
				+ customer + ", status=" + status + "]";
	}

}
