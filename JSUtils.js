var JSUtils = function() {
	return {
		getStringById: function (Id) {
			console.log(document.getElementById(Id).value);
			return String(document.getElementById(Id).value);
		},
		getNumericById: function(Id) {
			return parseInt(document.getElementById(Id).value);
		},
		setStringById: function (Id, Val) {
			document.getElementById(Id.trim()).value = Val.trim();
			//setTimeout(function(){ document.getElementById(Id.trim()).value = Val.trim(); }, 1000);
		},
		getStartDateRangePicker: function(Id) {
			var res = [];
			tDate = $('#'+Id).data('daterangepicker').startDate.format('YYYY-MM-DD');
			tValu = tDate.split('-');
			res.push(parseInt(tValu[0]));
			res.push(parseInt(tValu[1]));
			res.push(parseInt(tValu[2]));
			return res;
		},
		getEndDateRangePicker: function(Id) {
			var res = [];
			tDate = $('#'+Id).data('daterangepicker').endDate.format('YYYY-MM-DD');
			tValu = tDate.split('-');
			res.push(parseInt(tValu[0]));
			res.push(parseInt(tValu[1]));
			res.push(parseInt(tValu[2]));
			return res;
		},
		getStringVar: function (Var) {
			let returnvalue = '';
			console.log(Var + ': '+ returnvalue);
			eval('returnvalue = ' + Var + ';')
			return returnvalue;
		},
		executeFunction: function(FunctionName, Params){
			eval(FunctionName+'('+Params+')');
		},
		openURL: function (Url) {
			window.location.href = Url;
		},
		showModal: function (Id) {
			$('#' + Id).modal();
		},
		hideModal: function (Id) {
			$('#' + Id).modal('hide');
		}
	}
}