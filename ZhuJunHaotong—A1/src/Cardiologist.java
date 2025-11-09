/**
 * 心脏科医生类
 * 继承自 HealthProfessional
 */
public class Cardiologist extends HealthProfessional {
    // 额外的实例变量 - 区分于其他医疗专业人员
    private boolean canPerformSurgery;
    private String certificationLevel;

    // 默认构造函数
    public Cardiologist() {
        super();
        this.canPerformSurgery = false;
        this.certificationLevel = "Basic";
    }

    // 带参数的构造函数
    public Cardiologist(int id, String name, String specialization,
                        boolean canPerformSurgery, String certificationLevel) {
        super(id, name, specialization);
        this.canPerformSurgery = canPerformSurgery;
        this.certificationLevel = certificationLevel;
    }

    // 打印详细信息的方法（重写父类方法）
    @Override
    public void printDetails() {
        System.out.println("=== Cardiologist Details ===");
        super.printDetails(); // 调用父类的打印方法
        System.out.println("Can Perform Surgery: " + (canPerformSurgery ? "Yes" : "No"));
        System.out.println("Certification Level: " + certificationLevel);
        System.out.println("-----------------------------------");
    }

    // 特定于心脏科医生的方法
    public void performECG() {
        System.out.println(name + " is performing an ECG test.");
    }

    // Getter 和 Setter 方法
    public boolean canPerformSurgery() {
        return canPerformSurgery;
    }

    public void setCanPerformSurgery(boolean canPerformSurgery) {
        this.canPerformSurgery = canPerformSurgery;
    }

    public String getCertificationLevel() {
        return certificationLevel;
    }

    public void setCertificationLevel(String certificationLevel) {
        this.certificationLevel = certificationLevel;
    }
}
