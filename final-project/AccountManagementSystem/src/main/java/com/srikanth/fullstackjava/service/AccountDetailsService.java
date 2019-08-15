package com.srikanth.fullstackjava.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.srikanth.fullstackjava.entity.AccountTransactionDetails;
import com.srikanth.fullstackjava.entity.UserBankDetails;
import com.srikanth.fullstackjava.repository.AccountTransactionDetailsRepository;
import com.srikanth.fullstackjava.repository.UserBankDetailsRepository;

/**
 * Service class for account details business operations.
 * Transaction management is handled through Spring Declarative Transaction Management
 *
 * @author  Srikanth Sambirli
 * @version 1.0
 * @since   2018-06-26
 */
@Service
public class AccountDetailsService {

	@Autowired
	private UserBankDetailsRepository userBankDetailsRepository;

	@Autowired
	private AccountTransactionDetailsRepository atdRepository;

	/**
	 * This method is used to get the user account details identified by userId
	 * 
	 * @param userId
	 * @return
	 */
	@Transactional(readOnly = true, timeout = 50)
	public List<UserBankDetails> getUserAccountDetails(String userId) {
		return userBankDetailsRepository.getUserAccountDetails(userId);
	}

	/**
	 * This method is used to update account and transaction details
	 * when funds transfer is performed
	 * 
	 * @param sUserBankDetails
	 * @param dUserBankDetails
	 * @param sTransactionDetails
	 * @param dTransactionDetails
	 */
	@Transactional(rollbackFor = Exception.class, timeout = 50)
	public void transferFunds(UserBankDetails sUserBankDetails, UserBankDetails dUserBankDetails,
			AccountTransactionDetails sTransactionDetails, AccountTransactionDetails dTransactionDetails) {
		userBankDetailsRepository.save(sUserBankDetails);
		userBankDetailsRepository.save(dUserBankDetails);
		atdRepository.save(sTransactionDetails);
		atdRepository.save(dTransactionDetails);
	}

	/**
	 * This method is used to get the account transaction details
	 * for the account number between a period of time
	 * 
	 * @param accountNumber
	 * @param fromDate
	 * @param toDate
	 * @return
	 * @throws ParseException
	 */
	@Transactional(readOnly = true, timeout = 50)
	public List<AccountTransactionDetails> getAccountTransactionDetails(String accountNumber, String fromDate,
			String toDate) throws ParseException {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date fDate = dateFormat.parse(fromDate);
		Date tDate = dateFormat.parse(toDate);
		return atdRepository.findByAccountNumberAndUpdatedDateTimeBetween(accountNumber, fDate, tDate);
	}

}
