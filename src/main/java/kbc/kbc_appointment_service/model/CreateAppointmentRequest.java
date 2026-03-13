package kbc.kbc_appointment_service.model;

import lombok.Data;
import java.time.OffsetDateTime;

@Data
public class CreateAppointmentRequest {
    private Long customerId;
    private Integer serviceId;
    private Long adminId;
    private OffsetDateTime appointmentAt;
    private String notes;
}
