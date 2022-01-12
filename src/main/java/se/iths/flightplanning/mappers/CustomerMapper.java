package se.iths.flightplanning.mappers;

import org.springframework.stereotype.Component;
import se.iths.flightplanning.dto.CustomerDto;
import se.iths.flightplanning.entity.CustomerEntity;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class CustomerMapper {
    public CustomerMapper() {
    }

    public CustomerDto mapp(CustomerEntity customerEntity) {
        return new CustomerDto(customerEntity.getFirstName(),
                customerEntity.getLastName(),
                customerEntity.getEmail(),
                customerEntity.getTelephone(),
                customerEntity.getUsername(),
                customerEntity.getPassword());
    }

    public CustomerEntity mapp(CustomerDto customerDto) {
        return new CustomerEntity(
                customerDto.getFirstName(),
                customerDto.getLastName(),
                customerDto.getEmail(),
                customerDto.getTelephone(),
                customerDto.getUsername(),
                customerDto.getPassword());
    }

    public Optional<CustomerDto> mapp(Optional<CustomerEntity> optionalCustomerEntity) {
        if(optionalCustomerEntity.isEmpty())
            return Optional.empty();
        return Optional.of(mapp(optionalCustomerEntity.get()));
    }

    public List<CustomerDto> mapp(List<CustomerEntity> all) {
        return all
                .stream()
                .map(this::mapp)
                .collect(Collectors.toList());
    }
}
