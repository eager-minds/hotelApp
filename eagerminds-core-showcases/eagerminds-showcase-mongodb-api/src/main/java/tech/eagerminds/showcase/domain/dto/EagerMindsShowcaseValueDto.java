package tech.eagerminds.showcase.domain.dto;

import java.util.List;

public record EagerMindsShowcaseValueDto(String id, String myString, Integer myInt,
                                         List<Integer> myIntArray) {

}
