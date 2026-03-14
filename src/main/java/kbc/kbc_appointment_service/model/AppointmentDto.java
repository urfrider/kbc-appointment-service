package kbc.kbc_appointment_service.model;

import kbc.kbc_appointment_service.constant.AppointmentStatus;
import kbc.kbc_appointment_service.entity.Appointment;
import lombok.Builder;
import lombok.Data;

import java.time.OffsetDateTime;

@Data
@Builder
public class AppointmentDto {
    private Long id;
    private Long customerId;
    private Integer serviceId;
    private Long adminId;
    private OffsetDateTime appointmentAt;
    private AppointmentStatus status;
    private String notes;
    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;
    private String createdBy;
    private String updatedBy;

    public static AppointmentDto from(Appointment appointment) {
        if (appointment == null) return null;
        return AppointmentDto.builder()
                .id(appointment.getId())
                .customerId(appointment.getCustomerId())
                .serviceId(appointment.getServiceId())
                .adminId(appointment.getAdminId())
                .appointmentAt(appointment.getAppointmentAt())
                .status(appointment.getStatus())
                .notes(appointment.getNotes())
                .createdAt(appointment.getCreatedAt())
                .updatedAt(appointment.getUpdatedAt())
                .createdBy(appointment.getCreatedBy())
                .updatedBy(appointment.getUpdatedBy())
                .build();
    }
}
