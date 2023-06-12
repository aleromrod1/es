package api.users.es.application.service.address;

import org.springframework.stereotype.Component;

import api.users.es.domain.model.address.Address;

@Component
public class AddressMapper {

	public AddressDTO toDTO(Address model) {
		return AddressDTO.of(model.getAddressId(), model.getStreet(), model.getState(), model.getCity(), model.getCountry(), model.getZip());
	}
	
	public Address toModel(AddressDTO dto) {
		return Address.of(dto.getId(), dto.getStreet(), dto.getState(), dto.getCity(), dto.getCountry(), dto.getZip());
	}
}