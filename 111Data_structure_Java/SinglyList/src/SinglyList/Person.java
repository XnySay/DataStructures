package SinglyList;

public class Person {
    private String name;
    private String phone;
    private String email;
    public Person next;

    public Person(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        next = null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // 重写 toString() 方法，用于打印联系人信息
    public String toString() {
        return "Name: " + name + "\nPhone: " + phone + "\nEmail: " + email;
    }
}

