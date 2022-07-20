package b3.k8s.insertDB.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.b3.k8s.sboot.insert.gen.model.ApiModelResponse;

import b3.k8s.insertDB.repository.InsertDbRepository;

@Service
public class InsertDbService {

	@Autowired
	InsertDbRepository repository;
	
	public ApiModelResponse insertLog(String message) {
	
			return repository.insertLog(message);
		

		}
	
}
