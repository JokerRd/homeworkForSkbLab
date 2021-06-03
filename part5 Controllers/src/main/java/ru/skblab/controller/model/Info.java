package ru.skblab.controller.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import ru.skblab.controller.util.DataSerializer;

import java.util.Date;

@Data
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Info {

    private long id;

    @JsonSerialize(using = DataSerializer.class)
    private Date date;

}
