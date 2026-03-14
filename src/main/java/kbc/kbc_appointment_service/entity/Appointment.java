package kbc.kbc_appointment_service.entity;

import kbc.common.entity.BaseAuditEntity;
import kbc.kbc_appointment_service.constant.AppointmentStatus;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "appointment", schema = "appointment")
@Data
@EqualsAndHashCode(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Appointment extends BaseAuditEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "customer_id", nullable = false)
    private Long customerId;

    @Column(name = "service_id", nullable = false)
    private Integer serviceId;

    @Column(name = "admin_id")
    private Long adminId;

    @Column(name = "appointment_at", nullable = false)
    private java.time.OffsetDateTime appointmentAt;

    @Enumerated(EnumType.STRING)
    @Builder.Default
    @Column(length = 20)
    private AppointmentStatus status = AppointmentStatus.SCHEDULED;

    @Column(columnDefinition = "TEXT")
    private String notes;
}
