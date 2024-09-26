package com.wsu.workorderproservice.service;

import com.wsu.workorderproservice.dto.TechnicianDTO;
import com.wsu.workorderproservice.model.Technician;
import com.wsu.workorderproservice.repository.TechnicianRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import static com.wsu.workorderproservice.utilities.CommonUtils.sort;

@Service
@RequiredArgsConstructor
public class TechnicianService {

    private final TechnicianRepository technicianRepository;

      /**
     * Retrieves a list of all technicians with optional filter parameters.
     * @param search - allows for type ahead search by technician firstname, lastname, workOrderStatus, or technicianCode.
     * @param sortField - field used for sorting result. Default value is descending.
     * @param sortOrder - specifies order for the returned result
     * @param page - specifies which page number to return
     * @param rpp - specifies how many results to return per page.
     * @return - Returns Page<TechnicianDTO> mapped from the Page<Object[]> returned by the database.
     */
    public Page<TechnicianDTO> getAllTechnicians(String search, String sortField, String sortOrder, Integer page, Integer rpp) {
        Page<Object[]> technicians = technicianRepository.findBySearch(search, PageRequest.of(page-1, rpp, sort(sortField, sortOrder)));
        return technicians.map(technician -> TechnicianDTO.builder().technicianCode((String)technician[0])
                .technicianFirstName((String)technician[1]).technicianLastName((String)technician[2])
                .latestWorkOrderStatus((String)technician[3]).build());
    }


    private TechnicianDTO mapToDto(Technician technician) {
        return  technician != null ? TechnicianDTO.builder().technicianCode(technician.getTechnicianCode())
                .technicianFirstName(technician.getTechnicianFirstName())
                .technicianLastName(technician.getTechnicianLastName()).build() : null;
    }

}
