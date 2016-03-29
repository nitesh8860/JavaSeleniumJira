package utility;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import properties.LoadProperties;

public class LibraryFunc {
	
	public static WebDriver driver = null;
	static LoadProperties object=new LoadProperties();
	public static WebElement element; 
	
	//Method to generate random number
	
	public static String nbsp() 
   	{   
   	    int x = (int)(Math.random() * 9);
   	    x = x + 1;
   	    String randomPIN = (x + "") + ( ((int)(Math.random()*1000)) + "" );
   	    return randomPIN;
   	}
	
	//To locate Object By ID
	
	
	
	public static WebElement getObjectById(WebDriver driver,String id) {

        try{

              element= driver.findElement(By.id(object.getPropValues(id)));

        }catch(Throwable t){

              // report error

              //takeScreenShot(id);

             // Assert.assertTrue(t.getMessage(),false);

              
//
              return null;

        }
        
        return element;
        
  }
	
	
	//To locate Object By Name
	
	public static WebElement FindElementByName(WebDriver driver,String name)
	  {
		try{

            element= driver.findElement(By.name(name));

      }catch(Exception e){

            
            e.printStackTrace();

      }
		return element;
      
	  }
	
	
	//To Locate Object by Class
	
	
	public static WebElement FindElementByClass(WebDriver driver ,String classname)
	  {
	      try
	      {
	           return driver.findElement(By.className(object.getPropValues(classname)));
	      }
	      catch(Throwable t)
	      {
	    	  return null;
	      }
	       
	  }

	

	    //To click a button using id
	    public static void ClickButton(String id,String label,WebDriver driver)
	    {
	        try
	        {
	               WebElement element=getObjectById(driver,id);
	                //Snooze();
	                element.click();
	               // PrintMessage(label+" is selected");
	        }
	        catch(Exception e)
	        {
	        	System.out.println("Got an Exception:B " + e.getMessage());
	        }
	    }   
	    
	    // To click button using name
	    
	    public static void ClickButtonByName(WebDriver driver,String name)
	    {
	    	try
	    	{
	    		WebElement element=FindElementByName(driver,name);
	    		element.click();
	    	}
	    	catch(Exception e)
	    	{
	    		System.out.println("Got an Exception:B " + e.getMessage());
	    	}
	    }

	            //To click a button using class
	            public void ClickButtonByClass(String classname,String label,WebDriver driver)
	            {
	                try
	                {
	                        WebElement webElement= FindElementByClass(driver,classname);
	                       // Snooze();
	                        webElement.click();
	                        //PrintMessage(label+" is selected");
	                }
	                catch(Exception e)
	                {
	                	System.out.println("Got an Exception: " + e.getMessage());
	                }
	            }   
	     

	    //To enter data into Textbox
	            
	     public String editTextFieldDirect(WebElement element ,String text,String label)
	      {
	            element.clear();//To clear contents if present
	            try
	            {
	                      element.sendKeys(text);
	                      String  elementVal=element.toString();
	                      if(elementVal.contains("password"))
	                      {   
	                         // PrintMessage("Password is entered");
	                      }
	                      else
	                      {   
	                         // PrintMessage("Value entered for "+label+" is "+text);
	                      }  
	            }
	            catch(Exception e){
	                System.out.println("Got an Exception: " + e.getMessage());
	                //cv.verifyTrue(false, "<font color= 'red'> Failed due to : </font> "+e.getMessage());
	            }
	            return text;
	      }
	     
	     
	   //To select Radio button
	        public void ClickRadioButton(WebDriver driver,String id)
	        {
	            try
	            {
	                    WebElement webElement= getObjectById(driver,id);
	                    //Snooze();
	                    webElement.click();                 
	                  String  text=webElement.getText();          
	                  System.out.println(text+" is selected");
	            }
	            catch(Exception e)
	            {
	            	System.out.println(e);
	            }
	        } 

	    //To select Link
	    public void ClickLink(String id,String label,WebDriver driver)
	    {
	        try
	        {
	        	ClickButton(id,label,driver);
	        }
	        catch(Exception e)
	        {
	        	System.out.println(e);
	        }
	    } 

	  
	    //Select a checkbox
	    public void CheckboxSelect(String id,String label,WebDriver driver)
	    {
	        try
	        {
	                WebElement webElement= getObjectById(driver,id);
	                //Snooze();
	                webElement.click();
	                System.out.println("Checkbox "+label+" is selected");
	        }
	        catch(Exception e)
	        {
	        	System.out.println("");
	        }
	    } 

