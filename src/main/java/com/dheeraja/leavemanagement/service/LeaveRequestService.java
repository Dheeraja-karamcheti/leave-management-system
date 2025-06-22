package com.dheeraja.leavemanagement.service;

import com.dheeraja.leavemanagement.model.LeaveRequest;

import java.util.List;

public interface LeaveRequestService {
    LeaveRequest applyLeave(LeaveRequest request);
    List<LeaveRequest> getAllLeaveRequests();
    List<LeaveRequest> getLeavesByUser(String userId);
    LeaveRequest updateLeaveStatus(Long id, String status);
    LeaveRequest getLatestLeaveByUser(String userId); // 🔔 Added
}
