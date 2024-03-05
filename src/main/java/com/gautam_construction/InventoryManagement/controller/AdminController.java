package com.gautam_construction.InventoryManagement.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.gautam_construction.InventoryManagement.DTO.brief_product_challan_dto;
import com.gautam_construction.InventoryManagement.model.contractor;
import com.gautam_construction.InventoryManagement.model.fuel_entry;
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
import com.gautam_construction.InventoryManagement.repository.fuel_repository;
import com.gautam_construction.InventoryManagement.repository.product_add_by_challan_repository;
import com.gautam_construction.InventoryManagement.repository.product_add_by_ghy_office_repository;
import com.gautam_construction.InventoryManagement.repository.product_add_by_local_office_repository;
import com.gautam_construction.InventoryManagement.repository.product_exit_by_challan_repository;
import com.gautam_construction.InventoryManagement.repository.product_exit_by_contractor_repository;
import com.gautam_construction.InventoryManagement.repository.product_exit_by_miscellaneous_repository;
import com.gautam_construction.InventoryManagement.repository.product_exit_by_staff_repository;
import com.gautam_construction.InventoryManagement.repository.userRepository;
import com.gautam_construction.InventoryManagement.repository.user_roles_repository;
import com.gautam_construction.InventoryManagement.services.loginServices;


