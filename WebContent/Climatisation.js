$(document).ready(function() {
	$("#sourceNbId").blur(function() {
		$.ajax({
			url : 'ClimatisationAjax',
			type : 'GET',
			dataType : 'text', // On désire recevoir du texte
			success : function(texte) { // texte contient le texte renvoyé
				$("#nbId").html(texte);
			}
		});

	});
});
