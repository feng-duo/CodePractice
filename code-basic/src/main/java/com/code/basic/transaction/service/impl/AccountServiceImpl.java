package com.code.basic.transaction.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.code.basic.transaction.repository.AccountMapper;
import com.code.basic.transaction.domain.AccountDomain;
import com.code.basic.transaction.service.AccountService;
import org.springframework.stereotype.Service;

/**
* @author FengDuo
* @description 针对表【account】的数据库操作Service实现
* @createDate 2023-03-08 17:08:06
*/
@Service
public class AccountServiceImpl extends ServiceImpl<AccountMapper, AccountDomain> implements AccountService {

}




