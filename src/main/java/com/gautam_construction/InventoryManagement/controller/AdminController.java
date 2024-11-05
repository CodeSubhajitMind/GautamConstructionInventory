package com.gautam_construction.InventoryManagement.controller;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.ResponseBody;

import com.gautam_construction.InventoryManagement.DTO.brief_product_challan_dto;
import com.gautam_construction.InventoryManagement.DTO.product_add_by_challan_dto;
import com.gautam_construction.InventoryManagement.DTO.product_add_by_ghy_office_dto;
import com.gautam_construction.InventoryManagement.DTO.product_add_by_local_office_dto;
import com.gautam_construction.InventoryManagement.DTO.product_exit_by_challan_dto;
import com.gautam_construction.InventoryManagement.DTO.product_exit_by_contractor_dto;
import com.gautam_construction.InventoryManagement.DTO.product_exit_by_misc_dto;
import com.gautam_construction.InventoryManagement.DTO.product_exit_by_staff_dto;
import com.gautam_construction.InventoryManagement.DTO.userLoginDetailsDTO;
import com.gautam_construction.InventoryManagement.DTO.vehicle_list_dto;
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
import com.gautam_construction.InventoryManagement.model.product_return;
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
import com.gautam_construction.InventoryManagement.repository.product_return_repository;
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
	
	@Autowired
	private fuel_exit_repository fexr;
	
	@Autowired
	private product_return_repository prr;
	
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.ENGLISH);
	
	DateTimeFormatter formatterL = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	
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
        List<users> user_info = ur.getUserCredentiaLs(user_id);
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
        List<vehicle_list_dto> vehicleListDto = new ArrayList<>();
        List<location> locationList = lr.getAllLocations();
        List<product_return> productReturnList = prr.getAllProductReturn();
        
        model.addAttribute("productList", productList);
        model.addAttribute("staffList", staffList);
        model.addAttribute("contractorList", contractorList);
        model.addAttribute("vehicleList", vehicleList);
        model.addAttribute("locationList", locationList);

        model.addAttribute("productReturnList",productReturnList);
        model.addAttribute("products_returned", productReturnList.size());
        
        
        for(vehicle vr: vehicleList) {
        	LocalDate pollutionExpiryDate = null;
        	if(vr.getPollution_expiry_date().isEmpty())
        		pollutionExpiryDate = null;
        	else
        		pollutionExpiryDate = LocalDate.parse(vr.getPollution_expiry_date(), formatterL);
        	
        	LocalDate FittnessEndDate = null;
        	if(vr.getFitness_end_date().isEmpty())
        		FittnessEndDate = null;
        	else
        		FittnessEndDate = LocalDate.parse(vr.getFitness_end_date(), formatterL);
        	
        	LocalDate InsuranceEndDate = null;
        	if(vr.getInsurance_end_date().isEmpty())
        		InsuranceEndDate = null;
        	else
        		InsuranceEndDate = LocalDate.parse(vr.getInsurance_end_date(), formatterL);
        	
        	vehicle_list_dto vld = new vehicle_list_dto(vr.getId(),vr.getVehicle_no(),vr.getDriver_lisence_no(),vr.getTyre_no(),vr.getBattery_no(),vr.getPollution_from_date(),pollutionExpiryDate,vr.getFitness_from_date(),FittnessEndDate,vr.getInsurance_from_date(),InsuranceEndDate,vr.getLast_servicing_date(),vr.getVehicle_type());
        	vehicleListDto.add(vld);
        }
        
        model.addAttribute("vehicleListDto", vehicleListDto);
        
        model.addAttribute("productCount", productList.size());
        model.addAttribute("staffCount", staffList.size());
        model.addAttribute("contractorCount", contractorList.size());
        model.addAttribute("vehicleCount", vehicleList.size());
        model.addAttribute("locationCount", locationList.size());
        
        List<users> user_info_all_admin = ur.getAllAdminCredentiaLs();
        List<users> user_info_all_sub_admin = ur.getAllSubAdminCredentiaLs();
        
        List<userLoginDetailsDTO> user_info_all_admin_dto = new ArrayList<>();
        List<userLoginDetailsDTO> user_info_all_sub_admin_dto = new ArrayList<>();
        
