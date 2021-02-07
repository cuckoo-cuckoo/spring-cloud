package com.service;

import com.dao.AccountDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

/**
 * @author Administrator
 * @create 2021-02-07 22:10
 */
@Service
public class AccountServiceImpl {

    private static final Logger LOGGER = LoggerFactory.getLogger(AccountServiceImpl.class);




    @Resource
    AccountDao accountDao;


    /**
     * 扣减账户余额
     */
    public void decrease(Long userId, BigDecimal money) {
        LOGGER.info("------->account-service中扣减账户余额开始");
        try { TimeUnit.SECONDS.sleep(20); } catch (InterruptedException e) { e.printStackTrace(); }
        accountDao.decrease(userId,money);
        LOGGER.info("------->account-service中扣减账户余额结束");
    }
}
