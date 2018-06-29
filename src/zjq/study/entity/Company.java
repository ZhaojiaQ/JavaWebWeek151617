package zjq.study.entity;

public class Company {
    private int id;
    private String c_name;
    private String c_boss;
    private String c_address;

    public Company(String c_name, String c_boss, String c_address) {
        this.c_name = c_name;
        this.c_boss = c_boss;
        this.c_address = c_address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getC_name() {
        return c_name;
    }

    public void setC_name(String c_name) {
        this.c_name = c_name;
    }

    public String getC_boss() {
        return c_boss;
    }

    public void setC_boss(String c_boss) {
        this.c_boss = c_boss;
    }

    public String getC_address() {
        return c_address;
    }

    public void setC_address(String c_address) {
        this.c_address = c_address;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", c_name='" + c_name + '\'' +
                ", c_boss='" + c_boss + '\'' +
                ", c_address='" + c_address + '\'' +
                '}';
    }
}
