package kbc.kbc_appointment_service.entity;

import kbc.kbc_appointment_service.constant.AppointmentStatus;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.OffsetDateTime;

@Entity
@Table(name = "appointment", schema = "appointment")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Appointment {

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
    private OffsetDateTime appointmentAt;

    @Enumerated(EnumType.STRING)
    @Builder.Default
    @Column(length = 20)
    private AppointmentStatus status = AppointmentStatus.SCHEDULED;

    @Column(columnDefinition = "TEXT")
    private String notes;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private OffsetDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private OffsetDateTime updatedAt;
}
