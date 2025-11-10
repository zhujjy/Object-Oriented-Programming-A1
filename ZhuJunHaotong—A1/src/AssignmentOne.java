import java.util.ArrayList;
import java.util.Iterator;

/**
 * 主类 - 包含程序的入口点
 * 演示所有功能部分
 */
public class AssignmentOne {
    // 用于存储预约的ArrayList
    private static ArrayList<Appointment> appointments = new ArrayList<>();

    public static void main(String[] args) {

        // Part 3 – Using classes and objects
        System.out.println("Part 3 – Using classes and objects");

        // 创建三个全科医生对象
        GeneralPractitioner gp1 = new GeneralPractitioner(101, "Dr. Smith", "Family Medicine", true, 25);
        GeneralPractitioner gp2 = new GeneralPractitioner(102, "Dr. Johnson", "General Practice", false, 20);
        GeneralPractitioner gp3 = new GeneralPractitioner(103, "Dr. Williams", "Primary Care", true, 30);

        // 创建两个心脏科医生对象
        Cardiologist cardio1 = new Cardiologist(201, "Dr. Brown", "Cardiology", true, "Advanced");
        Cardiologist cardio2 = new Cardiologist(202, "Dr. Davis", "Interventional Cardiology", true, "Expert");

        // 打印所有医疗专业人员的详细信息
        System.out.println("\nPrinting Health Professional Details:");
        gp1.printDetails();
        gp2.printDetails();
        gp3.printDetails();
        cardio1.printDetails();
        cardio2.printDetails();

        System.out.println("---");

        // Part 5 – Collection of appointments
        System.out.println("Part 5 – Collection of appointments");

        // 创建预约
        createAppointment("John Doe", "0412345678", "09:00", gp1);
        createAppointment("Jane Smith", "0498765432", "10:30", gp2);
        createAppointment("Mike Wilson", "0432145698", "14:00", cardio1);
        createAppointment("Sarah Brown", "0456789123", "15:30", cardio2);

        // 打印现有预约
        System.out.println("\nAll Appointments:");
        printExistingAppointments();

        // 取消一个预约
        System.out.println("\nCancelling appointment for mobile: 0498765432");
        cancelBooking("0498765432");

        // 再次打印预约以展示更新
        System.out.println("\nUpdated Appointments:");
        printExistingAppointments();

        System.out.println("---");

        // 演示错误处理
        System.out.println("\nDemonstrating Error Handling:");
        createAppointment("Test Patient", "123", "25:00", gp1); // 无效的手机号和时间段
    }

    /**
     * 创建新预约并添加到ArrayList
     * 使用多态处理不同类型的医疗专业人员
     */
    public static void createAppointment(String patientName, String patientMobile,
                                         String timeSlot, HealthProfessional doctor) {
        try {
            Appointment newAppointment = new Appointment(patientName, patientMobile, timeSlot, doctor);
            appointments.add(newAppointment);
            System.out.println("Appointment created successfully for: " + patientName);
        } catch (IllegalArgumentException e) {
            System.out.println("Failed to create appointment: " + e.getMessage());
        }
    }

    /**
     * 显示现有预约
     * 如果没有预约，显示提示信息
     */
    public static void printExistingAppointments() {
        if (appointments.isEmpty()) {
            System.out.println("No existing appointments.");
            return;
        }

        System.out.println("Total appointments: " + appointments.size());
        for (int i = 0; i < appointments.size(); i++) {
            System.out.println("\nAppointment #" + (i + 1) + ":");
            appointments.get(i).printAppointmentDetails();
        }
    }

    /**
     * 根据患者手机号取消预约
     */
    public static void cancelBooking(String patientMobile) {
        boolean found = false;
        Iterator<Appointment> iterator = appointments.iterator();

        while (iterator.hasNext()) {
            Appointment appointment = iterator.next();
            if (appointment.getPatientMobile().equals(patientMobile)) {
                iterator.remove();
                System.out.println("Appointment cancelled for mobile: " + patientMobile);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Error: No appointment found for mobile: " + patientMobile);
        }
    }
}
