package com.dheeraja.leavemanagement.controller;

import com.dheeraja.leavemanagement.model.LeaveRequest;
import com.dheeraja.leavemanagement.service.LeaveRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/leaves")
@CrossOrigin
public class LeaveRequestController {

    @Autowired
    private LeaveRequestService leaveRequestService;

    @PostMapping("/apply")
    public LeaveRequest applyLeave(@RequestBody LeaveRequest request) {
        return leaveRequestService.applyLeave(request);
    }

    @GetMapping("/all")
    public List<LeaveRequest> getAll() {
        return leaveRequestService.getAllLeaveRequests();
    }

    @GetMapping("/user/{userId}")
    public List<LeaveRequest> getByUser(@PathVariable String userId) {
        return leaveRequestService.getLeavesByUser(userId);
    }

    @PutMapping("/update/{id}")
    public LeaveRequest updateStatus(@PathVariable Long id, @RequestParam String status) {
        return leaveRequestService.updateLeaveStatus(id, status);
    }

    @GetMapping("/latest-status/{userId}") // 🔔 New endpoint
    public LeaveRequest getLatestStatus(@PathVariable String userId) {
        return leaveRequestService.getLatestLeaveByUser(userId);
    }
}
