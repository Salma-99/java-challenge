package jp.co.axa.apidemo.beans.response;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

import org.springframework.stereotype.Component;

@Component
public class EmployeeRecordResponse {

    @Getter
    @Setter
    public Long id;

    @Getter
    @Setter
    @NotEmpty
    public String name;

    @Getter
    @Setter
    @NotEmpty
    public Integer salary;

    @Getter
    @Setter
    @NotEmpty
    public String department;
}
