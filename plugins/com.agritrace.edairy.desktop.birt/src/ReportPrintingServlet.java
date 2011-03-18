//import java.awt.print.Book;
//import java.awt.print.PageFormat;
//import java.awt.print.PrinterJob;
//import java.io.BufferedInputStream;
//import java.io.ByteArrayOutputStream;
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.nio.ByteBuffer;
//import java.util.Enumeration;
//import java.util.Properties;
//
//import javax.print.PrintService;
//import javax.print.PrintServiceLookup;
//
//import org.eclipse.birt.core.framework.IPlatformContext;
//import org.eclipse.birt.core.framework.Platform;
//import org.eclipse.birt.core.framework.PlatformFileContext;
//import org.eclipse.birt.report.engine.api.EngineConfig;
//import org.eclipse.birt.report.engine.api.EngineConstants;
//import org.eclipse.birt.report.engine.api.EngineException;
//import org.eclipse.birt.report.engine.api.IReportEngine;
//import org.eclipse.birt.report.engine.api.IReportEngineFactory;
//import org.eclipse.birt.report.engine.api.IReportRunnable;
//import org.eclipse.birt.report.engine.api.IRunAndRenderTask;
//import org.eclipse.birt.report.engine.api.PDFRenderOption;
//
//import com.sun.pdfview.PDFFile;
//
//
//public class ReportPrintingServlet // extends HttpServlet
//{
//
//// @Override
//	public void doGet(	) throws  IOException
//	{
//
//		System.out.println("Came for printing");
//		ServletContext servletContext = getServletConfig().getServletContext();
//		Object attribute = servletContext.getAttribute("reportprintproperties");
//		Properties properties = (Properties) attribute;
//		try {
//			generatePDFFile(properties, request);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//
//	private void generatePDFFile(	Properties properties
//									) throws Exception
//	{
//		final String REPORT_ENGINE = "";// Path of your ReportEngine
//		final String REPORTS_PATH = "";// Path where .rptdesign files are kept
//		final String OUTPUT_LOCATION = "";// Location where pdf is to be generated
//
//		PDFRenderOption options = new PDFRenderOption();
//		EngineConfig config = new EngineConfig();
//		config.setEngineHome(REPORT_ENGINE);
//		IPlatformContext context = new PlatformFileContext();
//		config.setEngineContext(context);
//		IReportEngineFactory factory = (IReportEngineFactory) Platform
//				.createFactoryObject(IReportEngineFactory.EXTENSION_REPORT_ENGINE_FACTORY);
//
//		IReportEngine engine = factory.createReportEngine(config);
//		IReportRunnable runnable = null;
//		try {
//			runnable = engine.openReportDesign(REPORTS_PATH);
//		} catch (EngineException e) {
//			System.err.println("Design " + REPORTS_PATH + " not found!");
//			e.printStackTrace();
//			engine.destroy();
//		}
//
//		IRunAndRenderTask task = engine.createRunAndRenderTask(runnable);
//
//		ByteArrayOutputStream fso = new ByteArrayOutputStream();
//		options.setOutputStream(fso);
//		options.setOutputFormat(PDFRenderOption.OUTPUT_FORMAT_PDF);
//		options.setSupportedImageFormats("PNG");
//		options.setOutputFileName(OUTPUT_LOCATION); //
//		task.setRenderOption(options);
//
//		Enumeration names = request.getParameterNames();
//
//		while (names.hasMoreElements()) {
//			String name = (String) names.nextElement();
//			String value = request.getParameter(name);
//			task.setParameterValue(name, value);
//		}
//
//		task.getAppContext().put(EngineConstants.APPCONTEXT_CLASSLOADER_KEY,
//				Thread.currentThread().getContextClassLoader());
//		task.run();
//		System.out.println("Created Report " + OUTPUT_LOCATION + ".");
//		engine.destroy();
//
//		String printerName = request.getParameter("printer");
//		if (printPDF(OUTPUT_LOCATION, printerName)) {
//			deletePDFFile(OUTPUT_LOCATION);
//
//		}
//	}
//
//	private boolean printPDF(	String filename,
//								String printerName) throws Exception
//	{
//
//		FileInputStream fis = null;
//		BufferedInputStream bufferedInputStream = null;
//		ByteBuffer bb = null;
//
//		try {
//			File f = new File(filename);
//			fis = new FileInputStream(f);
//// FileChannel fc = fis.getChannel();
//// ByteBuffer bb = fc.map(FileChannel.MapMode.READ_WRITE, 0, fc.size());
//			bufferedInputStream = new BufferedInputStream(fis);
//			byte bytes[] = new byte[fis.available()];
//			bufferedInputStream.read(bytes);
//			bb = ByteBuffer.wrap(bytes);
//			PDFFile pdfFile = new PDFFile(bb); // Create PDF Print Page
//			PDFPrintPage pages = new PDFPrintPage(pdfFile);
//
//// Create Print Job
//			PrinterJob pjob = PrinterJob.getPrinterJob();
//			PageFormat pf = PrinterJob.getPrinterJob().defaultPage();
//			pjob.setJobName(f.getName());
//
//			/**
//			 * Use the printer which comes as parameter from URL. So that we can redirect the print at runtime to any of
//			 * the printer.
//			 */
//			PrintService selectedPrinter = null;
//			PrintService[] services = PrintServiceLookup.lookupPrintServices(null, null);
//			for (PrintService printService : services) {
//
//				System.out.println(printService.getName() + " = " + printerName);
//				if (printService.getName().equalsIgnoreCase(printerName)) {
//					selectedPrinter = printService;
//
//					break;
//				}
//
//			}
//			pjob.setPrintService(selectedPrinter);
//
//			Book book = new Book();
//			book.append(pages, pf, pdfFile.getNumPages());
//			pjob.setPageable(book);
//			System.out.println("Printer : " + pjob.getPrintService().getName());
//// Send print job to default printer
//
//			pjob.print();
//			System.out.println("Sent for Printing : É.");
//
//			return true;
//
//		} catch (Exception e) {
//			e.printStackTrace();
//			return false;
//		} finally {
//
//			bb.clear();
//			try {
//				fis.close();
//				bufferedInputStream.close();
//			} catch (Exception e) {
//				throw new Exception(e);
//			} finally {
//				fis = null;
//				bufferedInputStream = null;
//			}
//
//		}
//
//	}
//
//	private void deletePDFFile(String OUTPUT_LOCATION) throws Exception
//	{
//
//		File file = new File(OUTPUT_LOCATION);
//		boolean deleted = false;
//		if (file != null && file.exists()) {
//// file.renameTo(new File(OUTPUT_LOCATION.replace(".", "_")));
//			deleted = file.delete();
//		}
//		System.out.println(" Generated PDF Deleted " + deleted);
//	}
//}
