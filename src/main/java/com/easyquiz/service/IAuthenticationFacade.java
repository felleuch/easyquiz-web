package com.easyquiz.service;

import org.springframework.security.core.Authentication;

/**
 * Created by felleuch on 25/01/2018.
 */

public interface IAuthenticationFacade {
    Authentication getAuthentication();

}
