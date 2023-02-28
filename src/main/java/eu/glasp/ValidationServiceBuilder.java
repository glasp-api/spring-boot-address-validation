package eu.glasp;

import java.util.concurrent.TimeUnit;

public class ValidationServiceBuilder {
    private String user;
    private String password;
    private Integer timeout = 3;
    private TimeUnit timeUnit = TimeUnit.SECONDS;

    public ValidationServiceBuilder configureUser(String user){
        this.user = user;
        return this;
    }

    public ValidationServiceBuilder configurePassword(String password){
        this.password = password;
        return this;
    }

    public ValidationServiceBuilder configureTimeout(Integer timeout, TimeUnit unit){
        this.timeout = timeout;
        this.timeUnit = unit;
        return this;
    }

    public ValidationService build(){
        TimeUnit time = TimeUnit.MILLISECONDS;
        return new ValidationService(this.user, this.password, (int) time.convert(timeout, timeUnit));
    }
}
