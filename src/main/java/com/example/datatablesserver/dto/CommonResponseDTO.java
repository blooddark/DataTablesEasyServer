package com.example.datatablesserver.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 通用响应 DTO
 * @author Eddy
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CommonResponseDTO {
    private Integer code;
    private String msg;
    private Object data;
}
