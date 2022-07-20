package b3.k8s.insertDB.repository;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.b3.k8s.sboot.insert.gen.model.ApiModelResponse;

@Repository
public class InsertDbRepository {

	NamedParameterJdbcTemplate jdbc;	
	
	@Autowired
	public InsertDbRepository(NamedParameterJdbcTemplate jdbc) {
		this.jdbc = jdbc;
	}
	
	public ApiModelResponse insertLog(String message) {
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		namedParameters.addValue("value", message);
		
		
		jdbc.update("INSERT INTO k8s.teste (dtLog , message) values (current_timestamp() , :value) ;", namedParameters, keyHolder);
		
		namedParameters = new MapSqlParameterSource();
		namedParameters.addValue("id", keyHolder.getKey());

		return jdbc.query("select * from k8s.teste where id = :id", namedParameters, new ApiModelResponseMapper()).get(0);


		
		
		
	}

	
	
}
