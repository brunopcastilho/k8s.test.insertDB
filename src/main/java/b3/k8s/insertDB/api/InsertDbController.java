package b3.k8s.insertDB.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.b3.k8s.sboot.insert.gen.api.InsertLogApi;
import com.b3.k8s.sboot.insert.gen.model.ApiModelRequest;
import com.b3.k8s.sboot.insert.gen.model.ApiModelResponse;

import b3.k8s.insertDB.service.InsertDbService;

@RestController
public class InsertDbController implements InsertLogApi{

	@Autowired
	InsertDbService service;
	
	
	
	@Override
	public ResponseEntity<ApiModelResponse> insertLog(ApiModelRequest insertDb) {
		ApiModelResponse response = service.insertLog(insertDb.getMessage());
		return new ResponseEntity<ApiModelResponse>(response, HttpStatus.OK);
		
		
	}

}
