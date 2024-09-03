package ait.shop.service.mapping;


import ait.shop.model.dto.ProductDTO;
import ait.shop.model.dto.UserRegisterDto;
import ait.shop.model.entity.Product;
import ait.shop.model.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMappingService {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "userName", source = "username")
    User mapDtoToEntity(UserRegisterDto dto);

}