	    //To select value in Combobox
	    public void SelectData(String id,String label,String cellval,WebDriver driver)
	    {
	        try
	        {
	                WebElement webElement= getObjectById(driver,id);
	               // Snooze();
	                webElement.click();
	                String elementStr=webElement.toString();
	                int itemIndex=elementStr.indexOf("value");
	                if(itemIndex>-1)
	                {   
	                    int endIndex=elementStr.length()-3;
	                    String item=elementStr.substring(itemIndex+7, endIndex);
	                    if(cellval=="0")
	                    {   
	                    	System.out.println(item+" is selected for "+label);
	                    }
	                    else
	                    {
	                    	System.out.println(cellval+"  "+label+" is selected");
	                    }
	                }   
	                else
	                {
	                	System.out.println(cellval+" is selected for "+label);
	                }
	        }
	        catch(Exception e)
	        {
	        	System.out.println("");
	        }
	    } 

	      //To check if WebElement with id exists
	      public static boolean isExists(String id) 
	      {
	          boolean exists = false;
	          driver.manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS);
	              try 
	              {
	                       exists=driver.findElements( By.id(id) ).size() != 0;    
	              } 
	              catch (Exception e) 
	              {
	            	  System.out.println("");
	             }
	              if(exists==true)


	               return true;


	              else


	               return false;
	      }

	      //To check if WebElement with name exists
	      public static boolean isExistsName(String name) 
	      {
	          boolean exists = false;
	          driver.manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS);
	              try 
	              {
	                       exists=driver.findElements( By.name(name) ).size() != 0;    
	              } 
	              catch (Exception e) 
	              {
	                  if(e.getMessage().contains("InvalidSelectorError"))
	                  {   
	                      System.out.println("");
	                  }
	                  else
	                	  System.out.println("Does not exists");
	             }
	              if(exists==true)


	               return true;


	              else


	               return false;
	      }

	        //Explicit wait until a element is visible and enabled using id
	        public void ExplicitlyWait(String id)
	          {
	              try
	              {
	                  WebElement myDynamicElement = (new WebDriverWait(driver, 10))
	                            .until(ExpectedConditions.presenceOfElementLocated(By.id(id)));
	              }
	              catch(Exception e)
	              {
	                 e.printStackTrace();
	          }
	              
	          }

	        
	        
	    

	    

	    //Sleep for milliSeconds
	    public static void Sleep(int milisec) throws InterruptedException
	    {
	        Thread.sleep(milisec);
	    }

	   

	     
	
	//Table Methods
	     
	     //Search a text in table and click particular column
	     
	     
	public static void clickInTable(WebDriver driver, String tableid,
			int searchColIndex, String searchString, int clickColIndex,
			int excludeFromTop, int excludeFromBottom,String clickBtnid) {
		 WebElement table = driver.findElement(By.id(tableid));
		

		 List<WebElement> rows = table.findElements(By.tagName("tr")); 
		 WebElement tRow= rows.get(1);
		  
	 System.out.println(tRow.getText()); 
		 
		 List<WebElement> allCells = null;
				 //tRow.findElements(By.tagName("td")); 
		/* System.out.println("Total rows "+ rows.size()); 
		 System.out.println("Total cols "+ allCells.size()); */
		 
		 boolean found=false;

		 
		 for(int rNum=excludeFromTop;rNum<rows.size() - excludeFromBottom ;rNum++)
		 { 
		   WebElement currentRow = rows.get(rNum); 
		   allCells = currentRow.findElements(By.tagName("td")); 
		   
		   String firstClumntext=allCells.get(searchColIndex).getText() ;
		    if (firstClumntext.equals(searchString))
		    {
		    	allCells.get(clickColIndex).findElement(By.name(clickBtnid)).click();
		    	try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    	
		    	break;
		    }
		 }
		 try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 System.out.println(found);

		
	}
	
	 
	  
	
	  

	  

}
