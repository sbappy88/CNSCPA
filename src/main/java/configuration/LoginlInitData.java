package configuration;

import util.MainInitData;



public class LoginlInitData extends MainInitData
{
    /**
     * Script Name   : <b>LoginlInitData</b>
     * Generated     : <b>September 23, 2012</b>
     * Description   : Functional Test Script
     *
     * @since  2012/09/25
     * @author Abu
     */
    protected static LoginlInitData loginData = null;


    public static String admin_login ="";
    public static String production_executive_login ="";
    public static String totalROI1to15Employees="";
    public static String factory_head_login="";
    public static String store_manager_login="";
    public static String factory_QC_manager_login="";



    /**
     * Constructor to initialize location variables.
     *
     * @throws Exception
     */
    protected LoginlInitData() throws Exception
    {
        super();
        // initialize variables
        initLoginlVariables();
    }
    //single instance of LocationData object
    public static LoginlInitData getInstance() throws Exception
    {
        if(loginData == null)
            loginData = new LoginlInitData();

        return loginData;
    }

    public void initLoginlVariables () throws Exception
    {
        // Valencia test data load
        totalROI1to15Employees = getScriptValue("totalROI1to15Employees");



    }
}

