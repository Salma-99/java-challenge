package jp.co.axa.apidemo.beans.response;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
public class EmployeeResponse {

    @Getter
    @Setter
    public String message;
}
