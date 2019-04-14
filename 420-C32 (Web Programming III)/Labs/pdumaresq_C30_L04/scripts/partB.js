$( document ).ready(function() {
	$('#button').click(function() {
		$.ajax({
			type: "GET",
			url: "Lorem.txt",
			dataType: "text",
		}).done(function(data) {
			$('#readIt').text(data);
		});
	});
});