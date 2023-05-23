public class test {

    private String name;
    private int num;
    private String hello;

    public test(String name, int num, String hello) {
        this.name = name;
        this.num = num;
        this.hello = hello;
    }

    public String getName() {
        return name;
    }

    public int getNum() {
        return num;
    }

    public String getHello() {
        return hello;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public void setHello(String hello) {
        this.hello = hello;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("test{");
        sb.append("name='").append(name).append('\'');
        sb.append(", num=").append(num);
        sb.append(", hello='").append(hello).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
