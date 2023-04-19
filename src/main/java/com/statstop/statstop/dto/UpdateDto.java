package com.statstop.statstop.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateDto {
    private Integer gameId;
    private Integer runScored;
    private Integer wicket;
    private Integer firstInnings;
}
