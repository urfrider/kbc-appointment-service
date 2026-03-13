package kbc.kbc_appointment_service.model;

import kbc.kbc_appointment_service.constant.AppointmentStatus;
import lombok.Data;
import java.time.OffsetDateTime;

@Data
public class UpdateAppointmentRequest {
    private Long adminId;
    private OffsetDateTime appointmentAt;
    private AppointmentStatus status;
    private String notes;
}
