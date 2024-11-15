package ma.youcode.wrm.mappers;

import ma.youcode.wrm.common.BaseMapper;
import ma.youcode.wrm.dto.request.waitingList.WaitingListCreateDTO;
import ma.youcode.wrm.dto.request.waitingList.WaitingListUpdateDTO;
import ma.youcode.wrm.dto.response.waitingList.WaitingListEmbeddedDTO;
import ma.youcode.wrm.dto.response.waitingList.WaitingListResponseDTO;
import ma.youcode.wrm.entities.WaitingList;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface WaitingListMapper extends BaseMapper<WaitingList, WaitingListResponseDTO, WaitingListEmbeddedDTO,WaitingListCreateDTO, WaitingListUpdateDTO> {


}
