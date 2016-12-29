package com.springwebapp.domain;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="GENERATED_DATA")
public class GeneratedData {
	
	@Column(name="DATE")
	private Date date;

	@Column(name="PURPOSE")
	private String purpose;

	@Column(name="USERNAME")
	private String username;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="SEQ_NUM")
	private long seqNum;
	
	public GeneratedData()
	{
		
	}
	
	public GeneratedData(Date date, String purpose, String username)
	{
		this.date = date;
		this.purpose = purpose;
		this.username = username;
	}

	public Date getDate() {
		return date;
	}

	public String getPurpose() {
		return purpose;
	}

	public String getUsername() {
		return username;
	}

	public long getSeqNum() {
		return seqNum;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public void setPurpose(String description) {
		this.purpose = description;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}