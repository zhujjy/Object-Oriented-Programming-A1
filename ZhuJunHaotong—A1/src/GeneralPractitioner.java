/**
 * 全科医生类
 * 继承自 HealthProfessional
 */
public class GeneralPractitioner extends HealthProfessional {
    // 额外的实例变量 - 区分于其他医疗专业人员
    private boolean canPerformMinorSurgery;
    private int maxPatientsPerDay;

    // 默认构造函数
    public GeneralPractitioner() {
        super(); // 调用父类默认构造函数
        this.canPerformMinorSurgery = false;
        this.maxPatientsPerDay = 20;
    }

    // 带参数的构造函数
    public GeneralPractitioner(int id, String name, String specialization,
                               boolean canPerformMinorSurgery, int maxPatientsPerDay) {
        super(id, name, specialization); // 调用父类构造函数
        this.canPerformMinorSurgery = canPerformMinorSurgery;
        this.maxPatientsPerDay = maxPatientsPerDay;
    }

    // 打印详细信息的方法（重写父类方法）
    @Override
    public void printDetails() {
        System.out.println("=== General Practitioner Details ===");
        super.printDetails(); // 调用父类的打印方法
        System.out.println("Can Perform Minor Surgery: " + (canPerformMinorSurgery ? "Yes" : "No"));
        System.out.println("Max Patients Per Day: " + maxPatientsPerDay);
        System.out.println("-----------------------------------");
    }

    // Getter 和 Setter 方法
    public boolean canPerformMinorSurgery() {
        return canPerformMinorSurgery;
    }

    public void setCanPerformMinorSurgery(boolean canPerformMinorSurgery) {
        this.canPerformMinorSurgery = canPerformMinorSurgery;
    }

    public int getMaxPatientsPerDay() {
        return maxPatientsPerDay;
    }

    public void setMaxPatientsPerDay(int maxPatientsPerDay) {
        this.maxPatientsPerDay = maxPatientsPerDay;
    }
}
