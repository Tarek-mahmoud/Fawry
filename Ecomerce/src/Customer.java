public class Customer {
    private String name;
    private String address;
    private String phone;
    private String email;
    private double balance;

    public Customer(String name, String address, String phone, String email, double balance) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public double getBalance() {
        return balance;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}