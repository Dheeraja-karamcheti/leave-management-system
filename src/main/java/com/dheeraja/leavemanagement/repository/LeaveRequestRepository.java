package com.dheeraja.leavemanagement.repository;

import com.dheeraja.leavemanagement.model.LeaveRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LeaveRequestRepository extends JpaRepository<LeaveRequest, Long> {
    List<LeaveRequest> findByUserId(String userId);
    LeaveRequest findTopByUserIdOrderByIdDesc(String userId); // 🔔 Added for latest leave
}
