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
  		
	});