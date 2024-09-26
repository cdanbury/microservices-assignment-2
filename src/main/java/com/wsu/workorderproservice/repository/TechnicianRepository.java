package com.wsu.workorderproservice.repository;

import com.wsu.workorderproservice.model.Technician;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TechnicianRepository extends JpaRepository<Technician, Integer> {

    @Query(nativeQuery = true, value = "SELECT t.technician_code AS technicianCode, t.technician_first_name AS firstName, "
        + "t.technician_last_name AS lastName, wos.work_order_status_desc AS latestWorkOrderStatus "
        + "FROM technician t LEFT JOIN work_order wo ON wo.work_order_number = "
        + "(SELECT MAX(wo1.work_order_number) FROM work_order wo1 WHERE wo1.technician_code = t.technician_code) "
        + "LEFT JOIN work_order_status wos ON wo.work_order_status_code = wos.work_order_status_code "
        + "WHERE (:search IS NULL OR t.technician_code LIKE %:search% OR t.technician_first_name LIKE %:search% "
        + "OR t.technician_last_name LIKE %:search% OR wos.work_order_status_desc LIKE %:search%)")
    Page<Object[]> findBySearch(@Param("search")String search, Pageable pageable);
}
