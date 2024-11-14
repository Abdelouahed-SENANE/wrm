package ma.youcode.wrm.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record PageDTO(
        long totalElements,
        int totalPages,
        int size,
        int currentPage,
        boolean hasPrevious,
        boolean hasNext
) {}