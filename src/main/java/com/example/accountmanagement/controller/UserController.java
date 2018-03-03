package com.example.accountmanagement.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.accountmanagement.model.AccountName;
import com.example.accountmanagement.model.Accounts;
import com.example.accountmanagement.model.CashSection;
import com.example.accountmanagement.model.CreditDetail;
import com.example.accountmanagement.model.PartyDetails;
import com.example.accountmanagement.model.PurchaseSection;
import com.example.accountmanagement.model.SaleSection;
import com.example.accountmanagement.model.Stock;
import com.example.accountmanagement.service.AccountHolderService;
import com.example.accountmanagement.service.AccountService;
import com.example.accountmanagement.service.CashDetailService;
import com.example.accountmanagement.service.CreditService;
import com.example.accountmanagement.service.PartyDetailService;
import com.example.accountmanagement.service.PurchaseService;
import com.example.accountmanagement.service.SaleService;
import com.example.accountmanagement.service.StockService;


@Controller
public class UserController {
	@Autowired
	private StockService stockService;
	
	@Autowired
	private PurchaseService purchaseservice;
	
	@Autowired
	private SaleService saleService;
	
	@Autowired
	private PartyDetailService partyDetailService;
	
	@Autowired
	private CreditService creditService;
	
	@Autowired
	private CashDetailService cashDetailService;
	
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private AccountHolderService accountHolderService;
	
	@GetMapping(value="/")
	public ModelAndView showStock() {

		List<Stock> stock=stockService.getAllStock();
		ModelAndView modelAndView = new ModelAndView("Stock");
		modelAndView.addObject("stock", stock);
		return modelAndView;
	}
	@GetMapping("/tiledetail")
	public String addTile()
	{
		return "tiledetail";
	}
	@PostMapping("/AddTile")
	public ModelAndView SaveForm(@Valid @ModelAttribute("stock") Stock stock) {

		Stock stk=new Stock();
		stk.setAvailablestock(0);
		stk.setSize(stock.getSize());
		stk.setTilename(stock.getTilename());
		if(stockService.findtile(stk))
			return showStock();
		stockService.saveTile(stk);
		return showStock();
	}
	@GetMapping("/PurchaseSection")
	public ModelAndView purchaseSection() {
		List<PurchaseSection> purchase=purchaseservice.getPurchase();
		ModelAndView modelAndView=new ModelAndView("purchaseSection");
		modelAndView.addObject("purchase",purchase);
		return modelAndView;
	}
	@GetMapping("/AddPurchase")
	public String AddPurchase() {
		return "AddPurchase";
	}
	@PostMapping("/PurchaseItem")
	public ModelAndView purchaseItem(@ModelAttribute("purchaseItem") PurchaseSection purchaseSection) {
		purchaseservice.addPurchase(purchaseSection);
		Stock stk=new Stock();
		stk=stockService.find(purchaseSection);
		if(stk!=null) {
			stk.setAvailablestock(stk.getAvailablestock()+purchaseSection.getQuantity());
			stk.setSize(purchaseSection.getSize());
			stk.setTilename(purchaseSection.getTilename());
			stockService.saveTile(stk);
		}
		else {
			Stock stks=new Stock();
			stks.setAvailablestock(purchaseSection.getQuantity());
			stks.setSize(purchaseSection.getSize());
			stks.setTilename(purchaseSection.getTilename());
			stockService.saveTile(stks);
		}
		return purchaseSection();
	}
	
	@GetMapping("/SalesSection")
	public ModelAndView saleSection() {
		List<SaleSection> sales=saleService.getSales();
		ModelAndView modelAndView = new ModelAndView("salesSection");
		modelAndView.addObject("sales",sales);
		return modelAndView;
	}
	
