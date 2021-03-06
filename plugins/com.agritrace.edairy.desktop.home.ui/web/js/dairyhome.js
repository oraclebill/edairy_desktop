/**
 * Script to generate tables and graph for dairy home page / dashboard
 */
var COLORS = [ "Coral", "MediumSlateBlue", "Gold", "DarkSeaGreen", "RosyBrown",
		"MediumPurple", "PaleVioletRed", "GreenYellow", "DarkKhaki",
		"MediumAquaMarine", "MediumOrchid", "MediumTurquoise",
		"CornflowerBlue", "Salmon", "Turquoise", "LightCoral", "DarkSalmon",
		"SandyBrown", "DarkGray", "Cyan", "Fuchsia", "Yellow", "LightGreen",
		"Tan", "LightSalmon", "BurlyWood", "HotPink", "Aqua", "Orchid",
		"PaleGreen", "Silver", "SkyBlue", "LightSkyBlue", "Magenta",
		"LightSteelBlue", "Aquamarine", "Plum", "Violet", "Khaki", "LightBlue",
		"Thistle", "PowderBlue", "LightPink", "LightGrey", "PaleGoldenRod",
		"Wheat", "NavajoWhite", "Pink", "PaleTurquoise", "PeachPuff",
		"Gainsboro", "Moccasin", "Bisque" ];

function getData() {
	var d = [];
	for (i = 0; i < 25; i++) {
		num = Math.floor(Math.random() * 800 + Math.random() * 800);
		num = num / 10;
		if (i < 10)
			d[i] = [ "R00" + i, num, Math.floor(num * Math.random()) ];
		else
			d[i] = [ "R0" + i, num, Math.floor(num * Math.random()) ];
	}
	return d;
}

function genTableData(data) {
	var sums = [ 0, 0, 0 ];
	for (i = 0; i < data.length; i++) {
		row = data[i];

		name = row[0];
		am_qty = row[1];
		pm_qty = row[2];
		sum = am_qty + pm_qty;
		sums[0] += am_qty;
		sums[1] += pm_qty;
		sums[2] += sum;
		html = '<tr><th scope="row">' + name + '</th><td class="chart">'
				+ am_qty.toFixed(2) + '</td><td class="chart">' + pm_qty.toFixed(2) + '</td><td>'
				+ sum.toFixed(2) + '</td></tr>';
		$('table#intake-data-table tbody').append(html);
	}
	$('table#intake-data-table tfoot').append("<tr><td></td></tr>");
	html = '<tr><th >Total</th><td>' + sums[0].toFixed(2)
			+ '</td><td>' + sums[1].toFixed(2) + '</td><td>'
			+ sums[2].toFixed(2) + '</td></tr>';
	$('table#intake-data-table tfoot').append(html);

}

function getReportDate() {
	return new Date();
}

$(document).ready(function() {
	/** build the table * */
	date = getReportDate();
	try {
		dateStr = date.getDate() + "/" + date.getMonth() + "/" + date.getFullYear();
		data = getIntakeData(dateStr);
//		data = getData();  // testing
	}
	catch (e) {
		alert(e);
	}
//	alert("in document ready: " + data);
	genTableData(data);
	/** visualize with a line graph **/
	pieProps = {
		type : 'pie',
		parseDirection : 'y',
		colors : COLORS,
		colFilter : '.chart',
		width : 100,
		height : 100,
		title : ' ',
		pieLablePos : 'outside'
	};

	barProps = {
		type : 'bar',
		parseDirection : 'y',
		//colors : COLORS,
		colFilter : '.chart',
		barMargin : 0,
		barGroupMargin : 2,
		width : 1000,
		height : 100,
		title : ' '
	};
	$('table#intake-data-table').visualize(barProps).insertAfter('#chart-by-route');
//	$('table#intake-data-table').visualize(pieProps).appendTo('#pie-chart');

	// for some reason in ie, we have to refresh after moving the table..
	$('.visualize').trigger('visualizeRefresh');
});
