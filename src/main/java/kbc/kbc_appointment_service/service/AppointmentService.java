package kbc.kbc_appointment_service.service;

import kbc.kbc_appointment_service.entity.Appointment;
import kbc.kbc_appointment_service.model.AppointmentDto;
import kbc.kbc_appointment_service.model.CreateAppointmentRequest;
import kbc.kbc_appointment_service.model.UpdateAppointmentRequest;
import kbc.kbc_appointment_service.repository.AppointmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;

    @Transactional
    public AppointmentDto createAppointment(CreateAppointmentRequest request) {
        Appointment appointment = Appointment.builder()
                .customerId(request.getCustomerId())
                .serviceId(request.getServiceId())
                .adminId(request.getAdminId())
                .appointmentAt(request.getAppointmentAt())
                .notes(request.getNotes())
                .build();
        return AppointmentDto.from(appointmentRepository.save(appointment));
    }

    public List<AppointmentDto> getAllAppointments() {
        return appointmentRepository.findAll().stream()
                .map(AppointmentDto::from)
                .collect(Collectors.toList());
    }

    public AppointmentDto getAppointmentById(Long id) {
        Appointment appointment = appointmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Appointment not found with id: " + id));
        return AppointmentDto.from(appointment);
    }

    public List<AppointmentDto> getAppointmentsByCustomerId(Long customerId) {
        return appointmentRepository.findByCustomerIdOrderByAppointmentAtDesc(customerId).stream()
                .map(AppointmentDto::from)
                .collect(Collectors.toList());
    }

    @Transactional
    public AppointmentDto updateAppointment(Long id, UpdateAppointmentRequest request) {
        Appointment appointment = appointmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Appointment not found with id: " + id));

        if (request.getAdminId() != null) appointment.setAdminId(request.getAdminId());
        if (request.getAppointmentAt() != null) appointment.setAppointmentAt(request.getAppointmentAt());
        if (request.getStatus() != null) appointment.setStatus(request.getStatus());
        if (request.getNotes() != null) appointment.setNotes(request.getNotes());

        return AppointmentDto.from(appointmentRepository.save(appointment));
    }

    @Transactional
    public void deleteAppointment(Long id) {
        if (!appointmentRepository.existsById(id)) {
            throw new RuntimeException("Appointment not found with id: " + id);
        }
        appointmentRepository.deleteById(id);
    }
}
