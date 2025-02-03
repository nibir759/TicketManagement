import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Save {

    private String name,num,pass,cpass,gender,email,brth;
	
	private File file;
	private FileWriter fwriter; 
	private Scanner sc; 
    public Save()
    {

        
    }

    public Save(String name,String pass)//String num,String pass,String cpass,String gender,String email,String brth)
    {
        this.name=name;
        
        this.pass=pass;
        /*this.num=num;
        this.name=name;
        this.cpass=cpass;
        this.gender=gender;
        this.email=email;
        this.brth=brth;*/
        

        
    }

    public String getName() {

        return name;

    }


   /*  public String getNum() {

        return num;

    }*/


    public String getPass() {

        return pass;

    }


   /*  public String getCpass() {

        return cpass;

    }


    public String getGender() {

        return gender;

    }


    public String getEmail() {

        return email;

    }


    public String getBrth() {

        return brth;

    }*/


    

    public void setName(String name) {

        this.name = name;

    }


    /*public void setNum(String num) {

        this.num = num;

    }*/


    public void setPass(String pass) {

        this.pass = pass;

    }


   /*  public void setCpass(String cpass) {

        this.cpass = cpass;

    }


    public void setGender(String gender) {

        this.gender = gender;

    }


    public void setEmail(String email) {

        this.email = email;

    }


    public void setBrth(String brth) {

        this.brth = brth;

    }*/

    @SuppressWarnings("CallToPrintStackTrace")
    public void addAccount()
    {
        try 
		{
			file = new File("D:\\java\\Handiling\\Data.txt");
			file.createNewFile();
			fwriter = new FileWriter(file, true);
			fwriter.write("UserName: "+getName()+"\t"+"Password: "+getPass()+"\n");
			
            //fwriter.write(getPass()+"\t");
            /*fwriter.write(getCpass()+"\n");
            fwriter.write(getNum()+"\n");
            fwriter.write(getGender()+"\n");
            fwriter.write(getEmail()+"\n");
            fwriter.write(getBrth()+"\n");*/
			fwriter.flush();
			fwriter.close();
		}
		catch(IOException ioe) 
		{
			ioe.printStackTrace();
		}

    }


    @SuppressWarnings("CallToPrintStackTrace")
        public boolean checkAccount()
	{
		boolean flag = false;
		file = new File("D:\\java\\Handiling\\Data.txt");     						
		try 
		{
			sc = new Scanner(file);
			while(sc.hasNextLine())
			{
				String line = sc.nextLine();
				//String[] value = line.split("\t");
				if (line.contains("UserName:") && line.contains("Password:"))
                 {
                    // Extract username and password
                    String[] parts = line.split("\t");
                    if (parts.length >= 2) {
                        String storedUsername = parts[0].replace("UserName: ", "").trim();
                        String storedPassword = parts[1].replace("Password: ", "").trim();
    
                        if (storedUsername.equals(name) && storedPassword.equals(pass)) 
                        {
                            flag = true;
                            break;
                        }
                    }
                }
            }
		}
		catch(IOException ioe) 
		{
			ioe.printStackTrace();
		}
		return flag;
	}





    }

    

