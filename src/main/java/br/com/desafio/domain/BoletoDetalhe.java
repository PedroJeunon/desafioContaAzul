package br.com.desafio.domain;

import java.util.Date;

public class BoletoDetalhe {

	private String id;
	private Date due_date;
	private int total_in_cents;
	private String customer;

	public BoletoDetalhe() {

	}

	/**
	 * @param id
	 * @param due_date
	 * @param total_in_cents
	 * @param customer
	 */
	public BoletoDetalhe(String id, Date due_date, int total_in_cents, String customer) {
		this.id = id;
		this.due_date = due_date;
		this.total_in_cents = total_in_cents;
		this.customer = customer;
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
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof BoletoDetalhe)) {
			return false;
		}
		BoletoDetalhe other = (BoletoDetalhe) obj;
		if (customer == null) {
			if (other.customer != null) {
				return false;
			}
		} else if (!customer.equals(other.customer)) {
			return false;
		}
		if (due_date == null) {
			if (other.due_date != null) {
				return false;
			}
		} else if (!due_date.equals(other.due_date)) {
			return false;
		}
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		if (total_in_cents != other.total_in_cents) {
			return false;
		}
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "BoletoDetalhe [id=" + id + ", due_date=" + due_date + ", total_in_cents=" + total_in_cents
				+ ", customer=" + customer + "]";
	}
}
