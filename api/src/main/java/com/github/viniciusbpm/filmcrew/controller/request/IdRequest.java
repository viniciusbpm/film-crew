package com.github.viniciusbpm.filmcrew.controller.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class IdRequest {
    @NotNull
    private Long id;
}
