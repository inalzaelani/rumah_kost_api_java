package com.inaal.rumahkost_api.controllers;

import com.inaal.rumahkost_api.models.entity.Booking;
import com.inaal.rumahkost_api.models.entity.Report;
import com.inaal.rumahkost_api.models.response.SuccessResponse;
import com.inaal.rumahkost_api.services.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/report")
public class ReportController {
    private ReportService reportService;

    @Autowired
    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @GetMapping("/monthly-report/{year}/{month}")
    public ResponseEntity getMonthlyReport(@PathVariable Integer year, @PathVariable Integer month) throws Exception {
        List<Report> monthlyReports = reportService.monthReport(year, month);
        return ResponseEntity.status(HttpStatus.OK).body(new SuccessResponse("Success", monthlyReports));
    }
    @GetMapping("/find-report/{id}")
    private ResponseEntity findReport(@PathVariable Long id) throws Exception {
        Report reports = reportService.findReportById(id);
        return ResponseEntity.status(HttpStatus.OK).body(new SuccessResponse("Success", reports));
    }

    @DeleteMapping("/delete-report/{year}/{month}")
    private ResponseEntity deleteReport(@PathVariable Integer year, @PathVariable Integer month) throws Exception {
        reportService.deleteReport(year, month);
        return ResponseEntity.status(HttpStatus.OK).body(new SuccessResponse("Success", "Report Deleted"));
    }
}
