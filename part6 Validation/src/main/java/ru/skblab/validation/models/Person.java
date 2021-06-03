package ru.skblab.validation.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.skblab.validation.validators.OldBirthday;
import javax.validation.constraints.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
public class Person {

    @NotNull(message = "Birthday not filled")
    @Past(message = "The date of birth must be less than the current date of birth")
    @OldBirthday(message = "The date of birth exceeds the current date by 100 years")
    private LocalDate birthday;

    @NotBlank(message = "Name not filled")
    @Size(max = 125, message = "Name size is larger than 125 characters")
    private String name;

    @Size(max = 150, message = "Surname size is more than 150 characters")
    private String surname;

    @NotNull(message = "Sex not filled")
    private Sex sex;
}
