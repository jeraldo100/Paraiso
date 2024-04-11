 var contextPath = '${pageContext.request.contextPath}' + '/';
  	
  	$(document).ready(function(){
  	    var table = $('#addOnsList').DataTable({
  	    	lengthMenu: [1, 3, 5, 10, 50, 100],
  	        pageLength: 50,
  	        columnDefs: [
  	            { targets: [0, 1, 2, 3], searchable: true },
  	            { targets: [4], searchable: false },
  	        ]
  	    });
  	    
  	    var table = $('#voucherList').DataTable({
  	    	lengthMenu: [1, 3, 5, 10, 50, 100],
  	        pageLength: 50,
  	        columnDefs: [
  	            { targets: [0, 1, 2, 3, 4], searchable: true },
  	            { targets: [5], searchable: false },
  	        ]
  	    });
  	    
  	    var table = $('#roomList').DataTable({
  	    	lengthMenu: [1, 3, 5, 10, 50, 100],
  	        pageLength: 50,
  	        columnDefs: [
  	            { targets: [0, 1, 2, 3], searchable: true },
  	            { targets: [4], searchable: false },
  	        ]
  	    });
  	    
  	    var table = $('#userList').DataTable({
  	    	lengthMenu: [1, 3, 5, 10, 50, 100],
  	        pageLength: 50,
  	        columnDefs: [
  	            { targets: [0, 1, 2, 3, 4, 5, 6, 7, 8, 9], searchable: true },
  	            { targets: [10], searchable: false },
  	        ]
  	    });
  	    
  	    var table = $('#bookingList').DataTable({
			lengthMenu: [1, 3, 5, 10, 50, 100],
			pageLength: 50,
  	        columnDefs: [
  	            { targets: [0, 1, 2, 3, 4, 5, 6, 7, 8], searchable: true },
  	            { targets: [9,10], searchable: false },
  	        ]
		});
  	    
  	    $('#printButton').click(function() {
    // Get the DataTable's raw data source
    var dataSource = table.rows().data().toArray();

    // Loop through each row data
    dataSource.forEach(function(rowData) {
        // Print each row data
        console.log(rowData);
    });
});
  	    
  	    $('#printTotalPriceBtn').click(function() {
	        var totalPrice = 0;
	        $('#bookingList tbody tr').each(function() {
	            var price = parseFloat($(this).find('td:eq(4)').text()); 
	            if (!isNaN(price)) {
	                totalPrice += price;
	            }
	        });

	        var printWindow = window.open('', '_blank');
	        printWindow.document.write('<html><head><title>Total Price</title></head><body><div id="totalPrice">Total Revenue: ' + totalPrice.toFixed(2) + '</div></body></html>');
	        printWindow.document.close();

	        printWindow.print();
	        printWindow.close();
	    });
  	});