package ma.youcode.wrm.mappers;

import ma.youcode.wrm.common.BaseMapper;
import ma.youcode.wrm.dto.request.visit.VisitCreateDTO;
import ma.youcode.wrm.dto.request.visit.VisitUpdateDTO;
import ma.youcode.wrm.dto.response.visit.VisitEmbeddedDTO;
import ma.youcode.wrm.dto.response.visit.VisitResponseDTO;
import ma.youcode.wrm.entities.Visit;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface VisitMapper extends BaseMapper<Visit, VisitResponseDTO, VisitEmbeddedDTO, VisitCreateDTO , VisitUpdateDTO> {}
