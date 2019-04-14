$( document ).ready(function() {
	var album;
	$("#button").click(function(event){
		console.log("gdkfhd");
		event.preventDefault();
		
		var cont = validate();
		if (cont) {
			$("#confirm").dialog({ 
				width: 500, 
				modal: true,
				resizable: false,
				draggable: false,
				buttons: {
					"Add": function() {
						$("input").val("")
							.css('borderWidth', '1px')
							.css('borderColor', 'black');
							
						addAlbums(album);
						$(this).dialog("close");
					},
					"Back": function() {
						$(this).dialog("close");
					}
				}
			});//dialog
		}//if (valid)
	});
	
	function validate() {
		var albumName     = /^[a-zA-Z]{1,25}$/;
		var artistName    = /^[a-zA-Z]{1,25}$/; 
		var companyName   = /^[a-zA-Z]{1,25}$/;
		var yearPublished = /^(?:((19)([0-9]{2}))|((20)((0[0-9])|1[0-6])))$/;
		var albumPrice    = /^([0-9]+)(\.?)([0-9]{1,2})$/;
		
		var isValid = true;
		
		album = {
			albumName:     contain("#albumName",     albumName,     "Invalid album name.",        "#confirmAlbum"),
			artistName:    contain("#artistName",    artistName,    "Invalid artist Name.",       "#confirmArtist"),
			companyName:   contain("#companyName",   companyName,   "Invalid companyName Name.",  "#confirmCompany"),
			yearPublished: contain("#yearPublished", yearPublished, "Invalid amount.",            "#confirmYear"),
			albumPrice:    contain("#albumPrice",    albumPrice,    "Invalid amount.",            "#confirmPrice"),
			albumGenre: function() {
				var selected = $("#genreList").val();
				$("#confirmGenre").append(selected);
				return selected;
			},
			albumCondition: function() {
				var selected = $("#conditionList").val();
				$("#confirmCondition").append(selected);
				return selected;
			}
		}
		
		function contain(id, regex, errorMessage, confirm) {
			var input_v = $(id).val();
			if ( input_v == undefined ) 
				input_v = ""; 
			
			var valid = regex;
			var tester = valid.test(input_v);
			
			isValid = isValid && tester;
			try {
				if (input_v == "") { throw ""; }
					else if (tester != true) { throw ""; }
						else { 
							$(id).css('borderWidth', '2px')
								 .css('borderColor', 'Green');
							
							$(confirm).append(input_v);
						}
			}
			catch(err) {
				$("#message").text(errorMessage);
				$(id).css('borderWidth', '2px').css('borderColor', 'red');
			}
			finally {
				return input_v;
			} 
		}
		return isValid;
	}
	
	function addAlbums(album) {
		console.log(album);
		$.Post("addAlbum.php", function(data, status) {
			genre = album.albumGenre();
			albumName = album.albumName;
			artist = album.artistName;
			company = album.companyName;
			condition = album.albumCondition();
			year = album.yearPublished;
			price = album.albumPrice;
		});
	}
});