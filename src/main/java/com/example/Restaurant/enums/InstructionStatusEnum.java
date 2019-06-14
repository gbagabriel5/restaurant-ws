package com.example.Restaurant.enums;

import lombok.Getter;

public enum InstructionStatusEnum {

    TO_APPROVE("To Approve"),
    APPROVED("Approved"),
    DRAFT("Draft"),
    REPROVED("Reproved"),
    ARCHIVED("archived"),
    REVISED("Revised");

    @Getter
    private String description;

    InstructionStatusEnum(String description) { this.description = description; }

}
