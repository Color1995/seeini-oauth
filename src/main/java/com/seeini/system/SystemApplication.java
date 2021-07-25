package com.seeini.system;

import com.seeini.system.service.AccessService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author Vincent
 * @Date 2021/7/13 17:16
 * @Version 1.0
 * @Description
 */
public class SystemApplication {

    @Autowired
    private AccessService accessService;

}
