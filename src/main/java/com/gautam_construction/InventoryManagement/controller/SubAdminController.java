package com.gautam_construction.InventoryManagement.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gautam_construction.InventoryManagement.model.contractor;
import com.gautam_construction.InventoryManagement.model.location;
import com.gautam_construction.InventoryManagement.model.product;
import com.gautam_construction.InventoryManagement.model.product_add_by_local_office;
import com.gautam_construction.InventoryManagement.model.product_exit_by_challan;
import com.gautam_construction.InventoryManagement.model.product_exit_by_contractor;
import com.gautam_construction.InventoryManagement.model.product_exit_by_miscellaneous;
import com.gautam_construction.InventoryManagement.model.product_exit_by_staff;
import com.gautam_construction.InventoryManagement.model.staff;
import com.gautam_construction.InventoryManagement.model.users;
import com.gautam_construction.InventoryManagement.model.vehicle;
import com.gautam_construction.InventoryManagement.repository.ContractorRepository;
import com.gautam_construction.InventoryManagement.repository.LocationRepository;
import com.gautam_construction.InventoryManagement.repository.ProductRepository;
import com.gautam_construction.InventoryManagement.repository.StaffRepository;
import com.gautam_construction.InventoryManagement.repository.VehicleRepository;
import com.gautam_construction.InventoryManagement.repository.product_add_by_challan_repository;
import com.gautam_construction.InventoryManagement.repository.product_add_by_ghy_office_repository;
import com.gautam_construction.InventoryManagement.repository.product_add_by_local_office_repository;
import com.gautam_construction.InventoryManagement.repository.product_exit_by_challan_repository;
import com.gautam_construction.InventoryManagement.repository.product_exit_by_contractor_repository;
import com.gautam_construction.InventoryManagement.repository.product_exit_by_miscellaneous_repository;
import com.gautam_construction.InventoryManagement.repository.product_exit_by_staff_repository;
import com.gautam_construction.InventoryManagement.repository.userRepository;

@Controller
public class SubAdminController {
	@Autowired
	private userRepository ur;
	@Autowired
	private ProductRepository pr;
	@Autowired
	private StaffRepository sr;
	@Autowired
	private ContractorRepository cr;
	@Autowired
	private VehicleRepository vr;
	@Autowired
	private LocationRepository lr;
	
	@Autowired
	private product_add_by_challan_repository pacr;
	@Autowired
	private product_add_by_ghy_office_repository pagor;
	@Autowired
	private product_add_by_local_office_repository palor;
	
	@Autowired
	private product_exit_by_challan_repository pecr;
	@Autowired
	private product_exit_by_contractor_repository pecor;
	@Autowired
	private product_exit_by_staff_repository pesr;
	@Autowired
	private product_exit_by_miscellaneous_repository pemr;
	
	@RequestMapping("/SubAdminHome")
	public Object SubAdminHome(HttpSession session,Model model,Authentication authentication) {
		@SuppressWarnings("unchecked")
		String user_id = session.getAttribute("userId").toString();
		String user_type = session.getAttribute("userType").toString();
		String office_name = session.getAttribute("officeName").toString();
		model.addAttribute("office_name", office_name);
		Date currentDate=new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        model.addAttribute("currentDate",formatter.format(currentDate));
		model.addAttribute("office_name", office_name);
        List<users> user_info = ur.getUserCredentiaLs(Integer.parseInt(user_id));
        model.addAttribute("office_name", office_name);
		List<product> productList = pr.getAllProducts();
        List<staff> staffList = sr.getAllStaffs();
        List<contractor> contractorList = cr.getAllContractors();
        List<vehicle> vehicleList = vr.getAllVehicles();
        List<location> locationList = lr.getAllLocations();
        model.addAttribute("productList", productList);
        model.addAttribute("staffList", staffList);
        model.addAttribute("contractorList", contractorList);
        model.addAttribute("vehicleList", vehicleList);
        model.addAttribute("locationList", locationList);
        
        model.addAttribute("productCount", productList.size());
        model.addAttribute("staffCount", staffList.size());
        model.addAttribute("contractorCount", contractorList.size());
        model.addAttribute("vehicleCount", vehicleList.size());
        model.addAttribute("locationCount", locationList.size());
        
        System.out.println("product info:"+productList.size());
        return "sub_admin_home";
	}
	
