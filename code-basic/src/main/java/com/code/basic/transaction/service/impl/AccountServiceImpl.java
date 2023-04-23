package com.code.basic.transaction.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.code.basic.transaction.domain.AccountDomain;
import com.code.basic.transaction.repository.AccountMapper;
import com.code.basic.transaction.service.AccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author FengDuo
 * @description 针对表【account】的数据库操作Service实现
 * @createDate 2023-03-08 17:08:06
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class AccountServiceImpl extends ServiceImpl<AccountMapper, AccountDomain> implements AccountService {

    private final AccountMapper accountMapper;
    private final DataSourceTransactionManager dataSourceTransactionManager;

    List<TransactionStatus> transactionStatusList = Collections.synchronizedList(new ArrayList<>());


    @Override
    @Transactional(rollbackFor = Exception.class)
    public String multiOrderTransaction() {
        LocalDateTime pre = LocalDateTime.now();
        CountDownLatch countDownLatch = new CountDownLatch(2);
        AtomicBoolean isError = new AtomicBoolean(false);
        CompletableFuture<AccountDomain> future = CompletableFuture.supplyAsync(() -> {
            AccountDomain account = new AccountDomain();
            try {
                DefaultTransactionDefinition definition = new DefaultTransactionDefinition();
                definition.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW);
                TransactionStatus transactionStatus = dataSourceTransactionManager.getTransaction(definition);
                transactionStatusList.add(transactionStatus);
                account.setUserName("fengduo");
                account.setAge(0);
                account.setEmail("666");
                accountMapper.insert(account);
            } catch (Exception e) {
                isError.set(true);
            } finally {
                countDownLatch.countDown();
            }
            return account;
        });
        try {
            log.info("first result: " + future.get().toString());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        CompletableFuture<AccountDomain> secondFuture = future.thenApply(s -> {
            AccountDomain account = new AccountDomain();
            try {
                DefaultTransactionDefinition definition = new DefaultTransactionDefinition();
                definition.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW);
                TransactionStatus transactionStatus = dataSourceTransactionManager.getTransaction(definition);
                transactionStatusList.add(transactionStatus);
                account.setUserName("ddd");
                account.setAge(0);
                account.setEmail("777");
                accountMapper.insert(account);
                int i = 1 / 0;
            } catch (Exception e) {
                isError.set(true);
            } finally {
                countDownLatch.countDown();
            }
            return account;
        });

        try {
            System.out.println("second result: " + secondFuture.get() + ",Time: " +
                    Duration.between(pre, LocalDateTime.now()).toMillis());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public AccountDomain getAccountDomain() {
        AccountDomain account = new AccountDomain();
        account.setUserName("fengduo");
        account.setAge(0);
        account.setEmail("666");
        accountMapper.insert(account);
        int i = 1 / 0;
        return account;
    }

}




