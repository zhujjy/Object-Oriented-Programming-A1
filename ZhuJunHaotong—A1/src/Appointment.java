import java.util.regex.Pattern;

/**
 * 预约类
 * 处理患者的预约信息
 */
public class Appointment {
    // 实例变量
    private String patientName;
    private String patientMobile;
    private String timeSlot;
    private HealthProfessional doctor; // 使用基类类型，支持多态

    // 默认构造函数
    public Appointment() {
        this.patientName = "Unknown";
        this.patientMobile = "0000000000";
        this.timeSlot = "09:00";
        this.doctor = null;
    }

    // 带参数的构造函数
    public Appointment(String patientName, String patientMobile, String timeSlot, HealthProfessional doctor) {
        // 验证手机号格式（简单的格式检查）
        if (!isValidMobile(patientMobile)) {
            throw new IllegalArgumentException("Invalid mobile number format");
        }

        // 验证时间段格式
        if (!isValidTimeSlot(timeSlot)) {
            throw new IllegalArgumentException("Invalid time slot format. Use HH:MM format");
        }

        this.patientName = patientName;
        this.patientMobile = patientMobile;
        this.timeSlot = timeSlot;
        this.doctor = doctor;
    }

    // 验证手机号格式的方法
    private boolean isValidMobile(String mobile) {
        // 简单的手机号验证 - 实际应用中可能需要更复杂的验证
        return mobile != null && mobile.matches("\\d{10}");
    }

    // 验证时间段格式的方法
    private boolean isValidTimeSlot(String timeSlot) {
        return timeSlot != null && timeSlot.matches("([01]?[0-9]|2[0-3]):[0-5][0-9]");
    }

    // 打印所有实例变量的方法
    public void printAppointmentDetails() {
        System.out.println("=== Appointment Details ===");
        System.out.println("Patient Name: " + patientName);
        System.out.println("Patient Mobile: " + patientMobile);
        System.out.println("Time Slot: " + timeSlot);
        System.out.println("Doctor: " + (doctor != null ? doctor.getName() : "Not assigned"));
        if (doctor != null) {
            System.out.println("Doctor Type: " + doctor.getClass().getSimpleName());
        }
        System.out.println("-----------------------------------");
    }

    // Getter 和 Setter 方法
    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getPatientMobile() {
        return patientMobile;
    }

    public void setPatientMobile(String patientMobile) {
        if (isValidMobile(patientMobile)) {
            this.patientMobile = patientMobile;
        } else {
            System.out.println("Error: Invalid mobile number format");
        }
    }

    public String getTimeSlot() {
        return timeSlot;
    }

    public void setTimeSlot(String timeSlot) {
        if (isValidTimeSlot(timeSlot)) {
            this.timeSlot = timeSlot;
        } else {
            System.out.println("Error: Invalid time slot format");
        }
    }

    public HealthProfessional getDoctor() {
        return doctor;
    }

    public void setDoctor(HealthProfessional doctor) {
        this.doctor = doctor;
    }
}
