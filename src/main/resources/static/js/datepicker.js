@DateTimeFormat(pattern = "yyyy-MM-dd")

$(function() {
	
	$( document ).ready(function() {
		
		$('.datepicker').pickadate({
		    monthsFull: ['Janeiro', 'Fevereiro', 'Mar�o', 'Abril', 'Maio', 'Junho', 'Julho', 'Agosto', 'Setembro', 'Outubro', 'Novembro', 'Dezembro'],
		    monthsShort: ['Jan', 'Fev', 'Mar', 'Abr', 'Mai', 'Jun', 'Jul', 'Ago', 'Set', 'Out', 'Nov', 'Dez'],
		    weekdaysFull: ['Domingo', 'Segunda', 'Ter�a', 'Quarta', 'Quinta', 'Sexta', 'Sab�do'],
		    weekdaysShort: ['Dom', 'Seg', 'Ter', 'Qua', 'Qui', 'Sex', 'Sab'],
		    today: 'Hoje',
		    clear: 'Limpar',
		    close: 'Pronto',
		    labelMonthNext: 'Pr�ximo m�s',
		    labelMonthPrev: 'M�s anterior',
		    labelMonthSelect: 'Selecione um m�s',
		    labelYearSelect: 'Selecione um ano',
		    selectMonths: true, 
		    selectYears: 15,
		    format: 'dd/mm/yyyy'	    
		 });
		
		$('select').material_select();
	});
})