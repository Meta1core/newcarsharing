package com.exposit.carsharing.converter;

import com.exposit.carsharing.security.CarsharingUserDetails;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;

@Slf4j
public class AccessCheckUtil {

    public static void checkAccess(String urlUuid) throws Exception {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof CarsharingUserDetails) {

            String uuid = ((CarsharingUserDetails) principal).getId().toString();

            if (!urlUuid.equals(uuid))
                throw new Exception("Not enough permission");
            else log.info("Access for user {} allowed",uuid);
        }
        else  throw new Exception("Not enough permission");
    }
}