	@RequestMapping(value="/addProductEntryByChallan",method=RequestMethod.POST)
	public Object addProductEntryByChallan(@RequestParam("product_id") String product_id,
			@RequestParam("product_quantity") String product_quantity,
			@RequestParam("challan_no") String challan_no,
			@RequestParam("challan_date") String challan_date,
			@RequestParam("from_branch") String from_branch,
			@RequestParam("vehicle_no") String vehicle_no,
			HttpSession session,Model model,Authentication authentication) {
		Double quantity = 0.0;
		List<product> prodList = pr.getProductQuantity(Integer.parseInt(product_id));
		if(prodList.size()>0) {
			quantity = quantity + Double.parseDouble(prodList.get(0).getQuantity());
		}
		quantity = quantity + Double.parseDouble(product_quantity);
		pacr.InsertProductAddByChallan(Integer.parseInt(product_id), product_quantity, challan_no, challan_date, from_branch, vehicle_no);
		pr.UpdateProductQuantity(Integer.parseInt(product_id), Double.toString(quantity));
		return "redirect:/SubAdminHome";
	}
	
	@RequestMapping(value="/addProductEntryByGhyOffice",method=RequestMethod.POST)
	public Object addProductEntryByGhyOffice(@RequestParam("product_id") String product_id,
			@RequestParam("product_quantity") String product_quantity,
			@RequestParam("invoice_no") String invoice_no,
			@RequestParam("invoice_date") String invoice_date,
			@RequestParam("vendor_name") String vendor_name,
			@RequestParam("vehicle_no") String vehicle_no,
			HttpSession session,Model model,Authentication authentication) {
		Double quantity = 0.0;
		List<product> prodList = pr.getProductQuantity(Integer.parseInt(product_id));
		if(prodList.size()>0) {
			quantity = quantity + Double.parseDouble(prodList.get(0).getQuantity());
		}
		quantity = quantity + Double.parseDouble(product_quantity);
		pagor.InsertProductAddByGhyOffice(Integer.parseInt(product_id), product_quantity, invoice_no, invoice_date, vendor_name, vehicle_no);
		pr.UpdateProductQuantity(Integer.parseInt(product_id), Double.toString(quantity));
		return "redirect:/SubAdminHome";
	}
	
	@RequestMapping(value="/addProductEntryBylocalOffice",method=RequestMethod.POST)
	public Object addProductEntryBylocalOffice(@RequestParam("product_id") String product_id,
			@RequestParam("product_quantity") String product_quantity,
			@RequestParam("invoice_no") String invoice_no,
			@RequestParam("invoice_date") String invoice_date,
			@RequestParam("vendor_name") String vendor_name,
			@RequestParam("vehicle_no") String vehicle_no,
			HttpSession session,Model model,Authentication authentication) {
		List<product_add_by_local_office> prodAddList =  palor.getAllProductAddByLocalOffice();
		Integer serial_no = 100;
		String new_serial_no = "";
		if(prodAddList.size()>0) {
			String max_serial_no = palor.getMaxSerialNumber();
			serial_no = Integer.parseInt(max_serial_no.split("/")[3])+1;
			new_serial_no = max_serial_no.split("/")[0] + "/" + max_serial_no.split("/")[1] + "/" + max_serial_no.split("/")[2] + "/" + Integer.toString(serial_no);
		}
		else {
			new_serial_no = "SGCCL/Noonmati/2023-24/"+serial_no;
		}
		
		Double quantity = 0.0;
		List<product> prodList = pr.getProductQuantity(Integer.parseInt(product_id));
		if(prodList.size()>0) {
			quantity = quantity + Double.parseDouble(prodList.get(0).getQuantity());
		}
		quantity = quantity + Double.parseDouble(product_quantity);
		
		palor.InsertProductAddByLocalOffice(Integer.parseInt(product_id), product_quantity, invoice_no, invoice_date, vendor_name, vehicle_no, new_serial_no);
		pr.UpdateProductQuantity(Integer.parseInt(product_id), Double.toString(quantity));
		return "redirect:/SubAdminHome";
	}
	
