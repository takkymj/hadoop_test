/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.creditcloud.fuiou.api;

import com.creditcloud.fuiou.model.CollectRecordStatus;
import com.creditcloud.fuiou.model.CollectResult;
import com.creditcloud.fuiou.model.FuiouCollectRecord;
import com.creditcloud.model.criteria.PageInfo;
import com.creditcloud.model.enums.misc.Bank;
import com.creditcloud.model.misc.PagedResult;
import java.math.BigDecimal;
import java.util.Date;
import javax.ejb.Remote;

/**
 *
 * @author kdliu
 */
@Remote
public interface FuiouService {
    
    /**
     * Execute the collect for the given repayment.
     * 
     * @param clientCode not null
     * @param repayId not null
     * @param date not null
     * @param bank not null
     * @param accountNo not null
     * @param accountName not null
     * @param amount not null
     * @param reExIfLastFailed
     * @return 
     */
    public CollectResult collectRepayment(String clientCode,
                                          String userId,
                                          String repayId,
                                          String date,
                                          Bank bank,
                                          String accountNo,
                                          String accountName,
                                          BigDecimal amount,
                                          Boolean reExIfLastFailed);
 
    /**
     * Query the remote Fuiou server to get transaction status
     * 
     * @param clientCode not null
     * @param repayId nullable
     * @param startDate not null
     * @param endDate  not null
     */
    public void queryTransaction(String clientCode,
                                 String repayId, 
                                 String startDate,
                                 String endDate);
    
    /**
     * Query the collect records in the given time range.
     * 
     * @param clientCode not null
     * @param from not null
     * @param to not null
     * @param pageInfo not null
     * @return 
     */
    public PagedResult<FuiouCollectRecord> listCollectRecord(String clientCode,
                                                        Date from,
                                                        Date to,
                                                        PageInfo pageInfo);
    
    /**
     * Mark the given collect order no to be the given status.
     * 
     * @param orderNo not null
     * @param status not null, FAILED or SUCCESSFUL
     * @return 
     */
    public CollectResult markCollectRecordStatus(String clientCode,
                                                 String orderNo,
                                                 CollectRecordStatus status);
    
}
