package com.github.viniciusbpm.filmcrew.controller.apidto;

import lombok.*;

import java.time.LocalDate;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DatesDto {
    private LocalDate maximum;
    private LocalDate minimum;
}
