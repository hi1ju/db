package com.example.db.datasource.transaction;


import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.interceptor.DefaultTransactionAttribute;
import org.springframework.transaction.interceptor.RollbackRuleAttribute;
import org.springframework.transaction.interceptor.RuleBasedTransactionAttribute;
import org.springframework.transaction.interceptor.TransactionInterceptor;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

//@Configuration
public class BizATransactionConfigAdvice {

    private PlatformTransactionManager platformTransactionManager;

    public BizATransactionConfigAdvice(@Qualifier("bizATransactionManager") PlatformTransactionManager platformTransactionManager) {
        this.platformTransactionManager = platformTransactionManager;
    }

    @Bean
    public TransactionInterceptor transactionAdvice2() {

        TransactionInterceptor transactionAdvice = new TransactionInterceptor();

        List<RollbackRuleAttribute> rollbackRules = new ArrayList<>();
        rollbackRules.add(new RollbackRuleAttribute(Exception.class));

        DefaultTransactionAttribute attribute = new RuleBasedTransactionAttribute(TransactionDefinition.PROPAGATION_REQUIRED, rollbackRules);
        attribute.setReadOnly(true);
        String transactionAttributesDefinition = attribute.toString();

        Properties transactionAttribues = new Properties();
        transactionAttribues.setProperty("*", transactionAttributesDefinition);

        transactionAdvice.setTransactionAttributes(transactionAttribues);
        transactionAdvice.setTransactionManager(platformTransactionManager);

        return transactionAdvice;
    }

    @Bean
    public DefaultPointcutAdvisor transactionAdviceAdvisor2() {

        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
        //pointcut.setExpression(CommonConstants.TRANSACTION_POINTCUT);
        return new DefaultPointcutAdvisor(pointcut, transactionAdvice2());

    }
}