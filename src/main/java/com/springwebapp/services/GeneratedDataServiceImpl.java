package com.springwebapp.services;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.springwebapp.domain.GeneratedData;
import com.springwebapp.repositories.GeneratedDataRepository;

public class GeneratedDataServiceImpl implements GeneratedDataService{

	private GeneratedDataRepository generatedDataRepository;
	
	private JdbcTemplate jdbcTemplate;
	
	public GeneratedDataServiceImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public GeneratedDataServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Autowired
	public void setGeneratedDataRepository(GeneratedDataRepository generatedDataRepository)
	{
		this.generatedDataRepository = generatedDataRepository;
	}
	
	@Override
	public List<GeneratedData> listAllGeneratedData() {
		return (List<GeneratedData>) generatedDataRepository.findAll();
	}

	@Override
	public GeneratedData getGeneratedDataBySeqNum(Long id) {
		return generatedDataRepository.findOne(id);
	}

	@Override
	public void saveGeneratedData(GeneratedData data) {
		 if (data.getSeqNum() > 0) {
		        // update
		        String sql = "UPDATE GENERATED_DATA SET username=?, purpose=?, date=? "
		                    + "WHERE seqNum=?";
		        jdbcTemplate.update(sql, data.getUsername(), data.getPurpose(), data.getDate(), data.getSeqNum());
		    } else {
		        // insert
		        String sql = "INSERT INTO GENERATED_DATA (username, purpose, date)"
		                    + " VALUES (?, ?, ?)";
		        jdbcTemplate.update(sql, data.getUsername(), data.getPurpose(),
		                data.getDate());
		    }
		 
	}

	@Override
	public void deleteGeneratedData(Long id) {
		generatedDataRepository.delete(id);
	}
	
}
