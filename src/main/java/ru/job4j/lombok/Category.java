package ru.job4j.lombok;

import lombok.*;

/**
 * @author Alex Gutorov
 * @version 1.0
 * @created 09/08/2022 - 21:36
 */
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@RequiredArgsConstructor
public class Category {
    @Getter
    @NonNull
    @EqualsAndHashCode.Include
    private int id;

    @Getter
    @Setter
    private String name;
}