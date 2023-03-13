package com.code.basic.transaction.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.code.basic.transaction.domain.AccountDomain;
import com.code.basic.transaction.repository.AccountMapper;
import com.code.basic.transaction.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author FengDuo
 * @description 针对表【account】的数据库操作Service实现
 * @createDate 2023-03-08 17:08:06
 */
@Slf4j
@Service
public class AccountServiceImpl extends ServiceImpl<AccountMapper, AccountDomain> implements AccountService {

    private final AccountMapper accountMapper;

    public AccountServiceImpl(AccountMapper accountMapper) {
        this.accountMapper = accountMapper;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public String multiOrderTransaction() {
        LocalDateTime pre = LocalDateTime.now();
        CompletableFuture<AccountDomain> future = CompletableFuture.supplyAsync(() -> {
            AccountDomain account = new AccountDomain();
            account.setUserName("fengduo");
            account.setAge(0);
            account.setEmail("666");
            accountMapper.insert(account);
            return account;
        });
        try {
            log.info("first result: " + future.get().toString());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        CompletableFuture<AccountDomain> secondFuture = future.thenApply(s -> {
            AccountDomain account = new AccountDomain();
            account.setUserName("ddd");
            account.setAge(0);
            account.setEmail("777");
            accountMapper.insert(account);
            return account;
        });
        int i = 1 / 0;
        try {
            System.out.println("second result: " + secondFuture.get() + ",Time: " +
                    Duration.between(pre, LocalDateTime.now()).toMillis());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        return null;
    }

}