	@GetMapping("/Addsales")
	public String showSaleForm() {
		return "addsales";
	}
	@PostMapping("/SaleByCash")
	public ModelAndView saleBycash(@ModelAttribute("sales") SaleSection salesSection) {
		salesSection.setSaletype("Cash");
		if(stockService.decreaseStock(salesSection)) {
			saleService.addSales(salesSection);
			int cash=salesSection.getQuantity()*salesSection.getRate();
			CashSection cashSection =new CashSection();
			cashSection.setCashreceived(cash);
			cashSection.setDate(salesSection.getSdate());
			cashSection.setPartyname(salesSection.getPartyname());
			cashDetailService.addcash(cashSection);
		}
		return saleSection();
	}
	@GetMapping("/SaleCredit")
	public String creditForm() {
		return "saleCredit";
	}
	@PostMapping("/SaleByCredit")
	public ModelAndView saleByCredit(@ModelAttribute("sales") SaleSection salesSection,@RequestParam("address") String address,@RequestParam("contact") String contact,@RequestParam("depositamt") int depositamt) {
		PartyDetails partydetail=new PartyDetails();
		partydetail.setAddress(address);
		partydetail.setContact(contact);
		partydetail.setPname(salesSection.getPartyname());
		
		CreditDetail creditDetail=new CreditDetail();
		creditDetail.setDepositamt(depositamt);
		creditDetail.setPdate(salesSection.getSdate());
		creditDetail.setPname(salesSection.getPartyname());
		creditDetail.setQuantity(salesSection.getQuantity());
		creditDetail.setRate(salesSection.getRate());
		creditDetail.setSize(salesSection.getSize());
		creditDetail.setTilename(salesSection.getTilename());
		
		CashSection cashSection =new CashSection();
		cashSection.setCashreceived(depositamt);
		cashSection.setDate(salesSection.getSdate());
		cashSection.setPartyname(salesSection.getPartyname());
		
		
		salesSection.setSaletype("Credit");
		if(stockService.decreaseStock(salesSection)) {
			saleService.addSales(salesSection);
			partyDetailService.addparty(partydetail);
			creditService.addSales(creditDetail);
			cashDetailService.addcash(cashSection);
		}
		//ModelAndView modelAndView=new ModelAndView("PartyDetails");
		return saleSection();
	}

	@GetMapping("/partylist")
	public ModelAndView saleBycash() {
		List<PartyDetails> partydetails=partyDetailService.getparty();
		ModelAndView modelAndView = new ModelAndView("partylist");
		modelAndView.addObject("party", partydetails);
		return modelAndView;
	}

	@GetMapping("/partydetail/{Pname}")
	public ModelAndView partydetail(@PathVariable("Pname") String Pname) {
		ModelAndView mv=new ModelAndView("partydetail");
		List<CreditDetail> creditdetails=creditService.partydetail(Pname);
		mv.addObject("party",creditdetails);
		mv.addObject("pname", Pname);
		return mv;
	}	
	@GetMapping("/CashAccount")
	public ModelAndView cashdetail() {
		ModelAndView mv=new ModelAndView("cashsection");
		List<CashSection> cashSection=cashDetailService.getAllStock();
		List<AccountName> accountsName=accountService.getAccounts();
		int balance=0;
		int s1=0,s2=0;
		for(AccountName b:accountsName){
				s1+=b.getAmount();
				} 

		for(CashSection b:cashSection){
				s2+=b.getCashreceived();
				}
		balance=s2-s1;
		mv.addObject("balance", balance);
		mv.addObject("cashSection", cashSection);
		return mv;
	}
	@PostMapping("/depositamt")
	public String depositamount(@RequestParam("amount") int depositamt,@RequestParam("pname") String pname) {
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String pdate=dateFormat.format(date);
		
		CashSection cashSection=new CashSection();
		cashSection.setDate(pdate);
		cashSection.setCashreceived(depositamt);
		cashSection.setPartyname(pname);
		
		CreditDetail creditDetail=new CreditDetail();
		creditDetail.setDepositamt(depositamt);
		creditDetail.setPdate(pdate);
		creditDetail.setPname(pname);
		creditDetail.setQuantity(0);
		creditDetail.setRate(0);
		creditDetail.setSize("");
		creditDetail.setTilename("");
		//creditdetails.add(creditDetail);
		cashDetailService.addcash(cashSection);
		creditService.addSales(creditDetail);
		
		return "redirect:/partydetail/"+pname;
	}
	@GetMapping("/Account")
	public ModelAndView modelAndView() {
		ModelAndView modelAndView=new ModelAndView("Account");
		List<Accounts> accountName=accountHolderService.getAccounts();
		
		modelAndView.addObject("accountName", accountName);
		return modelAndView;
	}

	@GetMapping("/Accountdetail/{aname}")
	public ModelAndView accountdetail(@PathVariable("aname") String aname) {
		ModelAndView mv=new ModelAndView("accountdetail");
		List<AccountName> accountName=accountService.accountdetail(aname);
		mv.addObject("accountName",accountName);
		mv.addObject("aname", aname);
		return mv;
	}	

	@GetMapping("/Account/{aname}")
	public ModelAndView addaccountdetail(@PathVariable("aname") String aname) {
		ModelAndView mv=new ModelAndView("addaccountdetail");
		mv.addObject("aname", aname);
		return mv;
	}	
	
	@PostMapping("/addDetail")
	public ModelAndView adddetail(@ModelAttribute("accountName") AccountName accountName) {
		accountService.addAccountDetail(accountName);
		return modelAndView();
	}
	@PostMapping("/addAccount")
	public ModelAndView addAccount(@RequestParam("accountholder") String accounth) {
		Accounts accountholder=new Accounts();
		accountholder.setAccountholder(accounth);
		accountHolderService.addAccount(accountholder);
		return modelAndView();
	}
	
}
