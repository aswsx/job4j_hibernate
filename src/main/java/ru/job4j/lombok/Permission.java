package ru.job4j.lombok;

import lombok.*;

import java.util.List;

/**
 * @author Alex Gutorov
 * @version 1.0
 * @created 09/08/2022 - 21:51
 */
@Builder(builderMethodName = "of")
@ToString
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Permission {
    @EqualsAndHashCode.Include
    private final int id;
    @Setter
    private String name;
    @Setter
    @Singular("rules")
    private List<String> rules;
}
