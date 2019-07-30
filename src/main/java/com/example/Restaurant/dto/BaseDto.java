package com.example.Restaurant.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Base DTO for all DTOs
 * <p>
 * Do not serialize:
 * The configuration <code>spring.jackson.default-property-inclusion</code> in application.properties do not working.
 * So it was annotated <code>@JsonInclude(JsonInclude.Include.NON_NULL)</code> for
 * </p>
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BaseDto {}