function onDelete(id){
	console.log(id);
	
	
	
	
	
	
	
	swal({
		  title: "Are you sure?",
		  text: "Once deleted",
		  icon: "warning",
		  buttons: true,
		  dangerMode: true,
		})
		.then((willDelete) => {
		  if (willDelete) {
		    swal("Poof! Your imaginary file has been deleted!", {
		      icon: "success",
		    });
		  } 
		});
}
