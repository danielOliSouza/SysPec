function openModal() {
	var tipo = PF('wgvTipo').jq.find(".ui-selectonemenu-label")
	.first().text();
	console.log(tipo);
	if (tipo == "NATURAL")
		PF("modalNatural").show();
	else if (tipo == "INSEMINACAO")
		PF("modalInsem").show();
}
window.onload = function() {
	var idin = parseInt($.urlParam("idinsem"));
	var idGest = parseInt($.urlParam("idGestacao"));

	if(isNaN(idin) && isNaN(idGest))
		PF('insereAnimal').show();
}

$.urlParam = function(name) {
	var results = new RegExp('[\?&amp;]' + name + '=([^&amp;#]*)')
	.exec(window.location.href);
	if (results == null) {
		return null;
	} else {
		return decodeURI(results[1]) || 0;
	}
}