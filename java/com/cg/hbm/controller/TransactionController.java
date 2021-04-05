package com.cg.hbm.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cg.hbm.entites.Transactions;
import com.cg.hbm.service.ITransactionService;
/**
 * 
 * @author KV Prasad
 *
 */

@RestController
@RequestMapping("/transaction")
public class TransactionController {
	
	@Autowired
	ITransactionService iService;
	/**
	 * 
	 * @param transaction
	 * @return Transactions
	 * @throws Exception
	 */
	
	@PostMapping("/add")
	public ResponseEntity<Transactions> addTransaction(@RequestBody Transactions transaction) throws Exception  {
		Transactions resultTransaction=iService.addTransaction(transaction);
		return new ResponseEntity<Transactions>(resultTransaction,HttpStatus.OK) ;
	}
	/**
	 * 
	 * @return list of transactions
	 * @throws Exception
	 */
	@GetMapping("/all")
	public ResponseEntity<List<Transactions>> showAllTransactions() throws Exception{
		List<Transactions> resultTransaction=iService.showAllTransactions();
		return new ResponseEntity<List<Transactions>>(resultTransaction, HttpStatus.OK);
	}
}

