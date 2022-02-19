package resource.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import resource.dao.ResourceDAOInterface;
import resource.model.Resource;
import resource.service.ResourceService;
import resource.service.ResourceServiceInterface;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class ResourceController {
	
	@Autowired
	private ResourceServiceInterface resourceServiceInterface;
	
	@Autowired
	private ResourceService r;
	
	@Autowired
	private ResourceDAOInterface rd;
	
	@GetMapping("/hello")
	public String print() {
		return "Hello";
	}
	
	@GetMapping("/Resource")
	public List<Resource> getAll()
	{
		return rd.findAll();
	}

	
	// http://localhost:777/gr/3
	@GetMapping("/Resource/{resourceId}")
	public Resource getResourceDetails(@PathVariable int resourceId) {
		
		return resourceServiceInterface.getResourceDetails(resourceId);
		
	}
	
	
	
	// erquest body somebody has to supply resource object.
	//as a json spring will convert that into java object
	@PostMapping("/Resource")
	public boolean addResource(@RequestBody Resource r) {
		
		
		return resourceServiceInterface.addResource(r); 
		
	}
	

}
