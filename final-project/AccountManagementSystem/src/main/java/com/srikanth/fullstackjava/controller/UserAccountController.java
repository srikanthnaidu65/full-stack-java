package com.srikanth.fullstackjava.controller;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.srikanth.fullstackjava.entity.AccountTransactionDetails;
import com.srikanth.fullstackjava.entity.UserBankDetails;
import com.srikanth.fullstackjava.service.AccountDetailsService;

/**
 * Controller class for User account details.
 *
 * @author  Srikanth Sambirli
 * @version 1.0
 * @since   2018-06-26
 */
@Controller
public class UserAccountController implements ErrorController {

	private static final String errorPath = "/errors";

	@Autowired
	private AccountDetailsService accountDetailsService;

	/**
	 * This method is used to check the account balance
	 * 
	 * @param req
	 * @param session
	 * @param model
	 * @return
	 */
	@GetMapping(value = "/user/checkBalance")
	public String checkBalance(HttpServletRequest req,
			HttpSession session, Model model) {

		Object user = session.getAttribute("user");
		if(user != null) {
			List<UserBankDetails> bankDetails = accountDetailsService.getUserAccountDetails(
					user.toString());
			if (bankDetails != null && !bankDetails.isEmpty()) {
				model.addAttribute("accounts", bankDetails);
				return "checkBalance";
			} else {
				model.addAttribute("errMsg", "User account details not found!");
				return "userHome";
			}
		} else {
			model.addAttribute("secureMsg", "Please login first to continue!");
			return "login";
		}
	}

	/**
	 * This method is used to get the accounts
	 * to perform the funds transfer
	 * 
	 * @param req
	 * @param session
	 * @param model
	 * @return
	 */
	@GetMapping("/user/transferFunds")
	public String transferFunds(HttpServletRequest req,
			HttpSession session, Model model) {

		Object user = session.getAttribute("user");
		if(user != null) {
			List<UserBankDetails> bankDetails = accountDetailsService.getUserAccountDetails(
					user.toString());
			if (bankDetails != null && !bankDetails.isEmpty()) {
				model.addAttribute("accounts", bankDetails);
				return "transferFunds";
			} else {
				model.addAttribute("errMsg", "No Accounts Found!");
				return "userHome";
			}
		} else {
			model.addAttribute("secureMsg", "Please login first to continue!");
			return "login";
		}
	}

