package com.inaal.rumahkost_api.services;

import com.inaal.rumahkost_api.exception.NotFoundException;
import com.inaal.rumahkost_api.models.entity.Booking;
import com.inaal.rumahkost_api.models.entity.Report;
import com.inaal.rumahkost_api.repositories.ReportRepository;
import jakarta.persistence.NoResultException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ReportService {

    private ReportRepository reportRepository;

    @Autowired
    public ReportService(ReportRepository reportRepository) {
        this.reportRepository = reportRepository;
    }

    public List<Report> monthReport(Integer year, Integer month) throws Exception {
        try{
            try {
                List<Report> monthlyReports= reportRepository.reportMonthly(year, month);
                return monthlyReports;
            }catch (NoResultException e){
                throw new NotFoundException("Report Not Found");
            }
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }

   public void deleteReport(Integer year, Integer month) throws Exception {
        try{
            try {
                reportRepository.deleteMonthlyReports(year, month);
            }catch (NoResultException e){
                throw new NotFoundException("Report Not Found");
            }
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public Report findReportById(Long id) throws Exception {
        try{
            try {
                Report report = reportRepository.findReportById(id);
                return report;
            }catch (NoResultException e){
                throw new NotFoundException("Report Not Found");
            }
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
