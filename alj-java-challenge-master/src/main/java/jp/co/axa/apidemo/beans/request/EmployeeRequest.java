package jp.co.axa.apidemo.beans.request;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import javax.validation.constraints.NotEmpty;

public class EmployeeRequest {

    @Getter
    @Setter
    public Long id;

    @Getter
    @Setter
    @NotEmpty
    public String name;

    @Getter
    @Setter
    @NonNull
    public Integer salary;

    @Getter
    @Setter
    @NotEmpty
    public String department;
    
    
}
