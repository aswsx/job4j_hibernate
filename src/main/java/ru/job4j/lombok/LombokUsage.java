package ru.job4j.lombok;

/**
 * @author Alex Gutorov
 * @version 1.0
 * @created 09/08/2022 - 21:52
 */
public class LombokUsage {
    public static void main(String[] args) {
        var permission = Permission.of()
                .id(1)
                .name("ADMIN")
                .rules("add")
                .rules("edit")
                .rules("view")
                .rules("delete")
                .build();
        System.out.println(permission);
    }
}
