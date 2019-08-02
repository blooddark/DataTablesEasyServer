package com.example.datatablesserver.dto.datatables;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DataTables 表格数据响应 DTO
 * @author Eddy
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DataTablesResponseDTO {
    private Object data;
    private String draw;
    private Integer recordsFiltered;
    private Integer recordsTotal;
}
