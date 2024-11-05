/**
 * 
 */
                                                                                          
 $(document).ready(function(){
		//$(this).select2();
		$('.select2').select2();
		var counter = 1;
		$('#btn_prod_add_challan').click(function(event){
			event.preventDefault();
			counter++;
			//var prodList = '[[${productList}]]';
			var prodOptions = '';
			prodList.forEach(function(product) {
				prodOptions = prodOptions + '<option value="'+product.prod_id+'">'+product.name+'</option>';
				});
			var locationOptions = '';
			locationList.forEach(function(location) {
				locationOptions = locationOptions + '<option value="'+location.location_name+'">'+location.location_name+'</option>';
				});
			var vehicleOptions = '';
			vehicleList.forEach(function(vehicle) {
				vehicleOptions = vehicleOptions + '<option value="'+vehicle.vehicle_no+'">'+vehicle.vehicle_no+'</option>';
				});
			var add_product_to_challan = 
				'<div>'+
				' <div class="form-group row">'+
				' 	<div class="col-lg-2">'+
				' 		<h3><b>#'+counter+'</b></h3>'+
				' 	</div>'+
				' 	<div class="col-lg-8"></div>'+
				' 	<div class="col-lg-2">'+
				' 		<button type="button" class="product_remove btn btn-danger float-right">Delete Product</button>'+
				' 	</div>'+
				' </div>'+
				'<div class="form-group row">'+
				'	<label class="col-lg-3 col-form-label form-control-label">Product name<span><b>*</b></span></label>'+
				'	<div class="col-lg-9">'+
				'	  <select class="form-control select2" name="product_id" id="product_id_ech_'+counter+'" style="width: 100%;height: 100%;">'+
				'			<option value="">select option</option>'+prodOptions+
				'	  </select>'+
				'	</div>'+
				'</div>'+
				'<div class="form-group row">'+
				'	<label class="col-lg-3 col-form-label form-control-label">Product Quantity<span><b>*</b></span></label>'+
				'	<div class="col-lg-9">'+
				'	  <input id="product_quantity" name="product_quantity" class="form-control" type="text" value="0">'+
				'	</div>'+
				'</div>'+
				'<div class="form-group row">'+
				'	<label class="col-lg-3 col-form-label form-control-label">Issuing Branch<span><b>*</b></span></label>'+
				'	<div class="col-lg-9">'+
				'	  <select class="form-control" name="from_branch" id="from_branch">'+
				'			<option value="">select option</option>'+locationOptions+
				'	  </select>'+
				'	</div>'+
				'</div>'+
				'<div class="form-group row">'+
				'	<label class="col-lg-3 col-form-label form-control-label">Vehicle No.</label>'+
				'	<div class="col-lg-9">'+
				'	<input id="vehicle_no" name="vehicle_no" class="form-control" type="text" value="">'+
				'	</div>'+
				'</div>'+
				'<hr>'+
				'</div>';
				
				$('.addByChallan').append(add_product_to_challan);
				$('.select2').select2();
		});
		
		$('.addByChallan').on("click",".product_remove", function(e){ //user click on remove text
		  if(counter>0){
				counter--;
		  }
  		  e.preventDefault(); $(this).parent('div').parent('div').parent('div').remove();
  		})
  	
  		var counterG = 1;
		$('#btn_prod_add_ghy_office').click(function(event){
			event.preventDefault();
			counterG++;
			//var prodList = '[[${productList}]]';
			var prodOptions = '';
			prodList.forEach(function(product) {
				prodOptions = prodOptions + '<option value="'+product.prod_id+'">'+product.name+'</option>';
				});
			var locationOptions = '';
			locationList.forEach(function(location) {
				locationOptions = locationOptions + '<option value="'+location.location_name+'">'+location.location_name+'</option>';
				});
			var vehicleOptions = '';
			vehicleList.forEach(function(vehicle) {
				vehicleOptions = vehicleOptions + '<option value="'+vehicle.vehicle_no+'">'+vehicle.vehicle_no+'</option>';
				});
			var add_product_to_ghy_office = 
				'<div>'+
				' <div class="form-group row">'+
				' 	<div class="col-lg-2">'+
				' 		<h3><b>#'+counterG+'</b></h3>'+
				' 	</div>'+
				' 	<div class="col-lg-8"></div>'+
				' 	<div class="col-lg-2">'+
				' 		<button type="button" class="product_remove btn btn-danger float-right">Delete Product</button>'+
				' 	</div>'+
				' </div>'+
				'<div class="form-group row">'+
				'	<label class="col-lg-3 col-form-label form-control-label">Product name<span><b>*</b></span></label>'+
				'	<div class="col-lg-9">'+
				'	  <select class="form-control select2" name="product_id" id="product_id_ego_'+counterG+'" style="width: 100%;height: 100%;">'+
				'			<option value="">select option</option>'+prodOptions+
				'	  </select>'+
				'	</div>'+
				'</div>'+
				'<div class="form-group row">'+
				'	<label class="col-lg-3 col-form-label form-control-label">Product Quantity<span><b>*</b></span></label>'+
				'	<div class="col-lg-9">'+
				'	  <input id="product_quantity" name="product_quantity" class="form-control" type="text" value="0">'+
				'	</div>'+
				'</div>'+
				'<div class="form-group row">'+
				'	<label class="col-lg-3 col-form-label form-control-label">Vendor Name<span><b>*</b></span></label>'+
				'	<div class="col-lg-9">'+
				'	  <input id="vendor_name" name="vendor_name" class="form-control" type="text" value="">'+
				'	</div>'+
				'</div>'+
				'<div class="form-group row">'+
				'	<label class="col-lg-3 col-form-label form-control-label">Vehicle No.</label>'+
				'	<div class="col-lg-9">'+
				'	<input id="vehicle_no" name="vehicle_no" class="form-control" type="text" value="">'+
				'	</div>'+
				'</div>'+
				'<hr>'+
				'</div>';
				
				$('.addByGhyOffice').append(add_product_to_ghy_office);
				$('.select2').select2();
		});
		
		$('.addByGhyOffice').on("click",".product_remove", function(e){ //user click on remove text
		  if(counterG>0){
				counterG--;
		  }
  		  e.preventDefault(); $(this).parent('div').parent('div').parent('div').remove();
  		})
  		
  		var counterL = 1;
		$('#btn_prod_add_local').click(function(event){
			event.preventDefault();
			counterL++;
			//var prodList = '[[${productList}]]';
			var prodOptions = '';
			prodList.forEach(function(product) {
				prodOptions = prodOptions + '<option value="'+product.prod_id+'">'+product.name+'</option>';
				});
			var locationOptions = '';
			locationList.forEach(function(location) {
				locationOptions = locationOptions + '<option value="'+location.location_name+'">'+location.location_name+'</option>';
				});
			var vehicleOptions = '';
			vehicleList.forEach(function(vehicle) {
				vehicleOptions = vehicleOptions + '<option value="'+vehicle.vehicle_no+'">'+vehicle.vehicle_no+'</option>';
				});
			var add_product_to_local_office = 
				'<div>'+
				' <div class="form-group row">'+
				' 	<div class="col-lg-2">'+
				' 		<h3><b>#'+counterL+'</b></h3>'+
				' 	</div>'+
				' 	<div class="col-lg-8"></div>'+
				' 	<div class="col-lg-2">'+
				' 		<button type="button" class="product_remove btn btn-danger float-right">Delete Product</button>'+
				' 	</div>'+
				' </div>'+
				'<div class="form-group row">'+
				'	<label class="col-lg-3 col-form-label form-control-label">Product name<span><b>*</b></span></label>'+
				'	<div class="col-lg-9">'+
				'	  <select class="form-control select2" name="product_id" id="product_id_elo_'+counterL+'" style="width: 100%;height: 100%;">'+
				'			<option value="">select option</option>'+prodOptions+
				'	  </select>'+
				'	</div>'+
				'</div>'+
				'<div class="form-group row">'+
				'	<label class="col-lg-3 col-form-label form-control-label">Product Quantity<span><b>*</b></span></label>'+
				'	<div class="col-lg-9">'+
				'	  <input id="product_quantity" name="product_quantity" class="form-control" type="text" value="0">'+
				'	</div>'+
				'</div>'+
				'<div class="form-group row">'+
				'	<label class="col-lg-3 col-form-label form-control-label">Vendor Name<span><b>*</b></span></label>'+
				'	<div class="col-lg-9">'+
				'	  <input id="vendor_name" name="vendor_name" class="form-control" type="text" value="">'+
				'	</div>'+
				'</div>'+
				'<div class="form-group row">'+
				'	<label class="col-lg-3 col-form-label form-control-label">Vehicle No.</label>'+
				'	<div class="col-lg-9">'+
				'	<input id="vehicle_no" name="vehicle_no" class="form-control" type="text" value="">'+
				'	</div>'+
				'</div>'+
				'<hr>'+
				'</div>';
				
				$('.addByLocalOffice').append(add_product_to_local_office);
				$('.select2').select2();
		});
		
		$('.addByLocalOffice').on("click",".product_remove", function(e){ //user click on remove text
		  if(counterL>0){
				counterL--;
		  }
  		  e.preventDefault(); $(this).parent('div').parent('div').parent('div').remove();
  		})
  		
  		
  		var counterExitChallan = 1;
		$('#btn_prod_exit_challan').click(function(event){
			event.preventDefault();
			counterExitChallan++;
			//var prodList = '[[${productList}]]';
			var prodOptions = '';
			prodList.forEach(function(product) {
				prodOptions = prodOptions + '<option value="'+product.prod_id+'">'+product.name+'</option>';
				});
			var locationOptions = '';
			locationList.forEach(function(location) {
				locationOptions = locationOptions + '<option value="'+location.location_name+'">'+location.location_name+'</option>';
				});
			var vehicleOptions = '';
			vehicleList.forEach(function(vehicle) {
				vehicleOptions = vehicleOptions + '<option value="'+vehicle.vehicle_no+'">'+vehicle.vehicle_no+'</option>';
				});
			var exit_product_challan = 
				'<div>'+
				' <div class="form-group row">'+
				' 	<div class="col-lg-2">'+
				' 		<h3><b>#'+counterExitChallan+'</b></h3>'+
				' 	</div>'+
				' 	<div class="col-lg-8"></div>'+
				' 	<div class="col-lg-2">'+
				' 		<button type="button" class="product_remove btn btn-danger float-right">Delete Product</button>'+
				' 	</div>'+
				' </div>'+
				'<div class="form-group row">'+
				'	<label class="col-lg-3 col-form-label form-control-label">Product name<span><b>*</b></span></label>'+
				'	<div class="col-lg-9">'+
				'	  <select class="form-control select2" name="product_id" id="product_id_exch_'+counterExitChallan+'" style="width: 100%;height: 100%;">'+
				'			<option value="">select option</option>'+prodOptions+
				'	  </select>'+
				'	</div>'+
				'</div>'+
				'<div class="form-group row">'+
				'	<label class="col-lg-3 col-form-label form-control-label">Product Quantity<span><b>*</b></span></label>'+
				'	<div class="col-lg-9">'+
				'	  <input id="product_quantity1" name="product_quantity" class="form-control" type="text" value="0">'+
				'	</div>'+
				'</div>'+
				'<div class="form-group row">'+
				'	<label class="col-lg-3 col-form-label form-control-label">To Location<span><b>*</b></span></label>'+
				'	<div class="col-lg-9">'+
				'	  <select class="form-control" name="to_location" id="to_location">'+
				'			<option value="">select option</option>'+locationOptions+
				'	  </select>'+
				'	</div>'+
				'</div>'+
				'<div class="form-group row">'+
				'	<label class="col-lg-3 col-form-label form-control-label">Vehicle No.<span><b>*</b></span></label>'+
				'	<div class="col-lg-9">'+
				'	  <select class="form-control" name="vehicle_no" id="vehicle_no">'+
				'			<option value="">select option</option>'+vehicleOptions+
				'	  </select>'+
				'	</div>'+
				'</div>'+
				'<hr>'+
				'</div>';
				
				$('.exitByChallan').append(exit_product_challan);
				$('.select2').select2();
		});
		
		$('.exitByChallan').on("click",".product_remove", function(e){ //user click on remove text
		  if(counterExitChallan>0){
				counterExitChallan--;
		  }
  		  e.preventDefault(); $(this).parent('div').parent('div').parent('div').remove();
  		})
  		
  		
  		var counterExitContractor = 1;
		$('#btn_prod_exit_contractor').click(function(event){
			event.preventDefault();
			counterExitContractor++;
			//var prodList = '[[${productList}]]';
			var prodOptions = '';
			prodList.forEach(function(product) {
				prodOptions = prodOptions + '<option value="'+product.prod_id+'">'+product.name+'</option>';
				});
			var locationOptions = '';
			locationList.forEach(function(location) {
				locationOptions = locationOptions + '<option value="'+location.location_name+'">'+location.location_name+'</option>';
				});
			var vehicleOptions = '';
			vehicleList.forEach(function(vehicle) {
				vehicleOptions = vehicleOptions + '<option value="'+vehicle.vehicle_no+'">'+vehicle.vehicle_no+'</option>';
				});
			var contractorOptions = '';
			contractorList.forEach(function(contractor) {
				contractorOptions = contractorOptions + '<option value="'+contractor.name+'">'+contractor.name+'</option>';
				});
			var exit_product_contractor = 
				'<div>'+
				' <div class="form-group row">'+
				' 	<div class="col-lg-2">'+
				' 		<h3><b>#'+counterExitContractor+'</b></h3>'+
				' 	</div>'+
				' 	<div class="col-lg-8"></div>'+
				' 	<div class="col-lg-2">'+
				' 		<button type="button" class="product_remove btn btn-danger float-right">Delete Product</button>'+
				' 	</div>'+
				' </div>'+
				'<div class="form-group row">'+
				'	<label class="col-lg-3 col-form-label form-control-label">Product name<span><b>*</b></span></label>'+
				'	<div class="col-lg-9">'+
				'	  <select class="form-control select2" name="product_id" id="product_id_exco_'+counterExitContractor+'" style="width: 100%;height: 100%;">'+
				'			<option value="">select option</option>'+prodOptions+
				'	  </select>'+
				'	</div>'+
				'</div>'+
				'<div class="form-group row">'+
				'	<label class="col-lg-3 col-form-label form-control-label">product Quantity<span><b>*</b></span></label>'+
				'	<div class="col-lg-9">'+
				'	  <input id="product_quantity2" name="product_quantity" class="form-control" type="text" value="0" onclick="checkAvailableQuantity(event)">'+
				'	</div>'+
				'</div>'+
				'<div class="form-group row">'+
				'	<label class="col-lg-3 col-form-label form-control-label">Contractor Name<span><b>*</b></span></label>'+
				'	<div class="col-lg-9">'+
				'	  <select class="form-control" name="contractor_name" id="contractor_name">'+
				'			<option value="">select option</option>'+contractorOptions+
				'	  </select>'+
				'	</div>'+
				'</div>'+
				'<div class="form-group row">'+
				'	<label class="col-lg-3 col-form-label form-control-label">Receiving Person Name<span><b>*</b></span></label>'+
				'	<div class="col-lg-9">'+
				'	  <input id="receiving_person" name="receiving_person" class="form-control" type="text" value="0">'+
				'	</div>'+
				'</div>'+
				'<hr>'+
				'</div>';
				
				$('.exitByContractor').append(exit_product_contractor);
				$('.select2').select2();
		});
		
		$('.exitByContractor').on("click",".product_remove", function(e){ //user click on remove text
		  if(counterExitContractor>0){
				counterExitContractor--;
		  }
  		  e.preventDefault(); $(this).parent('div').parent('div').parent('div').remove();
  		})
  		
  		
  		var counterExitStaff = 1;
		$('#btn_prod_exit_staff').click(function(event){
			event.preventDefault();
			counterExitStaff++;
			//var prodList = '[[${productList}]]';
			var prodOptions = '';
			prodList.forEach(function(product) {
				prodOptions = prodOptions + '<option value="'+product.prod_id+'">'+product.name+'</option>';
				});
			var locationOptions = '';
			locationList.forEach(function(location) {
				locationOptions = locationOptions + '<option value="'+location.location_name+'">'+location.location_name+'</option>';
				});
			var vehicleOptions = '';
			vehicleList.forEach(function(vehicle) {
				vehicleOptions = vehicleOptions + '<option value="'+vehicle.vehicle_no+'">'+vehicle.vehicle_no+'</option>';
				});
				var staffOptions = '';
			staffList.forEach(function(staff) {
				staffOptions = staffOptions + '<option value="'+staff.emp_code+'">'+staff.name+'</option>';
				});
			var exit_product_staff = 
				'<div>'+
				' <div class="form-group row">'+
				' 	<div class="col-lg-2">'+
				' 		<h3><b>#'+counterExitStaff+'</b></h3>'+
				' 	</div>'+
				' 	<div class="col-lg-8"></div>'+
				' 	<div class="col-lg-2">'+
				' 		<button type="button" class="product_remove btn btn-danger float-right">Delete Product</button>'+
				' 	</div>'+
				' </div>'+
				'<div class="form-group row">'+
				'	<label class="col-lg-3 col-form-label form-control-label">Product name<span><b>*</b></span></label>'+
				'	<div class="col-lg-9">'+
				'	  <select class="form-control select2" name="product_id" id="product_id_exemp_'+counterExitStaff+'" style="width: 100%;height: 100%;">'+
				'			<option value="">select option</option>'+prodOptions+
				'	  </select>'+
				'	</div>'+
				'</div>'+
				'<div class="form-group row">'+
				'	<label class="col-lg-3 col-form-label form-control-label">product Quantity<span><b>*</b></span></label>'+
				'	<div class="col-lg-9">'+
				'	  <input id="product_quantity3" name="product_quantity" class="form-control" type="text" value="0" onclick="checkAvailableQuantity(event)">'+
				'	</div>'+
				'</div>'+
				'<div class="form-group row">'+
				'	<label class="col-lg-3 col-form-label form-control-label">Staff Name<span><b>*</b></span></label>'+
				'	<div class="col-lg-9">'+
				'	  <select class="form-control" name="staff_emp_code" id="staff_emp_code">'+
				'			<option value="">select option</option>'+staffOptions+
				'	  </select>'+
				'	</div>'+
				'</div>'+
				'<div class="form-group row">'+
				'	<label class="col-lg-3 col-form-label form-control-label">Receiving Person Name<span><b>*</b></span></label>'+
				'	<div class="col-lg-9">'+
				'	  <input id="receiving_person" name="receiving_person" class="form-control" type="text" value="0">'+
				'	</div>'+
				'</div>'+
				'<hr>'+
				'</div>';
				
				$('.exitByStaff').append(exit_product_staff);
				$('.select2').select2();
		});
		
		$('.exitByStaff').on("click",".product_remove", function(e){ //user click on remove text
		  if(counterExitStaff>0){
				counterExitStaff--;
		  }
  		  e.preventDefault(); $(this).parent('div').parent('div').parent('div').remove();
  		})
  		
  		
  		var counterExitMisc = 1;
		$('#btn_prod_exit_misc').click(function(event){
			event.preventDefault();
			counterExitMisc++;
			//var prodList = '[[${productList}]]';
			var prodOptions = '';
			prodList.forEach(function(product) {
				prodOptions = prodOptions + '<option value="'+product.prod_id+'">'+product.name+'</option>';
				});
			var locationOptions = '';
			locationList.forEach(function(location) {
				locationOptions = locationOptions + '<option value="'+location.location_name+'">'+location.location_name+'</option>';
				});
			var vehicleOptions = '';
			vehicleList.forEach(function(vehicle) {
				vehicleOptions = vehicleOptions + '<option value="'+vehicle.vehicle_no+'">'+vehicle.vehicle_no+'</option>';
				});
				var contractorOptions = '';
			contractorList.forEach(function(contractor) {
				contractorOptions = contractorOptions + '<option value="'+contractor.name+'">'+contractor.name+'</option>';
				});
			var exit_product_misc = 
				'<div>'+
				' <div class="form-group row">'+
				' 	<div class="col-lg-2">'+
				' 		<h3><b>#'+counterExitMisc+'</b></h3>'+
				' 	</div>'+
				' 	<div class="col-lg-8"></div>'+
				' 	<div class="col-lg-2">'+
				' 		<button type="button" class="product_remove btn btn-danger float-right">Delete Product</button>'+
				' 	</div>'+
				' </div>'+
				'<div class="form-group row">'+
				'	<label class="col-lg-3 col-form-label form-control-label">Product name<span><b>*</b></span></label>'+
				'	<div class="col-lg-9">'+
				'	  <select class="form-control select2" name="product_id" id="product_id_exmisc_'+counterExitMisc+'" style="width: 100%;height: 100%;">'+
				'			<option value="">select option</option>'+prodOptions+
				'	  </select>'+
				'	</div>'+
				'</div>'+
				'<div class="form-group row">'+
				'	<label class="col-lg-3 col-form-label form-control-label">product Quantity<span><b>*</b></span></label>'+
				'	<div class="col-lg-9">'+
				'	  <input id="product_quantity4" name="product_quantity" class="form-control" type="text" value="0" onclick="checkAvailableQuantity(event)">'+
				'	</div>'+
				'</div>'+
				'<div class="form-group row">'+
				'	<label class="col-lg-3 col-form-label form-control-label">Name of Work<span><b>*</b></span></label>'+
				'	<div class="col-lg-9">'+
				'	  <input id="work_name" name="work_name" class="form-control" type="text" value="">'+
				'	</div>'+
				'</div>'+
				'<div class="form-group row">'+
				'	<label class="col-lg-3 col-form-label form-control-label">Receiving Person Name<span><b>*</b></span></label>'+
				'	<div class="col-lg-9">'+
				'	  <input id="receiving_person" name="receiving_person" class="form-control" type="text" value="">'+
				'	</div>'+
				'</div>'+
				'<hr>'+
				'</div>';
				
				$('.exitByMisc').append(exit_product_misc);
				$('.select2').select2();
		});
		
		$('.exitByMisc').on("click",".product_remove", function(e){ //user click on remove text
		  if(counterExitMisc>0){
				counterExitMisc--;
		  }
  		  e.preventDefault(); $(this).parent('div').parent('div').parent('div').remove();
  		})
		
		/* fuel entry section */
		var counterFuelEntry = 1;
				$('#btn_fuel_entry_add').click(function(event){
					event.preventDefault();
					counterFuelEntry++;
					//var prodList = '[[${productList}]]';
					
					var add_fuel_entry = 
						'<div>'+
						' <div class="form-group row">'+
						' 	<div class="col-lg-2">'+
						' 	</div>'+
						' 	<div class="col-lg-8"></div>'+
						' 	<div class="col-lg-2">'+
						' 		<button type="button" class="product_remove btn btn-danger float-right">Delete Product</button>'+
						' 	</div>'+
						' </div>'+
						'<div class="form-group row">'+
						'<label class="col-lg-3 col-form-label form-control-label">Fuel Type<span><b>*</b></span></label>'+
						'<div class="col-lg-9">'+
						'  <select class="form-control" name="fuel_type" id="fuel_type">'+
						'		<option value="">select option</option>'+
						'		<option value="diesel">Diesel</option>'+
						'		<option value="petrol">Petrol</option>'+
						'  </select>'+
						'</div>'+
						'</div>'+
						'<div class="form-group row">'+
						'<label class="col-lg-3 col-form-label form-control-label">Fuel Issue Quantity<span><b>*</b></span></label>'+
						'<div class="col-lg-9">'+
						'  <input id="fuel_quantity" name="fuel_quantity" class="form-control" type="text" value="0">'+
						'</div>'+
						'</div>'+
						'<div class="form-group row">'+
						'<label class="col-lg-3 col-form-label form-control-label">Invoice Number<span><b>*</b></span></label>'+
						'<div class="col-lg-9">'+
						'  <input id="invoice_no" name="invoice_no" class="form-control" type="text" value="">'+
						'</div>'+
						'</div>'+
						'<div class="form-group row">'+
						'<label class="col-lg-3 col-form-label form-control-label">Invoice Date<span><b>*</b></span></label>'+
						'<div class="col-lg-9">'+
						'  <input id="invoice_date" name="invoice_date" class="form-control" type="date" value="">'+
						'</div>'+
						'</div>'+
						'<div class="form-group row">'+
						'<label class="col-lg-3 col-form-label form-control-label">Vendor Name<span><b>*</b></span></label>'+
						'<div class="col-lg-9">'+
						'  <input id="vendor_name" name="vendor_name" class="form-control" type="text" value="">'+
						'</div>'+
						'</div>'+
						'<div class="form-group row">'+
						'<label class="col-lg-3 col-form-label form-control-label">Vehicle No.</label>'+
						'<div class="col-lg-9">'+
						'  <input id="vehicle_no" name="vehicle_no" class="form-control" type="text" value="">'+
						'</div>'+
						'</div>'+
						'<hr>'+
						'</div>';
						
						$('.fuelEntryDivStart').append(add_fuel_entry);
						$('.select2').select2();
				});
				
				$('.fuelEntryDivStart').on("click",".product_remove", function(e){ //user click on remove text
		  		  e.preventDefault(); $(this).parent('div').parent('div').parent('div').remove();
		  		})
				
				/* fuel exit section */
				var counterFuelExit = 1;
						$('#btn_fuel_exit_add').click(function(event){
							//alert("within exit");
							event.preventDefault();
							counterFuelExit++;
							//var prodList = '[[${productList}]]';
							
							var add_fuel_exit = 
								'<div>'+
								' <div class="form-group row">'+
								' 	<div class="col-lg-2">'+
								' 	</div>'+
								' 	<div class="col-lg-8"></div>'+
								' 	<div class="col-lg-2">'+
								' 		<button type="button" class="product_remove btn btn-danger float-right">Delete Product</button>'+
								' 	</div>'+
								' </div>'+
								'<div class="form-group row">'+
								'<label class="col-lg-3 col-form-label form-control-label">Type of Fuel Exit<span><b>*</b></span></label>'+
								'<div class="col-lg-9">'+
								'  <select class="form-control" name="exit_type" id="exit_type">'+
								'		<option value="">select option</option>'+
								'		<option value="petrol_diesel">Petrol / Diesel</option>'+
								'		<option value="misc">Miscellaneous</option>'+
								'  </select>'+
								'</div>'+
								'</div>'+
								'<hr><br>'+
								'<div class="form-group row">'+
								'<label class="col-lg-3 col-form-label form-control-label">Fuel Type<span><b>*</b></span></label>'+
								'<div class="col-lg-9">'+
								'  <select class="form-control" name="fuel_type" id="fuel_type">'+
								'		<option value="">select option</option>'+
								'		<option value="diesel">Diesel</option>'+
								'		<option value="petrol">Petrol</option>'+
								'  </select>'+
								'</div>'+
								'</div>'+
								'<div class="form-group row">'+
								'<label class="col-lg-3 col-form-label form-control-label">Vehicle No.<span><b>*</b></span></label>'+
								'<div class="col-lg-9">'+
								'  <select class="form-control" name="vehicle_no" id="vehicle_no">'+
								'		<option value="">select option</option>'+
								'		<option th:each="vehicle : ${vehicleList}" th:value="${vehicle.vehicle_no}" th:text="${vehicle.vehicle_no}"></option>'+
								'  </select>'+
								'</div>'+
								'</div>'+
								'<div class="form-group row">'+
								'<label class="col-lg-3 col-form-label form-control-label">Opening Reading<span><b>*</b></span></label>'+
								'<div class="col-lg-9">'+
								'  <input id="opening_reading" name="opening_reading" class="form-control" type="text" value="">'+
								'</div>'+
								'</div>'+
								'<div class="form-group row">'+
								'<label class="col-lg-3 col-form-label form-control-label">Mileage<span><b>*</b></span></label>'+
								'<div class="col-lg-9">'+
								'  <input id="mileage" name="mileage" class="form-control" type="text" value="">'+
								'</div>'+
								'</div>'+
								'<div class="form-group row">'+
								'<label class="col-lg-3 col-form-label form-control-label">Fuel Issue<span><b>*</b></span></label>'+
								'<div class="col-lg-9">'+
								'  <input id="fuel_issue" name="fuel_issue" class="form-control" type="text" value="0">'+
								'</div>'+
								'</div>'+
								'<div class="form-group row">'+
								'<label class="col-lg-3 col-form-label form-control-label">Issue Date<span><b>*</b></span></label>'+
								'<div class="col-lg-9">'+
								'  <input id="issue_date" name="issue_date" class="form-control" type="date" value="">'+
								'</div>'+
								'</div>'+
								'<div class="form-group row">'+
								'<label class="col-lg-3 col-form-label form-control-label">Type of Vehicle<span><b>*</b></span></label>'+
								'<div class="col-lg-9">'+
								'  <select class="form-control" name="vehicle_type" id="vehicle_type">'+
								'		<option value="">select option</option>'+
								'		<option th:each="vehicleType : ${distinctVehicleTypeList}" th:value="${vehicleType}" th:text="${vehicleType}"></option>'+
								'  </select>'+
								'</div>'+
								'</div>'+
								'<hr>'+
								'</div>';
								
								$('.fuelExitDivStart').append(add_fuel_exit);
								$('.select2').select2();
						});
						
						$('.fuelExitDivStart').on("click",".product_remove", function(e){ //user click on remove text
				  		  e.preventDefault(); $(this).parent('div').parent('div').parent('div').remove();
				  		})
  		
	});