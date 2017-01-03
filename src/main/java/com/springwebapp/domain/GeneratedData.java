package com.springwebapp.domain;



import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.Max;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Type;

@Entity
@Table(name="GENERATED_DATA")
public class GeneratedData {
	
	@Column(name="DATE")
	@Type(type = "java.time.LocalDateTime")
	private LocalDateTime date;

	@Column(name="PURPOSE")
	@Size(min=1, message="Can not be left empty.")
	private String purpose;

	@Column(name="USERNAME")
	private String username;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="SEQ_NUM")
	private Long seqNum;
	
	@Column(name="NEXT_SEQ_NUM")
	private Long nextSeqNum;
	
	@Version
	@Max(0)
	@Column(name="VERSION")
	private Integer version;
	
	public Integer getVersion() {
		return version;
	}

	public Long getNextSeqNum() {
		return nextSeqNum;
	}

	public void setNextSeqNum(Long nextSeqNum) {
		this.nextSeqNum = nextSeqNum;
	}

	public GeneratedData()
	{
		this.date = LocalDateTime.now();
	}
	
	public GeneratedData(LocalDateTime date, String purpose, String username)
	{
		this.date = date;
		this.purpose = purpose;
		this.username = username;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public String getPurpose() {
		return purpose;
	}

	public String getUsername() {
		return username;
	}

	public Long getSeqNum() {
		return seqNum;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public void setPurpose(String description) {
		this.purpose = description;
	}


	@JoinTable(name = "users", joinColumns = @JoinColumn(name = "username"), inverseJoinColumns = @JoinColumn(name = "username"))
	public void setUsername(String username) {
		this.username = username;
	}

}