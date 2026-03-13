package kbc.kbc_appointment_service.controller;

import kbc.common.constant.RoleConstants;
import kbc.kbc_appointment_service.model.AppointmentDto;
import kbc.kbc_appointment_service.model.CreateAppointmentRequest;
import kbc.kbc_appointment_service.model.UpdateAppointmentRequest;
import kbc.kbc_appointment_service.service.AppointmentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/appointments")
@RequiredArgsConstructor
@Slf4j
public class AppointmentController {

    private final AppointmentService appointmentService;

    @PostMapping
    @PreAuthorize(RoleConstants.ROLE_ADMIN_OR_SUPER)
    public ResponseEntity<AppointmentDto> createAppointment(@RequestBody CreateAppointmentRequest request) {
        log.info("Request to create appointment for customer id: {}", request.getCustomerId());
        return ResponseEntity.ok(appointmentService.createAppointment(request));
    }

    @GetMapping
    @PreAuthorize(RoleConstants.ROLE_ADMIN_OR_SUPER)
    public ResponseEntity<List<AppointmentDto>> getAllAppointments() {
        log.info("Request to get all appointments");
        return ResponseEntity.ok(appointmentService.getAllAppointments());
    }

    @GetMapping("/{id}")
    @PreAuthorize(RoleConstants.ROLE_ADMIN_OR_SUPER)
    public ResponseEntity<AppointmentDto> getAppointmentById(@PathVariable Long id) {
        log.info("Request to get appointment by id: {}", id);
        return ResponseEntity.ok(appointmentService.getAppointmentById(id));
    }

    @GetMapping("/customer/{customerId}")
    @PreAuthorize(RoleConstants.ROLE_ADMIN_OR_SUPER)
    public ResponseEntity<List<AppointmentDto>> getAppointmentsByCustomerId(@PathVariable Long customerId) {
        log.info("Request to get appointments for customer id: {}", customerId);
        return ResponseEntity.ok(appointmentService.getAppointmentsByCustomerId(customerId));
    }

    @PutMapping("/{id}")
    @PreAuthorize(RoleConstants.ROLE_ADMIN_OR_SUPER)
    public ResponseEntity<AppointmentDto> updateAppointment(@PathVariable Long id, @RequestBody UpdateAppointmentRequest request) {
        log.info("Request to update appointment id: {}", id);
        return ResponseEntity.ok(appointmentService.updateAppointment(id, request));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize(RoleConstants.ROLE_SUPER_ADMIN)
    public ResponseEntity<Void> deleteAppointment(@PathVariable Long id) {
        log.info("Request to delete appointment id: {}", id);
        appointmentService.deleteAppointment(id);
        return ResponseEntity.noContent().build();
    }
}
