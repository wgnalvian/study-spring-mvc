package com.spring_mvc.spring_mvc.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data  
@AllArgsConstructor
@NoArgsConstructor
public class HelloRequest {

    @NotBlank(message = "Name cannot be blank")
    private String name;

    @NotNull(message = "Hobbies cannot be null")
    private List<String> hobbies;
    
}
