package nagarro.training.ecommerce.services;

import java.util.List;

import nagarro.training.ecommerce.entities.Tshirt;

public interface SearchItemService {
	List<Tshirt> findTshirt(String color,String gender,String size);
}
