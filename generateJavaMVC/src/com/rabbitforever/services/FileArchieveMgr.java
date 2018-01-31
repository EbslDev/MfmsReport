package com.rabbitforever.services;

import java.io.File;

import com.rabbitforever.policies.SystemParams;

public class FileArchieveMgr {
	public FileArchieveMgr()
	{
		
	} // end constructor
	
	public void maintainFileArchieve()
	{
		try
		{
			String tempDirPath = SystemParams.OUTPUT_ROOT_DIRECTORY;
			
			File tempDir = new File(tempDirPath);
	
			// if the directory does not exist, create it
			if (!tempDir.exists())
			{
				System.out.println("creating directory: " + tempDirPath);
				tempDir.mkdir();
			}
			
			String javaDirPath = SystemParams.OUTPUT_ROOT_DIRECTORY + "\\" + SystemParams.PROJECT_FOLDER_ROOT;
			File javaDir = new File(javaDirPath);
			if (!javaDir.exists())
			{
				System.out.println("creating directory: " + javaDirPath);
				javaDir.mkdir();
			}
			
			// vo
			String vosDirPath = SystemParams.OUTPUT_ROOT_DIRECTORY + "\\" + SystemParams.PROJECT_FOLDER_ROOT +"\\" + SystemParams.VO_DIR_NAME;
			File vosDir = new File(vosDirPath);
			if (!vosDir.exists())
			{
				System.out.println("creating directory: " + vosDirPath);
				vosDir.mkdir();
			}			
			
			// service Interface
			String servicesIDirPath = SystemParams.OUTPUT_ROOT_DIRECTORY + "\\" + SystemParams.PROJECT_FOLDER_ROOT +"\\" + SystemParams.SERVICE_I_DIR_NAME;
			File servicesIDir = new File(servicesIDirPath);
			if (!servicesIDir.exists())
			{
				System.out.println("creating directory: " + servicesIDirPath);
				servicesIDir.mkdir();
			}					
			
			// service
			String servicesDirPath = SystemParams.OUTPUT_ROOT_DIRECTORY + "\\" + SystemParams.PROJECT_FOLDER_ROOT +"\\" + SystemParams.SERVICE_DIR_NAME;
			File servicesDir = new File(servicesDirPath);
			if (!servicesDir.exists())
			{
				System.out.println("creating directory: " + servicesDirPath);
				servicesDir.mkdir();
			}			
			
			// dao Interface
			String daosIDirPath = SystemParams.OUTPUT_ROOT_DIRECTORY + "\\" + SystemParams.PROJECT_FOLDER_ROOT +"\\" + SystemParams.DAO_I_DIR_NAME;
			File daosIDir = new File(daosIDirPath);
			if (!daosIDir.exists())
			{
				System.out.println("creating directory: " + daosIDirPath);
				daosIDir.mkdir();
			}					
			
			
			// dao
			String daosDirPath = SystemParams.OUTPUT_ROOT_DIRECTORY + "\\" + SystemParams.PROJECT_FOLDER_ROOT +"\\" + SystemParams.DAO_DIR_NAME;
			File daosDir = new File(daosDirPath);
			if (!daosDir.exists())
			{
				System.out.println("creating directory: " + daosDirPath);
				daosDir.mkdir();
			}				
			
			// cmd
			String cmdsDirPath = SystemParams.OUTPUT_ROOT_DIRECTORY + "\\" + SystemParams.PROJECT_FOLDER_ROOT +"\\cmds";
			File cmdsDir = new File(cmdsDirPath);
			if (!cmdsDir.exists())
			{
				System.out.println("creating directory: " + cmdsDirPath);
				cmdsDir.mkdir();
			}				
			
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
	} // end maintainFileArchieve()
} // end class
