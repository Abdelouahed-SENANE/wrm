package ma.youcode.wrm.mapper;

import ma.youcode.wrm.dto.request.WaitingListRequestDTO;
import ma.youcode.wrm.dto.response.WaitingListResponseDTO;
import ma.youcode.wrm.entities.WaitingList;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface WaitingListMapper {
    WaitingListResponseDTO toResponseDTO(WaitingList waitingList);
    WaitingList toEntity(WaitingListRequestDTO dto);


}