	@ResponseBody
	@RequestMapping(value="/addProductExitByChallan",method=RequestMethod.POST)
	public Object addProductExitByChallan(@RequestParam("product_id") String product_id,
			@RequestParam("product_quantity") String product_quantity,
			@RequestParam("exit_date") String exit_date,
			@RequestParam("to_location") String to_location,
			@RequestParam("vehicle_no") String vehicle_no,
			HttpSession session,Model model,Authentication authentication) {
		String challan_no = "SGCCL/";
		Random random = new Random();
        int num = random.nextInt(100000);
        String formatted_serial_no = String.format("%05d", num);
        List<product_exit_by_challan> exitprodList = pecr.getAllProductExitByChallan();
        if(exitprodList.size()>0) {
        	String max_challan_no = pecr.getMaxChallanNo();
        	Integer serial_no = Integer.parseInt(max_challan_no.split("/")[1])+1;
        	challan_no = challan_no + serial_no;
        }
        else {
        	challan_no = challan_no + formatted_serial_no;
        }
        String bill = "";
        
        Double quantity = 0.0;
		List<product> prodList = pr.getProductQuantity(Integer.parseInt(product_id));
		if(prodList.size()>0) {
			quantity = Double.parseDouble(prodList.get(0).getQuantity()) - Double.parseDouble(product_quantity);
		}
        
        pecr.InsertProductExitByChallan(Integer.parseInt(product_id), product_quantity, challan_no, exit_date, to_location, vehicle_no, bill);
        pr.UpdateProductQuantity(Integer.parseInt(product_id), Double.toString(quantity));
        List<String> returnList = new ArrayList<>();
        returnList.add(challan_no);
        returnList.add(prodList.get(0).getName());
        returnList.add(Double.toString(quantity));
        return returnList;
	}
	
	@ResponseBody
	@RequestMapping(value="/addProductExitByContractor",method=RequestMethod.POST)
	public Object addProductExitByContractor(@RequestParam("product_id") String product_id,
			@RequestParam("product_quantity") String product_quantity,
			@RequestParam("exit_date") String exit_date,
			@RequestParam("contractor_name") String contractor_name,
			@RequestParam("receiving_person") String receiving_person,
			HttpSession session,Model model,Authentication authentication) {
		String challan_no = "SGCCL/";
		Random random = new Random();
        int num = random.nextInt(100000);
        String formatted_serial_no = String.format("%05d", num);
        List<product_exit_by_contractor> exitprodList = pecor.getAllProductExitByContractor();
        if(exitprodList.size()>0) {
        	String max_challan_no = pecr.getMaxChallanNo();
        	Integer serial_no = Integer.parseInt(max_challan_no.split("/")[1])+1;
        	challan_no = challan_no + serial_no;
        }
        else {
        	challan_no = challan_no + formatted_serial_no;
        }
		String bill = "";
		Double quantity = 0.0;
		List<product> prodList = pr.getProductQuantity(Integer.parseInt(product_id));
		if(prodList.size()>0) {
			quantity = Double.parseDouble(prodList.get(0).getQuantity()) - Double.parseDouble(product_quantity);
		}
		pecor.InsertProductExitByContractor(Integer.parseInt(product_id), product_quantity, challan_no, exit_date, contractor_name, receiving_person, bill);
		pr.UpdateProductQuantity(Integer.parseInt(product_id), Double.toString(quantity));
		List<String> returnList = new ArrayList<>();
        returnList.add(challan_no);
        returnList.add(prodList.get(0).getName());
        returnList.add(Double.toString(quantity));
		return returnList;
	}
	
