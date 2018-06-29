package zjq.study.entity;

public class Salary {

    private int id;
    private int e_id;
    private int month;
    private int basic;
    private int more;
    private int order_value;

    public Salary() {

    }

    public Salary(int id, int e_id, int month, int basic, int more, int order_value) {
        this.id = id;
        this.e_id = e_id;
        this.month = month;
        this.basic = basic;
        this.more = more;
        this.order_value = order_value;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getE_id() {
        return e_id;
    }

    public void setE_id(int e_id) {
        this.e_id = e_id;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getBasic() {
        return basic;
    }

    public void setBasic(int basic) {
        this.basic = basic;
    }

    public int getMore() {
        return more;
    }

    public void setMore(int more) {
        this.more = more;
    }

    public int getOrder_value() {
        return order_value;
    }

    public void setOrder_value(int order_value) {
        this.order_value = order_value;
    }

    @Override
    public String toString() {
        return "Salary{" +
                "id=" + id +
                ", e_id=" + e_id +
                ", month=" + month +
                ", basic=" + basic +
                ", more=" + more +
                ", order_value=" + order_value +
                '}';
    }
}
