package kbc.kbc_appointment_service.repository;

import kbc.kbc_appointment_service.constant.AppointmentStatus;
import kbc.kbc_appointment_service.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    List<Appointment> findByCustomerIdOrderByAppointmentAtDesc(Long customerId);
    List<Appointment> findByAdminId(Long adminId);
    List<Appointment> findByStatus(AppointmentStatus status);
}
