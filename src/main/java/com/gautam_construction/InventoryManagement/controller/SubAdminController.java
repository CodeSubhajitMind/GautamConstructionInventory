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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gautam_construction.InventoryManagement.DTO.brief_product_challan_dto;
import com.gautam_construction.InventoryManagement.DTO.filter_product_search_dto;
import com.gautam_construction.InventoryManagement.DTO.product_exit_by_challan_dto;
import com.gautam_construction.InventoryManagement.DTO.product_exit_by_contractor_dto;
import com.gautam_construction.InventoryManagement.DTO.product_exit_by_misc_dto;
import com.gautam_construction.InventoryManagement.DTO.product_exit_by_staff_dto;
import com.gautam_construction.InventoryManagement.model.contractor;
import com.gautam_construction.InventoryManagement.model.fuel;
import com.gautam_construction.InventoryManagement.model.fuel_entry;
import com.gautam_construction.InventoryManagement.model.fuel_exit;
import com.gautam_construction.InventoryManagement.model.location;
import com.gautam_construction.InventoryManagement.model.product;
import com.gautam_construction.InventoryManagement.model.product_add_by_challan;
import com.gautam_construction.InventoryManagement.model.product_add_by_ghy_office;
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
import com.gautam_construction.InventoryManagement.repository.fuel_entry_repository;
import com.gautam_construction.InventoryManagement.repository.fuel_exit_repository;
import com.gautam_construction.InventoryManagement.repository.fuel_repository;
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
	
	@Autowired
	private fuel_repository fr;
	
	@Autowired
	private fuel_entry_repository fer;
	
	@Autowired
	private fuel_exit_repository fexr;
	
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/SubAdminHome")
	public Object SubAdminHome(HttpSession session,Model model,Authentication authentication) {
		String user_id = session.getAttribute("userId").toString();
		String user_type = session.getAttribute("userType").toString();
		String office_name = session.getAttribute("officeName").toString();
		model.addAttribute("office_name", office_name);
		Date currentDate=new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        model.addAttribute("currentDate",formatter.format(currentDate));
		model.addAttribute("office_name", office_name);
        List<users> user_info = ur.getUserCredentiaLs(user_id);
        model.addAttribute("office_name", office_name);
		List<product> productList = pr.getAllProducts();
        List<staff> staffList = sr.getAllStaffs();
        List<contractor> contractorList = cr.getAllContractors();
        List<vehicle> vehicleList = vr.getAllVehicles();
        List<location> locationList = lr.getAllLocations();
        List<product_add_by_challan> prodAddChallanList = pacr.getAllProductAddByChallan();
        List<product_add_by_ghy_office> prodAddGhyOffice = pagor.getAllProductAddByGhyOffice();
        List<product_add_by_local_office> prodAddLocalOffice = palor.getAllProductAddByLocalOffice();
        List<product_exit_by_challan> prodExitChallan = pecr.getAllProductExitByChallan();
        List<product_exit_by_contractor> prodExitContractor = pecor.getAllProductExitByContractor();
        List<product_exit_by_miscellaneous> prodExitMiscellaneous = pemr.getAllProductExitByMiscellaneous();
        List<product_exit_by_staff> prodExitStaff = pesr.getAllProductExitByStaff();
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
        
        model.addAttribute("prodAddChallanList", prodAddChallanList);
        model.addAttribute("prodAddGhyOffice", prodAddGhyOffice);
        model.addAttribute("prodAddLocalOffice", prodAddLocalOffice);
        model.addAttribute("prodExitChallan", prodExitChallan);
        model.addAttribute("prodExitContractor", prodExitContractor);
        model.addAttribute("prodExitMiscellaneous", prodExitMiscellaneous);
        model.addAttribute("prodExitStaff", prodExitStaff);
        
        model.addAttribute("prodAddChallanCount", prodAddChallanList.size());
        model.addAttribute("prodAddGhyOfficeCount", prodAddGhyOffice.size());
        model.addAttribute("prodAddLocalOfficeCount", prodAddLocalOffice.size());
        model.addAttribute("prodExitChallanCount", prodExitChallan.size());
        model.addAttribute("prodExitContractorCount", prodExitContractor.size());
        model.addAttribute("prodExitMiscellaneousCount", prodExitMiscellaneous.size());
        model.addAttribute("prodExitStaffCount", prodExitStaff.size());
        
        List<brief_product_challan_dto> briefProdAddChallanList = pacr.getBriefProductAddByChallan();
        List<brief_product_challan_dto> briefProdAddGhyOfficeList = pagor.getBriefProductAddByGhyOffice();
        List<brief_product_challan_dto> briefProdAddLocalOfficeList = palor.getBriefProductAddByLocalOffice();
        
        List<brief_product_challan_dto> briefProdExitChallanList = pecr.getBriefProductExitByChallan();
        List<brief_product_challan_dto> briefProdExitContractorList = pecor.getBriefProductExitByContractor();
        List<brief_product_challan_dto> briefProdExitStaffList = pesr.getBriefProductExitByStaff();
        List<brief_product_challan_dto> briefProdExitMiscList = pemr.getBriefProductExitByMiscellaneous();

        model.addAttribute("briefProdAddChallanList", briefProdAddChallanList);
        model.addAttribute("briefProdAddGhyOfficeList", briefProdAddGhyOfficeList);
        model.addAttribute("briefProdAddLocalOfficeList", briefProdAddLocalOfficeList);
        
        model.addAttribute("briefProdExitChallanList", briefProdExitChallanList);
        model.addAttribute("briefProdExitContractorList", briefProdExitContractorList);
        model.addAttribute("briefProdExitStaffList", briefProdExitStaffList);
        model.addAttribute("briefProdExitMiscList", briefProdExitMiscList);
        
        List<fuel_entry> fuelEntryList = fer.getAllFuelEntry();
        model.addAttribute("fuelEntryList", fuelEntryList);
        
        List<fuel_exit> fuelExitList = fexr.getAllFuelExit();
        model.addAttribute("fuelExitList", fuelExitList);
        
        String petrol_quantity = fr.getFuelDetailsByType("petrol").get(0).getQuantity();
        String diesel_quantity = fr.getFuelDetailsByType("diesel").get(0).getQuantity();
        
        model.addAttribute("petrol_quantity", petrol_quantity);
        model.addAttribute("diesel_quantity", diesel_quantity);
        
        Integer fuel_stockout = (Integer) model.asMap().get("alert_fuel_stock_out");
        
        model.addAttribute("fuel_stockout", fuel_stockout);
        
        System.out.println("product info:"+productList.size());
        
        List<String> distinctVehicleTypeList = vr.getDistinctVehicleTypes();
        
        model.addAttribute("distinctVehicleTypeList", distinctVehicleTypeList);
        
        return "sub_admin_home";
	}
	
	@RequestMapping("/billDetails")
	public Object billDetails(HttpSession session,Model model,Authentication authentication,
			@RequestParam("challan_no") String challan_no,@RequestParam("type") String type) {
		String user_id = session.getAttribute("userId").toString();
		String user_type = session.getAttribute("userType").toString();
		String office_name = session.getAttribute("officeName").toString();
		model.addAttribute("office_name", office_name);
		Date currentDate=new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        model.addAttribute("currentDate",formatter.format(currentDate));
		model.addAttribute("office_name", office_name);
		model.addAttribute("challan_no", challan_no);
        if(type.equals("byChallan")) {
        	List<product_exit_by_challan_dto> challan_list = pecr.getAllProductExitByChallanChNo(challan_no);
        	model.addAttribute("challan_list", challan_list);
        	model.addAttribute("challan", 1);
        	return "bill_generate";
        }
        else if(type.equals("byContractor")) {
        	List<product_exit_by_contractor_dto> challan_list = pecor.getAllProductExitByContractorChNo(challan_no);
        	model.addAttribute("challan_list", challan_list);
        	model.addAttribute("contractor", 1);
        	model.addAttribute("contractor_name", challan_list.get(0).getContractor_name());
        	model.addAttribute("receiving_person", challan_list.get(0).getReceiving_person());
        	return "bill_generate_secondary";
        }
        else if(type.equals("byStaff")) {
        	List<product_exit_by_staff_dto> challan_list = pesr.getAllProductExitByStaff_ChNo(challan_no);
        	model.addAttribute("challan_list", challan_list);
        	model.addAttribute("staff", 1);
        	List<staff> staffDetails = sr.getAllStaffsByEmpCode(challan_list.get(0).getStaff_emp_code());
        	model.addAttribute("staff_name", staffDetails.get(0).getName());
        	model.addAttribute("staff_designation", staffDetails.get(0).getDesignation());
        	return "bill_generate_secondary";
        }
        else {
        	List<product_exit_by_misc_dto> challan_list = pemr.getAllProductExitByMiscellaneousChNo(challan_no);
        	model.addAttribute("challan_list", challan_list);
        	model.addAttribute("misc", 1);
        	model.addAttribute("work_name", challan_list.get(0).getWork_name());
        	model.addAttribute("receiving_person", challan_list.get(0).getReceiving_person());
        	return "bill_generate_secondary";
        }

		
	}
	
	@RequestMapping(value="/addProductEntryByChallan",method=RequestMethod.POST)
	public Object addProductEntryByChallan(
			@RequestParam("challan_no") String challan_no,
			@RequestParam("challan_date") String challan_date,
			@RequestParam("product_id") List<String> product_id,
			@RequestParam("product_quantity") List<String> product_quantity,
			@RequestParam("from_branch") List<String> from_branch,
			@RequestParam(value="vehicle_no", required = false) List<String> vehicle_no,
			@RequestParam("remarks") String remarks,
			HttpSession session,Model model,Authentication authentication) {
		String office_name = session.getAttribute("officeName").toString();
		for(int i=0;i<product_id.size();i++) {
			String bill_no = "SGCCL/Noonmati/2023-24/";
			Random random = new Random();
	        int num = random.nextInt(100000);
	        String formatted_serial_no = String.format("%05d", num);
	        List<product_add_by_challan> addprodList = pacr.getAllProductAddByChallan();
	        if(addprodList.size()>0) {
	        	String max_bill_no = pacr.getMaxBillnNo();
	        	if(max_bill_no.equals("0")) {
	        		bill_no = bill_no + formatted_serial_no;
	        	}
	        	else {
	        		Integer serial_no = Integer.parseInt(max_bill_no.split("/")[3])+1;
		        	bill_no = bill_no + serial_no;
	        	}
	        	
	        }
	        else {
	        	bill_no = bill_no + formatted_serial_no;
	        }
			Double quantity = 0.0;
			List<product> prodList = pr.getProductQuantity(Integer.parseInt(product_id.get(i)));
			System.out.println("product stock is: "+prodList.get(0).getQuantity());
			System.out.println("product to be added is: "+product_quantity.get(i));
			if(prodList.size()>0) {
				quantity = quantity + Double.parseDouble(prodList.get(0).getQuantity());
			}
			quantity = quantity + Double.parseDouble(product_quantity.get(i));
			System.out.println("product to be updated is: "+quantity);
			if(vehicle_no.isEmpty()) {
				pacr.InsertProductAddByChallan(Integer.parseInt(product_id.get(i)), product_quantity.get(i), challan_no, challan_date, from_branch.get(i), "",office_name,remarks,bill_no);
			}
			else {
				pacr.InsertProductAddByChallan(Integer.parseInt(product_id.get(i)), product_quantity.get(i), challan_no, challan_date, from_branch.get(i), vehicle_no.get(i),office_name,remarks,bill_no);
			}
			
			pr.UpdateProductQuantity(Integer.parseInt(product_id.get(i)), Double.toString(quantity));
			
			List<product> prodList1 = pr.getProductQuantity(Integer.parseInt(product_id.get(i)));
			System.out.println("product stock is: "+prodList1.get(0).getQuantity());
		}
		return "redirect:/SubAdminHome";
	}
	
	@RequestMapping(value="/addProductEntryByGhyOffice",method=RequestMethod.POST)
	public Object addProductEntryByGhyOffice(
			 @RequestParam("invoice_no") String invoice_no,
			@RequestParam("invoice_date") String invoice_date,
			@RequestParam(value="product_id", required = false) List<String> product_id,
			@RequestParam(value="product_quantity", required = false) List<String> product_quantity,
			@RequestParam(value="vendor_name", required = false) List<String> vendor_name,
			@RequestParam(value="vehicle_no", required = false) List<String> vehicle_no,
			@RequestParam("remarks") String remarks,
			HttpSession session,Model model,Authentication authentication) {
		String office_name = session.getAttribute("officeName").toString();
		for(int i=0;i<product_id.size();i++) {
			String bill_no = "SGCCL/Noonmati/2023-24/";
			Random random = new Random();
	        int num = random.nextInt(100000);
	        String formatted_serial_no = String.format("%05d", num);
	        List<product_add_by_ghy_office> addprodList = pagor.getAllProductAddByGhyOffice();
	        if(addprodList.size()>0) {
	        	String max_bill_no = pagor.getMaxBillnNo();
	        	if(max_bill_no.equals("0")) {
	        		bill_no = bill_no + formatted_serial_no;
	        	}
	        	else {
	        		Integer serial_no = Integer.parseInt(max_bill_no.split("/")[3])+1;
		        	bill_no = bill_no + serial_no;
	        	}
	        }
	        else {
	        	bill_no = bill_no + formatted_serial_no;
	        }
			Double quantity = 0.0;
			List<product> prodList = pr.getProductQuantity(Integer.parseInt(product_id.get(i)));
			if(prodList.size()>0) {
				quantity = quantity + Double.parseDouble(prodList.get(0).getQuantity());
			}
			quantity = quantity + Double.parseDouble(product_quantity.get(i));
			if(vehicle_no.isEmpty()) {
				pagor.InsertProductAddByGhyOffice(Integer.parseInt(product_id.get(i)), product_quantity.get(i), invoice_no, invoice_date, vendor_name.get(i), "",office_name,remarks,bill_no);
				
			}
			else {
				pagor.InsertProductAddByGhyOffice(Integer.parseInt(product_id.get(i)), product_quantity.get(i), invoice_no, invoice_date, vendor_name.get(i), vehicle_no.get(i),office_name,remarks,bill_no);
				
			}
			pr.UpdateProductQuantity(Integer.parseInt(product_id.get(i)), Double.toString(quantity));
		}
		return "redirect:/SubAdminHome";
	}
	
	@RequestMapping(value="/addFuelEntry",method=RequestMethod.POST)
	public Object addFuelEntry(
			@RequestParam("fuel_type") String fuel_type,
			@RequestParam("fuel_quantity") String fuel_quantity,
			@RequestParam("invoice_no") String invoice_no,
			@RequestParam("invoice_date") String invoice_date,
			@RequestParam("vendor_name") String vendor_name,
			@RequestParam("vehicle_no") String vehicle_no,
			HttpSession session,Model model,Authentication authentication) {
			String office_name = session.getAttribute("officeName").toString();
			Double quantity = 0.0;
			List<fuel> fuelList = fr.getFuelDetailsByType(fuel_type);
			if(fuelList.size()>0) {
				quantity = quantity + Double.parseDouble(fuelList.get(0).getQuantity());
			}
			quantity = quantity + Double.parseDouble(fuel_quantity);
			fer.InsertFuelAdd(fuel_type, fuel_quantity, invoice_no, invoice_date, vendor_name, vehicle_no);
			fr.UpdateFuelQuantity(fuel_type, Double.toString(quantity));
		return "redirect:/SubAdminHome";
	}
	
	@RequestMapping(value="/addFuelExit",method=RequestMethod.POST)
	public Object addFuelExit(
			RedirectAttributes redirectAttributes,
			@RequestParam("exit_type") String exit_type,
			@RequestParam("fuel_type") String fuel_type,
			@RequestParam("vehicle_no") String vehicle_no,
			@RequestParam("opening_reading") String opening_reading,
			@RequestParam("mileage") String mileage,
			@RequestParam("fuel_issue") String fuel_issue,
			@RequestParam("issue_date") String issue_date,
			@RequestParam("vehicle_type") String vehicle_type,
			HttpSession session,Model model,Authentication authentication) {
		String office_name = session.getAttribute("officeName").toString();
			Double quantity = 0.0;
			List<fuel> fuelList = fr.getFuelDetailsByType(fuel_type);
			if(fuelList.size()>0) {
				quantity = quantity + Double.parseDouble(fuelList.get(0).getQuantity());
			}
			if(Double.parseDouble(fuel_issue)>quantity) {
				redirectAttributes.addFlashAttribute("alert_fuel_stock_out", 1);
				return "redirect:/SubAdminHome";
			}
			quantity = quantity - Double.parseDouble(fuel_issue);
			fexr.InsertFuelExit(exit_type, fuel_type, vehicle_no, opening_reading, mileage, fuel_issue, issue_date, vehicle_type);
			fr.UpdateFuelQuantity(fuel_type, Double.toString(quantity));
		return "redirect:/SubAdminHome";
	}
	
	@RequestMapping(value="/addProductEntryBylocalOffice",method=RequestMethod.POST)
	public Object addProductEntryBylocalOffice(
			@RequestParam("invoice_no") String invoice_no,
			@RequestParam("invoice_date") String invoice_date,
			@RequestParam(value="product_id", required = false) List<String> product_id,
			@RequestParam(value="product_quantity", required = false) List<String> product_quantity,
			@RequestParam(value="vendor_name", required = false) List<String> vendor_name,
			@RequestParam(value="vehicle_no", required = false) List<String> vehicle_no,
			@RequestParam("remarks") String remarks,
			HttpSession session,Model model,Authentication authentication) {
		String office_name = session.getAttribute("officeName").toString();
		List<product_add_by_local_office> prodAddList =  palor.getAllProductAddByLocalOffice();
		Integer serial_no = 100;
		String new_serial_no = "";
		if(prodAddList.size()>0) {
			String max_serial_no = palor.getMaxSerialNumber();
			if(max_serial_no.equals("0")) {
				new_serial_no = "SGCCL/Noonmati/2023-24/"+serial_no;
			}
			else {
				serial_no = Integer.parseInt(max_serial_no.split("/")[3])+1;
				new_serial_no = max_serial_no.split("/")[0] + "/" + max_serial_no.split("/")[1] + "/" + max_serial_no.split("/")[2] + "/" + Integer.toString(serial_no);
			}
			
		}
		else {
			new_serial_no = "SGCCL/Noonmati/2023-24/"+serial_no;
		}
		for(int i=0;i<product_id.size();i++) {
			Double quantity = 0.0;
			List<product> prodList = pr.getProductQuantity(Integer.parseInt(product_id.get(i)));
			if(prodList.size()>0) {
				quantity = quantity + Double.parseDouble(prodList.get(0).getQuantity());
			}
			quantity = quantity + Double.parseDouble(product_quantity.get(i));
			if(vehicle_no.isEmpty()) {
				palor.InsertProductAddByLocalOffice(Integer.parseInt(product_id.get(i)), product_quantity.get(i), invoice_no, invoice_date, vendor_name.get(i), "", new_serial_no,office_name,remarks);
				
			}
			else {
				palor.InsertProductAddByLocalOffice(Integer.parseInt(product_id.get(i)), product_quantity.get(i), invoice_no, invoice_date, vendor_name.get(i), vehicle_no.get(i), new_serial_no,office_name,remarks);
				
			}
			pr.UpdateProductQuantity(Integer.parseInt(product_id.get(i)), Double.toString(quantity));
		}

		return "redirect:/SubAdminHome";
	}
	
	@ResponseBody
	@RequestMapping(value="/addProductExitByChallan",method=RequestMethod.POST)
	public Object addProductExitByChallan(
			@RequestParam("exit_date") String exit_date,
			@RequestParam(value="product_id", required = false) List<String> product_id,
			@RequestParam(value="product_quantity", required = false) List<String> product_quantity,
			@RequestParam(value="to_location", required = false) List<String> to_location,
			@RequestParam(value="vehicle_no", required = false) List<String> vehicle_no,
			HttpSession session,Model model,Authentication authentication) {
		String office_name = session.getAttribute("officeName").toString();
		String challan_no = "SGCCL/Noonmati/2023-24/";
		Random random = new Random();
        int num = random.nextInt(100000);
        String formatted_serial_no = String.format("%05d", num);
        List<product_exit_by_challan> exitprodList = pecr.getAllProductExitByChallan();
        if(exitprodList.size()>0) {
        	String max_challan_no = pecr.getMaxChallanNo();
        	Integer serial_no = Integer.parseInt(max_challan_no.split("/")[3])+1;
        	challan_no = challan_no + serial_no;
        }
        else {
        	challan_no = challan_no + formatted_serial_no;
        }
        String bill = "";
        for(int i=0;i<product_id.size();i++) {
        	Double quantity = 0.0;
    		List<product> prodList = pr.getProductQuantity(Integer.parseInt(product_id.get(i)));
    		if(prodList.size()>0) {
    			quantity = Double.parseDouble(prodList.get(0).getQuantity()) - Double.parseDouble(product_quantity.get(i));
    		}
            
            pecr.InsertProductExitByChallan(Integer.parseInt(product_id.get(i)), product_quantity.get(i), challan_no, exit_date, to_location.get(i), vehicle_no.get(i), bill,office_name);
            pr.UpdateProductQuantity(Integer.parseInt(product_id.get(i)), Double.toString(quantity));
        }
        
        List<String> returnList = new ArrayList<>();
        returnList.add(challan_no);
//        returnList.add(prodList.get(0).getName());
//        returnList.add(Double.toString(quantity));
        return returnList;
	}
	
	@ResponseBody
	@RequestMapping(value="/addProductExitByContractor",method=RequestMethod.POST)
	public Object addProductExitByContractor(
			@RequestParam("exit_date") String exit_date,
			@RequestParam("product_id") List<String> product_id,
			@RequestParam("product_quantity") List<String> product_quantity,
			@RequestParam("contractor_name") List<String> contractor_name,
			@RequestParam("receiving_person") List<String> receiving_person,
			HttpSession session,Model model,Authentication authentication) {
		String office_name = session.getAttribute("officeName").toString();
		String challan_no = "SGCCL/Noonmati/2023-24/";
		Random random = new Random();
        int num = random.nextInt(100000);
        String formatted_serial_no = String.format("%05d", num);
        List<product_exit_by_contractor> exitprodList = pecor.getAllProductExitByContractor();
        if(exitprodList.size()>0) {
        	String max_challan_no = pecor.getMaxChallanNo();
        	Integer serial_no = Integer.parseInt(max_challan_no.split("/")[3])+1;
        	challan_no = challan_no + serial_no;
        }
        else {
        	challan_no = challan_no + formatted_serial_no;
        }
		String bill = "";
		for(int i=0;i<product_id.size();i++) {
			Double quantity = 0.0;
			List<product> prodList = pr.getProductQuantity(Integer.parseInt(product_id.get(i)));
			if(prodList.size()>0) {
				quantity = Double.parseDouble(prodList.get(0).getQuantity()) - Double.parseDouble(product_quantity.get(i));
			}
			pecor.InsertProductExitByContractor(Integer.parseInt(product_id.get(i)), product_quantity.get(i), challan_no, exit_date, contractor_name.get(i), receiving_person.get(i), bill,office_name);
			pr.UpdateProductQuantity(Integer.parseInt(product_id.get(i)), Double.toString(quantity));
		}
		
		List<String> returnList = new ArrayList<>();
        returnList.add(challan_no);
        //returnList.add(prodList.get(0).getName());
        //returnList.add(Double.toString(quantity));
		return returnList;
	}
	
	@ResponseBody
	@RequestMapping(value="/addProductExitByStaff",method=RequestMethod.POST)
	public Object addProductExitByStaff(
			@RequestParam("exit_date") String exit_date,
			@RequestParam("product_id") List<String> product_id,
			@RequestParam("product_quantity") List<String> product_quantity,
			@RequestParam("staff_emp_code") List<String> staff_emp_code,
			@RequestParam("receiving_person") List<String> receiving_person,
			HttpSession session,Model model,Authentication authentication) {
		String office_name = session.getAttribute("officeName").toString();
		String challan_no = "SGCCL/Noonmati/2023-24/";
		Random random = new Random();
        int num = random.nextInt(100000);
        String formatted_serial_no = String.format("%05d", num);
        List<product_exit_by_staff> exitprodList = pesr.getAllProductExitByStaff();
        if(exitprodList.size()>0) {
        	String max_challan_no = pesr.getMaxChallanNo();
        	Integer serial_no = Integer.parseInt(max_challan_no.split("/")[3])+1;
        	challan_no = challan_no + serial_no;
        }
        else {
        	challan_no = challan_no + formatted_serial_no;
        }
		String bill = "";
		for(int i=0;i<product_id.size();i++) {
			Double quantity = 0.0;
			List<product> prodList = pr.getProductQuantity(Integer.parseInt(product_id.get(i)));
			if(prodList.size()>0) {
				quantity = Double.parseDouble(prodList.get(0).getQuantity()) - Double.parseDouble(product_quantity.get(i));
			}
			pesr.InsertProductExitByStaff(Integer.parseInt(product_id.get(i)), product_quantity.get(i), challan_no, exit_date, staff_emp_code.get(i), receiving_person.get(i), bill,office_name);
			pr.UpdateProductQuantity(Integer.parseInt(product_id.get(i)), Double.toString(quantity));
		}
		
		List<String> returnList = new ArrayList<>();
        returnList.add(challan_no);
        //returnList.add(prodList.get(0).getName());
        //returnList.add(Double.toString(quantity));
		return returnList;
	}
	
	@ResponseBody
	@RequestMapping(value="/addProductExitByMiscellaneous",method=RequestMethod.POST)
	public Object addProductExitByMiscellaneous(
			@RequestParam("exit_date") String exit_date,
			@RequestParam("product_id") List<String> product_id,
			@RequestParam("product_quantity") List<String> product_quantity,
			@RequestParam("work_name") List<String> work_name,
			@RequestParam("receiving_person") List<String> receiving_person,
			HttpSession session,Model model,Authentication authentication) {
		String office_name = session.getAttribute("officeName").toString();
		String challan_no = "SGCCL/Noonmati/2023-24/";
		Random random = new Random();
        int num = random.nextInt(100000);
        String formatted_serial_no = String.format("%05d", num);
        List<product_exit_by_miscellaneous> exitprodList = pemr.getAllProductExitByMiscellaneous();
        if(exitprodList.size()>0) {
        	String max_challan_no = pemr.getMaxChallanNo();
        	Integer serial_no = Integer.parseInt(max_challan_no.split("/")[3])+1;
        	challan_no = challan_no + serial_no;
        }
        else {
        	challan_no = challan_no + formatted_serial_no;
        }
		String bill = "";
		for(int i=0;i<product_id.size();i++) {
			Double quantity = 0.0;
			List<product> prodList = pr.getProductQuantity(Integer.parseInt(product_id.get(i)));
			if(prodList.size()>0) {
				quantity = Double.parseDouble(prodList.get(0).getQuantity()) - Double.parseDouble(product_quantity.get(i));
			}
			pemr.InsertProductExitByMiscellaneous(Integer.parseInt(product_id.get(i)), product_quantity.get(i), challan_no, exit_date, work_name.get(i), receiving_person.get(i), bill,office_name);
			pr.UpdateProductQuantity(Integer.parseInt(product_id.get(i)), Double.toString(quantity));
		}
		
		List<String> returnList = new ArrayList<>();
        returnList.add(challan_no);
        //returnList.add(prodList.get(0).getName());
        //returnList.add(Double.toString(quantity));
		return returnList;
	}
	
	@ResponseBody
	@RequestMapping(value="/getProductDetails",method=RequestMethod.GET)
	public Object getProductDetails(@RequestParam("product_id") String product_id,
			HttpSession session,Model model,Authentication authentication) {
		List<product> prodList = pr.getProductQuantity(Integer.parseInt(product_id));
		return prodList.get(0);
	}
	
	@ResponseBody
	@RequestMapping(value="/getProductEntryDetails",method=RequestMethod.GET)
	public Object getProductEntryDetails(@RequestParam(name="entry_type", required = false) String entry_type,
			@RequestParam(name="entry_date", required = false) String entry_date,
			@RequestParam(name="entry_product_id", required = false) String entry_product_id,
			HttpSession session,Model model,Authentication authentication) {
		List<filter_product_search_dto> filtered_product_list = new ArrayList<>();
		if(entry_type.equals("by_challan")) {
			filtered_product_list.addAll(pacr.getProductFilterBySearch(entry_product_id, entry_date));
		}
		else if(entry_type.equals("by_ghy_office")) {
			filtered_product_list.addAll(pagor.getProductFilterBySearch(entry_product_id, entry_date));
		}
		else if(entry_type.equals("by_local_purchase")) {
			filtered_product_list.addAll(palor.getProductFilterBySearch(entry_product_id, entry_date));
		}
		else {
			filtered_product_list.addAll(pacr.getProductFilterBySearch(entry_product_id, entry_date));
			filtered_product_list.addAll(pagor.getProductFilterBySearch(entry_product_id, entry_date));
			filtered_product_list.addAll(palor.getProductFilterBySearch(entry_product_id, entry_date));
		}
		return filtered_product_list;
	}
	
	@ResponseBody
	@RequestMapping(value="/getProductExitDetails",method=RequestMethod.GET)
	public Object getProductExitDetails(@RequestParam(name="exit_type", required = false) String exit_type,
			@RequestParam(name="exit_date", required = false) String exit_date,
			@RequestParam(name="exit_product_id", required = false) String exit_product_id,
			HttpSession session,Model model,Authentication authentication) {
		List<filter_product_search_dto> filtered_product_list = new ArrayList<>();
		if(exit_type.equals("by_challan")) {
			filtered_product_list.addAll(pecr.getProductFilterBySearch(exit_product_id, exit_date));
		}
		else if(exit_type.equals("by_staff")) {
			filtered_product_list.addAll(pesr.getProductFilterBySearch(exit_product_id, exit_date));
		}
		else if(exit_type.equals("by_contractor")) {
			filtered_product_list.addAll(pecor.getProductFilterBySearch(exit_product_id, exit_date));
		}
		else if(exit_type.equals("by_misc")) {
			filtered_product_list.addAll(pemr.getProductFilterBySearch(exit_product_id, exit_date));
		}
		else {
			filtered_product_list.addAll(pecr.getProductFilterBySearch(exit_product_id, exit_date));
			filtered_product_list.addAll(pesr.getProductFilterBySearch(exit_product_id, exit_date));
			filtered_product_list.addAll(pecor.getProductFilterBySearch(exit_product_id, exit_date));
			filtered_product_list.addAll(pemr.getProductFilterBySearch(exit_product_id, exit_date));
		}
		return filtered_product_list;
	}
}
