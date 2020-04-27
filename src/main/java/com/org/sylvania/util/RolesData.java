package com.org.sylvania.util;

import org.springframework.stereotype.Component;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@Component
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class RolesData {
  public static final String[] ROLE = {"ROLE_ADMIN","ROLE_USER"};

}
