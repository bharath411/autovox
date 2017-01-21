

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Shopvox {

	WebDriver driver  = null;
	
	@BeforeClass
	public void baseSetup(){
		loadExcel();
		driver  = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://app.shopvox.com/login");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	public void login(String username,String password){

		driver.findElement(By.xpath("//input[@id='email']")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.name("commit")).click();
	}

	
	@Test
	public void testLogin(){
		String username = "laxmikanth.veggalam@gmail.com";
		String password = "test123";
		login(username, password);
		clickOnCustomers();
		addNewCustomer();
	}
	
	public void clickOnCustomers(){
		
		driver.findElement(By.xpath("//span[text()='Customers & Vendors']")).click();
		driver.findElement(By.xpath("//span[text()='Customers']")).click();
		
	}
	
		public void addNewCustomer(){
			
			ArrayList<String> list = readExcelRow(1);
			String name = list.get(0);
			String leagalName = list.get(1);
			String type = list.get(2);
			String board_view = list.get(3);
			String status = list.get(4);
			String tax = list.get(5);
			String terms = list.get(6);
			String sales_rep = list.get(7);
			String primary_name = list.get(8);
			String email = list.get(9);
			String primary_email = list.get(10);
			String primary_phone = list.get(11);
			String ext = list.get(12);
			String industry = list.get(13);
			String lead_source = list.get(14);
			String pricing = list.get(15);
			String credit_limit = list.get(16);
		driver.findElement(By.cssSelector(".actions .caret")).click();
		driver.findElement(By.xpath("//a[@ui-sref='companies.new' and @class='ng-binding']")).click();
		
		
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys(name);
		
		driver.findElement(By.xpath("//input[@placeholder='Legal Name']")).sendKeys(leagalName);
		WebElement checkbox = driver.findElement(By.xpath("//checkbox-field[@label='"+type+"']//input[@type='checkbox']"));
		if(!checkbox.isSelected()){
			checkbox.click();
		}
		WebElement checkbox_EnbaleView = driver.findElement(By.xpath("//checkbox-field[@label='Enable Job board View']//input[@type='checkbox']"));
		if(board_view.contains("true") && !checkbox_EnbaleView.isSelected()){
			checkbox_EnbaleView.click();
		}
		
		
		Select select_status = new Select(driver.findElement(By.xpath("//vox-select-field[@label='Status']//select")));
		select_status.selectByVisibleText(status);
		
		Select select_tax = new Select(driver.findElement(By.xpath("//vox-select-field[@label='Tax']//select")));
		select_tax.selectByVisibleText(tax);
		
		Select select_terms = new Select(driver.findElement(By.xpath("//vox-select-field[@label='Terms']//select")));
		select_terms.selectByVisibleText(terms);
		
		Select select_sales_rep = new Select(driver.findElement(By.xpath("//vox-select-field[@label='Sales rep']//select")));
		select_sales_rep.selectByVisibleText(sales_rep);
		
		
		driver.findElement(By.xpath("//h2[text()='Primary contact']/following::input[@placeholder='Name']")).sendKeys(primary_name);
		driver.findElement(By.xpath("//input[@placeholder='E-mail']")).sendKeys(email);
		driver.findElement(By.xpath("//input[@placeholder='jsmith@acme.com']")).sendKeys(primary_email);
		driver.findElement(By.xpath("//input[@placeholder='(555) 555-5555']")).sendKeys(primary_phone);
		driver.findElement(By.xpath("//input[@placeholder='555']")).sendKeys(ext);
		
		Select select_industry = new Select(driver.findElement(By.xpath("//vox-select-field[@label='Industry']//select")));
		select_industry.selectByVisibleText(industry);
		
		Select select_lead_source = new Select(driver.findElement(By.xpath("//vox-select-field[@label='Lead source']//select")));
		select_lead_source.selectByVisibleText(lead_source);
		
		Select select_priceing = new Select(driver.findElement(By.xpath("//vox-select-field[@label='Pricing Level']//select")));
		select_priceing.selectByVisibleText(pricing);
		
		
		
		driver.findElement(By.xpath("//input[@placeholder='Credit limit']")).sendKeys(credit_limit);
		
		driver.findElement(By.cssSelector(".submit-button")).click();
	}
		
		File file  =null;
		FileInputStream fis = null;
		HSSFWorkbook workbook = null;
		HSSFSheet sheet = null;
		public void loadExcel(){
			try {
			file  = new File("D:\\JBR_ShopVox.xls");
			fis = new FileInputStream(file);
			workbook = new HSSFWorkbook(fis);
			sheet = workbook.getSheet("shopvox");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		public ArrayList<String> readExcelRow(int number){
			
		HSSFRow row = sheet.getRow(number);
		ArrayList<String> list = new ArrayList<String>();
		int cellNumber = row.getPhysicalNumberOfCells();
		System.out.println(cellNumber);
		for (int i = 0; i < cellNumber; i++) {
			HSSFCell cell = row.getCell(i);
			String value ="";
			if(cell.getCellType()==cell.CELL_TYPE_STRING){
				value = cell.getStringCellValue();
			}else if(cell.getCellType()==cell.CELL_TYPE_NUMERIC){
				value = (int)cell.getNumericCellValue()+ "";
			}else if(cell.getCellType()==cell.CELL_TYPE_BOOLEAN){
				value = cell.getBooleanCellValue()+ "";
			}else {
				value="";
			}
			
			list.add(i,value);
			}
		
		return list;
		}
		
		public static void main(String[] args) {
			Shopvox vox =new Shopvox();
			vox.loadExcel();
			ArrayList<String> list = vox.readExcelRow(1);
			
			for (String string : list) {
				System.out.println(string);
			}
		}
}