@Controller
public class AdminController {
	@Autowired
	private userRepository ur;
	@Autowired
	private user_roles_repository urr;
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
	private loginServices ls;
	
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
	
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.ENGLISH);
	
	@RequestMapping("/AdminHome")
	public Object AdminHome(HttpSession session,Model model,Authentication authentication) {
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
        //return "admin_home";
        return "redirect:/AdminGeneralStoreHome";
	}
	
	@RequestMapping("/AdminGeneralStoreHome")
	public Object AdminGeneralStoreHome(HttpSession session,Model model,Authentication authentication) {
		String user_id = session.getAttribute("userId").toString();
		String user_type = session.getAttribute("userType").toString();
		String office_name = session.getAttribute("officeName").toString();
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
        
        List<users> user_info_all_admin = ur.getAllAdminCredentiaLs();
        List<users> user_info_all_sub_admin = ur.getAllSubAdminCredentiaLs();
        model.addAttribute("admin_user_list", user_info_all_admin);
        model.addAttribute("sub_admin_user_list", user_info_all_sub_admin);
        
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
        
        List<product_add_by_challan> prodAddChallanList = pacr.getAllProductAddByChallan();
        List<product_add_by_ghy_office> prodAddGhyOffice = pagor.getAllProductAddByGhyOffice();
        List<product_add_by_local_office> prodAddLocalOffice = palor.getAllProductAddByLocalOffice();
        List<product_exit_by_challan> prodExitChallan = pecr.getAllProductExitByChallan();
        List<product_exit_by_contractor> prodExitContractor = pecor.getAllProductExitByContractor();
        List<product_exit_by_miscellaneous> prodExitMiscellaneous = pemr.getAllProductExitByMiscellaneous();
        List<product_exit_by_staff> prodExitStaff = pesr.getAllProductExitByStaff();
        
        model.addAttribute("prodAddChallanCount", prodAddChallanList.size());
        model.addAttribute("prodAddGhyOfficeCount", prodAddGhyOffice.size());
        model.addAttribute("prodAddLocalOfficeCount", prodAddLocalOffice.size());
        model.addAttribute("prodExitChallanCount", prodExitChallan.size());
        model.addAttribute("prodExitContractorCount", prodExitContractor.size());
        model.addAttribute("prodExitMiscellaneousCount", prodExitMiscellaneous.size());
        model.addAttribute("prodExitStaffCount", prodExitStaff.size());
        
        
        List<fuel_entry> fuelEntryList = fer.getAllFuelEntry();
        model.addAttribute("fuelEntryList", fuelEntryList);
        
        String petrol_quantity = fr.getFuelDetailsByType("petrol").get(0).getQuantity();
        String diesel_quantity = fr.getFuelDetailsByType("diesel").get(0).getQuantity();
        
        model.addAttribute("petrol_quantity", petrol_quantity);
        model.addAttribute("diesel_quantity", diesel_quantity);
        
        
        System.out.println("product info:"+productList.size());
		return "admin_general_store";
	}
	
	@RequestMapping(value="/editProduct",method=RequestMethod.GET)
	public Object editProduct(@RequestParam("prod_id") String prod_id,
			HttpSession session,Model model,Authentication authentication) {
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
        List<product> prodList = pr.getProductQuantity(Integer.parseInt(prod_id));
        model.addAttribute("prod_id", prod_id);
        model.addAttribute("prod_name", prodList.get(0).getName());
        model.addAttribute("prod_unit", prodList.get(0).getUnit());
        model.addAttribute("prod_quantity", prodList.get(0).getQuantity());
        model.addAttribute("prod_type", prodList.get(0).getType());
        //return "admin_home";
        return "edit_product";
	}
	
	@RequestMapping(value="/addAdmin",method=RequestMethod.POST)
	public Object addAdmin(@RequestParam("name_sub_admin") String name_sub_admin,
			@RequestParam("user_id_sub_admin") String user_id_sub_admin) throws Exception {
		String pass = "abc123";
		String usertype = "A";
		Date now = new Date();
		String today_str = formatter.format(now);
		String encryptedPass = ls.hashPassword(pass);
		ur.registerOfficeDetails(Integer.parseInt(user_id_sub_admin), encryptedPass, name_sub_admin, usertype, today_str);
		urr.regsiterNewUserRole(Integer.parseInt(user_id_sub_admin), 1);
		return "redirect:/AdminGeneralStoreHome";
	}
	
	@RequestMapping(value="/addSubAdmin",method=RequestMethod.POST)
	public Object addSubAdmin(@RequestParam("name_sub_admin") String name_sub_admin,
			@RequestParam("user_id_sub_admin") String user_id_sub_admin) throws Exception {
		String pass = "abc123";
		String usertype = "SA";
		Date now = new Date();
		String today_str = formatter.format(now);
		String encryptedPass = ls.hashPassword(pass);
		ur.registerOfficeDetails(Integer.parseInt(user_id_sub_admin), encryptedPass, name_sub_admin, usertype, today_str);
		urr.regsiterNewUserRole(Integer.parseInt(user_id_sub_admin), 2);
		return "redirect:/AdminGeneralStoreHome";
	}
	
	@RequestMapping(value="/addProduct",method=RequestMethod.POST)
	public Object addProduct(@RequestParam("product_name") String product_name,
			@RequestParam("product_unit") String product_unit,
			@RequestParam("product_quantity") String product_quantity,
			@RequestParam("product_type") String product_type) {
		pr.InsertProductDetails(product_name, product_unit, product_quantity, product_type);
		return "redirect:/AdminGeneralStoreHome";
	}
	
	@RequestMapping(value="/updateProduct",method=RequestMethod.POST)
	public Object updateProduct(@RequestParam("product_id") String product_id,
			@RequestParam("product_name") String product_name,
			@RequestParam("product_unit") String product_unit,
			@RequestParam("product_quantity") String product_quantity,
			@RequestParam("product_type") String product_type) {
		pr.UpdateProductAllAttr(Integer.parseInt(product_id),product_name, product_unit, product_quantity, product_type);
		return "redirect:/AdminGeneralStoreHome";
	}
	
	@RequestMapping(value="/addStaff",method=RequestMethod.POST)
	public Object addStaff(@RequestParam("staff_name") String staff_name,
			@RequestParam("staff_designation") String staff_designation,
			@RequestParam("emp_code") String emp_code) {
		sr.InsertStaffDetails(emp_code, staff_name, staff_designation);
		return "redirect:/AdminGeneralStoreHome";
	}
	
	@RequestMapping(value="/addContractor",method=RequestMethod.POST)
	public Object addContractor(@RequestParam("contractor_name") String contractor_name,
			@RequestParam("contractor_department") String contractor_department,
			@RequestParam("contractor_address") String contractor_address) {
		cr.InsertContractorDetails(contractor_name, contractor_department, contractor_address);
		return "redirect:/AdminGeneralStoreHome";
	}
	
	@RequestMapping(value="/addVehicle",method=RequestMethod.POST)
	public Object addVehicle(@RequestParam("vehicle_no") String vehicle_no,
			@RequestParam("driver_lisence_no") String driver_lisence_no,
			@RequestParam("tyre_no") String tyre_no,
			@RequestParam("battery_no") String battery_no,
			@RequestParam("pollution_from") String pollution_from,
			@RequestParam("pollution_expiry") String pollution_expiry,
			@RequestParam("fitness_from") String fitness_from,
			@RequestParam("fitness_expiry") String fitness_expiry,
			@RequestParam("insurance_from") String insurance_from,
			@RequestParam("insurance_expiry") String insurance_expiry,
			@RequestParam("last_servicing") String last_servicing
			) {
		vr.InsertVehicleDetails(vehicle_no, driver_lisence_no, tyre_no, battery_no, pollution_from, pollution_expiry, fitness_from, fitness_expiry, insurance_from, insurance_expiry, last_servicing);
		return "redirect:/AdminGeneralStoreHome";
	}
	
	@RequestMapping(value="/addLocation",method=RequestMethod.POST)
	public Object addLocation(@RequestParam("location_name") String location_name) {
		lr.InsertLocationDetails(location_name);
		return "redirect:/AdminGeneralStoreHome";
	}
	
}
