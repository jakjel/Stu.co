package org.s3.individualassignment.backend.domain;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Settle {
    private Double id;
    private Double userId1;
    private Double userId2;
    private Double money;
}
