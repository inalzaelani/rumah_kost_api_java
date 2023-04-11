package com.inaal.rumahkost_api.repositories;

import com.inaal.rumahkost_api.models.entity.Report;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class ReportRepository {
    @PersistenceContext
    private EntityManager entityManager;
    public List<Report> reportMonthly(Integer year, Integer month) {
        String sql = "SELECT \n" +
                "ROW_NUMBER() OVER() as id, \n" +
                "    m_kost.id AS kost_id, \n" +
                "    m_kost.name AS kost_name, \n" +
                "    EXTRACT(MONTH FROM t_booking.start_date) AS month,\n" +
                "    EXTRACT(YEAR FROM t_booking.start_date) AS year,\n" +
                "    COUNT(t_booking.id) AS jumlah_booking,\n" +
                "    m_kost.price * COUNT(t_booking.id) AS total\n" +
                "FROM \n" +
                "    m_kost \n" +
                "    JOIN t_booking ON m_kost.id = t_booking.kost_id \n" +
                "    JOIN m_user ON t_booking.user_id = m_user.id\n" +
                "WHERE \n" +
                "    EXTRACT(YEAR FROM t_booking.start_date) = :year AND \n" +
                "    EXTRACT(MONTH FROM t_booking.start_date) = :month \n" +
                "GROUP BY \n" +
                "    m_kost.id, \n" +
                "    m_kost.name, \n" +
                "    EXTRACT(MONTH FROM t_booking.start_date),\n" +
                "\tEXTRACT(YEAR FROM t_booking.start_date)\n" +
                "ORDER BY \n" +
                "    m_kost.name ASC";


        List<Report> monthlyReports = entityManager.createNativeQuery(sql, Report.class)
                .setParameter("year", year)
                .setParameter("month", month)
                .getResultList();

        saveMonthlyReports(monthlyReports);

        return monthlyReports;
    }


    public void saveMonthlyReports(List<Report> monthlyReports) {
        for (Report report : monthlyReports) {
            String sql = "INSERT INTO v_report (kost_id, kost_name, month, year, jumlah_booking, total) " +
                    "VALUES (:kostId, :kostName, :month, :year, :jumlahBooking, :total)";
            Query query = entityManager.createNativeQuery(sql);
            query.setParameter("kostId", report.getKost().getId());
            query.setParameter("kostName", report.getKostName());
            query.setParameter("month", report.getMonth());
            query.setParameter("year", report.getYear());
            query.setParameter("jumlahBooking", report.getJumlahBooking());
            query.setParameter("total", report.getTotal());
            query.executeUpdate();
        }
    }
}