	/**
	 * This method is used to transfer funds from
	 * one account to another account
	 * 
	 * @param fromAccount
	 * @param toAccount
	 * @param description
	 * @param transferAmount
	 * @param req
	 * @param session
	 * @param model
	 * @return
	 */
	@PostMapping(value = "/user/fundsTransfer")
	public String fundsTransfer(@RequestParam("fromAccount") String fromAccount,
			@RequestParam("toAccount") String toAccount,
			@RequestParam("description") String description,
			@RequestParam("amount") Double transferAmount,
			HttpServletRequest req,
			HttpSession session, Model model) {

		Object user = session.getAttribute("user");
		if(user != null) {
			List<UserBankDetails> bankDetails = accountDetailsService.getUserAccountDetails(
					user.toString());
			model.addAttribute("accounts", bankDetails);

			if (fromAccount.equals(toAccount)) {
				model.addAttribute("errMsg", "From Account and To Account should not be same!");
				return "transferFunds";
			}

			UserBankDetails sUserBankDetails = null;
			UserBankDetails dUserBankDetails = null;
			for (UserBankDetails ubd: bankDetails) {
				if (fromAccount.equals(ubd.getUserAccountDetails().getAccountNumber())) {
					sUserBankDetails = ubd;
				}
				if (toAccount.equals(ubd.getUserAccountDetails().getAccountNumber())) {
					dUserBankDetails = ubd;
				}
			}

			Double sAvailableBalance = sUserBankDetails.getUserAccountDetails().getAccountBalance();
			Double dAvailableBalance = dUserBankDetails.getUserAccountDetails().getAccountBalance();

			if (transferAmount > sAvailableBalance) {
				model.addAttribute("errMsg", "Transfer Amount should not be more than Available Balance!");
				return "transferFunds";
			} else if (sAvailableBalance - transferAmount < 1000) {
				model.addAttribute("errMsg", "Cannot Transfer! Account Balance will go less than Minimum Balance!");
				return "transferFunds";
			}

			sAvailableBalance = sAvailableBalance - transferAmount;
			dAvailableBalance = dAvailableBalance + transferAmount;

			sUserBankDetails.getUserAccountDetails().setAccountBalance(sAvailableBalance);
			sUserBankDetails.getUserAccountDetails().setUpdatedDateTime(new Date());
			dUserBankDetails.getUserAccountDetails().setAccountBalance(dAvailableBalance);
			dUserBankDetails.getUserAccountDetails().setUpdatedDateTime(new Date());

			AccountTransactionDetails sTransactionDetails = new AccountTransactionDetails(
					fromAccount, description, transferAmount, sAvailableBalance, "Debit", new Date());
			AccountTransactionDetails dTransactionDetails = new AccountTransactionDetails(
					toAccount, description, transferAmount, dAvailableBalance, "Credit", new Date());
			try {
				accountDetailsService.transferFunds(sUserBankDetails, dUserBankDetails, 
						sTransactionDetails, dTransactionDetails);
				model.addAttribute("succMsg", "Funds Transfered successfully!");
				return "transferFunds";
			} catch(Exception e) {
				model.addAttribute("errMsg", "Failed to transfer Funds!");
				return "transferFunds";
			}
		} else {
			model.addAttribute("secureMsg", "Please login first to continue!");
			return "login";
		}
	}

	/**
	 * This method is used to display the account details to
	 * search the transaction details
	 * 
	 * @param req
	 * @param session
	 * @param model
	 * @return
	 */
	@GetMapping("/user/transactionSummary")
	public String transactionSummary(HttpServletRequest req,
			HttpSession session, Model model) {

		Object user = session.getAttribute("user");
		if(user != null) {
			List<UserBankDetails> bankDetails = accountDetailsService.getUserAccountDetails(
					user.toString());
			if (bankDetails != null && !bankDetails.isEmpty()) {
				model.addAttribute("accounts", bankDetails);
				return "transactionSummary";
			} else {
				model.addAttribute("errMsg", "No Accounts Found!");
				return "userHome";
			}
		} else {
			model.addAttribute("secureMsg", "Please login first to continue!");
			return "login";
		}
	}

	/**
	 * This method is used to retrieve the transaction summary
	 * of the selected account
	 * 
	 * @param accountNumber
	 * @param fromDate
	 * @param toDate
	 * @param req
	 * @param session
	 * @param model
	 * @return
	 */
	@PostMapping(value = "/user/searchTransactions")
	public String searchTransactions(@RequestParam("accountNumber") String accountNumber,
			@RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate,
			HttpServletRequest req,
			HttpSession session, Model model) {

		Object user = session.getAttribute("user");
		if(user != null) {
			List<UserBankDetails> bankDetails = accountDetailsService.getUserAccountDetails(
					user.toString());
			model.addAttribute("accounts", bankDetails);
			List<AccountTransactionDetails> transactionDetails = null;
			try {
				transactionDetails = accountDetailsService.getAccountTransactionDetails(
						accountNumber, fromDate, toDate);
			} catch (ParseException e) {
				model.addAttribute("errMsg", "Error while fetching transactions!");
				return "transactionSummary";
			}
			if (transactionDetails != null && !transactionDetails.isEmpty()) {
				model.addAttribute("transactions", transactionDetails);
				return "transactionSummary";
			} else {
				model.addAttribute("errMsg", "No Transactions Found!");
				return "transactionSummary";
			}
		} else {
			model.addAttribute("secureMsg", "Please login first to continue!");
			return "login";
		}
	}

	/**
	 * This method is used to handle the errors in the application
	 */
	public String getErrorPath() {
		return errorPath;
	}

}
