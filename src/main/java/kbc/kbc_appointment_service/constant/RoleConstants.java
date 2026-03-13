package kbc.kbc_appointment_service.constant;

public class RoleConstants {
    public static final String ADMIN = "ADMIN";
    public static final String SUPER_ADMIN = "SUPER_ADMIN";

    // For @PreAuthorize
    public static final String ROLE_ADMIN = "hasRole('ADMIN')";
    public static final String ROLE_SUPER_ADMIN = "hasRole('SUPER_ADMIN')";
    public static final String ROLE_ADMIN_OR_SUPER = "hasAnyRole('ADMIN', 'SUPER_ADMIN')";
}
