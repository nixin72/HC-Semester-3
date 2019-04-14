$( document ).ready(function() {
	$('.name').keyup(function() {
		$.ajax({
			type: "GET",
			url: "servertime.php",
			dataType: "text",
		}).done(function(data) {
			$('#showTime').text(data);
		});
	});
});