package org.s3.individualassignment.backend.business.impl;

import org.s3.individualassignment.backend.domain.AccessToken;

public interface AccessTokenDecoder {
    AccessToken decode(String accessTokenEncoded);
}