//        for(users u : user_info_all_admin) {
//        	userLoginDetailsDTO ul = new userLoginDetailsDTO(u.getName(),u.getUser_id(),ls.);
//        }
        
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
        
        List<fuel_exit> fuelExitList = fexr.getAllFuelExit();
        model.addAttribute("fuelExitList", fuelExitList);
        
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
        List<users> user_info = ur.getUserCredentiaLs(user_id);
        model.addAttribute("office_name", office_name);
        List<product> prodList = pr.getProductQuantity(Integer.parseInt(prod_id));
        model.addAttribute("prod_id", prod_id);
        model.addAttribute("prod_name", prodList.get(0).getName());
        model.addAttribute("prod_unit", prodList.get(0).getUnit());
        model.addAttribute("prod_quantity", prodList.get(0).getQuantity());
        model.addAttribute("prod_type", prodList.get(0).getType());
        model.addAttribute("prod_material", prodList.get(0).getMaterial());
        //return "admin_home";
        return "edit_product";
	}
	
	@RequestMapping(value="/editStaff",method=RequestMethod.GET)
	public Object editStaff(@RequestParam("staff_id") String staff_id,
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
        List<users> user_info = ur.getUserCredentiaLs(user_id);
        model.addAttribute("office_name", office_name);
        List<staff> staffList = sr.getAllStaffsById(Integer.parseInt(staff_id));
        model.addAttribute("staff_id", staff_id);
        model.addAttribute("name", staffList.get(0).getName());
        model.addAttribute("emp_code", staffList.get(0).getEmp_code());
        model.addAttribute("designation", staffList.get(0).getDesignation());
        //return "admin_home";
        return "edit_staff";
	}
	
	@RequestMapping(value="/editContractor",method=RequestMethod.GET)
	public Object editContractor(@RequestParam("contractor_id") String contractor_id,
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
        List<users> user_info = ur.getUserCredentiaLs(user_id);
        model.addAttribute("office_name", office_name);
        List<contractor> contractorList = cr.getAllContractorsById(Integer.parseInt(contractor_id));
        model.addAttribute("contractor_id", contractor_id);
        model.addAttribute("name", contractorList.get(0).getName());
        model.addAttribute("dept", contractorList.get(0).getDept());
        model.addAttribute("address", contractorList.get(0).getAddress());
        //return "admin_home";
        return "edit_contractor";
	}
	
	@RequestMapping(value="/editLocation",method=RequestMethod.GET)
	public Object editLocation(@RequestParam("location_id") String location_id,
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
        List<users> user_info = ur.getUserCredentiaLs(user_id);
        model.addAttribute("office_name", office_name);
        List<location> locationList = lr.getAllLocationsById(Integer.parseInt(location_id));
        model.addAttribute("location_id", location_id);
        model.addAttribute("location_name", locationList.get(0).getLocation_name());
        //return "admin_home";
        return "edit_location";
	}
	
	@RequestMapping(value="/editVehicle",method=RequestMethod.GET)
	public Object editVehicle(@RequestParam("vehicle_id") String vehicle_id,
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
        List<users> user_info = ur.getUserCredentiaLs(user_id);
        model.addAttribute("office_name", office_name);
        List<vehicle> vehicleList = vr.getAllVehiclesById(Integer.parseInt(vehicle_id));
        model.addAttribute("vehicle_id", vehicle_id);
        model.addAttribute("vehicle_no", vehicleList.get(0).getVehicle_no());
        model.addAttribute("driver_lisence_no", vehicleList.get(0).getDriver_lisence_no());
        model.addAttribute("tyre_no", vehicleList.get(0).getTyre_no());
        model.addAttribute("battery_no", vehicleList.get(0).getBattery_no());
        model.addAttribute("pollution_from_date", vehicleList.get(0).getPollution_from_date());
        model.addAttribute("pollution_end_date", vehicleList.get(0).getPollution_expiry_date());
        model.addAttribute("fittness_from_date", vehicleList.get(0).getFitness_from_date());
        model.addAttribute("fittness_end_date", vehicleList.get(0).getFitness_end_date());
        model.addAttribute("insurance_from_date", vehicleList.get(0).getInsurance_from_date());
        model.addAttribute("insurance_end_date", vehicleList.get(0).getInsurance_end_date());
        model.addAttribute("last_service_date", vehicleList.get(0).getLast_servicing_date());
        model.addAttribute("vehicle_type", vehicleList.get(0).getVehicle_type());
        //return "admin_home";
        return "edit_vehicle";
	}
	
	@RequestMapping(value="/addAdmin",method=RequestMethod.POST)
	public Object addAdmin(@RequestParam("name_sub_admin") String name_sub_admin,
			@RequestParam("user_id_sub_admin") String user_id_sub_admin,
			@RequestParam("password_sub_admin") String password_sub_admin) throws Exception {
		//String pass = "abc123";
		String usertype = "A";
		Date now = new Date();
		String today_str = formatter.format(now);
		String encryptedPass = ls.hashPassword(password_sub_admin);
		ur.registerOfficeDetails(user_id_sub_admin, encryptedPass, name_sub_admin, usertype, today_str);
		urr.regsiterNewUserRole(user_id_sub_admin, 1);
		return "redirect:/AdminGeneralStoreHome";
	}
	
	@ResponseBody
	@RequestMapping(value="/deleteUser",method=RequestMethod.POST)
	public Object deleteUser(@RequestParam("user_id") String user_id) throws Exception {
		//String pass = "abc123";
		ur.DeleteUserId(user_id);
		urr.deleteUserRole(user_id);
		return "success";
	}
	
	@RequestMapping(value="/addSubAdmin",method=RequestMethod.POST)
	public Object addSubAdmin(@RequestParam("name_sub_admin") String name_sub_admin,
			@RequestParam("user_id_sub_admin") String user_id_sub_admin,
			@RequestParam("password_sub_admin") String password_sub_admin) throws Exception {
		//String pass = "abc123";
		String usertype = "SA";
		Date now = new Date();
		String today_str = formatter.format(now);
		String encryptedPass = ls.hashPassword(password_sub_admin);
		ur.registerOfficeDetails(user_id_sub_admin, encryptedPass, name_sub_admin, usertype, today_str);
		urr.regsiterNewUserRole(user_id_sub_admin, 2);
		return "redirect:/AdminGeneralStoreHome";
	}
	
	@RequestMapping(value="/addProduct",method=RequestMethod.POST)
	public Object addProduct(@RequestParam("product_name") String product_name,
			@RequestParam("product_unit") String product_unit,
			@RequestParam("product_quantity") String product_quantity,
			@RequestParam("product_type") String product_type,
			@RequestParam("product_material") String product_material) {
		pr.InsertProductDetails(product_name, product_unit, product_quantity, product_type, product_material);
		return "redirect:/AdminGeneralStoreHome";
	}
	
	@RequestMapping(value="/updateProduct",method=RequestMethod.POST)
	public Object updateProduct(@RequestParam("product_id") String product_id,
			@RequestParam("product_name") String product_name,
			@RequestParam("product_unit") String product_unit,
			@RequestParam("product_quantity") String product_quantity,
			@RequestParam("product_type") String product_type,
			@RequestParam("prod_material") String prod_material) {
		pr.UpdateProductAllAttr(Integer.parseInt(product_id),product_name, product_unit, product_quantity, product_type,prod_material);
		return "redirect:/AdminGeneralStoreHome";
	}
	
	@ResponseBody
	@RequestMapping(value="/deleteProduct",method=RequestMethod.POST)
	public Object deleteProduct(@RequestParam("prod_id") String prod_id) throws Exception {
		//String pass = "abc123";
		pr.deleteProductId(Integer.parseInt(prod_id));
		return "success";
	}
	
	@RequestMapping(value="/addStaff",method=RequestMethod.POST)
	public Object addStaff(@RequestParam("staff_name") String staff_name,
			@RequestParam("staff_designation") String staff_designation,
			@RequestParam("emp_code") String emp_code) {
		sr.InsertStaffDetails(emp_code, staff_name, staff_designation);
		return "redirect:/AdminGeneralStoreHome";
	}
	
	@RequestMapping(value="/updateStaff",method=RequestMethod.POST)
	public Object updateStaff(@RequestParam("staff_id") String staff_id,
							@RequestParam("staff_name") String staff_name,
							@RequestParam("staff_designation") String staff_designation,
							@RequestParam("emp_code") String emp_code) {
		sr.UpdateStaffDetailsAllAttr(Integer.parseInt(staff_id), emp_code, staff_name, staff_designation);
		return "redirect:/AdminGeneralStoreHome";
	}
	
	@ResponseBody
	@RequestMapping(value="/deleteStaff",method=RequestMethod.POST)
	public Object deleteStaff(@RequestParam("staff_id") String staff_id) throws Exception {
		//String pass = "abc123";
		sr.DeleteStaffId(Integer.parseInt(staff_id));
		return "success";
	}
	
	@RequestMapping(value="/addContractor",method=RequestMethod.POST)
	public Object addContractor(@RequestParam("contractor_name") String contractor_name,
			@RequestParam("contractor_department") String contractor_department,
			@RequestParam("contractor_address") String contractor_address) {
		cr.InsertContractorDetails(contractor_name, contractor_department, contractor_address);
		return "redirect:/AdminGeneralStoreHome";
	}
	
	@RequestMapping(value="/updateContractor",method=RequestMethod.POST)
	public Object updateContractor(@RequestParam("contractor_id") String contractor_id,
			@RequestParam("contractor_name") String contractor_name,
			@RequestParam("contractor_department") String contractor_department,
			@RequestParam("contractor_address") String contractor_address) {
		cr.UpdateContractorDetailsAllAttr(Integer.parseInt(contractor_id), contractor_name, contractor_department, contractor_address);
		return "redirect:/AdminGeneralStoreHome";
	}
	
	@ResponseBody
	@RequestMapping(value="/deleteContractor",method=RequestMethod.POST)
	public Object deleteContractor(@RequestParam("contractor_id") String contractor_id) throws Exception {
		//String pass = "abc123";
		cr.DeleteContractorId(Integer.parseInt(contractor_id));
		return "success";
	}
	
	@RequestMapping(value="/addVehicle",method=RequestMethod.POST)
	public Object addVehicle(@RequestParam("vehicle_no") String vehicle_no,
			@RequestParam("vehicle_type") String vehicle_type,
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
		vr.InsertVehicleDetails(vehicle_no, driver_lisence_no, tyre_no, battery_no, pollution_from, pollution_expiry, fitness_from, fitness_expiry, insurance_from, insurance_expiry, last_servicing,vehicle_type);
		return "redirect:/AdminGeneralStoreHome";
	}
	
	@RequestMapping(value="/updateVehicle",method=RequestMethod.POST)
	public Object updateVehicle(@RequestParam("vehicle_id") String vehicle_id,
			@RequestParam("vehicle_no") String vehicle_no,
			@RequestParam("vehicle_type") String vehicle_type,
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
		vr.UpdateVehicleDetailsAllAttr(Integer.parseInt(vehicle_id), vehicle_no, driver_lisence_no, tyre_no, battery_no, pollution_from, pollution_expiry, fitness_from, fitness_expiry, insurance_from, insurance_expiry, last_servicing, vehicle_type);
		return "redirect:/AdminGeneralStoreHome";
	}
	
	@ResponseBody
	@RequestMapping(value="/deleteVehicle",method=RequestMethod.POST)
	public Object deleteVehicle(@RequestParam("vehicle_id") String vehicle_id) throws Exception {
		//String pass = "abc123";
		vr.DeleteVehicleId(Integer.parseInt(vehicle_id));
		return "success";
	}
	
	@RequestMapping(value="/addLocation",method=RequestMethod.POST)
	public Object addLocation(@RequestParam("location_name") String location_name) {
		lr.InsertLocationDetails(location_name);
		return "redirect:/AdminGeneralStoreHome";
	}
	
	@RequestMapping(value="/updateLocation",method=RequestMethod.POST)
	public Object updateLocation(@RequestParam("location_id") String location_id,
			@RequestParam("location_name") String location_name) {
		lr.UpdateLocationDetailsAllAttr(Integer.parseInt(location_id), location_name);
		return "redirect:/AdminGeneralStoreHome";
	}
	
	@ResponseBody
	@RequestMapping(value="/deleteLocation",method=RequestMethod.POST)
	public Object deleteLocation(@RequestParam("location_id") String location_id) throws Exception {
		//String pass = "abc123";
		lr.DeleteLocationId(Integer.parseInt(location_id));
		return "success";
	}
	
	@RequestMapping(value="/editFuelEntry",method=RequestMethod.GET)
	public Object editFuelEntry(@RequestParam("fuel_id") String fuel_id,
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
		model.addAttribute("fuel_id", fuel_id);
        List<users> user_info = ur.getUserCredentiaLs(user_id);
        model.addAttribute("office_name", office_name);
        List<fuel_entry> fuel_entry_list = fer.getAllFuelEntryById(Integer.parseInt(fuel_id));
        //return "admin_home";
        model.addAttribute("fuel_entry_obj", fuel_entry_list.get(0));
        return "edit_fuel_entry";
	}
	
	@RequestMapping(value="/updateFuelEntry",method=RequestMethod.POST)
	public Object updateFuelEntry(@RequestParam("fuel_id") String fuel_id,
			@RequestParam("fuel_type") String fuel_type,
			@RequestParam("fuel_quantity") String fuel_quantity,
			@RequestParam("invoice_no") String invoice_no,
			@RequestParam("invoice_date") String invoice_date,
			@RequestParam("vendor_name") String vendor_name,
			@RequestParam("vehicle_no") String vehicle_no
			) {
		List<fuel_entry> fuel_entry_list = fer.getAllFuelEntryById(Integer.parseInt(fuel_id));
		String fuel_entry_quantity = fuel_entry_list.get(0).getQuantity();
		Double fuel_update_diff = Double.parseDouble(fuel_quantity) - Double.parseDouble(fuel_entry_quantity);
		List<fuel> fuelDetails = fr.getFuelDetailsByType(fuel_type);
		Double fuelStoreQuantity = Double.parseDouble(fuelDetails.get(0).getQuantity());
		Double updatedFuelStoreQuantity = fuelStoreQuantity + fuel_update_diff;
		fer.UpdateFuelEntryAllAttr(Integer.parseInt(fuel_id), fuel_type, fuel_quantity, invoice_no, invoice_date, vendor_name, vehicle_no);
		fr.UpdateFuelQuantity(fuel_type, updatedFuelStoreQuantity.toString());
		return "redirect:/AdminGeneralStoreHome";
	}
	
	@ResponseBody
	@RequestMapping(value="/deleteFuelEntry",method=RequestMethod.POST)
	public Object deleteFuelEntry(@RequestParam("fuel_id") String fuel_id) throws Exception {
		//String pass = "abc123";
		List<fuel_entry> fuelEntryDetails = fer.getAllFuelEntryById(Integer.parseInt(fuel_id));
		String fuelEntryQuantity =  fuelEntryDetails.get(0).getQuantity();
		String fuel_type = fuelEntryDetails.get(0).getFuel_type();
		List<fuel> fuelDetails = fr.getFuelDetailsByType(fuel_type);
		String fuelStoreQuantity = fuelDetails.get(0).getQuantity();
		Double fuel_balance = Double.parseDouble(fuelStoreQuantity)-Double.parseDouble(fuelEntryQuantity);
		fer.deleteFuelEntryId(Integer.parseInt(fuel_id));
		fr.UpdateFuelQuantity(fuel_type, fuel_balance.toString());
		return "success";
	}
	
	@RequestMapping(value="/editFuelExit",method=RequestMethod.GET)
	public Object editFuelExit(@RequestParam("fuel_id") String fuel_id,
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
        List<users> user_info = ur.getUserCredentiaLs(user_id);
        model.addAttribute("fuel_id", fuel_id);
        List<fuel_exit> fuel_exit_list = fexr.getAllFuelExitById(Integer.parseInt(fuel_id));
        //return "admin_home";
        model.addAttribute("fuel_exit_obj", fuel_exit_list.get(0));
        return "edit_fuel_exit";
	}
	
	@RequestMapping(value="/updateFuelExit",method=RequestMethod.POST)
	public Object updateFuelExit(@RequestParam("fuel_id") String fuel_id,
			@RequestParam("exit_type") String exit_type,
			@RequestParam("fuel_type") String fuel_type,
			@RequestParam("vehicle_no") String vehicle_no,
			@RequestParam("opening_reading") String opening_reading,
			@RequestParam("mileage") String mileage,
			@RequestParam("fuel_issue") String fuel_issue,
			@RequestParam("issue_date") String issue_date,
			@RequestParam("vehicle_type") String vehicle_type
			) {
		List<fuel_exit> fuel_exit_list = fexr.getAllFuelExitById(Integer.parseInt(fuel_id));
		String fuel_exit_quantity = fuel_exit_list.get(0).getFuel_issue();
		Double fuel_update_diff = Double.parseDouble(fuel_issue) - Double.parseDouble(fuel_exit_quantity);
		List<fuel> fuelDetails = fr.getFuelDetailsByType(fuel_type);
		Double fuelStoreQuantity = Double.parseDouble(fuelDetails.get(0).getQuantity());
		Double updatedFuelStoreQuantity = fuelStoreQuantity - fuel_update_diff;
		fexr.UpdateFuelExitAllAttr(Integer.parseInt(fuel_id), exit_type, fuel_type, vehicle_no, opening_reading, mileage, fuel_issue, issue_date, vehicle_type);
		fr.UpdateFuelQuantity(fuel_type, updatedFuelStoreQuantity.toString());
		return "redirect:/AdminGeneralStoreHome";
	}
	
	@ResponseBody
	@RequestMapping(value="/deleteFuelExit",method=RequestMethod.POST)
	public Object deleteFuelExit(@RequestParam("fuel_id") String fuel_id) throws Exception {
		//String pass = "abc123";
		List<fuel_exit> fuelExitDetails = fexr.getAllFuelExitById(Integer.parseInt(fuel_id));
		String fuelExitQuantity =  fuelExitDetails.get(0).getFuel_issue();
		String fuel_type = fuelExitDetails.get(0).getFuel_type();
		List<fuel> fuelDetails = fr.getFuelDetailsByType(fuel_type);
		String fuelStoreQuantity = fuelDetails.get(0).getQuantity();
		String fuel_balance = Double.toString(Double.parseDouble(fuelStoreQuantity)+Double.parseDouble(fuelExitQuantity));
		fexr.deleteFuelExitId(Integer.parseInt(fuel_id));
		fr.UpdateFuelQuantity(fuel_type, fuel_balance);
		return "success";
	}
	
	
	
	@RequestMapping(value="/editProdAddChallan",method=RequestMethod.GET)
	public Object editProdAddChallan(@RequestParam("challan_no") String challan_no,
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
        List<users> user_info = ur.getUserCredentiaLs(user_id);
        model.addAttribute("office_name", office_name);
//        List<location> locationList = lr.getAllLocationsById(Integer.parseInt(location_id));
//        model.addAttribute("location_id", location_id);
//        model.addAttribute("location_name", locationList.get(0).getLocation_name());
        //return "admin_home";
        model.addAttribute("challan_no", challan_no);
        List<product_add_by_challan_dto> prodAddChallanList = pacr.getAllProductAddByChallanChNo(challan_no);
        model.addAttribute("prodAddChallanList", prodAddChallanList);
        model.addAttribute("remarks", prodAddChallanList.get(0).getRemarks());
        return "prod_add_by_challan";
	}
	
	@RequestMapping(value="/editProdAddGhyOffice",method=RequestMethod.GET)
	public Object editProdAddGhyOffice(@RequestParam("challan_no") String challan_no,
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
        List<users> user_info = ur.getUserCredentiaLs(user_id);
        model.addAttribute("office_name", office_name);
//        List<location> locationList = lr.getAllLocationsById(Integer.parseInt(location_id));
//        model.addAttribute("location_id", location_id);
//        model.addAttribute("location_name", locationList.get(0).getLocation_name());
        //return "admin_home";
        model.addAttribute("challan_no", challan_no);
        List<product_add_by_ghy_office_dto> prodAddGhyOffice = pagor.getAllProductAddByGhyOfficeChNo(challan_no);
        model.addAttribute("prodAddGhyOffice", prodAddGhyOffice);
        model.addAttribute("remarks", prodAddGhyOffice.get(0).getRemarks());
        return "prod_add_by_ghy_office";
	}
	
	@RequestMapping(value="/editProdAddLocalOffice",method=RequestMethod.GET)
	public Object editProdAddLocalOffice(@RequestParam("challan_no") String challan_no,
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
        List<users> user_info = ur.getUserCredentiaLs(user_id);
        model.addAttribute("office_name", office_name);
//        List<location> locationList = lr.getAllLocationsById(Integer.parseInt(location_id));
//        model.addAttribute("location_id", location_id);
//        model.addAttribute("location_name", locationList.get(0).getLocation_name());
        //return "admin_home";
        model.addAttribute("challan_no", challan_no);
        List<product_add_by_local_office_dto> prodAddLocalOffice = palor.getAllProductAddByLocalOfficeChNo(challan_no);
        model.addAttribute("prodAddLocalOffice", prodAddLocalOffice);
        model.addAttribute("remarks", prodAddLocalOffice.get(0).getRemarks());
        return "prod_add_by_local_office";
	}
	
	@RequestMapping(value="/editProdExitChallan",method=RequestMethod.GET)
	public Object editProdExitChallan(@RequestParam("challan_no") String challan_no,
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
        List<users> user_info = ur.getUserCredentiaLs(user_id);
        model.addAttribute("office_name", office_name);
//        List<location> locationList = lr.getAllLocationsById(Integer.parseInt(location_id));
//        model.addAttribute("location_id", location_id);
//        model.addAttribute("location_name", locationList.get(0).getLocation_name());
        //return "admin_home";
        model.addAttribute("challan_no", challan_no);
        List<product_exit_by_challan_dto> prodExitChallan = pecr.getAllProductExitByChallanChNo(challan_no);
        model.addAttribute("prodExitChallan", prodExitChallan);
        return "prod_exit_by_challan";
	}
	
	@RequestMapping(value="/editProdExitBySubContractor",method=RequestMethod.GET)
	public Object editProdExitBySubContractor(@RequestParam("challan_no") String challan_no,
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
        List<users> user_info = ur.getUserCredentiaLs(user_id);
        model.addAttribute("office_name", office_name);
//        List<location> locationList = lr.getAllLocationsById(Integer.parseInt(location_id));
//        model.addAttribute("location_id", location_id);
//        model.addAttribute("location_name", locationList.get(0).getLocation_name());
        //return "admin_home";
        model.addAttribute("challan_no", challan_no);
        List<product_exit_by_contractor_dto> prodExitContractor = pecor.getAllProductExitByContractorChNo(challan_no);
        model.addAttribute("prodExitContractor", prodExitContractor);
        return "prod_exit_by_contractor";
	}
	
	@RequestMapping(value="/editProdExitByStaff",method=RequestMethod.GET)
	public Object editProdExitByStaff(@RequestParam("challan_no") String challan_no,
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
        List<users> user_info = ur.getUserCredentiaLs(user_id);
        model.addAttribute("office_name", office_name);
//        List<location> locationList = lr.getAllLocationsById(Integer.parseInt(location_id));
//        model.addAttribute("location_id", location_id);
//        model.addAttribute("location_name", locationList.get(0).getLocation_name());
        //return "admin_home";
        model.addAttribute("challan_no", challan_no);
        List<product_exit_by_staff_dto> prodExitStaff = pesr.getAllProductExitByStaff_ChNo(challan_no);
        model.addAttribute("prodExitStaff", prodExitStaff);
        return "prod_exit_by_staff";
	}
	
	@RequestMapping(value="/editProdExitByMisc",method=RequestMethod.GET)
	public Object editProdExitByMisc(@RequestParam("challan_no") String challan_no,
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
        List<users> user_info = ur.getUserCredentiaLs(user_id);
        model.addAttribute("office_name", office_name);
//        List<location> locationList = lr.getAllLocationsById(Integer.parseInt(location_id));
//        model.addAttribute("location_id", location_id);
//        model.addAttribute("location_name", locationList.get(0).getLocation_name());
        //return "admin_home";
        model.addAttribute("challan_no", challan_no);
        List<product_exit_by_misc_dto> prodExitMiscellaneous = pemr.getAllProductExitByMiscellaneousChNo(challan_no);
        model.addAttribute("prodExitMiscellaneous", prodExitMiscellaneous);
        return "prod_exit_by_misc";
	}
	
	@ResponseBody
	@RequestMapping(value="/deleteChallan",method=RequestMethod.POST)
	public Object deleteChallan(@RequestParam("challan_no") String challan_no,
			@RequestParam("type") String type,
			HttpSession session,Model model,Authentication authentication) throws Exception {
		//String pass = "abc123";
		if(type.equals("prod_add_by_challan")) {
			List<product_add_by_challan_dto> prodAddChallanList = pacr.getAllProductAddByChallanChNo(challan_no);
			for(product_add_by_challan_dto pacd : prodAddChallanList) {
				Integer prod_id = pacd.getProd_id();
				String prod_challan_qty = pacd.getQuantity();
				String prod_qty = pr.getProductQuantity(prod_id).get(0).getQuantity();
				String reseted_qty = Double.toString(Double.parseDouble(prod_qty) - Double.parseDouble(prod_challan_qty));
				pr.UpdateProductQuantity(prod_id, reseted_qty);
			}
			pacr.DeleteAllProductAddByChallan(challan_no);
		}
		else if(type.equals("prod_add_by_ghy_office")) {
			List<product_add_by_ghy_office_dto> prodAddGhyOffice = pagor.getAllProductAddByGhyOfficeChNo(challan_no);
			for(product_add_by_ghy_office_dto pagod : prodAddGhyOffice) {
				Integer prod_id = pagod.getProd_id();
				String prod_challan_qty = pagod.getQuantity();
				String prod_qty = pr.getProductQuantity(prod_id).get(0).getQuantity();
				String reseted_qty = Double.toString(Double.parseDouble(prod_qty) - Double.parseDouble(prod_challan_qty));
				pr.UpdateProductQuantity(prod_id, reseted_qty);
			}
			//deldete challan
			pagor.DeleteAllProductAddByGhyOffice(challan_no);
		}
		else if(type.equals("prod_add_by_local_office")) {
			List<product_add_by_local_office_dto> prodAddLocalOffice = palor.getAllProductAddByLocalOfficeChNo(challan_no);
			for(product_add_by_local_office_dto palod : prodAddLocalOffice) {
				Integer prod_id = palod.getProd_id();
				String prod_challan_qty = palod.getQuantity();
				String prod_qty = pr.getProductQuantity(prod_id).get(0).getQuantity();
				String reseted_qty = Double.toString(Double.parseDouble(prod_qty) - Double.parseDouble(prod_challan_qty));
				pr.UpdateProductQuantity(prod_id, reseted_qty);
			}
			palor.DeleteAllProductAddByLocalOffice(challan_no);		
		}
		else if(type.equals("prod_exit_by_challan")) {
			List<product_exit_by_challan_dto> prodExitChallan = pecr.getAllProductExitByChallanChNo(challan_no);
			for(product_exit_by_challan_dto pecd : prodExitChallan) {
				Integer prod_id = pecd.getProd_id();
				String prod_challan_qty = pecd.getQuantity();
				String prod_qty = pr.getProductQuantity(prod_id).get(0).getQuantity();
				String reseted_qty = Double.toString(Double.parseDouble(prod_qty) + Double.parseDouble(prod_challan_qty));
				pr.UpdateProductQuantity(prod_id, reseted_qty);
			}
			pecr.DeleteAllProductExitByChallan(challan_no);
		}
		else if(type.equals("prod_exit_by_sub_contractor")) {
			 List<product_exit_by_contractor_dto> prodExitContractor = pecor.getAllProductExitByContractorChNo(challan_no);
			 for(product_exit_by_contractor_dto pecod : prodExitContractor) {
					Integer prod_id = pecod.getProd_id();
					String prod_challan_qty = pecod.getQuantity();
					String prod_qty = pr.getProductQuantity(prod_id).get(0).getQuantity();
					String reseted_qty = Double.toString(Double.parseDouble(prod_qty) + Double.parseDouble(prod_challan_qty));
					pr.UpdateProductQuantity(prod_id, reseted_qty);
				}
			 pecor.DeleteAllProductExitByContractor(challan_no);
		}
		else if(type.equals("prod_exit_by_staff")) {
			List<product_exit_by_staff_dto> prodExitStaff = pesr.getAllProductExitByStaff_ChNo(challan_no);
			for(product_exit_by_staff_dto pesd : prodExitStaff) {
				Integer prod_id = pesd.getProd_id();
				String prod_challan_qty = pesd.getQuantity();
				String prod_qty = pr.getProductQuantity(prod_id).get(0).getQuantity();
				String reseted_qty = Double.toString(Double.parseDouble(prod_qty) + Double.parseDouble(prod_challan_qty));
				pr.UpdateProductQuantity(prod_id, reseted_qty);
			}
			pesr.DeleteAllProductExitByStaff(challan_no);
		}
		else if(type.equals("prod_exit_by_misc")) {
			 List<product_exit_by_misc_dto> prodExitMiscellaneous = pemr.getAllProductExitByMiscellaneousChNo(challan_no);
			 for(product_exit_by_misc_dto pemd : prodExitMiscellaneous) {
					Integer prod_id = pemd.getProd_id();
					String prod_challan_qty = pemd.getQuantity();
					String prod_qty = pr.getProductQuantity(prod_id).get(0).getQuantity();
					String reseted_qty = Double.toString(Double.parseDouble(prod_qty) + Double.parseDouble(prod_challan_qty));
					pr.UpdateProductQuantity(prod_id, reseted_qty);
				}
			 pemr.DeleteAllProductExitByMisc(challan_no);
		}
		return "success";
	}
	
}