	@ResponseBody
	@RequestMapping(value="/addProductExitByStaff",method=RequestMethod.POST)
	public Object addProductExitByStaff(@RequestParam("product_id") String product_id,
			@RequestParam("product_quantity") String product_quantity,
			@RequestParam("exit_date") String exit_date,
			@RequestParam("staff_emp_code") String staff_emp_code,
			@RequestParam("receiving_person") String receiving_person,
			HttpSession session,Model model,Authentication authentication) {
		String challan_no = "SGCCL/";
		Random random = new Random();
        int num = random.nextInt(100000);
        String formatted_serial_no = String.format("%05d", num);
        List<product_exit_by_staff> exitprodList = pesr.getAllProductExitByStaff();
        if(exitprodList.size()>0) {
        	String max_challan_no = pecr.getMaxChallanNo();
        	Integer serial_no = Integer.parseInt(max_challan_no.split("/")[1])+1;
        	challan_no = challan_no + serial_no;
        }
        else {
        	challan_no = challan_no + formatted_serial_no;
        }
		String bill = "";
		Double quantity = 0.0;
		List<product> prodList = pr.getProductQuantity(Integer.parseInt(product_id));
		if(prodList.size()>0) {
			quantity = Double.parseDouble(prodList.get(0).getQuantity()) - Double.parseDouble(product_quantity);
		}
		pesr.InsertProductExitByStaff(Integer.parseInt(product_id), product_quantity, challan_no, exit_date, staff_emp_code, receiving_person, bill);
		pr.UpdateProductQuantity(Integer.parseInt(product_id), Double.toString(quantity));
		List<String> returnList = new ArrayList<>();
        returnList.add(challan_no);
        returnList.add(prodList.get(0).getName());
        returnList.add(Double.toString(quantity));
		return returnList;
	}
	
	@ResponseBody
	@RequestMapping(value="/addProductExitByMiscellaneous",method=RequestMethod.POST)
	public Object addProductExitByMiscellaneous(@RequestParam("product_id") String product_id,
			@RequestParam("product_quantity") String product_quantity,
			@RequestParam("exit_date") String exit_date,
			@RequestParam("work_name") String work_name,
			@RequestParam("receiving_person") String receiving_person,
			HttpSession session,Model model,Authentication authentication) {
		String challan_no = "SGCCL/";
		Random random = new Random();
        int num = random.nextInt(100000);
        String formatted_serial_no = String.format("%05d", num);
        List<product_exit_by_miscellaneous> exitprodList = pemr.getAllProductExitByMiscellaneous();
        if(exitprodList.size()>0) {
        	String max_challan_no = pecr.getMaxChallanNo();
        	Integer serial_no = Integer.parseInt(max_challan_no.split("/")[1])+1;
        	challan_no = challan_no + serial_no;
        }
        else {
        	challan_no = challan_no + formatted_serial_no;
        }
		String bill = "";
		Double quantity = 0.0;
		List<product> prodList = pr.getProductQuantity(Integer.parseInt(product_id));
		if(prodList.size()>0) {
			quantity = Double.parseDouble(prodList.get(0).getQuantity()) - Double.parseDouble(product_quantity);
		}
		pemr.InsertProductExitByMiscellaneous(Integer.parseInt(product_id), product_quantity, challan_no, exit_date, work_name, receiving_person, bill);
		pr.UpdateProductQuantity(Integer.parseInt(product_id), Double.toString(quantity));
		List<String> returnList = new ArrayList<>();
        returnList.add(challan_no);
        returnList.add(prodList.get(0).getName());
        returnList.add(Double.toString(quantity));
		return returnList;
	}
	
	@ResponseBody
	@RequestMapping(value="/getProductDetails",method=RequestMethod.GET)
	public Object getProductDetails(@RequestParam("product_id") String product_id,
			HttpSession session,Model model,Authentication authentication) {
		List<product> prodList = pr.getProductQuantity(Integer.parseInt(product_id));
		return prodList.get(0);
	}
}
