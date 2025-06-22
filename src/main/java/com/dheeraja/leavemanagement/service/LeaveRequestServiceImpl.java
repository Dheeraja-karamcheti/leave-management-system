package com.dheeraja.leavemanagement.service;

import com.dheeraja.leavemanagement.model.LeaveRequest;
import com.dheeraja.leavemanagement.repository.LeaveRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeaveRequestServiceImpl implements LeaveRequestService {

    @Autowired
    private LeaveRequestRepository repository;

    @Override
    public LeaveRequest applyLeave(LeaveRequest request) {
        request.setStatus("PENDING");
        return repository.save(request);
    }

    @Override
    public List<LeaveRequest> getAllLeaveRequests() {
        return repository.findAll();
    }

    @Override
    public List<LeaveRequest> getLeavesByUser(String userId) {
        return repository.findByUserId(userId);
    }

    @Override
    public LeaveRequest updateLeaveStatus(Long id, String status) {
        LeaveRequest req = repository.findById(id).orElse(null);
        if (req != null) {
            req.setStatus(status);
            return repository.save(req);
        }
        return null;
    }

    @Override
    public LeaveRequest getLatestLeaveByUser(String userId) {
        return repository.findTopByUserIdOrderByIdDesc(userId); // 🔔 Logic to get latest
    }
}
