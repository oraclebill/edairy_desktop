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
				+ am_qty + '</td><td class="chart">' + pm_qty + '</td><td>'
				+ sum + '</td></tr>';
		$('table#intakebyroute tbody').append(html);
	}
	$('table#intakebyroute tfoot').append("<tr><td></td></tr>");
	html = '<tr><th >Total</th><td>' + Math.floor(sums[0] * 10) / 10
			+ '</td><td>' + Math.floor(sums[1] * 10) / 10 + '</td><td>'
			+ Math.floor(sums[2] * 10) / 10 + '</td></tr>';
	$('table#intakebyroute tfoot').append(html);

}

function getReportDate() {
	return ("05/01/2010");
}

function generateTables() {
	date = getReportDate();
	try {
//		data = getIntakeData(date);
		data = getData();  // for testing
	}
	catch (e) {
		alert(e);
	}
	genTableData(data);
}
