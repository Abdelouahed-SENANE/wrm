package ma.youcode.wrm.mappers;

import ma.youcode.wrm.common.BaseMapper;
import ma.youcode.wrm.dto.request.visitor.VisitorCreateDTO;
import ma.youcode.wrm.dto.request.visitor.VisitorUpdateDTO;
import ma.youcode.wrm.dto.response.visitor.VisitorEmbeddedDTO;
import ma.youcode.wrm.dto.response.visitor.VisitorResponseDTO;
import ma.youcode.wrm.entities.Visitor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface VisitorMapper extends BaseMapper<Visitor, VisitorResponseDTO, VisitorEmbeddedDTO, VisitorCreateDTO , VisitorUpdateDTO> {

}
