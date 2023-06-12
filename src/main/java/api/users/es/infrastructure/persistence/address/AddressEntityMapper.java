package api.users.es.infrastructure.persistence.address;

import org.springframework.stereotype.Component;

import api.users.es.domain.model.address.Address;

@Component
public class AddressEntityMapper {
	
	public Address toModel(AddressEntity entity) {
		return Address.of(entity.getId(), entity.getStreet(), entity.getState(), entity.getCity(), entity.getCountry(), entity.getZip());
	}
	
	public AddressEntity toEntity(Address model) {
		AddressEntity entity = AddressEntity.of();
		entity.setStreet(model.getStreet());
		entity.setState(model.getState());
		entity.setCity(model.getCity());
		entity.setCountry(model.getCountry());
		entity.setZip(model.getZip());
		return entity;
	}
}