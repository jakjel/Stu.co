package org.s3.individualassignment.backend.business.impl;

import org.s3.individualassignment.backend.domain.AccessToken;

public interface AccessTokenEncoder {
    String encode(AccessToken accessToken);
}
